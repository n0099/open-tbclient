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
    private boolean GL = false;
    private long GM = 0;
    private float GN = 0.0f;
    private int repeatCount = 0;
    private float GO = -2.1474836E9f;
    private float GP = 2.1474836E9f;
    @VisibleForTesting
    protected boolean GQ = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(kU());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float kU() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.GN - this.composition.iv()) / (this.composition.iw() - this.composition.iv());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.GN) / (getMaxFrame() - getMinFrame());
        }
        return (this.GN - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.iu();
    }

    public float kV() {
        return this.GN;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.GQ;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        kX();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float kW = ((float) (nanoTime - this.GM)) / kW();
            float f = this.GN;
            if (isReversed()) {
                kW = -kW;
            }
            this.GN = kW + f;
            boolean z = !e.d(this.GN, getMinFrame(), getMaxFrame());
            this.GN = e.clamp(this.GN, getMinFrame(), getMaxFrame());
            this.GM = nanoTime;
            kT();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.GN = getMaxFrame();
                    kY();
                    aa(isReversed());
                } else {
                    kR();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.GL = this.GL ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.GN = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.GM = nanoTime;
                }
            }
            kZ();
        }
    }

    private float kW() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.ix()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.GO = -2.1474836E9f;
        this.GP = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.e eVar) {
        boolean z = this.composition == null;
        this.composition = eVar;
        if (z) {
            k((int) Math.max(this.GO, eVar.iv()), (int) Math.min(this.GP, eVar.iw()));
        } else {
            k((int) eVar.iv(), (int) eVar.iw());
        }
        setFrame((int) this.GN);
        this.GM = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.GN != i) {
            this.GN = e.clamp(i, getMinFrame(), getMaxFrame());
            this.GM = System.nanoTime();
            kT();
        }
    }

    public void setMinFrame(int i) {
        k(i, (int) this.GP);
    }

    public void setMaxFrame(int i) {
        k((int) this.GO, i);
    }

    public void k(int i, int i2) {
        float iv = this.composition == null ? -3.4028235E38f : this.composition.iv();
        float iw = this.composition == null ? Float.MAX_VALUE : this.composition.iw();
        this.GO = e.clamp(i, iv, iw);
        this.GP = e.clamp(i2, iv, iw);
        setFrame((int) e.clamp(this.GN, i, i2));
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
        if (i != 2 && this.GL) {
            this.GL = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.GQ = true;
        Z(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.GM = System.nanoTime();
        this.repeatCount = 0;
        kX();
    }

    @MainThread
    public void endAnimation() {
        kY();
        aa(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        kY();
    }

    @MainThread
    public void resumeAnimation() {
        this.GQ = true;
        kX();
        this.GM = System.nanoTime();
        if (isReversed() && kV() == getMinFrame()) {
            this.GN = getMaxFrame();
        } else if (!isReversed() && kV() == getMaxFrame()) {
            this.GN = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        kS();
        kY();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.GO == -2.1474836E9f ? this.composition.iv() : this.GO;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.GP == 2.1474836E9f ? this.composition.iw() : this.GP;
    }

    protected void kX() {
        if (isRunning()) {
            ab(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void kY() {
        ab(true);
    }

    @MainThread
    protected void ab(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.GQ = false;
        }
    }

    private void kZ() {
        if (this.composition != null) {
            if (this.GN < this.GO || this.GN > this.GP) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.GO), Float.valueOf(this.GP), Float.valueOf(this.GN)));
            }
        }
    }
}
