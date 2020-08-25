package com.baidu.live.utils;

import android.app.Activity;
/* loaded from: classes7.dex */
public class q {
    public static void e(Activity activity, boolean z) {
        if (z) {
            activity.getWindow().clearFlags(1024);
        } else {
            activity.getWindow().addFlags(1024);
        }
    }
}
