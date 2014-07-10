package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbadkApplication;
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.util.bm;
import com.baidu.tbadk.plugins.BdBrowserDelegate;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String a(String str, String str2) {
        String str3;
        if (!str.startsWith("http://")) {
            str = "http://".concat(str);
        }
        if (str.contains("?")) {
            str3 = "&st_type=" + str2;
        } else {
            str3 = "?st_type=" + str2;
        }
        return str.concat(str3);
    }

    public static void a(Context context, String str, boolean z) {
        if (z) {
            AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            TbWebViewActivity.startActivity(context, "", b(a(str)));
            return;
        }
        a(context, str);
    }

    public static void a(Context context, String str) {
        boolean z = false;
        try {
            int b = com.baidu.adp.lib.a.f.a().b("baidu_webview");
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            String b2 = b(a(str));
            boolean z2 = b2.indexOf("tbwebview=1") > 0;
            boolean z3 = b2.indexOf("tborientation=1") > 0;
            boolean z4 = b2.indexOf("tbfullscreen=1") > 0;
            boolean e = com.baidu.tbadk.tbplugin.m.a().e(BdBrowserDelegate.class);
            if (!z2 && com.baidu.tbadk.tbplugin.m.a() != null && com.baidu.tbadk.tbplugin.m.a().b(BdBrowserDelegate.class) != null && !e) {
                z = true;
            }
            if (z2) {
                TbWebViewActivity.startActivityWithoutNavBar(context, b2, true, null);
            } else if (b == 1 || !z) {
                if (parseBDUSS != null) {
                    WebTbActivity.a(context, b2, parseBDUSS.mBduss, parseBDUSS.mPtoken, z3, z4);
                } else {
                    WebTbActivity.a(context, b2, null, null, z3, z4);
                }
            } else if (Build.VERSION.SDK_INT >= 7 && b == 0) {
                if (parseBDUSS != null) {
                    WebBdActivity.a(context, b2, parseBDUSS.mBduss, parseBDUSS.mPtoken, z3, z4);
                } else {
                    WebBdActivity.a(context, b2, null, null, z3, z4);
                }
            } else {
                c(context, b2);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
        }
    }

    public static void b(Context context, String str) {
        boolean z = true;
        String b = b(a(str));
        try {
            int b2 = com.baidu.adp.lib.a.f.a().b("baidu_webview");
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            boolean z2 = b.indexOf("tbwebview=1") > 0;
            boolean z3 = b.indexOf("tborientation=1") > 0;
            boolean z4 = b.indexOf("tbfullscreen=1") > 0;
            boolean e = com.baidu.tbadk.tbplugin.m.a().e(BdBrowserDelegate.class);
            if (z2 || com.baidu.tbadk.tbplugin.m.a() == null || com.baidu.tbadk.tbplugin.m.a().b(BdBrowserDelegate.class) == null || e) {
                z = false;
            }
            if (!z2 && Build.VERSION.SDK_INT > 7 && b2 == 0 && z) {
                if (parseBDUSS != null) {
                    WebBdActivity.a(context, b, parseBDUSS.mBduss, parseBDUSS.mPtoken, z3, z4);
                } else {
                    WebBdActivity.a(context, b, null, null, z3, z4);
                }
            } else if (parseBDUSS != null) {
                WebTbActivity.a(context, b, parseBDUSS.mBduss, parseBDUSS.mPtoken, z3, z4);
            } else {
                WebTbActivity.a(context, b, null, null, z3, z4);
            }
        } catch (Exception e2) {
            BdLog.e(e2.getMessage());
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
            BdLog.e(e.getMessage());
        }
    }

    public static String a(String str) {
        if (!bm.c(str) && str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("cuid=");
            sb.append(TbadkApplication.m252getInst().getCuid());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String b(String str) {
        return (bm.c(str) || str.indexOf("_client_version=") <= -1) ? String.valueOf(str) + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void a(Context context) {
        AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
        CookieSyncManager.createInstance(context);
        CookieManager cookieManager = CookieManager.getInstance();
        if (parseBDUSS != null) {
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + parseBDUSS.mBduss + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + parseBDUSS.mPtoken + "; domain=.baidu.com;");
        } else {
            cookieManager.removeAllCookie();
        }
        CookieSyncManager.getInstance().sync();
    }

    public static void a(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }
}
