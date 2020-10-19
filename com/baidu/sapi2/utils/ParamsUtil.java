package com.baidu.sapi2.utils;

import android.text.TextUtils;
import com.baidu.sapi2.NoProguard;
import com.baidu.sapi2.SapiConfiguration;
import com.baidu.sapi2.SapiContext;
import com.baidu.sapi2.utils.enums.Language;
import com.baidu.sapi2.utils.enums.SocialType;
import com.baidu.webkit.internal.ETAG;
import com.tencent.open.SocialOperation;
import java.net.HttpCookie;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/* loaded from: classes5.dex */
public class ParamsUtil implements NoProguard {
    private static HttpCookie a(String str, String str2, String str3) {
        HttpCookie httpCookie = new HttpCookie(str, str2);
        httpCookie.setDomain(str3);
        httpCookie.setPath("/");
        return httpCookie;
    }

    public static String addExtras(String str, Map<String, String> map) {
        return str + SapiUtils.mapToUrlParams(map, str.contains("?"));
    }

    public static String buildH5CommonParams(SapiConfiguration sapiConfiguration) {
        return buildH5CommonParams(sapiConfiguration, true);
    }

    public static List<HttpCookie> buildNaCookie(String str, SapiConfiguration sapiConfiguration) {
        String wapDomain;
        ArrayList arrayList = new ArrayList();
        if (str.contains(sapiConfiguration.environment.getURL())) {
            wapDomain = sapiConfiguration.environment.getUrlDomain();
        } else if (!str.contains(sapiConfiguration.environment.getWap())) {
            return arrayList;
        } else {
            wapDomain = sapiConfiguration.environment.getWapDomain();
        }
        arrayList.add(a("cuid", SapiUtils.getClientId(sapiConfiguration.context), wapDomain));
        String deviceInfo = SapiContext.getInstance().getDeviceInfo();
        if (deviceInfo == null) {
            deviceInfo = "";
        }
        arrayList.add(a("DVIF", deviceInfo, wapDomain));
        arrayList.add(a("HISTORY", SapiUtils.getCookie(sapiConfiguration.environment.getWap(), "HISTORY"), wapDomain));
        arrayList.add(a("BAIDUID", SapiUtils.getCookie("https://baidu.com", "BAIDUID"), wapDomain));
        return arrayList;
    }

    public static String getGoogleTokenUrl() {
        return "https://oauth2.googleapis.com/token";
    }

    public static String getUrlBind(SapiConfiguration sapiConfiguration, SocialType socialType, String str, String str2, String str3) {
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
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + ETAG.ITEM_SEPARATOR + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlQQBind(SapiConfiguration sapiConfiguration, String str, String str2, String str3) {
        HashMap hashMap = new HashMap();
        hashMap.put("type", SocialType.QQ_SSO.getType() + "");
        hashMap.put("appid", sapiConfiguration.qqAppID);
        hashMap.put("access_token", str);
        hashMap.put("osuid", str2);
        hashMap.put(SocialOperation.GAME_UNION_ID, str3);
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + ETAG.ITEM_SEPARATOR + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String getUrlTwitterLogin(SapiConfiguration sapiConfiguration) {
        String str = sapiConfiguration.environment.getURL() + e.f;
        HashMap hashMap = new HashMap();
        hashMap.put("type", String.valueOf(SocialType.TWITTER.getType()));
        hashMap.put("tpl", sapiConfiguration.tpl);
        hashMap.put("adapter", "3");
        hashMap.put("display", "native");
        hashMap.put("act", "optional");
        hashMap.put("supportGuestAccount", "1");
        hashMap.put("app_key", sapiConfiguration.twitterAppKey);
        hashMap.put("client", "android");
        hashMap.put("clientfrom", "native");
        return str + SapiUtils.mapToUrlParams(hashMap, false);
    }

    public static String getUrlWeixinBind(SapiConfiguration sapiConfiguration, String str, String str2, boolean z) {
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
        return sapiConfiguration.environment.getURL() + "/phoenix/account/ssologin?" + buildH5CommonParams(sapiConfiguration) + ETAG.ITEM_SEPARATOR + SapiUtils.mapToUrlParams(hashMap, true);
    }

    public static String buildH5CommonParams(SapiConfiguration sapiConfiguration, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("clientfrom", "native");
        hashMap.put("tpl", sapiConfiguration.tpl);
        hashMap.put("login_share_strategy", sapiConfiguration.loginShareStrategy().getStrValue());
        hashMap.put("client", "android");
        if (z) {
            hashMap.put("adapter", sapiConfiguration.customActionBarEnabled ? "3" : "");
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
            hashMap.put("lang", com.baidu.fsg.base.statistics.h.f1493a);
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
}
