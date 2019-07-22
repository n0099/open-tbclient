package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long qp;
    private boolean qo = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float qq = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float qr = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.qo) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dY();
    }

    public void bN() {
        this.qo = true;
    }

    public void h(long j) {
        this.qp = j;
        dY();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.qq, this.qr);
        this.value = clamp;
        float abs = (isReversed() ? this.qr - clamp : clamp - this.qq) / Math.abs(this.qr - this.qq);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dX() {
        return this.value;
    }

    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.qq = f;
        this.qr = f2;
        dY();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.qr) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.qq = f;
        dY();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.qq) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.qr = f;
        dY();
    }

    public void setSpeed(float f) {
        this.speed = f;
        dY();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void br() {
        start();
        l(isReversed() ? this.qr : this.qq);
    }

    public void bt() {
        float f = this.value;
        cancel();
        l(f);
    }

    public void bs() {
        float f = this.value;
        if (isReversed() && this.value == this.qq) {
            f = this.qr;
        } else if (!isReversed() && this.value == this.qr) {
            f = this.qq;
        }
        start();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void dY() {
        setDuration((((float) this.qp) * (this.qr - this.qq)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.qr : this.qq;
        fArr[1] = this.speed < 0.0f ? this.qq : this.qr;
        setFloatValues(fArr);
        l(this.value);
    }
}
