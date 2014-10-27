package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class x {
    private static /* synthetic */ int[] wX;
    VelocityTracker sS;
    boolean sT;
    final int sU;
    final int sV;
    final /* synthetic */ VerticalTranslateLayout wV;

    static /* synthetic */ int[] iG() {
        int[] iArr = wX;
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
            wX = iArr;
        }
        return iArr;
    }

    public boolean ae(int i) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        w wVar;
        w wVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iG = iG();
        trackDirection = this.wV.wK;
        switch (iG[trackDirection.ordinal()]) {
            case 1:
                i4 = this.wV.su;
                if (i4 != 10004) {
                    i5 = this.wV.su;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.wV.su;
                if (i2 != 10004) {
                    i3 = this.wV.su;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                wVar = this.wV.wU;
                if (wVar != null) {
                    wVar2 = this.wV.wU;
                    wVar2.an(i);
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
        if (this.sT) {
            i2 = this.wV.wH;
            int i10 = i2 - i;
            int[] iG = iG();
            trackDirection = this.wV.wK;
            switch (iG[trackDirection.ordinal()]) {
                case 1:
                    Log.d("VerticalTranslateLayout", "@move top");
                    f4 = this.wV.wD;
                    i8 = this.wV.sk;
                    if (i10 > f4 - i8 && i10 < 0) {
                        VerticalTranslateLayout verticalTranslateLayout = this.wV;
                        i9 = verticalTranslateLayout.wH;
                        verticalTranslateLayout.wH = i9 - i;
                        this.wV.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("VerticalTranslateLayout", "@move bottom");
                    i6 = this.wV.sk;
                    f3 = this.wV.wF;
                    if (i10 < i6 - f3 && i10 > 0) {
                        VerticalTranslateLayout verticalTranslateLayout2 = this.wV;
                        i7 = verticalTranslateLayout2.wH;
                        verticalTranslateLayout2.wH = i7 - i;
                        this.wV.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("VerticalTranslateLayout", "@move vertical");
                    f = this.wV.wD;
                    i3 = this.wV.sk;
                    if (i10 >= f - i3) {
                        i4 = this.wV.sk;
                        f2 = this.wV.wF;
                        if (i10 <= i4 - f2) {
                            VerticalTranslateLayout verticalTranslateLayout3 = this.wV;
                            i5 = verticalTranslateLayout3.wH;
                            verticalTranslateLayout3.wH = i5 - i;
                            this.wV.invalidate();
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
        VerticalTranslateLayout.TrackDirection trackDirection;
        this.sS.computeCurrentVelocity(this.sU);
        float yVelocity = this.sS.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        if (yVelocity < 0.0f) {
            max = Math.min(yVelocity, -this.sV);
        } else {
            max = Math.max(yVelocity, this.sV);
        }
        int[] iG = iG();
        trackDirection = this.wV.wK;
        switch (iG[trackDirection.ordinal()]) {
            case 1:
                q(max);
                break;
            case 2:
                r(max);
                break;
            case 3:
                p(max);
                break;
        }
        this.sS.recycle();
        this.sS = null;
    }

    private void p(float f) {
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
        i = this.wV.wH;
        if (i <= 0) {
            f3 = this.wV.wD;
            i3 = this.wV.sk;
            if (i >= f3 - i3) {
                if (f < 0.0f) {
                    sVar4 = this.wV.wQ;
                    sVar4.n(f);
                    return;
                }
                sVar3 = this.wV.wQ;
                sVar3.l(f);
                return;
            }
        }
        if (i >= 0) {
            i2 = this.wV.sk;
            f2 = this.wV.wF;
            if (i <= i2 - f2) {
                if (f < 0.0f) {
                    sVar2 = this.wV.wQ;
                    sVar2.m(f);
                    return;
                }
                sVar = this.wV.wQ;
                sVar.o(f);
            }
        }
    }

    private void q(float f) {
        s sVar;
        s sVar2;
        Log.d("VerticalTranslateLayout", "@topFling");
        if (f < 0.0f) {
            sVar2 = this.wV.wQ;
            sVar2.n(f);
            return;
        }
        sVar = this.wV.wQ;
        sVar.l(f);
    }

    private void r(float f) {
        s sVar;
        s sVar2;
        Log.d("VerticalTranslateLayout", "@bottomFling");
        if (f < 0.0f) {
            sVar2 = this.wV.wQ;
            sVar2.m(f);
            return;
        }
        sVar = this.wV.wQ;
        sVar.o(f);
    }
}
