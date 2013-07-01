package com.baidu.mapapi;

import android.graphics.Point;
import android.os.Message;
import android.view.KeyEvent;
import android.view.View;
import com.baidu.zeus.bouncycastle.DERTags;
/* loaded from: classes.dex */
public class MapController implements View.OnKeyListener {

    /* renamed from: a  reason: collision with root package name */
    private MapView f523a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public MapController(MapView mapView) {
        this.f523a = null;
        this.f523a = mapView;
        mapView.b.setOnKeyListener(this);
    }

    public void animateTo(GeoPoint geoPoint) {
        this.f523a.a(geoPoint, (Message) null, (Runnable) null);
    }

    public void animateTo(GeoPoint geoPoint, Message message) {
        this.f523a.a(geoPoint, message, (Runnable) null);
    }

    public void animateTo(GeoPoint geoPoint, Runnable runnable) {
        this.f523a.a(geoPoint, (Message) null, runnable);
    }

    @Override // android.view.View.OnKeyListener
    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (this.f523a.b == view && keyEvent.getAction() == 0) {
            switch (i) {
                case 19:
                    scrollBy(0, -50);
                    break;
                case 20:
                    scrollBy(0, 50);
                    break;
                case 21:
                    scrollBy(-50, 0);
                    break;
                case DERTags.IA5_STRING /* 22 */:
                    scrollBy(50, 0);
                    break;
                default:
                    return false;
            }
            return true;
        }
        return false;
    }

    public void scrollBy(int i, int i2) {
        if (i == 0 && i2 == 0) {
            return;
        }
        this.f523a.b(i, i2);
    }

    public void setCenter(GeoPoint geoPoint) {
        this.f523a.a(geoPoint);
    }

    public void setMaxZoomLevel(int i) {
        this.f523a.a(i);
    }

    public void setMinZoomLevel(int i) {
        this.f523a.b(i);
    }

    public int setZoom(int i) {
        this.f523a.c(i);
        return this.f523a.getZoomLevel();
    }

    public void stopAnimation(boolean z) {
        this.f523a.a(z);
    }

    public void stopPanning() {
        setCenter(this.f523a.getMapCenter());
    }

    public boolean zoomIn() {
        return this.f523a.f();
    }

    public boolean zoomInFixing(int i, int i2) {
        GeoPoint fromPixels = this.f523a.getProjection().fromPixels(i, i2);
        boolean zoomIn = zoomIn();
        if (zoomIn) {
            Point point = new Point();
            this.f523a.getProjection().toPixels(fromPixels, point);
            scrollBy(point.x - i, point.y - i2);
        }
        return zoomIn;
    }

    public boolean zoomOut() {
        return this.f523a.g();
    }

    public boolean zoomOutFixing(int i, int i2) {
        GeoPoint fromPixels = this.f523a.getProjection().fromPixels(i, i2);
        boolean zoomOut = zoomOut();
        if (zoomOut) {
            Point point = new Point();
            this.f523a.getProjection().toPixels(fromPixels, point);
            scrollBy(point.x - i, point.y - i2);
        }
        return zoomOut;
    }

    public void zoomToSpan(int i, int i2) {
        this.f523a.a(i, i2);
    }
}
