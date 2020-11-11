package com.baidu.mapapi.map;

import android.view.View;
import com.baidu.platform.comapi.map.MapTextureView;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class aa implements View.OnClickListener {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextureMapView f2059a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(TextureMapView textureMapView) {
        this.f2059a = textureMapView;
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        mapTextureView = this.f2059a.b;
        float zoomLevel = mapTextureView.getZoomLevel();
        float f = zoomLevel - 1.0f;
        if (Math.floor(zoomLevel) != zoomLevel) {
            f = (float) Math.floor(zoomLevel);
        }
        mapTextureView2 = this.f2059a.b;
        float max = Math.max(f, mapTextureView2.getController().mMinZoomLevel);
        BaiduMap.mapStatusReason |= 16;
        mapTextureView3 = this.f2059a.b;
        mapTextureView3.setZoomLevel(max);
    }
}
