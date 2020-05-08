package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable
    public final T FO;
    @Nullable
    public final T FP;
    @Nullable
    public final Interpolator FQ;
    @Nullable
    public Float FR;
    private float FT;
    private float FU;
    public PointF FV;
    public PointF FW;
    @Nullable
    private final com.airbnb.lottie.e composition;
    public final float zN;

    public a(com.airbnb.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.FT = Float.MIN_VALUE;
        this.FU = Float.MIN_VALUE;
        this.FV = null;
        this.FW = null;
        this.composition = eVar;
        this.FO = t;
        this.FP = t2;
        this.FQ = interpolator;
        this.zN = f;
        this.FR = f2;
    }

    public a(T t) {
        this.FT = Float.MIN_VALUE;
        this.FU = Float.MIN_VALUE;
        this.FV = null;
        this.FW = null;
        this.composition = null;
        this.FO = t;
        this.FP = t;
        this.FQ = null;
        this.zN = Float.MIN_VALUE;
        this.FR = Float.valueOf(Float.MAX_VALUE);
    }

    public float iI() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.FT == Float.MIN_VALUE) {
            this.FT = (this.zN - this.composition.gE()) / this.composition.gL();
        }
        return this.FT;
    }

    public float ht() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.FU == Float.MIN_VALUE) {
            if (this.FR == null) {
                this.FU = 1.0f;
            } else {
                this.FU = iI() + ((this.FR.floatValue() - this.zN) / this.composition.gL());
            }
        }
        return this.FU;
    }

    public boolean jl() {
        return this.FQ == null;
    }

    public boolean k(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= iI() && f < ht();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.FO + ", endValue=" + this.FP + ", startFrame=" + this.zN + ", endFrame=" + this.FR + ", interpolator=" + this.FQ + '}';
    }
}
