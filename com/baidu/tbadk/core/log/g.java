package com.baidu.tbadk.core.log;

import android.text.TextUtils;
import com.baidu.adp.lib.util.BdLog;
/* loaded from: classes.dex */
public class g {
    private static String a = "";
    private static boolean b = false;

    public static boolean a(LoggerItem loggerItem) {
        if (loggerItem == null) {
            return false;
        }
        return a(loggerItem.getType());
    }

    public static boolean a(String str) {
        return com.baidu.adp.lib.a.f.a().b(str) == 0;
    }

    public static String b(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        return str.replace('\t', '@').replace('\n', '@');
    }

    public static void a() {
        try {
            a = com.baidu.adp.lib.stats.h.a().b();
        } catch (Exception e) {
            BdLog.d(e.getMessage());
        }
    }

    public static String b() {
        if (TextUtils.isEmpty(a) && !b) {
            a();
            b = true;
        }
        return a;
    }
}
