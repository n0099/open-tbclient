package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
/* loaded from: classes2.dex */
public class s implements View.OnClickListener {
    public final /* synthetic */ MapView a;

    public s(MapView mapView) {
        this.a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        mapSurfaceView = this.a.e;
        float zoomLevel = mapSurfaceView.getZoomLevel();
        float f = zoomLevel - 1.0f;
        double d = zoomLevel;
        if (Math.floor(d) != d) {
            f = (float) Math.floor(d);
        }
        mapSurfaceView2 = this.a.e;
        float max = Math.max(f, mapSurfaceView2.getController().mMinZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapSurfaceView3 = this.a.e;
        mapSurfaceView3.setZoomLevel(max);
    }
}
