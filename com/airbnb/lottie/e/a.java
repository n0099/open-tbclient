package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes6.dex */
public class a<T> {
    public final float Ao;
    @Nullable
    public final T Gp;
    @Nullable
    public final T Gq;
    @Nullable
    public final Interpolator Gr;
    @Nullable
    public Float Gs;
    private float Gt;
    private float Gu;
    public PointF Gv;
    public PointF Gw;
    @Nullable
    private final com.airbnb.lottie.e composition;

    public a(com.airbnb.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.Gt = Float.MIN_VALUE;
        this.Gu = Float.MIN_VALUE;
        this.Gv = null;
        this.Gw = null;
        this.composition = eVar;
        this.Gp = t;
        this.Gq = t2;
        this.Gr = interpolator;
        this.Ao = f;
        this.Gs = f2;
    }

    public a(T t) {
        this.Gt = Float.MIN_VALUE;
        this.Gu = Float.MIN_VALUE;
        this.Gv = null;
        this.Gw = null;
        this.composition = null;
        this.Gp = t;
        this.Gq = t;
        this.Gr = null;
        this.Ao = Float.MIN_VALUE;
        this.Gs = Float.valueOf(Float.MAX_VALUE);
    }

    public float iY() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.Gt == Float.MIN_VALUE) {
            this.Gt = (this.Ao - this.composition.gU()) / this.composition.hb();
        }
        return this.Gt;
    }

    public float hJ() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.Gu == Float.MIN_VALUE) {
            if (this.Gs == null) {
                this.Gu = 1.0f;
            } else {
                this.Gu = iY() + ((this.Gs.floatValue() - this.Ao) / this.composition.hb());
            }
        }
        return this.Gu;
    }

    public boolean jB() {
        return this.Gr == null;
    }

    public boolean m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= iY() && f < hJ();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.Gp + ", endValue=" + this.Gq + ", startFrame=" + this.Ao + ", endFrame=" + this.Gs + ", interpolator=" + this.Gr + '}';
    }
}
