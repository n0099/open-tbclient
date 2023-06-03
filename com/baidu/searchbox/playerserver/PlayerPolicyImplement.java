package com.baidu.searchbox.playerserver;

import android.os.Build;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.os.SystemClock;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.common.param.CommonUrlParamManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pyramid.runtime.service.ServiceManager;
import com.baidu.searchbox.playerserver.ab.PlayConfigABManager;
import com.baidu.searchbox.pms.constants.PmsConstant;
import com.baidu.ubc.UBCManager;
import com.baidu.webkit.internal.ETAG;
import com.huawei.hms.framework.common.hianalytics.CrashHianalyticsData;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;
import org.json.JSONObject;
/* loaded from: classes4.dex */
public class PlayerPolicyImplement implements IPlayerPolicy {
    public static final int ADD_OBSERVER_WORK_MSG = 2;
    public static final int JELLY_BEAN_MR2 = 18;
    public static final int MAX_RETRY_COUNT = 1;
    public static final int MIN_UPDATE_INTERVAL = 10;
    public static final String PLAYER_SERVER = "https://mbd.baidu.com/playserver/ctlconf?";
    public static final int REMOVE_OBSERVER_WORK_MSG = 3;
    public static final String TAG = "PlayerServer-PlcyImplmnt";
    public static final int TIMER_UPDATE_WORK_MSG = 1;
    public HandlerThread mHandlerThread;
    public Handler mWorkHandler;
    public Handler mMainHandler = new Handler(Looper.getMainLooper());
    public CopyOnWriteArrayList<IPlayerConfig> mList = new CopyOnWriteArrayList<>();
    public long mUpdateInterval = 180;
    public volatile int mSendRequestManually = 0;
    public volatile int mRequested = 0;
    public volatile int mPullCfgSuccessfully = 0;
    public volatile long mRetryCount = 0;
    public volatile long lastReqSendTimestamp = 0;
    public volatile long mFirstReqSendTimestamp = 0;
    public volatile long mLastReqSendTime = 0;
    public OkHttpClient mOkHttpClient = null;

    /* loaded from: classes4.dex */
    public static class PPSessionModel {
        public static final int ERR_APPEND_COMMON_PARAMS_TO_URL_FAILED = -101;
        public static final int ERR_ASSEMBLE_URL_FAILED = -102;
        public static final int ERR_CODE_REQUEST_FAILED = -201;
        public static final int ERR_ERRNO_NOT_EQUAL_TO_ZERO = -103;
        public static final int ERR_PARSE_RESPONSE_JSON_OBJECT_FAILED = -104;
        public static final int ERR_RESPONSE_JSON_OBJECT_IS_EMPTY = -105;
        public static final int ERR_RESPONSE_OR_RESPONSE_BODY_IS_EMPTY = -106;
        public static final int ERR_RESPONSE_PARSE_FAILED = -107;
        public static final String ERR_STR_APPEND_COMMON_PARAMS_TO_URL_FAILED = "Append common params to url failed";
        public static final String ERR_STR_ASSEMBLE_URL_FAILED = "Assemble url failed";
        public static final String ERR_STR_ERRNO_NOT_EQUAL_TO_ZERO = "Errno in config dict is not zero";
        public static final String ERR_STR_PARSE_RESPONSE_JSON_OBJECT_FAILED = "Parse response json object failed";
        public static final String ERR_STR_REQUEST_FAILED = "OKHttp request failed";
        public static final String ERR_STR_RESPONSE_JSON_OBJECT_IS_EMPTY = "Response json object is empty";
        public static final String ERR_STR_RESPONSE_OR_RESPONSE_BODY_IS_EMPTY = "Response or Response body is empty";
        public static final String ERR_STR_RESPONSE_PARSE_FAILED = "Response parse failed";
        public static final String UBC_ID = "5054";
        public static HashMap<Integer, String> errCodeMsgMap;
        public Integer mErrCode = 0;
        public long mUpdateInterval = 180;
        public long mActuralInterval = 0;
        public long mPID = 0;
        public long mProcessID = 0;
        public long mReqStartTime = 0;
        public long mDelaySecond = 180;
        public long mHttpRespStatusCode = 0;
        public String mUrl = "";
        public String mErrMsg = "";
        public String mDetailErrMsg = "";
        public String mRespConfigStr = "";

        static {
            HashMap<Integer, String> hashMap = new HashMap<>();
            errCodeMsgMap = hashMap;
            hashMap.put(-101, ERR_STR_APPEND_COMMON_PARAMS_TO_URL_FAILED);
            errCodeMsgMap.put(-102, ERR_STR_ASSEMBLE_URL_FAILED);
            errCodeMsgMap.put(-103, ERR_STR_ERRNO_NOT_EQUAL_TO_ZERO);
            errCodeMsgMap.put(-104, ERR_STR_PARSE_RESPONSE_JSON_OBJECT_FAILED);
            errCodeMsgMap.put(-105, ERR_STR_RESPONSE_JSON_OBJECT_IS_EMPTY);
            errCodeMsgMap.put(-106, ERR_STR_RESPONSE_OR_RESPONSE_BODY_IS_EMPTY);
            errCodeMsgMap.put(-107, ERR_STR_RESPONSE_PARSE_FAILED);
            errCodeMsgMap.put(-201, ERR_STR_REQUEST_FAILED);
        }

        public static String errStrFromCode(Integer num) {
            return errCodeMsgMap.get(num);
        }
    }

    public PlayerPolicyImplement() {
        this.mWorkHandler = null;
        this.mHandlerThread = null;
        HandlerThread handlerThread = new HandlerThread("player_policy_implement");
        this.mHandlerThread = handlerThread;
        if (handlerThread != null) {
            handlerThread.start();
            this.mWorkHandler = new Handler(this.mHandlerThread.getLooper()) { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.1
                @Override // android.os.Handler
                public void handleMessage(Message message) {
                    long j;
                    int i = message.what;
                    if (i != 1) {
                        if (i != 2) {
                            if (i == 3) {
                                Object obj = message.obj;
                                if (obj instanceof IPlayerConfig) {
                                    PlayerPolicyImplement.this.onUnregister((IPlayerConfig) obj);
                                    return;
                                }
                                return;
                            }
                            return;
                        }
                        Object obj2 = message.obj;
                        if (obj2 instanceof IPlayerConfig) {
                            PlayerPolicyImplement.this.onRegister((IPlayerConfig) obj2);
                            return;
                        }
                        return;
                    }
                    if (PlayerPolicyImplement.access$004(PlayerPolicyImplement.this) > 1) {
                        PlayerPolicyImplement.this.mPullCfgSuccessfully = 1;
                    }
                    if (PlayerPolicyImplement.this.mPullCfgSuccessfully != 1) {
                        j = 10;
                    } else {
                        j = PlayerPolicyImplement.this.mUpdateInterval;
                    }
                    sendEmptyMessageDelayed(1, 1000 * j);
                    PlayerPolicyImplement.this.onUpdateConfig(j);
                }
            };
        }
    }

    private void onUpload(String str, String str2) {
        try {
            ((UBCManager) ServiceManager.getService(UBCManager.SERVICE_REFERENCE)).onEvent(str, str2);
        } catch (Error e) {
            Log.e(TAG, "onUploadPPSession failed:  ", e);
        } catch (Exception e2) {
            Log.e(TAG, "onUploadPPSession failed:  ", e2);
        }
    }

    public static /* synthetic */ long access$004(PlayerPolicyImplement playerPolicyImplement) {
        long j = playerPolicyImplement.mRetryCount + 1;
        playerPolicyImplement.mRetryCount = j;
        return j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onRegister(IPlayerConfig iPlayerConfig) {
        CopyOnWriteArrayList<IPlayerConfig> copyOnWriteArrayList = this.mList;
        if (copyOnWriteArrayList != null && iPlayerConfig != null) {
            copyOnWriteArrayList.add(iPlayerConfig);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void onUnregister(IPlayerConfig iPlayerConfig) {
        CopyOnWriteArrayList<IPlayerConfig> copyOnWriteArrayList = this.mList;
        if (copyOnWriteArrayList != null && iPlayerConfig != null) {
            copyOnWriteArrayList.remove(iPlayerConfig);
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void notify(final String str) {
        Handler handler = this.mMainHandler;
        if (handler != null) {
            handler.post(new Runnable() { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.3
                @Override // java.lang.Runnable
                public void run() {
                    try {
                        Iterator it = PlayerPolicyImplement.this.mList.iterator();
                        while (it.hasNext()) {
                            IPlayerConfig iPlayerConfig = (IPlayerConfig) it.next();
                            if (iPlayerConfig != null) {
                                iPlayerConfig.update(str);
                            }
                        }
                    } catch (Exception e) {
                        Log.e(PlayerPolicyImplement.TAG, "config.update failed:  ", e);
                    }
                }
            });
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void register(IPlayerConfig iPlayerConfig) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            Message.obtain(handler, 2, 0, 0, iPlayerConfig).sendToTarget();
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void unregister(IPlayerConfig iPlayerConfig) {
        Handler handler = this.mWorkHandler;
        if (handler != null) {
            Message.obtain(handler, 3, 0, 0, iPlayerConfig).sendToTarget();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void assemblePPSession(PPSessionModel pPSessionModel) {
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("url", pPSessionModel.mUrl);
            jSONObject.put(DpStatConstants.KEY_P_ID, pPSessionModel.mPID);
            jSONObject.put(CrashHianalyticsData.PROCESS_ID, pPSessionModel.mProcessID);
            jSONObject.put(ETAG.KEY_HTTP_CODE, pPSessionModel.mHttpRespStatusCode);
            jSONObject.put(HiAnalyticsConstant.BI_KEY_COST_TIME, SystemClock.uptimeMillis() - pPSessionModel.mReqStartTime);
            jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRCODE, pPSessionModel.mErrCode);
            jSONObject.put(PmsConstant.Statistic.STATISTIC_ERRMSG, pPSessionModel.mErrMsg);
            jSONObject.put("detail_err_msg", pPSessionModel.mDetailErrMsg);
            jSONObject.put("update_interval", pPSessionModel.mUpdateInterval);
            jSONObject.put("actual_interval", pPSessionModel.mActuralInterval);
            jSONObject.put("config", pPSessionModel.mRespConfigStr);
            jSONObject.put("delay_second", pPSessionModel.mDelaySecond);
            jSONObject.put("req_source", PlayerPolicyManager.sRequestSource);
            onUpload(PPSessionModel.UBC_ID, jSONObject.toString());
        } catch (Exception e) {
            Log.e(TAG, "assemblePPSession failed:  ", e);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public synchronized void onUpdateConfig(long j) {
        long uptimeMillis = SystemClock.uptimeMillis() / 1000;
        long j2 = uptimeMillis - this.lastReqSendTimestamp;
        if (j2 < 10) {
            return;
        }
        if (this.lastReqSendTimestamp == 0) {
            j2 = -1;
        }
        this.lastReqSendTimestamp = uptimeMillis;
        final PPSessionModel pPSessionModel = new PPSessionModel();
        pPSessionModel.mPID = System.currentTimeMillis();
        pPSessionModel.mProcessID = Process.myPid();
        pPSessionModel.mReqStartTime = SystemClock.uptimeMillis();
        pPSessionModel.mErrCode = 0;
        pPSessionModel.mErrMsg = "";
        pPSessionModel.mUrl = "";
        pPSessionModel.mDelaySecond = j;
        pPSessionModel.mActuralInterval = j2;
        try {
            String appendParam = CommonUrlParamManager.getInstance().appendParam(PLAYER_SERVER, 1);
            if (appendParam == null) {
                pPSessionModel.mErrCode = -102;
                pPSessionModel.mErrMsg = PPSessionModel.errStrFromCode(-102);
                assemblePPSession(pPSessionModel);
                return;
            }
            pPSessionModel.mUrl = appendParam;
            Request.Builder url = new Request.Builder().url(appendParam);
            if (!TextUtils.isEmpty(PlayerPolicyCfgManager.getInstance().getHashTag())) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("hash_tag", PlayerPolicyCfgManager.getInstance().getHashTag());
                    url.post(RequestBody.create(MediaType.parse("application/json"), jSONObject.toString()));
                } catch (Exception unused) {
                }
            }
            Request build = url.build();
            if (this.mOkHttpClient == null) {
                this.mOkHttpClient = new OkHttpClient();
            }
            this.mOkHttpClient.newCall(build).enqueue(new Callback() { // from class: com.baidu.searchbox.playerserver.PlayerPolicyImplement.2
                @Override // okhttp3.Callback
                public void onFailure(Call call, IOException iOException) {
                    Log.d(PlayerPolicyImplement.TAG, "onFailure: ");
                    pPSessionModel.mErrCode = -201;
                    PPSessionModel pPSessionModel2 = pPSessionModel;
                    pPSessionModel2.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel2.mErrCode);
                    pPSessionModel.mDetailErrMsg = iOException.toString();
                    PlayerPolicyImplement.this.assemblePPSession(pPSessionModel);
                }

                @Override // okhttp3.Callback
                public void onResponse(Call call, Response response) {
                    PlayerPolicyImplement.this.mPullCfgSuccessfully = 0;
                    if (response != null) {
                        try {
                        } catch (IOException e) {
                            pPSessionModel.mErrCode = -107;
                            PPSessionModel pPSessionModel2 = pPSessionModel;
                            pPSessionModel2.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel2.mErrCode);
                            pPSessionModel.mDetailErrMsg = e.toString();
                        }
                        if (response.body() != null) {
                            String string = response.body().string();
                            if (string != null && !string.isEmpty()) {
                                if (PlayConfigABManager.getIntSwitch(PlayConfigABManager.KEY_PLAY_CONFIG_SAVE_SDCARD, 1) == 1) {
                                    PlayerPolicyCfgManager.getInstance().mergePlayConfigAndSave(string);
                                    string = PlayerPolicyCfgManager.getInstance().getPlayConfigMerged();
                                    if (TextUtils.isEmpty(string)) {
                                        return;
                                    }
                                }
                                PlayerPolicyImplement.this.notify(string);
                                try {
                                    JSONObject jSONObject2 = new JSONObject(string);
                                    int i = jSONObject2.getInt("errno");
                                    if (i == 0) {
                                        JSONObject jSONObject3 = jSONObject2.getJSONObject("bandwidth_config");
                                        PlayerPolicyImplement.this.mUpdateInterval = Math.max(10, jSONObject3.getInt("update_interval"));
                                        PlayerPolicyImplement.this.mPullCfgSuccessfully = 1;
                                        PlayerPolicyImplement.this.mRetryCount = 0L;
                                        pPSessionModel.mErrCode = 0;
                                        pPSessionModel.mUpdateInterval = PlayerPolicyImplement.this.mUpdateInterval;
                                    } else {
                                        pPSessionModel.mErrCode = -103;
                                        PPSessionModel pPSessionModel3 = pPSessionModel;
                                        pPSessionModel3.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel.mErrCode) + " errno: " + i;
                                        pPSessionModel.mRespConfigStr = string;
                                    }
                                } catch (Exception e2) {
                                    pPSessionModel.mErrCode = -104;
                                    pPSessionModel.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel.mErrCode);
                                    pPSessionModel.mRespConfigStr = string;
                                    pPSessionModel.mDetailErrMsg = e2.toString();
                                }
                            } else {
                                pPSessionModel.mErrCode = -105;
                                pPSessionModel.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel.mErrCode);
                            }
                            pPSessionModel.mHttpRespStatusCode = response.code();
                            PlayerPolicyImplement.this.assemblePPSession(pPSessionModel);
                        }
                    }
                    pPSessionModel.mErrCode = -106;
                    pPSessionModel.mErrMsg = PPSessionModel.errStrFromCode(pPSessionModel.mErrCode);
                    pPSessionModel.mHttpRespStatusCode = response.code();
                    PlayerPolicyImplement.this.assemblePPSession(pPSessionModel);
                }
            });
        } catch (Exception e) {
            Log.e(TAG, "onUpdateConfig:  ", e);
            pPSessionModel.mErrCode = -101;
            pPSessionModel.mErrMsg = PPSessionModel.errStrFromCode(-101);
            assemblePPSession(pPSessionModel);
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void sendRequestManually(int i) {
        long j;
        boolean z = true;
        this.mSendRequestManually = 1;
        long uptimeMillis = SystemClock.uptimeMillis() / 1000;
        if (this.mFirstReqSendTimestamp == 0) {
            this.mFirstReqSendTimestamp = uptimeMillis;
            this.mLastReqSendTime = uptimeMillis;
            onUpdateConfig(0L);
            return;
        }
        if (uptimeMillis - this.mFirstReqSendTimestamp > this.mUpdateInterval) {
            z = false;
        }
        Boolean valueOf = Boolean.valueOf(z);
        long j2 = uptimeMillis - this.mLastReqSendTime;
        if (valueOf.booleanValue()) {
            j = i;
        } else {
            j = this.mUpdateInterval;
        }
        if (j2 >= j) {
            this.mLastReqSendTime = uptimeMillis;
            onUpdateConfig(0L);
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void start() {
        if (this.mRequested == 0) {
            this.mRequested = 1;
            this.mWorkHandler.sendEmptyMessage(1);
        }
    }

    @Override // com.baidu.searchbox.playerserver.IPlayerPolicy
    public void stop() {
        HandlerThread handlerThread = this.mHandlerThread;
        if (handlerThread != null) {
            if (Build.VERSION.SDK_INT >= 18) {
                try {
                    handlerThread.getLooper().quitSafely();
                    return;
                } catch (NoSuchMethodError unused) {
                    this.mHandlerThread.getLooper().quit();
                    return;
                }
            }
            handlerThread.getLooper().quit();
        }
    }
}
