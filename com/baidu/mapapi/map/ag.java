package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class ag implements View.OnClickListener {
    final /* synthetic */ WearMapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WearMapView wearMapView) {
        this.a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        mapSurfaceView = this.a.f;
        com.baidu.mapsdkplatform.comapi.map.w B = mapSurfaceView.getBaseMap().B();
        B.a += 1.0f;
        mapSurfaceView2 = this.a.f;
        mapSurfaceView2.getBaseMap().a(B, 300);
    }
}
