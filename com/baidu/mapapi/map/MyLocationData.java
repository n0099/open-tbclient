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
        public double f7242a;

        /* renamed from: b  reason: collision with root package name */
        public double f7243b;

        /* renamed from: c  reason: collision with root package name */
        public float f7244c;

        /* renamed from: d  reason: collision with root package name */
        public float f7245d;

        /* renamed from: e  reason: collision with root package name */
        public float f7246e;

        /* renamed from: f  reason: collision with root package name */
        public int f7247f;

        public Builder accuracy(float f2) {
            this.f7246e = f2;
            return this;
        }

        public MyLocationData build() {
            return new MyLocationData(this.f7242a, this.f7243b, this.f7244c, this.f7245d, this.f7246e, this.f7247f);
        }

        public Builder direction(float f2) {
            this.f7245d = f2;
            return this;
        }

        public Builder latitude(double d2) {
            this.f7242a = d2;
            return this;
        }

        public Builder longitude(double d2) {
            this.f7243b = d2;
            return this;
        }

        public Builder satellitesNum(int i2) {
            this.f7247f = i2;
            return this;
        }

        public Builder speed(float f2) {
            this.f7244c = f2;
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
