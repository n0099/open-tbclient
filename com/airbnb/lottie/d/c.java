package com.airbnb.lottie.d;

import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes5.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.airbnb.lottie.e composition;
    private float speed = 1.0f;
    private boolean kc = false;
    private long kd = 0;
    private float ke = 0.0f;
    private int repeatCount = 0;
    private float kf = -2.1474836E9f;
    private float kg = 2.1474836E9f;
    @VisibleForTesting
    protected boolean kh = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(dE());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float dE() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.ke - this.composition.bg()) / (this.composition.bh() - this.composition.bg());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.ke) / (getMaxFrame() - getMinFrame());
        }
        return (this.ke - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.bf();
    }

    public float dF() {
        return this.ke;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.kh;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        dH();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float dG = ((float) (nanoTime - this.kd)) / dG();
            float f = this.ke;
            if (isReversed()) {
                dG = -dG;
            }
            this.ke = dG + f;
            boolean z = !e.c(this.ke, getMinFrame(), getMaxFrame());
            this.ke = e.clamp(this.ke, getMinFrame(), getMaxFrame());
            this.kd = nanoTime;
            dD();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.ke = getMaxFrame();
                    dI();
                    y(isReversed());
                } else {
                    dB();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.kc = this.kc ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.ke = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.kd = nanoTime;
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
        this.kf = -2.1474836E9f;
        this.kg = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.e eVar) {
        boolean z = this.composition == null;
        this.composition = eVar;
        if (z) {
            e((int) Math.max(this.kf, eVar.bg()), (int) Math.min(this.kg, eVar.bh()));
        } else {
            e((int) eVar.bg(), (int) eVar.bh());
        }
        setFrame((int) this.ke);
        this.kd = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.ke != i) {
            this.ke = e.clamp(i, getMinFrame(), getMaxFrame());
            this.kd = System.nanoTime();
            dD();
        }
    }

    public void setMinFrame(int i) {
        e(i, (int) this.kg);
    }

    public void setMaxFrame(int i) {
        e((int) this.kf, i);
    }

    public void e(int i, int i2) {
        float bg = this.composition == null ? -3.4028235E38f : this.composition.bg();
        float bh = this.composition == null ? Float.MAX_VALUE : this.composition.bh();
        this.kf = e.clamp(i, bg, bh);
        this.kg = e.clamp(i2, bg, bh);
        setFrame((int) e.clamp(this.ke, i, i2));
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
        if (i != 2 && this.kc) {
            this.kc = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.kh = true;
        x(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.kd = System.nanoTime();
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
        this.kh = true;
        dH();
        this.kd = System.nanoTime();
        if (isReversed() && dF() == getMinFrame()) {
            this.ke = getMaxFrame();
        } else if (!isReversed() && dF() == getMaxFrame()) {
            this.ke = getMinFrame();
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
        return this.kf == -2.1474836E9f ? this.composition.bg() : this.kf;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.kg == 2.1474836E9f ? this.composition.bh() : this.kg;
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
            this.kh = false;
        }
    }

    private void dJ() {
        if (this.composition != null) {
            if (this.ke < this.kf || this.ke > this.kg) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.kf), Float.valueOf(this.kg), Float.valueOf(this.ke)));
            }
        }
    }
}
