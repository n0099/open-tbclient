package com.baidu.live.lottie.d;
/* loaded from: classes9.dex */
public class d {
    private float HH;
    private int n;

    public void add(float f) {
        this.HH += f;
        this.n++;
        if (this.n == Integer.MAX_VALUE) {
            this.HH /= 2.0f;
            this.n /= 2;
        }
    }
}
