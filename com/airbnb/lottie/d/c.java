package com.airbnb.lottie.d;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes3.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.airbnb.lottie.d composition;
    private float speed = 1.0f;
    private boolean HE = false;
    private long HF = 0;
    private float HG = 0.0f;
    private int repeatCount = 0;
    private float HH = -2.1474836E9f;
    private float HI = 2.1474836E9f;
    @VisibleForTesting
    protected boolean running = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(ku());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float ku() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.HG - this.composition.hT()) / (this.composition.hU() - this.composition.hT());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.HG) / (getMaxFrame() - getMinFrame());
        }
        return (this.HG - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.hS();
    }

    public float kv() {
        return this.HG;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        kx();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float kw = ((float) (nanoTime - this.HF)) / kw();
            float f = this.HG;
            if (isReversed()) {
                kw = -kw;
            }
            this.HG = kw + f;
            boolean z = !e.d(this.HG, getMinFrame(), getMaxFrame());
            this.HG = e.clamp(this.HG, getMinFrame(), getMaxFrame());
            this.HF = nanoTime;
            kt();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.HG = getMaxFrame();
                    ky();
                    X(isReversed());
                } else {
                    kr();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.HE = this.HE ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.HG = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.HF = nanoTime;
                }
            }
            kz();
        }
    }

    private float kw() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.hV()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.HH = -2.1474836E9f;
        this.HI = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.d dVar) {
        boolean z = this.composition == null;
        this.composition = dVar;
        if (z) {
            l((int) Math.max(this.HH, dVar.hT()), (int) Math.min(this.HI, dVar.hU()));
        } else {
            l((int) dVar.hT(), (int) dVar.hU());
        }
        setFrame((int) this.HG);
        this.HF = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.HG != i) {
            this.HG = e.clamp(i, getMinFrame(), getMaxFrame());
            this.HF = System.nanoTime();
            kt();
        }
    }

    public void setMinFrame(int i) {
        l(i, (int) this.HI);
    }

    public void setMaxFrame(int i) {
        l((int) this.HH, i);
    }

    public void l(int i, int i2) {
        float hT = this.composition == null ? -3.4028235E38f : this.composition.hT();
        float hU = this.composition == null ? Float.MAX_VALUE : this.composition.hU();
        this.HH = e.clamp(i, hT, hU);
        this.HI = e.clamp(i2, hT, hU);
        setFrame((int) e.clamp(this.HG, i, i2));
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
        if (i != 2 && this.HE) {
            this.HE = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        W(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.HF = System.nanoTime();
        this.repeatCount = 0;
        kx();
    }

    @MainThread
    public void endAnimation() {
        ky();
        X(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        ky();
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        kx();
        this.HF = System.nanoTime();
        if (isReversed() && kv() == getMinFrame()) {
            this.HG = getMaxFrame();
        } else if (!isReversed() && kv() == getMaxFrame()) {
            this.HG = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        ks();
        ky();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.HH == -2.1474836E9f ? this.composition.hT() : this.HH;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.HI == 2.1474836E9f ? this.composition.hU() : this.HI;
    }

    protected void kx() {
        if (isRunning()) {
            Y(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void ky() {
        Y(true);
    }

    @MainThread
    protected void Y(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    private void kz() {
        if (this.composition != null) {
            if (this.HG < this.HH || this.HG > this.HI) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.HH), Float.valueOf(this.HI), Float.valueOf(this.HG)));
            }
        }
    }
}
