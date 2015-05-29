package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class m {
    private static /* synthetic */ int[] Ga;
    final /* synthetic */ HorizontalTranslateLayout FN;
    VelocityTracker FW;
    boolean FX;
    final int FY;
    final int FZ;

    static /* synthetic */ int[] mP() {
        int[] iArr = Ga;
        if (iArr == null) {
            iArr = new int[HorizontalTranslateLayout.TrackDirection.valuesCustom().length];
            try {
                iArr[HorizontalTranslateLayout.TrackDirection.horizontal.ordinal()] = 3;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[HorizontalTranslateLayout.TrackDirection.left.ordinal()] = 1;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[HorizontalTranslateLayout.TrackDirection.none.ordinal()] = 4;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[HorizontalTranslateLayout.TrackDirection.right.ordinal()] = 2;
            } catch (NoSuchFieldError e4) {
            }
            Ga = iArr;
        }
        return iArr;
    }

    public boolean au(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        i iVar;
        i iVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] mP = mP();
        trackDirection = this.FN.Fx;
        switch (mP[trackDirection.ordinal()]) {
            case 1:
                i4 = this.FN.Fy;
                if (i4 != 10004) {
                    i5 = this.FN.Fy;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.FN.Fy;
                if (i2 != 10004) {
                    i3 = this.FN.Fy;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                iVar = this.FN.FM;
                if (iVar != null) {
                    iVar2 = this.FN.FM;
                    iVar2.at(i);
                    break;
                }
                break;
        }
        this.FW = VelocityTracker.obtain();
        this.FX = true;
        return true;
    }

    public void mN() {
        this.FX = false;
    }

    public void av(int i) {
        int i2;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        float f;
        float f2;
        int i3;
        float f3;
        int i4;
        float f4;
        int i5;
        if (this.FX) {
            i2 = this.FN.Ft;
            int i6 = i2 - i;
            int[] mP = mP();
            trackDirection = this.FN.Fx;
            switch (mP[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f4 = this.FN.Fr;
                    if (i6 > f4 - this.FN.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.FN;
                        i5 = horizontalTranslateLayout.Ft;
                        horizontalTranslateLayout.Ft = i5 - i;
                        this.FN.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f3 = this.FN.Fs;
                    if (i6 < this.FN.getMeasuredWidth() - f3 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.FN;
                        i4 = horizontalTranslateLayout2.Ft;
                        horizontalTranslateLayout2.Ft = i4 - i;
                        this.FN.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f = this.FN.Fr;
                    if (i6 >= f - this.FN.getMeasuredWidth()) {
                        f2 = this.FN.Fs;
                        if (i6 <= this.FN.getMeasuredWidth() - f2) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.FN;
                            i3 = horizontalTranslateLayout3.Ft;
                            horizontalTranslateLayout3.Ft = i3 - i;
                            this.FN.invalidate();
                            return;
                        }
                        return;
                    }
                    return;
                default:
                    return;
            }
        }
    }

    public void mO() {
        float max;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.FW.computeCurrentVelocity(this.FY);
        float xVelocity = this.FW.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.FZ);
        } else {
            max = Math.max(xVelocity, this.FZ);
        }
        int[] mP = mP();
        trackDirection = this.FN.Fx;
        switch (mP[trackDirection.ordinal()]) {
            case 1:
                h(max);
                break;
            case 2:
                i(max);
                break;
            case 3:
                g(max);
                break;
        }
        this.FW.recycle();
        this.FW = null;
    }

    private void g(float f) {
        int i;
        float f2;
        h hVar;
        h hVar2;
        float f3;
        h hVar3;
        h hVar4;
        Log.d("HorizontalTranslateLayout", "@horizontalFling");
        i = this.FN.Ft;
        if (i <= 0) {
            f3 = this.FN.Fr;
            if (i >= f3 - this.FN.getMeasuredWidth()) {
                if (f < 0.0f) {
                    hVar4 = this.FN.FH;
                    hVar4.e(f);
                    return;
                }
                hVar3 = this.FN.FH;
                hVar3.c(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.FN.Fs;
            if (i <= this.FN.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    hVar2 = this.FN.FH;
                    hVar2.d(f);
                    return;
                }
                hVar = this.FN.FH;
                hVar.f(f);
            }
        }
    }

    private void h(float f) {
        h hVar;
        h hVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            hVar2 = this.FN.FH;
            hVar2.e(f);
            return;
        }
        hVar = this.FN.FH;
        hVar.c(f);
    }

    private void i(float f) {
        h hVar;
        h hVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            hVar2 = this.FN.FH;
            hVar2.d(f);
            return;
        }
        hVar = this.FN.FH;
        hVar.f(f);
    }
}
