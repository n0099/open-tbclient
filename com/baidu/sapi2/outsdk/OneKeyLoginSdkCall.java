package com.baidu.sapi2.outsdk;

import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import b.a.n0.a;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.inner.OneKeyLoginOptCallback;
import com.baidu.sapi2.result.OneKeyLoginOptResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes7.dex */
public class OneKeyLoginSdkCall {
    public static /* synthetic */ Interceptable $ic = null;
    public static final int CONNECT_TIMEOUT = 15000;
    public static final String OKL_SCENE_INIT = "init";
    public static final String OKL_SCENE_LOGIN = "login";
    public static final String OKL_SCENE_PRODUCT = "product";
    public static final String OKL_SCENE_SAPI = "sapi";
    public static final int ONE_KEY_AVAILABLE = 1;
    public static final String OPERATOR_CHINA_MOBILE = "CMCC";
    public static final String OPERATOR_CHINA_TELECOM = "CTCC";
    public static final String OPERATOR_CHINA_UNICOM = "CUCC";
    public static final String OPERATOR_TYPE_CMCC = "CM";
    public static final String OPERATOR_TYPE_CTCC = "CT";
    public static final String OPERATOR_TYPE_CUCC = "CU";
    public static final String TAG = "OneKeyLogin";
    public static OneKeyLoginSdkCall instance = null;
    public static final String oneKeyLoginAppKey = "350675";
    public static final String oneKeyLoginAppSecret = "ba8df9d21db832db598b22fc7cbfbcd6";
    public static OneKeyLoginOptResult preLoginOptResult;
    public static String signFromAbilityApi;
    public transient /* synthetic */ FieldHolder $fh;

    /* loaded from: classes7.dex */
    public interface TokenListener extends NoProguard {
        void onGetTokenComplete(JSONObject jSONObject);
    }

    public OneKeyLoginSdkCall() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i2 = newInitContext.flag;
            if ((i2 & 1) != 0) {
                int i3 = i2 & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static OneKeyLoginSdkCall getInstance() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65538, null)) == null) {
            if (instance == null) {
                instance = new OneKeyLoginSdkCall();
            }
            return instance;
        }
        return (OneKeyLoginSdkCall) invokeV.objValue;
    }

    public boolean checkSupOauth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048576, this)) == null) ? preLoginOptResult != null : invokeV.booleanValue;
    }

    public JSONObject getEncryptPhone() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this)) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                if (preLoginOptResult != null) {
                    jSONObject.put("phone", preLoginOptResult.getSecurityPhone());
                    jSONObject.put("operator", getOperatorType());
                    jSONObject.put("CUVersion", "2");
                }
            } catch (JSONException e2) {
                Log.e(TAG, e2);
            }
            Log.d(TAG, "getEncryptPhone result:" + jSONObject.toString());
            return jSONObject;
        }
        return (JSONObject) invokeV.objValue;
    }

    public void getMobileOauthToken(SapiConfiguration sapiConfiguration, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, sapiConfiguration, tokenListener) == null) {
            try {
                a.c().i(sapiConfiguration.context, 15000L, new a.InterfaceC0097a(this, tokenListener) { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.3
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OneKeyLoginSdkCall this$0;
                    public final /* synthetic */ TokenListener val$listener;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, tokenListener};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$listener = tokenListener;
                    }

                    @Override // b.a.n0.a.InterfaceC0097a
                    public void onFinish(String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                            Log.d(OneKeyLoginSdkCall.TAG, "getMobileOauthToken onFinish result=" + str);
                            OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str);
                            String extraStr = formatOptResult.getExtraStr();
                            SapiStatUtil.statOneKeyOauthToken(formatOptResult.getCode(), formatOptResult.getSubCode(), 1 ^ (TextUtils.isEmpty(extraStr) ? 1 : 0));
                            JSONObject jSONObject = new JSONObject();
                            if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                                try {
                                    jSONObject.put("errno", 0);
                                    jSONObject.put("operator", this.this$0.getOperatorType());
                                    jSONObject.put("appid", OneKeyLoginSdkCall.oneKeyLoginAppKey);
                                    jSONObject.put("token", extraStr);
                                    jSONObject.put("oneKeySdkVersion", "v2");
                                } catch (Exception e2) {
                                    Log.e(OneKeyLoginSdkCall.TAG, e2);
                                }
                            } else {
                                try {
                                    jSONObject.put("errno", 0);
                                    jSONObject.put("operator", this.this$0.getOperatorType());
                                } catch (JSONException e3) {
                                    Log.e(OneKeyLoginSdkCall.TAG, e3);
                                }
                            }
                            if (this.val$listener != null) {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, jSONObject) { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.3.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass3 this$1;
                                    public final /* synthetic */ JSONObject val$json;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, jSONObject};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i2 = newInitContext.flag;
                                            if ((i2 & 1) != 0) {
                                                int i3 = i2 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$json = jSONObject;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.this$1.val$listener.onGetTokenComplete(this.val$json);
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
            } catch (Exception e2) {
                Log.e(TAG, e2.getMessage());
                tokenListener.onGetTokenComplete(new JSONObject());
            }
        }
    }

    public String getOperatorType() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048579, this)) == null) {
            OneKeyLoginOptResult oneKeyLoginOptResult = preLoginOptResult;
            if (oneKeyLoginOptResult != null) {
                if ("1".equals(oneKeyLoginOptResult.getOperateType())) {
                    return OPERATOR_TYPE_CMCC;
                }
                if ("2".equals(preLoginOptResult.getOperateType())) {
                    return OPERATOR_TYPE_CUCC;
                }
                if ("3".equals(preLoginOptResult.getOperateType())) {
                    return OPERATOR_TYPE_CTCC;
                }
                return null;
            }
            return null;
        }
        return (String) invokeV.objValue;
    }

    public OneKeyLoginOptResult getPreLoginOptResult() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(1048580, this)) == null) ? preLoginOptResult : (OneKeyLoginOptResult) invokeV.objValue;
    }

    public void getToken(SapiConfiguration sapiConfiguration, TokenListener tokenListener) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048581, this, sapiConfiguration, tokenListener) == null) {
            a.c().f(sapiConfiguration.context, 15000L, new a.InterfaceC0097a(this, sapiConfiguration, tokenListener) { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ OneKeyLoginSdkCall this$0;
                public final /* synthetic */ SapiConfiguration val$configuration;
                public final /* synthetic */ TokenListener val$listener;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, sapiConfiguration, tokenListener};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$configuration = sapiConfiguration;
                    this.val$listener = tokenListener;
                }

                @Override // b.a.n0.a.InterfaceC0097a
                public void onFinish(String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str) == null) {
                        Log.d(OneKeyLoginSdkCall.TAG, "SSOManager login onFinish result=" + str);
                        OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str);
                        String extraStr = formatOptResult.getExtraStr();
                        SapiStatUtil.statOneKeyLoginSDKAction(formatOptResult.getCode(), formatOptResult.getSubCode(), !TextUtils.isEmpty(extraStr) ? 1 : 0);
                        JSONObject jSONObject = new JSONObject();
                        try {
                            if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                                jSONObject.put("errno", 0);
                                jSONObject.put("code", 0);
                                jSONObject.put("appid", this.val$configuration.context.getPackageName());
                                jSONObject.put("token", extraStr);
                                jSONObject.put("oneKeySdkVersion", "v2");
                            }
                        } catch (JSONException e2) {
                            Log.e(OneKeyLoginSdkCall.TAG, e2.getMessage());
                        }
                        if (this.val$listener != null) {
                            new Handler(Looper.getMainLooper()).post(new Runnable(this, jSONObject) { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.2.1
                                public static /* synthetic */ Interceptable $ic;
                                public transient /* synthetic */ FieldHolder $fh;
                                public final /* synthetic */ AnonymousClass2 this$1;
                                public final /* synthetic */ JSONObject val$jsonObj;

                                {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 != null) {
                                        InitContext newInitContext = TitanRuntime.newInitContext();
                                        newInitContext.initArgs = r2;
                                        Object[] objArr = {this, jSONObject};
                                        interceptable3.invokeUnInit(65536, newInitContext);
                                        int i2 = newInitContext.flag;
                                        if ((i2 & 1) != 0) {
                                            int i3 = i2 & 2;
                                            newInitContext.thisArg = this;
                                            interceptable3.invokeInitBody(65536, newInitContext);
                                            return;
                                        }
                                    }
                                    this.this$1 = this;
                                    this.val$jsonObj = jSONObject;
                                }

                                @Override // java.lang.Runnable
                                public void run() {
                                    Interceptable interceptable3 = $ic;
                                    if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                        this.this$1.val$listener.onGetTokenComplete(this.val$jsonObj);
                                    }
                                }
                            });
                        }
                    }
                }
            });
        }
    }

    public void initOneKeyLoginSdk(SapiConfiguration sapiConfiguration) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(1048582, this, sapiConfiguration) == null) {
            a.c().d(sapiConfiguration.context, oneKeyLoginAppKey, oneKeyLoginAppSecret);
            a.c().h(sapiConfiguration.context, sapiConfiguration.isAgreeDangerousProtocol());
        }
    }

    public boolean isMeetOneKeyLoginGray(String str) {
        InterceptResult invokeL;
        String str2;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048583, this, str)) == null) {
            if (TextUtils.equals(str, OPERATOR_CHINA_MOBILE)) {
                str2 = SapiOptions.Gray.FUN_NAME_CHINA_MOBILE_OAUTH;
            } else if (TextUtils.equals(str, OPERATOR_CHINA_UNICOM)) {
                str2 = SapiOptions.Gray.FUN_NAME_CHINA_UNICOM_OAUTH;
            } else {
                str2 = TextUtils.equals(str, OPERATOR_CHINA_TELECOM) ? SapiOptions.Gray.FUN_NAME_CHINA_TELECOM_OAUTH : null;
            }
            Log.d(TAG, "isMeetOneKeyLoginGray ? operator=" + str);
            if (TextUtils.isEmpty(str2)) {
                return false;
            }
            return SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(str2).isMeetGray();
        }
        return invokeL.booleanValue;
    }

    public void loadOneKeyLoginFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(InputDeviceCompat.SOURCE_TOUCHPAD, this, oneKeyLoginCallback, i2, str) == null) || oneKeyLoginCallback == null) {
            return;
        }
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(i2);
        oneKeyLoginResult.setResultMsg(str);
        oneKeyLoginCallback.onFail(oneKeyLoginResult);
    }

    public void preGetPhoneFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, int i3, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeCommon(1048585, this, new Object[]{oneKeyLoginCallback, Integer.valueOf(i2), Integer.valueOf(i3), str}) == null) || oneKeyLoginCallback == null) {
            return;
        }
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(i2);
        oneKeyLoginResult.setResultMsg("subCode=" + i3 + ", msg=" + str);
        oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
    }

    public void preGetPhoneInfo(SapiConfiguration sapiConfiguration, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048587, this, sapiConfiguration, str) == null) {
            preGetPhoneInfo(sapiConfiguration, str, 15000, null);
        }
    }

    public void transMobile(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048589, this, oneKeyLoginCallback, i2, str) == null) || oneKeyLoginCallback == null) {
            return;
        }
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(i2);
        oneKeyLoginResult.mobile = str;
        oneKeyLoginCallback.onFail(oneKeyLoginResult);
    }

    public void preGetPhoneInfo(SapiConfiguration sapiConfiguration, String str, int i2, OneKeyLoginOptCallback oneKeyLoginOptCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLIL(1048588, this, sapiConfiguration, str, i2, oneKeyLoginOptCallback) == null) {
            if (SapiAccountManager.getInstance().isLogin()) {
                Log.d(TAG, "preGetPhoneInfo account is logined");
                if (oneKeyLoginOptCallback != null) {
                    OneKeyLoginOptResult oneKeyLoginOptResult = new OneKeyLoginOptResult();
                    oneKeyLoginOptResult.setCode(-110);
                    oneKeyLoginOptResult.setSubCode(-110);
                    oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult);
                    return;
                }
                return;
            }
            String b2 = a.c().b(sapiConfiguration.context);
            if (TextUtils.equals(b2, OPERATOR_CHINA_MOBILE) || TextUtils.equals(b2, OPERATOR_CHINA_UNICOM) || TextUtils.equals(b2, OPERATOR_CHINA_TELECOM)) {
                if (!isMeetOneKeyLoginGray(b2)) {
                    Log.d(TAG, "未命中灰度，不请求预取号操作 operator=" + b2);
                    if (oneKeyLoginOptCallback != null) {
                        OneKeyLoginOptResult oneKeyLoginOptResult2 = new OneKeyLoginOptResult();
                        oneKeyLoginOptResult2.setCode(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NOT_MEET_GRAY);
                        oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult2);
                        return;
                    }
                    return;
                }
                a.c().g(sapiConfiguration.context, i2, new a.InterfaceC0097a(this, str, SapiUtils.getNetworkClass(sapiConfiguration.context), oneKeyLoginOptCallback) { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ OneKeyLoginSdkCall this$0;
                    public final /* synthetic */ OneKeyLoginOptCallback val$callback;
                    public final /* synthetic */ String val$netType;
                    public final /* synthetic */ String val$scene;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, str, r8, oneKeyLoginOptCallback};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i3 = newInitContext.flag;
                            if ((i3 & 1) != 0) {
                                int i4 = i3 & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$scene = str;
                        this.val$netType = r8;
                        this.val$callback = oneKeyLoginOptCallback;
                    }

                    @Override // b.a.n0.a.InterfaceC0097a
                    public void onFinish(String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, str2) == null) {
                            Log.d(OneKeyLoginSdkCall.TAG, "SSOManager preLogin onFinish result=" + str2);
                            OneKeyLoginOptResult formatOptResult = OneKeyLoginOptResult.formatOptResult(str2);
                            if (OneKeyLoginOptResult.isValid(formatOptResult)) {
                                formatOptResult.generateSecurityPhone();
                                OneKeyLoginOptResult unused = OneKeyLoginSdkCall.preLoginOptResult = formatOptResult;
                            }
                            SapiStatUtil.statOneKeyPreGetPhone(formatOptResult.getCode(), formatOptResult.getSubCode(), formatOptResult.getSecurityPhone(), formatOptResult.getOperateType(), this.val$scene, this.val$netType);
                            if (this.val$callback != null) {
                                new Handler(Looper.getMainLooper()).post(new Runnable(this, formatOptResult) { // from class: com.baidu.sapi2.outsdk.OneKeyLoginSdkCall.1.1
                                    public static /* synthetic */ Interceptable $ic;
                                    public transient /* synthetic */ FieldHolder $fh;
                                    public final /* synthetic */ AnonymousClass1 this$1;
                                    public final /* synthetic */ OneKeyLoginOptResult val$result;

                                    {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 != null) {
                                            InitContext newInitContext = TitanRuntime.newInitContext();
                                            newInitContext.initArgs = r2;
                                            Object[] objArr = {this, formatOptResult};
                                            interceptable3.invokeUnInit(65536, newInitContext);
                                            int i3 = newInitContext.flag;
                                            if ((i3 & 1) != 0) {
                                                int i4 = i3 & 2;
                                                newInitContext.thisArg = this;
                                                interceptable3.invokeInitBody(65536, newInitContext);
                                                return;
                                            }
                                        }
                                        this.this$1 = this;
                                        this.val$result = formatOptResult;
                                    }

                                    @Override // java.lang.Runnable
                                    public void run() {
                                        Interceptable interceptable3 = $ic;
                                        if (interceptable3 == null || interceptable3.invokeV(1048576, this) == null) {
                                            this.this$1.val$callback.onFinish(this.val$result);
                                        }
                                    }
                                });
                            }
                        }
                    }
                });
                return;
            }
            Log.d(TAG, "不能获取正确的运营商信息，请检查手机是否有sim卡，operator=" + b2);
            if (oneKeyLoginOptCallback != null) {
                OneKeyLoginOptResult oneKeyLoginOptResult3 = new OneKeyLoginOptResult();
                oneKeyLoginOptResult3.setCode(OneKeyLoginResult.ONE_KEY_LOGIN_CODE_INVALID_OPERATOR);
                oneKeyLoginOptCallback.onFinish(oneKeyLoginOptResult3);
            }
        }
    }

    public void preGetPhoneFail(OneKeyLoginCallback oneKeyLoginCallback, int i2, String str) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLIL(1048586, this, oneKeyLoginCallback, i2, str) == null) || oneKeyLoginCallback == null) {
            return;
        }
        OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
        oneKeyLoginResult.setResultCode(i2);
        oneKeyLoginResult.setResultMsg(str);
        oneKeyLoginCallback.unAvailable(oneKeyLoginResult);
    }
}
