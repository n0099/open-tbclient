package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes4.dex */
public class c {
    private static float bBU = 8.0f;
    private static float bBV;
    private final a bBR;
    private final a bBS;
    private final boolean bBT;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bBV = 1.0f;
        bBV = 1.0f / v(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float v(float f) {
        float exp;
        float f2 = bBU * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bBV;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bBT = z;
        this.bBR = new a(context);
        this.bBS = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bBR.setFriction(f);
        this.bBS.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bBR.mFinished && this.bBS.mFinished;
    }

    public final int getCurrX() {
        return this.bBR.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.bBR.bBY * this.bBR.bBY) + (this.bBS.bBY * this.bBS.bBY));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bBR.mStartTime;
                int i = this.bBR.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = v(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bBR.A(interpolation);
                    this.bBS.A(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bBR.mFinished && !this.bBR.update() && !this.bBR.To()) {
                    this.bBR.finish();
                }
                if (!this.bBS.mFinished && !this.bBS.update() && !this.bBS.To()) {
                    this.bBS.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bBR.p(i, i3, i5);
        this.bBS.p(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bBR.q(i, i3, i4) || this.bBS.q(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bBT && !isFinished()) {
            float f = this.bBR.bBY;
            float f2 = this.bBS.bBY;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bBR.b(i, i11, i5, i6, i9);
                this.bBS.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bBR.b(i, i11, i5, i6, i9);
        this.bBS.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bBR.u(i, i2, i3);
    }

    public void abortAnimation() {
        this.bBR.finish();
        this.bBS.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bBR.bBW - this.bBR.mStart)) && Math.signum(f2) == Math.signum((float) (this.bBS.bBW - this.bBS.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes4.dex */
    public static class a {
        private static float bCf = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bCg = new float[101];
        private static final float[] bCh = new float[101];
        private int bBW;
        private int bBX;
        private float bBY;
        private float bBZ;
        private int bCa;
        private int bCb;
        private int bCc;
        private float bCe;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bCd = ViewConfiguration.getScrollFriction();
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
                bCg[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bCh[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bCg;
            bCh[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bCd = f;
        }

        a(Context context) {
            this.bCe = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void A(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bBW - this.mStart) * f);
        }

        private static float fP(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void o(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bCh[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bCh[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void p(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bBW = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bBZ = 0.0f;
            this.bBX = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bBW;
            this.mFinished = true;
        }

        boolean q(int i, int i2, int i3) {
            this.mFinished = true;
            this.bBW = i;
            this.mStart = i;
            this.bBX = 0;
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
            this.bBW = i2;
            int i4 = i - i2;
            this.bBZ = fP(i4);
            this.bBX = -i4;
            this.bCc = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bBZ) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bCc = i5;
            this.mFinished = false;
            this.bBX = i2;
            this.bBY = i2;
            this.bCa = 0;
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
                int fS = fS(i2);
                this.bCa = fS;
                this.mDuration = fS;
                d = fR(i2);
            }
            this.bCb = (int) (d * Math.signum(i2));
            this.bBW = this.bCb + i;
            if (this.bBW < i3) {
                o(this.mStart, this.bBW, i3);
                this.bBW = i3;
            }
            if (this.bBW > i4) {
                o(this.mStart, this.bBW, i4);
                this.bBW = i4;
            }
        }

        private double fQ(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bCd * this.bCe));
        }

        private double fR(int i) {
            return Math.exp(fQ(i) * (bCf / (bCf - 1.0d))) * this.bCd * this.bCe;
        }

        private int fS(int i) {
            return (int) (Math.exp(fQ(i) / (bCf - 1.0d)) * 1000.0d);
        }

        private void s(int i, int i2, int i3) {
            float f = (-i3) / this.bBZ;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bBZ)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bBZ));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bBX = (int) ((-this.bBZ) * sqrt);
        }

        private void t(int i, int i2, int i3) {
            this.bBZ = fP(i3 == 0 ? i - i2 : i3);
            s(i, i2, i3);
            Tn();
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
            } else if (fR(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bCc);
            } else {
                r(i, i5, i4);
            }
        }

        void u(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bCc = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.bBY);
            }
        }

        private void Tn() {
            float abs = (this.bBX * this.bBX) / (Math.abs(this.bBZ) * 2.0f);
            float signum = Math.signum(this.bBX);
            if (abs > this.bCc) {
                this.bBZ = (((-signum) * this.bBX) * this.bBX) / (this.bCc * 2.0f);
                abs = this.bCc;
            }
            this.bCc = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bBX <= 0) {
                abs = -abs;
            }
            this.bBW = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bBX) / this.bBZ));
        }

        boolean To() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bCa) {
                        this.mStart = this.bBW;
                        this.bBX = (int) this.bBY;
                        this.bBZ = fP(this.bBX);
                        this.mStartTime += this.mDuration;
                        Tn();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    r(this.bBW, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bCa;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bCg[i];
                        f3 = (bCg[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bBY = ((f3 * this.bCb) / this.bCa) * 1000.0f;
                    d = f2 * this.bCb;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bBX);
                    d = this.bCc * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bBY = ((-f6) + f7) * signum * this.bCc * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bBY = this.bBX + (this.bBZ * f8);
                    d = ((f8 * (this.bBZ * f8)) / 2.0f) + (this.bBX * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
