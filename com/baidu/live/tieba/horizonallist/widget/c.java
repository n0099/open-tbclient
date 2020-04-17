package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes3.dex */
public class c {
    private static float aUo = 8.0f;
    private static float aUp;
    private final a aUl;
    private final a aUm;
    private final boolean aUn;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        aUp = 1.0f;
        aUp = 1.0f / q(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float q(float f) {
        float exp;
        float f2 = aUo * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * aUp;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.aUn = z;
        this.aUl = new a(context);
        this.aUm = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.aUl.setFriction(f);
        this.aUm.setFriction(f);
    }

    public final boolean isFinished() {
        return this.aUl.mFinished && this.aUm.mFinished;
    }

    public final int getCurrX() {
        return this.aUl.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.aUl.aUs * this.aUl.aUs) + (this.aUm.aUs * this.aUm.aUs));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.aUl.mStartTime;
                int i = this.aUl.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = q(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.aUl.r(interpolation);
                    this.aUm.r(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.aUl.mFinished && !this.aUl.update() && !this.aUl.Fb()) {
                    this.aUl.finish();
                }
                if (!this.aUm.mFinished && !this.aUm.update() && !this.aUm.Fb()) {
                    this.aUm.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.aUl.o(i, i3, i5);
        this.aUm.o(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.aUl.p(i, i3, i4) || this.aUm.p(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.aUn && !isFinished()) {
            float f = this.aUl.aUs;
            float f2 = this.aUm.aUs;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.aUl.b(i, i11, i5, i6, i9);
                this.aUm.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.aUl.b(i, i11, i5, i6, i9);
        this.aUm.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.aUl.t(i, i2, i3);
    }

    public void abortAnimation() {
        this.aUl.finish();
        this.aUm.finish();
    }

    public boolean l(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.aUl.aUq - this.aUl.mStart)) && Math.signum(f2) == Math.signum((float) (this.aUm.aUq - this.aUm.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes3.dex */
    public static class a {
        private int aUq;
        private int aUr;
        private float aUs;
        private float aUt;
        private int aUu;
        private int aUv;
        private int aUw;
        private float aUy;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private static float aUz = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] aUA = new float[101];
        private static final float[] aUB = new float[101];
        private float aUx = ViewConfiguration.getScrollFriction();
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
                aUA[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                aUB[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = aUA;
            aUB[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.aUx = f;
        }

        a(Context context) {
            this.aUy = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void r(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.aUq - this.mStart) * f);
        }

        private static float cU(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void n(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = aUB[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (aUB[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void o(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.aUq = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.aUt = 0.0f;
            this.aUr = 0;
        }

        void finish() {
            this.mCurrentPosition = this.aUq;
            this.mFinished = true;
        }

        boolean p(int i, int i2, int i3) {
            this.mFinished = true;
            this.aUq = i;
            this.mStart = i;
            this.aUr = 0;
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
            this.aUq = i2;
            int i4 = i - i2;
            this.aUt = cU(i4);
            this.aUr = -i4;
            this.aUw = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.aUt) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.aUw = i5;
            this.mFinished = false;
            this.aUr = i2;
            this.aUs = i2;
            this.aUu = 0;
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
                int cX = cX(i2);
                this.aUu = cX;
                this.mDuration = cX;
                d = cW(i2);
            }
            this.aUv = (int) (d * Math.signum(i2));
            this.aUq = this.aUv + i;
            if (this.aUq < i3) {
                n(this.mStart, this.aUq, i3);
                this.aUq = i3;
            }
            if (this.aUq > i4) {
                n(this.mStart, this.aUq, i4);
                this.aUq = i4;
            }
        }

        private double cV(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.aUx * this.aUy));
        }

        private double cW(int i) {
            return Math.exp(cV(i) * (aUz / (aUz - 1.0d))) * this.aUx * this.aUy;
        }

        private int cX(int i) {
            return (int) (Math.exp(cV(i) / (aUz - 1.0d)) * 1000.0d);
        }

        private void r(int i, int i2, int i3) {
            float f = (-i3) / this.aUt;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.aUt)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.aUt));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.aUr = (int) ((-this.aUt) * sqrt);
        }

        private void s(int i, int i2, int i3) {
            this.aUt = cU(i3 == 0 ? i - i2 : i3);
            r(i, i2, i3);
            Fa();
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
            } else if (cW(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.aUw);
            } else {
                q(i, i5, i4);
            }
        }

        void t(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.aUw = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.aUs);
            }
        }

        private void Fa() {
            float abs = (this.aUr * this.aUr) / (Math.abs(this.aUt) * 2.0f);
            float signum = Math.signum(this.aUr);
            if (abs > this.aUw) {
                this.aUt = (((-signum) * this.aUr) * this.aUr) / (this.aUw * 2.0f);
                abs = this.aUw;
            }
            this.aUw = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.aUr <= 0) {
                abs = -abs;
            }
            this.aUq = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.aUr) / this.aUt));
        }

        boolean Fb() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.aUu) {
                        this.mStart = this.aUq;
                        this.aUr = (int) this.aUs;
                        this.aUt = cU(this.aUr);
                        this.mStartTime += this.mDuration;
                        Fa();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    q(this.aUq, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.aUu;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = aUA[i];
                        f3 = (aUA[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.aUs = ((f3 * this.aUv) / this.aUu) * 1000.0f;
                    d = f2 * this.aUv;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.aUr);
                    d = this.aUw * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.aUs = ((-f6) + f7) * signum * this.aUw * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.aUs = this.aUr + (this.aUt * f8);
                    d = ((f8 * (this.aUt * f8)) / 2.0f) + (this.aUr * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
