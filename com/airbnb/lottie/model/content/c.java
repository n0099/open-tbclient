package com.airbnb.lottie.model.content;
/* loaded from: classes5.dex */
public class c {
    private final int[] colors;
    private final float[] hT;

    public c(float[] fArr, int[] iArr) {
        this.hT = fArr;
        this.colors = iArr;
    }

    public float[] cx() {
        return this.hT;
    }

    public int[] getColors() {
        return this.colors;
    }

    public int getSize() {
        return this.colors.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.colors.length != cVar2.colors.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.colors.length + " vs " + cVar2.colors.length + ")");
        }
        for (int i = 0; i < cVar.colors.length; i++) {
            this.hT[i] = com.airbnb.lottie.d.e.lerp(cVar.hT[i], cVar2.hT[i], f);
            this.colors[i] = com.airbnb.lottie.d.b.b(f, cVar.colors[i], cVar2.colors[i]);
        }
    }
}
