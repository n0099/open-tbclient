package com.baidu.swan.apps.an;

import android.text.TextUtils;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes2.dex */
public final class e {
    private static final Set<Integer> aWe = new HashSet();
    private static final Set<Integer> aWf = new HashSet();
    private static final Set<Integer> aWg = new HashSet();

    static {
        aWe.add(2);
        aWe.add(3);
        aWe.add(4);
        aWe.add(5);
        aWe.add(6);
        aWf.add(7);
        aWf.add(1);
        aWg.addAll(aWe);
        aWg.addAll(aWf);
    }

    public static Date LO() {
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
                return null;
            }
        }
    }

    public static Date aJ(String str, String str2) {
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

    public static Date d(String str, String[] strArr) {
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
}
