package com.baidu.live.utils;

import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.u.a;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Formatter;
import java.util.Locale;
/* loaded from: classes3.dex */
public class i {
    public static String numFormatOverWanNaForAudienceNum(long j) {
        if (j > 99990000) {
            return String.format("9999%s+", TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan));
        }
        if (j >= 10000000) {
            return String.valueOf(j / 10000) + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
        }
        if (j > 10000) {
            return String.format(Locale.getDefault(), "%.1f%s", Float.valueOf(((float) j) / 10000.0f), TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan));
        }
        if (j == 10000) {
            return "1" + TbadkCoreApplication.getInst().getResources().getString(a.i.sdk_unit_wan);
        }
        if (j < 0) {
            return "--";
        }
        return "" + j;
    }

    public static String formatTosepara(long j) {
        return new DecimalFormat("#,###").format(j);
    }

    public static String getCountDownTime(Long l) {
        return new SimpleDateFormat("HH:mm:ss").format(new Date((l.longValue() * 1000) - 28800000));
    }

    public static String b(Long l) {
        return new SimpleDateFormat("mm:ss").format(new Date((l.longValue() * 1000) - 28800000));
    }

    public static String cW(int i) {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyyMMddHH");
        Date date = new Date();
        date.setHours(date.getHours() - i);
        return simpleDateFormat.format(date);
    }

    public static String AY() {
        return new SimpleDateFormat("HH").format(new Date());
    }

    public static String AZ() {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH");
        Date date = new Date();
        date.setHours(date.getHours() - 1);
        return simpleDateFormat.format(date);
    }

    public static String stringForLastTime(int i) {
        if (i < 1) {
            i = 1;
        }
        int i2 = i % 60;
        int i3 = (i / 60) % 60;
        int i4 = i / 3600;
        StringBuilder sb = new StringBuilder();
        Formatter formatter = new Formatter(sb, Locale.getDefault());
        sb.setLength(0);
        return i4 > 0 ? formatter.format("%d:%02d:%02d", Integer.valueOf(i4), Integer.valueOf(i3), Integer.valueOf(i2)).toString() : formatter.format("%02d:%02d", Integer.valueOf(i3), Integer.valueOf(i2)).toString();
    }
}
