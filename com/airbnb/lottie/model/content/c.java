package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] nU;
    private final int[] nV;

    public c(float[] fArr, int[] iArr) {
        this.nU = fArr;
        this.nV = iArr;
    }

    public float[] cH() {
        return this.nU;
    }

    public int[] getColors() {
        return this.nV;
    }

    public int getSize() {
        return this.nV.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.nV.length != cVar2.nV.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.nV.length + " vs " + cVar2.nV.length + ")");
        }
        for (int i = 0; i < cVar.nV.length; i++) {
            this.nU[i] = com.airbnb.lottie.c.e.lerp(cVar.nU[i], cVar2.nU[i], f);
            this.nV[i] = com.airbnb.lottie.c.a.a(f, cVar.nV[i], cVar2.nV[i]);
        }
    }
}
