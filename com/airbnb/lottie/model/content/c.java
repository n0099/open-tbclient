package com.airbnb.lottie.model.content;
/* loaded from: classes2.dex */
public class c {
    private final float[] ra;
    private final int[] rb;

    public c(float[] fArr, int[] iArr) {
        this.ra = fArr;
        this.rb = iArr;
    }

    public float[] ed() {
        return this.ra;
    }

    public int[] getColors() {
        return this.rb;
    }

    public int getSize() {
        return this.rb.length;
    }

    public void a(c cVar, c cVar2, float f) {
        if (cVar.rb.length != cVar2.rb.length) {
            throw new IllegalArgumentException("Cannot interpolate between gradients. Lengths vary (" + cVar.rb.length + " vs " + cVar2.rb.length + ")");
        }
        for (int i = 0; i < cVar.rb.length; i++) {
            this.ra[i] = com.airbnb.lottie.c.e.lerp(cVar.ra[i], cVar2.ra[i], f);
            this.rb[i] = com.airbnb.lottie.c.a.a(f, cVar.rb[i], cVar2.rb[i]);
        }
    }
}
