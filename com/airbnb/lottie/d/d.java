package com.airbnb.lottie.d;
/* loaded from: classes16.dex */
public class d {
    private float Hj;
    private int n;

    public void add(float f) {
        this.Hj += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.Hj /= 2.0f;
            this.n /= 2;
        }
    }
}
