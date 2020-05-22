package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes3.dex */
public class c {
    private static float bbH = 8.0f;
    private static float bbI;
    private final a bbE;
    private final a bbF;
    private final boolean bbG;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bbI = 1.0f;
        bbI = 1.0f / q(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float q(float f) {
        float exp;
        float f2 = bbH * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bbI;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bbG = z;
        this.bbE = new a(context);
        this.bbF = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bbE.setFriction(f);
        this.bbF.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bbE.mFinished && this.bbF.mFinished;
    }

    public final int getCurrX() {
        return this.bbE.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.bbE.bbL * this.bbE.bbL) + (this.bbF.bbL * this.bbF.bbL));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bbE.mStartTime;
                int i = this.bbE.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = q(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bbE.r(interpolation);
                    this.bbF.r(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bbE.mFinished && !this.bbE.update() && !this.bbE.GR()) {
                    this.bbE.finish();
                }
                if (!this.bbF.mFinished && !this.bbF.update() && !this.bbF.GR()) {
                    this.bbF.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bbE.o(i, i3, i5);
        this.bbF.o(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bbE.p(i, i3, i4) || this.bbF.p(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bbG && !isFinished()) {
            float f = this.bbE.bbL;
            float f2 = this.bbF.bbL;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bbE.b(i, i11, i5, i6, i9);
                this.bbF.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bbE.b(i, i11, i5, i6, i9);
        this.bbF.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bbE.t(i, i2, i3);
    }

    public void abortAnimation() {
        this.bbE.finish();
        this.bbF.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bbE.bbJ - this.bbE.mStart)) && Math.signum(f2) == Math.signum((float) (this.bbF.bbJ - this.bbF.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        private static float bbS = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bbT = new float[101];
        private static final float[] bbU = new float[101];
        private int bbJ;
        private int bbK;
        private float bbL;
        private float bbM;
        private int bbN;
        private int bbO;
        private int bbP;
        private float bbR;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bbQ = ViewConfiguration.getScrollFriction();
        private int mState = 0;
        private boolean mFinished = true;

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5 = 0.0f;
            int i = 0;
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
                bbT[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bbU[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bbT;
            bbU[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bbQ = f;
        }

        a(Context context) {
            this.bbR = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void r(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bbJ - this.mStart) * f);
        }

        private static float db(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void n(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bbU[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bbU[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void o(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bbJ = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bbM = 0.0f;
            this.bbK = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bbJ;
            this.mFinished = true;
        }

        boolean p(int i, int i2, int i3) {
            this.mFinished = true;
            this.bbJ = i;
            this.mStart = i;
            this.bbK = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                q(i, i2, 0);
            } else if (i > i3) {
                q(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void q(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.bbJ = i2;
            int i4 = i - i2;
            this.bbM = db(i4);
            this.bbK = -i4;
            this.bbP = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bbM) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bbP = i5;
            this.mFinished = false;
            this.bbK = i2;
            this.bbL = i2;
            this.bbN = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                h(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int de2 = de(i2);
                this.bbN = de2;
                this.mDuration = de2;
                d = dd(i2);
            }
            this.bbO = (int) (d * Math.signum(i2));
            this.bbJ = this.bbO + i;
            if (this.bbJ < i3) {
                n(this.mStart, this.bbJ, i3);
                this.bbJ = i3;
            }
            if (this.bbJ > i4) {
                n(this.mStart, this.bbJ, i4);
                this.bbJ = i4;
            }
        }

        private double dc(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bbQ * this.bbR));
        }

        private double dd(int i) {
            return Math.exp(dc(i) * (bbS / (bbS - 1.0d))) * this.bbQ * this.bbR;
        }

        private int de(int i) {
            return (int) (Math.exp(dc(i) / (bbS - 1.0d)) * 1000.0d);
        }

        private void r(int i, int i2, int i3) {
            float f = (-i3) / this.bbM;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bbM)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bbM));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bbK = (int) ((-this.bbM) * sqrt);
        }

        private void s(int i, int i2, int i3) {
            this.bbM = db(i3 == 0 ? i - i2 : i3);
            r(i, i2, i3);
            GQ();
        }

        private void h(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                s(i, i5, i4);
            } else if (dd(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bbP);
            } else {
                q(i, i5, i4);
            }
        }

        void t(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bbP = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.bbL);
            }
        }

        private void GQ() {
            float abs = (this.bbK * this.bbK) / (Math.abs(this.bbM) * 2.0f);
            float signum = Math.signum(this.bbK);
            if (abs > this.bbP) {
                this.bbM = (((-signum) * this.bbK) * this.bbK) / (this.bbP * 2.0f);
                abs = this.bbP;
            }
            this.bbP = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bbK <= 0) {
                abs = -abs;
            }
            this.bbJ = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bbK) / this.bbM));
        }

        boolean GR() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bbN) {
                        this.mStart = this.bbJ;
                        this.bbK = (int) this.bbL;
                        this.bbM = db(this.bbK);
                        this.mStartTime += this.mDuration;
                        GQ();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    q(this.bbJ, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bbN;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bbT[i];
                        f3 = (bbT[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bbL = ((f3 * this.bbO) / this.bbN) * 1000.0f;
                    d = f2 * this.bbO;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bbK);
                    d = this.bbP * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bbL = ((-f6) + f7) * signum * this.bbP * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bbL = this.bbK + (this.bbM * f8);
                    d = ((f8 * (this.bbM * f8)) / 2.0f) + (this.bbK * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
