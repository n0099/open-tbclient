package com.baidu.live.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes10.dex */
public class a<T> {
    public final float BU;
    @Nullable
    public final T HN;
    @Nullable
    public final T HO;
    @Nullable
    public final Interpolator HP;
    @Nullable
    public Float HQ;
    private float HR;
    private float HS;
    public PointF HU;
    public PointF HV;
    @Nullable
    private final com.baidu.live.lottie.e composition;

    public a(com.baidu.live.lottie.e eVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.HR = Float.MIN_VALUE;
        this.HS = Float.MIN_VALUE;
        this.HU = null;
        this.HV = null;
        this.composition = eVar;
        this.HN = t;
        this.HO = t2;
        this.HP = interpolator;
        this.BU = f;
        this.HQ = f2;
    }

    public a(T t) {
        this.HR = Float.MIN_VALUE;
        this.HS = Float.MIN_VALUE;
        this.HU = null;
        this.HV = null;
        this.composition = null;
        this.HN = t;
        this.HO = t;
        this.HP = null;
        this.BU = Float.MIN_VALUE;
        this.HQ = Float.valueOf(Float.MAX_VALUE);
    }

    public float jY() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.HR == Float.MIN_VALUE) {
            this.HR = (this.BU - this.composition.hT()) / this.composition.ia();
        }
        return this.HR;
    }

    public float iL() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.HS == Float.MIN_VALUE) {
            if (this.HQ == null) {
                this.HS = 1.0f;
            } else {
                this.HS = jY() + ((this.HQ.floatValue() - this.BU) / this.composition.ia());
            }
        }
        return this.HS;
    }

    public boolean kB() {
        return this.HP == null;
    }

    public boolean l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= jY() && f < iL();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.HN + ", endValue=" + this.HO + ", startFrame=" + this.BU + ", endFrame=" + this.HQ + ", interpolator=" + this.HP + '}';
    }
}
