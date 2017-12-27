package android.support.v4.view.animation;

import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
abstract class a implements Interpolator {
    private final float[] Bu;
    private final float Bv;

    public a(float[] fArr) {
        this.Bu = fArr;
        this.Bv = 1.0f / (this.Bu.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) ((this.Bu.length - 1) * f), this.Bu.length - 2);
        float f2 = (f - (min * this.Bv)) / this.Bv;
        return ((this.Bu[min + 1] - this.Bu[min]) * f2) + this.Bu[min];
    }
}
