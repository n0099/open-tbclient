package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapTextureView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ab implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextureMapView f2060a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(TextureMapView textureMapView) {
        this.f2060a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        mapTextureView = this.f2060a.b;
        float zoomLevel = mapTextureView.getZoomLevel();
        float f = 1.0f + zoomLevel;
        if (((int) Math.ceil(zoomLevel)) != ((int) zoomLevel)) {
            f = (float) Math.ceil(zoomLevel);
        }
        mapTextureView2 = this.f2060a.b;
        float min = Math.min(f, mapTextureView2.getController().mMaxZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapTextureView3 = this.f2060a.b;
        mapTextureView3.setZoomLevel(min);
    }
}
