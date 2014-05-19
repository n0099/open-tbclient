package com.baidu.tbadk.core;

import android.content.Context;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
public class g {
    public static void a(Context context, String str) {
        TiebaStatic.eventStat(context, str, "click", 1, new Object[0]);
    }

    public static void b(Context context, String str) {
        TiebaStatic.eventStat(context, str, "visit", 1, new Object[0]);
    }
}
