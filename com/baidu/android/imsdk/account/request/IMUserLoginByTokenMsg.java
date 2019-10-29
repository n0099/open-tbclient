package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import android.util.Log;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.chatmessage.ChatMsgManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.internal.IMSDK;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.upload.action.IMTrack;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.sapi2.SapiContext;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes6.dex */
public class IMUserLoginByTokenMsg extends Message {
    public static int sRetrytimes = 0;
    private String cFrom;
    private int mAccountType;
    private Context mContext;
    private String mDeviceId;
    private String mFrom;
    private boolean mIsInternalLogin;
    private long mLoginRequestTime;
    private String mToken;
    private String TAG = "MessageHandler";
    private long mTail = 0;
    private long mTimeout = 10;

    public IMUserLoginByTokenMsg(Context context, String str, boolean z, String str2, String str3) {
        this.mToken = null;
        this.mAccountType = 1;
        this.mIsInternalLogin = true;
        this.mContext = context;
        initCommonParameter(context);
        this.mDeviceId = Utility.getIMDeviceId(this.mContext);
        this.mToken = str;
        this.mIsInternalLogin = z;
        setNeedReplay(true);
        setHeartbeat(false);
        setType(50);
        this.mAccountType = AccountManagerImpl.getInstance(context).getLoginType();
        this.mFrom = str2;
        this.cFrom = str3;
        this.mLoginRequestTime = System.currentTimeMillis();
    }

    public void setTail(long j) {
        this.mTail = j;
    }

    public static IMUserLoginByTokenMsg newInstance(Context context, Intent intent) {
        String token = AccountManagerImpl.getInstance(context).getToken();
        boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_INTERNAL_LOGIN, true);
        String str = "";
        if (intent.hasExtra(Constants.EXTRA_LOGIN_FROM)) {
            str = intent.getStringExtra(Constants.EXTRA_LOGIN_FROM);
        }
        String stringExtra = intent.hasExtra(Constants.EXTRA_LOGIN_CFROM) ? intent.getStringExtra(Constants.EXTRA_LOGIN_CFROM) : "";
        if (TextUtils.isEmpty(token)) {
            return null;
        }
        return new IMUserLoginByTokenMsg(context, token, booleanExtra, str, stringExtra);
    }

    public void setTimeout(long j) {
        this.mTimeout = j;
    }

    @Override // com.baidu.android.imsdk.request.Message
    protected void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 50);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put(Constants.KEY_DEVICE_ID, this.mDeviceId);
            jSONObject.put("account_type", this.mAccountType);
            jSONObject.put("token", this.mToken);
            jSONObject.put("version", 4);
            jSONObject.put(SapiContext.KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            jSONObject.put("client_identifier", AccountManagerImpl.getInstance(this.mContext).getExtraSafeParams());
            jSONObject.put("tail", this.mTail);
            jSONObject.put("timeout", this.mTimeout);
            if (!TextUtils.isEmpty(Utility.getLoginCookie(this.mContext))) {
                jSONObject.put("cookie", Utility.getLoginCookie(this.mContext));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            jSONObject2.put(BdStatsConstant.StatsKey.OS_VERSION, Build.VERSION.SDK_INT + "");
            jSONObject2.put("platform", "android");
            jSONObject2.put("appid", this.mAppid + "");
            jSONObject2.put("from", this.mFrom);
            jSONObject2.put(BdStatsConstant.StatsKey.CURRENT_CHANNEL, this.cFrom);
            jSONObject.put("device_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("rpc_retry_time", sRetrytimes);
            jSONObject.put("rpc", jSONObject3.toString());
            this.mBody = jSONObject.toString();
        } catch (JSONException e) {
            LogUtils.e(this.TAG, " IMUserLoginByTokenMsg buildBody", e);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) throws JSONException {
        LogUtils.d(this.TAG, "handleLoginMsg errCode: " + i + " msg:" + str);
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = LivenessStat.TYPE_STRING_DEFAULT;
        if (i == 0) {
            sRetrytimes = 0;
            LogUtils.d(this.TAG, "Logined");
            String optString = jSONObject.optString("logid", LivenessStat.TYPE_STRING_DEFAULT);
            long optLong = jSONObject.optLong("uk", -1L);
            long optLong2 = jSONObject.optJSONArray(Constants.KEY_TRIGGER_ID).optLong(0);
            int optInt = jSONObject.optInt("authority", -1);
            IMSDK.getInstance(this.mContext).setUk(optLong);
            Utility.writeTriggerId(this.mContext, optLong2);
            Utility.writeUK(this.mContext, optLong);
            Utility.setCuidAuthority(this.mContext, optInt);
            String optString2 = jSONObject.optString("cookie", "");
            if (!TextUtils.isEmpty(optString2)) {
                Utility.writeLoginCookie(this.mContext, optString2);
            }
            Utility.writeRestApiDisable(jSONObject.optInt("disable_restapi", 0));
            Utility.setBdDnsEnable(this.mContext, jSONObject.optInt("bddns_enable", 1));
            Utility.setConnType(this.mContext, jSONObject.optInt("conn_type", 0));
            Utility.setUploadIMTrack(this.mContext, jSONObject.optInt("client_upload_log_switch", 1));
            JSONArray optJSONArray = jSONObject.optJSONArray("log_switch");
            if (optJSONArray != null) {
                int i2 = 0;
                while (true) {
                    int i3 = i2;
                    if (i3 < optJSONArray.length()) {
                        JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                        if (jSONObject2 == null || jSONObject2.optInt("id", -1) != 501100) {
                            i2 = i3 + 1;
                        } else {
                            Utility.setUploadIMInitTrack(this.mContext, jSONObject2.optInt("switch", 0));
                            break;
                        }
                    } else {
                        break;
                    }
                }
            }
            ChatMsgManagerImpl.getInstance(this.mContext).fetchConfigMsg(this.mContext, 0L, 20L);
            str2 = optString;
        } else if (110 == i || 7 == i || 23 == i) {
            Utility.logout(this.mContext, null);
            sRetrytimes = 0;
        } else {
            sRetrytimes++;
        }
        AccountManagerImpl.getInstance(this.mContext).onLoginResult(getListenerKey(), i, str, this.mIsInternalLogin);
        new IMTrack.RequestBuilder(this.mContext).method("50").requestId(str2).requestTime(this.mLoginRequestTime).responseTime(currentTimeMillis).errorCode(i).aliasId(501101L).build();
    }
}
