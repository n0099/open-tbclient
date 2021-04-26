package com.baidu.mapapi.model.inner;
/* loaded from: classes2.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    public double f7407a;

    /* renamed from: b  reason: collision with root package name */
    public double f7408b;

    public GeoPoint(double d2, double d3) {
        this.f7407a = d2;
        this.f7408b = d3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == GeoPoint.class) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return this.f7407a == geoPoint.f7407a && this.f7408b == geoPoint.f7408b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f7407a;
    }

    public double getLongitudeE6() {
        return this.f7408b;
    }

    public void setLatitudeE6(double d2) {
        this.f7407a = d2;
    }

    public void setLongitudeE6(double d2) {
        this.f7408b = d2;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f7407a + ", Longitude: " + this.f7408b;
    }
}
