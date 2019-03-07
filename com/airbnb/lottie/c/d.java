package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float sN;

    public void o(float f) {
        this.sN += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.sN /= 2.0f;
            this.n /= 2;
        }
    }
}
