package com.airbnb.lottie.d;

import android.view.Choreographer;
import androidx.annotation.FloatRange;
import androidx.annotation.MainThread;
import androidx.annotation.Nullable;
import androidx.annotation.VisibleForTesting;
import com.baidu.mapapi.map.WeightedLatLng;
/* loaded from: classes5.dex */
public class c extends a implements Choreographer.FrameCallback {
    @Nullable
    private com.airbnb.lottie.d Dh;
    private float speed = 1.0f;
    private boolean Jb = false;
    private long Jc = 0;
    private float Jd = 0.0f;
    private int repeatCount = 0;
    private float Je = -2.1474836E9f;
    private float Jf = 2.1474836E9f;
    @VisibleForTesting
    protected boolean running = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(kt());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float kt() {
        if (this.Dh == null) {
            return 0.0f;
        }
        return (this.Jd - this.Dh.hS()) / (this.Dh.hT() - this.Dh.hS());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.Dh == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.Jd) / (getMaxFrame() - getMinFrame());
        }
        return (this.Jd - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.Dh == null) {
            return 0L;
        }
        return this.Dh.hR();
    }

    public float ku() {
        return this.Jd;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.running;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        kw();
        if (this.Dh != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float kv = ((float) (nanoTime - this.Jc)) / kv();
            float f = this.Jd;
            if (isReversed()) {
                kv = -kv;
            }
            this.Jd = kv + f;
            boolean z = !e.d(this.Jd, getMinFrame(), getMaxFrame());
            this.Jd = e.clamp(this.Jd, getMinFrame(), getMaxFrame());
            this.Jc = nanoTime;
            ks();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.Jd = getMaxFrame();
                    kx();
                    X(isReversed());
                } else {
                    kq();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.Jb = this.Jb ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.Jd = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.Jc = nanoTime;
                }
            }
            ky();
        }
    }

    private float kv() {
        if (this.Dh == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.Dh.hU()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.Dh = null;
        this.Je = -2.1474836E9f;
        this.Jf = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.d dVar) {
        boolean z = this.Dh == null;
        this.Dh = dVar;
        if (z) {
            l((int) Math.max(this.Je, dVar.hS()), (int) Math.min(this.Jf, dVar.hT()));
        } else {
            l((int) dVar.hS(), (int) dVar.hT());
        }
        setFrame((int) this.Jd);
        this.Jc = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.Jd != i) {
            this.Jd = e.clamp(i, getMinFrame(), getMaxFrame());
            this.Jc = System.nanoTime();
            ks();
        }
    }

    public void setMinFrame(int i) {
        l(i, (int) this.Jf);
    }

    public void setMaxFrame(int i) {
        l((int) this.Je, i);
    }

    public void l(int i, int i2) {
        float hS = this.Dh == null ? -3.4028235E38f : this.Dh.hS();
        float hT = this.Dh == null ? Float.MAX_VALUE : this.Dh.hT();
        this.Je = e.clamp(i, hS, hT);
        this.Jf = e.clamp(i2, hS, hT);
        setFrame((int) e.clamp(this.Jd, i, i2));
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
        if (i != 2 && this.Jb) {
            this.Jb = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.running = true;
        W(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.Jc = System.nanoTime();
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
        this.Jc = System.nanoTime();
        if (isReversed() && ku() == getMinFrame()) {
            this.Jd = getMaxFrame();
        } else if (!isReversed() && ku() == getMaxFrame()) {
            this.Jd = getMinFrame();
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
        if (this.Dh == null) {
            return 0.0f;
        }
        return this.Je == -2.1474836E9f ? this.Dh.hS() : this.Je;
    }

    public float getMaxFrame() {
        if (this.Dh == null) {
            return 0.0f;
        }
        return this.Jf == 2.1474836E9f ? this.Dh.hT() : this.Jf;
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
        if (this.Dh != null) {
            if (this.Jd < this.Je || this.Jd > this.Jf) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.Je), Float.valueOf(this.Jf), Float.valueOf(this.Jd)));
            }
        }
    }
}
