package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long pA;
    private boolean pz = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float pB = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float pC = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.pz) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dA();
    }

    public void bs() {
        this.pz = true;
    }

    public void h(long j) {
        this.pA = j;
        dA();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.pB, this.pC);
        this.value = clamp;
        float abs = (isReversed() ? this.pC - clamp : clamp - this.pB) / Math.abs(this.pC - this.pB);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dz() {
        return this.value;
    }

    public void g(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.pB = f;
        this.pC = f2;
        dA();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.pC) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.pB = f;
        dA();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.pB) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.pC = f;
        dA();
    }

    public void setSpeed(float f) {
        this.speed = f;
        dA();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void aX() {
        start();
        l(isReversed() ? this.pC : this.pB);
    }

    public void aZ() {
        float f = this.value;
        cancel();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void dA() {
        setDuration((((float) this.pA) * (this.pC - this.pB)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.pC : this.pB;
        fArr[1] = this.speed < 0.0f ? this.pB : this.pC;
        setFloatValues(fArr);
        l(this.value);
    }
}
