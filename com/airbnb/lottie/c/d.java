package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {
    private int n;
    private float qr;

    public void o(float f) {
        this.qr += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.qr /= 2.0f;
            this.n /= 2;
        }
    }
}
