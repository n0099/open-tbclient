package com.airbnb.lottie.d;
/* loaded from: classes6.dex */
public class d {
    private float km;
    private int n;

    public void add(float f) {
        this.km += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.km /= 2.0f;
            this.n /= 2;
        }
    }
}
