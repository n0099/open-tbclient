package com.baidu.mapapi.model.inner;
/* loaded from: classes2.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    public double f7224a;

    /* renamed from: b  reason: collision with root package name */
    public double f7225b;

    public GeoPoint(double d2, double d3) {
        this.f7224a = d2;
        this.f7225b = d3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == GeoPoint.class) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return this.f7224a == geoPoint.f7224a && this.f7225b == geoPoint.f7225b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f7224a;
    }

    public double getLongitudeE6() {
        return this.f7225b;
    }

    public void setLatitudeE6(double d2) {
        this.f7224a = d2;
    }

    public void setLongitudeE6(double d2) {
        this.f7225b = d2;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f7224a + ", Longitude: " + this.f7225b;
    }
}
