package com.baidu.mapapi;

import android.graphics.Point;
import android.os.Bundle;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Projection {

    /* renamed from: a  reason: collision with root package name */
    private MapView f551a;

    public e(MapView mapView) {
        this.f551a = null;
        this.f551a = mapView;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public Point a(GeoPoint geoPoint, Point point) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010200);
        bundle.putInt("x", geoPoint.getLongitudeE6());
        bundle.putInt("y", geoPoint.getLatitudeE6());
        Mj.sendBundle(bundle);
        if (point == null) {
            point = new Point(0, 0);
        }
        point.x = bundle.getInt("x");
        point.y = bundle.getInt("y");
        return point;
    }

    @Override // com.baidu.mapapi.Projection
    public GeoPoint fromPixels(int i, int i2) {
        int i3 = i - this.f551a.b.c;
        int i4 = i2 - this.f551a.b.d;
        if (this.f551a.b.e != 1.0d) {
            int i5 = (int) ((i4 - this.f551a.b.g) / this.f551a.b.e);
            i3 = ((int) ((i3 - this.f551a.b.f) / this.f551a.b.e)) + this.f551a.b.f;
            i4 = i5 + this.f551a.b.g;
        }
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010100);
        bundle.putInt("x", i3);
        bundle.putInt("y", i4);
        Mj.sendBundle(bundle);
        return new GeoPoint(bundle.getInt("y"), bundle.getInt("x"));
    }

    @Override // com.baidu.mapapi.Projection
    public float metersToEquatorPixels(float f) {
        return (float) (f / this.f551a.h());
    }

    @Override // com.baidu.mapapi.Projection
    public Point toPixels(GeoPoint geoPoint, Point point) {
        Bundle bundle = new Bundle();
        bundle.putInt("act", 15010200);
        bundle.putInt("x", geoPoint.getLongitudeE6());
        bundle.putInt("y", geoPoint.getLatitudeE6());
        Mj.sendBundle(bundle);
        if (point == null) {
            point = new Point(0, 0);
        }
        point.x = bundle.getInt("x");
        point.y = bundle.getInt("y");
        if (this.f551a.b.e != 1.0d) {
            point.x = ((int) (((point.x - this.f551a.b.f) * this.f551a.b.e) + 0.5d)) + this.f551a.b.f;
            point.y = this.f551a.b.g + ((int) (((point.y - this.f551a.b.g) * this.f551a.b.e) + 0.5d));
        }
        point.x += this.f551a.b.c;
        point.y += this.f551a.b.d;
        return point;
    }
}
