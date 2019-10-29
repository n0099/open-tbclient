package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private float iJ;
    private int n;

    public void o(float f) {
        this.iJ += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.iJ /= 2.0f;
            this.n /= 2;
        }
    }
}
