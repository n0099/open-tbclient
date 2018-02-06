package android.support.v4.view.animation;

import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
abstract class a implements Interpolator {
    private final float[] Bt;
    private final float Bu;

    public a(float[] fArr) {
        this.Bt = fArr;
        this.Bu = 1.0f / (this.Bt.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) ((this.Bt.length - 1) * f), this.Bt.length - 2);
        float f2 = (f - (min * this.Bu)) / this.Bu;
        return ((this.Bt[min + 1] - this.Bt[min]) * f2) + this.Bt[min];
    }
}
