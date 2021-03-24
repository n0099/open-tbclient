package com.baidu.mapapi.model.inner;
/* loaded from: classes2.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    public double f7116a;

    /* renamed from: b  reason: collision with root package name */
    public double f7117b;

    public GeoPoint(double d2, double d3) {
        this.f7116a = d2;
        this.f7117b = d3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == GeoPoint.class) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return this.f7116a == geoPoint.f7116a && this.f7117b == geoPoint.f7117b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f7116a;
    }

    public double getLongitudeE6() {
        return this.f7117b;
    }

    public void setLatitudeE6(double d2) {
        this.f7116a = d2;
    }

    public void setLongitudeE6(double d2) {
        this.f7117b = d2;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f7116a + ", Longitude: " + this.f7117b;
    }
}
