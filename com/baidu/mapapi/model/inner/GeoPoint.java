package com.baidu.mapapi.model.inner;
/* loaded from: classes4.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    private double f2824a;

    /* renamed from: b  reason: collision with root package name */
    private double f2825b;

    public GeoPoint(double d, double d2) {
        this.f2824a = d;
        this.f2825b = d2;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return this.f2824a == ((GeoPoint) obj).f2824a && this.f2825b == ((GeoPoint) obj).f2825b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.f2824a;
    }

    public double getLongitudeE6() {
        return this.f2825b;
    }

    public void setLatitudeE6(double d) {
        this.f2824a = d;
    }

    public void setLongitudeE6(double d) {
        this.f2825b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f2824a + ", Longitude: " + this.f2825b;
    }
}
