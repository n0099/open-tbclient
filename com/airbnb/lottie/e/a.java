package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes6.dex */
public class a<T> {
    @Nullable
    private final com.airbnb.lottie.e composition;
    public final float ec;
    @Nullable
    public final T kp;
    @Nullable
    public final T kq;
    @Nullable
    public final Interpolator kr;
    @Nullable
    public Float ks;
    private float kt;
    private float ku;
    public PointF kv;
    public PointF kx;

    public a(com.airbnb.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.kt = Float.MIN_VALUE;
        this.ku = Float.MIN_VALUE;
        this.kv = null;
        this.kx = null;
        this.composition = eVar;
        this.kp = t;
        this.kq = t2;
        this.kr = interpolator;
        this.ec = f;
        this.ks = f2;
    }

    public a(T t) {
        this.kt = Float.MIN_VALUE;
        this.ku = Float.MIN_VALUE;
        this.kv = null;
        this.kx = null;
        this.composition = null;
        this.kp = t;
        this.kq = t;
        this.kr = null;
        this.ec = Float.MIN_VALUE;
        this.ks = Float.valueOf(Float.MAX_VALUE);
    }

    public float dj() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.kt == Float.MIN_VALUE) {
            this.kt = (this.ec - this.composition.bh()) / this.composition.bo();
        }
        return this.kt;
    }

    public float bW() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.ku == Float.MIN_VALUE) {
            if (this.ks == null) {
                this.ku = 1.0f;
            } else {
                this.ku = dj() + ((this.ks.floatValue() - this.ec) / this.composition.bo());
            }
        }
        return this.ku;
    }

    public boolean dM() {
        return this.kr == null;
    }

    public boolean n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= dj() && f < bW();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.kp + ", endValue=" + this.kq + ", startFrame=" + this.ec + ", endFrame=" + this.ks + ", interpolator=" + this.kr + '}';
    }
}
