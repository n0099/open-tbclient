package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class l {
    private static /* synthetic */ int[] vm;
    final /* synthetic */ HorizontalTranslateLayout uZ;
    VelocityTracker vi;
    boolean vj;
    final int vk;
    final int vl;

    static /* synthetic */ int[] iZ() {
        int[] iArr = vm;
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
            vm = iArr;
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
        int[] iZ = iZ();
        trackDirection = this.uZ.uJ;
        switch (iZ[trackDirection.ordinal()]) {
            case 1:
                i4 = this.uZ.uK;
                if (i4 != 10004) {
                    i5 = this.uZ.uK;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.uZ.uK;
                if (i2 != 10004) {
                    i3 = this.uZ.uK;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                hVar = this.uZ.uY;
                if (hVar != null) {
                    hVar2 = this.uZ.uY;
                    hVar2.ay(i);
                    break;
                }
                break;
        }
        this.vi = VelocityTracker.obtain();
        this.vj = true;
        return true;
    }

    public void iX() {
        this.vj = false;
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
        if (this.vj) {
            i2 = this.uZ.uF;
            int i6 = i2 - i;
            int[] iZ = iZ();
            trackDirection = this.uZ.uJ;
            switch (iZ[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f4 = this.uZ.uD;
                    if (i6 > f4 - this.uZ.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.uZ;
                        i5 = horizontalTranslateLayout.uF;
                        horizontalTranslateLayout.uF = i5 - i;
                        this.uZ.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f3 = this.uZ.uE;
                    if (i6 < this.uZ.getMeasuredWidth() - f3 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.uZ;
                        i4 = horizontalTranslateLayout2.uF;
                        horizontalTranslateLayout2.uF = i4 - i;
                        this.uZ.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f = this.uZ.uD;
                    if (i6 >= f - this.uZ.getMeasuredWidth()) {
                        f2 = this.uZ.uE;
                        if (i6 <= this.uZ.getMeasuredWidth() - f2) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.uZ;
                            i3 = horizontalTranslateLayout3.uF;
                            horizontalTranslateLayout3.uF = i3 - i;
                            this.uZ.invalidate();
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

    public void iY() {
        float max;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.vi.computeCurrentVelocity(this.vk);
        float xVelocity = this.vi.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.vl);
        } else {
            max = Math.max(xVelocity, this.vl);
        }
        int[] iZ = iZ();
        trackDirection = this.uZ.uJ;
        switch (iZ[trackDirection.ordinal()]) {
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
        this.vi.recycle();
        this.vi = null;
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
        i = this.uZ.uF;
        if (i <= 0) {
            f3 = this.uZ.uD;
            if (i >= f3 - this.uZ.getMeasuredWidth()) {
                if (f < 0.0f) {
                    gVar4 = this.uZ.uT;
                    gVar4.e(f);
                    return;
                }
                gVar3 = this.uZ.uT;
                gVar3.c(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.uZ.uE;
            if (i <= this.uZ.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    gVar2 = this.uZ.uT;
                    gVar2.d(f);
                    return;
                }
                gVar = this.uZ.uT;
                gVar.f(f);
            }
        }
    }

    private void h(float f) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            gVar2 = this.uZ.uT;
            gVar2.e(f);
            return;
        }
        gVar = this.uZ.uT;
        gVar.c(f);
    }

    private void i(float f) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            gVar2 = this.uZ.uT;
            gVar2.d(f);
            return;
        }
        gVar = this.uZ.uT;
        gVar.f(f);
    }
}
