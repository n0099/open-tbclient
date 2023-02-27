package com.baidu.mapapi.map;

import android.view.View;
/* loaded from: classes2.dex */
public class ae implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ TextureMapView b;

    public ae(TextureMapView textureMapView, View view2) {
        this.b = textureMapView;
        this.a = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.removeView(this.a);
    }
}
