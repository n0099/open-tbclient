package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class af implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WearMapView f2066a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public af(WearMapView wearMapView) {
        this.f2066a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        mapSurfaceView = this.f2066a.f;
        com.baidu.mapsdkplatform.comapi.map.w B = mapSurfaceView.getBaseMap().B();
        B.f2244a -= 1.0f;
        mapSurfaceView2 = this.f2066a.f;
        mapSurfaceView2.getBaseMap().a(B, 300);
    }
}
