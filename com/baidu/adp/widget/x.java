package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class x {
    private static /* synthetic */ int[] yW;
    VelocityTracker vi;
    boolean vj;
    final int vk;
    final int vl;
    final /* synthetic */ VerticalTranslateLayout yU;

    static /* synthetic */ int[] ko() {
        int[] iArr = yW;
        if (iArr == null) {
            iArr = new int[VerticalTranslateLayout.TrackDirection.valuesCustom().length];
            try {
                iArr[VerticalTranslateLayout.TrackDirection.bottom.ordinal()] = 2;
            } catch (NoSuchFieldError e) {
            }
            try {
                iArr[VerticalTranslateLayout.TrackDirection.none.ordinal()] = 4;
            } catch (NoSuchFieldError e2) {
            }
            try {
                iArr[VerticalTranslateLayout.TrackDirection.top.ordinal()] = 1;
            } catch (NoSuchFieldError e3) {
            }
            try {
                iArr[VerticalTranslateLayout.TrackDirection.vertical.ordinal()] = 3;
            } catch (NoSuchFieldError e4) {
            }
            yW = iArr;
        }
        return iArr;
    }

    public boolean az(int i) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        w wVar;
        w wVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] ko = ko();
        trackDirection = this.yU.yJ;
        switch (ko[trackDirection.ordinal()]) {
            case 1:
                i4 = this.yU.uK;
                if (i4 != 10004) {
                    i5 = this.yU.uK;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.yU.uK;
                if (i2 != 10004) {
                    i3 = this.yU.uK;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                wVar = this.yU.yT;
                if (wVar != null) {
                    wVar2 = this.yU.yT;
                    wVar2.aH(i);
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
        VerticalTranslateLayout.TrackDirection trackDirection;
        float f;
        int i3;
        int i4;
        float f2;
        int i5;
        int i6;
        float f3;
        int i7;
        float f4;
        int i8;
        int i9;
        if (this.vj) {
            i2 = this.yU.yG;
            int i10 = i2 - i;
            int[] ko = ko();
            trackDirection = this.yU.yJ;
            switch (ko[trackDirection.ordinal()]) {
                case 1:
                    Log.d("VerticalTranslateLayout", "@move top");
                    f4 = this.yU.yC;
                    i8 = this.yU.uB;
                    if (i10 > f4 - i8 && i10 < 0) {
                        VerticalTranslateLayout verticalTranslateLayout = this.yU;
                        i9 = verticalTranslateLayout.yG;
                        verticalTranslateLayout.yG = i9 - i;
                        this.yU.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("VerticalTranslateLayout", "@move bottom");
                    i6 = this.yU.uB;
                    f3 = this.yU.yE;
                    if (i10 < i6 - f3 && i10 > 0) {
                        VerticalTranslateLayout verticalTranslateLayout2 = this.yU;
                        i7 = verticalTranslateLayout2.yG;
                        verticalTranslateLayout2.yG = i7 - i;
                        this.yU.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("VerticalTranslateLayout", "@move vertical");
                    f = this.yU.yC;
                    i3 = this.yU.uB;
                    if (i10 >= f - i3) {
                        i4 = this.yU.uB;
                        f2 = this.yU.yE;
                        if (i10 <= i4 - f2) {
                            VerticalTranslateLayout verticalTranslateLayout3 = this.yU;
                            i5 = verticalTranslateLayout3.yG;
                            verticalTranslateLayout3.yG = i5 - i;
                            this.yU.invalidate();
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
        VerticalTranslateLayout.TrackDirection trackDirection;
        this.vi.computeCurrentVelocity(this.vk);
        float yVelocity = this.vi.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        if (yVelocity < 0.0f) {
            max = Math.min(yVelocity, -this.vl);
        } else {
            max = Math.max(yVelocity, this.vl);
        }
        int[] ko = ko();
        trackDirection = this.yU.yJ;
        switch (ko[trackDirection.ordinal()]) {
            case 1:
                r(max);
                break;
            case 2:
                s(max);
                break;
            case 3:
                q(max);
                break;
        }
        this.vi.recycle();
        this.vi = null;
    }

    private void q(float f) {
        int i;
        int i2;
        float f2;
        s sVar;
        s sVar2;
        float f3;
        int i3;
        s sVar3;
        s sVar4;
        Log.d("VerticalTranslateLayout", "@verticalFling");
        i = this.yU.yG;
        if (i <= 0) {
            f3 = this.yU.yC;
            i3 = this.yU.uB;
            if (i >= f3 - i3) {
                if (f < 0.0f) {
                    sVar4 = this.yU.yP;
                    sVar4.o(f);
                    return;
                }
                sVar3 = this.yU.yP;
                sVar3.m(f);
                return;
            }
        }
        if (i >= 0) {
            i2 = this.yU.uB;
            f2 = this.yU.yE;
            if (i <= i2 - f2) {
                if (f < 0.0f) {
                    sVar2 = this.yU.yP;
                    sVar2.n(f);
                    return;
                }
                sVar = this.yU.yP;
                sVar.p(f);
            }
        }
    }

    private void r(float f) {
        s sVar;
        s sVar2;
        Log.d("VerticalTranslateLayout", "@topFling");
        if (f < 0.0f) {
            sVar2 = this.yU.yP;
            sVar2.o(f);
            return;
        }
        sVar = this.yU.yP;
        sVar.m(f);
    }

    private void s(float f) {
        s sVar;
        s sVar2;
        Log.d("VerticalTranslateLayout", "@bottomFling");
        if (f < 0.0f) {
            sVar2 = this.yU.yP;
            sVar2.n(f);
            return;
        }
        sVar = this.yU.yP;
        sVar.p(f);
    }
}
