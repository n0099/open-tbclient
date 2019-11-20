package com.airbnb.lottie.c;
/* loaded from: classes2.dex */
public class d {

    /* renamed from: if  reason: not valid java name */
    private float f0if;
    private int n;

    public void o(float f) {
        this.f0if += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.f0if /= 2.0f;
            this.n /= 2;
        }
    }
}
