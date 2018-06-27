package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.proxy.ContentProviderProxy;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.ah;
import com.baidu.tbadk.core.util.ap;
import com.baidu.tieba.compatible.CompatibleUtile;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String O(String str, String str2) {
        String str3;
        if (!str.startsWith("http://") && !str.startsWith(SapiUtils.COOKIE_HTTPS_URL_PREFIX)) {
            str = "http://".concat(str);
        }
        if (str.contains("?")) {
            str3 = "&st_type=" + str2;
        } else {
            str3 = "?st_type=" + str2;
        }
        return str.concat(str3);
    }

    public static void O(Context context, String str) {
        b(context, true, str);
    }

    public static void b(Context context, boolean z, String str) {
        a(context, "", str, true, true, true, true, z);
    }

    public static void a(Context context, boolean z, String str, String str2) {
        a(context, str2, str, true, true, true, true, z);
    }

    public static void g(Context context, String str, String str2) {
        a(context, str, str2, true, true, true, true, true);
    }

    public static void a(boolean z, Context context, String str, String str2) {
        a(context, str, str2, true, true, true, true, true, false, z);
    }

    public static void c(Context context, String str, String str2, boolean z) {
        a(context, str, str2, true, z, true, true, true);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        a(context, str, str2, z, z2, z3, true, true);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        sw();
        try {
            if (!StringUtils.isNull(str2)) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, str, z5 ? appendVersionCode(appendCuidParam(str2)) : str2, z, z2, z3)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        a(context, str, str2, z, z2, z3, z4, z5, z6, false);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        sw();
        try {
            if (!StringUtils.isNull(str2)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, str, z5 ? appendVersionCode(appendCuidParam(str2)) : str2, z, z2, z3, z6);
                tbWebViewActivityConfig.setFixTitle(z7);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void P(Context context, String str) {
        sw();
        try {
            if (!StringUtils.isNull(str)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, "", appendVersionCode(appendCuidParam(str)), true, true, true, false);
                tbWebViewActivityConfig.setNoShare(true);
                tbWebViewActivityConfig.setMenu(true);
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, tbWebViewActivityConfig));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void Q(Context context, String str) {
        O(context, str);
    }

    public static void R(Context context, String str) {
        String appendVersionCode = appendVersionCode(appendCuidParam(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(appendVersionCode));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static String b(String str, List<Pair<String, String>> list) {
        if (!ap.isEmpty(str) && list != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") < 0) {
                sb.append("?");
            }
            for (Pair<String, String> pair : list) {
                if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first)) {
                    sb.append("&");
                    sb.append((String) pair.first);
                    sb.append("=");
                    sb.append((String) pair.second);
                }
            }
            return sb.toString();
        }
        return str;
    }

    public static String appendCuidParam(String str) {
        if (!ap.isEmpty(str) && str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            if (!UtilHelper.isNativeAdURL(str)) {
                sb.append("cuid=");
                sb.append(TbadkCoreApplication.getInst().getCuid());
                sb.append("&cuid_galaxy2=");
                sb.append(TbadkCoreApplication.getInst().getCuidGalaxy2());
                sb.append("&cuid_gid=");
                sb.append(TbadkCoreApplication.getInst().getCuidGid());
            }
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (ap.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? str + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void aB(Context context) {
        CookieManager cookieManager;
        try {
            CookieSyncManager.createInstance(TbadkCoreApplication.getInst());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            BdLog.e(th);
            cookieManager = null;
        }
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(true);
            if (com.baidu.tbadk.core.a.a.tA().dd(TbadkCoreApplication.getCurrentBduss()) != null) {
                String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(c)) {
                    sb.append("STOKEN=").append(c).append("; domain=.tieba.baidu.com;");
                    cookieManager.setCookie("tieba.baidu.com", sb.toString());
                }
            } else {
                try {
                    cookieManager.removeAllCookie();
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            cookieManager.setCookie("baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + "; domain=.baidu.com; cuid_galaxy2=" + TbadkCoreApplication.getInst().getCuidGalaxy2() + "; cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            try {
                CookieSyncManager.getInstance().sync();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
            SapiAccountManager.getInstance().getAccountService().webLogin(context);
        }
    }

    public static void WebViewNoDataBase(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }

    private static void sw() {
        new ah("open_webview", true).start();
    }
}
