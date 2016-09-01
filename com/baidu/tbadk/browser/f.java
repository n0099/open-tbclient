package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.T5WebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.ar;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.plugins.LightAppPlugin;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String L(String str, String str2) {
        String str3;
        if (!str.startsWith("http://") && !str.startsWith("https://")) {
            str = "http://".concat(str);
        }
        if (str.contains("?")) {
            str3 = "&st_type=" + str2;
        } else {
            str3 = "?st_type=" + str2;
        }
        return str.concat(str3);
    }

    public static void u(Context context, String str) {
        a(context, true, str);
    }

    public static void a(Context context, boolean z, String str) {
        a(context, "", str, true, true, true, true, z);
    }

    public static void c(Context context, String str, String str2) {
        a(context, str, str2, true, true, true, true, true);
    }

    public static void b(Context context, String str, String str2, boolean z) {
        a(context, str, str2, true, z, true, true, true);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        a(context, str, str2, z, z2, z3, true, true);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        nN();
        try {
            if (!StringUtils.isNull(str2)) {
                String appendVersionCode = z5 ? appendVersionCode(appendCuidParam(str2)) : str2;
                if (((LightAppPlugin) PluginCenter.getInstance().getLightAppClassInstance()) != null && z4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new T5WebViewActivityConfig(context, str, appendVersionCode, z, z2, z3)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(context, str, appendVersionCode, z, z2, z3)));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        nN();
        try {
            if (!StringUtils.isNull(str2)) {
                String appendVersionCode = z5 ? appendVersionCode(appendCuidParam(str2)) : str2;
                if (((LightAppPlugin) PluginCenter.getInstance().getLightAppClassInstance()) != null && z4) {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new T5WebViewActivityConfig(context, str, appendVersionCode, z, z2, z3)));
                } else {
                    MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(context, str, appendVersionCode, z, z2, z3, z6)));
                }
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void v(Context context, String str) {
        u(context, str);
    }

    public static void w(Context context, String str) {
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

    public static String appendCuidParam(String str) {
        if (!ba.isEmpty(str) && str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("cuid=");
            sb.append(TbadkCoreApplication.m9getInst().getCuid());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (ba.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? String.valueOf(str) + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void R(Context context) {
        a.b ce = com.baidu.tbadk.core.a.a.oO().ce(TbadkCoreApplication.getCurrentBduss());
        CookieSyncManager.createInstance(TbadkCoreApplication.m9getInst());
        CookieManager cookieManager = null;
        try {
            cookieManager = CookieManager.getInstance();
        } catch (Exception e) {
            BdLog.e(e);
        }
        if (cookieManager != null) {
            if (ce != null) {
                cookieManager.setAcceptCookie(true);
                StringBuilder sb = new StringBuilder();
                String d = com.baidu.tbadk.core.a.h.d(TbadkCoreApplication.getCurrentAccountInfo());
                if (!StringUtils.isNull(d)) {
                    sb.append("stoken=").append(d).append("; ");
                }
                sb.append("CUID=").append(TbadkCoreApplication.m9getInst().getCuid()).append("; domain=.baidu.com;");
                cookieManager.setCookie("baidu.com", sb.toString());
            } else {
                try {
                    cookieManager.removeAllCookie();
                } catch (Exception e2) {
                    BdLog.e(e2);
                }
            }
            try {
                CookieSyncManager.getInstance().sync();
            } catch (Exception e3) {
                BdLog.e(e3);
            }
        }
    }

    public static void WebViewNoDataBase(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }

    private static void nN() {
        new ar("open_webview", true).start();
    }
}
