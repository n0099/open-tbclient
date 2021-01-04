package com.baidu.pano.platform.c;

import androidx.core.view.MotionEventCompat;
import androidx.core.view.ViewCompat;
/* loaded from: classes15.dex */
public class d {
    public static int a(int i, int i2, int i3, int i4) {
        return ((i << 24) & ViewCompat.MEASURED_STATE_MASK) | ((i2 << 16) & 16711680) | ((i3 << 8) & MotionEventCompat.ACTION_POINTER_INDEX_MASK) | (i4 & 255);
    }

    public static int a(int i) {
        return ((-16777216) & i) >> 24;
    }

    public static int b(int i) {
        return (16711680 & i) >> 16;
    }

    public static int c(int i) {
        return (65280 & i) >> 8;
    }

    public static int d(int i) {
        return i & 255;
    }
}
