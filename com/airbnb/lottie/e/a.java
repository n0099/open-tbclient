package com.airbnb.lottie.e;

import android.graphics.PointF;
import android.view.animation.Interpolator;
import androidx.annotation.FloatRange;
import androidx.annotation.Nullable;
/* loaded from: classes4.dex */
public class a<T> {
    @Nullable
    private final com.airbnb.lottie.d BJ;
    public final float BT;
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

    public a(com.airbnb.lottie.d dVar, @Nullable T t, @Nullable T t2, @Nullable Interpolator interpolator, float f, @Nullable Float f2) {
        this.HP = Float.MIN_VALUE;
        this.HQ = Float.MIN_VALUE;
        this.HR = null;
        this.HS = null;
        this.BJ = dVar;
        this.HL = t;
        this.HM = t2;
        this.HN = interpolator;
        this.BT = f;
        this.HO = f2;
    }

    public a(T t) {
        this.HP = Float.MIN_VALUE;
        this.HQ = Float.MIN_VALUE;
        this.HR = null;
        this.HS = null;
        this.BJ = null;
        this.HL = t;
        this.HM = t;
        this.HN = null;
        this.BT = Float.MIN_VALUE;
        this.HO = Float.valueOf(Float.MAX_VALUE);
    }

    public float jX() {
        if (this.BJ == null) {
            return 0.0f;
        }
        if (this.HP == Float.MIN_VALUE) {
            this.HP = (this.BT - this.BJ.hS()) / this.BJ.hZ();
        }
        return this.HP;
    }

    public float iK() {
        if (this.BJ == null) {
            return 1.0f;
        }
        if (this.HQ == Float.MIN_VALUE) {
            if (this.HO == null) {
                this.HQ = 1.0f;
            } else {
                this.HQ = jX() + ((this.HO.floatValue() - this.BT) / this.BJ.hZ());
            }
        }
        return this.HQ;
    }

    public boolean kA() {
        return this.HN == null;
    }

    public boolean l(@FloatRange(from = 0.0d, to = 1.0d) float f) {
        return f >= jX() && f < iK();
    }

    public String toString() {
        return "Keyframe{startValue=" + this.HL + ", endValue=" + this.HM + ", startFrame=" + this.BT + ", endFrame=" + this.HO + ", interpolator=" + this.HN + '}';
    }
}
