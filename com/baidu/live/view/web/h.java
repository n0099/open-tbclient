package com.baidu.live.view.web;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.extraparams.ExtraParamsManager;
import java.util.HashMap;
import java.util.Map;
/* loaded from: classes6.dex */
public class h {
    public static boolean aA(Context context) {
        String cuid = TbadkCoreApplication.getInst().getCuid();
        Log.i("WebCookiesUtils", "setWebCUID cuid:" + cuid);
        if (context == null || TextUtils.isEmpty(cuid)) {
            return false;
        }
        try {
            String str = "";
            HashMap hashMap = new HashMap();
            hashMap.put(ExtraParamsManager.KEY_GET_BASE64, cuid);
            Map<String, Object> process = ExtraParamsManager.getInstance().buildParamsExtra().process(hashMap);
            if (process.containsKey(ExtraParamsManager.KEY_GET_BASE64)) {
                str = (String) process.get(ExtraParamsManager.KEY_GET_BASE64);
            }
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            String dh = dh(str);
            Log.i("WebCookiesUtils", "setWebCUID cuidCookie:" + dh);
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie(".baidu.com", dh);
            CookieSyncManager.getInstance().sync();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static String dg(String str) {
        return "BDUSS=" + str + ";domain=.baidu.com;path=/";
    }

    private static String dh(String str) {
        return "BAIDUCUID=" + str + ";domain=.baidu.com;path=/";
    }

    public static boolean webLogin(Context context, String str) {
        Log.i("WebCookiesUtils", "webLogin bduss:" + str);
        if (context == null || TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            String dg = dg(str);
            Log.i("WebCookiesUtils", "webLogin bdussCookie:" + dg);
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie(".baidu.com", dg);
            CookieSyncManager.getInstance().sync();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }

    public static boolean webLogout(Context context) {
        if (context == null) {
            return false;
        }
        try {
            String dg = dg("");
            CookieSyncManager.createInstance(context);
            CookieManager cookieManager = CookieManager.getInstance();
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie(".baidu.com", dg);
            cookieManager.removeAllCookie();
            CookieSyncManager.getInstance().sync();
            return true;
        } catch (Throwable th) {
            return false;
        }
    }
}
