package com.baidu.fsg.base.utils;

import android.text.TextUtils;
import java.util.Calendar;
/* loaded from: classes5.dex */
public class CalendarUtil {
    public static String getYYYYMMDD(Calendar calendar, String str) {
        if (calendar == null) {
            return "";
        }
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        return calendar.get(1) + str + (calendar.get(2) + 1) + str + calendar.get(5);
    }
}
