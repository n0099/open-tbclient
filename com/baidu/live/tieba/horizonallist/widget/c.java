package com.baidu.live.tieba.horizonallist.widget;

import android.content.Context;
import android.util.Log;
import android.view.ViewConfiguration;
import android.view.animation.AnimationUtils;
import android.view.animation.Interpolator;
/* loaded from: classes7.dex */
public class c {
    private static float bmV = 8.0f;
    private static float bmW;
    private final a bmS;
    private final a bmT;
    private final boolean bmU;
    private Interpolator mInterpolator;
    private int mMode;

    static {
        bmW = 1.0f;
        bmW = 1.0f / s(1.0f);
    }

    public c(Context context) {
        this(context, null);
    }

    public static float s(float f) {
        float exp;
        float f2 = bmV * f;
        if (f2 < 1.0f) {
            exp = f2 - (1.0f - ((float) Math.exp(-f2)));
        } else {
            exp = ((1.0f - ((float) Math.exp(1.0f - f2))) * (1.0f - 0.36787945f)) + 0.36787945f;
        }
        return exp * bmW;
    }

    public c(Context context, Interpolator interpolator) {
        this(context, interpolator, true);
    }

    public c(Context context, Interpolator interpolator, boolean z) {
        this.mInterpolator = interpolator;
        this.bmU = z;
        this.bmS = new a(context);
        this.bmT = new a(context);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void setInterpolator(Interpolator interpolator) {
        this.mInterpolator = interpolator;
    }

    public final void setFriction(float f) {
        this.bmS.setFriction(f);
        this.bmT.setFriction(f);
    }

    public final boolean isFinished() {
        return this.bmS.mFinished && this.bmT.mFinished;
    }

    public final int getCurrX() {
        return this.bmS.mCurrentPosition;
    }

    public float getCurrVelocity() {
        return (float) Math.sqrt((this.bmS.bmZ * this.bmS.bmZ) + (this.bmT.bmZ * this.bmT.bmZ));
    }

    public boolean computeScrollOffset() {
        float interpolation;
        if (isFinished()) {
            return false;
        }
        switch (this.mMode) {
            case 0:
                long currentAnimationTimeMillis = AnimationUtils.currentAnimationTimeMillis() - this.bmS.mStartTime;
                int i = this.bmS.mDuration;
                if (currentAnimationTimeMillis < i) {
                    float f = ((float) currentAnimationTimeMillis) / i;
                    if (this.mInterpolator == null) {
                        interpolation = s(f);
                    } else {
                        interpolation = this.mInterpolator.getInterpolation(f);
                    }
                    this.bmS.t(interpolation);
                    this.bmT.t(interpolation);
                    break;
                } else {
                    abortAnimation();
                    break;
                }
            case 1:
                if (!this.bmS.mFinished && !this.bmS.update() && !this.bmS.Od()) {
                    this.bmS.finish();
                }
                if (!this.bmT.mFinished && !this.bmT.update() && !this.bmT.Od()) {
                    this.bmT.finish();
                    break;
                }
                break;
        }
        return true;
    }

    public void startScroll(int i, int i2, int i3, int i4, int i5) {
        this.mMode = 0;
        this.bmS.o(i, i3, i5);
        this.bmT.o(i2, i4, i5);
    }

    public boolean springBack(int i, int i2, int i3, int i4, int i5, int i6) {
        this.mMode = 1;
        return this.bmS.p(i, i3, i4) || this.bmT.p(i2, i5, i6);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        fling(i, i2, i3, i4, i5, i6, i7, i8, 0, 0);
    }

    public void fling(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10) {
        int i11;
        if (this.bmU && !isFinished()) {
            float f = this.bmS.bmZ;
            float f2 = this.bmT.bmZ;
            if (Math.signum(i3) == Math.signum(f) && Math.signum(i4) == Math.signum(f2)) {
                i4 = (int) (i4 + f2);
                i11 = (int) (f + i3);
                this.mMode = 1;
                this.bmS.b(i, i11, i5, i6, i9);
                this.bmT.b(i2, i4, i7, i8, i10);
            }
        }
        i11 = i3;
        this.mMode = 1;
        this.bmS.b(i, i11, i5, i6, i9);
        this.bmT.b(i2, i4, i7, i8, i10);
    }

    public void notifyHorizontalEdgeReached(int i, int i2, int i3) {
        this.bmS.t(i, i2, i3);
    }

    public void abortAnimation() {
        this.bmS.finish();
        this.bmT.finish();
    }

    public boolean k(float f, float f2) {
        return !isFinished() && Math.signum(f) == Math.signum((float) (this.bmS.bmX - this.bmS.mStart)) && Math.signum(f2) == Math.signum((float) (this.bmT.bmX - this.bmT.mStart));
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    /* loaded from: classes7.dex */
    public static class a {
        private static float bng = (float) (Math.log(0.78d) / Math.log(0.9d));
        private static final float[] bnh = new float[101];
        private static final float[] bni = new float[101];
        private int bmX;
        private int bmY;
        private float bmZ;
        private float bna;
        private int bnb;
        private int bnc;
        private int bnd;
        private float bnf;
        private int mCurrentPosition;
        private int mDuration;
        private int mStart;
        private long mStartTime;
        private float bne = ViewConfiguration.getScrollFriction();
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
                bnh[i] = (f * f * f) + (f2 * (((1.0f - f) * 0.5f) + f));
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
                bni[i] = (f3 * f3 * f3) + ((((1.0f - f3) * 0.175f) + (0.35000002f * f3)) * f4);
                i++;
                f6 = f9;
            }
            float[] fArr = bnh;
            bni[100] = 1.0f;
            fArr[100] = 1.0f;
        }

        void setFriction(float f) {
            this.bne = f;
        }

        a(Context context) {
            this.bnf = context.getResources().getDisplayMetrics().density * 160.0f * 386.0878f * 0.84f;
        }

        void t(float f) {
            this.mCurrentPosition = this.mStart + Math.round((this.bmX - this.mStart) * f);
        }

        private static float fg(int i) {
            return i > 0 ? -2000.0f : 2000.0f;
        }

        private void n(int i, int i2, int i3) {
            float abs = Math.abs((i3 - i) / (i2 - i));
            int i4 = (int) (100.0f * abs);
            if (i4 < 100) {
                float f = i4 / 100.0f;
                float f2 = bni[i4];
                this.mDuration = (int) (((((abs - f) / (((i4 + 1) / 100.0f) - f)) * (bni[i4 + 1] - f2)) + f2) * this.mDuration);
            }
        }

        void o(int i, int i2, int i3) {
            this.mFinished = false;
            this.mStart = i;
            this.bmX = i + i2;
            this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
            this.mDuration = i3;
            this.bna = 0.0f;
            this.bmY = 0;
        }

        void finish() {
            this.mCurrentPosition = this.bmX;
            this.mFinished = true;
        }

        boolean p(int i, int i2, int i3) {
            this.mFinished = true;
            this.bmX = i;
            this.mStart = i;
            this.bmY = 0;
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
            this.bmX = i2;
            int i4 = i - i2;
            this.bna = fg(i4);
            this.bmY = -i4;
            this.bnd = Math.abs(i4);
            this.mDuration = (int) (Math.sqrt((i4 * (-2.0d)) / this.bna) * 1000.0d);
        }

        void b(int i, int i2, int i3, int i4, int i5) {
            this.bnd = i5;
            this.mFinished = false;
            this.bmY = i2;
            this.bmZ = i2;
            this.bnb = 0;
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
                int fj = fj(i2);
                this.bnb = fj;
                this.mDuration = fj;
                d = fi(i2);
            }
            this.bnc = (int) (d * Math.signum(i2));
            this.bmX = this.bnc + i;
            if (this.bmX < i3) {
                n(this.mStart, this.bmX, i3);
                this.bmX = i3;
            }
            if (this.bmX > i4) {
                n(this.mStart, this.bmX, i4);
                this.bmX = i4;
            }
        }

        private double fh(int i) {
            return Math.log((0.35f * Math.abs(i)) / (this.bne * this.bnf));
        }

        private double fi(int i) {
            return Math.exp(fh(i) * (bng / (bng - 1.0d))) * this.bne * this.bnf;
        }

        private int fj(int i) {
            return (int) (Math.exp(fh(i) / (bng - 1.0d)) * 1000.0d);
        }

        private void r(int i, int i2, int i3) {
            float f = (-i3) / this.bna;
            float sqrt = (float) Math.sqrt((((((i3 * i3) / 2.0f) / Math.abs(this.bna)) + Math.abs(i2 - i)) * 2.0d) / Math.abs(this.bna));
            this.mStartTime -= (int) ((sqrt - f) * 1000.0f);
            this.mStart = i2;
            this.bmY = (int) ((-this.bna) * sqrt);
        }

        private void s(int i, int i2, int i3) {
            this.bna = fg(i3 == 0 ? i - i2 : i3);
            r(i, i2, i3);
            Oc();
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
            } else if (fi(i4) > Math.abs(i6)) {
                b(i, i4, z ? i2 : i, z ? i : i3, this.bnd);
            } else {
                q(i, i5, i4);
            }
        }

        void t(int i, int i2, int i3) {
            if (this.mState == 0) {
                this.bnd = i3;
                this.mStartTime = AnimationUtils.currentAnimationTimeMillis();
                h(i, i2, i2, (int) this.bmZ);
            }
        }

        private void Oc() {
            float abs = (this.bmY * this.bmY) / (Math.abs(this.bna) * 2.0f);
            float signum = Math.signum(this.bmY);
            if (abs > this.bnd) {
                this.bna = (((-signum) * this.bmY) * this.bmY) / (this.bnd * 2.0f);
                abs = this.bnd;
            }
            this.bnd = (int) abs;
            this.mState = 2;
            int i = this.mStart;
            if (this.bmY <= 0) {
                abs = -abs;
            }
            this.bmX = ((int) abs) + i;
            this.mDuration = -((int) ((1000.0f * this.bmY) / this.bna));
        }

        boolean Od() {
            switch (this.mState) {
                case 0:
                    if (this.mDuration < this.bnb) {
                        this.mStart = this.bmX;
                        this.bmY = (int) this.bmZ;
                        this.bna = fg(this.bmY);
                        this.mStartTime += this.mDuration;
                        Oc();
                        break;
                    } else {
                        return false;
                    }
                case 1:
                    return false;
                case 2:
                    this.mStartTime += this.mDuration;
                    q(this.bmX, this.mStart, 0);
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
                    float f = ((float) currentAnimationTimeMillis) / this.bnb;
                    int i = (int) (100.0f * f);
                    float f2 = 1.0f;
                    float f3 = 0.0f;
                    if (i < 100) {
                        float f4 = i / 100.0f;
                        float f5 = bnh[i];
                        f3 = (bnh[i + 1] - f5) / (((i + 1) / 100.0f) - f4);
                        f2 = ((f - f4) * f3) + f5;
                    }
                    this.bmZ = ((f3 * this.bnc) / this.bnb) * 1000.0f;
                    d = f2 * this.bnc;
                    break;
                case 1:
                    float f6 = ((float) currentAnimationTimeMillis) / this.mDuration;
                    float f7 = f6 * f6;
                    float signum = Math.signum(this.bmY);
                    d = this.bnd * signum * ((3.0f * f7) - ((2.0f * f6) * f7));
                    this.bmZ = ((-f6) + f7) * signum * this.bnd * 6.0f;
                    break;
                case 2:
                    float f8 = ((float) currentAnimationTimeMillis) / 1000.0f;
                    this.bmZ = this.bmY + (this.bna * f8);
                    d = ((f8 * (this.bna * f8)) / 2.0f) + (this.bmY * f8);
                    break;
            }
            this.mCurrentPosition = ((int) Math.round(d)) + this.mStart;
            return true;
        }
    }
}
