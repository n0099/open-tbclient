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
import com.baidu.tbadk.core.account.AccountLoginHelper;
import com.baidu.tbadk.core.atomData.T5WebViewActivityConfig;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.plugins.LightAppPlugin;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String I(String str, String str2) {
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

    public static void c(Context context, String str, boolean z) {
        if (z) {
            AccountLoginHelper.parseBDUSS(TbadkCoreApplication.getCurrentBduss());
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, "", appendVersionCode(appendCuidParam(str)), true, true, false, false, false)));
            return;
        }
        y(context, str);
    }

    public static void y(Context context, String str) {
        b(context, true, str);
    }

    public static void b(Context context, boolean z, String str) {
        String appendVersionCode;
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
        if (((LightAppPlugin) PluginCenter.gX().he()) != null) {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new T5WebViewActivityConfig(context, null, appendVersionCode, true, true, true, true, true)));
        } else {
            MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, null, appendVersionCode, true, true, true, true, true)));
        }
    }

    public static void f(Context context, String str, String str2) {
        try {
            String appendVersionCode = appendVersionCode(appendCuidParam(str2));
            if (((LightAppPlugin) PluginCenter.gX().he()) != null) {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new T5WebViewActivityConfig(context, str, appendVersionCode, true, true, true, true, true)));
            } else {
                MessageManager.getInstance().sendMessage(new CustomMessage(2002001, new TbWebViewActivityConfig(context, str, appendVersionCode, true, true, true, true, true)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void z(Context context, String str) {
        b(context, true, str);
    }

    public static void A(Context context, String str) {
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
            sb.append(TbadkCoreApplication.m255getInst().getCuid());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (ba.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? String.valueOf(str) + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void Q(Context context) {
        AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkCoreApplication.getCurrentBduss());
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

    public static void WebViewNoDataBase(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }
}
