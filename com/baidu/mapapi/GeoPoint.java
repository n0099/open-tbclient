package com.baidu.mapapi;
/* loaded from: classes.dex */
public class GeoPoint {
    private int a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoPoint(double d, double d2) {
        this((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
    }

    public GeoPoint(int i, int i2) {
        this.a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return this.a == ((GeoPoint) obj).a && this.b == ((GeoPoint) obj).b;
        }
        return false;
    }

    public int getLatitudeE6() {
        return this.a;
    }

    public int getLongitudeE6() {
        return this.b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setLatitudeE6(int i) {
        this.a = i;
    }

    public void setLongitudeE6(int i) {
        this.b = i;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.a + ", Longitude: " + this.b;
    }
}
