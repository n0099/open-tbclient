package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float pP;

    public void o(float f) {
        this.pP += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.pP /= 2.0f;
            this.n /= 2;
        }
    }
}
