package com.airbnb.lottie.model.content;
/* loaded from: classes3.dex */
public class c {
    private final float[] FG;
    private final int[] FH;

    public c(float[] fArr, int[] iArr) {
        this.FG = fArr;
        this.FH = iArr;
    }

    public float[] jn() {
        return this.FG;
    }

    public int[] getColors() {
        return this.FH;
    }

    public int getSize() {
        return this.FH.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.FH.length != cVar2.FH.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.FH.length + " vs " + cVar2.FH.length + ")");
        }
        for (int i = 0; i < cVar.FH.length; i++) {
            this.FG[i] = com.airbnb.lottie.d.e.lerp(cVar.FG[i], cVar2.FG[i], f);
            this.FH[i] = com.airbnb.lottie.d.b.b(f, cVar.FH[i], cVar2.FH[i]);
        }
    }
}
