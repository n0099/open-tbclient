package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class l {
    private static /* synthetic */ int[] vp;
    final /* synthetic */ HorizontalTranslateLayout vc;
    VelocityTracker vl;
    boolean vm;
    final int vn;
    final int vo;

    static /* synthetic */ int[] jg() {
        int[] iArr = vp;
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
            vp = iArr;
        }
        return iArr;
    }

    public boolean az(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        h hVar;
        h hVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] jg = jg();
        trackDirection = this.vc.uM;
        switch (jg[trackDirection.ordinal()]) {
            case 1:
                i4 = this.vc.uN;
                if (i4 != 10004) {
                    i5 = this.vc.uN;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.vc.uN;
                if (i2 != 10004) {
                    i3 = this.vc.uN;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                hVar = this.vc.vb;
                if (hVar != null) {
                    hVar2 = this.vc.vb;
                    hVar2.ay(i);
                    break;
                }
                break;
        }
        this.vl = VelocityTracker.obtain();
        this.vm = true;
        return true;
    }

    public void je() {
        this.vm = false;
    }

    public void aA(int i) {
        int i2;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        float f;
        float f2;
        int i3;
        float f3;
        int i4;
        float f4;
        int i5;
        if (this.vm) {
            i2 = this.vc.uI;
            int i6 = i2 - i;
            int[] jg = jg();
            trackDirection = this.vc.uM;
            switch (jg[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f4 = this.vc.uG;
                    if (i6 > f4 - this.vc.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.vc;
                        i5 = horizontalTranslateLayout.uI;
                        horizontalTranslateLayout.uI = i5 - i;
                        this.vc.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f3 = this.vc.uH;
                    if (i6 < this.vc.getMeasuredWidth() - f3 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.vc;
                        i4 = horizontalTranslateLayout2.uI;
                        horizontalTranslateLayout2.uI = i4 - i;
                        this.vc.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f = this.vc.uG;
                    if (i6 >= f - this.vc.getMeasuredWidth()) {
                        f2 = this.vc.uH;
                        if (i6 <= this.vc.getMeasuredWidth() - f2) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.vc;
                            i3 = horizontalTranslateLayout3.uI;
                            horizontalTranslateLayout3.uI = i3 - i;
                            this.vc.invalidate();
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

    public void jf() {
        float max;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.vl.computeCurrentVelocity(this.vn);
        float xVelocity = this.vl.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.vo);
        } else {
            max = Math.max(xVelocity, this.vo);
        }
        int[] jg = jg();
        trackDirection = this.vc.uM;
        switch (jg[trackDirection.ordinal()]) {
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
        this.vl.recycle();
        this.vl = null;
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
        i = this.vc.uI;
        if (i <= 0) {
            f3 = this.vc.uG;
            if (i >= f3 - this.vc.getMeasuredWidth()) {
                if (f < 0.0f) {
                    gVar4 = this.vc.uW;
                    gVar4.e(f);
                    return;
                }
                gVar3 = this.vc.uW;
                gVar3.c(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.vc.uH;
            if (i <= this.vc.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    gVar2 = this.vc.uW;
                    gVar2.d(f);
                    return;
                }
                gVar = this.vc.uW;
                gVar.f(f);
            }
        }
    }

    private void h(float f) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            gVar2 = this.vc.uW;
            gVar2.e(f);
            return;
        }
        gVar = this.vc.uW;
        gVar.c(f);
    }

    private void i(float f) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            gVar2 = this.vc.uW;
            gVar2.d(f);
            return;
        }
        gVar = this.vc.uW;
        gVar.f(f);
    }
}
