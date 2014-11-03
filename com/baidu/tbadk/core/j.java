package com.baidu.tbadk.core;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class j {
    public static void l(Context context, String str) {
        TiebaStatic.eventStat(context, str, "click", 1, new Object[0]);
    }

    public static void m(Context context, String str) {
        TiebaStatic.eventStat(context, str, "visit", 1, new Object[0]);
    }
}
