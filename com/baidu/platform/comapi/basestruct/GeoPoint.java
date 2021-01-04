package com.baidu.platform.comapi.basestruct;
/* loaded from: classes15.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    private double f4190a;

    /* renamed from: b  reason: collision with root package name */
    private double f4191b;

    public GeoPoint(double d, double d2) {
        this.f4190a = d;
        this.f4191b = d2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass() == getClass() && Math.abs(this.f4190a - ((GeoPoint) obj).f4190a) <= 1.0E-6d && Math.abs(this.f4191b - ((GeoPoint) obj).f4191b) <= 1.0E-6d;
    }

    public double getLatitude() {
        return this.f4190a;
    }

    public double getLatitudeE6() {
        return this.f4190a;
    }

    public double getLongitude() {
        return this.f4191b;
    }

    public double getLongitudeE6() {
        return this.f4191b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setLatitude(double d) {
        this.f4190a = d;
    }

    public void setLatitudeE6(double d) {
        this.f4190a = d;
    }

    public void setLongitude(double d) {
        this.f4191b = d;
    }

    public void setLongitudeE6(double d) {
        this.f4191b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f4190a + ", Longitude: " + this.f4191b;
    }
}
