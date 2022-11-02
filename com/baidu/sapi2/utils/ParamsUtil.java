package com.baidu.sapi2.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.SapiOptions;
import com.baidu.sapi2.ServiceManager;
import com.baidu.sapi2.service.interfaces.ISAccountManager;
import com.baidu.sapi2.utils.enums.BindInfoAction;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.searchbox.crius.constants.CriusAttrConstants;
import com.baidu.swan.game.guide.GameGuideConfigInfo;
import com.baidu.tbadk.core.util.httpNet.HttpRequest;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptable;
import com.baidu.titan.sdk.runtime.ClassClinitInterceptorStorage;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import com.google.android.exoplayer2.text.webvtt.WebvttCueParser;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
/* loaded from: classes2.dex */
public class ParamsUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public static String getAdapterParamValue(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(65544, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z ? "3" : z2 ? "8" : "" : (String) invokeCommon.objValue;
    }

    /* renamed from: com.baidu.sapi2.utils.ParamsUtil$1  reason: invalid class name */
    /* loaded from: classes2.dex */
    public static /* synthetic */ class AnonymousClass1 {
        public static final /* synthetic */ int[] $SwitchMap$com$baidu$sapi2$utils$enums$BindInfoAction;
        public static /* synthetic */ Interceptable $ic;
        public transient /* synthetic */ FieldHolder $fh;

        static {
            InterceptResult invokeClinit;
            ClassClinitInterceptable classClinitInterceptable = ClassClinitInterceptorStorage.$ic;
            if (classClinitInterceptable != null && (invokeClinit = classClinitInterceptable.invokeClinit(1232389526, "Lcom/baidu/sapi2/utils/ParamsUtil$1;")) != null) {
                Interceptable interceptable = invokeClinit.interceptor;
                if (interceptable != null) {
                    $ic = interceptable;
                }
                if ((invokeClinit.flags & 1) != 0) {
                    classClinitInterceptable.invokePostClinit(1232389526, "Lcom/baidu/sapi2/utils/ParamsUtil$1;");
                    return;
                }
            }
            int[] iArr = new int[BindInfoAction.values().length];
            $SwitchMap$com$baidu$sapi2$utils$enums$BindInfoAction = iArr;
            try {
                iArr[BindInfoAction.BIND_EMAIL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                $SwitchMap$com$baidu$sapi2$utils$enums$BindInfoAction[BindInfoAction.BIND_MOBILE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public ParamsUtil() {
        Interceptable interceptable = $ic;
        if (interceptable != null) {
            InitContext newInitContext = TitanRuntime.newInitContext();
            interceptable.invokeUnInit(65536, newInitContext);
            int i = newInitContext.flag;
            if ((i & 1) != 0) {
                int i2 = i & 2;
                newInitContext.thisArg = this;
                interceptable.invokeInitBody(65536, newInitContext);
            }
        }
    }

    public static String addExtras(String str, Map<String, String> map) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65537, null, str, map)) == null) {
            return str + SapiUtils.mapToUrlParams(map, str.contains("?"));
        }
        return (String) invokeLL.objValue;
    }

    public static HttpCookie buidCookie(String str, String str2, String str3) {
        InterceptResult invokeLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLL = interceptable.invokeLLL(65538, null, str, str2, str3)) == null) {
            HttpCookie httpCookie = new HttpCookie(str, str2);
            httpCookie.setDomain(str3);
            httpCookie.setPath("/");
            return httpCookie;
        }
        return (HttpCookie) invokeLLL.objValue;
    }

    public static String buildH5CommonParams(SapiConfiguration sapiConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sapiConfiguration)) == null) {
            return buildH5CommonParams(sapiConfiguration, true);
        }
        return (String) invokeL.objValue;
    }

    public static String getBindInfoType(BindInfoAction bindInfoAction) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, bindInfoAction)) == null) {
            if (bindInfoAction == null || AnonymousClass1.$SwitchMap$com$baidu$sapi2$utils$enums$BindInfoAction[bindInfoAction.ordinal()] != 1) {
                return "";
            }
            return "&type=email";
        }
        return (String) invokeL.objValue;
    }

    public static String buildH5CommonParams(SapiConfiguration sapiConfiguration, boolean z) {
        InterceptResult invokeLZ;
        String str;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, sapiConfiguration, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("clientfrom", "native");
            hashMap.put("tpl", sapiConfiguration.tpl);
            hashMap.put("login_share_strategy", sapiConfiguration.loginShareStrategy().getStrValue());
            hashMap.put("client", "android");
            if (z) {
                if (sapiConfiguration.customActionBarEnabled) {
                    str = "3";
                } else {
                    str = "";
                }
                hashMap.put("adapter", str);
            } else if (sapiConfiguration.showBottomBack) {
                hashMap.put("adapter", "8");
            }
            hashMap.put("t", String.valueOf(System.currentTimeMillis()));
            hashMap.put("act", sapiConfiguration.socialBindType.getName());
            hashMap.put("hideExtraEntry", String.valueOf(sapiConfiguration.smsLoginConfig.flagHideExtraEntry.ordinal()));
            hashMap.put("loginLink", String.valueOf(sapiConfiguration.smsLoginConfig.flagShowLoginLink.ordinal()));
            hashMap.put("smsLoginLink", String.valueOf(sapiConfiguration.smsLoginConfig.flagShowSmsLoginLink.ordinal()));
            hashMap.put("lPFastRegLink", String.valueOf(sapiConfiguration.smsLoginConfig.flagShowFastRegLink.ordinal()));
            hashMap.put("lPlayout", String.valueOf(sapiConfiguration.configurableViewLayout.ordinal()));
            if (sapiConfiguration.uniteVerify) {
                hashMap.put("connect", "1");
            }
            if (sapiConfiguration.language == Language.ENGLISH) {
                hashMap.put(WebvttCueParser.TAG_LANG, "en");
            }
            hashMap.put("suppcheck", "1");
            if (sapiConfiguration.supportFaceLogin) {
                hashMap.put("scanface", "1");
                hashMap.put("liveAbility", "1");
            }
            if (sapiConfiguration.disableVoiceVerify) {
                hashMap.put("disable_voice_vcode", "1");
            }
            return SapiUtils.mapToUrlParams(hashMap, true);
        }
        return (String) invokeLZ.objValue;
    }

    public static List<HttpCookie> buildLoginStatusCookie(String str, SapiConfiguration sapiConfiguration) {
        InterceptResult invokeLL;
        String wapDomain;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65541, null, str, sapiConfiguration)) == null) {
            ArrayList arrayList = new ArrayList();
            if (str.contains(sapiConfiguration.environment.getURL())) {
                wapDomain = sapiConfiguration.environment.getUrlDomain();
            } else {
                if (str.contains(sapiConfiguration.environment.getWap())) {
                    wapDomain = sapiConfiguration.environment.getWapDomain();
                }
                return arrayList;
            }
            arrayList.add(buidCookie(HttpRequest.BDUSS, SapiUtils.getCookie(sapiConfiguration.environment.getWap(), HttpRequest.BDUSS), wapDomain));
            arrayList.add(buidCookie("PTOKEN", SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "PTOKEN"), wapDomain));
            arrayList.add(buidCookie("STOKEN", SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "STOKEN"), wapDomain));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static List<HttpCookie> buildNaCookie(String str, SapiConfiguration sapiConfiguration) {
        InterceptResult invokeLL;
        String wapDomain;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65542, null, str, sapiConfiguration)) == null) {
            ArrayList arrayList = new ArrayList();
            if (str.contains(sapiConfiguration.environment.getURL())) {
                wapDomain = sapiConfiguration.environment.getUrlDomain();
            } else {
                if (str.contains(sapiConfiguration.environment.getWap())) {
                    wapDomain = sapiConfiguration.environment.getWapDomain();
                }
                return arrayList;
            }
            arrayList.add(buidCookie("cuid", SapiUtils.getClientId(sapiConfiguration.context), wapDomain));
            String deviceInfo = SapiContext.getInstance().getDeviceInfo();
            if (deviceInfo == null) {
                deviceInfo = "";
            }
            arrayList.add(buidCookie("DVIF", deviceInfo, wapDomain));
            arrayList.add(buidCookie("HISTORY", SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "HISTORY"), wapDomain));
            arrayList.add(buidCookie("BAIDUID", SapiUtils.getCookie("https://baidu.com", "BAIDUID"), wapDomain));
            return arrayList;
        }
        return (List) invokeLL.objValue;
    }

    public static String getUrlCFOLogin(SapiConfiguration sapiConfiguration, String str) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65549, null, sapiConfiguration, str)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", SocialType.CFO.getType() + "");
            hashMap.put("appid", sapiConfiguration.cfoAppKey);
            hashMap.put("code", str);
            return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + "&" + SapiUtils.mapToUrlParams(hashMap, true);
        }
        return (String) invokeLL.objValue;
    }

    public static String getUrlYYLogin(String str, SapiConfiguration sapiConfiguration) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65553, null, str, sapiConfiguration)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", SocialType.YY.getType() + "");
            hashMap.put("appid", sapiConfiguration.yyAppId);
            hashMap.put("access_token", str);
            if (sapiConfiguration.supportGuestAccountLogin) {
                hashMap.put("supportGuestAccount", "1");
            }
            return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + "&" + SapiUtils.mapToUrlParams(hashMap, true);
        }
        return (String) invokeLL.objValue;
    }

    public static boolean checkDiUpload(JSONArray jSONArray, int i) {
        InterceptResult invokeLI;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLI = interceptable.invokeLI(65543, null, jSONArray, i)) == null) {
            for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                String optString = jSONArray.optString(i2);
                if (!TextUtils.isEmpty(optString) && optString.equals(String.valueOf(i))) {
                    Log.e("privacy_parameter_control", "di is not upload , index = " + i);
                    return false;
                }
            }
            return true;
        }
        return invokeLI.booleanValue;
    }

    public static JSONArray getGrayControlParams() {
        InterceptResult invokeV;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeV = interceptable.invokeV(65546, null)) == null) {
            JSONArray jSONArray = new JSONArray();
            ISAccountManager isAccountManager = ServiceManager.getInstance().getIsAccountManager();
            if (isAccountManager == null) {
                Log.e("privacy_parameter_control", "accountManager is null");
                return jSONArray;
            }
            SapiConfiguration confignation = isAccountManager.getConfignation();
            if (confignation == null) {
                Log.e("privacy_parameter_control", "confignation is null");
                return jSONArray;
            } else if (!confignation.mPrivacyParamesRegulation) {
                Log.e("privacy_parameter_control", "params is not be regulation");
                return jSONArray;
            } else {
                SapiOptions.Gray gray = SapiContext.getInstance().getSapiOptions().gray;
                if (gray == null) {
                    Log.e("privacy_parameter_control", "gray is null");
                    return jSONArray;
                }
                SapiOptions.Gray.GrayModule grayModuleByFunName = gray.getGrayModuleByFunName(SapiOptions.Gray.FUN_NAME_MAPPING);
                if (grayModuleByFunName == null) {
                    Log.e("privacy_parameter_control", "grayModule is null");
                    return jSONArray;
                } else if (!grayModuleByFunName.isMeetGray()) {
                    Log.e("privacy_parameter_control", "meetGray is false");
                    return jSONArray;
                } else {
                    String extraParams = grayModuleByFunName.getExtraParams();
                    if (extraParams == null) {
                        Log.e("privacy_parameter_control", "extraParams is null");
                        return jSONArray;
                    }
                    Log.e("privacy_parameter_control", "extraParams : " + extraParams);
                    try {
                        jSONArray = new JSONObject(extraParams).optJSONArray("dt_params");
                        Log.e("privacy_parameter_control", "paramsList : " + jSONArray);
                        return jSONArray;
                    } catch (JSONException e) {
                        Log.e("privacy_parameter_control", "exception : " + e);
                        e.printStackTrace();
                        return jSONArray;
                    }
                }
            }
        }
        return (JSONArray) invokeV.objValue;
    }

    public static String getUrlBind(SapiConfiguration sapiConfiguration, SocialType socialType, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65547, null, sapiConfiguration, socialType, str, str2, str3)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(CriusAttrConstants.DISPLAY, "native");
            hashMap.put("type", socialType.getType() + "");
            hashMap.put("act", sapiConfiguration.socialBindType.getName());
            if (!TextUtils.isEmpty(str3)) {
                hashMap.put("appid", str3);
            }
            hashMap.put("access_token", str);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("osuid", str2);
            }
            return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + "&" + SapiUtils.mapToUrlParams(hashMap, true);
        }
        return (String) invokeLLLLL.objValue;
    }

    public static String getUrlBindHonor(SapiConfiguration sapiConfiguration, SocialType socialType, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65548, null, sapiConfiguration, socialType, str, str2, str3)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put(CriusAttrConstants.DISPLAY, "native");
            hashMap.put("type", socialType.getType() + "");
            hashMap.put("act", sapiConfiguration.socialBindType.getName());
            hashMap.put("redirect_uri", str3);
            if (!TextUtils.isEmpty(str2)) {
                hashMap.put("appid", str2);
            }
            hashMap.put("code", str);
            return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + "&" + SapiUtils.mapToUrlParams(hashMap, true);
        }
        return (String) invokeLLLLL.objValue;
    }

    public static String getUrlQQBind(SapiConfiguration sapiConfiguration, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65550, null, sapiConfiguration, str, str2, str3)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", SocialType.QQ_SSO.getType() + "");
            hashMap.put("appid", sapiConfiguration.qqAppID);
            hashMap.put("access_token", str);
            if (sapiConfiguration.supportGuestAccountLogin) {
                hashMap.put("supportGuestAccount", "1");
            }
            hashMap.put("osuid", str2);
            hashMap.put("unionid", str3);
            return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + "&" + SapiUtils.mapToUrlParams(hashMap, true);
        }
        return (String) invokeLLLL.objValue;
    }

    public static String getUrlTwitterLogin(SapiConfiguration sapiConfiguration) {
        InterceptResult invokeL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeL = interceptable.invokeL(65551, null, sapiConfiguration)) == null) {
            String str = sapiConfiguration.environment.getURL() + SapiEnv.SOCIAL_START_URI;
            HashMap hashMap = new HashMap();
            hashMap.put("type", String.valueOf(SocialType.TWITTER.getType()));
            hashMap.put("tpl", sapiConfiguration.tpl);
            hashMap.put("adapter", "3");
            if (sapiConfiguration.showBottomBack) {
                hashMap.put("adapter", "8");
            } else {
                hashMap.put("adapter", "3");
            }
            hashMap.put(CriusAttrConstants.DISPLAY, "native");
            hashMap.put("act", "optional");
            hashMap.put("supportGuestAccount", "1");
            hashMap.put(GameGuideConfigInfo.KEY_APP_KEY, sapiConfiguration.twitterAppKey);
            hashMap.put("client", "android");
            hashMap.put("clientfrom", "native");
            return str + SapiUtils.mapToUrlParams(hashMap, false);
        }
        return (String) invokeL.objValue;
    }

    public static String getUrlWeixinBind(SapiConfiguration sapiConfiguration, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65552, null, new Object[]{sapiConfiguration, str, str2, Boolean.valueOf(z)})) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("type", SocialType.WEIXIN.getType() + "");
            hashMap.put("mkey", str2);
            hashMap.put("code", str);
            if (sapiConfiguration.supportGuestAccountLogin) {
                hashMap.put("supportGuestAccount", "1");
            }
            if (z) {
                hashMap.put("wapsec", "center");
                hashMap.put("adapter", "3");
            }
            hashMap.put("appid", sapiConfiguration.wxAppID);
            hashMap.put(CriusAttrConstants.DISPLAY, "native");
            return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + "&" + SapiUtils.mapToUrlParams(hashMap, true);
        }
        return (String) invokeCommon.objValue;
    }
}
