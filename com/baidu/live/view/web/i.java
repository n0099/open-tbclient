package com.baidu.live.view.web;

import android.content.Context;
import android.text.TextUtils;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import com.baidu.webkit.internal.ETAG;
import java.net.MalformedURLException;
import java.net.URL;
/* loaded from: classes3.dex */
public class i {
    public static boolean D(Context context, String str) {
        return c(context, str, "BAIDUZID", aF(ExtraParamsManager.getBaiduzid(), ge(str)));
    }

    public static boolean E(Context context, String str) {
        return c(context, str, "BAIDUCUID", aG(ExtraParamsManager.getBase64(ExtraParamsManager.getInstance().buildParamsExtra().getCuid()), ge(str)));
    }

    private static boolean c(Context context, String str, String str2, String str3) {
        boolean z;
        if (context == null || TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            return false;
        }
        try {
            String ge = ge(str);
            if (TextUtils.isEmpty(ge)) {
                return false;
            }
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            String[] split = cookieManager.getCookie(ge).split(ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            if (split.length > 0) {
                z = true;
                for (String str4 : split) {
                    if (!TextUtils.isEmpty(str4)) {
                        Object[] split2 = str4.split(ETAG.EQUAL);
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
                cookieManager.setCookie(ge, str2 + ETAG.EQUAL + str3);
                CookieSyncManager.getInstance().sync();
                return true;
            }
            return false;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String ge(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        try {
            return new URL(str).getHost();
        } catch (MalformedURLException e) {
            return null;
        }
    }

    private static String aF(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? "" : str + ";domain=" + str2 + ";path=/";
    }

    private static String aG(String str, String str2) {
        return (TextUtils.isEmpty(str2) || TextUtils.isEmpty(str)) ? "" : str + ";domain=" + str2 + ";path=/";
    }
}
