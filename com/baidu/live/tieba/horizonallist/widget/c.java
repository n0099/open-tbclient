package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes10.dex */
public class c {
    private static float bKD = 8.0f;
    private static float bKE;
    private final a bKA;
    private final a bKB;
    private final boolean bKC;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bKE = 1.0f;
        bKE = 1.0f / B(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float B(float f) {
        float exp;
        float f2 = bKD * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bKE;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bKC = z;
        this.bKA = new a(context);
        this.bKB = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bKA.setFriction(f);
        this.bKB.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bKA.mFinished && this.bKB.mFinished;
    }

    public final int getCurrX() {
        return this.bKA.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.bKA.bKH * this.bKA.bKH) + (this.bKB.bKH * this.bKB.bKH));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bKA.mStartTime;
                int i = this.bKA.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = B(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bKA.C(interpolation);
                    this.bKB.C(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bKA.mFinished && !this.bKA.update() && !this.bKA.Ua()) {
                    this.bKA.finish();
                }
                if (!this.bKB.mFinished && !this.bKB.update() && !this.bKB.Ua()) {
                    this.bKB.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bKA.p(i, i3, i5);
        this.bKB.p(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bKA.q(i, i3, i4) || this.bKB.q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bKC && !isFinished()) {
            float f = this.bKA.bKH;
            float f2 = this.bKB.bKH;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bKA.b(i, i11, i5, i6, i9);
                this.bKB.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bKA.b(i, i11, i5, i6, i9);
        this.bKB.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bKA.u(i, i2, i3);
    }

    public void abortAnimation() {
        this.bKA.finish();
        this.bKB.finish();
    }

    public boolean m(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bKA.bKF - this.bKA.mStart)) && Math.signum(f2) == Math.signum((float) (this.bKB.bKF - this.bKB.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes10.dex */
    public static class a {
        private static float bKO = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bKP = new float[101];
        private static final float[] bKQ = new float[101];
        private int bKF;
        private int bKG;
        private float bKH;
        private float bKI;
        private int bKJ;
        private int bKK;
        private int bKL;
        private float bKN;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bKM = ViewConfiguration.getScrollFriction();
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
                bKP[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bKQ[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bKP;
            bKQ[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bKM = f;
        }

        a(Context context) {
            this.bKN = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void C(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bKF - this.mStart) * f);
        }

        private static float eJ(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void o(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bKQ[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bKQ[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void p(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bKF = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bKI = 0.0f;
            this.bKG = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bKF;
            this.mFinished = true;
        }

        boolean q(int i, int i2, int i3) {
            this.mFinished = true;
            this.bKF = i;
            this.mStart = i;
            this.bKG = 0;
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
            this.bKF = i2;
            int i4 = i - i2;
            this.bKI = eJ(i4);
            this.bKG = -i4;
            this.bKL = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bKI) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bKL = i5;
            this.mFinished = false;
            this.bKG = i2;
            this.bKH = i2;
            this.bKJ = 0;
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
                int eM = eM(i2);
                this.bKJ = eM;
                this.mDuration = eM;
                d = eL(i2);
            }
            this.bKK = (int) (d * Math.signum(i2));
            this.bKF = this.bKK + i;
            if (this.bKF < i3) {
                o(this.mStart, this.bKF, i3);
                this.bKF = i3;
            }
            if (this.bKF > i4) {
                o(this.mStart, this.bKF, i4);
                this.bKF = i4;
            }
        }

        private double eK(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bKM * this.bKN));
        }

        private double eL(int i) {
            return Math.exp(eK(i) * (bKO / (bKO - 1.0d))) * this.bKM * this.bKN;
        }

        private int eM(int i) {
            return (int) (Math.exp(eK(i) / (bKO - 1.0d)) * 1000.0d);
        }

        private void s(int i, int i2, int i3) {
            float f = (-i3) / this.bKI;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bKI)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bKI));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bKG = (int) ((-this.bKI) * sqrt);
        }

        private void t(int i, int i2, int i3) {
            this.bKI = eJ(i3 == 0 ? i - i2 : i3);
            s(i, i2, i3);
            TZ();
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
            } else if (eL(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bKL);
            } else {
                r(i, i5, i4);
            }
        }

        void u(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bKL = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                k(i, i2, i2, (int) this.bKH);
            }
        }

        private void TZ() {
            float abs = (this.bKG * this.bKG) / (Math.abs(this.bKI) * 2.0f);
            float signum = Math.signum(this.bKG);
            if (abs > this.bKL) {
                this.bKI = (((-signum) * this.bKG) * this.bKG) / (this.bKL * 2.0f);
                abs = this.bKL;
            }
            this.bKL = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bKG <= 0) {
                abs = -abs;
            }
            this.bKF = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bKG) / this.bKI));
        }

        boolean Ua() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bKJ) {
                        this.mStart = this.bKF;
                        this.bKG = (int) this.bKH;
                        this.bKI = eJ(this.bKG);
                        this.mStartTime += this.mDuration;
                        TZ();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    r(this.bKF, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bKJ;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bKP[i];
                        f3 = (bKP[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bKH = ((f3 * this.bKK) / this.bKJ) * 1000.0f;
                    d = f2 * this.bKK;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bKG);
                    d = this.bKL * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bKH = ((-f6) + f7) * signum * this.bKL * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bKH = this.bKG + (this.bKI * f8);
                    d = ((f8 * (this.bKI * f8)) / 2.0f) + (this.bKG * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
