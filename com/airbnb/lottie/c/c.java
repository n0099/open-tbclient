package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long sJ;
    private boolean sI = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float sK = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float sL = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.sI) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        eX();
    }

    public void cP() {
        this.sI = true;
    }

    public void k(long j) {
        this.sJ = j;
        eX();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.sK, this.sL);
        this.value = clamp;
        float abs = (isReversed() ? this.sL - clamp : clamp - this.sK) / Math.abs(this.sL - this.sK);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float eW() {
        return this.value;
    }

    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.sK = f;
        this.sL = f2;
        eX();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.sL) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.sK = f;
        eX();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.sK) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.sL = f;
        eX();
    }

    public void setSpeed(float f) {
        this.speed = f;
        eX();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void cu() {
        start();
        l(isReversed() ? this.sL : this.sK);
    }

    public void cw() {
        float f = this.value;
        cancel();
        l(f);
    }

    public void cv() {
        float f = this.value;
        if (isReversed() && this.value == this.sK) {
            f = this.sL;
        } else if (!isReversed() && this.value == this.sL) {
            f = this.sK;
        }
        start();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void eX() {
        setDuration((((float) this.sJ) * (this.sL - this.sK)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.sL : this.sK;
        fArr[1] = this.speed < 0.0f ? this.sK : this.sL;
        setFloatValues(fArr);
        l(this.value);
    }
}
