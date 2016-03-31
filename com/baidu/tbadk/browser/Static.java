package com.baidu.tbadk.browser;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomMessage;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.atomData.LegoListActivityConfig;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.bg;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
/* loaded from: classes.dex */
public class Static {
    public static boolean Py = true;

    static {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new h(0));
        bg.wM().a(new i());
        com.baidu.adp.lib.c.e.gE().a(new com.baidu.adp.lib.c.c("switch_mbaidu_startup", 1, null));
        pN();
        pQ();
        pR();
    }

    private static void pN() {
        bg.wM().a(new j());
    }

    private static String bS(String str) {
        String str2;
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.m411getInst().getCheckUrl();
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

    private static String bT(String str) {
        if (StringUtils.isNull(str)) {
            return "";
        }
        String checkUrl = TbadkCoreApplication.m411getInst().getCheckUrl();
        if (checkUrl == null) {
            checkUrl = "http://tieba.baidu.com/mo/q/checkurl?url=";
        } else if (checkUrl.trim().length() == 0) {
            return str;
        }
        if (!str.startsWith(checkUrl)) {
            return String.valueOf(checkUrl) + bU(str);
        }
        return str;
    }

    public static String bU(String str) {
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
        String bS = bS(str);
        if (!bV(bS) && pO() && bX("com.baidu.searchbox") && bW(bS) && Py) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_2", null);
            b(tbPageContext, str, str2, z, z2, z3, z4);
            return;
        }
        c(tbPageContext, str, str2, z, z2, z3, z4);
    }

    private static boolean bV(String str) {
        return WhiteListData.createBySP().checkUrl(str);
    }

    private static boolean pO() {
        return com.baidu.adp.lib.c.e.gE().ai("switch_mbaidu_startup") == 1;
    }

    private static boolean bW(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || !str.contains("://");
    }

    private static boolean bX(String str) {
        try {
            PackageInfo packageInfo = TbadkCoreApplication.m411getInst().getPackageManager().getPackageInfo(str, 1);
            if (packageInfo == null) {
                return false;
            }
            return str.equals(packageInfo.packageName);
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    private static void b(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        k kVar = new k(tbPageContext, str, str2, z, z2, z3, z4);
        String M = f.M(str, null);
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(M));
        intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
        try {
            try {
                TbadkCoreApplication.m411getInst().startActivity(intent);
                kVar.sendEmptyMessageDelayed(1, 2000L);
            } catch (ActivityNotFoundException e) {
                BdLog.e(e);
                kVar.sendEmptyMessageDelayed(1, 2000L);
            }
        } catch (Throwable th) {
            kVar.sendEmptyMessageDelayed(1, 2000L);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean pP() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.m411getInst().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            for (ActivityManager.RunningAppProcessInfo runningAppProcessInfo : runningAppProcesses) {
                if (runningAppProcessInfo != null && !StringUtils.isNull(runningAppProcessInfo.processName) && runningAppProcessInfo.processName.equals(TbadkCoreApplication.m411getInst().getPackageName()) && runningAppProcessInfo.importance == 100) {
                    return true;
                }
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String bT = bT(str);
        if (z) {
            com.baidu.tbadk.coreExtra.e.a.a(tbPageContext, new l(tbPageContext, str2, bT), new m(), bT);
        } else {
            f.c(tbPageContext.getPageActivity(), str2, bT);
        }
    }

    private static void pQ() {
        bg.wM().a(new n());
    }

    private static void pR() {
        bg.wM().a(new o());
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean a(TbPageContext<?> tbPageContext, Uri uri, String str) {
        int i;
        if (tbPageContext == null || uri == null) {
            return false;
        }
        if (str == null || str.length() == 0) {
            str = uri.getQueryParameter(LegoListActivityConfig.PAGE_ID);
        }
        String queryParameter = uri.getQueryParameter(LegoListActivityConfig.PAGE_TYPE);
        String queryParameter2 = uri.getQueryParameter(LegoListActivityConfig.ITEM_ID);
        String queryParameter3 = uri.getQueryParameter(LegoListActivityConfig.RN);
        String queryParameter4 = uri.getQueryParameter(LegoListActivityConfig.PARAMS);
        if (str == null || queryParameter == null || str.length() <= 0 || queryParameter.length() <= 0) {
            return false;
        }
        try {
            int parseInt = Integer.parseInt(queryParameter);
            try {
                long parseLong = Long.parseLong(str);
                try {
                    i = Integer.parseInt(queryParameter3);
                } catch (Exception e) {
                    i = 20;
                }
                tbPageContext.sendMessage(new CustomMessage((int) CmdConfigCustom.CMD_LEGO_LIST, new LegoListActivityConfig(tbPageContext.getPageActivity()).createNormalCfg(parseLong, parseInt, queryParameter2, i, queryParameter4)));
                return true;
            } catch (Exception e2) {
                return false;
            }
        } catch (Exception e3) {
            return false;
        }
    }

    public static boolean bY(String str) {
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
