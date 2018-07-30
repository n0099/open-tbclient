package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] nK;
    private final int[] nL;

    public c(float[] fArr, int[] iArr) {
        this.nK = fArr;
        this.nL = iArr;
    }

    public float[] cF() {
        return this.nK;
    }

    public int[] getColors() {
        return this.nL;
    }

    public int getSize() {
        return this.nL.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.nL.length != cVar2.nL.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.nL.length + " vs " + cVar2.nL.length + ")");
        }
        for (int i = 0; i < cVar.nL.length; i++) {
            this.nK[i] = com.airbnb.lottie.c.e.lerp(cVar.nK[i], cVar2.nK[i], f);
            this.nL[i] = com.airbnb.lottie.c.a.a(f, cVar.nL[i], cVar2.nL[i]);
        }
    }
}
