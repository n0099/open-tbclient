package com.baidu.swan.apps.ao;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes9.dex */
public final class j {
    private static final Set<Integer> dRx = new HashSet();
    private static final Set<Integer> dRy = new HashSet();
    private static final Set<Integer> dRz = new HashSet();

    static {
        dRx.add(2);
        dRx.add(3);
        dRx.add(4);
        dRx.add(5);
        dRx.add(6);
        dRy.add(7);
        dRy.add(1);
        dRz.addAll(dRx);
        dRz.addAll(dRy);
    }

    public static Date aRl() {
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
                return new SimpleDateFormat("yyyy-MM-dd").format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }

    public static Date cL(String str, String str2) {
        if (str == null) {
            return null;
        }
        try {
            return new SimpleDateFormat(str2).parse(str);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(str);
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }
    }

    public static Date f(String str, String[] strArr) {
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

    public static String i(long j, String str) {
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
