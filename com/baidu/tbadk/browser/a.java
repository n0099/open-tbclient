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
import com.baidu.tbadk.core.util.az;
import com.baidu.tbadk.pluginArch.Plugin;
import com.baidu.tbadk.pluginArch.PluginCenter;
import com.baidu.tbadk.pluginArch.PluginNameList;
import com.baidu.tbadk.plugins.BdBrowserDelegate;
import com.baidu.tieba.compatible.CompatibleUtile;
/* loaded from: classes.dex */
public class a {
    /* JADX INFO: Access modifiers changed from: package-private */
    public static String x(String str, String str2) {
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
            TbWebViewActivity.startActivity(context, "", aQ(aP(str)));
            return;
        }
        i(context, str);
    }

    public static void i(Context context, String str) {
        a(context, true, str);
    }

    public static void a(Context context, boolean z, String str) {
        boolean z2;
        boolean z3 = false;
        BdBrowserDelegate bdBrowserDelegate = null;
        try {
            int U = com.baidu.adp.lib.b.f.db().U("baidu_webview");
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            String aQ = z ? aQ(aP(str)) : str;
            boolean z4 = aQ.indexOf("tbwebview=1") > 0;
            boolean z5 = aQ.indexOf("tborientation=1") > 0;
            boolean z6 = aQ.indexOf("tbfullscreen=1") > 0;
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BROWSER);
            if (pluginByName != null) {
                bdBrowserDelegate = (BdBrowserDelegate) pluginByName.getClassInstance(BdBrowserDelegate.class);
                z2 = !pluginByName.checkEnable();
            } else {
                z2 = true;
            }
            if (!z4 && PluginCenter.getInstance() != null && bdBrowserDelegate != null && !z2) {
                z3 = true;
            }
            if (z4) {
                TbWebViewActivity.startActivityWithoutNavBar(context, aQ, true, null);
            } else if (U == 1 || !z3) {
                if (parseBDUSS != null && z) {
                    WebTbActivity.a(context, aQ, parseBDUSS.mBduss, parseBDUSS.mPtoken, z5, z6);
                } else {
                    WebTbActivity.a(context, aQ, null, null, z5, z6);
                }
            } else if (Build.VERSION.SDK_INT >= 7 && U == 0) {
                if (parseBDUSS != null && z) {
                    WebBdActivity.a(context, aQ, parseBDUSS.mBduss, parseBDUSS.mPtoken, z5, z6);
                } else {
                    WebBdActivity.a(context, aQ, null, null, z5, z6);
                }
            } else {
                k(context, aQ);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void a(Context context, String str, String str2) {
        boolean z;
        boolean z2 = false;
        BdBrowserDelegate bdBrowserDelegate = null;
        try {
            int U = com.baidu.adp.lib.b.f.db().U("baidu_webview");
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            String aQ = aQ(aP(str2));
            boolean z3 = aQ.indexOf("tbwebview=1") > 0;
            boolean z4 = aQ.indexOf("tborientation=1") > 0;
            boolean z5 = aQ.indexOf("tbfullscreen=1") > 0;
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BROWSER);
            if (pluginByName != null) {
                bdBrowserDelegate = (BdBrowserDelegate) pluginByName.getClassInstance(BdBrowserDelegate.class);
                z = !pluginByName.checkEnable();
            } else {
                z = true;
            }
            if (!z3 && PluginCenter.getInstance() != null && bdBrowserDelegate != null && !z) {
                z2 = true;
            }
            if (z3) {
                TbWebViewActivity.startActivityWithoutNavBar(context, str, aQ, true, null);
            } else if (U == 1 || !z2) {
                if (parseBDUSS != null) {
                    WebTbActivity.a(context, aQ, parseBDUSS.mBduss, parseBDUSS.mPtoken, z4, z5);
                } else {
                    WebTbActivity.a(context, aQ, null, null, z4, z5);
                }
            } else if (Build.VERSION.SDK_INT >= 7 && U == 0) {
                if (parseBDUSS != null) {
                    WebBdActivity.a(context, aQ, parseBDUSS.mBduss, parseBDUSS.mPtoken, z4, z5);
                } else {
                    WebBdActivity.a(context, aQ, null, null, z4, z5);
                }
            } else {
                k(context, aQ);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void j(Context context, String str) {
        boolean z;
        BdBrowserDelegate bdBrowserDelegate = null;
        boolean z2 = false;
        String aQ = aQ(aP(str));
        try {
            int U = com.baidu.adp.lib.b.f.db().U("baidu_webview");
            AccountLoginHelper.OurToken parseBDUSS = AccountLoginHelper.parseBDUSS(TbadkApplication.getCurrentBduss());
            boolean z3 = aQ.indexOf("tbwebview=1") > 0;
            boolean z4 = aQ.indexOf("tborientation=1") > 0;
            boolean z5 = aQ.indexOf("tbfullscreen=1") > 0;
            Plugin pluginByName = PluginCenter.getInstance().getPluginByName(PluginNameList.NAME_BROWSER);
            if (pluginByName != null) {
                bdBrowserDelegate = (BdBrowserDelegate) pluginByName.getClassInstance(BdBrowserDelegate.class);
                z = !pluginByName.checkEnable();
            } else {
                z = true;
            }
            if (!z3 && PluginCenter.getInstance() != null && bdBrowserDelegate != null && !z) {
                z2 = true;
            }
            if (!z3 && Build.VERSION.SDK_INT > 7 && U == 0 && z2) {
                if (parseBDUSS != null) {
                    WebBdActivity.a(context, aQ, parseBDUSS.mBduss, parseBDUSS.mPtoken, z4, z5);
                } else {
                    WebBdActivity.a(context, aQ, null, null, z4, z5);
                }
            } else if (parseBDUSS != null) {
                WebTbActivity.a(context, aQ, parseBDUSS.mBduss, parseBDUSS.mPtoken, z4, z5);
            } else {
                WebTbActivity.a(context, aQ, null, null, z4, z5);
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void k(Context context, String str) {
        String aQ = aQ(aP(str));
        try {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.setData(Uri.parse(aQ));
            if (!(context instanceof Activity)) {
                intent.addFlags(268435456);
            }
            context.startActivity(intent);
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static String aP(String str) {
        if (!az.aA(str) && str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append("&");
            } else {
                sb.append("?");
            }
            sb.append("cuid=");
            sb.append(TbadkApplication.m251getInst().getCuid());
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String aQ(String str) {
        return (az.aA(str) || str.indexOf("_client_version=") <= -1) ? String.valueOf(str) + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void s(Context context) {
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

    public static void WebViewNoDataBase(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }
}
