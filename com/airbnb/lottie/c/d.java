package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float sR;

    public void o(float f) {
        this.sR += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.sR /= 2.0f;
            this.n /= 2;
        }
    }
}
