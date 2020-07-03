package com.baidu.swan.apps.aq;

import android.text.TextUtils;
import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public final class i {
    private static final Set<Integer> cOy = new HashSet();
    private static final Set<Integer> cOz = new HashSet();
    private static final Set<Integer> cOA = new HashSet();

    static {
        cOy.add(2);
        cOy.add(3);
        cOy.add(4);
        cOy.add(5);
        cOy.add(6);
        cOz.add(7);
        cOz.add(1);
        cOA.addAll(cOy);
        cOA.addAll(cOz);
    }

    public static Date auw() {
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

    public static Date cb(String str, String str2) {
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
}
