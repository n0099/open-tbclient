package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes11.dex */
public class c {
    private static float bKf = 8.0f;
    private static float bKg;
    private final a bKc;
    private final a bKd;
    private final boolean bKe;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bKg = 1.0f;
        bKg = 1.0f / t(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float t(float f) {
        float exp;
        float f2 = bKf * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bKg;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bKe = z;
        this.bKc = new a(context);
        this.bKd = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bKc.setFriction(f);
        this.bKd.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bKc.mFinished && this.bKd.mFinished;
    }

    public final int getCurrX() {
        return this.bKc.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.bKc.bKj * this.bKc.bKj) + (this.bKd.bKj * this.bKd.bKj));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bKc.mStartTime;
                int i = this.bKc.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = t(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bKc.u(interpolation);
                    this.bKd.u(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bKc.mFinished && !this.bKc.update() && !this.bKc.Wj()) {
                    this.bKc.finish();
                }
                if (!this.bKd.mFinished && !this.bKd.update() && !this.bKd.Wj()) {
                    this.bKd.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bKc.p(i, i3, i5);
        this.bKd.p(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bKc.q(i, i3, i4) || this.bKd.q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bKe && !isFinished()) {
            float f = this.bKc.bKj;
            float f2 = this.bKd.bKj;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bKc.b(i, i11, i5, i6, i9);
                this.bKd.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bKc.b(i, i11, i5, i6, i9);
        this.bKd.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bKc.u(i, i2, i3);
    }

    public void abortAnimation() {
        this.bKc.finish();
        this.bKd.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bKc.bKh - this.bKc.mStart)) && Math.signum(f2) == Math.signum((float) (this.bKd.bKh - this.bKd.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes11.dex */
    public static class a {
        private static float bKq = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bKr = new float[101];
        private static final float[] bKs = new float[101];
        private int bKh;
        private int bKi;
        private float bKj;
        private float bKk;
        private int bKl;
        private int bKm;
        private int bKn;
        private float bKp;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bKo = ViewConfiguration.getScrollFriction();
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
                bKr[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bKs[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bKr;
            bKs[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bKo = f;
        }

        a(Context context) {
            this.bKp = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void u(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bKh - this.mStart) * f);
        }

        private static float gk(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void o(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bKs[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bKs[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void p(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bKh = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bKk = 0.0f;
            this.bKi = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bKh;
            this.mFinished = true;
        }

        boolean q(int i, int i2, int i3) {
            this.mFinished = true;
            this.bKh = i;
            this.mStart = i;
            this.bKi = 0;
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
            this.bKh = i2;
            int i4 = i - i2;
            this.bKk = gk(i4);
            this.bKi = -i4;
            this.bKn = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bKk) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bKn = i5;
            this.mFinished = false;
            this.bKi = i2;
            this.bKj = i2;
            this.bKl = 0;
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
                int gn = gn(i2);
                this.bKl = gn;
                this.mDuration = gn;
                d = gm(i2);
            }
            this.bKm = (int) (d * Math.signum(i2));
            this.bKh = this.bKm + i;
            if (this.bKh < i3) {
                o(this.mStart, this.bKh, i3);
                this.bKh = i3;
            }
            if (this.bKh > i4) {
                o(this.mStart, this.bKh, i4);
                this.bKh = i4;
            }
        }

        private double gl(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bKo * this.bKp));
        }

        private double gm(int i) {
            return Math.exp(gl(i) * (bKq / (bKq - 1.0d))) * this.bKo * this.bKp;
        }

        private int gn(int i) {
            return (int) (Math.exp(gl(i) / (bKq - 1.0d)) * 1000.0d);
        }

        private void s(int i, int i2, int i3) {
            float f = (-i3) / this.bKk;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bKk)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bKk));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bKi = (int) ((-this.bKk) * sqrt);
        }

        private void t(int i, int i2, int i3) {
            this.bKk = gk(i3 == 0 ? i - i2 : i3);
            s(i, i2, i3);
            Wi();
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
            } else if (gm(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bKn);
            } else {
                r(i, i5, i4);
            }
        }

        void u(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bKn = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                k(i, i2, i2, (int) this.bKj);
            }
        }

        private void Wi() {
            float abs = (this.bKi * this.bKi) / (Math.abs(this.bKk) * 2.0f);
            float signum = Math.signum(this.bKi);
            if (abs > this.bKn) {
                this.bKk = (((-signum) * this.bKi) * this.bKi) / (this.bKn * 2.0f);
                abs = this.bKn;
            }
            this.bKn = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bKi <= 0) {
                abs = -abs;
            }
            this.bKh = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bKi) / this.bKk));
        }

        boolean Wj() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bKl) {
                        this.mStart = this.bKh;
                        this.bKi = (int) this.bKj;
                        this.bKk = gk(this.bKi);
                        this.mStartTime += this.mDuration;
                        Wi();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    r(this.bKh, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bKl;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bKr[i];
                        f3 = (bKr[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bKj = ((f3 * this.bKm) / this.bKl) * 1000.0f;
                    d = f2 * this.bKm;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bKi);
                    d = this.bKn * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bKj = ((-f6) + f7) * signum * this.bKn * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bKj = this.bKi + (this.bKk * f8);
                    d = ((f8 * (this.bKk * f8)) / 2.0f) + (this.bKi * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
