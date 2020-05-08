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
    private boolean FE = false;
    private long FF = 0;
    private float FG = 0.0f;
    private int repeatCount = 0;
    private float FH = -2.1474836E9f;
    private float FI = 2.1474836E9f;
    @VisibleForTesting
    protected boolean FJ = false;

    @Override // android.animation.ValueAnimator
    public Object getAnimatedValue() {
        return Float.valueOf(je());
    }

    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float je() {
        if (this.composition == null) {
            return 0.0f;
        }
        return (this.FG - this.composition.gE()) / (this.composition.gF() - this.composition.gE());
    }

    @Override // android.animation.ValueAnimator
    @FloatRange(from = 0.0d, to = WeightedLatLng.DEFAULT_INTENSITY)
    public float getAnimatedFraction() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (isReversed()) {
            return (getMaxFrame() - this.FG) / (getMaxFrame() - getMinFrame());
        }
        return (this.FG - getMinFrame()) / (getMaxFrame() - getMinFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public long getDuration() {
        if (this.composition == null) {
            return 0L;
        }
        return this.composition.gD();
    }

    public float jf() {
        return this.FG;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public boolean isRunning() {
        return this.FJ;
    }

    @Override // android.view.Choreographer.FrameCallback
    public void doFrame(long j) {
        jh();
        if (this.composition != null && isRunning()) {
            long nanoTime = System.nanoTime();
            float jg = ((float) (nanoTime - this.FF)) / jg();
            float f = this.FG;
            if (isReversed()) {
                jg = -jg;
            }
            this.FG = jg + f;
            boolean z = !e.d(this.FG, getMinFrame(), getMaxFrame());
            this.FG = e.clamp(this.FG, getMinFrame(), getMaxFrame());
            this.FF = nanoTime;
            jd();
            if (z) {
                if (getRepeatCount() != -1 && this.repeatCount >= getRepeatCount()) {
                    this.FG = getMaxFrame();
                    ji();
                    Z(isReversed());
                } else {
                    jb();
                    this.repeatCount++;
                    if (getRepeatMode() == 2) {
                        this.FE = this.FE ? false : true;
                        reverseAnimationSpeed();
                    } else {
                        this.FG = isReversed() ? getMaxFrame() : getMinFrame();
                    }
                    this.FF = nanoTime;
                }
            }
            jj();
        }
    }

    private float jg() {
        if (this.composition == null) {
            return Float.MAX_VALUE;
        }
        return (1.0E9f / this.composition.gG()) / Math.abs(this.speed);
    }

    public void clearComposition() {
        this.composition = null;
        this.FH = -2.1474836E9f;
        this.FI = 2.1474836E9f;
    }

    public void setComposition(com.airbnb.lottie.e eVar) {
        boolean z = this.composition == null;
        this.composition = eVar;
        if (z) {
            h((int) Math.max(this.FH, eVar.gE()), (int) Math.min(this.FI, eVar.gF()));
        } else {
            h((int) eVar.gE(), (int) eVar.gF());
        }
        setFrame((int) this.FG);
        this.FF = System.nanoTime();
    }

    public void setFrame(int i) {
        if (this.FG != i) {
            this.FG = e.clamp(i, getMinFrame(), getMaxFrame());
            this.FF = System.nanoTime();
            jd();
        }
    }

    public void setMinFrame(int i) {
        h(i, (int) this.FI);
    }

    public void setMaxFrame(int i) {
        h((int) this.FH, i);
    }

    public void h(int i, int i2) {
        float gE = this.composition == null ? -3.4028235E38f : this.composition.gE();
        float gF = this.composition == null ? Float.MAX_VALUE : this.composition.gF();
        this.FH = e.clamp(i, gE, gF);
        this.FI = e.clamp(i2, gE, gF);
        setFrame((int) e.clamp(this.FG, i, i2));
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
        if (i != 2 && this.FE) {
            this.FE = false;
            reverseAnimationSpeed();
        }
    }

    @MainThread
    public void playAnimation() {
        this.FJ = true;
        Y(isReversed());
        setFrame((int) (isReversed() ? getMaxFrame() : getMinFrame()));
        this.FF = System.nanoTime();
        this.repeatCount = 0;
        jh();
    }

    @MainThread
    public void endAnimation() {
        ji();
        Z(isReversed());
    }

    @MainThread
    public void pauseAnimation() {
        ji();
    }

    @MainThread
    public void resumeAnimation() {
        this.FJ = true;
        jh();
        this.FF = System.nanoTime();
        if (isReversed() && jf() == getMinFrame()) {
            this.FG = getMaxFrame();
        } else if (!isReversed() && jf() == getMaxFrame()) {
            this.FG = getMinFrame();
        }
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    @MainThread
    public void cancel() {
        jc();
        ji();
    }

    private boolean isReversed() {
        return getSpeed() < 0.0f;
    }

    public float getMinFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.FH == -2.1474836E9f ? this.composition.gE() : this.FH;
    }

    public float getMaxFrame() {
        if (this.composition == null) {
            return 0.0f;
        }
        return this.FI == 2.1474836E9f ? this.composition.gF() : this.FI;
    }

    protected void jh() {
        if (isRunning()) {
            aa(false);
            Choreographer.getInstance().postFrameCallback(this);
        }
    }

    @MainThread
    protected void ji() {
        aa(true);
    }

    @MainThread
    protected void aa(boolean z) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (z) {
            this.FJ = false;
        }
    }

    private void jj() {
        if (this.composition != null) {
            if (this.FG < this.FH || this.FG > this.FI) {
                throw new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", Float.valueOf(this.FH), Float.valueOf(this.FI), Float.valueOf(this.FG)));
            }
        }
    }
}
