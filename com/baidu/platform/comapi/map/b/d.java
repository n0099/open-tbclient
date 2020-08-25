package com.baidu.platform.comapi.map.b;

import com.baidu.platform.comapi.basestruct.GeoPoint;
import com.baidu.platform.comapi.map.MapController;
import com.baidu.platform.comapi.map.MapViewInterface;
import java.util.IllegalFormatException;
/* loaded from: classes20.dex */
public class d {
    private float a;
    private StringBuffer b = new StringBuffer();
    private StringBuffer c = new StringBuffer();
    private MapController d;

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes20.dex */
    public enum a {
        ZOOM_OUT,
        ZOOM_IN,
        FLING,
        MOVE,
        ROTATE,
        DOUBLE_CLICK_ZOOM_IN,
        TWO_CLICK_ZOOM_OUT,
        MOVE_OVERLOOK
    }

    public d(MapController mapController) {
        this.d = mapController;
    }

    private void a(a aVar) {
        MapViewInterface mapView;
        String b;
        if (this.d == null || (mapView = this.d.getMapView()) == null) {
            return;
        }
        GeoPoint mapCenter = mapView.getMapCenter();
        try {
            b = String.format("(%s,%d,%d,%d,%d)", b(aVar), Double.valueOf(mapCenter.getLongitudeE6()), Double.valueOf(mapCenter.getLatitudeE6()), Integer.valueOf((int) mapView.getZoomLevel()), Long.valueOf(System.currentTimeMillis()));
        } catch (IllegalFormatException e) {
            b = b(aVar);
        }
        if (this.b != null) {
            this.b.append(b);
            if (this.c != null) {
                this.c.append(b(aVar));
            }
        }
    }

    private String b(a aVar) {
        switch (aVar) {
            case MOVE:
            case FLING:
                return "0";
            case ZOOM_OUT:
                return "1";
            case ZOOM_IN:
                return "2";
            case ROTATE:
                return "3";
            case DOUBLE_CLICK_ZOOM_IN:
                return "4";
            case TWO_CLICK_ZOOM_OUT:
                return "5";
            case MOVE_OVERLOOK:
                return "6";
            default:
                return "";
        }
    }

    private void d(float f) {
        this.a = f;
    }

    private boolean e(float f) {
        return f > this.a;
    }

    private boolean f(float f) {
        return f < this.a;
    }

    public void a() {
        a(a.FLING);
    }

    public void a(float f) {
        if (e(f)) {
            a(a.ZOOM_OUT);
        }
        if (f(f)) {
            a(a.ZOOM_IN);
        }
        d(f);
    }

    public void b() {
        a(a.MOVE);
    }

    public void b(float f) {
        a(a.DOUBLE_CLICK_ZOOM_IN);
        d(f);
    }

    public void c() {
        a(a.ROTATE);
    }

    public void c(float f) {
        a(a.TWO_CLICK_ZOOM_OUT);
        d(f);
    }

    public void d() {
        a(a.MOVE_OVERLOOK);
    }
}
