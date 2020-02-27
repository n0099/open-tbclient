package com.baidu.swan.apps.as;

import android.text.TextUtils;
import com.baidu.android.util.time.DateTimeUtil;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;
/* loaded from: classes11.dex */
public final class h {
    private static final Set<Integer> WORK_DAY = new HashSet();
    private static final Set<Integer> WEEKEND_DAY = new HashSet();
    private static final Set<Integer> NORMAL_DAY = new HashSet();

    static {
        WORK_DAY.add(2);
        WORK_DAY.add(3);
        WORK_DAY.add(4);
        WORK_DAY.add(5);
        WORK_DAY.add(6);
        WEEKEND_DAY.add(7);
        WEEKEND_DAY.add(1);
        NORMAL_DAY.addAll(WORK_DAY);
        NORMAL_DAY.addAll(WEEKEND_DAY);
    }

    public static Date getCurrDate() {
        return new Date();
    }

    public static String getFormatDate(Date date, String str) {
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

    public static Date getFormatDate(String str, String str2) {
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

    public static Date getFormatDate(String str, String[] strArr) {
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

    public static String getFormatDateTime(Date date, String str) {
        if (date == null) {
            return "";
        }
        try {
            return new SimpleDateFormat(str).format(date);
        } catch (Exception e) {
            try {
                return new SimpleDateFormat(DateTimeUtil.TIME_FORMAT).format(date);
            } catch (Exception e2) {
                e2.printStackTrace();
                return "";
            }
        }
    }
}
