package com.airbnb.lottie.d;
/* loaded from: classes3.dex */
public class d {
    private float HJ;
    private int n;

    public void add(float f) {
        this.HJ += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.HJ /= 2.0f;
            this.n /= 2;
        }
    }
}
