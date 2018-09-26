package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] qn;
    private final int[] qo;

    public c(float[] fArr, int[] iArr) {
        this.qn = fArr;
        this.qo = iArr;
    }

    public float[] dM() {
        return this.qn;
    }

    public int[] getColors() {
        return this.qo;
    }

    public int getSize() {
        return this.qo.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.qo.length != cVar2.qo.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.qo.length + " vs " + cVar2.qo.length + ")");
        }
        for (int i = 0; i < cVar.qo.length; i++) {
            this.qn[i] = com.airbnb.lottie.c.e.lerp(cVar.qn[i], cVar2.qn[i], f);
            this.qo[i] = com.airbnb.lottie.c.a.a(f, cVar.qo[i], cVar2.qo[i]);
        }
    }
}
