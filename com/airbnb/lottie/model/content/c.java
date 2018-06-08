package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] nV;
    private final int[] nW;

    public c(float[] fArr, int[] iArr) {
        this.nV = fArr;
        this.nW = iArr;
    }

    public float[] cH() {
        return this.nV;
    }

    public int[] getColors() {
        return this.nW;
    }

    public int getSize() {
        return this.nW.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.nW.length != cVar2.nW.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.nW.length + " vs " + cVar2.nW.length + ")");
        }
        for (int i = 0; i < cVar.nW.length; i++) {
            this.nV[i] = com.airbnb.lottie.c.e.lerp(cVar.nV[i], cVar2.nV[i], f);
            this.nW[i] = com.airbnb.lottie.c.a.a(f, cVar.nW[i], cVar2.nW[i]);
        }
    }
}
