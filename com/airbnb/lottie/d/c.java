package com.airbnb.lottie.d;

import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes4.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.airbnb.lottie.e composition;
    private float speed = 1.0f;
    private boolean kd = false;
    private long ke = 0;
    private float kf = 0.0f;
    private int repeatCount = 0;
    private float kg = -2.1474836E9f;
    private float kh = 2.1474836E9f;
    @VisibleForTesting
    protected boolean ki = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(dE());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float dE() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.kf - this.composition.bg()) / (this.composition.bh() - this.composition.bg());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.kf) / (getMaxFrame() - getMinFrame());
        }
        return (this.kf - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.bf();
    }

    public float dF() {
        return this.kf;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.ki;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        dH();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float dG = ((float) (nanoTime - this.ke)) / dG();
            float f = this.kf;
            if (isReversed()) {
                dG = -dG;
            }
            this.kf = dG + f;
            boolean z = !e.c(this.kf, getMinFrame(), getMaxFrame());
            this.kf = e.clamp(this.kf, getMinFrame(), getMaxFrame());
            this.ke = nanoTime;
            dD();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.kf = getMaxFrame();
                    dI();
                    y(isReversed());
                } else {
                    dB();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.kd = this.kd ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.kf = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.ke = nanoTime;
                }
            }
            dJ();
        }
    }

    private float dG() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.bi()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.kg = -2.1474836E9f;
        this.kh = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.e eVar) {
        boolean z = this.composition == null;
        this.composition = eVar;
        if (z) {
            e((int) Math.max(this.kg, eVar.bg()), (int) Math.min(this.kh, eVar.bh()));
        } else {
            e((int) eVar.bg(), (int) eVar.bh());
        }
        setFrame((int) this.kf);
        this.ke = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.kf != i) {
            this.kf = e.clamp(i, getMinFrame(), getMaxFrame());
            this.ke = System.nanoTime();
            dD();
        }
    }

    public void setMinFrame(int i) {
        e(i, (int) this.kh);
    }

    public void setMaxFrame(int i) {
        e((int) this.kg, i);
    }

    public void e(int i, int i2) {
        float bg = this.composition == null ? -3.4028235E38f : this.composition.bg();
        float bh = this.composition == null ? Float.MAX_VALUE : this.composition.bh();
        this.kg = e.clamp(i, bg, bh);
        this.kh = e.clamp(i2, bg, bh);
        setFrame((int) e.clamp(this.kf, i, i2));
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
        if (i != 2 && this.kd) {
            this.kd = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.ki = true;
        x(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.ke = System.nanoTime();
        this.repeatCount = 0;
        dH();
    }

    @MainThread
    public void endAnimation() {
        dI();
        y(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        dI();
    }

    @MainThread
    public void resumeAnimation() {
        this.ki = true;
        dH();
        this.ke = System.nanoTime();
        if (isReversed() && dF() == getMinFrame()) {
            this.kf = getMaxFrame();
        } else if (!isReversed() && dF() == getMaxFrame()) {
            this.kf = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        dC();
        dI();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.kg == -2.1474836E9f ? this.composition.bg() : this.kg;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.kh == 2.1474836E9f ? this.composition.bh() : this.kh;
    }

    protected void dH() {
        if (isRunning()) {
            z(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void dI() {
        z(true);
    }

    @MainThread
    protected void z(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.ki = false;
        }
    }

    private void dJ() {
        if (this.composition != null) {
            if (this.kf < this.kg || this.kf > this.kh) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.kg), Float.valueOf(this.kh), Float.valueOf(this.kf)));
            }
        }
    }
}
