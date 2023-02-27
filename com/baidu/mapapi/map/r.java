package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.SparseIntArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapSurfaceView;
import com.baidu.platform.comapi.map.al;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class r implements al {
    public final /* synthetic */ MapView a;

    @Override // com.baidu.platform.comapi.map.al
    public void a() {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(MotionEvent motionEvent) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(com.baidu.mapsdkplatform.comapi.map.x xVar) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(String str) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(GL10 gl10, com.baidu.mapsdkplatform.comapi.map.x xVar) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(boolean z) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void a(boolean z, int i) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(Point point, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean a(MotionEvent motionEvent, float f, float f2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b() {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b(com.baidu.mapsdkplatform.comapi.map.x xVar) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void b(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean b(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean b(String str) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c() {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean c(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void d() {
    }

    @Override // com.baidu.platform.comapi.map.al
    public void d(GeoPoint geoPoint) {
    }

    @Override // com.baidu.platform.comapi.map.al
    public boolean d(Point point, Point point2, com.baidu.mapsdkplatform.comapi.map.x xVar) {
        return false;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void e(GeoPoint geoPoint) {
    }

    public r(MapView mapView) {
        this.a = mapView;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c(com.baidu.mapsdkplatform.comapi.map.x xVar) {
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
        String format;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        MapSurfaceView mapSurfaceView8;
        mapSurfaceView = this.a.e;
        if (mapSurfaceView != null) {
            mapSurfaceView2 = this.a.e;
            if (mapSurfaceView2.getController() != null) {
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
                    if (imageView != null) {
                        imageView2 = this.a.o;
                        int i2 = zoomUnitsInMeter / 2;
                        imageView2.setPadding(i2, 0, i2, 0);
                    }
                    if (i >= 1000) {
                        format = String.format(" %d公里 ", Integer.valueOf(i / 1000));
                    } else {
                        format = String.format(" %d米 ", Integer.valueOf(i));
                    }
                    textView = this.a.m;
                    if (textView != null) {
                        textView4 = this.a.m;
                        textView4.setText(format);
                    }
                    textView2 = this.a.n;
                    if (textView2 != null) {
                        textView3 = this.a.n;
                        textView3.setText(format);
                    }
                    this.a.u = zoomLevel;
                }
                this.a.b();
                this.a.requestLayout();
            }
        }
    }
}
