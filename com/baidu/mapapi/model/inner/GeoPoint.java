package com.baidu.mapapi.model.inner;
/* loaded from: classes2.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    public double f7167a;

    /* renamed from: b  reason: collision with root package name */
    public double f7168b;

    public GeoPoint(double d2, double d3) {
        this.f7167a = d2;
        this.f7168b = d3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == GeoPoint.class) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return this.f7167a == geoPoint.f7167a && this.f7168b == geoPoint.f7168b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f7167a;
    }

    public double getLongitudeE6() {
        return this.f7168b;
    }

    public void setLatitudeE6(double d2) {
        this.f7167a = d2;
    }

    public void setLongitudeE6(double d2) {
        this.f7168b = d2;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f7167a + ", Longitude: " + this.f7168b;
    }
}
