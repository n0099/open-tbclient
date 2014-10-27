package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class l {
    private static /* synthetic */ int[] sW;
    final /* synthetic */ HorizontalTranslateLayout sJ;
    VelocityTracker sS;
    boolean sT;
    final int sU;
    final int sV;

    static /* synthetic */ int[] hi() {
        int[] iArr = sW;
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
            sW = iArr;
        }
        return iArr;
    }

    public boolean ae(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        h hVar;
        h hVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] hi = hi();
        trackDirection = this.sJ.st;
        switch (hi[trackDirection.ordinal()]) {
            case 1:
                i4 = this.sJ.su;
                if (i4 != 10004) {
                    i5 = this.sJ.su;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.sJ.su;
                if (i2 != 10004) {
                    i3 = this.sJ.su;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                hVar = this.sJ.sI;
                if (hVar != null) {
                    hVar2 = this.sJ.sI;
                    hVar2.ad(i);
                    break;
                }
                break;
        }
        this.sS = VelocityTracker.obtain();
        this.sT = true;
        return true;
    }

    public void hg() {
        this.sT = false;
    }

    public void af(int i) {
        int i2;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        float f;
        float f2;
        int i3;
        float f3;
        int i4;
        float f4;
        int i5;
        if (this.sT) {
            i2 = this.sJ.so;
            int i6 = i2 - i;
            int[] hi = hi();
            trackDirection = this.sJ.st;
            switch (hi[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f4 = this.sJ.sm;
                    if (i6 > f4 - this.sJ.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.sJ;
                        i5 = horizontalTranslateLayout.so;
                        horizontalTranslateLayout.so = i5 - i;
                        this.sJ.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f3 = this.sJ.sn;
                    if (i6 < this.sJ.getMeasuredWidth() - f3 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.sJ;
                        i4 = horizontalTranslateLayout2.so;
                        horizontalTranslateLayout2.so = i4 - i;
                        this.sJ.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f = this.sJ.sm;
                    if (i6 >= f - this.sJ.getMeasuredWidth()) {
                        f2 = this.sJ.sn;
                        if (i6 <= this.sJ.getMeasuredWidth() - f2) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.sJ;
                            i3 = horizontalTranslateLayout3.so;
                            horizontalTranslateLayout3.so = i3 - i;
                            this.sJ.invalidate();
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

    public void hh() {
        float max;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.sS.computeCurrentVelocity(this.sU);
        float xVelocity = this.sS.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.sV);
        } else {
            max = Math.max(xVelocity, this.sV);
        }
        int[] hi = hi();
        trackDirection = this.sJ.st;
        switch (hi[trackDirection.ordinal()]) {
            case 1:
                g(max);
                break;
            case 2:
                h(max);
                break;
            case 3:
                f(max);
                break;
        }
        this.sS.recycle();
        this.sS = null;
    }

    private void f(float f) {
        int i;
        float f2;
        g gVar;
        g gVar2;
        float f3;
        g gVar3;
        g gVar4;
        Log.d("HorizontalTranslateLayout", "@horizontalFling");
        i = this.sJ.so;
        if (i <= 0) {
            f3 = this.sJ.sm;
            if (i >= f3 - this.sJ.getMeasuredWidth()) {
                if (f < 0.0f) {
                    gVar4 = this.sJ.sD;
                    gVar4.d(f);
                    return;
                }
                gVar3 = this.sJ.sD;
                gVar3.b(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.sJ.sn;
            if (i <= this.sJ.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    gVar2 = this.sJ.sD;
                    gVar2.c(f);
                    return;
                }
                gVar = this.sJ.sD;
                gVar.e(f);
            }
        }
    }

    private void g(float f) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            gVar2 = this.sJ.sD;
            gVar2.d(f);
            return;
        }
        gVar = this.sJ.sD;
        gVar.b(f);
    }

    private void h(float f) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            gVar2 = this.sJ.sD;
            gVar2.c(f);
            return;
        }
        gVar = this.sJ.sD;
        gVar.e(f);
    }
}
