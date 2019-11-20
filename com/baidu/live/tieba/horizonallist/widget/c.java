package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes6.dex */
public class c {
    private static float anr = 8.0f;
    private static float ans;
    private final a ano;
    private final a anp;
    private final boolean anq;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        ans = 1.0f;
        ans = 1.0f / I(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float I(float f) {
        float exp;
        float f2 = anr * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * ans;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.anq = z;
        this.ano = new a(context);
        this.anp = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.ano.setFriction(f);
        this.anp.setFriction(f);
    }

    public final boolean isFinished() {
        return this.ano.mFinished && this.anp.mFinished;
    }

    public final int getCurrX() {
        return this.ano.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.ano.anv * this.ano.anv) + (this.anp.anv * this.anp.anv));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.ano.mStartTime;
                int i = this.ano.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = I(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.ano.J(interpolation);
                    this.anp.J(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.ano.mFinished && !this.ano.update() && !this.ano.vp()) {
                    this.ano.finish();
                }
                if (!this.anp.mFinished && !this.anp.update() && !this.anp.vp()) {
                    this.anp.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.ano.l(i, i3, i5);
        this.anp.l(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.ano.m(i, i3, i4) || this.anp.m(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.anq && !isFinished()) {
            float f = this.ano.anv;
            float f2 = this.anp.anv;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.ano.b(i, i11, i5, i6, i9);
                this.anp.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.ano.b(i, i11, i5, i6, i9);
        this.anp.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.ano.q(i, i2, i3);
    }

    public void abortAnimation() {
        this.ano.finish();
        this.anp.finish();
    }

    public boolean n(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.ano.ant - this.ano.mStart)) && Math.signum(f2) == Math.signum((float) (this.anp.ant - this.anp.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes6.dex */
    public static class a {
        private static float anC = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] anD = new float[101];
        private static final float[] anE = new float[101];
        private float anB;
        private int ant;
        private int anu;
        private float anv;
        private float anw;
        private int anx;
        private int any;
        private int anz;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float anA = ViewConfiguration.getScrollFriction();
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
                anD[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                anE[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = anD;
            anE[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.anA = f;
        }

        a(Context context) {
            this.anB = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void J(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.ant - this.mStart) * f);
        }

        private static float bW(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void k(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = anE[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (anE[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void l(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.ant = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.anw = 0.0f;
            this.anu = 0;
        }

        void finish() {
            this.mCurrentPosition = this.ant;
            this.mFinished = true;
        }

        boolean m(int i, int i2, int i3) {
            this.mFinished = true;
            this.ant = i;
            this.mStart = i;
            this.anu = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                n(i, i2, 0);
            } else if (i > i3) {
                n(i, i3, 0);
            }
            return !this.mFinished;
        }

        private void n(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.ant = i2;
            int i4 = i - i2;
            this.anw = bW(i4);
            this.anu = -i4;
            this.anz = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.anw) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.anz = i5;
            this.mFinished = false;
            this.anu = i2;
            this.anv = i2;
            this.anx = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i > i4 || i < i3) {
                g(i, i3, i4, i2);
                return;
            }
            this.mState = 0;
            double d = 0.0d;
            if (i2 != 0) {
                int bZ = bZ(i2);
                this.anx = bZ;
                this.mDuration = bZ;
                d = bY(i2);
            }
            this.any = (int) (d * Math.signum(i2));
            this.ant = this.any + i;
            if (this.ant < i3) {
                k(this.mStart, this.ant, i3);
                this.ant = i3;
            }
            if (this.ant > i4) {
                k(this.mStart, this.ant, i4);
                this.ant = i4;
            }
        }

        private double bX(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.anA * this.anB));
        }

        private double bY(int i) {
            return Math.exp(bX(i) * (anC / (anC - 1.0d))) * this.anA * this.anB;
        }

        private int bZ(int i) {
            return (int) (Math.exp(bX(i) / (anC - 1.0d)) * 1000.0d);
        }

        private void o(int i, int i2, int i3) {
            float f = (-i3) / this.anw;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.anw)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.anw));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.anu = (int) ((-this.anw) * sqrt);
        }

        private void p(int i, int i2, int i3) {
            this.anw = bW(i3 == 0 ? i - i2 : i3);
            o(i, i2, i3);
            vo();
        }

        private void g(int i, int i2, int i3, int i4) {
            if (i > i2 && i < i3) {
                Log.e("OverScroller", "startAfterEdge called from a valid position");
                this.mFinished = true;
                return;
            }
            boolean z = i > i3;
            int i5 = z ? i3 : i2;
            int i6 = i - i5;
            if (i6 * i4 >= 0) {
                p(i, i5, i4);
            } else if (bY(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.anz);
            } else {
                n(i, i5, i4);
            }
        }

        void q(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.anz = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                g(i, i2, i2, (int) this.anv);
            }
        }

        private void vo() {
            float abs = (this.anu * this.anu) / (Math.abs(this.anw) * 2.0f);
            float signum = Math.signum(this.anu);
            if (abs > this.anz) {
                this.anw = (((-signum) * this.anu) * this.anu) / (this.anz * 2.0f);
                abs = this.anz;
            }
            this.anz = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.anu <= 0) {
                abs = -abs;
            }
            this.ant = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.anu) / this.anw));
        }

        boolean vp() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.anx) {
                        this.mStart = this.ant;
                        this.anu = (int) this.anv;
                        this.anw = bW(this.anu);
                        this.mStartTime += this.mDuration;
                        vo();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    n(this.ant, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.anx;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = anD[i];
                        f3 = (anD[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.anv = ((f3 * this.any) / this.anx) * 1000.0f;
                    d = f2 * this.any;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.anu);
                    d = this.anz * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.anv = ((-f6) + f7) * signum * this.anz * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.anv = this.anu + (this.anw * f8);
                    d = ((f8 * (this.anw * f8)) / 2.0f) + (this.anu * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
