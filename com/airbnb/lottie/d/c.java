package com.airbnb.lottie.d;

import android.support.annotation.FloatRange;
import android.support.annotation.MainThread;
import android.support.annotation.Nullable;
import android.support.annotation.VisibleForTesting;
import android.view.Choreographer;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes7.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.airbnb.lottie.e composition;
    private float speed = 1.0f;
    private boolean HW = false;
    private long HX = 0;
    private float HY = 0.0f;
    private int repeatCount = 0;
    private float HZ = -2.1474836E9f;
    private float Ia = 2.1474836E9f;
    @VisibleForTesting
    protected boolean running = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(kV());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float kV() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.HY - this.composition.iw()) / (this.composition.ix() - this.composition.iw());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.HY) / (getMaxFrame() - getMinFrame());
        }
        return (this.HY - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.iv();
    }

    public float kW() {
        return this.HY;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        kY();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float kX = ((float) (nanoTime - this.HX)) / kX();
            float f = this.HY;
            if (isReversed()) {
                kX = -kX;
            }
            this.HY = kX + f;
            boolean z = !e.d(this.HY, getMinFrame(), getMaxFrame());
            this.HY = e.clamp(this.HY, getMinFrame(), getMaxFrame());
            this.HX = nanoTime;
            kU();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.HY = getMaxFrame();
                    kZ();
                    Y(isReversed());
                } else {
                    kS();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.HW = this.HW ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.HY = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.HX = nanoTime;
                }
            }
            la();
        }
    }

    private float kX() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.iy()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.HZ = -2.1474836E9f;
        this.Ia = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.e eVar) {
        boolean z = this.composition == null;
        this.composition = eVar;
        if (z) {
            l((int) Math.max(this.HZ, eVar.iw()), (int) Math.min(this.Ia, eVar.ix()));
        } else {
            l((int) eVar.iw(), (int) eVar.ix());
        }
        setFrame((int) this.HY);
        this.HX = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.HY != i) {
            this.HY = e.clamp(i, getMinFrame(), getMaxFrame());
            this.HX = System.nanoTime();
            kU();
        }
    }

    public void setMinFrame(int i) {
        l(i, (int) this.Ia);
    }

    public void setMaxFrame(int i) {
        l((int) this.HZ, i);
    }

    public void l(int i, int i2) {
        float iw = this.composition == null ? -3.4028235E38f : this.composition.iw();
        float ix = this.composition == null ? Float.MAX_VALUE : this.composition.ix();
        this.HZ = e.clamp(i, iw, ix);
        this.Ia = e.clamp(i2, iw, ix);
        setFrame((int) e.clamp(this.HY, i, i2));
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
        if (i != 2 && this.HW) {
            this.HW = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        X(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.HX = System.nanoTime();
        this.repeatCount = 0;
        kY();
    }

    @MainThread
    public void endAnimation() {
        kZ();
        Y(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        kZ();
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        kY();
        this.HX = System.nanoTime();
        if (isReversed() && kW() == getMinFrame()) {
            this.HY = getMaxFrame();
        } else if (!isReversed() && kW() == getMaxFrame()) {
            this.HY = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        kT();
        kZ();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.HZ == -2.1474836E9f ? this.composition.iw() : this.HZ;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.Ia == 2.1474836E9f ? this.composition.ix() : this.Ia;
    }

    protected void kY() {
        if (isRunning()) {
            Z(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void kZ() {
        Z(true);
    }

    @MainThread
    protected void Z(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    private void la() {
        if (this.composition != null) {
            if (this.HY < this.HZ || this.HY > this.Ia) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.HZ), Float.valueOf(this.Ia), Float.valueOf(this.HY)));
            }
        }
    }
}
