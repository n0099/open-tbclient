package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] gS;
    private final int[] gT;

    public c(float[] fArr, int[] iArr) {
        this.gS = fArr;
        this.gT = iArr;
    }

    public float[] cv() {
        return this.gS;
    }

    public int[] getColors() {
        return this.gT;
    }

    public int getSize() {
        return this.gT.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.gT.length != cVar2.gT.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.gT.length + " vs " + cVar2.gT.length + ")");
        }
        for (int i = 0; i < cVar.gT.length; i++) {
            this.gS[i] = com.airbnb.lottie.c.e.lerp(cVar.gS[i], cVar2.gS[i], f);
            this.gT[i] = com.airbnb.lottie.c.a.b(f, cVar.gT[i], cVar2.gT[i]);
        }
    }
}
