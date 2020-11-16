package com.baidu.live.utils;

import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes4.dex */
public class k {
    public static String aU(long j) {
        long j2 = j / 60000;
        long j3 = (j % 60000) / 1000;
        String str = (j2 < 10 ? "0" : "") + j2 + ":";
        if (j3 < 10) {
            str = str + "0";
        }
        return str + j3;
    }

    public static String b(Date date) {
        return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).format(date);
    }

    public static Date iy(String str) {
        try {
            return new SimpleDateFormat(ControlShowManager.DAY_TIME_FORMAT).parse(str);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static boolean c(Date date) {
        boolean z = true;
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        if (calendar.get(1) != calendar2.get(1) || calendar.get(2) != calendar2.get(2)) {
            z = false;
        }
        return z;
    }

    public static boolean d(Date date) {
        boolean z = true;
        if (date == null) {
            return false;
        }
        Calendar calendar = Calendar.getInstance();
        calendar.setTime(new Date());
        Calendar calendar2 = Calendar.getInstance();
        calendar2.setTime(date);
        if (calendar.get(1) != calendar2.get(1) || calendar.get(2) != calendar2.get(2) || calendar.get(5) != calendar2.get(5)) {
            z = false;
        }
        return z;
    }
}
