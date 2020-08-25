package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapTextureView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes20.dex */
public class aa implements View.OnClickListener {
    final /* synthetic */ TextureMapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TextureMapView textureMapView) {
        this.a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        mapTextureView = this.a.b;
        float zoomLevel = mapTextureView.getZoomLevel();
        float f = zoomLevel - 1.0f;
        if (Math.floor(zoomLevel) != zoomLevel) {
            f = (float) Math.floor(zoomLevel);
        }
        mapTextureView2 = this.a.b;
        float max = Math.max(f, mapTextureView2.getController().mMinZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapTextureView3 = this.a.b;
        mapTextureView3.setZoomLevel(max);
    }
}
