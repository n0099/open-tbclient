package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable
    public final T FL;
    @Nullable
    public final T FM;
    @Nullable
    public final Interpolator FN;
    @Nullable
    public Float FO;
    private float FP;
    private float FQ;
    public PointF FR;
    public PointF FT;
    @Nullable
    private final com.airbnb.lottie.e composition;
    public final float zN;

    public a(com.airbnb.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.FP = Float.MIN_VALUE;
        this.FQ = Float.MIN_VALUE;
        this.FR = null;
        this.FT = null;
        this.composition = eVar;
        this.FL = t;
        this.FM = t2;
        this.FN = interpolator;
        this.zN = f;
        this.FO = f2;
    }

    public a(T t) {
        this.FP = Float.MIN_VALUE;
        this.FQ = Float.MIN_VALUE;
        this.FR = null;
        this.FT = null;
        this.composition = null;
        this.FL = t;
        this.FM = t;
        this.FN = null;
        this.zN = Float.MIN_VALUE;
        this.FO = Float.valueOf(Float.MAX_VALUE);
    }

    public float iI() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.FP == Float.MIN_VALUE) {
            this.FP = (this.zN - this.composition.gE()) / this.composition.gL();
        }
        return this.FP;
    }

    public float ht() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.FQ == Float.MIN_VALUE) {
            if (this.FO == null) {
                this.FQ = 1.0f;
            } else {
                this.FQ = iI() + ((this.FO.floatValue() - this.zN) / this.composition.gL());
            }
        }
        return this.FQ;
    }

    public boolean jl() {
        return this.FN == null;
    }

    public boolean k(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= iI() && f < ht();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.FL + ", endValue=" + this.FM + ", startFrame=" + this.zN + ", endFrame=" + this.FO + ", interpolator=" + this.FN + '}';
    }
}
