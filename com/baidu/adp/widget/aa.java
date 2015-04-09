package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class aa {
    private static /* synthetic */ int[] JQ;
    VelocityTracker Gh;
    boolean Gi;
    final int Gj;
    final int Gk;
    final /* synthetic */ VerticalTranslateLayout JO;

    static /* synthetic */ int[] nL() {
        int[] iArr = JQ;
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
            JQ = iArr;
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
        trackDirection = this.JO.JD;
        switch (nL[trackDirection.ordinal()]) {
            case 1:
                i4 = this.JO.FJ;
                if (i4 != 10004) {
                    i5 = this.JO.FJ;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.JO.FJ;
                if (i2 != 10004) {
                    i3 = this.JO.FJ;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                zVar = this.JO.JN;
                if (zVar != null) {
                    zVar2 = this.JO.JN;
                    zVar2.aE(i);
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
        if (this.Gi) {
            i2 = this.JO.JA;
            int i10 = i2 - i;
            int[] nL = nL();
            trackDirection = this.JO.JD;
            switch (nL[trackDirection.ordinal()]) {
                case 1:
                    Log.d("VerticalTranslateLayout", "@move top");
                    f4 = this.JO.Jw;
                    i8 = this.JO.FA;
                    if (i10 > f4 - i8 && i10 < 0) {
                        VerticalTranslateLayout verticalTranslateLayout = this.JO;
                        i9 = verticalTranslateLayout.JA;
                        verticalTranslateLayout.JA = i9 - i;
                        this.JO.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("VerticalTranslateLayout", "@move bottom");
                    i6 = this.JO.FA;
                    f3 = this.JO.Jy;
                    if (i10 < i6 - f3 && i10 > 0) {
                        VerticalTranslateLayout verticalTranslateLayout2 = this.JO;
                        i7 = verticalTranslateLayout2.JA;
                        verticalTranslateLayout2.JA = i7 - i;
                        this.JO.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("VerticalTranslateLayout", "@move vertical");
                    f = this.JO.Jw;
                    i3 = this.JO.FA;
                    if (i10 >= f - i3) {
                        i4 = this.JO.FA;
                        f2 = this.JO.Jy;
                        if (i10 <= i4 - f2) {
                            VerticalTranslateLayout verticalTranslateLayout3 = this.JO;
                            i5 = verticalTranslateLayout3.JA;
                            verticalTranslateLayout3.JA = i5 - i;
                            this.JO.invalidate();
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
        this.Gh.computeCurrentVelocity(this.Gj);
        float yVelocity = this.Gh.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        if (yVelocity < 0.0f) {
            max = Math.min(yVelocity, -this.Gk);
        } else {
            max = Math.max(yVelocity, this.Gk);
        }
        int[] nL = nL();
        trackDirection = this.JO.JD;
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
        this.Gh.recycle();
        this.Gh = null;
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
        i = this.JO.JA;
        if (i <= 0) {
            f3 = this.JO.Jw;
            i3 = this.JO.FA;
            if (i >= f3 - i3) {
                if (f < 0.0f) {
                    vVar4 = this.JO.JJ;
                    vVar4.o(f);
                    return;
                }
                vVar3 = this.JO.JJ;
                vVar3.m(f);
                return;
            }
        }
        if (i >= 0) {
            i2 = this.JO.FA;
            f2 = this.JO.Jy;
            if (i <= i2 - f2) {
                if (f < 0.0f) {
                    vVar2 = this.JO.JJ;
                    vVar2.n(f);
                    return;
                }
                vVar = this.JO.JJ;
                vVar.p(f);
            }
        }
    }

    private void r(float f) {
        v vVar;
        v vVar2;
        Log.d("VerticalTranslateLayout", "@topFling");
        if (f < 0.0f) {
            vVar2 = this.JO.JJ;
            vVar2.o(f);
            return;
        }
        vVar = this.JO.JJ;
        vVar.m(f);
    }

    private void s(float f) {
        v vVar;
        v vVar2;
        Log.d("VerticalTranslateLayout", "@bottomFling");
        if (f < 0.0f) {
            vVar2 = this.JO.JJ;
            vVar2.n(f);
            return;
        }
        vVar = this.JO.JJ;
        vVar.p(f);
    }
}
