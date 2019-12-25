package com.baidu.live.tbadk.browser;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Pair;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.webkit.WebSettings;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.message.CustomMessage;
import com.baidu.live.adp.lib.util.BdLog;
import com.baidu.live.adp.lib.util.StringUtils;
import com.baidu.live.tbadk.TbConfig;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.account.AccountLoginCoreHelper;
import com.baidu.live.tbadk.core.account.StokenPolicy;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.util.StringHelper;
import com.baidu.live.tbadk.core.util.UtilHelper;
import com.baidu.sapi2.utils.SapiUtils;
import com.baidu.tieba.compatible.CompatibleUtile;
import com.baidu.webkit.internal.ETAG;
import java.util.List;
/* loaded from: classes2.dex */
public class BrowserHelper {
    static String parseWebViewUrl(String str, String str2) {
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
        try {
            if (!StringUtils.isNull(str2)) {
                if (z5) {
                    str2 = appendVersionCode(appendCuidParam(str2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WEB_BROWSER, str2));
            }
        } catch (Exception e) {
            BdLog.e(e.getMessage());
        }
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6) {
        startWebActivity(context, str, str2, z, z2, z3, z4, z5, z6, false);
    }

    public static void startWebActivity(Context context, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4, boolean z5, boolean z6, boolean z7) {
        try {
            if (!StringUtils.isNull(str2)) {
                if (z5) {
                    str2 = appendVersionCode(appendCuidParam(str2));
                }
                MessageManager.getInstance().sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_OPEN_WEB_BROWSER, str2));
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
        if (!StringHelper.isEmpty(str) && list != null) {
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
        if (!StringHelper.isEmpty(str) && str.indexOf("cuid=") <= -1) {
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
            }
            sb.append("&timestamp=");
            sb.append(Long.toString(System.currentTimeMillis()));
            return sb.toString();
        }
        return str;
    }

    public static String appendVersionCode(String str) {
        return (StringHelper.isEmpty(str) || str.indexOf("_client_version=") <= -1) ? str + "&_client_version=" + TbConfig.getVersion() : str;
    }

    public static void initCookie(Context context) {
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
            if (AccountLoginCoreHelper.getInstance().parseBDUSS(TbadkCoreApplication.getCurrentBduss()) != null) {
                String verificatedStoken = StokenPolicy.getVerificatedStoken(TbadkCoreApplication.getCurrentAccountInfo());
                StringBuilder sb = new StringBuilder();
                if (!StringUtils.isNull(verificatedStoken)) {
                    sb.append("STOKEN=").append(verificatedStoken).append("; domain=.tieba.baidu.com;");
                    cookieManager.setCookie("tieba.baidu.com", sb.toString());
                }
            } else {
                try {
                    cookieManager.removeAllCookie();
                } catch (Exception e) {
                    BdLog.e(e);
                }
            }
            cookieManager.setCookie("baidu.com", "CUID=" + TbadkCoreApplication.getInst().getCuid() + "; domain=.baidu.com;");
            try {
                CookieSyncManager.getInstance().sync();
            } catch (Exception e2) {
                BdLog.e(e2);
            }
        }
    }

    public static void WebViewNoDataBase(WebSettings webSettings) {
        CompatibleUtile.getInstance().WebViewNoDataBase(webSettings);
    }
}
