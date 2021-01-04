package com.baidu.live.view.web;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes11.dex */
public class i {
    public static boolean R(Context context, String str) {
        return d(context, str, "BAIDUZID", aS(ExtraParamsManager.getBaiduzid(), jl(str)));
    }

    public static boolean S(Context context, String str) {
        return d(context, str, "BAIDUCUID", aT(ExtraParamsManager.getBase64(ExtraParamsManager.getInstance().buildParamsExtra().getCuid()), jl(str)));
    }

    private static boolean d(Context context, String str, String str2, String str3) {
        boolean z;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        try {
            String jl = jl(str);
            if (TextUtils.isEmpty(jl)) {
                return false;
            }
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            String[] split = cookieManager.getCookie(jl).split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            if (split.length > 0) {
                z = true;
                for (String str4 : split) {
                    if (!TextUtils.isEmpty(str4)) {
                        Object[] split2 = str4.split("=");
                        if (!TextUtils.isEmpty(split2[0])) {
                            split2[0] = split2[0].trim();
                        }
                        if (split2.length > 1 && str2.equals(split2[0]) && !TextUtils.isEmpty(split2[1])) {
                            z = false;
                        }
                    }
                }
            } else {
                z = true;
            }
            if (z) {
                cookieManager.setCookie(jl, str2 + "=" + str3);
                CookieSyncManager.getInstance().sync();
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String jl(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private static String aS(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? "" : str + ";domain=" + str2 + ";path=/";
    }

    private static String aT(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? "" : str + ";domain=" + str2 + ";path=/";
    }
}
