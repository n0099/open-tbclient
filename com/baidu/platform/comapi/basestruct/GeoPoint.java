package com.baidu.platform.comapi.basestruct;
/* loaded from: classes3.dex */
public class GeoPoint {
    private double a;
    private double b;

    public GeoPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        return obj.getClass() == getClass() && Math.abs(this.a - ((GeoPoint) obj).a) <= 1.0E-6d && Math.abs(this.b - ((GeoPoint) obj).b) <= 1.0E-6d;
    }

    public double getLatitude() {
        return this.a;
    }

    public double getLatitudeE6() {
        return this.a;
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
        this.a = d;
    }

    public void setLatitudeE6(double d) {
        this.a = d;
    }

    public void setLongitude(double d) {
        this.b = d;
    }

    public void setLongitudeE6(double d) {
        this.b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.a + ", Longitude: " + this.b;
    }
}
