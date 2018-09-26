package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long rV;
    private boolean rU = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float rW = 0.0f;
    @FloatRange(from = 0.0d, to = 1.0d)
    private float rX = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.rU) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        eH();
    }

    public void cz() {
        this.rU = true;
    }

    public void k(long j) {
        this.rV = j;
        eH();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.rW, this.rX);
        this.value = clamp;
        float abs = (isReversed() ? this.rX - clamp : clamp - this.rW) / Math.abs(this.rX - this.rW);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float eG() {
        return this.value;
    }

    public void g(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.rW = f;
        this.rX = f2;
        eH();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.rX) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.rW = f;
        eH();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.rW) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.rX = f;
        eH();
    }

    public void setSpeed(float f) {
        this.speed = f;
        eH();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void ce() {
        start();
        l(isReversed() ? this.rX : this.rW);
    }

    public void cg() {
        float f = this.value;
        cancel();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void eH() {
        setDuration((((float) this.rV) * (this.rX - this.rW)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.rX : this.rW;
        fArr[1] = this.speed < 0.0f ? this.rW : this.rX;
        setFloatValues(fArr);
        l(this.value);
    }
}
