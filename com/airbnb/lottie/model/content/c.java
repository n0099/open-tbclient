package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final int[] oA;
    private final float[] oz;

    public c(float[] fArr, int[] iArr) {
        this.oz = fArr;
        this.oA = iArr;
    }

    public float[] dc() {
        return this.oz;
    }

    public int[] getColors() {
        return this.oA;
    }

    public int getSize() {
        return this.oA.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.oA.length != cVar2.oA.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.oA.length + " vs " + cVar2.oA.length + ")");
        }
        for (int i = 0; i < cVar.oA.length; i++) {
            this.oz[i] = com.airbnb.lottie.c.e.lerp(cVar.oz[i], cVar2.oz[i], f);
            this.oA[i] = com.airbnb.lottie.c.a.b(f, cVar.oA[i], cVar2.oA[i]);
        }
    }
}
