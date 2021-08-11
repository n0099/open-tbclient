package com.baidu.sapi2.utils;

import android.text.TextUtils;
import androidx.core.view.InputDeviceCompat;
import com.baidu.fsg.base.statistics.f;
import com.baidu.mobads.container.util.AdIconUtil;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.titan.sdk.runtime.FieldHolder;
import com.baidu.titan.sdk.runtime.InitContext;
import com.baidu.titan.sdk.runtime.InterceptResult;
import com.baidu.titan.sdk.runtime.Interceptable;
import com.baidu.titan.sdk.runtime.TitanRuntime;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ParamsUtil implements NoProguard {
    public static /* synthetic */ Interceptable $ic;
    public transient /* synthetic */ FieldHolder $fh;

    public ParamsUtil() {
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
        return (interceptable == null || (invokeL = interceptable.invokeL(65539, null, sapiConfiguration)) == null) ? buildH5CommonParams(sapiConfiguration, true) : (String) invokeL.objValue;
    }

    public static List<HttpCookie> buildNaCookie(String str, SapiConfiguration sapiConfiguration) {
        InterceptResult invokeLL;
        String wapDomain;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(AdIconUtil.AD_TEXT_ID, null, str, sapiConfiguration)) == null) {
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

    public static String getAdapterParamValue(boolean z, boolean z2) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        return (interceptable == null || (invokeCommon = interceptable.invokeCommon(AdIconUtil.BAIDU_LOGO_ID, null, new Object[]{Boolean.valueOf(z), Boolean.valueOf(z2)})) == null) ? z ? "3" : z2 ? "8" : "" : (String) invokeCommon.objValue;
    }

    public static String getUrlBind(SapiConfiguration sapiConfiguration, SocialType socialType, String str, String str2, String str3) {
        InterceptResult invokeLLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLLL = interceptable.invokeLLLLL(65543, null, sapiConfiguration, socialType, str, str2, str3)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("display", "native");
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

    public static String getUrlQQBind(SapiConfiguration sapiConfiguration, String str, String str2, String str3) {
        InterceptResult invokeLLLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLLLL = interceptable.invokeLLLL(65544, null, sapiConfiguration, str, str2, str3)) == null) {
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
        if (interceptable == null || (invokeL = interceptable.invokeL(65545, null, sapiConfiguration)) == null) {
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
            hashMap.put("display", "native");
            hashMap.put("act", "optional");
            hashMap.put("supportGuestAccount", "1");
            hashMap.put("app_key", sapiConfiguration.twitterAppKey);
            hashMap.put("client", "android");
            hashMap.put("clientfrom", "native");
            return str + SapiUtils.mapToUrlParams(hashMap, false);
        }
        return (String) invokeL.objValue;
    }

    public static String getUrlWeixinBind(SapiConfiguration sapiConfiguration, String str, String str2, boolean z) {
        InterceptResult invokeCommon;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeCommon = interceptable.invokeCommon(65546, null, new Object[]{sapiConfiguration, str, str2, Boolean.valueOf(z)})) == null) {
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
            hashMap.put("display", "native");
            return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + "&" + SapiUtils.mapToUrlParams(hashMap, true);
        }
        return (String) invokeCommon.objValue;
    }

    public static String getUrlYYLogin(String str, SapiConfiguration sapiConfiguration) {
        InterceptResult invokeLL;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLL = interceptable.invokeLL(65547, null, str, sapiConfiguration)) == null) {
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

    public static String buildH5CommonParams(SapiConfiguration sapiConfiguration, boolean z) {
        InterceptResult invokeLZ;
        Interceptable interceptable = $ic;
        if (interceptable == null || (invokeLZ = interceptable.invokeLZ(InputDeviceCompat.SOURCE_TRACKBALL, null, sapiConfiguration, z)) == null) {
            HashMap hashMap = new HashMap();
            hashMap.put("clientfrom", "native");
            hashMap.put("tpl", sapiConfiguration.tpl);
            hashMap.put("login_share_strategy", sapiConfiguration.loginShareStrategy().getStrValue());
            hashMap.put("client", "android");
            if (z) {
                hashMap.put("adapter", sapiConfiguration.customActionBarEnabled ? "3" : "");
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
                hashMap.put("lang", f.f39281a);
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
}
