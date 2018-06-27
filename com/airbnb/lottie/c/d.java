package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float pN;

    public void o(float f) {
        this.pN += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.pN /= 2.0f;
            this.n /= 2;
        }
    }
}
