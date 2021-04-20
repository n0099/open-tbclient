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
        public double f6995a;

        /* renamed from: b  reason: collision with root package name */
        public double f6996b;

        /* renamed from: c  reason: collision with root package name */
        public float f6997c;

        /* renamed from: d  reason: collision with root package name */
        public float f6998d;

        /* renamed from: e  reason: collision with root package name */
        public float f6999e;

        /* renamed from: f  reason: collision with root package name */
        public int f7000f;

        public Builder accuracy(float f2) {
            this.f6999e = f2;
            return this;
        }

        public MyLocationData build() {
            return new MyLocationData(this.f6995a, this.f6996b, this.f6997c, this.f6998d, this.f6999e, this.f7000f);
        }

        public Builder direction(float f2) {
            this.f6998d = f2;
            return this;
        }

        public Builder latitude(double d2) {
            this.f6995a = d2;
            return this;
        }

        public Builder longitude(double d2) {
            this.f6996b = d2;
            return this;
        }

        public Builder satellitesNum(int i) {
            this.f7000f = i;
            return this;
        }

        public Builder speed(float f2) {
            this.f6997c = f2;
            return this;
        }
    }

    public MyLocationData(double d2, double d3, float f2, float f3, float f4, int i) {
        this.latitude = d2;
        this.longitude = d3;
        this.speed = f2;
        this.direction = f3;
        this.accuracy = f4;
        this.satellitesNum = i;
    }
}
