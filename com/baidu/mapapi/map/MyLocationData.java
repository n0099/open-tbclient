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
        public double f6959a;

        /* renamed from: b  reason: collision with root package name */
        public double f6960b;

        /* renamed from: c  reason: collision with root package name */
        public float f6961c;

        /* renamed from: d  reason: collision with root package name */
        public float f6962d;

        /* renamed from: e  reason: collision with root package name */
        public float f6963e;

        /* renamed from: f  reason: collision with root package name */
        public int f6964f;

        public Builder accuracy(float f2) {
            this.f6963e = f2;
            return this;
        }

        public MyLocationData build() {
            return new MyLocationData(this.f6959a, this.f6960b, this.f6961c, this.f6962d, this.f6963e, this.f6964f);
        }

        public Builder direction(float f2) {
            this.f6962d = f2;
            return this;
        }

        public Builder latitude(double d2) {
            this.f6959a = d2;
            return this;
        }

        public Builder longitude(double d2) {
            this.f6960b = d2;
            return this;
        }

        public Builder satellitesNum(int i) {
            this.f6964f = i;
            return this;
        }

        public Builder speed(float f2) {
            this.f6961c = f2;
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
