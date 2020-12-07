package com.airbnb.lottie.d;
/* loaded from: classes7.dex */
public class d {
    private float Ib;
    private int n;

    public void add(float f) {
        this.Ib += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.Ib /= 2.0f;
            this.n /= 2;
        }
    }
}
