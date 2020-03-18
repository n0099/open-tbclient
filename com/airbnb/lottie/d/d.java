package com.airbnb.lottie.d;
/* loaded from: classes6.dex */
public class d {
    private float kl;
    private int n;

    public void add(float f) {
        this.kl += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.kl /= 2.0f;
            this.n /= 2;
        }
    }
}
