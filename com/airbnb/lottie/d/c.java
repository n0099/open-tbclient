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
    private boolean kf = false;
    private long kg = 0;
    private float kh = 0.0f;
    private int repeatCount = 0;
    private float ki = -2.1474836E9f;
    private float kj = 2.1474836E9f;
    @VisibleForTesting
    protected boolean kk = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(dF());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float dF() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.kh - this.composition.bh()) / (this.composition.bi() - this.composition.bh());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.kh) / (getMaxFrame() - getMinFrame());
        }
        return (this.kh - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.bg();
    }

    public float dG() {
        return this.kh;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.kk;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        dI();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float dH = ((float) (nanoTime - this.kg)) / dH();
            float f = this.kh;
            if (isReversed()) {
                dH = -dH;
            }
            this.kh = dH + f;
            boolean z = !e.c(this.kh, getMinFrame(), getMaxFrame());
            this.kh = e.clamp(this.kh, getMinFrame(), getMaxFrame());
            this.kg = nanoTime;
            dE();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.kh = getMaxFrame();
                    dJ();
                    y(isReversed());
                } else {
                    dC();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.kf = this.kf ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.kh = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.kg = nanoTime;
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
        this.ki = -2.1474836E9f;
        this.kj = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.e eVar) {
        boolean z = this.composition == null;
        this.composition = eVar;
        if (z) {
            f((int) Math.max(this.ki, eVar.bh()), (int) Math.min(this.kj, eVar.bi()));
        } else {
            f((int) eVar.bh(), (int) eVar.bi());
        }
        setFrame((int) this.kh);
        this.kg = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.kh != i) {
            this.kh = e.clamp(i, getMinFrame(), getMaxFrame());
            this.kg = System.nanoTime();
            dE();
        }
    }

    public void setMinFrame(int i) {
        f(i, (int) this.kj);
    }

    public void setMaxFrame(int i) {
        f((int) this.ki, i);
    }

    public void f(int i, int i2) {
        float bh = this.composition == null ? -3.4028235E38f : this.composition.bh();
        float bi = this.composition == null ? Float.MAX_VALUE : this.composition.bi();
        this.ki = e.clamp(i, bh, bi);
        this.kj = e.clamp(i2, bh, bi);
        setFrame((int) e.clamp(this.kh, i, i2));
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
        if (i != 2 && this.kf) {
            this.kf = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.kk = true;
        x(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.kg = System.nanoTime();
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
        this.kk = true;
        dI();
        this.kg = System.nanoTime();
        if (isReversed() && dG() == getMinFrame()) {
            this.kh = getMaxFrame();
        } else if (!isReversed() && dG() == getMaxFrame()) {
            this.kh = getMinFrame();
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
        return this.ki == -2.1474836E9f ? this.composition.bh() : this.ki;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.kj == 2.1474836E9f ? this.composition.bi() : this.kj;
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
            this.kk = false;
        }
    }

    private void dK() {
        if (this.composition != null) {
            if (this.kh < this.ki || this.kh > this.kj) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.ki), Float.valueOf(this.kj), Float.valueOf(this.kh)));
            }
        }
    }
}
