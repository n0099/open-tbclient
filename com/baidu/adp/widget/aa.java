package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class aa {
    private static /* synthetic */ int[] JO;
    VelocityTracker Gf;
    boolean Gg;
    final int Gh;
    final int Gi;
    final /* synthetic */ VerticalTranslateLayout JM;

    static /* synthetic */ int[] nL() {
        int[] iArr = JO;
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
            JO = iArr;
        }
        return iArr;
    }

    public boolean aw(int i) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        z zVar;
        z zVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] nL = nL();
        trackDirection = this.JM.JB;
        switch (nL[trackDirection.ordinal()]) {
            case 1:
                i4 = this.JM.FH;
                if (i4 != 10004) {
                    i5 = this.JM.FH;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.JM.FH;
                if (i2 != 10004) {
                    i3 = this.JM.FH;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                zVar = this.JM.JL;
                if (zVar != null) {
                    zVar2 = this.JM.JL;
                    zVar2.aE(i);
                    break;
                }
                break;
        }
        this.Gf = VelocityTracker.obtain();
        this.Gg = true;
        return true;
    }

    public void mu() {
        this.Gg = false;
    }

    public void ax(int i) {
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
        if (this.Gg) {
            i2 = this.JM.Jy;
            int i10 = i2 - i;
            int[] nL = nL();
            trackDirection = this.JM.JB;
            switch (nL[trackDirection.ordinal()]) {
                case 1:
                    Log.d("VerticalTranslateLayout", "@move top");
                    f4 = this.JM.Ju;
                    i8 = this.JM.Fy;
                    if (i10 > f4 - i8 && i10 < 0) {
                        VerticalTranslateLayout verticalTranslateLayout = this.JM;
                        i9 = verticalTranslateLayout.Jy;
                        verticalTranslateLayout.Jy = i9 - i;
                        this.JM.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("VerticalTranslateLayout", "@move bottom");
                    i6 = this.JM.Fy;
                    f3 = this.JM.Jw;
                    if (i10 < i6 - f3 && i10 > 0) {
                        VerticalTranslateLayout verticalTranslateLayout2 = this.JM;
                        i7 = verticalTranslateLayout2.Jy;
                        verticalTranslateLayout2.Jy = i7 - i;
                        this.JM.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("VerticalTranslateLayout", "@move vertical");
                    f = this.JM.Ju;
                    i3 = this.JM.Fy;
                    if (i10 >= f - i3) {
                        i4 = this.JM.Fy;
                        f2 = this.JM.Jw;
                        if (i10 <= i4 - f2) {
                            VerticalTranslateLayout verticalTranslateLayout3 = this.JM;
                            i5 = verticalTranslateLayout3.Jy;
                            verticalTranslateLayout3.Jy = i5 - i;
                            this.JM.invalidate();
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
        VerticalTranslateLayout.TrackDirection trackDirection;
        this.Gf.computeCurrentVelocity(this.Gh);
        float yVelocity = this.Gf.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        if (yVelocity < 0.0f) {
            max = Math.min(yVelocity, -this.Gi);
        } else {
            max = Math.max(yVelocity, this.Gi);
        }
        int[] nL = nL();
        trackDirection = this.JM.JB;
        switch (nL[trackDirection.ordinal()]) {
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
        this.Gf.recycle();
        this.Gf = null;
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
        i = this.JM.Jy;
        if (i <= 0) {
            f3 = this.JM.Ju;
            i3 = this.JM.Fy;
            if (i >= f3 - i3) {
                if (f < 0.0f) {
                    vVar4 = this.JM.JH;
                    vVar4.o(f);
                    return;
                }
                vVar3 = this.JM.JH;
                vVar3.m(f);
                return;
            }
        }
        if (i >= 0) {
            i2 = this.JM.Fy;
            f2 = this.JM.Jw;
            if (i <= i2 - f2) {
                if (f < 0.0f) {
                    vVar2 = this.JM.JH;
                    vVar2.n(f);
                    return;
                }
                vVar = this.JM.JH;
                vVar.p(f);
            }
        }
    }

    private void r(float f) {
        v vVar;
        v vVar2;
        Log.d("VerticalTranslateLayout", "@topFling");
        if (f < 0.0f) {
            vVar2 = this.JM.JH;
            vVar2.o(f);
            return;
        }
        vVar = this.JM.JH;
        vVar.m(f);
    }

    private void s(float f) {
        v vVar;
        v vVar2;
        Log.d("VerticalTranslateLayout", "@bottomFling");
        if (f < 0.0f) {
            vVar2 = this.JM.JH;
            vVar2.n(f);
            return;
        }
        vVar = this.JM.JH;
        vVar.p(f);
    }
}
