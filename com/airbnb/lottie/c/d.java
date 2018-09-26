package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float rZ;

    public void o(float f) {
        this.rZ += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.rZ /= 2.0f;
            this.n /= 2;
        }
    }
}
