package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes4.dex */
public class a<T> {
    @Nullable
    private final com.airbnb.lottie.e composition;
    public final float ed;
    @Nullable
    public final T kn;
    @Nullable
    public final T ko;
    @Nullable
    public final Interpolator kp;
    @Nullable
    public Float kq;
    private float kr;
    private float ks;
    public PointF kt;
    public PointF ku;

    public a(com.airbnb.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.kr = Float.MIN_VALUE;
        this.ks = Float.MIN_VALUE;
        this.kt = null;
        this.ku = null;
        this.composition = eVar;
        this.kn = t;
        this.ko = t2;
        this.kp = interpolator;
        this.ed = f;
        this.kq = f2;
    }

    public a(T t) {
        this.kr = Float.MIN_VALUE;
        this.ks = Float.MIN_VALUE;
        this.kt = null;
        this.ku = null;
        this.composition = null;
        this.kn = t;
        this.ko = t;
        this.kp = null;
        this.ed = Float.MIN_VALUE;
        this.kq = Float.valueOf(Float.MAX_VALUE);
    }

    public float di() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.kr == Float.MIN_VALUE) {
            this.kr = (this.ed - this.composition.bg()) / this.composition.bn();
        }
        return this.kr;
    }

    public float bV() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.ks == Float.MIN_VALUE) {
            if (this.kq == null) {
                this.ks = 1.0f;
            } else {
                this.ks = di() + ((this.kq.floatValue() - this.ed) / this.composition.bn());
            }
        }
        return this.ks;
    }

    public boolean dL() {
        return this.kp == null;
    }

    public boolean n(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= di() && f < bV();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.kn + ", endValue=" + this.ko + ", startFrame=" + this.ed + ", endFrame=" + this.kq + ", interpolator=" + this.kp + '}';
    }
}
