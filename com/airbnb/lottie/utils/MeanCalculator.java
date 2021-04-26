package com.airbnb.lottie.utils;
/* loaded from: classes.dex */
public class MeanCalculator {
    public int n;
    public float sum;

    public void add(float f2) {
        float f3 = this.sum + f2;
        this.sum = f3;
        int i2 = this.n + 1;
        this.n = i2;
        if (i2 == Integer.MAX_VALUE) {
            this.sum = f3 / 2.0f;
            this.n = i2 / 2;
        }
    }

    public float getMean() {
        int i2 = this.n;
        if (i2 == 0) {
            return 0.0f;
        }
        return this.sum / i2;
    }
}
