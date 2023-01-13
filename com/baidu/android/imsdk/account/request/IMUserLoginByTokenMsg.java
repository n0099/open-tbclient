package com.baidu.android.imsdk.account.request;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.text.TextUtils;
import com.alipay.sdk.data.a;
import com.baidu.android.imsdk.account.AccountManager;
import com.baidu.android.imsdk.account.AccountManagerImpl;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.internal.IMConfigInternal;
import com.baidu.android.imsdk.media.MediaSessionManager;
import com.baidu.android.imsdk.request.Message;
import com.baidu.android.imsdk.utils.LogUtils;
import com.baidu.android.imsdk.utils.Utility;
import com.baidu.ar.constants.HttpConstants;
import com.baidu.searchbox.common.security.DeviceInfoIPCServiceManager;
import com.baidu.tieba.setting.model.imageWatermarkType.SetImageWatermarkTypeReqMsg;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
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
        String str;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65538, null, context, intent)) == null) {
            String token = AccountManagerImpl.getInstance(context).getToken();
            boolean booleanExtra = intent.getBooleanExtra(Constants.EXTRA_INTERNAL_LOGIN, true);
            if (!intent.hasExtra(Constants.EXTRA_LOGIN_FROM)) {
                str = "";
            } else {
                str = intent.getStringExtra(Constants.EXTRA_LOGIN_FROM);
            }
            if (!intent.hasExtra(Constants.EXTRA_LOGIN_CFROM)) {
                str2 = "";
            } else {
                str2 = intent.getStringExtra(Constants.EXTRA_LOGIN_CFROM);
            }
            if (!TextUtils.isEmpty(token)) {
                return new IMUserLoginByTokenMsg(context, token, booleanExtra, str, str2);
            }
            return null;
        }
        return (IMUserLoginByTokenMsg) invokeLL.objValue;
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void buildBody() {
        int i;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(1048576, this) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("method", 50);
                jSONObject.put("appid", this.mAppid);
                jSONObject.put("device_id", this.mDeviceId);
                jSONObject.put("account_type", this.mAccountType);
                jSONObject.put("token", this.mToken);
                jSONObject.put("client_id", AccountManagerImpl.getInstance(this.mContext).getXDClientId());
                jSONObject.put("version", 4);
                jSONObject.put("sdk_version", IMConfigInternal.getInstance().getSDKVersionValue(this.mContext));
                jSONObject.put("app_version", AccountManagerImpl.getInstance(this.mContext).getAppVersion());
                jSONObject.put("app_open_type", AccountManagerImpl.getInstance(this.mContext).getAppOpenType());
                jSONObject.put("client_identifier", AccountManagerImpl.getInstance(this.mContext).getExtraSafeParams());
                jSONObject.put("tail", this.mTail);
                jSONObject.put(a.O, this.mTimeout);
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
                if (this.mAccountType == 11) {
                    jSONObject.put("client_id", AccountManagerImpl.getInstance(this.mContext).getXDClientId());
                }
                jSONObject.put(DeviceInfoIPCServiceManager.IPC_SERVICE_NAME, jSONObject2);
                JSONObject jSONObject3 = new JSONObject();
                jSONObject3.put("rpc_retry_time", sRetrytimes);
                jSONObject.put("rpc", jSONObject3.toString());
                if (AccountManager.getMediaRole(this.mContext)) {
                    i = 1;
                } else {
                    i = 0;
                }
                jSONObject.put("user_type", i);
                this.mBody = jSONObject.toString();
                String str = this.TAG;
                LogUtils.d(str, "buildBody :" + this.mBody);
            } catch (JSONException e) {
                LogUtils.e(this.TAG, " IMUserLoginByTokenMsg buildBody", e);
            }
        }
    }

    @Override // com.baidu.android.imsdk.request.Message
    public void handleMessageResult(Context context, JSONObject jSONObject, int i, String str) {
        boolean z;
        boolean z2;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, context, jSONObject, i, str) == null) {
            LogUtils.d(this.TAG, "handleLoginMsg errCode: " + i + " msg:" + str);
            if (i == 410) {
                return;
            }
            System.currentTimeMillis();
            if (i == 0) {
                try {
                    sRetrytimes = 0;
                    LogUtils.d(this.TAG, "Logined");
                    jSONObject.optString("logid", "-1");
                    AccountManagerImpl.getInstance(this.mContext).setLoginId(jSONObject.optLong(Constants.EXTRA_LOGIN_ID));
                    long optLong = jSONObject.optLong("uk", -1L);
                    long optLong2 = jSONObject.optJSONArray(Constants.KEY_TRIGGER_ID).optLong(0);
                    int optInt = jSONObject.optInt("authority", -1);
                    AccountManager.setUK(this.mContext, optLong);
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
                    JSONArray optJSONArray = jSONObject.optJSONArray("log_switch");
                    if (optJSONArray != null) {
                        for (int i2 = 0; i2 < optJSONArray.length(); i2++) {
                            JSONObject jSONObject2 = (JSONObject) optJSONArray.opt(i2);
                            if (jSONObject2 != null && jSONObject2.optInt("id", -1) == 501101) {
                                AccountManagerImpl accountManagerImpl = AccountManagerImpl.getInstance(this.mContext);
                                if (jSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0) == 1) {
                                    z2 = true;
                                } else {
                                    z2 = false;
                                }
                                accountManagerImpl.setScreenStatis(z2);
                            }
                            if (jSONObject2 != null && jSONObject2.optInt("id", -1) == 501102) {
                                AccountManagerImpl accountManagerImpl2 = AccountManagerImpl.getInstance(this.mContext);
                                if (jSONObject2.optInt(SetImageWatermarkTypeReqMsg.SWITCH, 0) == 1) {
                                    z = true;
                                } else {
                                    z = false;
                                }
                                accountManagerImpl2.setLogoutUpload(z);
                            }
                        }
                    }
                    AccountManagerImpl.getInstance(this.mContext).setBduid(jSONObject.optLong("bd_uid"));
                    MediaSessionManager.getInstance(this.mContext).setMediaPaid(jSONObject.optLong(Constants.EXTRA_PAUID_TYPE));
                } catch (Exception e) {
                    LogUtils.e(this.TAG, "handle login msg exception :", e);
                }
            } else if (110 == i || 7 == i || 23 == i) {
                Utility.logout(this.mContext, null, "login :" + i);
                sRetrytimes = 0;
            } else {
                sRetrytimes++;
            }
            AccountManagerImpl.getInstance(this.mContext).onLoginResult(getListenerKey(), i, str, this.mIsInternalLogin);
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
