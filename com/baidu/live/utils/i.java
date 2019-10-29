package com.baidu.live.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes6.dex */
public class i {
    public static String H(long j) {
        long j2 = j / 60000;
        long j3 = (j % 60000) / 1000;
        String str = (j2 < 10 ? "0" : "") + j2 + ":";
        if (j3 < 10) {
            str = str + "0";
        }
        return str + j3;
    }

    public static String b(Date date) {
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }
}
