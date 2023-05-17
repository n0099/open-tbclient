package com.baidu.mapapi.map;

import android.view.View;
/* loaded from: classes3.dex */
public class u implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ MapView b;

    public u(MapView mapView, View view2) {
        this.b = mapView;
        this.a = view2;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.removeView(this.a);
    }
}
