package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long pB;
    private boolean pA = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float pC = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float pD = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.pA) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dA();
    }

    public void bs() {
        this.pA = true;
    }

    public void h(long j) {
        this.pB = j;
        dA();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.pC, this.pD);
        this.value = clamp;
        float abs = (isReversed() ? this.pD - clamp : clamp - this.pC) / Math.abs(this.pD - this.pC);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dz() {
        return this.value;
    }

    public void g(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.pC = f;
        this.pD = f2;
        dA();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.pD) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.pC = f;
        dA();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.pC) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.pD = f;
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
        l(isReversed() ? this.pD : this.pC);
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
        setDuration((((float) this.pB) * (this.pD - this.pC)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.pD : this.pC;
        fArr[1] = this.speed < 0.0f ? this.pC : this.pD;
        setFloatValues(fArr);
        l(this.value);
    }
}
