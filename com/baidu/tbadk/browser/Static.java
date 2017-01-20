package com.baidu.tbadk.browser;

import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbConfig;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ba;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
/* loaded from: classes.dex */
public class Static {
    public static boolean LN = true;

    static {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new i(0));
        ba.vt().a(new j());
        com.baidu.adp.lib.b.e.dL().a(new com.baidu.adp.lib.b.c("switch_mbaidu_startup", 1, null));
        nO();
        nQ();
        nR();
    }

    private static void nO() {
        ba.vt().a(new k());
    }

    private static String bQ(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.m9getInst().getCheckUrl();
        boolean z = !TextUtils.isEmpty(checkUrl) && str.startsWith(checkUrl);
        boolean startsWith = str.startsWith("http://tieba.baidu.com/mo/q/checkurl?url=");
        if (z || startsWith) {
            if (z) {
                str2 = str.substring(checkUrl.length());
            } else if (!startsWith) {
                str2 = null;
            } else {
                str2 = str.substring("http://tieba.baidu.com/mo/q/checkurl?url=".length());
            }
            if (!TextUtils.isEmpty(str2)) {
                try {
                    return URLDecoder.decode(str2, "UTF-8");
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                    return str;
                }
            }
            return str;
        }
        return str;
    }

    private static String bR(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.m9getInst().getCheckUrl();
        if (checkUrl == null) {
            checkUrl = "http://tieba.baidu.com/mo/q/checkurl?url=";
        } else if (checkUrl.trim().length() == 0) {
            return str;
        }
        if (!str.startsWith(checkUrl)) {
            return String.valueOf(checkUrl) + bS(str);
        }
        return str;
    }

    public static String bS(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        try {
            String str2 = new String(str.getBytes(), "UTF-8");
            try {
                return URLEncoder.encode(str2, "UTF-8");
            } catch (Exception e) {
                return str2;
            }
        } catch (Exception e2) {
            return str;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void a(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_1", null);
        String bQ = bQ(str);
        if (!bT(bQ) && nP() && bV("com.baidu.searchbox") && bU(bQ) && LN) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_2", null);
            b(tbPageContext, str, str2, z, z2, z3, z4);
            return;
        }
        c(tbPageContext, str, str2, z, z2, z3, z4);
    }

    private static boolean bT(String str) {
        return WhiteListData.createBySP().checkUrl(str);
    }

    private static boolean nP() {
        return com.baidu.adp.lib.b.e.dL().ac("switch_mbaidu_startup") == 1;
    }

    private static boolean bU(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || !str.contains("://");
    }

    private static boolean bV(String str) {
        try {
            PackageInfo packageInfo = TbadkCoreApplication.m9getInst().getPackageManager().getPackageInfo(str, 1);
            if (packageInfo == null) {
                return false;
            }
            return str.equals(packageInfo.packageName);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static void b(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String L = f.L(str, null);
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(L));
        intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
        try {
            TbadkCoreApplication.m9getInst().startActivity(intent);
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_3", null);
        } catch (Exception e) {
            BdLog.e(e);
            c(tbPageContext, str, str2, z, z2, z3, z4);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String bR = bR(str);
        if (z) {
            com.baidu.tbadk.coreExtra.e.a.a(tbPageContext, new l(tbPageContext, str2, bR), new m(), bR);
        } else {
            f.c(tbPageContext.getPageActivity(), str2, bR);
        }
    }

    private static void nQ() {
        ba.vt().a(new n());
    }

    private static void nR() {
        ba.vt().a(new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(TbPageContext<?> tbPageContext, Uri uri, String str, boolean z) {
        int i;
        int i2;
        int i3;
        String str2;
        int i4;
        if (tbPageContext == null || uri == null) {
            return false;
        }
        if (str == null || str.length() == 0) {
            str = uri.getQueryParameter("page_id");
        }
        String queryParameter = uri.getQueryParameter("page_type");
        String queryParameter2 = uri.getQueryParameter(LegoListActivityConfig.ITEM_ID);
        String queryParameter3 = uri.getQueryParameter(LegoListActivityConfig.RN);
        String queryParameter4 = uri.getQueryParameter(LegoListActivityConfig.PARAMS);
        String queryParameter5 = uri.getQueryParameter(LegoListActivityConfig.PRE_LOAD);
        String queryParameter6 = uri.getQueryParameter(LegoListActivityConfig.NEXT_PAGE);
        String queryParameter7 = uri.getQueryParameter("lego_version");
        String queryParameter8 = uri.getQueryParameter(LegoListActivityConfig.IS_IMMERSIVE);
        String queryParameter9 = uri.getQueryParameter(LegoListActivityConfig.HAS_ANIMATION);
        String queryParameter10 = uri.getQueryParameter(LegoListActivityConfig.IS_LANDINGPAGE);
        String queryParameter11 = uri.getQueryParameter("source");
        String str3 = TextUtils.isEmpty(queryParameter11) ? "unknown" : queryParameter11;
        if ((!z || bW(queryParameter7)) && str != null && queryParameter != null && str.length() > 0 && queryParameter.length() > 0) {
            try {
                int parseInt = Integer.parseInt(queryParameter);
                try {
                    long parseLong = Long.parseLong(str);
                    try {
                        i = Integer.parseInt(queryParameter3);
                    } catch (Exception e) {
                        i = 20;
                    }
                    try {
                        i2 = Integer.parseInt(queryParameter8);
                    } catch (Exception e2) {
                        i2 = 0;
                    }
                    try {
                        i3 = Integer.parseInt(queryParameter9);
                    } catch (Exception e3) {
                        i3 = 0;
                    }
                    if (i3 != 1) {
                        str2 = "";
                    } else {
                        str2 = uri.getQueryParameter(LegoListActivityConfig.ANIMATION_INFO);
                    }
                    try {
                        i4 = Integer.parseInt(queryParameter10);
                    } catch (Exception e4) {
                        i4 = 0;
                    }
                    LegoListActivityConfig createNormalCfg = new LegoListActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(parseLong, parseInt, queryParameter2, i2, i, queryParameter4);
                    createNormalCfg.addLandingPageParams(str2, queryParameter5, queryParameter6, i3, i4, str3);
                    tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_LEGO_LIST, createNormalCfg));
                    return true;
                } catch (Exception e5) {
                    return false;
                }
            } catch (Exception e6) {
                return false;
            }
        }
        return false;
    }

    private static boolean bW(String str) {
        if (TextUtils.isEmpty(str)) {
            str = "1.0.0";
        }
        return TbConfig.getLegoLibVersion().compareTo(str) >= 0;
    }

    public static boolean bX(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        try {
            return "lego".equalsIgnoreCase(Uri.parse(str).getAuthority());
        } catch (Throwable th) {
            return false;
        }
    }
}
