package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] nL;
    private final int[] nM;

    public c(float[] fArr, int[] iArr) {
        this.nL = fArr;
        this.nM = iArr;
    }

    public float[] cF() {
        return this.nL;
    }

    public int[] getColors() {
        return this.nM;
    }

    public int getSize() {
        return this.nM.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.nM.length != cVar2.nM.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.nM.length + " vs " + cVar2.nM.length + ")");
        }
        for (int i = 0; i < cVar.nM.length; i++) {
            this.nL[i] = com.airbnb.lottie.c.e.lerp(cVar.nL[i], cVar2.nL[i], f);
            this.nM[i] = com.airbnb.lottie.c.a.a(f, cVar.nM[i], cVar2.nM[i]);
        }
    }
}
