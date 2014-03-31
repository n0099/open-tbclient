package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.util.bc;
/* loaded from: classes.dex */
public final class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        String str3;
        if (!str.startsWith(com.baidu.loginshare.e.f)) {
            str = com.baidu.loginshare.e.f.concat(str);
        }
        if (str.contains("?")) {
            str3 = "&st_type=" + str2;
        } else {
            str3 = "?st_type=" + str2;
        }
        return str.concat(str3);
    }

    public static void a(Context context, String str, boolean z) {
        com.baidu.tbadk.core.a.n a = com.baidu.tbadk.core.a.a.a(TbadkApplication.D());
        String b = b(a(str));
        if (a != null) {
            WebTbActivity.a(context, b, a.a, a.b);
        } else {
            WebTbActivity.a(context, b, null, null);
        }
    }

    public static void a(Context context, String str) {
        try {
            int b = com.baidu.adp.lib.a.f.a().b("baidu_webview");
            com.baidu.tbadk.core.a.n a = com.baidu.tbadk.core.a.a.a(TbadkApplication.D());
            String b2 = b(a(str));
            if (b2.indexOf("tbwebview=1") > 0) {
                TbWebViewActivity.a(context, b2, true, null);
            } else if (b == 1) {
                if (a != null) {
                    WebTbActivity.a(context, b2, a.a, a.b);
                } else {
                    WebTbActivity.a(context, b2, null, null);
                }
            } else if (Build.VERSION.SDK_INT >= 7 && b == 0) {
                if (a != null) {
                    WebBdActivity.a(context, b2, a.a, a.b);
                } else {
                    WebBdActivity.a(context, b2, null, null);
                }
            } else {
                c(context, b2);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("UtilHelper", "startWebActivity", e.getMessage());
        }
    }

    public static void b(Context context, String str) {
        String b = b(a(str));
        try {
            int b2 = com.baidu.adp.lib.a.f.a().b("baidu_webview");
            com.baidu.tbadk.core.a.n a = com.baidu.tbadk.core.a.a.a(TbadkApplication.D());
            if (!(b.indexOf("tbwebview=1") > 0) && Build.VERSION.SDK_INT > 7 && b2 == 0) {
                if (a != null) {
                    WebBdActivity.a(context, b, a.a, a.b);
                } else {
                    WebBdActivity.a(context, b, null, null);
                }
            } else if (a != null) {
                WebTbActivity.a(context, b, a.a, a.b);
            } else {
                WebTbActivity.a(context, b, null, null);
            }
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("UtilHelper", "startInternalWebActivity", e.getMessage());
        }
    }

    public static void c(Context context, String str) {
        String b = b(a(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(b));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            com.baidu.adp.lib.util.f.b("UtilHelper", "startExternWebActivity", e.getMessage());
        }
    }

    private static String a(String str) {
        if (bc.c(str) || str.indexOf("cuid=") < 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("cuid=");
            sb.append(TbadkApplication.j().z());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    private static String b(String str) {
        return (bc.c(str) || str.indexOf("_client_version=") < 0) ? String.valueOf(str) + "&_client_version=" + com.baidu.tbadk.core.data.n.c() : str;
    }

    public static void a(Context context) {
        com.baidu.tbadk.core.a.n a = com.baidu.tbadk.core.a.a.a(TbadkApplication.D());
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        if (a != null) {
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + a.a + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + a.b + "; domain=.baidu.com;");
        } else {
            cookieManager.removeAllCookie();
        }
        CookieSyncManager.getInstance().sync();
    }
}
