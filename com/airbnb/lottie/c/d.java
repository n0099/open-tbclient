package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float pF;

    public void o(float f) {
        this.pF += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.pF /= 2.0f;
            this.n /= 2;
        }
    }
}
