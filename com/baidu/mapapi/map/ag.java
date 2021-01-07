package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class ag implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WearMapView f2908a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(WearMapView wearMapView) {
        this.f2908a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        mapSurfaceView = this.f2908a.f;
        com.baidu.mapsdkplatform.comapi.map.w B = mapSurfaceView.getBaseMap().B();
        B.f3203a += 1.0f;
        mapSurfaceView2 = this.f2908a.f;
        mapSurfaceView2.getBaseMap().a(B, 300);
    }
}
