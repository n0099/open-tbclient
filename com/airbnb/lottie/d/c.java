package com.airbnb.lottie.d;

import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes6.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.airbnb.lottie.e composition;
    private float speed = 1.0f;
    private boolean kg = false;
    private long kh = 0;
    private float ki = 0.0f;
    private int repeatCount = 0;
    private float kj = -2.1474836E9f;
    private float kk = 2.1474836E9f;
    @VisibleForTesting
    protected boolean kl = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(dF());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float dF() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.ki - this.composition.bh()) / (this.composition.bi() - this.composition.bh());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.ki) / (getMaxFrame() - getMinFrame());
        }
        return (this.ki - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.bg();
    }

    public float dG() {
        return this.ki;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.kl;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        dI();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float dH = ((float) (nanoTime - this.kh)) / dH();
            float f = this.ki;
            if (isReversed()) {
                dH = -dH;
            }
            this.ki = dH + f;
            boolean z = !e.c(this.ki, getMinFrame(), getMaxFrame());
            this.ki = e.clamp(this.ki, getMinFrame(), getMaxFrame());
            this.kh = nanoTime;
            dE();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.ki = getMaxFrame();
                    dJ();
                    y(isReversed());
                } else {
                    dC();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.kg = this.kg ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.ki = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.kh = nanoTime;
                }
            }
            dK();
        }
    }

    private float dH() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.bj()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.kj = -2.1474836E9f;
        this.kk = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.e eVar) {
        boolean z = this.composition == null;
        this.composition = eVar;
        if (z) {
            f((int) Math.max(this.kj, eVar.bh()), (int) Math.min(this.kk, eVar.bi()));
        } else {
            f((int) eVar.bh(), (int) eVar.bi());
        }
        setFrame((int) this.ki);
        this.kh = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.ki != i) {
            this.ki = e.clamp(i, getMinFrame(), getMaxFrame());
            this.kh = System.nanoTime();
            dE();
        }
    }

    public void setMinFrame(int i) {
        f(i, (int) this.kk);
    }

    public void setMaxFrame(int i) {
        f((int) this.kj, i);
    }

    public void f(int i, int i2) {
        float bh = this.composition == null ? -3.4028235E38f : this.composition.bh();
        float bi = this.composition == null ? Float.MAX_VALUE : this.composition.bi();
        this.kj = e.clamp(i, bh, bi);
        this.kk = e.clamp(i2, bh, bi);
        setFrame((int) e.clamp(this.ki, i, i2));
    }

    public void reverseAnimationSpeed() {
        setSpeed(-getSpeed());
    }

    public void setSpeed(float f) {
        this.speed = f;
    }

    public float getSpeed() {
        return this.speed;
    }

    @Override // android.animation.ValueAnimator
    public void setRepeatMode(int i) {
        super.setRepeatMode(i);
        if (i != 2 && this.kg) {
            this.kg = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.kl = true;
        x(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.kh = System.nanoTime();
        this.repeatCount = 0;
        dI();
    }

    @MainThread
    public void endAnimation() {
        dJ();
        y(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        dJ();
    }

    @MainThread
    public void resumeAnimation() {
        this.kl = true;
        dI();
        this.kh = System.nanoTime();
        if (isReversed() && dG() == getMinFrame()) {
            this.ki = getMaxFrame();
        } else if (!isReversed() && dG() == getMaxFrame()) {
            this.ki = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        dD();
        dJ();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.kj == -2.1474836E9f ? this.composition.bh() : this.kj;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.kk == 2.1474836E9f ? this.composition.bi() : this.kk;
    }

    protected void dI() {
        if (isRunning()) {
            z(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void dJ() {
        z(true);
    }

    @MainThread
    protected void z(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.kl = false;
        }
    }

    private void dK() {
        if (this.composition != null) {
            if (this.ki < this.kj || this.ki > this.kk) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.kj), Float.valueOf(this.kk), Float.valueOf(this.ki)));
            }
        }
    }
}
