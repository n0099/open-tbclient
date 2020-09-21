package com.baidu.spswitch.b;

import android.app.Activity;
/* loaded from: classes24.dex */
public class e {
    private static final boolean DEBUG = b.isDebug();

    public static boolean B(Activity activity) {
        return (activity.getWindow().getAttributes().flags & 67108864) != 0;
    }

    public static boolean C(Activity activity) {
        return (activity.getWindow().getDecorView().getSystemUiVisibility() & 1024) != 0;
    }
}
