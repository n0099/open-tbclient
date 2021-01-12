package com.baidu.mapapi.model.inner;
/* loaded from: classes6.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    private double f2826a;

    /* renamed from: b  reason: collision with root package name */
    private double f2827b;

    public GeoPoint(double d, double d2) {
        this.f2826a = d;
        this.f2827b = d2;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return this.f2826a == ((GeoPoint) obj).f2826a && this.f2827b == ((GeoPoint) obj).f2827b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f2826a;
    }

    public double getLongitudeE6() {
        return this.f2827b;
    }

    public void setLatitudeE6(double d) {
        this.f2826a = d;
    }

    public void setLongitudeE6(double d) {
        this.f2827b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f2826a + ", Longitude: " + this.f2827b;
    }
}
