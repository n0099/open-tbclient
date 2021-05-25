package com.baidu.mapapi.model.inner;
/* loaded from: classes2.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    public double f7124a;

    /* renamed from: b  reason: collision with root package name */
    public double f7125b;

    public GeoPoint(double d2, double d3) {
        this.f7124a = d2;
        this.f7125b = d3;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == GeoPoint.class) {
            GeoPoint geoPoint = (GeoPoint) obj;
            return this.f7124a == geoPoint.f7124a && this.f7125b == geoPoint.f7125b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f7124a;
    }

    public double getLongitudeE6() {
        return this.f7125b;
    }

    public void setLatitudeE6(double d2) {
        this.f7124a = d2;
    }

    public void setLongitudeE6(double d2) {
        this.f7125b = d2;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f7124a + ", Longitude: " + this.f7125b;
    }
}
