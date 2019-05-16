package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] oy;
    private final int[] oz;

    public c(float[] fArr, int[] iArr) {
        this.oy = fArr;
        this.oz = iArr;
    }

    public float[] cW() {
        return this.oy;
    }

    public int[] getColors() {
        return this.oz;
    }

    public int getSize() {
        return this.oz.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.oz.length != cVar2.oz.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.oz.length + " vs " + cVar2.oz.length + ")");
        }
        for (int i = 0; i < cVar.oz.length; i++) {
            this.oy[i] = com.airbnb.lottie.c.e.lerp(cVar.oy[i], cVar2.oy[i], f);
            this.oz[i] = com.airbnb.lottie.c.a.a(f, cVar.oz[i], cVar2.oz[i]);
        }
    }
}
