package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class aa {
    private static /* synthetic */ int[] JH;
    VelocityTracker FW;
    boolean FX;
    final int FY;
    final int FZ;
    final /* synthetic */ VerticalTranslateLayout JF;

    static /* synthetic */ int[] oc() {
        int[] iArr = JH;
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
            JH = iArr;
        }
        return iArr;
    }

    public boolean au(int i) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        z zVar;
        z zVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] oc = oc();
        trackDirection = this.JF.Ju;
        switch (oc[trackDirection.ordinal()]) {
            case 1:
                i4 = this.JF.Fy;
                if (i4 != 10004) {
                    i5 = this.JF.Fy;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.JF.Fy;
                if (i2 != 10004) {
                    i3 = this.JF.Fy;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                zVar = this.JF.JE;
                if (zVar != null) {
                    zVar2 = this.JF.JE;
                    zVar2.aC(i);
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
        if (this.FX) {
            i2 = this.JF.Jr;
            int i10 = i2 - i;
            int[] oc = oc();
            trackDirection = this.JF.Ju;
            switch (oc[trackDirection.ordinal()]) {
                case 1:
                    Log.d("VerticalTranslateLayout", "@move top");
                    f4 = this.JF.Jn;
                    i8 = this.JF.Fp;
                    if (i10 > f4 - i8 && i10 < 0) {
                        VerticalTranslateLayout verticalTranslateLayout = this.JF;
                        i9 = verticalTranslateLayout.Jr;
                        verticalTranslateLayout.Jr = i9 - i;
                        this.JF.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("VerticalTranslateLayout", "@move bottom");
                    i6 = this.JF.Fp;
                    f3 = this.JF.Jp;
                    if (i10 < i6 - f3 && i10 > 0) {
                        VerticalTranslateLayout verticalTranslateLayout2 = this.JF;
                        i7 = verticalTranslateLayout2.Jr;
                        verticalTranslateLayout2.Jr = i7 - i;
                        this.JF.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("VerticalTranslateLayout", "@move vertical");
                    f = this.JF.Jn;
                    i3 = this.JF.Fp;
                    if (i10 >= f - i3) {
                        i4 = this.JF.Fp;
                        f2 = this.JF.Jp;
                        if (i10 <= i4 - f2) {
                            VerticalTranslateLayout verticalTranslateLayout3 = this.JF;
                            i5 = verticalTranslateLayout3.Jr;
                            verticalTranslateLayout3.Jr = i5 - i;
                            this.JF.invalidate();
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
        VerticalTranslateLayout.TrackDirection trackDirection;
        this.FW.computeCurrentVelocity(this.FY);
        float yVelocity = this.FW.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        if (yVelocity < 0.0f) {
            max = Math.min(yVelocity, -this.FZ);
        } else {
            max = Math.max(yVelocity, this.FZ);
        }
        int[] oc = oc();
        trackDirection = this.JF.Ju;
        switch (oc[trackDirection.ordinal()]) {
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
        this.FW.recycle();
        this.FW = null;
    }

    private void q(float f) {
        int i;
        int i2;
        float f2;
        v vVar;
        v vVar2;
        float f3;
        int i3;
        v vVar3;
        v vVar4;
        Log.d("VerticalTranslateLayout", "@verticalFling");
        i = this.JF.Jr;
        if (i <= 0) {
            f3 = this.JF.Jn;
            i3 = this.JF.Fp;
            if (i >= f3 - i3) {
                if (f < 0.0f) {
                    vVar4 = this.JF.JA;
                    vVar4.o(f);
                    return;
                }
                vVar3 = this.JF.JA;
                vVar3.m(f);
                return;
            }
        }
        if (i >= 0) {
            i2 = this.JF.Fp;
            f2 = this.JF.Jp;
            if (i <= i2 - f2) {
                if (f < 0.0f) {
                    vVar2 = this.JF.JA;
                    vVar2.n(f);
                    return;
                }
                vVar = this.JF.JA;
                vVar.p(f);
            }
        }
    }

    private void r(float f) {
        v vVar;
        v vVar2;
        Log.d("VerticalTranslateLayout", "@topFling");
        if (f < 0.0f) {
            vVar2 = this.JF.JA;
            vVar2.o(f);
            return;
        }
        vVar = this.JF.JA;
        vVar.m(f);
    }

    private void s(float f) {
        v vVar;
        v vVar2;
        Log.d("VerticalTranslateLayout", "@bottomFling");
        if (f < 0.0f) {
            vVar2 = this.JF.JA;
            vVar2.n(f);
            return;
        }
        vVar = this.JF.JA;
        vVar.p(f);
    }
}
