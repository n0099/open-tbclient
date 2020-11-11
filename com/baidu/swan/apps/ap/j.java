package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes10.dex */
public final class j {
    private static final Set<Integer> dDB = new HashSet();
    private static final Set<Integer> dDC = new HashSet();
    private static final Set<Integer> dDD = new HashSet();

    static {
        dDB.add(2);
        dDB.add(3);
        dDB.add(4);
        dDB.add(5);
        dDB.add(6);
        dDC.add(7);
        dDC.add(1);
        dDD.addAll(dDB);
        dDD.addAll(dDC);
    }

    public static Date aMv() {
        return new Date();
    }

    public static String a(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public static Date cG(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).parse(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static Date e(String str, String[] strArr) {
        Date date = null;
        if (!TextUtils.isEmpty(str) && strArr != null) {
            for (String str2 : strArr) {
                try {
                    date = new SimpleDateFormat(str2).parse(str);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                if (date != null) {
                    break;
                }
            }
        }
        return date;
    }

    public static String b(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public static String h(long j, String str) {
        try {
            return new SimpleDateFormat((str == null || str.isEmpty()) ? "yyyy-MM-dd HH:mm:ss" : "yyyy-MM-dd HH:mm:ss").format(new Date(j));
        } catch (NumberFormatException e) {
            if (com.baidu.swan.apps.b.DEBUG) {
                e.printStackTrace();
            }
            return "";
        }
    }
}
