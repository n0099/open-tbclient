package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
/* loaded from: classes2.dex */
public class ai implements View.OnClickListener {
    public final /* synthetic */ WearMapView a;

    public ai(WearMapView wearMapView) {
        this.a = wearMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        mapSurfaceView = this.a.f;
        com.baidu.mapsdkplatform.comapi.map.x D = mapSurfaceView.getBaseMap().D();
        D.a -= 1.0f;
        mapSurfaceView2 = this.a.f;
        mapSurfaceView2.getBaseMap().a(D, 300);
    }
}
