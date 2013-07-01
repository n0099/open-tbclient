package com.baidu.mapapi;
/* loaded from: classes.dex */
public class GeoPoint {

    /* renamed from: a  reason: collision with root package name */
    private int f502a;
    private int b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public GeoPoint(double d, double d2) {
        this((int) (d * 1000000.0d), (int) (d2 * 1000000.0d));
    }

    public GeoPoint(int i, int i2) {
        this.f502a = i;
        this.b = i2;
    }

    public boolean equals(Object obj) {
        if (obj != null && obj.getClass() == getClass()) {
            return this.f502a == ((GeoPoint) obj).f502a && this.b == ((GeoPoint) obj).b;
        }
        return false;
    }

    public int getLatitudeE6() {
        return this.f502a;
    }

    public int getLongitudeE6() {
        return this.b;
    }

    public int hashCode() {
        return toString().hashCode();
    }

    public void setLatitudeE6(int i) {
        this.f502a = i;
    }

    public void setLongitudeE6(int i) {
        this.b = i;
    }

    public String toString() {
        return "GeoPoint: Latitude: " + this.f502a + ", Longitude: " + this.b;
    }
}
