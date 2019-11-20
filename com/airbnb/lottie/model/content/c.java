package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] gt;
    private final int[] gu;

    public c(float[] fArr, int[] iArr) {
        this.gt = fArr;
        this.gu = iArr;
    }

    public float[] cv() {
        return this.gt;
    }

    public int[] getColors() {
        return this.gu;
    }

    public int getSize() {
        return this.gu.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.gu.length != cVar2.gu.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.gu.length + " vs " + cVar2.gu.length + ")");
        }
        for (int i = 0; i < cVar.gu.length; i++) {
            this.gt[i] = com.airbnb.lottie.c.e.lerp(cVar.gt[i], cVar2.gt[i], f);
            this.gu[i] = com.airbnb.lottie.c.a.b(f, cVar.gu[i], cVar2.gu[i]);
        }
    }
}
