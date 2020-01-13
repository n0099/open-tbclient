package com.baidu.mapapi.map;

import android.os.Bundle;
/* loaded from: classes6.dex */
public final class Stroke {
    public final int color;
    public final int strokeWidth;

    public Stroke(int i, int i2) {
        this.strokeWidth = i <= 0 ? 5 : i;
        this.color = i2;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Bundle a(Bundle bundle) {
        bundle.putInt("width", this.strokeWidth);
        Overlay.a(this.color, bundle);
        return bundle;
    }
}
