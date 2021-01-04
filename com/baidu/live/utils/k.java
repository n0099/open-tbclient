package com.baidu.live.utils;

import com.kwad.sdk.collector.AppStatusRules;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
/* loaded from: classes11.dex */
public class k {
    public static String bs(long j) {
        long j2 = j / AppStatusRules.DEFAULT_GRANULARITY;
        long j3 = (j % AppStatusRules.DEFAULT_GRANULARITY) / 1000;
        String str = (j2 < 10 ? "0" : "") + j2 + ":";
        if (j3 < 10) {
            str = str + "0";
        }
        return str + j3;
    }

    public static String b(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static Date iR(String str) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd").parse(str);
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
