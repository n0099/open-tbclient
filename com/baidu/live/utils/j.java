package com.baidu.live.utils;

import com.baidu.searchbox.ui.animview.praise.guide.ControlShowManager;
import java.text.SimpleDateFormat;
import java.util.Date;
/* loaded from: classes3.dex */
public class j {
    public static String at(long j) {
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
}
