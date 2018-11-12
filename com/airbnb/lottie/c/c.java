package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long sN;
    private boolean sM = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float sO = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float sP = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.sM) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        eY();
    }

    public void cQ() {
        this.sM = true;
    }

    public void m(long j) {
        this.sN = j;
        eY();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.sO, this.sP);
        this.value = clamp;
        float abs = (isReversed() ? this.sP - clamp : clamp - this.sO) / Math.abs(this.sP - this.sO);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float eX() {
        return this.value;
    }

    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.sO = f;
        this.sP = f2;
        eY();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.sP) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.sO = f;
        eY();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.sO) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.sP = f;
        eY();
    }

    public void setSpeed(float f) {
        this.speed = f;
        eY();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void cv() {
        start();
        l(isReversed() ? this.sP : this.sO);
    }

    public void cx() {
        float f = this.value;
        cancel();
        l(f);
    }

    public void cw() {
        float f = this.value;
        if (isReversed() && this.value == this.sO) {
            f = this.sP;
        } else if (!isReversed() && this.value == this.sP) {
            f = this.sO;
        }
        start();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void eY() {
        setDuration((((float) this.sN) * (this.sP - this.sO)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.sP : this.sO;
        fArr[1] = this.speed < 0.0f ? this.sO : this.sP;
        setFloatValues(fArr);
        l(this.value);
    }
}
