package com.baidu.mapapi.map;

import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import javax.microedition.khronos.opengles.GL10;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class q implements com.baidu.platform.comapi.map.ag {
    final /* synthetic */ MapView a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(MapView mapView) {
        this.a = mapView;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a() {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        MapSurfaceView mapSurfaceView4;
        MapSurfaceView mapSurfaceView5;
        MapSurfaceView mapSurfaceView6;
        float f;
        SparseIntArray sparseIntArray;
        MapSurfaceView mapSurfaceView7;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        MapSurfaceView mapSurfaceView8;
        mapSurfaceView = this.a.e;
        if (mapSurfaceView != null) {
            mapSurfaceView2 = this.a.e;
            if (mapSurfaceView2.getController() == null) {
                return;
            }
            mapSurfaceView3 = this.a.e;
            float zoomLevel = mapSurfaceView3.getZoomLevel();
            mapSurfaceView4 = this.a.e;
            if (zoomLevel < mapSurfaceView4.getController().mMinZoomLevel) {
                mapSurfaceView8 = this.a.e;
                zoomLevel = mapSurfaceView8.getController().mMinZoomLevel;
            } else {
                mapSurfaceView5 = this.a.e;
                if (zoomLevel > mapSurfaceView5.getController().mMaxZoomLevel) {
                    mapSurfaceView6 = this.a.e;
                    zoomLevel = mapSurfaceView6.getController().mMaxZoomLevel;
                }
            }
            f = this.a.u;
            if (Math.abs(f - zoomLevel) > 0.0f) {
                sparseIntArray = MapView.q;
                int i = sparseIntArray.get(Math.round(zoomLevel));
                mapSurfaceView7 = this.a.e;
                int zoomUnitsInMeter = (int) (i / mapSurfaceView7.getController().getZoomUnitsInMeter());
                imageView = this.a.o;
                imageView.setPadding(zoomUnitsInMeter / 2, 0, zoomUnitsInMeter / 2, 0);
                String format = i >= 1000 ? String.format(" %d公里 ", Integer.valueOf(i / 1000)) : String.format(" %d米 ", Integer.valueOf(i));
                textView = this.a.m;
                textView.setText(format);
                textView2 = this.a.n;
                textView2.setText(format);
                this.a.u = zoomLevel;
            }
            this.a.b();
            this.a.requestLayout();
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
