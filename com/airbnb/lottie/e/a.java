package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable
    private final com.airbnb.lottie.e composition;
    public final float ed;
    @Nullable
    public final T kq;
    @Nullable
    public final T kr;
    @Nullable
    public final Interpolator ks;
    @Nullable
    public Float kt;
    private float ku;
    private float kv;
    public PointF kx;
    public PointF ky;

    public a(com.airbnb.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.ku = Float.MIN_VALUE;
        this.kv = Float.MIN_VALUE;
        this.kx = null;
        this.ky = null;
        this.composition = eVar;
        this.kq = t;
        this.kr = t2;
        this.ks = interpolator;
        this.ed = f;
        this.kt = f2;
    }

    public a(T t) {
        this.ku = Float.MIN_VALUE;
        this.kv = Float.MIN_VALUE;
        this.kx = null;
        this.ky = null;
        this.composition = null;
        this.kq = t;
        this.kr = t;
        this.ks = null;
        this.ed = Float.MIN_VALUE;
        this.kt = Float.valueOf(Float.MAX_VALUE);
    }

    public float dj() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.ku == Float.MIN_VALUE) {
            this.ku = (this.ed - this.composition.bh()) / this.composition.bo();
        }
        return this.ku;
    }

    public float bW() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.kv == Float.MIN_VALUE) {
            if (this.kt == null) {
                this.kv = 1.0f;
            } else {
                this.kv = dj() + ((this.kt.floatValue() - this.ed) / this.composition.bo());
            }
        }
        return this.kv;
    }

    public boolean dM() {
        return this.ks == null;
    }

    public boolean n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= dj() && f < bW();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.kq + ", endValue=" + this.kr + ", startFrame=" + this.ed + ", endFrame=" + this.kt + ", interpolator=" + this.ks + '}';
    }
}
