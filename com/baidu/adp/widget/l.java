package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class l {
    private static /* synthetic */ int[] vj;
    final /* synthetic */ HorizontalTranslateLayout uW;
    VelocityTracker vf;
    boolean vg;
    final int vh;
    final int vi;

    static /* synthetic */ int[] jf() {
        int[] iArr = vj;
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
            vj = iArr;
        }
        return iArr;
    }

    public boolean au(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        h hVar;
        h hVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] jf = jf();
        trackDirection = this.uW.uG;
        switch (jf[trackDirection.ordinal()]) {
            case 1:
                i4 = this.uW.uH;
                if (i4 != 10004) {
                    i5 = this.uW.uH;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.uW.uH;
                if (i2 != 10004) {
                    i3 = this.uW.uH;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                hVar = this.uW.uV;
                if (hVar != null) {
                    hVar2 = this.uW.uV;
                    hVar2.at(i);
                    break;
                }
                break;
        }
        this.vf = VelocityTracker.obtain();
        this.vg = true;
        return true;
    }

    public void jd() {
        this.vg = false;
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
        if (this.vg) {
            i2 = this.uW.uC;
            int i6 = i2 - i;
            int[] jf = jf();
            trackDirection = this.uW.uG;
            switch (jf[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f4 = this.uW.uA;
                    if (i6 > f4 - this.uW.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.uW;
                        i5 = horizontalTranslateLayout.uC;
                        horizontalTranslateLayout.uC = i5 - i;
                        this.uW.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f3 = this.uW.uB;
                    if (i6 < this.uW.getMeasuredWidth() - f3 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.uW;
                        i4 = horizontalTranslateLayout2.uC;
                        horizontalTranslateLayout2.uC = i4 - i;
                        this.uW.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f = this.uW.uA;
                    if (i6 >= f - this.uW.getMeasuredWidth()) {
                        f2 = this.uW.uB;
                        if (i6 <= this.uW.getMeasuredWidth() - f2) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.uW;
                            i3 = horizontalTranslateLayout3.uC;
                            horizontalTranslateLayout3.uC = i3 - i;
                            this.uW.invalidate();
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

    public void je() {
        float max;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.vf.computeCurrentVelocity(this.vh);
        float xVelocity = this.vf.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.vi);
        } else {
            max = Math.max(xVelocity, this.vi);
        }
        int[] jf = jf();
        trackDirection = this.uW.uG;
        switch (jf[trackDirection.ordinal()]) {
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
        this.vf.recycle();
        this.vf = null;
    }

    private void g(float f) {
        int i;
        float f2;
        g gVar;
        g gVar2;
        float f3;
        g gVar3;
        g gVar4;
        Log.d("HorizontalTranslateLayout", "@horizontalFling");
        i = this.uW.uC;
        if (i <= 0) {
            f3 = this.uW.uA;
            if (i >= f3 - this.uW.getMeasuredWidth()) {
                if (f < 0.0f) {
                    gVar4 = this.uW.uQ;
                    gVar4.e(f);
                    return;
                }
                gVar3 = this.uW.uQ;
                gVar3.c(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.uW.uB;
            if (i <= this.uW.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    gVar2 = this.uW.uQ;
                    gVar2.d(f);
                    return;
                }
                gVar = this.uW.uQ;
                gVar.f(f);
            }
        }
    }

    private void h(float f) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            gVar2 = this.uW.uQ;
            gVar2.e(f);
            return;
        }
        gVar = this.uW.uQ;
        gVar.c(f);
    }

    private void i(float f) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            gVar2 = this.uW.uQ;
            gVar2.d(f);
            return;
        }
        gVar = this.uW.uQ;
        gVar.f(f);
    }
}
