package com.baidu.mapapi.map;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapTextureView;
import javax.microedition.khronos.opengles.GL10;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes26.dex */
public class z implements com.baidu.platform.comapi.map.ag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ TextureMapView f2092a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public z(TextureMapView textureMapView) {
        this.f2092a = textureMapView;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a() {
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        MapTextureView mapTextureView4;
        MapTextureView mapTextureView5;
        float f;
        MapTextureView mapTextureView6;
        float f2;
        SparseArray sparseArray;
        MapTextureView mapTextureView7;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        MapTextureView mapTextureView8;
        mapTextureView = this.f2092a.b;
        if (mapTextureView != null) {
            mapTextureView2 = this.f2092a.b;
            if (mapTextureView2.getController() == null) {
                return;
            }
            mapTextureView3 = this.f2092a.b;
            float zoomLevel = mapTextureView3.getZoomLevel();
            mapTextureView4 = this.f2092a.b;
            if (zoomLevel < mapTextureView4.getController().mMinZoomLevel) {
                mapTextureView8 = this.f2092a.b;
                f = mapTextureView8.getController().mMinZoomLevel;
            } else {
                mapTextureView5 = this.f2092a.b;
                if (zoomLevel > mapTextureView5.getController().mMaxZoomLevel) {
                    mapTextureView6 = this.f2092a.b;
                    f = mapTextureView6.getController().mMaxZoomLevel;
                } else {
                    f = zoomLevel;
                }
            }
            f2 = this.f2092a.r;
            if (Math.abs(f2 - f) > 0.0f) {
                sparseArray = TextureMapView.q;
                int intValue = ((Integer) sparseArray.get(Math.round(f))).intValue();
                mapTextureView7 = this.f2092a.b;
                int zoomUnitsInMeter = (int) (intValue / mapTextureView7.getController().getZoomUnitsInMeter());
                imageView = this.f2092a.o;
                imageView.setPadding(zoomUnitsInMeter / 2, 0, zoomUnitsInMeter / 2, 0);
                String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", Integer.valueOf(intValue));
                textView = this.f2092a.m;
                textView.setText(format);
                textView2 = this.f2092a.n;
                textView2.setText(format);
                this.f2092a.r = f;
            }
            this.f2092a.b();
            this.f2092a.requestLayout();
        }
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(MotionEvent motionEvent) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(com.baidu.mapsdkplatform.comapi.map.w wVar) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(String str) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.w wVar) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void b() {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void b(com.baidu.mapsdkplatform.comapi.map.w wVar) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void b(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public boolean b(String str) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void c() {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void c(com.baidu.mapsdkplatform.comapi.map.w wVar) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void c(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void d() {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void d(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void e(GeoPoint geoPoint) {
    }
}
