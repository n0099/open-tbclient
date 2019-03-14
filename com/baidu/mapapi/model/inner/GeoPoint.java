package com.baidu.mapapi.model.inner;
/* loaded from: classes5.dex */
public class GeoPoint {
    private double a;
    private double b;

    public GeoPoint(double d, double d2) {
        this.a = d;
        this.b = d2;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return this.a == ((GeoPoint) obj).a && this.b == ((GeoPoint) obj).b;
        }
        return false;
    }

    public double getLatitudeE6() {
        return this.a;
    }

    public double getLongitudeE6() {
        return this.b;
    }

    public void setLatitudeE6(double d) {
        this.a = d;
    }

    public void setLongitudeE6(double d) {
        this.b = d;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.a + ", Longitude: " + this.b;
    }
}
