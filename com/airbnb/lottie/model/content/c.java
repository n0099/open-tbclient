package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] qW;
    private final int[] qX;

    public c(float[] fArr, int[] iArr) {
        this.qW = fArr;
        this.qX = iArr;
    }

    public float[] ec() {
        return this.qW;
    }

    public int[] getColors() {
        return this.qX;
    }

    public int getSize() {
        return this.qX.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.qX.length != cVar2.qX.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.qX.length + " vs " + cVar2.qX.length + ")");
        }
        for (int i = 0; i < cVar.qX.length; i++) {
            this.qW[i] = com.airbnb.lottie.c.e.lerp(cVar.qW[i], cVar2.qW[i], f);
            this.qX[i] = com.airbnb.lottie.c.a.a(f, cVar.qX[i], cVar2.qX[i]);
        }
    }
}
