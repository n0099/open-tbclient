package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class r implements View.OnClickListener {
    final /* synthetic */ MapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(MapView mapView) {
        this.a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        mapSurfaceView = this.a.e;
        float zoomLevel = mapSurfaceView.getZoomLevel();
        float f = zoomLevel - 1.0f;
        if (Math.floor(zoomLevel) != zoomLevel) {
            f = (float) Math.floor(zoomLevel);
        }
        mapSurfaceView2 = this.a.e;
        float max = Math.max(f, mapSurfaceView2.getController().mMinZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapSurfaceView3 = this.a.e;
        mapSurfaceView3.setZoomLevel(max);
    }
}
