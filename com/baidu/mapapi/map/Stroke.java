package com.baidu.mapapi.map;

import android.os.Bundle;
/* loaded from: classes2.dex */
public final class Stroke {
    public final int color;
    public final int strokeWidth;

    public Stroke(int i2, int i3) {
        this.strokeWidth = i2 <= 0 ? 5 : i2;
        this.color = i3;
    }

    public Bundle a(Bundle bundle) {
        bundle.putInt("width", this.strokeWidth);
        Overlay.a(this.color, bundle);
        return bundle;
    }
}
