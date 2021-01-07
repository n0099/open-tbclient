package com.baidu.platform.comapi.basestruct;
/* loaded from: classes3.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    private double f4191a;

    /* renamed from: b  reason: collision with root package name */
    private double f4192b;

    public GeoPoint(double d, double d2) {
        this.f4191a = d;
        this.f4192b = d2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass() == getClass() && Math.abs(this.f4191a - ((GeoPoint) obj).f4191a) <= 1.0E-6d && Math.abs(this.f4192b - ((GeoPoint) obj).f4192b) <= 1.0E-6d;
    }

    public double getLatitude() {
        return this.f4191a;
    }

    public double getLatitudeE6() {
        return this.f4191a;
    }

    public double getLongitude() {
        return this.f4192b;
    }

    public double getLongitudeE6() {
        return this.f4192b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setLatitude(double d) {
        this.f4191a = d;
    }

    public void setLatitudeE6(double d) {
        this.f4191a = d;
    }

    public void setLongitude(double d) {
        this.f4192b = d;
    }

    public void setLongitudeE6(double d) {
        this.f4192b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f4191a + ", Longitude: " + this.f4192b;
    }
}
