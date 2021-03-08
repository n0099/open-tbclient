package com.airbnb.lottie.model.content;
/* loaded from: classes5.dex */
public class c {
    private final float[] Hb;
    private final int[] Hc;

    public c(float[] fArr, int[] iArr) {
        this.Hb = fArr;
        this.Hc = iArr;
    }

    public float[] jm() {
        return this.Hb;
    }

    public int[] getColors() {
        return this.Hc;
    }

    public int getSize() {
        return this.Hc.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.Hc.length != cVar2.Hc.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.Hc.length + " vs " + cVar2.Hc.length + ")");
        }
        for (int i = 0; i < cVar.Hc.length; i++) {
            this.Hb[i] = com.airbnb.lottie.d.e.lerp(cVar.Hb[i], cVar2.Hb[i], f);
            this.Hc[i] = com.airbnb.lottie.d.b.b(f, cVar.Hc[i], cVar2.Hc[i]);
        }
    }
}
