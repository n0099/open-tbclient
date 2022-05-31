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
import com.baidu.ar.constants.HttpConstants;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.repackage.e60;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes.dex */
public class IMUserLoginByTokenMsg extends Message {
    public static /* synthetic */ Interceptable $ic;
    public static int sRetrytimes;
    public transient /* synthetic */ FieldHolder $fh;
    public String TAG;
    public String cFrom;
    public int mAccountType;
    public Context mContext;
    public String mDeviceId;
    public String mFrom;
    public boolean mIsInternalLogin;
    public long mLoginRequestTime;
    public long mTail;
    public long mTimeout;
    public String mToken;

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(1738371275, "Lcom/baidu/android/imsdk/account/request/IMUserLoginByTokenMsg;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(1738371275, "Lcom/baidu/android/imsdk/account/request/IMUserLoginByTokenMsg;");
        }
    }

    public IMUserLoginByTokenMsg(Context context, String str, boolean z, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            newInitContext.initArgs = r2;
            Object[] objArr = {context, str, Boolean.valueOf(z), str2, str3};
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.TAG = "IMUserLoginByTokenMsg";
        this.mToken = null;
        this.mAccountType = 1;
        this.mTail = 0L;
        this.mTimeout = 10L;
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
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
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
        return (IMUserLoginByTokenMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 50);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("device_id", this.mDeviceId);
                jSONObject.put("account_type", this.mAccountType);
                jSONObject.put("token", this.mToken);
                jSONObject.put("version", 4);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
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
                jSONObject2.put(HttpConstants.OS_VERSION, Build.VERSION.SDK_INT + "");
                jSONObject2.put(com.tencent.connect.common.Constants.PARAM_PLATFORM, "android");
                jSONObject2.put("appid", this.mAppid + "");
                jSONObject2.put("from", this.mFrom);
                jSONObject2.put("cfrom", this.cFrom);
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
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            LogUtils.d(this.TAG, "handleLoginMsg errCode: " + i + " msg:" + str);
            if (i == 410) {
                return;
            }
            long currentTimeMillis = System.currentTimeMillis();
            String str2 = "-1";
            if (i == 0) {
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
                        int i2 = 0;
                        while (true) {
                            if (i2 < optJSONArray.length()) {
                                JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                                if (jSONObject2 != null && jSONObject2.optInt("id", -1) == 501100) {
                                    Utility.setUploadIMInitTrack(this.mContext, jSONObject2.optInt("switch", 0));
                                    break;
                                }
                                i2++;
                            } else {
                                break;
                            }
                        }
                    }
                    if (!e60.e) {
                        ChatMsgManagerImpl.getInstance(this.mContext).fetchConfigMsg(this.mContext, 0L, 20L);
                    }
                } catch (Exception e) {
                    LogUtils.e(this.TAG, "handle login msg exception :", e);
                }
            } else if (110 != i && 7 != i && 23 != i) {
                sRetrytimes++;
            } else {
                Utility.logout(this.mContext, null);
                sRetrytimes = 0;
            }
            super.handleMessageResult(context, jSONObject, i, str);
            AccountManagerImpl.getInstance(this.mContext).onLoginResult(getListenerKey(), i, str, this.mIsInternalLogin);
            new IMTrack.RequestBuilder(this.mContext).method(String.valueOf(AccountManagerImpl.getInstance(context).getAppOpenType())).requestId(str2).requestTime(Utility.getLoginCallTime(this.mContext)).responseTime(currentTimeMillis).errorCode(i).aliasId(501101L).build();
        }
    }

    public void setTail(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(Constants.METHOD_SEND_USER_MSG, this, j) == null) {
            this.mTail = j;
        }
    }

    public void setTimeout(long j) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeJ(1048579, this, j) == null) {
            this.mTimeout = j;
        }
    }
}
