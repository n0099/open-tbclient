package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class m {
    private static /* synthetic */ int[] Gl;
    final /* synthetic */ HorizontalTranslateLayout FY;
    VelocityTracker Gh;
    boolean Gi;
    final int Gj;
    final int Gk;

    static /* synthetic */ int[] mw() {
        int[] iArr = Gl;
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
            Gl = iArr;
        }
        return iArr;
    }

    public boolean aw(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        i iVar;
        i iVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] mw = mw();
        trackDirection = this.FY.FI;
        switch (mw[trackDirection.ordinal()]) {
            case 1:
                i4 = this.FY.FJ;
                if (i4 != 10004) {
                    i5 = this.FY.FJ;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.FY.FJ;
                if (i2 != 10004) {
                    i3 = this.FY.FJ;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                iVar = this.FY.FX;
                if (iVar != null) {
                    iVar2 = this.FY.FX;
                    iVar2.av(i);
                    break;
                }
                break;
        }
        this.Gh = VelocityTracker.obtain();
        this.Gi = true;
        return true;
    }

    public void mu() {
        this.Gi = false;
    }

    public void ax(int i) {
        int i2;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        float f;
        float f2;
        int i3;
        float f3;
        int i4;
        float f4;
        int i5;
        if (this.Gi) {
            i2 = this.FY.FE;
            int i6 = i2 - i;
            int[] mw = mw();
            trackDirection = this.FY.FI;
            switch (mw[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f4 = this.FY.FC;
                    if (i6 > f4 - this.FY.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.FY;
                        i5 = horizontalTranslateLayout.FE;
                        horizontalTranslateLayout.FE = i5 - i;
                        this.FY.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f3 = this.FY.FD;
                    if (i6 < this.FY.getMeasuredWidth() - f3 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.FY;
                        i4 = horizontalTranslateLayout2.FE;
                        horizontalTranslateLayout2.FE = i4 - i;
                        this.FY.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f = this.FY.FC;
                    if (i6 >= f - this.FY.getMeasuredWidth()) {
                        f2 = this.FY.FD;
                        if (i6 <= this.FY.getMeasuredWidth() - f2) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.FY;
                            i3 = horizontalTranslateLayout3.FE;
                            horizontalTranslateLayout3.FE = i3 - i;
                            this.FY.invalidate();
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

    public void mv() {
        float max;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.Gh.computeCurrentVelocity(this.Gj);
        float xVelocity = this.Gh.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.Gk);
        } else {
            max = Math.max(xVelocity, this.Gk);
        }
        int[] mw = mw();
        trackDirection = this.FY.FI;
        switch (mw[trackDirection.ordinal()]) {
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
        this.Gh.recycle();
        this.Gh = null;
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
        i = this.FY.FE;
        if (i <= 0) {
            f3 = this.FY.FC;
            if (i >= f3 - this.FY.getMeasuredWidth()) {
                if (f < 0.0f) {
                    hVar4 = this.FY.FS;
                    hVar4.e(f);
                    return;
                }
                hVar3 = this.FY.FS;
                hVar3.c(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.FY.FD;
            if (i <= this.FY.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    hVar2 = this.FY.FS;
                    hVar2.d(f);
                    return;
                }
                hVar = this.FY.FS;
                hVar.f(f);
            }
        }
    }

    private void h(float f) {
        h hVar;
        h hVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            hVar2 = this.FY.FS;
            hVar2.e(f);
            return;
        }
        hVar = this.FY.FS;
        hVar.c(f);
    }

    private void i(float f) {
        h hVar;
        h hVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            hVar2 = this.FY.FS;
            hVar2.d(f);
            return;
        }
        hVar = this.FY.FS;
        hVar.f(f);
    }
}
