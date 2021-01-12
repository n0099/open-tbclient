package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes10.dex */
public class c {
    private static float bFt = 8.0f;
    private static float bFu;
    private final a bFq;
    private final a bFr;
    private final boolean bFs;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bFu = 1.0f;
        bFu = 1.0f / t(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float t(float f) {
        float exp;
        float f2 = bFt * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bFu;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bFs = z;
        this.bFq = new a(context);
        this.bFr = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bFq.setFriction(f);
        this.bFr.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bFq.mFinished && this.bFr.mFinished;
    }

    public final int getCurrX() {
        return this.bFq.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.bFq.bFx * this.bFq.bFx) + (this.bFr.bFx * this.bFr.bFx));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bFq.mStartTime;
                int i = this.bFq.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = t(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bFq.u(interpolation);
                    this.bFr.u(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bFq.mFinished && !this.bFq.update() && !this.bFq.Sq()) {
                    this.bFq.finish();
                }
                if (!this.bFr.mFinished && !this.bFr.update() && !this.bFr.Sq()) {
                    this.bFr.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bFq.p(i, i3, i5);
        this.bFr.p(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bFq.q(i, i3, i4) || this.bFr.q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bFs && !isFinished()) {
            float f = this.bFq.bFx;
            float f2 = this.bFr.bFx;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bFq.b(i, i11, i5, i6, i9);
                this.bFr.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bFq.b(i, i11, i5, i6, i9);
        this.bFr.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bFq.u(i, i2, i3);
    }

    public void abortAnimation() {
        this.bFq.finish();
        this.bFr.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bFq.bFv - this.bFq.mStart)) && Math.signum(f2) == Math.signum((float) (this.bFr.bFv - this.bFr.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a {
        private static float bFE = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bFF = new float[101];
        private static final float[] bFG = new float[101];
        private int bFA;
        private int bFB;
        private float bFD;
        private int bFv;
        private int bFw;
        private float bFx;
        private float bFy;
        private int bFz;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bFC = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean mFinished = true;

        static {
            float f;
            float f2;
            float f3;
            float f4;
            int i = 0;
            float f5 = 0.0f;
            float f6 = 0.0f;
            while (i < 100) {
                float f7 = i / 100.0f;
                float f8 = 1.0f;
                float f9 = f6;
                while (true) {
                    f = ((f8 - f9) / 2.0f) + f9;
                    f2 = 3.0f * f * (1.0f - f);
                    float f10 = ((((1.0f - f) * 0.175f) + (0.35000002f * f)) * f2) + (f * f * f);
                    if (Math.abs(f10 - f7) < 1.0E-5d) {
                        break;
                    } else if (f10 > f7) {
                        f8 = f;
                    } else {
                        f9 = f;
                    }
                }
                bFF[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
                float f11 = 1.0f;
                while (true) {
                    f3 = ((f11 - f5) / 2.0f) + f5;
                    f4 = 3.0f * f3 * (1.0f - f3);
                    float f12 = ((((1.0f - f3) * 0.5f) + f3) * f4) + (f3 * f3 * f3);
                    if (Math.abs(f12 - f7) < 1.0E-5d) {
                        break;
                    } else if (f12 > f7) {
                        f11 = f3;
                    } else {
                        f5 = f3;
                    }
                }
                bFG[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bFF;
            bFG[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bFC = f;
        }

        a(Context context) {
            this.bFD = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void u(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bFv - this.mStart) * f);
        }

        private static float eE(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void o(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bFG[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bFG[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void p(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bFv = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bFy = 0.0f;
            this.bFw = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bFv;
            this.mFinished = true;
        }

        boolean q(int i, int i2, int i3) {
            this.mFinished = true;
            this.bFv = i;
            this.mStart = i;
            this.bFw = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                r(i, i2, 0);
            } else if (i > i3) {
                r(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void r(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.bFv = i2;
            int i4 = i - i2;
            this.bFy = eE(i4);
            this.bFw = -i4;
            this.bFB = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bFy) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bFB = i5;
            this.mFinished = false;
            this.bFw = i2;
            this.bFx = i2;
            this.bFz = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                k(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int eH = eH(i2);
                this.bFz = eH;
                this.mDuration = eH;
                d = eG(i2);
            }
            this.bFA = (int) (d * Math.signum(i2));
            this.bFv = this.bFA + i;
            if (this.bFv < i3) {
                o(this.mStart, this.bFv, i3);
                this.bFv = i3;
            }
            if (this.bFv > i4) {
                o(this.mStart, this.bFv, i4);
                this.bFv = i4;
            }
        }

        private double eF(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bFC * this.bFD));
        }

        private double eG(int i) {
            return Math.exp(eF(i) * (bFE / (bFE - 1.0d))) * this.bFC * this.bFD;
        }

        private int eH(int i) {
            return (int) (Math.exp(eF(i) / (bFE - 1.0d)) * 1000.0d);
        }

        private void s(int i, int i2, int i3) {
            float f = (-i3) / this.bFy;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bFy)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bFy));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bFw = (int) ((-this.bFy) * sqrt);
        }

        private void t(int i, int i2, int i3) {
            this.bFy = eE(i3 == 0 ? i - i2 : i3);
            s(i, i2, i3);
            Sp();
        }

        private void k(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                t(i, i5, i4);
            } else if (eG(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bFB);
            } else {
                r(i, i5, i4);
            }
        }

        void u(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bFB = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                k(i, i2, i2, (int) this.bFx);
            }
        }

        private void Sp() {
            float abs = (this.bFw * this.bFw) / (Math.abs(this.bFy) * 2.0f);
            float signum = Math.signum(this.bFw);
            if (abs > this.bFB) {
                this.bFy = (((-signum) * this.bFw) * this.bFw) / (this.bFB * 2.0f);
                abs = this.bFB;
            }
            this.bFB = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bFw <= 0) {
                abs = -abs;
            }
            this.bFv = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bFw) / this.bFy));
        }

        boolean Sq() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bFz) {
                        this.mStart = this.bFv;
                        this.bFw = (int) this.bFx;
                        this.bFy = eE(this.bFw);
                        this.mStartTime += this.mDuration;
                        Sp();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    r(this.bFv, this.mStart, 0);
                    break;
            }
            update();
            return true;
        }

        boolean update() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            if (currentAnimationTimeMillis > this.mDuration) {
                return false;
            }
            double d = 0.0d;
            switch (this.mState) {
                case 0:
                    float f = ((float) currentAnimationTimeMillis) / this.bFz;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bFF[i];
                        f3 = (bFF[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bFx = ((f3 * this.bFA) / this.bFz) * 1000.0f;
                    d = f2 * this.bFA;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bFw);
                    d = this.bFB * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bFx = ((-f6) + f7) * signum * this.bFB * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bFx = this.bFw + (this.bFy * f8);
                    d = ((f8 * (this.bFy * f8)) / 2.0f) + (this.bFw * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
