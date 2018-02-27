package android.support.v4.view.animation;

import android.view.animation.Interpolator;
/* loaded from: classes2.dex */
abstract class a implements Interpolator {
    private final float[] Bo;
    private final float Bp;

    public a(float[] fArr) {
        this.Bo = fArr;
        this.Bp = 1.0f / (this.Bo.length - 1);
    }

    @Override // android.animation.TimeInterpolator
    public float getInterpolation(float f) {
        if (f >= 1.0f) {
            return 1.0f;
        }
        if (f <= 0.0f) {
            return 0.0f;
        }
        int min = Math.min((int) ((this.Bo.length - 1) * f), this.Bo.length - 2);
        float f2 = (f - (min * this.Bp)) / this.Bp;
        return ((this.Bo[min + 1] - this.Bo[min]) * f2) + this.Bo[min];
    }
}
