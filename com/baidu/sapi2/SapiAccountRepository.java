package com.baidu.sapi2;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import androidx.core.view.InputDeviceCompat;
import com.baidu.android.imsdk.db.TableDefine;
import com.baidu.android.imsdk.internal.Constants;
import com.baidu.android.imsdk.retrieve.RetrieveTaskManager;
import com.baidu.cyberplayer.sdk.statistics.DpStatConstants;
import com.baidu.pass.common.SecurityUtil;
import com.baidu.pass.http.HttpHashMap;
import com.baidu.pass.http.ReqPriority;
import com.baidu.pass.main.facesdk.utils.PreferencesUtil;
import com.baidu.sapi2.SapiAccount;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.callback.FillUsernameCallback;
import com.baidu.sapi2.callback.GetTplStokenCallback;
import com.baidu.sapi2.callback.GetUserInfoCallback;
import com.baidu.sapi2.callback.IqiyiLoginCallback;
import com.baidu.sapi2.callback.NetCallback;
import com.baidu.sapi2.callback.OneKeyLoginCallback;
import com.baidu.sapi2.callback.SapiCallback;
import com.baidu.sapi2.callback.SsoHashCallback;
import com.baidu.sapi2.callback.Web2NativeLoginCallback;
import com.baidu.sapi2.callback.inner.ExecuteJsCallback;
import com.baidu.sapi2.callback.inner.GetOnlineAppCallback;
import com.baidu.sapi2.callback.inner.GetShareV3AppCallback;
import com.baidu.sapi2.callback.inner.LoadExternalWebViewActivityCallback;
import com.baidu.sapi2.callback.inner.LoginHistoryCallback;
import com.baidu.sapi2.dto.FaceBaseDTO;
import com.baidu.sapi2.dto.IqiyiLoginDTO;
import com.baidu.sapi2.dto.PassNameValuePair;
import com.baidu.sapi2.httpwrap.HttpClientWrap;
import com.baidu.sapi2.httpwrap.HttpHandlerWrap;
import com.baidu.sapi2.httpwrap.HttpHashMapWrap;
import com.baidu.sapi2.outsdk.OneKeyLoginSdkCall;
import com.baidu.sapi2.result.CheckUserFaceIdResult;
import com.baidu.sapi2.result.FaceLoginStatusResult;
import com.baidu.sapi2.result.FillUsernameResult;
import com.baidu.sapi2.result.GetTplStokenResult;
import com.baidu.sapi2.result.GetUserInfoResult;
import com.baidu.sapi2.result.IqiyiLoginResult;
import com.baidu.sapi2.result.OAuthResult;
import com.baidu.sapi2.result.OneKeyLoginResult;
import com.baidu.sapi2.result.SapiResult;
import com.baidu.sapi2.result.SsoHashResult;
import com.baidu.sapi2.result.Web2NativeLoginResult;
import com.baidu.sapi2.share.GetOnlineRequestShareModel;
import com.baidu.sapi2.share.ShareCallPacking;
import com.baidu.sapi2.share.ShareStorage;
import com.baidu.sapi2.share.ShareUtils;
import com.baidu.sapi2.share.face.FaceLoginService;
import com.baidu.sapi2.shell.callback.SapiCallBack;
import com.baidu.sapi2.shell.response.SapiAccountResponse;
import com.baidu.sapi2.shell.response.SapiResponse;
import com.baidu.sapi2.shell.response.SocialResponse;
import com.baidu.sapi2.stat.OneKeyLoginStat;
import com.baidu.sapi2.stat.ShareLoginStat;
import com.baidu.sapi2.utils.GetTplStokenStat;
import com.baidu.sapi2.utils.Log;
import com.baidu.sapi2.utils.ParamsUtil;
import com.baidu.sapi2.utils.PtokenStat;
import com.baidu.sapi2.utils.SapiCoreUtil;
import com.baidu.sapi2.utils.SapiDataEncryptor;
import com.baidu.sapi2.utils.SapiDeviceInfo;
import com.baidu.sapi2.utils.SapiDeviceUtils;
import com.baidu.sapi2.utils.SapiEnv;
import com.baidu.sapi2.utils.SapiStatUtil;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.sapi2.utils.Security;
import com.baidu.sapi2.utils.enums.BindWidgetAction;
import com.baidu.sapi2.utils.enums.Domain;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.searchbox.pms.db.PackageTable;
import com.baidu.tieba.external.music.data.MusicData;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.facebook.cache.disk.DefaultDiskStorage;
import com.meizu.cloud.pushsdk.notification.model.AppIconSetting;
import com.repackage.gd1;
import com.tachikoma.core.component.input.InputType;
import java.io.UnsupportedEncodingException;
import java.net.HttpCookie;
import java.net.URL;
import java.net.URLConnection;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.security.cert.CertificateException;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public final class SapiAccountRepository {
    public static /* synthetic */ Interceptable $ic = null;
    public static final String API_V3 = "3";
    public static final int SSL_AES = 6;
    public static final String TAG = "SapiAccountRepository";
    public transient /* synthetic */ FieldHolder $fh;
    public SapiConfiguration configuration;

    /* loaded from: classes2.dex */
    public interface OneKeyRequestJsCallback {
        void failure(int i, String str);

        void success();
    }

    static {
        InterceptResult invokeClinit;
        ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
        if (classClinitInterceptable == null || (invokeClinit = classClinitInterceptable.invokeClinit(105204573, "Lcom/baidu/sapi2/SapiAccountRepository;")) == null) {
            return;
        }
        Interceptable interceptable = invokeClinit.interceptor;
        if (interceptable != null) {
            $ic = interceptable;
        }
        if ((invokeClinit.flags & 1) != 0) {
            classClinitInterceptable.invokePostClinit(105204573, "Lcom/baidu/sapi2/SapiAccountRepository;");
        }
    }

    public SapiAccountRepository() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65537, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65537, newInitContext);
                return;
            }
        }
        this.configuration = SapiAccountManager.getInstance().getSapiConfiguration();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public OAuthResult formatOauthResult(JSONObject jSONObject) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65547, this, jSONObject)) == null) {
            if (jSONObject == null) {
                return null;
            }
            OAuthResult oAuthResult = new OAuthResult();
            try {
                oAuthResult.setResultCode(Integer.parseInt(jSONObject.optString("errno")));
            } catch (Exception e) {
                String str = TAG;
                Log.e(str, "formatOauthResult parseInt: " + e.getMessage());
            }
            oAuthResult.accessToken = jSONObject.optString("access_token");
            oAuthResult.expiresIn = jSONObject.optInt("expires_in");
            oAuthResult.scope = jSONObject.optString("scope");
            oAuthResult.refreshToken = jSONObject.optString("refresh_token");
            oAuthResult.sessionKey = jSONObject.optString("session_key");
            oAuthResult.sessionSecret = jSONObject.optString("session_secret");
            oAuthResult.extra = jSONObject.optString("extra");
            oAuthResult.openid = jSONObject.optString("openid");
            return oAuthResult;
        }
        return (OAuthResult) invokeL.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getAccessTokenCacheKey(String str, String str2) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65548, this, str, str2)) == null) {
            return new String(Base64.encode((str + str2).getBytes(), 0));
        }
        return (String) invokeLL.objValue;
    }

    private OAuthResult getCachedOauthResult(String str, String str2) {
        InterceptResult invokeLL;
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, this, str, str2)) == null) {
            String string = SapiContext.getInstance().getString(getAccessTokenCacheKey(str, str2));
            try {
                jSONObject = new JSONObject(string);
            } catch (JSONException e) {
                String str3 = TAG;
                Log.e(str3, "formatOauthResult: " + e.getMessage());
                jSONObject = null;
            }
            if (jSONObject != null) {
                OAuthResult formatOauthResult = formatOauthResult(jSONObject);
                if (System.currentTimeMillis() / 1000 < jSONObject.optLong("cachedTimeSecond", 0L) + formatOauthResult.expiresIn) {
                    String str4 = TAG;
                    Log.d(str4, "getCachedOauthResult result: " + string);
                    return formatOauthResult;
                }
            }
            return null;
        }
        return (OAuthResult) invokeLL.objValue;
    }

    private String getCheckAvailableLoginHistoryUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65550, this)) == null) {
            return getDomain().getWap() + "/v3/api/login/historylist";
        }
        return (String) invokeV.objValue;
    }

    private Domain getDomain() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65551, this)) == null) ? this.configuration.environment : (Domain) invokeV.objValue;
    }

    private String getLastCert() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeV = interceptable.invokeV(65552, this)) == null) ? "/sslcrypt/get_last_cert" : (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void getThroughServer(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO, IqiyiLoginResult iqiyiLoginResult) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(65553, this, iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult) == null) {
            if (!TextUtils.isEmpty(iqiyiLoginDTO.accessToken) && !TextUtils.isEmpty(iqiyiLoginDTO.openID)) {
                HttpHashMapWrap buildSapiParams = buildSapiParams(getDomainSSOStart());
                if (!TextUtils.isEmpty(iqiyiLoginDTO.phoneNum)) {
                    buildSapiParams.put("crypt_m", iqiyiLoginDTO.phoneNum);
                }
                buildSapiParams.put("access_token", iqiyiLoginDTO.accessToken);
                buildSapiParams.put("osuid", iqiyiLoginDTO.openID);
                buildSapiParams.put("json", "1");
                buildSapiParams.put("type", SocialType.IQIYI.getType() + "");
                buildSapiParams.put("act", "special");
                buildSapiParams.put(CriusAttrConstants.DISPLAY, "native");
                new HttpClientWrap().get(getDomainSSOStart(), ReqPriority.IMMEDIATE, buildSapiParams, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), iqiyiLoginCallback, iqiyiLoginResult) { // from class: com.baidu.sapi2.SapiAccountRepository.11
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiAccountRepository this$0;
                    public final /* synthetic */ IqiyiLoginCallback val$callback;
                    public final /* synthetic */ IqiyiLoginResult val$result;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, iqiyiLoginCallback, iqiyiLoginResult};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = iqiyiLoginCallback;
                        this.val$result = iqiyiLoginResult;
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFailure(Throwable th, int i, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str) == null) {
                            this.val$result.setResultCode(i);
                            this.val$callback.onFailure(this.val$result);
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.val$callback.onFinish();
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onSuccess(int i, String str) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, str) == null) {
                            if (this.this$0.getErrorCode(str) != 302) {
                                SocialResponse parseOpenApiAuthorizedResult = SapiWebView.parseOpenApiAuthorizedResult(str, this.this$0.configuration.context);
                                if (parseOpenApiAuthorizedResult == null) {
                                    this.val$result.setResultCode(-100);
                                    this.val$result.setResultMsg("登录失败");
                                    this.val$callback.onFailure(this.val$result);
                                    return;
                                } else if (parseOpenApiAuthorizedResult.errorCode != -100) {
                                    this.val$result.setResultCode(-100);
                                    this.val$result.setResultMsg("登录失败");
                                    this.val$callback.onFailure(this.val$result);
                                    return;
                                } else {
                                    SapiAccount responseToAccount = this.this$0.responseToAccount(parseOpenApiAuthorizedResult);
                                    responseToAccount.addSocialInfo(parseOpenApiAuthorizedResult.socialType, parseOpenApiAuthorizedResult.socialPortraitUrl, parseOpenApiAuthorizedResult.socialNickname);
                                    responseToAccount.putExtra("account_type", Integer.valueOf(parseOpenApiAuthorizedResult.accountType.getType()));
                                    responseToAccount.addDispersionCertification(parseOpenApiAuthorizedResult.tplStokenMap);
                                    responseToAccount.addIsGuestAccount(parseOpenApiAuthorizedResult.isGuestAccount);
                                    responseToAccount.putExtra("tpl", this.this$0.configuration.tpl);
                                    SapiAccountManager.getInstance().validate(responseToAccount);
                                    this.val$callback.onSuccess(this.val$result);
                                    return;
                                }
                            }
                            try {
                                JSONObject jSONObject = new JSONObject(str);
                                this.val$result.nextUrl = jSONObject.optString("next_url");
                                this.val$callback.onBindWebview(this.val$result);
                            } catch (JSONException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                });
                return;
            }
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public String getUaInfo() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65554, this)) == null) {
            return "tpl:" + this.configuration.tpl + ";android_sapi_v9.5.5";
        }
        return (String) invokeV.objValue;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void processOneKeyLoginIsAvailable(int i, String str, String str2, OneKeyLoginCallback oneKeyLoginCallback) {
        JSONObject jSONObject;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65555, this, new Object[]{Integer.valueOf(i), str, str2, oneKeyLoginCallback}) == null) {
            Log.d(TAG, "onSuccess, statusCode = " + i + ", response = " + str);
            JSONObject jSONObject2 = null;
            try {
                jSONObject = new JSONObject(str);
            } catch (Exception unused) {
                jSONObject = null;
            }
            OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
            if (jSONObject == null) {
                SapiStatUtil.statOneKeyCheckAbility(i, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR, false, OneKeyLoginSdkCall.getInstance().getOperatorType());
                new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, -100, null);
                OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf((int) OneKeyLoginResult.ONE_KEY_LOGIN_CODE_JSON_ERROR));
                OneKeyLoginStat.CheckAbility.sValue = "0";
                OneKeyLoginStat.CheckAbility.upload();
                return;
            }
            int optInt = jSONObject.optInt("errno");
            if ((optInt == 0 && (jSONObject2 = jSONObject.optJSONObject("data")) != null && 1 == jSONObject2.optInt("enable")) && jSONObject2 != null) {
                oneKeyLoginResult.enable = true;
                oneKeyLoginResult.setResultCode(0);
                oneKeyLoginResult.hasHistory = jSONObject2.optInt("hasHistory", -1) == 1;
                oneKeyLoginResult.encryptPhoneNum = str2;
                String optString = jSONObject2.optString("sign");
                oneKeyLoginResult.sign = optString;
                OneKeyLoginSdkCall.signFromAbilityApi = optString;
                oneKeyLoginResult.operator = new OneKeyLoginSdkCall().getOperatorType();
                String optString2 = jSONObject2.optString(PackageTable.MD5);
                String optString3 = jSONObject2.optString("url");
                String optString4 = jSONObject2.optString("js");
                String onekeyLoginJsMd5 = SapiContext.getInstance().getOnekeyLoginJsMd5();
                if (optString2 != null && optString2.equals(onekeyLoginJsMd5)) {
                    OneKeyLoginResult.secondJsCode = optString4;
                    oneKeyLoginCallback.available(oneKeyLoginResult);
                    OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(optInt));
                    OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE, "1");
                    OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE_REPETITION, "1");
                    OneKeyLoginStat.CheckAbility.sValue = "1";
                    OneKeyLoginStat.CheckAbility.upload();
                } else {
                    OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE_REPETITION, "0");
                    requestFirstJsCode(optString3, optString2, optString4, new OneKeyRequestJsCallback(this, optString4, oneKeyLoginCallback, oneKeyLoginResult, optInt, System.currentTimeMillis()) { // from class: com.baidu.sapi2.SapiAccountRepository.18
                        public static /* synthetic */ Interceptable $ic;
                        public transient /* synthetic */ FieldHolder $fh;
                        public final /* synthetic */ SapiAccountRepository this$0;
                        public final /* synthetic */ OneKeyLoginCallback val$callback;
                        public final /* synthetic */ int val$errno;
                        public final /* synthetic */ OneKeyLoginResult val$result;
                        public final /* synthetic */ String val$secondJsCode;
                        public final /* synthetic */ long val$startTime;

                        {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 != null) {
                                InitContext newInitContext = TitanRuntime.newInitContext();
                                newInitContext.initArgs = r2;
                                Object[] objArr = {this, optString4, oneKeyLoginCallback, oneKeyLoginResult, Integer.valueOf(optInt), Long.valueOf(r11)};
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
                            this.val$secondJsCode = optString4;
                            this.val$callback = oneKeyLoginCallback;
                            this.val$result = oneKeyLoginResult;
                            this.val$errno = optInt;
                            this.val$startTime = r11;
                        }

                        @Override // com.baidu.sapi2.SapiAccountRepository.OneKeyRequestJsCallback
                        public void failure(int i2, String str3) {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeIL(1048576, this, i2, str3) == null) {
                                long currentTimeMillis = System.currentTimeMillis();
                                new OneKeyLoginSdkCall().preGetPhoneFail(this.val$callback, i2, str3);
                                OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(this.val$errno));
                                OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE, "0");
                                OneKeyLoginStat.CheckAbility.sValue = "0";
                                OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_DUR, Long.valueOf(currentTimeMillis - this.val$startTime));
                                OneKeyLoginStat.CheckAbility.upload();
                            }
                        }

                        @Override // com.baidu.sapi2.SapiAccountRepository.OneKeyRequestJsCallback
                        public void success() {
                            Interceptable interceptable2 = $ic;
                            if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                                long currentTimeMillis = System.currentTimeMillis();
                                OneKeyLoginResult.secondJsCode = this.val$secondJsCode;
                                this.val$callback.available(this.val$result);
                                OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(this.val$errno));
                                OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_ABLE, "1");
                                OneKeyLoginStat.CheckAbility.statExtMap.put(OneKeyLoginStat.CheckAbility.KEY_EXT_JS_DUR, Long.valueOf(currentTimeMillis - this.val$startTime));
                                OneKeyLoginStat.CheckAbility.sValue = "1";
                                OneKeyLoginStat.CheckAbility.upload();
                            }
                        }
                    });
                }
            } else {
                new OneKeyLoginSdkCall().preGetPhoneFail(oneKeyLoginCallback, optInt, jSONObject.optString("errmsg"));
                OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(optInt));
                OneKeyLoginStat.CheckAbility.sValue = "0";
                OneKeyLoginStat.CheckAbility.upload();
            }
            SapiStatUtil.statOneKeyCheckAbility(i, optInt, oneKeyLoginResult.enable, oneKeyLoginResult.operator);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void realDynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, String str3, String str4, boolean z, SapiDataEncryptor sapiDataEncryptor) throws InvalidKeyException, NoSuchAlgorithmException, NoSuchPaddingException, IllegalBlockSizeException, BadPaddingException, UnsupportedEncodingException, CertificateException, JSONException {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(65556, this, new Object[]{sapiCallBack, str, str2, str3, str4, Boolean.valueOf(z), sapiDataEncryptor}) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("crypttype", "6");
            String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.LOGIN_URI);
            if (!TextUtils.isEmpty(deviceInfo)) {
                httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
            }
            httpHashMapWrap.put("cert_id", str2);
            httpHashMapWrap.put("isdpass", "1");
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("username", str3);
            jSONObject.put("isphone", "1");
            jSONObject.put(InputType.PASSWORD, str4);
            jSONObject.put(Constants.KEY_LOGIN_TYPE, "3");
            jSONObject.put("key", sapiDataEncryptor.getAESKey());
            jSONObject.put("sdk_version", "2");
            jSONObject.put("pinfo", SapiDeviceUtils.getBrandName());
            httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt(str, jSONObject.toString()));
            new HttpClientWrap().post(SapiEnv.LOGIN_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), sapiCallBack, z, sapiDataEncryptor) { // from class: com.baidu.sapi2.SapiAccountRepository.3
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ SapiCallBack val$callBack;
                public final /* synthetic */ SapiDataEncryptor val$helper;
                public final /* synthetic */ boolean val$needShare;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, sapiCallBack, Boolean.valueOf(z), sapiDataEncryptor};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callBack = sapiCallBack;
                    this.val$needShare = z;
                    this.val$helper = sapiDataEncryptor;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str5) == null) {
                        super.onFailure(th, i, str5);
                        if (i == -201) {
                            this.val$callBack.onNetworkFailed();
                        } else {
                            this.val$callBack.onSystemError(i);
                        }
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str5) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str5) == null) {
                        super.onSuccess(i, str5);
                        SapiAccountRepository sapiAccountRepository = this.this$0;
                        sapiAccountRepository.handleDynamicPwdLogin(sapiAccountRepository.getErrorCode(str5), this.val$callBack, str5, this.val$needShare, this.val$helper);
                    }
                }
            });
        }
    }

    private void requestFirstJsCode(String str, String str2, String str3, OneKeyRequestJsCallback oneKeyRequestJsCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(65557, this, str, str2, str3, oneKeyRequestJsCallback) == null) {
            new HttpClientWrap().get(str, ReqPriority.IMMEDIATE, new HttpHandlerWrap(this, Looper.getMainLooper(), str2, oneKeyRequestJsCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.20
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ OneKeyRequestJsCallback val$callback;
                public final /* synthetic */ String val$md5;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, str2, oneKeyRequestJsCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$md5 = str2;
                    this.val$callback = oneKeyRequestJsCallback;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str4) {
                    OneKeyRequestJsCallback oneKeyRequestJsCallback2;
                    Interceptable interceptable2 = $ic;
                    if (!(interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str4) == null) || (oneKeyRequestJsCallback2 = this.val$callback) == null) {
                        return;
                    }
                    oneKeyRequestJsCallback2.failure(-105, "");
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str4) == null) {
                        String md5 = SecurityUtil.md5(str4.getBytes(), false);
                        String str5 = this.val$md5;
                        if (str5 != null && str5.equals(md5)) {
                            SapiContext.getInstance().setOneKeyLoginJSCode(str4);
                            SapiContext.getInstance().setOnekeyLoginJsMd5(this.val$md5);
                            OneKeyRequestJsCallback oneKeyRequestJsCallback2 = this.val$callback;
                            if (oneKeyRequestJsCallback2 != null) {
                                oneKeyRequestJsCallback2.success();
                                return;
                            }
                            return;
                        }
                        OneKeyRequestJsCallback oneKeyRequestJsCallback3 = this.val$callback;
                        if (oneKeyRequestJsCallback3 != null) {
                            oneKeyRequestJsCallback3.failure(-106, "");
                        }
                        Log.d(SapiAccountRepository.TAG, "oneKeyLogin check javsScript MD5 failed");
                    }
                }
            });
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void setOneKeyLoginCookies(HashMap<String, String> hashMap) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeL(65558, this, hashMap) == null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new PassNameValuePair(this.configuration.environment.getWap(), hashMap.get("HISTORY")));
            SapiUtils.syncCookies(this.configuration.context, arrayList);
        }
    }

    public HttpHashMapWrap buildSapiParams(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048576, this, str)) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            String deviceInfo = SapiDeviceInfo.getDeviceInfo(str);
            if (!TextUtils.isEmpty(deviceInfo)) {
                httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
            }
            httpHashMapWrap.put("clientfrom", "mobilesdk_enhanced");
            httpHashMapWrap.put("sdk_version", "3");
            return httpHashMapWrap;
        }
        return (HttpHashMapWrap) invokeL.objValue;
    }

    public void cancelRequest() {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
        }
    }

    public void checkAvailableLoginHistory(String str, LoginHistoryCallback loginHistoryCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(Constants.METHOD_SEND_USER_MSG, this, str, loginHistoryCallback) == null) {
            Log.d("history", "checkAvailableLoginHistory loginHistoryInfo=" + str);
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("historyBdussList", str);
            new HttpClientWrap().post(getCheckAvailableLoginHistoryUrl(), ReqPriority.IMMEDIATE, httpHashMapWrap, new HttpHandlerWrap(this, Looper.getMainLooper(), loginHistoryCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.23
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ LoginHistoryCallback val$callback;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, loginHistoryCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = loginHistoryCallback;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str2) == null) {
                        Log.d("History", "checkAvailableLoginHistory onFailure errorCode=" + i + ", responseBody=" + str2);
                        this.val$callback.onFailure();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str2, HashMap<String, String> hashMap) {
                    JSONObject jSONObject;
                    JSONObject optJSONObject;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2, hashMap) == null) {
                        Log.d("History", "checkAvailableLoginHistory onSuccess statusCode=" + i + ", responseBody=" + str2);
                        JSONArray jSONArray = null;
                        try {
                            jSONObject = new JSONObject(str2);
                        } catch (JSONException e) {
                            e.printStackTrace();
                            jSONObject = null;
                        }
                        if (jSONObject == null) {
                            this.val$callback.onFailure();
                            return;
                        }
                        if (jSONObject.optInt("code") == 110000 && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                            jSONArray = optJSONObject.optJSONArray("historyList");
                        }
                        if (jSONArray != null) {
                            this.val$callback.onResult(jSONArray);
                        } else {
                            this.val$callback.onFailure();
                        }
                    }
                }
            });
        }
    }

    public void checkFaceLoginStatus(SapiCallback<FaceLoginStatusResult> sapiCallback, String str) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048579, this, sapiCallback, str) == null) {
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                str = currentAccount.bduss;
            }
            SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notEmpty(str, "bduss can't be empty");
            HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.FACE_LOGIN_STATUS_CHECK);
            buildSapiParams.put("clientfrom", "native");
            buildSapiParams.put("bduss", str);
            new HttpClientWrap().post(SapiEnv.FACE_LOGIN_STATUS_CHECK, buildSapiParams, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), sapiCallback, new FaceLoginStatusResult()) { // from class: com.baidu.sapi2.SapiAccountRepository.13
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ SapiCallback val$callback;
                public final /* synthetic */ FaceLoginStatusResult val$result;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, sapiCallback, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = sapiCallback;
                    this.val$result = r10;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str2) == null) {
                        this.val$result.setResultCode(i);
                        this.val$callback.onFailure(this.val$result);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.val$callback.onFinish();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.val$callback.onStart();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, str2) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                            this.val$result.setResultCode(parseInt);
                            this.val$result.setResultMsg(jSONObject.optString("errmsg"));
                            if (parseInt == 0) {
                                this.val$result.status = jSONObject.optInt("status");
                                this.val$result.livingUname = jSONObject.optString("livinguname");
                                this.val$result.authsid = jSONObject.optString("authsid");
                                this.val$result.authWidgetURL = jSONObject.optString("authurl");
                                FaceLoginStatusResult faceLoginStatusResult = this.val$result;
                                boolean z = true;
                                if (jSONObject.optInt("faceLoginEnabled") != 1) {
                                    z = false;
                                }
                                faceLoginStatusResult.faceLoginSwitch = z;
                                this.val$callback.onSuccess(this.val$result);
                                return;
                            }
                            this.val$callback.onFailure(this.val$result);
                        } catch (Throwable unused) {
                            this.val$result.setResultCode(-202);
                            this.val$callback.onFailure(this.val$result);
                        }
                    }
                }
            });
        }
    }

    public void checkOneKeyLoginIsAvailable(OneKeyLoginCallback oneKeyLoginCallback, String str, int i) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLI(1048580, this, oneKeyLoginCallback, str, i) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("ability", "onekeylogin");
            httpHashMapWrap.put("scene", RetrieveTaskManager.KEY);
            httpHashMapWrap.put("clientfrom", "native");
            httpHashMapWrap.put("mobile", str);
            httpHashMapWrap.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
            String oneKeyLoginAbilityUrl = getOneKeyLoginAbilityUrl();
            List<HttpCookie> buildNaCookie = ParamsUtil.buildNaCookie(oneKeyLoginAbilityUrl, this.configuration);
            long currentTimeMillis = System.currentTimeMillis();
            OneKeyLoginStat.CheckAbility.statExtMap.put("phoneNum", str);
            OneKeyLoginStat.CheckAbility.statExtMap.put("connectTimeout", Integer.valueOf(i));
            OneKeyLoginStat.CheckAbility.statExtMap.put("scene", RetrieveTaskManager.KEY);
            OneKeyLoginStat.CheckAbility.statExtMap.put("netType", SapiUtils.getNetworkClass(this.configuration.context));
            OneKeyLoginStat.CheckAbility.statExtMap.put("operator", gd1.c().b(this.configuration.context));
            new HttpClientWrap().get(oneKeyLoginAbilityUrl, ReqPriority.IMMEDIATE, httpHashMapWrap, buildNaCookie, getUaInfo(), i, new HttpHandlerWrap(this, Looper.getMainLooper(), currentTimeMillis, str, oneKeyLoginCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.17
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ OneKeyLoginCallback val$callback;
                public final /* synthetic */ String val$encryptPhoneNum;
                public final /* synthetic */ long val$startTime;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, Long.valueOf(currentTimeMillis), str, oneKeyLoginCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$startTime = currentTimeMillis;
                    this.val$encryptPhoneNum = str;
                    this.val$callback = oneKeyLoginCallback;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i2, str2) == null) {
                        OneKeyLoginStat.CheckAbility.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - this.val$startTime));
                        OneKeyLoginStat.CheckAbility.statExtMap.put("code", Integer.valueOf(i2));
                        OneKeyLoginStat.CheckAbility.sValue = "0";
                        OneKeyLoginStat.CheckAbility.upload();
                        String str3 = SapiAccountRepository.TAG;
                        Log.d(str3, "onFailure, error = " + th + ", errorCode = " + i2 + ", responseBody = " + str2);
                        SapiStatUtil.statOneKeyCheckAbility(i2, OneKeyLoginResult.ONE_KEY_LOGIN_CODE_NET_ERROR, false, OneKeyLoginSdkCall.getInstance().getOperatorType());
                        new OneKeyLoginSdkCall().preGetPhoneFail(this.val$callback, i2, null);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i2, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i2, str2) == null) {
                        OneKeyLoginStat.CheckAbility.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - this.val$startTime));
                        this.this$0.processOneKeyLoginIsAvailable(i2, str2, this.val$encryptPhoneNum, this.val$callback);
                    }
                }
            });
        }
    }

    public void checkUserFaceId(SapiCallback<CheckUserFaceIdResult> sapiCallback, String str, Map<String, String> map) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048581, this, sapiCallback, str, map) == null) {
            SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notEmpty(str, "bduss can't be empty");
            HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.CHECK_USER_FACE_ID);
            buildSapiParams.put("clientfrom", "native");
            buildSapiParams.put("bduss", str);
            if (map != null && !map.isEmpty()) {
                buildSapiParams.putAll(map);
            }
            new HttpClientWrap().post(SapiEnv.CHECK_USER_FACE_ID, buildSapiParams, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), sapiCallback, new CheckUserFaceIdResult()) { // from class: com.baidu.sapi2.SapiAccountRepository.12
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ SapiCallback val$callback;
                public final /* synthetic */ CheckUserFaceIdResult val$result;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, sapiCallback, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = sapiCallback;
                    this.val$result = r10;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str2) == null) {
                        this.val$result.setResultCode(i);
                        this.val$callback.onFailure(this.val$result);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.val$callback.onFinish();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.val$callback.onStart();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, str2) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                            this.val$result.setResultCode(parseInt);
                            this.val$result.setResultMsg(jSONObject.optString("errmsg"));
                            if (parseInt == 0) {
                                this.val$result.status = jSONObject.optInt("status");
                                this.val$result.livingUname = jSONObject.optString("livinguname");
                                this.val$result.authsid = jSONObject.optString("authsid");
                                this.val$result.authWidgetURL = jSONObject.optString("authurl");
                                this.val$result.action = jSONObject.optString("action");
                                this.val$callback.onSuccess(this.val$result);
                                return;
                            }
                            this.val$callback.onFailure(this.val$result);
                        } catch (Throwable unused) {
                            this.val$result.setResultCode(-202);
                            this.val$callback.onFailure(this.val$result);
                        }
                    }
                }
            });
        }
    }

    public boolean dynamicPwdLogin(SapiCallBack<SapiAccountResponse> sapiCallBack, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048582, this, new Object[]{sapiCallBack, str, str2, Boolean.valueOf(z)})) == null) {
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration == null || sapiConfiguration.context == null) {
                return false;
            }
            SapiUtils.notNull(sapiCallBack, SapiCallBack.class.getSimpleName() + " can't be null");
            new HttpClientWrap().get(getLastCert(), ReqPriority.IMMEDIATE, null, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), sapiCallBack, z, new SapiDataEncryptor(), str, str2) { // from class: com.baidu.sapi2.SapiAccountRepository.2
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ SapiCallBack val$callBack;
                public final /* synthetic */ SapiDataEncryptor val$helper;
                public final /* synthetic */ boolean val$needShare;
                public final /* synthetic */ String val$password;
                public final /* synthetic */ String val$username;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, sapiCallBack, Boolean.valueOf(z), r11, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callBack = sapiCallBack;
                    this.val$needShare = z;
                    this.val$helper = r11;
                    this.val$username = str;
                    this.val$password = str2;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str3) == null) {
                        if (i == -201) {
                            this.val$callBack.onNetworkFailed();
                        } else {
                            this.val$callBack.onSystemError(i);
                        }
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str3) == null) {
                        super.onSuccess(i, str3);
                        if (!TextUtils.isEmpty(str3)) {
                            this.this$0.handleDynamicPwdLogin(-100, this.val$callBack, str3, this.val$needShare, this.val$helper);
                            return;
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            this.this$0.realDynamicPwdLogin(this.val$callBack, jSONObject.optString("cert"), jSONObject.optString("cert_id"), this.val$username, this.val$password, this.val$needShare, this.val$helper);
                        } catch (Exception e) {
                            this.this$0.handleDynamicPwdLogin(-100, this.val$callBack, str3, this.val$needShare, this.val$helper);
                            Log.e(e);
                        }
                    }
                }
            });
            return true;
        }
        return invokeCommon.booleanValue;
    }

    public void extendSysWebViewMethodCheck(SapiCallback<SapiResult> sapiCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048583, this, sapiCallback, str, str2) == null) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("open_appid", str);
            httpHashMapWrap.put("open_apikey", str2);
            httpHashMapWrap.put("time", System.currentTimeMillis() + "");
            new HttpClientWrap().post(SapiEnv.EXTEND_SYS_WEBVIEW_METHOD_CHECK, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), sapiCallback, new SapiResult()) { // from class: com.baidu.sapi2.SapiAccountRepository.16
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ SapiCallback val$callback;
                public final /* synthetic */ SapiResult val$result;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, sapiCallback, r10};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = sapiCallback;
                    this.val$result = r10;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str3) == null) {
                        this.val$result.setResultCode(i);
                        this.val$result.setResultMsg(str3);
                        this.val$callback.onFailure(this.val$result);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.val$callback.onFinish();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.val$callback.onStart();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, str3) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            this.val$result.setResultCode(jSONObject.optInt("errno"));
                            this.val$result.setResultMsg(jSONObject.optString("errmsg"));
                        } catch (JSONException e) {
                            Log.e(e);
                        }
                        if (this.val$result.getResultCode() == 0) {
                            this.val$callback.onSuccess(this.val$result);
                        } else {
                            this.val$callback.onFailure(this.val$result);
                        }
                    }
                }
            });
        }
    }

    public void faceLoginSwitch(SapiCallback<SapiResult> sapiCallback, String str, boolean z, String str2) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(InputDeviceCompat.SOURCE_TOUCHPAD, this, new Object[]{sapiCallback, str, Boolean.valueOf(z), str2}) == null) {
            if (SapiContext.getInstance().getSapiOptions().getOpenBdussTpls().contains(SapiAccountManager.getInstance().getConfignation().tpl) && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                str = currentAccount.bduss;
            }
            SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notEmpty(str, "bduss can't be empty");
            HttpHashMapWrap buildSapiParams = buildSapiParams(SapiEnv.FACE_LOGIN_STATUS_CHECK);
            if (z) {
                buildSapiParams.put("action", "enable_face_login");
            } else {
                buildSapiParams.put("action", "disable_face_login");
            }
            if (!TextUtils.isEmpty(str2)) {
                buildSapiParams.put("callbackKey", str2);
            }
            buildSapiParams.put("guidefrom", FaceBaseDTO.BUSINESS_SENCE_FACE_LOGIN_SWITCH);
            buildSapiParams.put("clientfrom", "native");
            buildSapiParams.put("bduss", str);
            new HttpClientWrap().post(SapiEnv.FACE_LOGIN_SWITCH_URI, buildSapiParams, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), sapiCallback, new CheckUserFaceIdResult(), z) { // from class: com.baidu.sapi2.SapiAccountRepository.14
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ SapiCallback val$callback;
                public final /* synthetic */ boolean val$faceLoginSwitch;
                public final /* synthetic */ CheckUserFaceIdResult val$result;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, sapiCallback, r10, Boolean.valueOf(z)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = sapiCallback;
                    this.val$result = r10;
                    this.val$faceLoginSwitch = z;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str3) == null) {
                        this.val$result.setResultCode(i);
                        this.val$callback.onFailure(this.val$result);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.val$callback.onFinish();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.val$callback.onStart();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, str3) == null) {
                        try {
                            JSONObject jSONObject = new JSONObject(str3);
                            int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                            this.val$result.setResultCode(parseInt);
                            this.val$result.setResultMsg(jSONObject.optString("errmsg"));
                            if (parseInt == 0) {
                                if (this.val$faceLoginSwitch) {
                                    String optString = jSONObject.optString("livinguname");
                                    if (!TextUtils.isEmpty(optString)) {
                                        new FaceLoginService().syncFaceLoginUID(this.this$0.configuration.context, optString);
                                    }
                                }
                                this.val$callback.onSuccess(this.val$result);
                                return;
                            }
                            this.val$callback.onFailure(this.val$result);
                        } catch (Throwable unused) {
                            this.val$result.setResultCode(-202);
                            this.val$callback.onFailure(this.val$result);
                        }
                    }
                }
            });
        }
    }

    public void fillUsername(FillUsernameCallback fillUsernameCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048585, this, fillUsernameCallback, str, str2) == null) {
            SapiUtils.notNull(fillUsernameCallback, FillUsernameCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notEmpty(str, "bduss can't be empty");
            SapiUtils.notEmpty(str2, "username can't be empty");
            FillUsernameResult fillUsernameResult = new FillUsernameResult();
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("cert_id", String.valueOf(1));
            httpHashMapWrap.put("crypttype", String.valueOf(6));
            JSONObject jSONObject = new JSONObject();
            SapiDataEncryptor sapiDataEncryptor = new SapiDataEncryptor();
            try {
                jSONObject.put("bduss", str);
                String clientId = SapiUtils.getClientId(this.configuration.context);
                if (!TextUtils.isEmpty(clientId)) {
                    jSONObject.put("clientid", clientId);
                }
                if (!TextUtils.isEmpty(this.configuration.clientIp)) {
                    jSONObject.put("clientip", this.configuration.clientIp);
                }
                jSONObject.put("username", str2);
                jSONObject.put("key", sapiDataEncryptor.getAESKey());
                httpHashMapWrap.put(TableDefine.DB_TABLE_USERINFO, sapiDataEncryptor.encrypt(SapiDataEncryptor.Cert1.CERT, jSONObject.toString()));
                new HttpClientWrap().post(SapiEnv.FILL_UNAME, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), fillUsernameCallback, fillUsernameResult, sapiDataEncryptor) { // from class: com.baidu.sapi2.SapiAccountRepository.6
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiAccountRepository this$0;
                    public final /* synthetic */ FillUsernameCallback val$callback;
                    public final /* synthetic */ SapiDataEncryptor val$encryptor;
                    public final /* synthetic */ FillUsernameResult val$result;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, fillUsernameCallback, fillUsernameResult, sapiDataEncryptor};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = fillUsernameCallback;
                        this.val$result = fillUsernameResult;
                        this.val$encryptor = sapiDataEncryptor;
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFailure(Throwable th, int i, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str3) == null) {
                            this.val$result.setResultCode(i);
                            this.val$callback.onFailure(this.val$result);
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.val$callback.onFinish();
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.val$callback.onStart();
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onSuccess(int i, String str3) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, str3) == null) {
                            int errorCode = this.this$0.getErrorCode(str3);
                            this.val$result.setResultCode(errorCode);
                            try {
                                JSONObject jSONObject2 = new JSONObject(str3);
                                this.val$result.setResultMsg(jSONObject2.optString("errmsg"));
                                JSONObject jSONObject3 = new JSONObject(this.val$encryptor.decrypt(jSONObject2.optString(TableDefine.DB_TABLE_USERINFO)));
                                if (errorCode != 0 && errorCode != 110000) {
                                    switch (errorCode) {
                                        case 160103:
                                            this.val$callback.onBdussExpired(this.val$result);
                                            return;
                                        case FillUsernameResult.RESULT_CODE_USER_HAVE_USERNAME /* 160104 */:
                                            this.val$callback.onUserHaveUsername(this.val$result);
                                            return;
                                        default:
                                            this.val$callback.onFailure(this.val$result);
                                            return;
                                    }
                                }
                                SapiAccount sapiAccount = new SapiAccount();
                                sapiAccount.bduss = jSONObject3.optString("bduss");
                                sapiAccount.ptoken = jSONObject3.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
                                sapiAccount.stoken = jSONObject3.optString("stoken");
                                sapiAccount.displayname = jSONObject3.optString("displayname");
                                sapiAccount.username = jSONObject3.optString("uname");
                                sapiAccount.uid = jSONObject3.optString("uid");
                                sapiAccount.app = SapiUtils.getAppName(this.this$0.configuration.context);
                                sapiAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject3).tplStokenMap);
                                sapiAccount.putExtra("tpl", this.this$0.configuration.tpl);
                                SapiAccountManager.getInstance().validate(sapiAccount);
                                this.val$result.session = sapiAccount;
                                this.val$callback.onSuccess(this.val$result);
                                new PtokenStat().onEvent(PtokenStat.FILLNAME_WIDGE);
                            } catch (Throwable th) {
                                this.val$callback.onFailure(this.val$result);
                                Log.e(th);
                            }
                        }
                    }
                });
            } catch (Throwable th) {
                fillUsernameResult.setResultCode(-202);
                fillUsernameCallback.onFailure(fillUsernameResult);
                Log.e(th);
            }
        }
    }

    @SuppressLint({"NewApi"})
    public void generateSsoHash(SsoHashCallback ssoHashCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048586, this, ssoHashCallback, str, str2) == null) {
            SapiUtils.notNull(ssoHashCallback, "SsoHashCallback can't be null");
            new AsyncTask<String, Void, Long>(this, str, str2, ssoHashCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.15
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ SsoHashCallback val$callback;
                public final /* synthetic */ String val$callingAppId;
                public final /* synthetic */ String val$callingPkg;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, str, str2, ssoHashCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callingPkg = str;
                    this.val$callingAppId = str2;
                    this.val$callback = ssoHashCallback;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public Long doInBackground(String... strArr) {
                    InterceptResult invokeL;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || (invokeL = interceptable2.invokeL(1048576, this, strArr)) == null) {
                        try {
                            URLConnection openConnection = new URL(strArr[0]).openConnection();
                            openConnection.setConnectTimeout(3000);
                            openConnection.connect();
                            return Long.valueOf(openConnection.getDate() / 1000);
                        } catch (Exception e) {
                            Log.e(e);
                            return 0L;
                        }
                    }
                    return (Long) invokeL.objValue;
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // android.os.AsyncTask
                public void onPostExecute(Long l) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, l) == null) {
                        SsoHashResult ssoHashResult = new SsoHashResult();
                        ssoHashResult.ssoHash = new Security().encryptSsoHash(l, this.val$callingPkg, this.val$callingAppId);
                        ssoHashResult.setResultCode(0);
                        this.val$callback.onSuccess(ssoHashResult);
                    }
                }
            }.execute(SapiEnv.HASH_TIMESTAMP_URL);
        }
    }

    public String getAcccountCenterUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048587, this)) == null) {
            return getDomain().getWap() + "/wp/v3/ucenter/index";
        }
        return (String) invokeV.objValue;
    }

    public String getAccountCenterCheckUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048588, this)) == null) {
            return getDomain().getWap() + "/v6/safetyInspection";
        }
        return (String) invokeV.objValue;
    }

    public String getAccountRealNameUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048589, this)) == null) {
            return getDomain().getWap() + "/wp/v3/ucenter/realnameverify";
        }
        return (String) invokeV.objValue;
    }

    public String getAuthWidgetUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048590, this)) == null) {
            return getDomain().getWap() + "/v6/authwidget";
        }
        return (String) invokeV.objValue;
    }

    public String getBindWidgetUrl(BindWidgetAction bindWidgetAction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048591, this, bindWidgetAction)) == null) {
            return getDomain().getWap() + bindWidgetAction.getUri();
        }
        return (String) invokeL.objValue;
    }

    public String getChildVerifyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048592, this)) == null) {
            return getDomain().getWap() + SapiEnv.CHILD_VERIFY;
        }
        return (String) invokeV.objValue;
    }

    public String getContactAddressUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048593, this)) == null) {
            return getDomain().getWap() + "/v6/shippingAddress";
        }
        return (String) invokeV.objValue;
    }

    public String getDomainAfterAuth() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048594, this)) == null) {
            return getDomain().getURL() + SapiEnv.SOCIAL_AFTER_AUTH_URI;
        }
        return (String) invokeV.objValue;
    }

    public String getDomainFinishBind() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048595, this)) == null) {
            return getDomain().getURL() + SapiEnv.SOCIAL_FINISH_AUTH_URI;
        }
        return (String) invokeV.objValue;
    }

    public String getDomainSSOFinish() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048596, this)) == null) {
            return getDomain().getURL() + "/phoenix/account/ssologin";
        }
        return (String) invokeV.objValue;
    }

    public String getDomainSSOSecondcard() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048597, this)) == null) {
            return getDomain().getURL() + SapiEnv.SSO_SECONDCARD_URI;
        }
        return (String) invokeV.objValue;
    }

    public String getDomainSSOStart() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048598, this)) == null) {
            return getDomain().getURL() + "/phoenix/account/ssologin";
        }
        return (String) invokeV.objValue;
    }

    public boolean getDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        InterceptResult invokeLL;
        Context context;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048599, this, sapiCallBack, str)) == null) {
            SapiConfiguration sapiConfiguration = this.configuration;
            if (sapiConfiguration == null || (context = sapiConfiguration.context) == null) {
                return false;
            }
            if (!SapiUtils.hasActiveNetwork(context)) {
                if (sapiCallBack != null) {
                    sapiCallBack.onNetworkFailed();
                }
                return false;
            } else if (TextUtils.isEmpty(str)) {
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(257);
                }
                return false;
            } else {
                HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.put("username", str);
                new HttpClientWrap().post(SapiEnv.GET_DYNAMIC_PWD_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), sapiCallBack) { // from class: com.baidu.sapi2.SapiAccountRepository.9
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiAccountRepository this$0;
                    public final /* synthetic */ SapiCallBack val$callBack;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r8);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, r8, sapiCallBack};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callBack = sapiCallBack;
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFailure(Throwable th, int i, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str2) == null) {
                            if (i == -203) {
                                this.val$callBack.onSystemError(i);
                            } else {
                                this.this$0.handleGetDynamicPwd(this.val$callBack, str2);
                            }
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onSuccess(int i, String str2) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                            this.this$0.handleGetDynamicPwd(this.val$callBack, str2);
                        }
                    }
                });
                return true;
            }
        }
        return invokeLL.booleanValue;
    }

    public int getErrorCode(String str) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048600, this, str)) == null) {
            try {
                return new JSONObject(str).getInt("errno");
            } catch (Exception e) {
                Log.e(e);
                return -100;
            }
        }
        return invokeL.intValue;
    }

    public String getExplainCameraDeatilUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048601, this)) == null) {
            return getDomain().getWap() + SapiEnv.EXPLAIN_CAMERA_DETAIL;
        }
        return (String) invokeV.objValue;
    }

    public String getInvoiceAddressUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048602, this)) == null) {
            return getDomain().getWap() + "/v6/invoiceManage";
        }
        return (String) invokeV.objValue;
    }

    public String getLoadOneKeyLoginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048603, this)) == null) {
            return getDomain().getWap() + SapiEnv.LOAD_ONE_KEY_LOGIN;
        }
        return (String) invokeV.objValue;
    }

    public String getNormalizeGuestAccountUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048604, this)) == null) {
            return getDomain().getURL() + SapiEnv.NORMALIZE_GUEST_ACCOUNT_URI;
        }
        return (String) invokeV.objValue;
    }

    public String getOneKeyLoginAbilityUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048605, this)) == null) {
            return getDomain().getWap() + SapiEnv.ONE_KEY_LOGIN_ABILITY;
        }
        return (String) invokeV.objValue;
    }

    public void getOnlineAppShareModel(List<GetOnlineRequestShareModel> list, String str, GetOnlineAppCallback getOnlineAppCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLL(1048606, this, list, str, getOnlineAppCallback) == null) || getOnlineAppCallback == null || list == null || list.size() == 0) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("client", "android");
        httpHashMapWrap.put("clientfrom", "native");
        JSONArray jSONArray = new JSONArray();
        for (GetOnlineRequestShareModel getOnlineRequestShareModel : list) {
            jSONArray.put(GetOnlineRequestShareModel.parseModel2JsonObject(getOnlineRequestShareModel));
        }
        httpHashMapWrap.put("applist", jSONArray.toString());
        httpHashMapWrap.put("frominterflow", str);
        String onlineAppUrl = getOnlineAppUrl();
        new HttpClientWrap().post(onlineAppUrl, httpHashMapWrap, ParamsUtil.buildNaCookie(onlineAppUrl, this.configuration), getUaInfo(), new HttpHandlerWrap(this, getOnlineAppCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.24
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SapiAccountRepository this$0;
            public final /* synthetic */ GetOnlineAppCallback val$callback;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, getOnlineAppCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$callback = getOnlineAppCallback;
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str2) == null) {
                    Log.d(ShareUtils.TAG, "getOnlineAppShareModel fail responseBody=" + str2);
                    this.val$callback.onFailure();
                }
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str2) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                    Log.d(ShareUtils.TAG, "getOnlineAppShareModel success response=" + str2);
                    try {
                        JSONObject jSONObject = new JSONObject(str2);
                        if (jSONObject.optInt("errno") != 0) {
                            this.val$callback.onFailure();
                            return;
                        }
                        JSONObject optJSONObject = jSONObject.optJSONObject("data");
                        if (optJSONObject == null) {
                            this.val$callback.onFailure();
                            return;
                        }
                        JSONArray optJSONArray = optJSONObject.optJSONArray("applist");
                        if (optJSONArray == null) {
                            this.val$callback.onFailure();
                        } else {
                            this.val$callback.onSuccess(optJSONArray);
                        }
                    } catch (JSONException e) {
                        Log.e(SapiAccountRepository.TAG, e.getMessage());
                        this.val$callback.onFailure();
                    }
                }
            }
        });
    }

    public String getOnlineAppUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048607, this)) == null) {
            return getDomain().getURL() + SapiEnv.SHARE_LOGIN_GET_ONLINE_APP;
        }
        return (String) invokeV.objValue;
    }

    public void getShareV3App(String str, List<String> list, String str2, GetShareV3AppCallback getShareV3AppCallback) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLLLL(1048608, this, str, list, str2, getShareV3AppCallback) == null) || getShareV3AppCallback == null) {
            return;
        }
        HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
        httpHashMapWrap.put("client", "android");
        httpHashMapWrap.put("clientfrom", "native");
        httpHashMapWrap.put("tpl", str);
        StringBuilder sb = new StringBuilder();
        sb.append(PreferencesUtil.LEFT_MOUNT);
        for (String str3 : list) {
            sb.append("\"");
            sb.append(str3);
            sb.append("\"");
            sb.append(",");
        }
        StringBuilder deleteCharAt = sb.deleteCharAt(sb.length() - 1);
        deleteCharAt.append(PreferencesUtil.RIGHT_MOUNT);
        httpHashMapWrap.put("interflowPkgList", deleteCharAt.toString());
        httpHashMapWrap.put("currentAppPkg", str2);
        String shareV3AppUrl = getShareV3AppUrl();
        new HttpClientWrap().post(shareV3AppUrl, httpHashMapWrap, ParamsUtil.buildNaCookie(shareV3AppUrl, this.configuration), getUaInfo(), new HttpHandlerWrap(this, getShareV3AppCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.21
            public static /* synthetic */ Interceptable $ic;
            public transient /* synthetic */ FieldHolder $fh;
            public final /* synthetic */ SapiAccountRepository this$0;
            public final /* synthetic */ GetShareV3AppCallback val$callback;

            {
                Interceptable interceptable2 = $ic;
                if (interceptable2 != null) {
                    InitContext newInitContext = TitanRuntime.newInitContext();
                    newInitContext.initArgs = r2;
                    Object[] objArr = {this, getShareV3AppCallback};
                    interceptable2.invokeUnInit(65536, newInitContext);
                    int i = newInitContext.flag;
                    if ((i & 1) != 0) {
                        int i2 = i & 2;
                        newInitContext.thisArg = this;
                        interceptable2.invokeInitBody(65536, newInitContext);
                        return;
                    }
                }
                this.this$0 = this;
                this.val$callback = getShareV3AppCallback;
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onFailure(Throwable th, int i, String str4) {
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str4) == null) {
                    ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_FROM_NET_ERRCODE, Integer.valueOf(i));
                    Log.d(ShareUtils.TAG, "requestShareV3AppFromCloud fail responseBody=" + str4);
                    this.val$callback.onFailure();
                }
            }

            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
            public void onSuccess(int i, String str4) {
                JSONObject jSONObject;
                JSONObject optJSONObject;
                Interceptable interceptable2 = $ic;
                if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str4) == null) {
                    Log.d(ShareUtils.TAG, "requestShareV3AppFromCloud success response=" + str4);
                    ShareLoginStat.GetShareListStat.statExtMap.put(ShareLoginStat.GetShareListStat.KEY_FROM_NET_ERRCODE, Integer.valueOf(i));
                    JSONArray jSONArray = null;
                    try {
                        jSONObject = new JSONObject(str4);
                    } catch (JSONException e) {
                        Log.e(SapiAccountRepository.TAG, e.getMessage());
                        jSONObject = null;
                    }
                    if (jSONObject != null && (optJSONObject = jSONObject.optJSONObject("data")) != null) {
                        jSONArray = optJSONObject.optJSONArray("list");
                    }
                    if (jSONArray != null) {
                        ArrayList arrayList = new ArrayList();
                        for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                            ShareStorage.StorageModel fromJSON = ShareStorage.StorageModel.fromJSON(jSONArray.optJSONObject(i2));
                            if (fromJSON != null) {
                                arrayList.add(fromJSON);
                            }
                        }
                        SapiContext.getInstance().put(SapiContext.KEY_SHARE_MODELS_FROM_CLOUD_CACHE, jSONArray.toString());
                        this.val$callback.onSuccess(arrayList);
                        return;
                    }
                    this.val$callback.onFailure();
                }
            }
        });
    }

    public String getShareV3AppUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048609, this)) == null) {
            return getDomain().getURL() + SapiEnv.CLOUD_SHARE_V3_APP;
        }
        return (String) invokeV.objValue;
    }

    public String getSwitchAccountUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048610, this)) == null) {
            return getDomain().getWap() + SapiEnv.SWITCH_ACCOUNT;
        }
        return (String) invokeV.objValue;
    }

    public Map<String, String> getTplStoken(GetTplStokenCallback getTplStokenCallback, String str, List<String> list, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(1048611, this, new Object[]{getTplStokenCallback, str, list, Boolean.valueOf(z)})) == null) {
            long currentTimeMillis = System.currentTimeMillis();
            SapiUtils.notNull(getTplStokenCallback, GetTplStokenCallback.class.getSimpleName() + " can't be null");
            GetTplStokenResult getTplStokenResult = new GetTplStokenResult();
            if (list != null && !list.isEmpty()) {
                SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
                if (accountFromBduss == null) {
                    getTplStokenResult.setResultCode(-301);
                    getTplStokenCallback.onFailure(getTplStokenResult);
                    GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-301), GetTplStokenResult.ERROR_MSG_BDUSS_NOT_EXIST);
                    return getTplStokenResult.tplStokenMap;
                }
                String str2 = accountFromBduss.ptoken;
                if (isStokenExist(str, list)) {
                    try {
                        SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(accountFromBduss.extra));
                        Iterator<String> it = list.iterator();
                        while (true) {
                            if (!it.hasNext()) {
                                break;
                            }
                            String next = it.next();
                            if (fromJSONObject.tplStokenMap.containsKey(next)) {
                                getTplStokenResult.tplStokenMap.put(next, fromJSONObject.tplStokenMap.get(next));
                            } else {
                                getTplStokenResult.tplStokenMap.clear();
                                break;
                            }
                        }
                        if (!getTplStokenResult.tplStokenMap.isEmpty()) {
                            getTplStokenResult.setResultCode(0);
                            getTplStokenResult.setResultMsg("成功");
                            getTplStokenCallback.onSuccess(getTplStokenResult);
                            GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(0), "成功");
                            return getTplStokenResult.tplStokenMap;
                        }
                    } catch (JSONException e) {
                        Log.e(e);
                        getTplStokenResult.setResultCode(GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL);
                        getTplStokenCallback.onFailure(getTplStokenResult);
                        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf((int) GetTplStokenResult.ERROR_CODE_PARSE_DATA_FAIL), "服务端数据异常，请稍后再试");
                        return getTplStokenResult.tplStokenMap;
                    }
                }
                String str3 = list.get(0);
                for (int i = 1; i < list.size(); i++) {
                    str3 = str3 + "|" + list.get(i);
                }
                if (TextUtils.isEmpty(str2)) {
                    getTplStokenResult.setResultCode(-305);
                    getTplStokenResult.failureType = GetTplStokenResult.FailureType.PTOKEN_EMPTY;
                    getTplStokenCallback.onFailure(getTplStokenResult);
                }
                HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
                httpHashMapWrap.put("bduss", str);
                httpHashMapWrap.put("sign", SecurityUtil.md5((this.configuration.appId + this.configuration.tpl + str + this.configuration.appSignKey).getBytes(), false));
                httpHashMapWrap.put("return_type", "1");
                if (!TextUtils.isEmpty(str2)) {
                    httpHashMapWrap.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, str2);
                }
                httpHashMapWrap.put("tpl_list", str3);
                new HttpClientWrap().post(SapiEnv.GET_STOKEN_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), getTplStokenCallback, getTplStokenResult, accountFromBduss, list, z, currentTimeMillis, str2) { // from class: com.baidu.sapi2.SapiAccountRepository.7
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiAccountRepository this$0;
                    public final /* synthetic */ GetTplStokenCallback val$callback;
                    public final /* synthetic */ SapiAccount val$finalSession;
                    public final /* synthetic */ String val$ptoken;
                    public final /* synthetic */ GetTplStokenResult val$result;
                    public final /* synthetic */ boolean val$shouldValidate;
                    public final /* synthetic */ long val$startTimeMillis;
                    public final /* synthetic */ List val$targetTplList;

                    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                    {
                        super(r9);
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r3;
                            Object[] objArr = {this, r9, getTplStokenCallback, getTplStokenResult, accountFromBduss, list, Boolean.valueOf(z), Long.valueOf(currentTimeMillis), str2};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i2 = newInitContext.flag;
                            if ((i2 & 1) != 0) {
                                int i3 = i2 & 2;
                                super((Looper) newInitContext.callArgs[0]);
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$callback = getTplStokenCallback;
                        this.val$result = getTplStokenResult;
                        this.val$finalSession = accountFromBduss;
                        this.val$targetTplList = list;
                        this.val$shouldValidate = z;
                        this.val$startTimeMillis = currentTimeMillis;
                        this.val$ptoken = str2;
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFailure(Throwable th, int i2, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (!(interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i2, str4) == null) || TextUtils.isEmpty(this.val$ptoken)) {
                            return;
                        }
                        this.val$result.setResultCode(i2);
                        this.val$callback.onFailure(this.val$result);
                        GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - this.val$startTimeMillis), String.valueOf(i2), "网络连接失败，请检查网络设置");
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                            this.val$callback.onFinish();
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                            this.val$callback.onStart();
                        }
                    }

                    @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                    public void onSuccess(int i2, String str4) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i2, str4) == null) {
                            try {
                                JSONObject jSONObject = new JSONObject(str4);
                                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                                this.val$result.setResultCode(parseInt);
                                if (parseInt == 0) {
                                    Map<String, String> tplStokenMap = SapiAccount.DispersionCertification.getTplStokenMap(jSONObject.optJSONObject("stoken_list"));
                                    this.val$result.tplStokenMap = tplStokenMap;
                                    SapiAccount.ExtraProperty extraProperty = new SapiAccount.ExtraProperty();
                                    if (!TextUtils.isEmpty(this.val$finalSession.extra)) {
                                        extraProperty = SapiAccount.ExtraProperty.fromJSONObject(new JSONObject(this.val$finalSession.extra));
                                    }
                                    extraProperty.dispersionCertification.tplStokenMap.putAll(tplStokenMap);
                                    this.val$finalSession.extra = extraProperty.toJSONObject().toString();
                                    if (this.val$targetTplList.size() == tplStokenMap.size()) {
                                        if (this.val$shouldValidate) {
                                            SapiAccountManager.getInstance().validate(this.val$finalSession);
                                        } else {
                                            SapiContext.getInstance().setCurrentAccount(this.val$finalSession);
                                            SapiContext.getInstance().addLoginAccount(this.val$finalSession);
                                            new ShareCallPacking().asyncMarkLoginState(5);
                                        }
                                        this.val$callback.onSuccess(this.val$result);
                                        return;
                                    }
                                    this.val$result.setResultCode(-306);
                                    this.val$callback.onFailure(this.val$result);
                                    GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - this.val$startTimeMillis), String.valueOf(-306), "服务端数据异常，请稍后再试");
                                } else if (parseInt != 8) {
                                    if (TextUtils.isEmpty(this.val$ptoken)) {
                                        return;
                                    }
                                    String optString = jSONObject.optString("errmsg");
                                    this.val$result.setResultMsg(optString);
                                    this.val$callback.onFailure(this.val$result);
                                    GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - this.val$startTimeMillis), String.valueOf(i2), optString);
                                } else if (TextUtils.isEmpty(this.val$ptoken)) {
                                } else {
                                    String optString2 = jSONObject.optString("ssnerror");
                                    if (TextUtils.isEmpty(optString2)) {
                                        optString2 = "0";
                                    }
                                    int parseInt2 = Integer.parseInt(optString2);
                                    if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH.ordinal()) {
                                        this.val$result.failureType = GetTplStokenResult.FailureType.BDUSS_PTOKEN_NOT_MATCH;
                                    } else if (parseInt2 == GetTplStokenResult.FailureType.BDUSS_EXPIRED.ordinal()) {
                                        this.val$result.failureType = GetTplStokenResult.FailureType.BDUSS_EXPIRED;
                                    }
                                    String optString3 = jSONObject.optString("errmsg");
                                    this.val$result.setResultMsg(optString3);
                                    this.val$callback.onFailure(this.val$result);
                                    GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - this.val$startTimeMillis), String.valueOf(8), optString3);
                                }
                            } catch (Exception e2) {
                                Log.e(e2);
                                if (TextUtils.isEmpty(this.val$ptoken)) {
                                    return;
                                }
                                this.val$result.setResultCode(-205);
                                this.val$callback.onFailure(this.val$result);
                                GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - this.val$startTimeMillis), String.valueOf(-205), "服务端数据异常，请稍后再试");
                            }
                        }
                    }
                });
                return getTplStokenResult.tplStokenMap;
            }
            getTplStokenResult.setResultCode(-302);
            getTplStokenResult.setResultMsg("参数错误，请稍后再试");
            getTplStokenCallback.onFailure(getTplStokenResult);
            GetTplStokenStat.onEventAutoStat(String.valueOf(System.currentTimeMillis() - currentTimeMillis), String.valueOf(-302), "参数错误，请稍后再试");
            return getTplStokenResult.tplStokenMap;
        }
        return (Map) invokeCommon.objValue;
    }

    public String getUniteVerifyUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048612, this)) == null) {
            return getDomain().getWap() + "/wp/unitewidget";
        }
        return (String) invokeV.objValue;
    }

    public void getUserInfo(GetUserInfoCallback getUserInfoCallback, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048613, this, getUserInfoCallback, str) == null) {
            SapiUtils.notNull(getUserInfoCallback, GetUserInfoCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notEmpty(str, "bduss can't be empty");
            SapiAccount accountFromBduss = SapiContext.getInstance().getAccountFromBduss(str);
            getUserInfo(str, accountFromBduss != null ? accountFromBduss.ptoken : null, new NetCallback(this, getUserInfoCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.4
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ GetUserInfoCallback val$callback;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, getUserInfoCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = getUserInfoCallback;
                }

                @Override // com.baidu.sapi2.callback.NetCallback
                public void onFailure(Throwable th, int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str2) == null) {
                        GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
                        getUserInfoResult.setResultCode(i);
                        this.val$callback.onFailure(getUserInfoResult);
                    }
                }

                @Override // com.baidu.sapi2.callback.NetCallback
                public void onSuccess(int i, String str2) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str2) == null) {
                        GetUserInfoResult getUserInfoResult = new GetUserInfoResult();
                        int errorCode = this.this$0.getErrorCode(str2);
                        getUserInfoResult.setResultCode(errorCode);
                        if (errorCode != 0) {
                            if (errorCode != 400021) {
                                this.val$callback.onFailure(getUserInfoResult);
                                return;
                            } else {
                                this.val$callback.onBdussExpired(getUserInfoResult);
                                return;
                            }
                        }
                        try {
                            JSONObject jSONObject = new JSONObject(str2);
                            String optString = jSONObject.optString("portrait_tag");
                            getUserInfoResult.portraitSign = optString;
                            getUserInfoResult.isInitialPortrait = "0".equals(optString);
                            String optString2 = jSONObject.optString("portrait");
                            if (!TextUtils.isEmpty(optString2)) {
                                getUserInfoResult.portrait = String.format("http://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString2, getUserInfoResult.portraitSign);
                                getUserInfoResult.portraitHttps = String.format("https://himg.bdimg.com/sys/portrait/item/%s.jpg?%s", optString2, getUserInfoResult.portraitSign);
                            }
                            getUserInfoResult.username = jSONObject.optString("username");
                            getUserInfoResult.uid = jSONObject.optString(DpStatConstants.KEY_USER_ID);
                            getUserInfoResult.displayname = jSONObject.optString("displayname");
                            getUserInfoResult.incompleteUser = "1".equals(jSONObject.optString("incomplete_user"));
                            getUserInfoResult.secureMobile = jSONObject.optString("securemobil");
                            getUserInfoResult.secureEmail = jSONObject.optString("secureemail");
                            getUserInfoResult.havePwd = "1".equals(jSONObject.optString("have_psw"));
                            getUserInfoResult.carSdkFace = jSONObject.optInt("carSdkFace");
                            getUserInfoResult.faceLoginSwitch = jSONObject.optInt("faceLoginSwitch");
                            this.val$callback.onSuccess(getUserInfoResult);
                        } catch (Exception unused) {
                            this.val$callback.onFailure(getUserInfoResult);
                        }
                    }
                }
            });
        }
    }

    public String getWapForgetPwdUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048615, this)) == null) {
            return getDomain().getWap() + "/passport/getpass";
        }
        return (String) invokeV.objValue;
    }

    public String getWapLoginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048616, this)) == null) {
            return getDomain().getWap() + "/passport/login";
        }
        return (String) invokeV.objValue;
    }

    public String getWapShareLoginUrl() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(1048617, this)) == null) {
            return getDomain().getWap() + "/v3/login/api/login";
        }
        return (String) invokeV.objValue;
    }

    public void handleDynamicPwdLogin(int i, SapiCallBack<SapiAccountResponse> sapiCallBack, String str, boolean z, SapiDataEncryptor sapiDataEncryptor) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeCommon(1048618, this, new Object[]{Integer.valueOf(i), sapiCallBack, str, Boolean.valueOf(z), sapiDataEncryptor}) == null) {
            if (str == null) {
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(i);
                    return;
                }
                return;
            }
            SapiAccountResponse sapiAccountResponse = new SapiAccountResponse();
            try {
                String optString = new JSONObject(str).optString(TableDefine.DB_TABLE_USERINFO);
                JSONObject jSONObject = null;
                if (!TextUtils.isEmpty(optString)) {
                    jSONObject = new JSONObject(sapiDataEncryptor.decrypt(optString));
                    sapiAccountResponse.displayname = jSONObject.optString("displayname");
                    sapiAccountResponse.username = jSONObject.optString("uname");
                    sapiAccountResponse.uid = jSONObject.optString("uid");
                    sapiAccountResponse.email = jSONObject.optString("email");
                    sapiAccountResponse.bduss = jSONObject.optString("bduss");
                    sapiAccountResponse.ptoken = jSONObject.optString(SapiAccount.SAPI_ACCOUNT_PTOKEN);
                    sapiAccountResponse.stoken = jSONObject.optString("stoken");
                    sapiAccountResponse.authSid = jSONObject.optString("authsid");
                }
                if (sapiCallBack != null) {
                    if (i != 0) {
                        sapiCallBack.onSystemError(i);
                        return;
                    }
                    if (z) {
                        SapiAccount responseToAccount = responseToAccount(sapiAccountResponse);
                        responseToAccount.addDispersionCertification(SapiAccount.DispersionCertification.fromJSONObject(jSONObject).tplStokenMap);
                        responseToAccount.putExtra("tpl", this.configuration.tpl);
                        SapiAccountManager.getInstance().validate(responseToAccount);
                    }
                    sapiCallBack.onSuccess(sapiAccountResponse);
                }
            } catch (Exception e) {
                Log.e(e);
                if (sapiCallBack != null) {
                    sapiCallBack.onSystemError(-100);
                }
            }
        }
    }

    public void handleGetDynamicPwd(SapiCallBack<SapiResponse> sapiCallBack, String str) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLL(1048619, this, sapiCallBack, str) == null) {
            try {
                JSONObject jSONObject = new JSONObject(str);
                EnhancedService.smsCodeLength = jSONObject.optInt("smsCodeLength", 6);
                int parseInt = Integer.parseInt(jSONObject.optString("errno"));
                if (parseInt != 0) {
                    sapiCallBack.onSystemError(parseInt);
                    return;
                }
                SapiResponse sapiResponse = new SapiResponse();
                sapiResponse.errorCode = parseInt;
                sapiResponse.errorMsg = "短信验证码发送成功";
                sapiCallBack.onSuccess(sapiResponse);
            } catch (Exception unused) {
                sapiCallBack.onSystemError(-100);
            }
        }
    }

    public void iqiyiSSOLogin(IqiyiLoginCallback iqiyiLoginCallback, IqiyiLoginDTO iqiyiLoginDTO) {
        Interceptable interceptable = $ic;
        if (!(interceptable == null || interceptable.invokeLL(1048620, this, iqiyiLoginCallback, iqiyiLoginDTO) == null) || iqiyiLoginCallback == null) {
            return;
        }
        iqiyiLoginCallback.onStart();
        String str = iqiyiLoginDTO.accessToken;
        String str2 = iqiyiLoginDTO.phoneNum;
        String str3 = iqiyiLoginDTO.openID;
        IqiyiLoginResult iqiyiLoginResult = new IqiyiLoginResult();
        SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
        boolean z = (TextUtils.isEmpty(str) || TextUtils.isEmpty(str3)) ? false : true;
        if (!z && currentAccount == null) {
            iqiyiLoginCallback.onLogin(iqiyiLoginResult);
        } else if (z && currentAccount == null) {
            getThroughServer(iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult);
        } else {
            SapiAccountManager.getInstance().getAccountService().getUserInfo(new GetUserInfoCallback(this, iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult, str2) { // from class: com.baidu.sapi2.SapiAccountRepository.10
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ IqiyiLoginCallback val$callback;
                public final /* synthetic */ IqiyiLoginDTO val$iqiyiLoginDTO;
                public final /* synthetic */ IqiyiLoginResult val$iqiyiLoginResult;
                public final /* synthetic */ String val$phoneNum;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, iqiyiLoginCallback, iqiyiLoginDTO, iqiyiLoginResult, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = iqiyiLoginCallback;
                    this.val$iqiyiLoginDTO = iqiyiLoginDTO;
                    this.val$iqiyiLoginResult = iqiyiLoginResult;
                    this.val$phoneNum = str2;
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                    }
                }

                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.LoginStatusAware
                public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, getUserInfoResult) == null) {
                        this.this$0.getThroughServer(this.val$callback, this.val$iqiyiLoginDTO, this.val$iqiyiLoginResult);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onFailure(GetUserInfoResult getUserInfoResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                        this.val$iqiyiLoginResult.setResultCode(getUserInfoResult.getResultCode());
                        this.val$iqiyiLoginResult.setResultMsg(getUserInfoResult.getResultMsg());
                        this.val$callback.onFailure(this.val$iqiyiLoginResult);
                    }
                }

                /* JADX DEBUG: Method merged with bridge method */
                @Override // com.baidu.sapi2.callback.SapiCallback
                public void onSuccess(GetUserInfoResult getUserInfoResult) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048582, this, getUserInfoResult) == null) {
                        String str4 = getUserInfoResult.secureMobile;
                        boolean z2 = getUserInfoResult.incompleteUser;
                        if (!TextUtils.isEmpty(str4)) {
                            this.val$callback.onSuccess(this.val$iqiyiLoginResult);
                        } else if (z2) {
                            this.this$0.getThroughServer(this.val$callback, this.val$iqiyiLoginDTO, this.val$iqiyiLoginResult);
                        } else if (!TextUtils.isEmpty(this.val$phoneNum)) {
                            this.this$0.getThroughServer(this.val$callback, this.val$iqiyiLoginDTO, this.val$iqiyiLoginResult);
                        } else {
                            this.val$callback.onSuccess(this.val$iqiyiLoginResult);
                        }
                    }
                }
            }, currentAccount.bduss);
        }
    }

    public boolean isAccountStokenExist(SapiAccount sapiAccount, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048621, this, sapiAccount, list)) == null) {
            if (sapiAccount != null && !TextUtils.isEmpty(sapiAccount.extra)) {
                try {
                    SapiAccount.DispersionCertification fromJSONObject = SapiAccount.DispersionCertification.fromJSONObject(new JSONObject(sapiAccount.extra));
                    for (String str : list) {
                        if (!fromJSONObject.tplStokenMap.containsKey(str)) {
                            return false;
                        }
                    }
                    return true;
                } catch (JSONException e) {
                    Log.e(e);
                }
            }
            return false;
        }
        return invokeLL.booleanValue;
    }

    public boolean isStokenExist(String str, List<String> list) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(1048622, this, str, list)) == null) {
            SapiUtils.notEmpty(str, "bduss can't be empty");
            if (list != null && !list.isEmpty()) {
                return isAccountStokenExist(SapiContext.getInstance().getAccountFromBduss(str), list);
            }
            throw new IllegalArgumentException("targetTplList can't be null or empty");
        }
        return invokeLL.booleanValue;
    }

    public void loadOneKeyLogin(OneKeyLoginCallback oneKeyLoginCallback, String str, String str2, LoadExternalWebViewActivityCallback loadExternalWebViewActivityCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048623, this, oneKeyLoginCallback, str, str2, loadExternalWebViewActivityCallback) == null) {
            JSONObject jSONObject = new JSONObject();
            try {
                String operatorType = new OneKeyLoginSdkCall().getOperatorType();
                jSONObject.put("token", str);
                jSONObject.put("tpl", this.configuration.tpl);
                jSONObject.put("client", "android");
                jSONObject.put("clientfrom", "native");
                jSONObject.put("appid", OneKeyLoginSdkCall.oneKeyLoginAppKey);
                jSONObject.put("operator", operatorType);
                jSONObject.put("scene", RetrieveTaskManager.KEY);
                jSONObject.put("sign", str2);
                if (OneKeyLoginSdkCall.OPERATOR_TYPE_CUCC.equals(operatorType)) {
                    jSONObject.put("CUVersion", "2");
                }
            } catch (JSONException e) {
                Log.e(e);
            }
            String oneKeyLoginJsCode = SapiContext.getInstance().getOneKeyLoginJsCode();
            String str3 = OneKeyLoginResult.secondJsCode;
            long currentTimeMillis = System.currentTimeMillis();
            OneKeyLoginStat.LoadLogin.statExtMap.put("netType", SapiUtils.getNetworkClass(this.configuration.context));
            OneKeyLoginStat.LoadLogin.statExtMap.put("operator", gd1.c().b(this.configuration.context));
            SapiCoreUtil.executeJsCode(oneKeyLoginJsCode, str3, jSONObject.toString(), this.configuration.context, new ExecuteJsCallback(this, currentTimeMillis, oneKeyLoginCallback, loadExternalWebViewActivityCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.19
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ OneKeyLoginCallback val$callback;
                public final /* synthetic */ LoadExternalWebViewActivityCallback val$innerCallback;
                public final /* synthetic */ long val$startTime;

                {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, Long.valueOf(currentTimeMillis), oneKeyLoginCallback, loadExternalWebViewActivityCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$startTime = currentTimeMillis;
                    this.val$callback = oneKeyLoginCallback;
                    this.val$innerCallback = loadExternalWebViewActivityCallback;
                }

                @Override // com.baidu.sapi2.callback.inner.ExecuteJsCallback
                public void jsExecuteCompleted(String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeL(1048576, this, str4) == null) {
                        OneKeyLoginStat.OauthToken.statExtMap.put(OneKeyLoginStat.LoadLogin.KEY_EXT_DUR_JS, Long.valueOf(System.currentTimeMillis() - this.val$startTime));
                        JSONObject jSONObject2 = null;
                        if (TextUtils.isEmpty(str4)) {
                            Log.e(SapiAccountRepository.TAG, "oneKeyLogin execute JavaScript failed, it only support after KitKat version");
                            new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.val$callback, -107, null);
                            SapiStatUtil.statOneKeyLoginPassAction(-1, MusicData.MUSIC_NORMAL_ID, "js execute fail");
                            OneKeyLoginStat.LoadLogin.statExtMap.put("code", -107);
                            OneKeyLoginStat.LoadLogin.sValue = "0";
                            OneKeyLoginStat.LoadLogin.upload();
                            return;
                        }
                        try {
                            jSONObject2 = new JSONObject(str4);
                        } catch (JSONException e2) {
                            OneKeyLoginStat.LoadLogin.statExtMap.put("code", "JSONException");
                            OneKeyLoginStat.LoadLogin.sValue = "0";
                            OneKeyLoginStat.LoadLogin.upload();
                            Log.e(e2);
                        }
                        HttpHashMap httpHashMap = new HttpHashMap();
                        if (jSONObject2 != null) {
                            Iterator<String> keys = jSONObject2.keys();
                            while (keys.hasNext()) {
                                String next = keys.next();
                                httpHashMap.put(next, jSONObject2.optString(next));
                            }
                        }
                        httpHashMap.put("oneKeySdkVersion", DefaultDiskStorage.DEFAULT_DISK_STORAGE_VERSION_PREFIX);
                        httpHashMap.put("yyNormalOneKey", "1");
                        String loadOneKeyLoginUrl = this.this$0.getLoadOneKeyLoginUrl();
                        new HttpClientWrap().post(loadOneKeyLoginUrl, httpHashMap, ParamsUtil.buildNaCookie(loadOneKeyLoginUrl, this.this$0.configuration), this.this$0.getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), System.currentTimeMillis()) { // from class: com.baidu.sapi2.SapiAccountRepository.19.1
                            public static /* synthetic */ Interceptable $ic;
                            public transient /* synthetic */ FieldHolder $fh;
                            public final /* synthetic */ AnonymousClass19 this$1;
                            public final /* synthetic */ long val$loginStartTime;

                            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                            {
                                super(r8);
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 != null) {
                                    InitContext newInitContext = TitanRuntime.newInitContext();
                                    newInitContext.initArgs = r2;
                                    Object[] objArr = {this, r8, Long.valueOf(r9)};
                                    interceptable3.invokeUnInit(65536, newInitContext);
                                    int i = newInitContext.flag;
                                    if ((i & 1) != 0) {
                                        int i2 = i & 2;
                                        super((Looper) newInitContext.callArgs[0]);
                                        newInitContext.thisArg = this;
                                        interceptable3.invokeInitBody(65536, newInitContext);
                                        return;
                                    }
                                }
                                this.this$1 = this;
                                this.val$loginStartTime = r9;
                            }

                            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                            public void onFailure(Throwable th, int i, String str5) {
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeLIL(1048576, this, th, i, str5) == null) {
                                    OneKeyLoginStat.LoadLogin.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - this.val$loginStartTime));
                                    OneKeyLoginStat.LoadLogin.statExtMap.put("code", Integer.valueOf(i));
                                    OneKeyLoginStat.LoadLogin.sValue = "0";
                                    OneKeyLoginStat.LoadLogin.upload();
                                    String str6 = SapiAccountRepository.TAG;
                                    Log.d(str6, "onFailure, error = " + th + ", errorCode = " + i + ", responseBody = " + str5);
                                    new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.this$1.val$callback, -100, null);
                                    SapiStatUtil.statOneKeyLoginPassAction(0, "-114", "net error");
                                }
                            }

                            /* JADX WARN: Removed duplicated region for block: B:45:0x012c A[Catch: Exception -> 0x0160, TryCatch #0 {Exception -> 0x0160, blocks: (B:5:0x0043, B:8:0x006e, B:10:0x007b, B:12:0x009e, B:11:0x0092, B:14:0x00a2, B:17:0x00ac, B:19:0x00b4, B:22:0x00bd, B:24:0x00c5, B:27:0x00ce, B:29:0x00d6, B:31:0x00dc, B:32:0x00e2, B:34:0x00f6, B:36:0x010a, B:38:0x0110, B:43:0x0126, B:45:0x012c, B:47:0x015c, B:46:0x0145, B:40:0x0119, B:42:0x011f), top: B:55:0x0043 }] */
                            /* JADX WARN: Removed duplicated region for block: B:46:0x0145 A[Catch: Exception -> 0x0160, TryCatch #0 {Exception -> 0x0160, blocks: (B:5:0x0043, B:8:0x006e, B:10:0x007b, B:12:0x009e, B:11:0x0092, B:14:0x00a2, B:17:0x00ac, B:19:0x00b4, B:22:0x00bd, B:24:0x00c5, B:27:0x00ce, B:29:0x00d6, B:31:0x00dc, B:32:0x00e2, B:34:0x00f6, B:36:0x010a, B:38:0x0110, B:43:0x0126, B:45:0x012c, B:47:0x015c, B:46:0x0145, B:40:0x0119, B:42:0x011f), top: B:55:0x0043 }] */
                            @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                            /*
                                Code decompiled incorrectly, please refer to instructions dump.
                            */
                            public void onSuccess(int i, String str5, HashMap<String, String> hashMap) {
                                String optString;
                                Interceptable interceptable3 = $ic;
                                if (interceptable3 == null || interceptable3.invokeILL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str5, hashMap) == null) {
                                    OneKeyLoginStat.LoadLogin.statExtMap.put("dur", Long.valueOf(System.currentTimeMillis() - this.val$loginStartTime));
                                    Log.d(SapiAccountRepository.TAG, "onSuccess, statusCode = " + i + ", response = " + str5);
                                    try {
                                        JSONObject jSONObject3 = new JSONObject(str5);
                                        JSONObject optJSONObject = jSONObject3.optJSONObject("errInfo");
                                        String optString2 = optJSONObject.optString("no");
                                        String optString3 = optJSONObject.optString("msg");
                                        SapiStatUtil.statOneKeyLoginPassAction(0, optString2, optString3);
                                        OneKeyLoginStat.LoadLogin.statExtMap.put("code", optString2);
                                        OneKeyLoginStat.LoadLogin.sValue = "1";
                                        if ("0".equals(optString2)) {
                                            this.this$1.this$0.setOneKeyLoginCookies(hashMap);
                                            JSONObject optJSONObject2 = jSONObject3.optJSONObject("data");
                                            if (optJSONObject2 != null) {
                                                SapiAccountManager.getInstance().getAccountService().handleOneKeyLoginResult(this.this$1.val$callback, optJSONObject2.optString("xml"));
                                            } else {
                                                new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.this$1.val$callback, -100, null);
                                            }
                                            OneKeyLoginStat.LoadLogin.upload();
                                            return;
                                        }
                                        if (!"400101".equals(optString2) && !"400031".equals(optString2) && !"400023".equals(optString2)) {
                                            if (!"400704".equals(optString2) && !"400706".equals(optString2)) {
                                                if ("400801".equals(optString2)) {
                                                    JSONObject optJSONObject3 = jSONObject3.optJSONObject("data");
                                                    new OneKeyLoginSdkCall().transMobile(this.this$1.val$callback, Integer.parseInt(optString2), optJSONObject3 != null ? optJSONObject3.optString("mobile") : "");
                                                    OneKeyLoginStat.LoadLogin.upload();
                                                    return;
                                                }
                                                new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.this$1.val$callback, Integer.parseInt(optString2), optString3);
                                                OneKeyLoginStat.LoadLogin.upload();
                                                return;
                                            }
                                            JSONObject optJSONObject4 = jSONObject3.optJSONObject("data");
                                            if (optJSONObject4 != null) {
                                                optString = optJSONObject4.optString("ppDatau");
                                                if (TextUtils.isEmpty(optString)) {
                                                    OneKeyLoginResult oneKeyLoginResult = new OneKeyLoginResult();
                                                    oneKeyLoginResult.setResultCode(-104);
                                                    this.this$1.val$callback.onGuideProcess(oneKeyLoginResult);
                                                    this.this$1.val$innerCallback.needLoadExternalWebView("", optString);
                                                } else {
                                                    new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.this$1.val$callback, -100, null);
                                                    OneKeyLoginStat.LoadLogin.statExtMap.put("code", -100);
                                                    OneKeyLoginStat.LoadLogin.sValue = "0";
                                                }
                                                OneKeyLoginStat.LoadLogin.upload();
                                            }
                                            optString = null;
                                            if (TextUtils.isEmpty(optString)) {
                                            }
                                            OneKeyLoginStat.LoadLogin.upload();
                                        }
                                        JSONObject optJSONObject5 = jSONObject3.optJSONObject("data");
                                        if (optJSONObject5 != null) {
                                            optString = optJSONObject5.optString("verifyUrl");
                                            if (TextUtils.isEmpty(optString)) {
                                            }
                                            OneKeyLoginStat.LoadLogin.upload();
                                        }
                                        optString = null;
                                        if (TextUtils.isEmpty(optString)) {
                                        }
                                        OneKeyLoginStat.LoadLogin.upload();
                                    } catch (Exception e3) {
                                        Log.e(e3);
                                        new OneKeyLoginSdkCall().loadOneKeyLoginFail(this.this$1.val$callback, -100, null);
                                        SapiStatUtil.statOneKeyLoginPassAction(0, "-113", "json error");
                                        OneKeyLoginStat.LoadLogin.statExtMap.put("code", e3.getMessage());
                                        OneKeyLoginStat.LoadLogin.sValue = "0";
                                        OneKeyLoginStat.LoadLogin.upload();
                                    }
                                }
                            }
                        });
                    }
                }
            });
        }
    }

    public void oauth(SapiCallback<OAuthResult> sapiCallback, String str, String str2, String str3) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLLL(1048624, this, sapiCallback, str, str2, str3) == null) {
            SapiUtils.notNull(sapiCallback, SapiCallback.class.getSimpleName() + " can't be null");
            SapiUtils.notEmpty(str, "bduss can't be empty");
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            if (!TextUtils.isEmpty(str2)) {
                httpHashMapWrap.put("openPlatformId", str2);
            }
            httpHashMapWrap.put("bduss", str);
            if (!TextUtils.isEmpty(str3)) {
                httpHashMapWrap.put("scope", str3);
            }
            new HttpClientWrap().post(SapiEnv.OAUTH_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), sapiCallback, str, str2) { // from class: com.baidu.sapi2.SapiAccountRepository.8
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ String val$bduss;
                public final /* synthetic */ SapiCallback val$callback;
                public final /* synthetic */ String val$openPlatformId;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, sapiCallback, str, str2};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = sapiCallback;
                    this.val$bduss = str;
                    this.val$openPlatformId = str2;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str4) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str4) == null) {
                        String str5 = SapiAccountRepository.TAG;
                        Log.d(str5, "oauth failure: code=" + i + " body=" + str4);
                        OAuthResult oAuthResult = new OAuthResult();
                        oAuthResult.setResultCode(i);
                        this.val$callback.onFailure(oAuthResult);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFinish() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        this.val$callback.onFinish();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_SEND_USER_MSG, this) == null) {
                        this.val$callback.onStart();
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str4) {
                    JSONObject jSONObject;
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(1048579, this, i, str4) == null) {
                        String str5 = SapiAccountRepository.TAG;
                        Log.d(str5, "oauth success: " + str4);
                        try {
                            jSONObject = new JSONObject(str4);
                        } catch (JSONException e) {
                            String str6 = SapiAccountRepository.TAG;
                            Log.e(str6, "formatOauthResult: " + e.getMessage());
                            jSONObject = null;
                        }
                        if (jSONObject != null) {
                            try {
                                jSONObject.put("extra", str4);
                                jSONObject.put("cachedTimeSecond", System.currentTimeMillis() / 1000);
                            } catch (JSONException e2) {
                                String str7 = SapiAccountRepository.TAG;
                                Log.e(str7, "" + e2.getMessage());
                            }
                        }
                        OAuthResult formatOauthResult = this.this$0.formatOauthResult(jSONObject);
                        if (jSONObject != null && formatOauthResult != null) {
                            if (formatOauthResult.getResultCode() == 0) {
                                SapiContext.getInstance().put(this.this$0.getAccessTokenCacheKey(this.val$bduss, this.val$openPlatformId), jSONObject.toString());
                                this.val$callback.onSuccess(formatOauthResult);
                                return;
                            }
                            this.val$callback.onFailure(formatOauthResult);
                            return;
                        }
                        OAuthResult oAuthResult = new OAuthResult();
                        oAuthResult.setResultCode(-202);
                        this.val$callback.onFailure(oAuthResult);
                    }
                }
            });
        }
    }

    public void oauthAccessToken(SapiCallback<OAuthResult> sapiCallback, String str, String str2) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048625, this, sapiCallback, str, str2) == null) {
            OAuthResult cachedOauthResult = getCachedOauthResult(str, str2);
            if (cachedOauthResult != null) {
                sapiCallback.onSuccess(cachedOauthResult);
            } else {
                oauth(sapiCallback, str, str2, null);
            }
        }
    }

    public SapiAccount responseToAccount(SapiAccountResponse sapiAccountResponse) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(1048626, this, sapiAccountResponse)) == null) {
            SapiAccount sapiAccount = new SapiAccount();
            sapiAccount.displayname = sapiAccountResponse.displayname;
            sapiAccount.bduss = sapiAccountResponse.bduss;
            sapiAccount.ptoken = sapiAccountResponse.ptoken;
            sapiAccount.stoken = sapiAccountResponse.stoken;
            sapiAccount.uid = sapiAccountResponse.uid;
            sapiAccount.username = sapiAccountResponse.username;
            sapiAccount.app = SapiUtils.getAppName(this.configuration.context);
            return sapiAccount;
        }
        return (SapiAccount) invokeL.objValue;
    }

    public void setCloudShareAccount(int i, ShareStorage.StorageModel storageModel) {
        SapiAccount currentAccount;
        Interceptable interceptable = $ic;
        if ((interceptable == null || interceptable.invokeIL(1048627, this, i, storageModel) == null) && SapiContext.getInstance().getSapiOptions().gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_SHARE_V3).meetGray) {
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            if (i == 2) {
                httpHashMapWrap.put("cmd", "insert");
            } else if (i == 3) {
                httpHashMapWrap.put("cmd", "delete");
            } else if (i != 4) {
                return;
            } else {
                httpHashMapWrap.put("cmd", "reset");
            }
            if (i == 2 && storageModel.flag == 0 && (currentAccount = SapiContext.getInstance().getCurrentAccount()) != null) {
                httpHashMapWrap.put("bduss", currentAccount.bduss);
                httpHashMapWrap.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, currentAccount.ptoken);
                httpHashMapWrap.put("stoken", currentAccount.stoken);
            }
            httpHashMapWrap.put("app", SapiUtils.getAppName(this.configuration.context));
            httpHashMapWrap.put("pkg", this.configuration.context.getPackageName());
            new HttpClientWrap().post(SapiEnv.CLOUND_SHARE_ACCOUNT, ReqPriority.IMMEDIATE, httpHashMapWrap, new HttpHandlerWrap(this, Looper.getMainLooper(), i) { // from class: com.baidu.sapi2.SapiAccountRepository.22
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ int val$shareEvent;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, Integer.valueOf(i)};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i2 = newInitContext.flag;
                        if ((i2 & 1) != 0) {
                            int i3 = i2 & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$shareEvent = i;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i2, str) == null) {
                        SapiStatUtil.statSetCloudShareAccount(this.val$shareEvent, 2);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onStart() {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeV(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this) == null) {
                        Log.d(SapiAccountRepository.TAG, "set clound share account start");
                        SapiStatUtil.statSetCloudShareAccount(this.val$shareEvent, 0);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i2, String str) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_SEND_USER_MSG, this, i2, str) == null) {
                        try {
                            if (new JSONObject(str).optInt("code") == 110000) {
                                SapiStatUtil.statSetCloudShareAccount(this.val$shareEvent, 1);
                                return;
                            }
                        } catch (Exception e) {
                            Log.e(e);
                        }
                        SapiStatUtil.statSetCloudShareAccount(this.val$shareEvent, 2);
                    }
                }
            });
        }
    }

    public void web2NativeLogin(Web2NativeLoginCallback web2NativeLoginCallback, boolean z) {
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLZ(1048628, this, web2NativeLoginCallback, z) == null) {
            SapiUtils.notNull(web2NativeLoginCallback, Web2NativeLoginCallback.class.getSimpleName() + " can't be null");
            Web2NativeLoginResult web2NativeLoginResult = new Web2NativeLoginResult();
            String cookieBduss = SapiUtils.getCookieBduss();
            String cookiePtoken = SapiUtils.getCookiePtoken();
            if (TextUtils.isEmpty(cookieBduss)) {
                web2NativeLoginResult.setResultCode(-101);
                web2NativeLoginCallback.onBdussEmpty(web2NativeLoginResult);
                return;
            }
            SapiAccount currentAccount = SapiContext.getInstance().getCurrentAccount();
            String str2 = "";
            if (currentAccount != null) {
                str2 = currentAccount.bduss;
                str = currentAccount.ptoken;
            } else {
                str = "";
            }
            if (cookieBduss.equals(str2) && !TextUtils.isEmpty(cookiePtoken) && cookiePtoken.equals(str)) {
                web2NativeLoginResult.setResultCode(0);
                web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
            } else if (SapiAccountManager.getInstance().isLogin() && !z) {
                SapiAccount currentAccount2 = SapiContext.getInstance().getCurrentAccount();
                if (!cookieBduss.equals(currentAccount2.bduss)) {
                    SapiAccountManager.getInstance().getAccountService().webLogin(this.configuration.context, currentAccount2.bduss);
                }
                web2NativeLoginResult.setResultCode(0);
                web2NativeLoginCallback.onSuccess(web2NativeLoginResult);
            } else {
                getUserInfo(new GetUserInfoCallback(this, web2NativeLoginResult, web2NativeLoginCallback, cookieBduss, cookiePtoken) { // from class: com.baidu.sapi2.SapiAccountRepository.1
                    public static /* synthetic */ Interceptable $ic;
                    public transient /* synthetic */ FieldHolder $fh;
                    public final /* synthetic */ SapiAccountRepository this$0;
                    public final /* synthetic */ String val$bduss;
                    public final /* synthetic */ Web2NativeLoginCallback val$callback;
                    public final /* synthetic */ String val$ptoken;
                    public final /* synthetic */ Web2NativeLoginResult val$result;

                    {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 != null) {
                            InitContext newInitContext = TitanRuntime.newInitContext();
                            newInitContext.initArgs = r2;
                            Object[] objArr = {this, web2NativeLoginResult, web2NativeLoginCallback, cookieBduss, cookiePtoken};
                            interceptable2.invokeUnInit(65536, newInitContext);
                            int i = newInitContext.flag;
                            if ((i & 1) != 0) {
                                int i2 = i & 2;
                                newInitContext.thisArg = this;
                                interceptable2.invokeInitBody(65536, newInitContext);
                                return;
                            }
                        }
                        this.this$0 = this;
                        this.val$result = web2NativeLoginResult;
                        this.val$callback = web2NativeLoginCallback;
                        this.val$bduss = cookieBduss;
                        this.val$ptoken = cookiePtoken;
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFinish() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048580, this) == null) {
                            this.val$callback.onFinish();
                        }
                    }

                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onStart() {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeV(1048581, this) == null) {
                            this.val$callback.onStart();
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.LoginStatusAware
                    public void onBdussExpired(GetUserInfoResult getUserInfoResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048576, this, getUserInfoResult) == null) {
                            this.val$result.setResultCode(400021);
                            this.val$callback.onBdussExpired(this.val$result);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onFailure(GetUserInfoResult getUserInfoResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(Constants.METHOD_SEND_USER_MSG, this, getUserInfoResult) == null) {
                            this.val$result.setResultCode(-202);
                            this.val$callback.onFailure(this.val$result);
                        }
                    }

                    /* JADX DEBUG: Method merged with bridge method */
                    @Override // com.baidu.sapi2.callback.SapiCallback
                    public void onSuccess(GetUserInfoResult getUserInfoResult) {
                        Interceptable interceptable2 = $ic;
                        if (interceptable2 == null || interceptable2.invokeL(1048582, this, getUserInfoResult) == null) {
                            SapiAccount sapiAccount = new SapiAccount();
                            sapiAccount.uid = getUserInfoResult.uid;
                            sapiAccount.username = getUserInfoResult.username;
                            sapiAccount.displayname = getUserInfoResult.displayname;
                            sapiAccount.bduss = this.val$bduss;
                            if (!TextUtils.isEmpty(this.val$ptoken)) {
                                sapiAccount.ptoken = this.val$ptoken;
                            }
                            sapiAccount.app = SapiUtils.getAppName(this.this$0.configuration.context);
                            SapiAccountManager.getInstance().validate(sapiAccount);
                            this.val$result.setResultCode(0);
                            this.val$callback.onSuccess(this.val$result);
                            new PtokenStat().onEvent(PtokenStat.WEB_2_NATIVE);
                        }
                    }
                }, cookieBduss);
            }
        }
    }

    public void getUserInfo(String str, String str2, NetCallback netCallback) {
        Interceptable interceptable = $ic;
        if (interceptable == null || interceptable.invokeLLL(1048614, this, str, str2, netCallback) == null) {
            SapiUtils.notNull(netCallback, "callback can't be null");
            SapiUtils.notEmpty(str, "bduss can't be empty");
            HttpHashMapWrap httpHashMapWrap = new HttpHashMapWrap();
            httpHashMapWrap.put("bduss", str);
            if (TextUtils.isEmpty(str2)) {
                httpHashMapWrap.put(SapiAccount.SAPI_ACCOUNT_PTOKEN, str2);
            }
            String deviceInfo = SapiDeviceInfo.getDeviceInfo(SapiEnv.GET_USER_INFO_URI);
            if (!TextUtils.isEmpty(deviceInfo)) {
                httpHashMapWrap.put(AppIconSetting.DEFAULT_LARGE_ICON, deviceInfo);
            }
            new HttpClientWrap().post(SapiEnv.GET_USER_INFO_URI, httpHashMapWrap, null, getUaInfo(), new HttpHandlerWrap(this, Looper.getMainLooper(), netCallback) { // from class: com.baidu.sapi2.SapiAccountRepository.5
                public static /* synthetic */ Interceptable $ic;
                public transient /* synthetic */ FieldHolder $fh;
                public final /* synthetic */ SapiAccountRepository this$0;
                public final /* synthetic */ NetCallback val$callback;

                /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
                {
                    super(r8);
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 != null) {
                        InitContext newInitContext = TitanRuntime.newInitContext();
                        newInitContext.initArgs = r2;
                        Object[] objArr = {this, r8, netCallback};
                        interceptable2.invokeUnInit(65536, newInitContext);
                        int i = newInitContext.flag;
                        if ((i & 1) != 0) {
                            int i2 = i & 2;
                            super((Looper) newInitContext.callArgs[0]);
                            newInitContext.thisArg = this;
                            interceptable2.invokeInitBody(65536, newInitContext);
                            return;
                        }
                    }
                    this.this$0 = this;
                    this.val$callback = netCallback;
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onFailure(Throwable th, int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeLIL(1048576, this, th, i, str3) == null) {
                        this.val$callback.onFailure(th, i, str3);
                    }
                }

                @Override // com.baidu.sapi2.httpwrap.HttpHandlerWrap
                public void onSuccess(int i, String str3) {
                    Interceptable interceptable2 = $ic;
                    if (interceptable2 == null || interceptable2.invokeIL(Constants.METHOD_GET_CONTACTER_INFO_FOR_SESSION, this, i, str3) == null) {
                        this.val$callback.onSuccess(i, str3);
                    }
                }
            });
        }
    }
}
