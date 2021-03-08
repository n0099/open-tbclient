package com.baidu.mapapi.model.inner;
/* loaded from: classes4.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    private double f2089a;
    private double b;

    public GeoPoint(double d, double d2) {
        this.f2089a = d;
        this.b = d2;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return this.f2089a == ((GeoPoint) obj).f2089a && this.b == ((GeoPoint) obj).b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f2089a;
    }

    public double getLongitudeE6() {
        return this.b;
    }

    public void setLatitudeE6(double d) {
        this.f2089a = d;
    }

    public void setLongitudeE6(double d) {
        this.b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f2089a + ", Longitude: " + this.b;
    }
}
