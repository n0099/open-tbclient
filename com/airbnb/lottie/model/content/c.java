package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] qZ;
    private final int[] ra;

    public c(float[] fArr, int[] iArr) {
        this.qZ = fArr;
        this.ra = iArr;
    }

    public float[] ee() {
        return this.qZ;
    }

    public int[] getColors() {
        return this.ra;
    }

    public int getSize() {
        return this.ra.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.ra.length != cVar2.ra.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.ra.length + " vs " + cVar2.ra.length + ")");
        }
        for (int i = 0; i < cVar.ra.length; i++) {
            this.qZ[i] = com.airbnb.lottie.c.e.lerp(cVar.qZ[i], cVar2.qZ[i], f);
            this.ra[i] = com.airbnb.lottie.c.a.a(f, cVar.ra[i], cVar2.ra[i]);
        }
    }
}
