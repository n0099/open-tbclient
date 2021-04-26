package com.baidu.pano.platform.c;

import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes2.dex */
public class d {
    public static int a(int i2) {
        return (i2 & (-16777216)) >> 24;
    }

    public static int a(int i2, int i3, int i4, int i5) {
        return ((i2 << 24) & (-16777216)) | ((i3 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i4 << 8) & 65280) | (i5 & 255);
    }

    public static int b(int i2) {
        return (i2 & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
    }

    public static int c(int i2) {
        return (i2 & 65280) >> 8;
    }

    public static int d(int i2) {
        return i2 & 255;
    }
}
