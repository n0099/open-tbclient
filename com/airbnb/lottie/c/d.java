package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float sP;

    public void o(float f) {
        this.sP += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.sP /= 2.0f;
            this.n /= 2;
        }
    }
}
