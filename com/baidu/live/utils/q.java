package com.baidu.live.utils;

import android.app.Activity;
/* loaded from: classes6.dex */
public class q {
    public static void d(Activity activity, boolean z) {
        if (z) {
            activity.getWindow().clearFlags(1024);
        } else {
            activity.getWindow().addFlags(1024);
        }
    }
}
