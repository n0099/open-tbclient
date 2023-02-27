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
        public double a;
        public double b;
        public float c;
        public float d;
        public float e;
        public int f;

        public MyLocationData build() {
            return new MyLocationData(this.a, this.b, this.c, this.d, this.e, this.f);
        }

        public Builder accuracy(float f) {
            this.e = f;
            return this;
        }

        public Builder direction(float f) {
            this.d = f;
            return this;
        }

        public Builder latitude(double d) {
            this.a = d;
            return this;
        }

        public Builder longitude(double d) {
            this.b = d;
            return this;
        }

        public Builder satellitesNum(int i) {
            this.f = i;
            return this;
        }

        public Builder speed(float f) {
            this.c = f;
            return this;
        }
    }

    public MyLocationData(double d, double d2, float f, float f2, float f3, int i) {
        this.latitude = d;
        this.longitude = d2;
        this.speed = f;
        this.direction = f2;
        this.accuracy = f3;
        this.satellitesNum = i;
    }
}
