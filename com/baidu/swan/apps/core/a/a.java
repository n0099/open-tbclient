package com.baidu.swan.apps.core.a;

import android.support.v7.widget.ActivityChooserView;
/* loaded from: classes2.dex */
public final class a {
    public static int ys() {
        return 3;
    }

    public static int yt() {
        return ActivityChooserView.ActivityChooserViewAdapter.MAX_ACTIVITY_COUNT_UNLIMITED;
    }

    public static boolean bT(int i) {
        return (i & 2) == 2;
    }

    public static boolean bU(int i) {
        return (i & 4) == 4;
    }

    public static boolean bV(int i) {
        return i == ys();
    }
}
