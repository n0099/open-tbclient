package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float qt;

    public void o(float f) {
        this.qt += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.qt /= 2.0f;
            this.n /= 2;
        }
    }
}
