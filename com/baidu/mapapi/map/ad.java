package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapTextureView;
/* loaded from: classes3.dex */
public class ad implements View.OnClickListener {
    public final /* synthetic */ TextureMapView a;

    public ad(TextureMapView textureMapView) {
        this.a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view2) {
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        mapTextureView = this.a.b;
        float zoomLevel = mapTextureView.getZoomLevel();
        float f = 1.0f + zoomLevel;
        double d = zoomLevel;
        if (((int) Math.ceil(d)) != ((int) zoomLevel)) {
            f = (float) Math.ceil(d);
        }
        mapTextureView2 = this.a.b;
        float min = Math.min(f, mapTextureView2.getController().mMaxZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapTextureView3 = this.a.b;
        mapTextureView3.setZoomLevel(min);
    }
}
