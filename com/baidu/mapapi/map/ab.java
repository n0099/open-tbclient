package com.baidu.mapapi.map;

import android.graphics.Point;
import android.util.SparseArray;
import android.view.MotionEvent;
import android.widget.ImageView;
import android.widget.TextView;
import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapTextureView;
import com.baidu.platform.comapi.map.al;
import javax.microedition.khronos.opengles.GL10;
/* loaded from: classes2.dex */
public class ab implements al {
    public final /* synthetic */ TextureMapView a;

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

    public ab(TextureMapView textureMapView) {
        this.a = textureMapView;
    }

    @Override // com.baidu.platform.comapi.map.al
    public void c(com.baidu.mapsdkplatform.comapi.map.x xVar) {
        MapTextureView mapTextureView;
        MapTextureView mapTextureView2;
        MapTextureView mapTextureView3;
        MapTextureView mapTextureView4;
        MapTextureView mapTextureView5;
        MapTextureView mapTextureView6;
        float f;
        SparseArray sparseArray;
        MapTextureView mapTextureView7;
        ImageView imageView;
        String format;
        TextView textView;
        TextView textView2;
        TextView textView3;
        TextView textView4;
        ImageView imageView2;
        MapTextureView mapTextureView8;
        mapTextureView = this.a.b;
        if (mapTextureView != null) {
            mapTextureView2 = this.a.b;
            if (mapTextureView2.getController() != null) {
                mapTextureView3 = this.a.b;
                float zoomLevel = mapTextureView3.getZoomLevel();
                mapTextureView4 = this.a.b;
                if (zoomLevel < mapTextureView4.getController().mMinZoomLevel) {
                    mapTextureView8 = this.a.b;
                    zoomLevel = mapTextureView8.getController().mMinZoomLevel;
                } else {
                    mapTextureView5 = this.a.b;
                    if (zoomLevel > mapTextureView5.getController().mMaxZoomLevel) {
                        mapTextureView6 = this.a.b;
                        zoomLevel = mapTextureView6.getController().mMaxZoomLevel;
                    }
                }
                f = this.a.r;
                if (Math.abs(f - zoomLevel) > 0.0f) {
                    sparseArray = TextureMapView.q;
                    int intValue = ((Integer) sparseArray.get(Math.round(zoomLevel))).intValue();
                    mapTextureView7 = this.a.b;
                    int zoomUnitsInMeter = (int) (intValue / mapTextureView7.getController().getZoomUnitsInMeter());
                    imageView = this.a.o;
                    if (imageView != null) {
                        imageView2 = this.a.o;
                        int i = zoomUnitsInMeter / 2;
                        imageView2.setPadding(i, 0, i, 0);
                    }
                    if (intValue >= 1000) {
                        format = String.format(" %d公里 ", Integer.valueOf(intValue / 1000));
                    } else {
                        format = String.format(" %d米 ", Integer.valueOf(intValue));
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
                    this.a.r = zoomLevel;
                }
                this.a.b();
                this.a.requestLayout();
            }
        }
    }
}
