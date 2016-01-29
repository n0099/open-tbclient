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
import com.baidu.tbadk.core.util.ao;
import com.baidu.tbadk.core.util.aw;
import com.baidu.tbadk.plugins.LightAppPlugin;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class f {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String O(String str, String str2) {
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

    public static void B(Context context, String str) {
        a(context, true, str);
    }

    public static void a(Context context, boolean z, String str) {
        a(context, "", str, true, true, true, true, z);
    }

    public static void f(Context context, String str, String str2) {
        a(context, str, str2, true, true, true, true, true);
    }

    public static void b(Context context, String str, String str2, boolean z) {
        a(context, str, str2, true, z, true, true, true);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        a(context, str, str2, z, z2, z3, true, true);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        qx();
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

    public static void C(Context context, String str) {
        B(context, str);
    }

    public static void D(Context context, String str) {
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
        if (!aw.isEmpty(str) && str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("cuid=");
            sb.append(TbadkCoreApplication.m411getInst().getCuid());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (aw.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? String.valueOf(str) + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void W(Context context) {
        a.b ci = com.baidu.tbadk.core.a.a.rv().ci(TbadkCoreApplication.getCurrentBduss());
        CookieSyncManager.createInstance(TbadkCoreApplication.m411getInst());
        CookieManager cookieManager = CookieManager.getInstance();
        if (ci != null) {
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + ci.wJ + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + ci.TU + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "CUID=" + TbadkCoreApplication.m411getInst().getCuid() + "; domain=.baidu.com;");
        } else {
            try {
                cookieManager.removeAllCookie();
            } catch (Exception e) {
                BdLog.e(e);
            }
        }
        try {
            CookieSyncManager.getInstance().sync();
        } catch (Exception e2) {
            BdLog.e(e2);
        }
    }

    public static void WebViewNoDataBase(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }

    private static void qx() {
        new ao("open_webview", true).start();
    }
}
