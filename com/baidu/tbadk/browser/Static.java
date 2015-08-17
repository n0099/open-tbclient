package com.baidu.tbadk.browser;

import android.app.ActivityManager;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.text.TextUtils;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.lib.util.BdLog;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.TbadkCoreApplication;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ax;
import com.baidu.tbadk.coreExtra.data.WhiteListData;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;
/* loaded from: classes.dex */
public class Static {
    public static boolean Sm = true;

    static {
        MessageManager.getInstance().registerListener(CmdConfigCustom.METHOD_ACCOUNT_CHANGE, new g(0));
        ax.uR().a(new h());
        ax.uR().a(new i());
        com.baidu.adp.lib.b.e.gy().a(new com.baidu.adp.lib.b.c("switch_mbaidu_startup", 1, null));
    }

    private static String bQ(String str) {
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

    private static String bR(String str) {
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
        if (!bT(bQ) && qw() && bV("com.baidu.searchbox") && bU(bQ) && Sm) {
            TiebaStatic.eventStat(tbPageContext.getPageActivity(), "url_2", null);
            b(tbPageContext, str, str2, z, z2, z3, z4);
            return;
        }
        c(tbPageContext, str, str2, z, z2, z3, z4);
    }

    private static boolean bT(String str) {
        return WhiteListData.createBySP().checkUrl(str);
    }

    private static boolean qw() {
        return com.baidu.adp.lib.b.e.gy().ah("switch_mbaidu_startup") == 1;
    }

    private static boolean bU(String str) {
        return str.startsWith("http://") || str.startsWith("https://") || !str.contains("://");
    }

    private static boolean bV(String str) {
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
        j jVar = new j(tbPageContext, str, str2, z, z2, z3, z4);
        String T = f.T(str, null);
        Intent intent = new Intent();
        intent.setAction("com.baidu.searchbox.action.VIEW");
        intent.addCategory("android.intent.category.DEFAULT");
        intent.addFlags(268435456);
        intent.setData(Uri.parse(T));
        intent.putExtra("EXTRA_URL_NEW_WINDOW", true);
        try {
            try {
                TbadkCoreApplication.m411getInst().startActivity(intent);
                jVar.sendEmptyMessageDelayed(1, 2000L);
            } catch (ActivityNotFoundException e) {
                BdLog.e(e);
                jVar.sendEmptyMessageDelayed(1, 2000L);
            }
        } catch (Throwable th) {
            jVar.sendEmptyMessageDelayed(1, 2000L);
            throw th;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static boolean qx() {
        List<ActivityManager.RunningAppProcessInfo> runningAppProcesses = ((ActivityManager) TbadkCoreApplication.m411getInst().getSystemService("activity")).getRunningAppProcesses();
        if (runningAppProcesses != null && runningAppProcesses.size() > 0) {
            ActivityManager.RunningAppProcessInfo runningAppProcessInfo = runningAppProcesses.get(0);
            if (runningAppProcessInfo.processName.equals(TbadkCoreApplication.m411getInst().getPackageName()) && runningAppProcessInfo.importance == 100) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static void c(TbPageContext<?> tbPageContext, String str, String str2, boolean z, boolean z2, boolean z3, boolean z4) {
        String bR = bR(str);
        if (z) {
            com.baidu.tbadk.coreExtra.util.a.a(tbPageContext, new k(tbPageContext, str2, bR), new l(), bR);
        } else {
            f.f(tbPageContext.getPageActivity(), str2, bR);
        }
    }
}
