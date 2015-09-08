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
import com.baidu.adp.plugin.PluginCenter;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.a.a;
import com.baidu.tbadk.core.atomData.T5WebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.aq;
import com.baidu.tbadk.plugins.LightAppPlugin;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class g {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String T(String str, String str2) {
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
        b(context, true, str);
    }

    public static void b(Context context, boolean z, String str) {
        String appendVersionCode;
        qs();
        if (z) {
            try {
                appendVersionCode = appendVersionCode(appendCuidParam(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return;
            }
        } else {
            appendVersionCode = str;
        }
        if (((LightAppPlugin) PluginCenter.getInstance().getLightAppClassInstance()) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new T5WebViewActivityConfig(context, null, appendVersionCode, true, true, true)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(context, null, appendVersionCode, true, true, true)));
        }
    }

    public static void a(Context context, boolean z, String str, String str2) {
        String appendVersionCode;
        qs();
        if (z) {
            try {
                appendVersionCode = appendVersionCode(appendCuidParam(str));
            } catch (Exception e) {
                BdLog.e(e.getMessage());
                return;
            }
        } else {
            appendVersionCode = str;
        }
        if (((LightAppPlugin) PluginCenter.getInstance().getLightAppClassInstance()) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new T5WebViewActivityConfig(context, str2, appendVersionCode, true, false, true)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(context, str2, appendVersionCode, true, false, true)));
        }
    }

    public static void f(Context context, String str, String str2) {
        qs();
        try {
            String appendVersionCode = appendVersionCode(appendCuidParam(str2));
            if (((LightAppPlugin) PluginCenter.getInstance().getLightAppClassInstance()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new T5WebViewActivityConfig(context, str, appendVersionCode, true, true, true)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(context, str, appendVersionCode, true, true, true)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void c(Context context, String str, String str2, boolean z) {
        qs();
        try {
            String appendVersionCode = appendVersionCode(appendCuidParam(str2));
            if (((LightAppPlugin) PluginCenter.getInstance().getLightAppClassInstance()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new T5WebViewActivityConfig(context, str, appendVersionCode, true, z, true)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(context, str, appendVersionCode, true, z, true)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        a(context, str, str2, z, z2, z3, true);
    }

    public static void a(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        qs();
        try {
            String appendVersionCode = appendVersionCode(appendCuidParam(str2));
            if (((LightAppPlugin) PluginCenter.getInstance().getLightAppClassInstance()) != null && z4) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new T5WebViewActivityConfig(context, str, appendVersionCode, z, z2, z3)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(context, str, appendVersionCode, z, z2, z3)));
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
        if (!aq.isEmpty(str) && str.indexOf("cuid=") <= -1) {
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
        return (aq.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? String.valueOf(str) + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void W(Context context) {
        a.b cb = com.baidu.tbadk.core.a.a.rh().cb(TbadkCoreApplication.getCurrentBduss());
        CookieSyncManager.createInstance(TbadkCoreApplication.m411getInst());
        CookieManager cookieManager = CookieManager.getInstance();
        if (cb != null) {
            cookieManager.setAcceptCookie(true);
            cookieManager.setCookie("baidu.com", "BDUSS=" + cb.wr + "; domain=.baidu.com;");
            cookieManager.setCookie("baidu.com", "PTOKEN=" + cb.TR + "; domain=.baidu.com;");
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

    private static void qs() {
        new aj("open_webview", true).start();
    }
}
