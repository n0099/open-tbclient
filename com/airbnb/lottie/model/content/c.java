package com.airbnb.lottie.model.content;
/* loaded from: classes3.dex */
public class c {
    private final float[] FE;
    private final int[] FF;

    public c(float[] fArr, int[] iArr) {
        this.FE = fArr;
        this.FF = iArr;
    }

    public float[] jn() {
        return this.FE;
    }

    public int[] getColors() {
        return this.FF;
    }

    public int getSize() {
        return this.FF.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.FF.length != cVar2.FF.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.FF.length + " vs " + cVar2.FF.length + ")");
        }
        for (int i = 0; i < cVar.FF.length; i++) {
            this.FE[i] = com.airbnb.lottie.d.e.lerp(cVar.FE[i], cVar2.FE[i], f);
            this.FF[i] = com.airbnb.lottie.d.b.b(f, cVar.FF[i], cVar2.FF[i]);
        }
    }
}
