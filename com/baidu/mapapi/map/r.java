package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class r implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapView f2931a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MapView mapView) {
        this.f2931a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        mapSurfaceView = this.f2931a.e;
        float zoomLevel = mapSurfaceView.getZoomLevel();
        float f = zoomLevel - 1.0f;
        if (Math.floor(zoomLevel) != zoomLevel) {
            f = (float) Math.floor(zoomLevel);
        }
        mapSurfaceView2 = this.f2931a.e;
        float max = Math.max(f, mapSurfaceView2.getController().mMinZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapSurfaceView3 = this.f2931a.e;
        mapSurfaceView3.setZoomLevel(max);
    }
}
