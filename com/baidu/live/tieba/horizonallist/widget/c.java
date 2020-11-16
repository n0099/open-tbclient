package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes4.dex */
public class c {
    private static float bAj = 8.0f;
    private static float bAk;
    private final a bAg;
    private final a bAh;
    private final boolean bAi;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bAk = 1.0f;
        bAk = 1.0f / u(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float u(float f) {
        float exp;
        float f2 = bAj * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bAk;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bAi = z;
        this.bAg = new a(context);
        this.bAh = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bAg.setFriction(f);
        this.bAh.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bAg.mFinished && this.bAh.mFinished;
    }

    public final int getCurrX() {
        return this.bAg.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.bAg.bAn * this.bAg.bAn) + (this.bAh.bAn * this.bAh.bAn));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bAg.mStartTime;
                int i = this.bAg.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = u(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bAg.v(interpolation);
                    this.bAh.v(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bAg.mFinished && !this.bAg.update() && !this.bAg.SF()) {
                    this.bAg.finish();
                }
                if (!this.bAh.mFinished && !this.bAh.update() && !this.bAh.SF()) {
                    this.bAh.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bAg.p(i, i3, i5);
        this.bAh.p(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bAg.q(i, i3, i4) || this.bAh.q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bAi && !isFinished()) {
            float f = this.bAg.bAn;
            float f2 = this.bAh.bAn;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bAg.b(i, i11, i5, i6, i9);
                this.bAh.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bAg.b(i, i11, i5, i6, i9);
        this.bAh.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bAg.u(i, i2, i3);
    }

    public void abortAnimation() {
        this.bAg.finish();
        this.bAh.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bAg.bAl - this.bAg.mStart)) && Math.signum(f2) == Math.signum((float) (this.bAh.bAl - this.bAh.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        private static float bAu = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bAv = new float[101];
        private static final float[] bAw = new float[101];
        private int bAl;
        private int bAm;
        private float bAn;
        private float bAo;
        private int bAp;
        private int bAq;
        private int bAr;
        private float bAt;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bAs = ViewConfiguration.getScrollFriction();
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
                bAv[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bAw[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bAv;
            bAw[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bAs = f;
        }

        a(Context context) {
            this.bAt = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void v(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bAl - this.mStart) * f);
        }

        private static float fL(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void o(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bAw[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bAw[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void p(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bAl = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bAo = 0.0f;
            this.bAm = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bAl;
            this.mFinished = true;
        }

        boolean q(int i, int i2, int i3) {
            this.mFinished = true;
            this.bAl = i;
            this.mStart = i;
            this.bAm = 0;
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
            this.bAl = i2;
            int i4 = i - i2;
            this.bAo = fL(i4);
            this.bAm = -i4;
            this.bAr = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bAo) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bAr = i5;
            this.mFinished = false;
            this.bAm = i2;
            this.bAn = i2;
            this.bAp = 0;
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
                int fO = fO(i2);
                this.bAp = fO;
                this.mDuration = fO;
                d = fN(i2);
            }
            this.bAq = (int) (d * Math.signum(i2));
            this.bAl = this.bAq + i;
            if (this.bAl < i3) {
                o(this.mStart, this.bAl, i3);
                this.bAl = i3;
            }
            if (this.bAl > i4) {
                o(this.mStart, this.bAl, i4);
                this.bAl = i4;
            }
        }

        private double fM(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bAs * this.bAt));
        }

        private double fN(int i) {
            return Math.exp(fM(i) * (bAu / (bAu - 1.0d))) * this.bAs * this.bAt;
        }

        private int fO(int i) {
            return (int) (Math.exp(fM(i) / (bAu - 1.0d)) * 1000.0d);
        }

        private void s(int i, int i2, int i3) {
            float f = (-i3) / this.bAo;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bAo)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bAo));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bAm = (int) ((-this.bAo) * sqrt);
        }

        private void t(int i, int i2, int i3) {
            this.bAo = fL(i3 == 0 ? i - i2 : i3);
            s(i, i2, i3);
            SE();
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
                t(i, i5, i4);
            } else if (fN(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bAr);
            } else {
                r(i, i5, i4);
            }
        }

        void u(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bAr = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.bAn);
            }
        }

        private void SE() {
            float abs = (this.bAm * this.bAm) / (Math.abs(this.bAo) * 2.0f);
            float signum = Math.signum(this.bAm);
            if (abs > this.bAr) {
                this.bAo = (((-signum) * this.bAm) * this.bAm) / (this.bAr * 2.0f);
                abs = this.bAr;
            }
            this.bAr = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bAm <= 0) {
                abs = -abs;
            }
            this.bAl = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bAm) / this.bAo));
        }

        boolean SF() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bAp) {
                        this.mStart = this.bAl;
                        this.bAm = (int) this.bAn;
                        this.bAo = fL(this.bAm);
                        this.mStartTime += this.mDuration;
                        SE();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    r(this.bAl, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bAp;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bAv[i];
                        f3 = (bAv[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bAn = ((f3 * this.bAq) / this.bAp) * 1000.0f;
                    d = f2 * this.bAq;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bAm);
                    d = this.bAr * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bAn = ((-f6) + f7) * signum * this.bAr * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bAn = this.bAm + (this.bAo * f8);
                    d = ((f8 * (this.bAo * f8)) / 2.0f) + (this.bAm * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
