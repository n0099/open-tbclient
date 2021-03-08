package com.baidu.live.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes9.dex */
public class a<T> {
    public final float Dr;
    @Nullable
    public final T Jk;
    @Nullable
    public final T Jl;
    @Nullable
    public final Interpolator Jm;
    @Nullable
    public Float Jn;
    private float Jo;
    private float Jp;
    public PointF Jq;
    public PointF Jr;
    @Nullable
    private final com.baidu.live.lottie.e composition;

    public a(com.baidu.live.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.Jo = Float.MIN_VALUE;
        this.Jp = Float.MIN_VALUE;
        this.Jq = null;
        this.Jr = null;
        this.composition = eVar;
        this.Jk = t;
        this.Jl = t2;
        this.Jm = interpolator;
        this.Dr = f;
        this.Jn = f2;
    }

    public a(T t) {
        this.Jo = Float.MIN_VALUE;
        this.Jp = Float.MIN_VALUE;
        this.Jq = null;
        this.Jr = null;
        this.composition = null;
        this.Jk = t;
        this.Jl = t;
        this.Jm = null;
        this.Dr = Float.MIN_VALUE;
        this.Jn = Float.valueOf(Float.MAX_VALUE);
    }

    public float jX() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.Jo == Float.MIN_VALUE) {
            this.Jo = (this.Dr - this.composition.hS()) / this.composition.hZ();
        }
        return this.Jo;
    }

    public float iK() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.Jp == Float.MIN_VALUE) {
            if (this.Jn == null) {
                this.Jp = 1.0f;
            } else {
                this.Jp = jX() + ((this.Jn.floatValue() - this.Dr) / this.composition.hZ());
            }
        }
        return this.Jp;
    }

    public boolean kA() {
        return this.Jm == null;
    }

    public boolean p(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= jX() && f < iK();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.Jk + ", endValue=" + this.Jl + ", startFrame=" + this.Dr + ", endFrame=" + this.Jn + ", interpolator=" + this.Jm + '}';
    }
}
