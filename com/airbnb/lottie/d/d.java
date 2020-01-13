package com.airbnb.lottie.d;
/* loaded from: classes5.dex */
public class d {
    private float ki;
    private int n;

    public void add(float f) {
        this.ki += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.ki /= 2.0f;
            this.n /= 2;
        }
    }
}
