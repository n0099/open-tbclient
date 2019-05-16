package com.airbnb.lottie.c;

import android.animation.ValueAnimator;
import android.support.annotation.FloatRange;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes2.dex */
public class c extends ValueAnimator {
    private long qn;
    private boolean qm = false;
    private float speed = 1.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float value = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float qo = 0.0f;
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    private float qp = 1.0f;

    public c() {
        setInterpolator(null);
        addUpdateListener(new ValueAnimator.AnimatorUpdateListener() { // from class: com.airbnb.lottie.c.c.1
            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                if (!c.this.qm) {
                    c.this.value = ((Float) valueAnimator.getAnimatedValue()).floatValue();
                }
            }
        });
        dR();
    }

    public void bJ() {
        this.qm = true;
    }

    public void h(long j) {
        this.qn = j;
        dR();
    }

    public void l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        float clamp = e.clamp(f, this.qo, this.qp);
        this.value = clamp;
        float abs = (isReversed() ? this.qp - clamp : clamp - this.qo) / Math.abs(this.qp - this.qo);
        if (getDuration() > 0) {
            setCurrentPlayTime(abs * ((float) getDuration()));
        }
    }

    public float dQ() {
        return this.value;
    }

    public void j(@FloatRange(from = 0.0d, to = 1.0d) float f, @FloatRange(from = 0.0d, to = 1.0d) float f2) {
        this.qo = f;
        this.qp = f2;
        dR();
    }

    public void m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f >= this.qp) {
            throw new IllegalArgumentException("Min value must be smaller then max value.");
        }
        this.qo = f;
        dR();
    }

    public void n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        if (f <= this.qo) {
            throw new IllegalArgumentException("Max value must be greater than min value.");
        }
        this.qp = f;
        dR();
    }

    public void setSpeed(float f) {
        this.speed = f;
        dR();
    }

    public float getSpeed() {
        return this.speed;
    }

    public void bo() {
        start();
        l(isReversed() ? this.qp : this.qo);
    }

    public void bq() {
        float f = this.value;
        cancel();
        l(f);
    }

    public void bp() {
        float f = this.value;
        if (isReversed() && this.value == this.qo) {
            f = this.qp;
        } else if (!isReversed() && this.value == this.qp) {
            f = this.qo;
        }
        start();
        l(f);
    }

    private boolean isReversed() {
        return this.speed < 0.0f;
    }

    private void dR() {
        setDuration((((float) this.qn) * (this.qp - this.qo)) / Math.abs(this.speed));
        float[] fArr = new float[2];
        fArr[0] = this.speed < 0.0f ? this.qp : this.qo;
        fArr[1] = this.speed < 0.0f ? this.qo : this.qp;
        setFloatValues(fArr);
        l(this.value);
    }
}
