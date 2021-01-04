package com.baidu.live.utils;

import android.app.Activity;
/* loaded from: classes11.dex */
public class r {
    public static void e(Activity activity, boolean z) {
        if (z) {
            activity.getWindow().clearFlags(1024);
        } else {
            activity.getWindow().addFlags(1024);
        }
    }
}
