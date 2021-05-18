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
        public double f7058a;

        /* renamed from: b  reason: collision with root package name */
        public double f7059b;

        /* renamed from: c  reason: collision with root package name */
        public float f7060c;

        /* renamed from: d  reason: collision with root package name */
        public float f7061d;

        /* renamed from: e  reason: collision with root package name */
        public float f7062e;

        /* renamed from: f  reason: collision with root package name */
        public int f7063f;

        public Builder accuracy(float f2) {
            this.f7062e = f2;
            return this;
        }

        public MyLocationData build() {
            return new MyLocationData(this.f7058a, this.f7059b, this.f7060c, this.f7061d, this.f7062e, this.f7063f);
        }

        public Builder direction(float f2) {
            this.f7061d = f2;
            return this;
        }

        public Builder latitude(double d2) {
            this.f7058a = d2;
            return this;
        }

        public Builder longitude(double d2) {
            this.f7059b = d2;
            return this;
        }

        public Builder satellitesNum(int i2) {
            this.f7063f = i2;
            return this;
        }

        public Builder speed(float f2) {
            this.f7060c = f2;
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
