package com.baidu.swan.apps.ap;

import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes3.dex */
public final class j {
    private static final Set<Integer> dda = new HashSet();
    private static final Set<Integer> ddb = new HashSet();
    private static final Set<Integer> ddc = new HashSet();

    static {
        dda.add(2);
        dda.add(3);
        dda.add(4);
        dda.add(5);
        dda.add(6);
        ddb.add(7);
        ddb.add(1);
        ddc.addAll(dda);
        ddc.addAll(ddb);
    }

    public static Date aFs() {
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

    public static Date cu(String str, String str2) {
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

    public static String f(long j, String str) {
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
