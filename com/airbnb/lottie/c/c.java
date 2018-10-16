package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long sL;
    private boolean sK = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float sM = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float sN = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.sK) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        eZ();
    }

    public void cR() {
        this.sK = true;
    }

    public void k(long j) {
        this.sL = j;
        eZ();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.sM, this.sN);
        this.value = clamp;
        float abs = (isReversed() ? this.sN - clamp : clamp - this.sM) / Math.abs(this.sN - this.sM);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float eY() {
        return this.value;
    }

    public void g(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.sM = f;
        this.sN = f2;
        eZ();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.sN) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.sM = f;
        eZ();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.sM) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.sN = f;
        eZ();
    }

    public void setSpeed(float f) {
        this.speed = f;
        eZ();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void cv() {
        start();
        l(isReversed() ? this.sN : this.sM);
    }

    public void cy() {
        float f = this.value;
        cancel();
        l(f);
    }

    public void cw() {
        float f = this.value;
        if (isReversed() && this.value == this.sM) {
            f = this.sN;
        } else if (!isReversed() && this.value == this.sN) {
            f = this.sM;
        }
        start();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void eZ() {
        setDuration((((float) this.sL) * (this.sN - this.sM)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.sN : this.sM;
        fArr[1] = this.speed < 0.0f ? this.sM : this.sN;
        setFloatValues(fArr);
        l(this.value);
    }
}
