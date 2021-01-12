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
    private boolean HC = false;
    private long HD = 0;
    private float HE = 0.0f;
    private int repeatCount = 0;
    private float HF = -2.1474836E9f;
    private float HG = 2.1474836E9f;
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
        return (this.HE - this.composition.hT()) / (this.composition.hU() - this.composition.hT());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.HE) / (getMaxFrame() - getMinFrame());
        }
        return (this.HE - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.hS();
    }

    public float kv() {
        return this.HE;
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
            float kw = ((float) (nanoTime - this.HD)) / kw();
            float f = this.HE;
            if (isReversed()) {
                kw = -kw;
            }
            this.HE = kw + f;
            boolean z = !e.d(this.HE, getMinFrame(), getMaxFrame());
            this.HE = e.clamp(this.HE, getMinFrame(), getMaxFrame());
            this.HD = nanoTime;
            kt();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.HE = getMaxFrame();
                    ky();
                    X(isReversed());
                } else {
                    kr();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.HC = this.HC ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.HE = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.HD = nanoTime;
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
        this.HF = -2.1474836E9f;
        this.HG = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.d dVar) {
        boolean z = this.composition == null;
        this.composition = dVar;
        if (z) {
            l((int) Math.max(this.HF, dVar.hT()), (int) Math.min(this.HG, dVar.hU()));
        } else {
            l((int) dVar.hT(), (int) dVar.hU());
        }
        setFrame((int) this.HE);
        this.HD = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.HE != i) {
            this.HE = e.clamp(i, getMinFrame(), getMaxFrame());
            this.HD = System.nanoTime();
            kt();
        }
    }

    public void setMinFrame(int i) {
        l(i, (int) this.HG);
    }

    public void setMaxFrame(int i) {
        l((int) this.HF, i);
    }

    public void l(int i, int i2) {
        float hT = this.composition == null ? -3.4028235E38f : this.composition.hT();
        float hU = this.composition == null ? Float.MAX_VALUE : this.composition.hU();
        this.HF = e.clamp(i, hT, hU);
        this.HG = e.clamp(i2, hT, hU);
        setFrame((int) e.clamp(this.HE, i, i2));
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
        if (i != 2 && this.HC) {
            this.HC = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        W(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.HD = System.nanoTime();
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
        this.HD = System.nanoTime();
        if (isReversed() && kv() == getMinFrame()) {
            this.HE = getMaxFrame();
        } else if (!isReversed() && kv() == getMaxFrame()) {
            this.HE = getMinFrame();
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
        return this.HF == -2.1474836E9f ? this.composition.hT() : this.HF;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.HG == 2.1474836E9f ? this.composition.hU() : this.HG;
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
            if (this.HE < this.HF || this.HE > this.HG) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.HF), Float.valueOf(this.HG), Float.valueOf(this.HE)));
            }
        }
    }
}
