package com.baidu.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Build;
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
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.sapi2.SapiAccountManager;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.TbWebViewActivityConfig;
import com.baidu.tbadk.core.util.UtilHelper;
import com.baidu.tbadk.core.util.aj;
import com.baidu.tbadk.core.util.at;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.util.Base64Encoder;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
/* loaded from: classes.dex */
public class a {
    public static String dSk;

    /* JADX INFO: Access modifiers changed from: package-private */
    public static String parseWebViewUrl(String str, String str2) {
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

    public static void ye(String str) {
        dSk = str;
    }

    public static void startWebActivity(Context context, String str) {
        startWebActivity(context, true, str);
    }

    public static void startWebActivity(Context context, boolean z, String str) {
        startWebActivity(context, "", str, true, true, true, true, z);
    }

    public static void startWebActivity(Context context, boolean z, String str, String str2) {
        startWebActivity(context, str2, str, true, true, true, true, z);
    }

    public static void startWebActivity(Context context, String str, String str2) {
        startWebActivity(context, str, str2, true, true, true, true, true);
    }

    public static void startWebActivity(boolean z, Context context, String str, String str2) {
        startWebActivity(context, str, str2, true, true, true, true, true, false, z);
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z) {
        startWebActivity(context, str, str2, true, z, true, true, true);
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3) {
        startWebActivity(context, str, str2, z, z2, z3, true, true);
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5) {
        baW();
        try {
            if (!StringUtils.isNull(str2)) {
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, new TbWebViewActivityConfig(context, str, z5 ? appendVersionCode(appendCuidParam(str2)) : str2, z, z2, z3)));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        startWebActivity(context, str, str2, z, z2, z3, z4, z5, z6, false);
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        baW();
        try {
            if (!StringUtils.isNull(str2)) {
                TbWebViewActivityConfig tbWebViewActivityConfig = new TbWebViewActivityConfig(context, str, z5 ? appendVersionCode(appendCuidParam(str2)) : str2, z, z2, z3, z6);
                tbWebViewActivityConfig.setFixTitle(z7);
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.START_GO_ACTION, tbWebViewActivityConfig));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void startInternalWebActivity(Context context, String str) {
        startWebActivity(context, str);
    }

    public static void startExternWebActivity(Context context, String str) {
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

    public static String appendParams(String str, List<Pair<String, String>> list) {
        if (!at.isEmpty(str) && list != null) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") < 0) {
                sb.append("?");
            }
            for (Pair<String, String> pair : list) {
                if (pair != null && !TextUtils.isEmpty((CharSequence) pair.first)) {
                    sb.append(ETAG.ITEM_SEPARATOR);
                    sb.append((String) pair.first);
                    sb.append(ETAG.EQUAL);
                    sb.append((String) pair.second);
                }
            }
            return sb.toString();
        }
        return str;
    }

    public static String appendCuidParam(String str) {
        if (!at.isEmpty(str) && str.indexOf("cuid=") <= -1) {
            StringBuilder sb = new StringBuilder();
            sb.append(str);
            if (str.indexOf("?") > 0) {
                sb.append(ETAG.ITEM_SEPARATOR);
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
        return (at.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? str + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void initCookie(Context context) {
        CookieManager cookieManager = null;
        try {
            CookieSyncManager.createInstance(TbadkCoreApplication.getInst());
            cookieManager = CookieManager.getInstance();
        } catch (Throwable th) {
            BdLog.e(th);
        }
        if (cookieManager != null) {
            cookieManager.setAcceptCookie(true);
            if (com.baidu.tbadk.core.a.a.bbN().yN(TbadkCoreApplication.getCurrentBduss()) != null) {
                String c = com.baidu.tbadk.core.a.d.c(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(c)) {
                    sb.append("STOKEN=").append(c).append("; domain=.tieba.baidu.com;");
                    cookieManager.setCookie("tieba.baidu.com", sb.toString());
                }
            } else {
                try {
                    if (Build.VERSION.SDK_INT >= 21) {
                        cookieManager.removeAllCookies(null);
                        CookieManager.getInstance().flush();
                    } else {
                        cookieManager.removeAllCookie();
                        CookieSyncManager.createInstance(context);
                        CookieSyncManager.getInstance().sync();
                    }
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            cookieManager.setCookie(".baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            String cuidGalaxy2 = TbadkCoreApplication.getInst().getCuidGalaxy2();
            String str = "";
            if (!TextUtils.isEmpty(cuidGalaxy2)) {
                str = new String(Base64Encoder.B64Encode(cuidGalaxy2.getBytes()));
            }
            cookieManager.setCookie(".baidu.com", "BAIDUCUID=" + str + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            cookieManager.setCookie(".baidu.com", "TBBRAND=" + Build.MODEL + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            cookieManager.setCookie(".baidu.com", "BAIDUZID=" + TbadkCoreApplication.getInst().getZid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            cookieManager.setCookie(".baidu.com", "cuid_galaxy2=" + cuidGalaxy2 + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            cookieManager.setCookie(".baidu.com", "cuid_gid=" + TbadkCoreApplication.getInst().getCuidGid() + ContentProviderProxy.PROVIDER_AUTHOR_SEPARATOR);
            try {
                if (Build.VERSION.SDK_INT >= 21) {
                    CookieManager.getInstance().flush();
                } else {
                    CookieSyncManager.getInstance().sync();
                }
                SapiAccountManager.getInstance().getAccountService().webLogin(context);
            } catch (Throwable th2) {
                BdLog.e(th2);
            }
        }
    }

    public static void WebViewNoDataBase(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }

    private static void baW() {
        new aj("open_webview", true).start();
    }
}
