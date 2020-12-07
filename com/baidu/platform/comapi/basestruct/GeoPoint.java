package com.baidu.platform.comapi.basestruct;
/* loaded from: classes26.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    private double f2826a;
    private double b;

    public GeoPoint(double d, double d2) {
        this.f2826a = d;
        this.b = d2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass() == getClass() && Math.abs(this.f2826a - ((GeoPoint) obj).f2826a) <= 1.0E-6d && Math.abs(this.b - ((GeoPoint) obj).b) <= 1.0E-6d;
    }

    public double getLatitude() {
        return this.f2826a;
    }

    public double getLatitudeE6() {
        return this.f2826a;
    }

    public double getLongitude() {
        return this.b;
    }

    public double getLongitudeE6() {
        return this.b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setLatitude(double d) {
        this.f2826a = d;
    }

    public void setLatitudeE6(double d) {
        this.f2826a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public void setLongitudeE6(double d) {
        this.b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f2826a + ", Longitude: " + this.b;
    }
}
