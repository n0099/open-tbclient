package com.baidu.mapapi.model.inner;
/* loaded from: classes2.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    public double f7152a;

    /* renamed from: b  reason: collision with root package name */
    public double f7153b;

    public GeoPoint(double d2, double d3) {
        this.f7152a = d2;
        this.f7153b = d3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == GeoPoint.class) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return this.f7152a == geoPoint.f7152a && this.f7153b == geoPoint.f7153b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f7152a;
    }

    public double getLongitudeE6() {
        return this.f7153b;
    }

    public void setLatitudeE6(double d2) {
        this.f7152a = d2;
    }

    public void setLongitudeE6(double d2) {
        this.f7153b = d2;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f7152a + ", Longitude: " + this.f7153b;
    }
}
