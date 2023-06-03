package com.baidu.searchbox.ui;

import android.content.Context;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes4.dex */
public class OverScroller {
    public static final boolean DEBUG = false;
    public static final int DEFAULT_DURATION = 250;
    public static final int FLING_MODE = 1;
    public static final int SCROLL_MODE = 0;
    public static final String TAG = "OverScroller";
    public static float sViscousFluidNormalize = 1.0f / viscousFluid(1.0f);
    public static float sViscousFluidScale = 8.0f;
    public final boolean mFlywheel;
    public Interpolator mInterpolator;
    public int mMode;
    public final SplineOverScroller mScrollerX;
    public final SplineOverScroller mScrollerY;

    /* loaded from: classes4.dex */
    public static class SplineOverScroller {
        public static final int BALLISTIC = 2;
        public static final int CUBIC = 1;
        public static final float END_TENSION = 1.0f;
        public static final float GRAVITY = 2000.0f;
        public static final float INFLEXION = 0.35f;
        public static final int NB_SAMPLES = 100;
        public static final float P1 = 0.175f;
        public static final float P2 = 0.35000002f;
        public static final int SPLINE = 0;
        public static final float START_TENSION = 0.5f;
        public float mCurrVelocity;
        public int mCurrentPosition;
        public float mDeceleration;
        public int mDuration;
        public int mFinal;
        public int mOver;
        public float mPhysicalCoeff;
        public int mSplineDistance;
        public int mSplineDuration;
        public int mStart;
        public long mStartTime;
        public int mVelocity;
        public static float DECELERATION_RATE = (float) (Math.log(0.78d) / Math.log(0.9d));
        public static final float[] SPLINE_POSITION = new float[101];
        public static final float[] SPLINE_TIME = new float[101];
        public float mFlingFriction = ViewConfiguration.getScrollFriction();
        public int mState = 0;
        public boolean mFinished = true;

        public static float getDeceleration(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        static {
            float f;
            float f2;
            float f3;
            float f4;
            float f5;
            float f6;
            float f7;
            float f8;
            float f9;
            float f10;
            float f11 = 0.0f;
            float f12 = 0.0f;
            for (int i = 0; i < 100; i++) {
                float f13 = i / 100.0f;
                float f14 = 1.0f;
                while (true) {
                    f = 2.0f;
                    f2 = ((f14 - f11) / 2.0f) + f11;
                    f3 = 3.0f;
                    f4 = 1.0f - f2;
                    f5 = f2 * 3.0f * f4;
                    f6 = f2 * f2 * f2;
                    float f15 = (((f4 * 0.175f) + (f2 * 0.35000002f)) * f5) + f6;
                    if (Math.abs(f15 - f13) < 1.0E-5d) {
                        break;
                    } else if (f15 > f13) {
                        f14 = f2;
                    } else {
                        f11 = f2;
                    }
                }
                SPLINE_POSITION[i] = (f5 * ((f4 * 0.5f) + f2)) + f6;
                float f16 = 1.0f;
                while (true) {
                    f7 = ((f16 - f12) / f) + f12;
                    f8 = 1.0f - f7;
                    f9 = f7 * f3 * f8;
                    f10 = f7 * f7 * f7;
                    float f17 = (((f8 * 0.5f) + f7) * f9) + f10;
                    if (Math.abs(f17 - f13) < 1.0E-5d) {
                        break;
                    }
                    if (f17 > f13) {
                        f16 = f7;
                    } else {
                        f12 = f7;
                    }
                    f = 2.0f;
                    f3 = 3.0f;
                }
                SPLINE_TIME[i] = (f9 * ((f8 * 0.175f) + (f7 * 0.35000002f))) + f10;
            }
            float[] fArr = SPLINE_POSITION;
            SPLINE_TIME[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        public boolean update() {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mStartTime;
            int i = this.mDuration;
            if (currentAnimationTimeMillis > i) {
                return false;
            }
            double d = 0.0d;
            int i2 = this.mState;
            if (i2 != 0) {
                if (i2 != 1) {
                    if (i2 == 2) {
                        float f = ((float) currentAnimationTimeMillis) / 1000.0f;
                        int i3 = this.mVelocity;
                        float f2 = this.mDeceleration;
                        this.mCurrVelocity = i3 + (f2 * f);
                        d = (i3 * f) + (((f2 * f) * f) / 2.0f);
                    }
                } else {
                    float f3 = ((float) currentAnimationTimeMillis) / i;
                    float f4 = f3 * f3;
                    float signum = Math.signum(this.mVelocity);
                    int i4 = this.mOver;
                    this.mCurrVelocity = signum * i4 * 6.0f * ((-f3) + f4);
                    d = i4 * signum * ((3.0f * f4) - ((2.0f * f3) * f4));
                }
            } else {
                float f5 = ((float) currentAnimationTimeMillis) / this.mSplineDuration;
                int i5 = (int) (f5 * 100.0f);
                float f6 = 1.0f;
                float f7 = 0.0f;
                if (i5 < 100) {
                    float f8 = i5 / 100.0f;
                    int i6 = i5 + 1;
                    float[] fArr = SPLINE_POSITION;
                    float f9 = fArr[i5];
                    f7 = (fArr[i6] - f9) / ((i6 / 100.0f) - f8);
                    f6 = f9 + ((f5 - f8) * f7);
                }
                int i7 = this.mSplineDistance;
                this.mCurrVelocity = ((f7 * i7) / this.mSplineDuration) * 1000.0f;
                d = f6 * i7;
            }
            this.mCurrentPosition = this.mStart + ((int) Math.round(d));
            return true;
        }

        public SplineOverScroller(Context context) {
            this.mPhysicalCoeff = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        private double getSplineDeceleration(int i) {
            return Math.log((Math.abs(i) * 0.35f) / (this.mFlingFriction * this.mPhysicalCoeff));
        }

        private double getSplineFlingDistance(int i) {
            double splineDeceleration = getSplineDeceleration(i);
            float f = DECELERATION_RATE;
            return this.mFlingFriction * this.mPhysicalCoeff * Math.exp((f / (f - 1.0d)) * splineDeceleration);
        }

        private int getSplineFlingDuration(int i) {
            return (int) (Math.exp(getSplineDeceleration(i) / (DECELERATION_RATE - 1.0d)) * 1000.0d);
        }

        public void extendDuration(int i) {
            this.mDuration = ((int) (AnimationUtils.currentAnimationTimeMillis() - this.mStartTime)) + i;
            this.mFinished = false;
        }

        public void setFinalPosition(int i) {
            this.mFinal = i;
            this.mFinished = false;
        }

        public void setFriction(float f) {
            this.mFlingFriction = f;
        }

        public void updateScroll(float f) {
            int i = this.mStart;
            this.mCurrentPosition = i + Math.round(f * (this.mFinal - i));
        }

        private void adjustDuration(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (abs * 100.0f);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                int i5 = i4 + 1;
                float[] fArr = SPLINE_TIME;
                float f2 = fArr[i4];
                this.mDuration = (int) (this.mDuration * (f2 + (((abs - f) / ((i5 / 100.0f) - f)) * (fArr[i5] - f2))));
            }
        }

        private void startBounceAfterEdge(int i, int i2, int i3) {
            int i4;
            if (i3 == 0) {
                i4 = i - i2;
            } else {
                i4 = i3;
            }
            this.mDeceleration = getDeceleration(i4);
            fitOnBounceCurve(i, i2, i3);
            onEdgeReached();
        }

        private void startSpringback(int i, int i2, int i3) {
            this.mFinished = false;
            this.mState = 1;
            this.mStart = i;
            this.mFinal = i2;
            int i4 = i - i2;
            this.mDeceleration = getDeceleration(i4);
            this.mVelocity = -i4;
            this.mOver = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.mDeceleration) * 1000.0d);
        }

        public void notifyEdgeReached(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.mOver = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                startAfterEdge(i, i2, i2, (int) this.mCurrVelocity);
            }
        }

        public boolean springback(int i, int i2, int i3) {
            this.mFinished = true;
            this.mFinal = i;
            this.mStart = i;
            this.mVelocity = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = 0;
            if (i < i2) {
                startSpringback(i, i2, 0);
            } else if (i > i3) {
                startSpringback(i, i3, 0);
            }
            return !this.mFinished;
        }

        public void startScroll(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.mFinal = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.mDeceleration = 0.0f;
            this.mVelocity = 0;
        }

        private void fitOnBounceCurve(int i, int i2, int i3) {
            float f = this.mDeceleration;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(f)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.mDeceleration));
            this.mStartTime -= (int) ((sqrt - ((-i3) / f)) * 1000.0f);
            this.mStart = i2;
            this.mVelocity = (int) ((-this.mDeceleration) * sqrt);
        }

        private void onEdgeReached() {
            int i = this.mVelocity;
            float abs = (i * i) / (Math.abs(this.mDeceleration) * 2.0f);
            float signum = Math.signum(this.mVelocity);
            int i2 = this.mOver;
            if (abs > i2) {
                float f = -signum;
                int i3 = this.mVelocity;
                this.mDeceleration = ((f * i3) * i3) / (i2 * 2.0f);
                abs = i2;
            }
            this.mOver = (int) abs;
            this.mState = 2;
            int i4 = this.mStart;
            if (this.mVelocity <= 0) {
                abs = -abs;
            }
            this.mFinal = i4 + ((int) abs);
            this.mDuration = -((int) ((this.mVelocity * 1000.0f) / this.mDeceleration));
        }

        private void startAfterEdge(int i, int i2, int i3, int i4) {
            boolean z;
            int i5;
            int i6;
            int i7;
            boolean z2 = true;
            if (i > i2 && i < i3) {
                this.mFinished = true;
                return;
            }
            if (i > i3) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                i5 = i3;
            } else {
                i5 = i2;
            }
            int i8 = i - i5;
            if (i8 * i4 < 0) {
                z2 = false;
            }
            if (z2) {
                startBounceAfterEdge(i, i5, i4);
            } else if (getSplineFlingDistance(i4) > Math.abs(i8)) {
                if (z) {
                    i6 = i2;
                } else {
                    i6 = i;
                }
                if (z) {
                    i7 = i;
                } else {
                    i7 = i3;
                }
                fling(i, i4, i6, i7, this.mOver);
            } else {
                startSpringback(i, i5, i4);
            }
        }

        public boolean continueWhenFinished() {
            int i = this.mState;
            if (i != 0) {
                if (i == 1) {
                    return false;
                }
                if (i == 2) {
                    this.mStartTime += this.mDuration;
                    startSpringback(this.mFinal, this.mStart, 0);
                }
            } else if (this.mDuration >= this.mSplineDuration) {
                return false;
            } else {
                this.mStart = this.mFinal;
                int i2 = (int) this.mCurrVelocity;
                this.mVelocity = i2;
                this.mDeceleration = getDeceleration(i2);
                this.mStartTime += this.mDuration;
                onEdgeReached();
            }
            update();
            return true;
        }

        public void finish() {
            this.mCurrentPosition = this.mFinal;
            this.mFinished = true;
        }

        public void fling(int i, int i2, int i3, int i4, int i5) {
            float f;
            this.mOver = i5;
            this.mFinished = false;
            this.mVelocity = i2;
            this.mCurrVelocity = i2;
            this.mSplineDuration = 0;
            this.mDuration = 0;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mStart = i;
            this.mCurrentPosition = i;
            if (i <= i4 && i >= i3) {
                this.mState = 0;
                double d = 0.0d;
                if (i2 != 0) {
                    int splineFlingDuration = getSplineFlingDuration(i2);
                    this.mSplineDuration = splineFlingDuration;
                    this.mDuration = splineFlingDuration;
                    d = getSplineFlingDistance(i2);
                }
                int signum = (int) (d * Math.signum(f));
                this.mSplineDistance = signum;
                int i6 = i + signum;
                this.mFinal = i6;
                if (i6 < i3) {
                    adjustDuration(this.mStart, i6, i3);
                    this.mFinal = i3;
                }
                int i7 = this.mFinal;
                if (i7 > i4) {
                    adjustDuration(this.mStart, i7, i4);
                    this.mFinal = i4;
                    return;
                }
                return;
            }
            startAfterEdge(i, i3, i4, i2);
        }
    }

    public void abortAnimation() {
        this.mScrollerX.finish();
        this.mScrollerY.finish();
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.mScrollerX.mCurrVelocity * this.mScrollerX.mCurrVelocity) + (this.mScrollerY.mCurrVelocity * this.mScrollerY.mCurrVelocity));
    }

    public final int getCurrX() {
        return this.mScrollerX.mCurrentPosition;
    }

    public final int getCurrY() {
        return this.mScrollerY.mCurrentPosition;
    }

    @Deprecated
    public final int getDuration() {
        return Math.max(this.mScrollerX.mDuration, this.mScrollerY.mDuration);
    }

    public final int getFinalX() {
        return this.mScrollerX.mFinal;
    }

    public final int getFinalY() {
        return this.mScrollerY.mFinal;
    }

    public final int getStartX() {
        return this.mScrollerX.mStart;
    }

    public final int getStartY() {
        return this.mScrollerY.mStart;
    }

    public final boolean isFinished() {
        if (this.mScrollerX.mFinished && this.mScrollerY.mFinished) {
            return true;
        }
        return false;
    }

    public boolean isOverScrolled() {
        if ((!this.mScrollerX.mFinished && this.mScrollerX.mState != 0) || (!this.mScrollerY.mFinished && this.mScrollerY.mState != 0)) {
            return true;
        }
        return false;
    }

    public int timePassed() {
        return (int) (AnimationUtils.currentAnimationTimeMillis() - Math.min(this.mScrollerX.mStartTime, this.mScrollerY.mStartTime));
    }

    public OverScroller(Context context) {
        this(context, null);
    }

    public static float viscousFluid(float f) {
        float exp;
        float f2 = f * sViscousFluidScale;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * 0.63212055f) + 0.36787945f;
        }
        return exp * sViscousFluidNormalize;
    }

    @Deprecated
    public void extendDuration(int i) {
        this.mScrollerX.extendDuration(i);
        this.mScrollerY.extendDuration(i);
    }

    public final void forceFinished(boolean z) {
        this.mScrollerX.mFinished = this.mScrollerY.mFinished = z;
    }

    @Deprecated
    public void setFinalX(int i) {
        this.mScrollerX.setFinalPosition(i);
    }

    @Deprecated
    public void setFinalY(int i) {
        this.mScrollerY.setFinalPosition(i);
    }

    public final void setFriction(float f) {
        this.mScrollerX.setFriction(f);
        this.mScrollerY.setFriction(f);
    }

    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public OverScroller(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f2) {
        this(context, interpolator, true);
    }

    public void startScroll(int i, int i2, int i3, int i4) {
        startScroll(i, i2, i3, i4, 250);
    }

    public OverScroller(Context context, Interpolator interpolator, float f, float f2, boolean z) {
        this(context, interpolator, z);
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.mScrollerX.startScroll(i, i3, i5);
        this.mScrollerY.startScroll(i2, i4, i5);
    }

    public OverScroller(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.mFlywheel = z;
        this.mScrollerX = new SplineOverScroller(context);
        this.mScrollerY = new SplineOverScroller(context);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.mScrollerX.notifyEdgeReached(i, i2, i3);
    }

    public void notifyVerticalEdgeReached(int i, int i2, int i3) {
        this.mScrollerY.notifyEdgeReached(i, i2, i3);
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        int i = this.mMode;
        if (i != 0) {
            if (i == 1) {
                if (!this.mScrollerX.mFinished && !this.mScrollerX.update() && !this.mScrollerX.continueWhenFinished()) {
                    this.mScrollerX.finish();
                }
                if (!this.mScrollerY.mFinished && !this.mScrollerY.update() && !this.mScrollerY.continueWhenFinished()) {
                    this.mScrollerY.finish();
                }
            }
        } else {
            long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.mScrollerX.mStartTime;
            int i2 = this.mScrollerX.mDuration;
            if (currentAnimationTimeMillis < i2) {
                float f = ((float) currentAnimationTimeMillis) / i2;
                Interpolator interpolator = this.mInterpolator;
                if (interpolator == null) {
                    interpolation = viscousFluid(f);
                } else {
                    interpolation = interpolator.getInterpolation(f);
                }
                this.mScrollerX.updateScroll(interpolation);
                this.mScrollerY.updateScroll(interpolation);
            } else {
                abortAnimation();
            }
        }
        return true;
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        int i12;
        int i13;
        int i14;
        if (this.mFlywheel && !isFinished()) {
            float f = this.mScrollerX.mCurrVelocity;
            float f2 = this.mScrollerY.mCurrVelocity;
            i11 = i3;
            float f3 = i11;
            if (Math.signum(f3) == Math.signum(f)) {
                i12 = i4;
                float f4 = i12;
                if (Math.signum(f4) == Math.signum(f2)) {
                    i13 = (int) (f4 + f2);
                    i14 = (int) (f3 + f);
                    this.mMode = 1;
                    this.mScrollerX.fling(i, i14, i5, i6, i9);
                    this.mScrollerY.fling(i2, i13, i7, i8, i10);
                }
                i13 = i12;
                i14 = i11;
                this.mMode = 1;
                this.mScrollerX.fling(i, i14, i5, i6, i9);
                this.mScrollerY.fling(i2, i13, i7, i8, i10);
            }
        } else {
            i11 = i3;
        }
        i12 = i4;
        i13 = i12;
        i14 = i11;
        this.mMode = 1;
        this.mScrollerX.fling(i, i14, i5, i6, i9);
        this.mScrollerY.fling(i2, i13, i7, i8, i10);
    }

    public boolean isScrollingInDirection(float f, float f2) {
        int i = this.mScrollerX.mFinal - this.mScrollerX.mStart;
        int i2 = this.mScrollerY.mFinal - this.mScrollerY.mStart;
        if (!isFinished() && Math.signum(f) == Math.signum(i) && Math.signum(f2) == Math.signum(i2)) {
            return true;
        }
        return false;
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        boolean springback = this.mScrollerX.springback(i, i3, i4);
        boolean springback2 = this.mScrollerY.springback(i2, i5, i6);
        if (springback || springback2) {
            return true;
        }
        return false;
    }
}
