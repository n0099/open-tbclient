package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapSurfaceView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class s implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ MapView f2081a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(MapView mapView) {
        this.f2081a = mapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        mapSurfaceView = this.f2081a.e;
        float zoomLevel = mapSurfaceView.getZoomLevel();
        float f = 1.0f + zoomLevel;
        if (((int) Math.ceil(zoomLevel)) != ((int) zoomLevel)) {
            f = (float) Math.ceil(zoomLevel);
        }
        mapSurfaceView2 = this.f2081a.e;
        float min = Math.min(f, mapSurfaceView2.getController().mMaxZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapSurfaceView3 = this.f2081a.e;
        mapSurfaceView3.setZoomLevel(min);
    }
}
