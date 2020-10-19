package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.support.annotation.FloatRange;
import android.support.annotation.Nullable;
import android.view.animation.Interpolator;
/* loaded from: classes10.dex */
public class a<T> {
    public final float Bo;
    @Nullable
    public final T Hn;
    @Nullable
    public final T Ho;
    @Nullable
    public final Interpolator Hp;
    @Nullable
    public Float Hq;
    private float Hr;
    private float Hs;
    public PointF Ht;
    public PointF Hu;
    @Nullable
    private final com.airbnb.lottie.e composition;

    public a(com.airbnb.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.Hr = Float.MIN_VALUE;
        this.Hs = Float.MIN_VALUE;
        this.Ht = null;
        this.Hu = null;
        this.composition = eVar;
        this.Hn = t;
        this.Ho = t2;
        this.Hp = interpolator;
        this.Bo = f;
        this.Hq = f2;
    }

    public a(T t) {
        this.Hr = Float.MIN_VALUE;
        this.Hs = Float.MIN_VALUE;
        this.Ht = null;
        this.Hu = null;
        this.composition = null;
        this.Hn = t;
        this.Ho = t;
        this.Hp = null;
        this.Bo = Float.MIN_VALUE;
        this.Hq = Float.valueOf(Float.MAX_VALUE);
    }

    public float kz() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.Hr == Float.MIN_VALUE) {
            this.Hr = (this.Bo - this.composition.iw()) / this.composition.iD();
        }
        return this.Hr;
    }

    public float jm() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.Hs == Float.MIN_VALUE) {
            if (this.Hq == null) {
                this.Hs = 1.0f;
            } else {
                this.Hs = kz() + ((this.Hq.floatValue() - this.Bo) / this.composition.iD());
            }
        }
        return this.Hs;
    }

    public boolean lc() {
        return this.Hp == null;
    }

    public boolean m(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= kz() && f < jm();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.Hn + ", endValue=" + this.Ho + ", startFrame=" + this.Bo + ", endFrame=" + this.Hq + ", interpolator=" + this.Hp + '}';
    }
}
