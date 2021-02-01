package com.airbnb.lottie.d;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes4.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.airbnb.lottie.d BJ;
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
        return Float.valueOf(kt());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float kt() {
        if (this.BJ == null) {
            return 0.0f;
        }
        return (this.HE - this.BJ.hS()) / (this.BJ.hT() - this.BJ.hS());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.BJ == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.HE) / (getMaxFrame() - getMinFrame());
        }
        return (this.HE - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.BJ == null) {
            return 0L;
        }
        return this.BJ.hR();
    }

    public float ku() {
        return this.HE;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        kw();
        if (this.BJ != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float kv = ((float) (nanoTime - this.HD)) / kv();
            float f = this.HE;
            if (isReversed()) {
                kv = -kv;
            }
            this.HE = kv + f;
            boolean z = !e.d(this.HE, getMinFrame(), getMaxFrame());
            this.HE = e.clamp(this.HE, getMinFrame(), getMaxFrame());
            this.HD = nanoTime;
            ks();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.HE = getMaxFrame();
                    kx();
                    X(isReversed());
                } else {
                    kq();
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
            ky();
        }
    }

    private float kv() {
        if (this.BJ == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.BJ.hU()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.BJ = null;
        this.HF = -2.1474836E9f;
        this.HG = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.d dVar) {
        boolean z = this.BJ == null;
        this.BJ = dVar;
        if (z) {
            l((int) Math.max(this.HF, dVar.hS()), (int) Math.min(this.HG, dVar.hT()));
        } else {
            l((int) dVar.hS(), (int) dVar.hT());
        }
        setFrame((int) this.HE);
        this.HD = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.HE != i) {
            this.HE = e.clamp(i, getMinFrame(), getMaxFrame());
            this.HD = System.nanoTime();
            ks();
        }
    }

    public void setMinFrame(int i) {
        l(i, (int) this.HG);
    }

    public void setMaxFrame(int i) {
        l((int) this.HF, i);
    }

    public void l(int i, int i2) {
        float hS = this.BJ == null ? -3.4028235E38f : this.BJ.hS();
        float hT = this.BJ == null ? Float.MAX_VALUE : this.BJ.hT();
        this.HF = e.clamp(i, hS, hT);
        this.HG = e.clamp(i2, hS, hT);
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
        kw();
    }

    @MainThread
    public void endAnimation() {
        kx();
        X(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        kx();
    }

    @MainThread
    public void resumeAnimation() {
        this.running = true;
        kw();
        this.HD = System.nanoTime();
        if (isReversed() && ku() == getMinFrame()) {
            this.HE = getMaxFrame();
        } else if (!isReversed() && ku() == getMaxFrame()) {
            this.HE = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        kr();
        kx();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.BJ == null) {
            return 0.0f;
        }
        return this.HF == -2.1474836E9f ? this.BJ.hS() : this.HF;
    }

    public float getMaxFrame() {
        if (this.BJ == null) {
            return 0.0f;
        }
        return this.HG == 2.1474836E9f ? this.BJ.hT() : this.HG;
    }

    protected void kw() {
        if (isRunning()) {
            Y(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void kx() {
        Y(true);
    }

    @MainThread
    protected void Y(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.running = false;
        }
    }

    private void ky() {
        if (this.BJ != null) {
            if (this.HE < this.HF || this.HE > this.HG) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.HF), Float.valueOf(this.HG), Float.valueOf(this.HE)));
            }
        }
    }
}
