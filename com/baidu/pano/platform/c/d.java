package com.baidu.pano.platform.c;

import androidx.recyclerview.widget.ItemTouchHelper;
/* loaded from: classes2.dex */
public class d {
    public static int a(int i) {
        return (i & (-16777216)) >> 24;
    }

    public static int a(int i, int i2, int i3, int i4) {
        return ((i << 24) & (-16777216)) | ((i2 << 16) & ItemTouchHelper.ACTION_MODE_DRAG_MASK) | ((i3 << 8) & 65280) | (i4 & 255);
    }

    public static int b(int i) {
        return (i & ItemTouchHelper.ACTION_MODE_DRAG_MASK) >> 16;
    }

    public static int c(int i) {
        return (i & 65280) >> 8;
    }

    public static int d(int i) {
        return i & 255;
    }
}
