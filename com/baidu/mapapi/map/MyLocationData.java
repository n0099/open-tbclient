package com.baidu.mapapi.map;
/* loaded from: classes2.dex */
public class MyLocationData {
    public final float accuracy;
    public final float direction;
    public final double latitude;
    public final double longitude;
    public final int satellitesNum;
    public final float speed;

    /* loaded from: classes2.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        public double f7001a;

        /* renamed from: b  reason: collision with root package name */
        public double f7002b;

        /* renamed from: c  reason: collision with root package name */
        public float f7003c;

        /* renamed from: d  reason: collision with root package name */
        public float f7004d;

        /* renamed from: e  reason: collision with root package name */
        public float f7005e;

        /* renamed from: f  reason: collision with root package name */
        public int f7006f;

        public Builder accuracy(float f2) {
            this.f7005e = f2;
            return this;
        }

        public MyLocationData build() {
            return new MyLocationData(this.f7001a, this.f7002b, this.f7003c, this.f7004d, this.f7005e, this.f7006f);
        }

        public Builder direction(float f2) {
            this.f7004d = f2;
            return this;
        }

        public Builder latitude(double d2) {
            this.f7001a = d2;
            return this;
        }

        public Builder longitude(double d2) {
            this.f7002b = d2;
            return this;
        }

        public Builder satellitesNum(int i2) {
            this.f7006f = i2;
            return this;
        }

        public Builder speed(float f2) {
            this.f7003c = f2;
            return this;
        }
    }

    public MyLocationData(double d2, double d3, float f2, float f3, float f4, int i2) {
        this.latitude = d2;
        this.longitude = d3;
        this.speed = f2;
        this.direction = f3;
        this.accuracy = f4;
        this.satellitesNum = i2;
    }
}
