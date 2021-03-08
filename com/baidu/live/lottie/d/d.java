package com.baidu.live.lottie.d;
/* loaded from: classes9.dex */
public class d {
    private float Jg;
    private int n;

    public void add(float f) {
        this.Jg += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.Jg /= 2.0f;
            this.n /= 2;
        }
    }
}
