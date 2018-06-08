package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long pK;
    private boolean pJ = false;
    private float pL = 1.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float pM = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float pN = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.pJ) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dC();
    }

    public void bu() {
        this.pJ = true;
    }

    public void h(long j) {
        this.pK = j;
        dC();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.pM, this.pN);
        this.value = clamp;
        float abs = (isReversed() ? this.pN - clamp : clamp - this.pM) / Math.abs(this.pN - this.pM);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dB() {
        return this.value;
    }

    public void g(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.pM = f;
        this.pN = f2;
        dC();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.pN) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.pM = f;
        dC();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.pM) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.pN = f;
        dC();
    }

    public void setSpeed(float f) {
        this.pL = f;
        dC();
    }

    public float getSpeed() {
        return this.pL;
    }

    public void ba() {
        start();
        l(isReversed() ? this.pN : this.pM);
    }

    private boolean isReversed() {
        return this.pL < 0.0f;
    }

    private void dC() {
        setDuration((((float) this.pK) * (this.pN - this.pM)) / Math.abs(this.pL));
        float[] fArr = new float[2];
        fArr[0] = this.pL < 0.0f ? this.pN : this.pM;
        fArr[1] = this.pL < 0.0f ? this.pM : this.pN;
        setFloatValues(fArr);
        l(this.value);
    }
}
