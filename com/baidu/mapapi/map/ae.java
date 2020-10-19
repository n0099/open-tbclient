package com.baidu.mapapi.map;

import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import javax.microedition.khronos.opengles.GL10;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class ae implements com.baidu.platform.comapi.map.ag {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ WearMapView f2061a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ae(WearMapView wearMapView) {
        this.f2061a = wearMapView;
    }

    @Override // com.baidu.platform.comapi.map.ag
    public void a() {
        MapSurfaceView mapSurfaceView;
        MapSurfaceView mapSurfaceView2;
        MapSurfaceView mapSurfaceView3;
        MapSurfaceView mapSurfaceView4;
        MapSurfaceView mapSurfaceView5;
        float f;
        MapSurfaceView mapSurfaceView6;
        float f2;
        SparseArray sparseArray;
        MapSurfaceView mapSurfaceView7;
        ImageView imageView;
        TextView textView;
        TextView textView2;
        MapSurfaceView mapSurfaceView8;
        mapSurfaceView = this.f2061a.f;
        if (mapSurfaceView != null) {
            mapSurfaceView2 = this.f2061a.f;
            if (mapSurfaceView2.getBaseMap() == null) {
                return;
            }
            mapSurfaceView3 = this.f2061a.f;
            float zoomLevel = mapSurfaceView3.getZoomLevel();
            mapSurfaceView4 = this.f2061a.f;
            if (zoomLevel < mapSurfaceView4.getController().mMinZoomLevel) {
                mapSurfaceView8 = this.f2061a.f;
                f = mapSurfaceView8.getController().mMinZoomLevel;
            } else {
                mapSurfaceView5 = this.f2061a.f;
                if (zoomLevel > mapSurfaceView5.getController().mMaxZoomLevel) {
                    mapSurfaceView6 = this.f2061a.f;
                    f = mapSurfaceView6.getController().mMaxZoomLevel;
                } else {
                    f = zoomLevel;
                }
            }
            f2 = this.f2061a.A;
            if (Math.abs(f2 - f) > 0.0f) {
                sparseArray = WearMapView.x;
                int intValue = ((Integer) sparseArray.get(Math.round(f))).intValue();
                mapSurfaceView7 = this.f2061a.f;
                int zoomUnitsInMeter = (int) (intValue / mapSurfaceView7.getController().getZoomUnitsInMeter());
                imageView = this.f2061a.r;
                imageView.setPadding(zoomUnitsInMeter / 2, 0, zoomUnitsInMeter / 2, 0);
                String format = intValue >= 1000 ? String.format(" %d公里 ", Integer.valueOf(intValue / 1000)) : String.format(" %d米 ", Integer.valueOf(intValue));
                textView = this.f2061a.p;
                textView.setText(format);
                textView2 = this.f2061a.q;
                textView2.setText(format);
                this.f2061a.A = f;
            }
            this.f2061a.requestLayout();
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
