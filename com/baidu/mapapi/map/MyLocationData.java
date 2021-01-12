package com.baidu.mapapi.map;
/* loaded from: classes6.dex */
public class MyLocationData {
    public final float accuracy;
    public final float direction;
    public final double latitude;
    public final double longitude;
    public final int satellitesNum;
    public final float speed;

    /* loaded from: classes6.dex */
    public static class Builder {

        /* renamed from: a  reason: collision with root package name */
        private double f2750a;

        /* renamed from: b  reason: collision with root package name */
        private double f2751b;
        private float c;
        private float d;
        private float e;
        private int f;

        public Builder accuracy(float f) {
            this.e = f;
            return this;
        }

        public MyLocationData build() {
            return new MyLocationData(this.f2750a, this.f2751b, this.c, this.d, this.e, this.f);
        }

        public Builder direction(float f) {
            this.d = f;
            return this;
        }

        public Builder latitude(double d) {
            this.f2750a = d;
            return this;
        }

        public Builder longitude(double d) {
            this.f2751b = d;
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

    MyLocationData(double d, double d2, float f, float f2, float f3, int i) {
        this.latitude = d;
        this.longitude = d2;
        this.speed = f;
        this.direction = f2;
        this.accuracy = f3;
        this.satellitesNum = i;
    }
}
