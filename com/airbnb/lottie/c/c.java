package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long pJ;
    private boolean pI = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float pK = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float pL = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.pI) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dC();
    }

    public void bu() {
        this.pI = true;
    }

    public void h(long j) {
        this.pJ = j;
        dC();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.pK, this.pL);
        this.value = clamp;
        float abs = (isReversed() ? this.pL - clamp : clamp - this.pK) / Math.abs(this.pL - this.pK);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dB() {
        return this.value;
    }

    public void g(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.pK = f;
        this.pL = f2;
        dC();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.pL) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.pK = f;
        dC();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.pK) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.pL = f;
        dC();
    }

    public void setSpeed(float f) {
        this.speed = f;
        dC();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void ba() {
        start();
        l(isReversed() ? this.pL : this.pK);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void dC() {
        setDuration((((float) this.pJ) * (this.pL - this.pK)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.pL : this.pK;
        fArr[1] = this.speed < 0.0f ? this.pK : this.pL;
        setFloatValues(fArr);
        l(this.value);
    }
}
