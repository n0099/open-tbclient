package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes3.dex */
public class a<T> {
    public final float BS;
    @Nullable
    public final T HL;
    @Nullable
    public final T HM;
    @Nullable
    public final Interpolator HN;
    @Nullable
    public Float HO;
    private float HP;
    private float HQ;
    public PointF HR;
    public PointF HS;
    @Nullable
    private final com.airbnb.lottie.d composition;

    public a(com.airbnb.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.HP = Float.MIN_VALUE;
        this.HQ = Float.MIN_VALUE;
        this.HR = null;
        this.HS = null;
        this.composition = dVar;
        this.HL = t;
        this.HM = t2;
        this.HN = interpolator;
        this.BS = f;
        this.HO = f2;
    }

    public a(T t) {
        this.HP = Float.MIN_VALUE;
        this.HQ = Float.MIN_VALUE;
        this.HR = null;
        this.HS = null;
        this.composition = null;
        this.HL = t;
        this.HM = t;
        this.HN = null;
        this.BS = Float.MIN_VALUE;
        this.HO = Float.valueOf(Float.MAX_VALUE);
    }

    public float jY() {
        if (this.composition == null) {
            return 0.0f;
        }
        if (this.HP == Float.MIN_VALUE) {
            this.HP = (this.BS - this.composition.hT()) / this.composition.ia();
        }
        return this.HP;
    }

    public float iL() {
        if (this.composition == null) {
            return 1.0f;
        }
        if (this.HQ == Float.MIN_VALUE) {
            if (this.HO == null) {
                this.HQ = 1.0f;
            } else {
                this.HQ = jY() + ((this.HO.floatValue() - this.BS) / this.composition.ia());
            }
        }
        return this.HQ;
    }

    public boolean kB() {
        return this.HN == null;
    }

    public boolean l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= jY() && f < iL();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.HL + ", endValue=" + this.HM + ", startFrame=" + this.BS + ", endFrame=" + this.HO + ", interpolator=" + this.HN + '}';
    }
}
