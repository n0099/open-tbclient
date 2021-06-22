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
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.webkit.internal.utils.ZeusInitConfigUtils;
import d.a.s.a;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMUserLoginByTokenMsg extends Message {
    public static int sRetrytimes;
    public String cFrom;
    public int mAccountType;
    public Context mContext;
    public String mDeviceId;
    public String mFrom;
    public boolean mIsInternalLogin;
    public long mLoginRequestTime;
    public String mToken;
    public String TAG = "IMUserLoginByTokenMsg";
    public long mTail = 0;
    public long mTimeout = 10;

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

    public static IMUserLoginByTokenMsg newInstance(Context context, Intent intent) {
        String token = AccountManagerImpl.getInstance(context).getToken();
        boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_INTERNAL_LOGIN, true);
        String stringExtra = intent.hasExtra(Constants.EXTRA_LOGIN_FROM) ? intent.getStringExtra(Constants.EXTRA_LOGIN_FROM) : "";
        String stringExtra2 = intent.hasExtra(Constants.EXTRA_LOGIN_CFROM) ? intent.getStringExtra(Constants.EXTRA_LOGIN_CFROM) : "";
        if (!TextUtils.isEmpty(token)) {
            Utility.writeLoginFlag(context, "7Y", "new IMUserLoginByTokenMsg");
            return new IMUserLoginByTokenMsg(context, token, booleanExtra, stringExtra, stringExtra2);
        }
        Utility.writeLoginFlag(context, "7N", "IMUserLoginByTokenMsg return null");
        return null;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("method", 50);
            jSONObject.put("appid", this.mAppid);
            jSONObject.put(Constants.KEY_DEVICE_ID, this.mDeviceId);
            jSONObject.put("account_type", this.mAccountType);
            jSONObject.put("token", this.mToken);
            jSONObject.put("version", 4);
            jSONObject.put(ZeusInitConfigUtils.PREF_KEY_SDK_VERSION, IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
            jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            jSONObject.put("app_open_type", AccountManagerImpl.getInstance(this.mContext).getAppOpenType());
            jSONObject.put("client_identifier", AccountManagerImpl.getInstance(this.mContext).getExtraSafeParams());
            jSONObject.put("tail", this.mTail);
            jSONObject.put("timeout", this.mTimeout);
            if (!TextUtils.isEmpty(Utility.getLoginCookie(this.mContext))) {
                jSONObject.put("cookie", Utility.getLoginCookie(this.mContext));
            }
            JSONObject jSONObject2 = new JSONObject();
            jSONObject2.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
            jSONObject2.put("os_version", Build.VERSION.SDK_INT + "");
            jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
            jSONObject2.put("appid", this.mAppid + "");
            jSONObject2.put("from", this.mFrom);
            jSONObject2.put("cfrom", this.cFrom);
            jSONObject.put("device_info", jSONObject2);
            JSONObject jSONObject3 = new JSONObject();
            jSONObject3.put("rpc_retry_time", sRetrytimes);
            jSONObject.put("rpc", jSONObject3.toString());
            this.mBody = jSONObject.toString();
        } catch (JSONException e2) {
            LogUtils.e(this.TAG, " IMUserLoginByTokenMsg buildBody", e2);
            new IMTrack.CrashBuilder(this.mContext).exception(Log.getStackTraceString(e2)).build();
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i2, String str) {
        LogUtils.d(this.TAG, "handleLoginMsg errCode: " + i2 + " msg:" + str);
        if (i2 == 410) {
            return;
        }
        long currentTimeMillis = System.currentTimeMillis();
        String str2 = "-1";
        if (i2 == 0) {
            try {
                Utility.writeLoginFlag(this.mContext, "17Y", "Read LoginMsg response");
                sRetrytimes = 0;
                LogUtils.d(this.TAG, "Logined");
                str2 = jSONObject.optString("logid", "-1");
                long optLong = jSONObject.optLong("uk", -1L);
                long optLong2 = jSONObject.optJSONArray(Constants.KEY_TRIGGER_ID).optLong(0);
                int optInt = jSONObject.optInt("authority", -1);
                IMSDK.getInstance(this.mContext).setUk(optLong);
                Utility.writeTriggerId(this.mContext, optLong2);
                Utility.writeUK(this.mContext, optLong);
                Utility.setCuidAuthority(this.mContext, optInt);
                String optString = jSONObject.optString("cookie", "");
                if (!TextUtils.isEmpty(optString)) {
                    Utility.writeLoginCookie(this.mContext, optString);
                }
                Utility.writeLoginRole(this.mContext, jSONObject.optInt("role", 0));
                Utility.writeRestApiDisable(jSONObject.optInt("disable_restapi", 0));
                Utility.setBdDnsEnable(this.mContext, jSONObject.optInt("bddns_enable", 1));
                Utility.setConnType(this.mContext, jSONObject.optInt("conn_type", 0));
                Utility.setUploadIMTrack(this.mContext, jSONObject.optInt("client_upload_log_switch", 1));
                JSONArray optJSONArray = jSONObject.optJSONArray("log_switch");
                if (optJSONArray != null) {
                    int i3 = 0;
                    while (true) {
                        if (i3 < optJSONArray.length()) {
                            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i3);
                            if (jSONObject2 != null && jSONObject2.optInt("id", -1) == 501100) {
                                Utility.setUploadIMInitTrack(this.mContext, jSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0));
                                break;
                            }
                            i3++;
                        } else {
                            break;
                        }
                    }
                }
                if (!a.f68195e) {
                    ChatMsgManagerImpl.getInstance(this.mContext).fetchConfigMsg(this.mContext, 0L, 20L);
                }
            } catch (Exception e2) {
                LogUtils.e(this.TAG, "handle login msg exception :", e2);
            }
        } else if (110 != i2 && 7 != i2 && 23 != i2) {
            sRetrytimes++;
        } else {
            Utility.logout(this.mContext, null);
            sRetrytimes = 0;
        }
        super.handleMessageResult(context, jSONObject, i2, str);
        AccountManagerImpl.getInstance(this.mContext).onLoginResult(getListenerKey(), i2, str, this.mIsInternalLogin);
        new IMTrack.RequestBuilder(this.mContext).method(String.valueOf(AccountManagerImpl.getInstance(context).getAppOpenType())).requestId(str2).requestTime(Utility.getLoginCallTime(this.mContext)).responseTime(currentTimeMillis).errorCode(i2).aliasId(501101L).build();
    }

    public void setTail(long j) {
        this.mTail = j;
    }

    public void setTimeout(long j) {
        this.mTimeout = j;
    }
}
