package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class x {
    private static /* synthetic */ int[] yZ;
    VelocityTracker vf;
    boolean vg;
    final int vh;
    final int vi;
    final /* synthetic */ VerticalTranslateLayout yX;

    static /* synthetic */ int[] kv() {
        int[] iArr = yZ;
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
            yZ = iArr;
        }
        return iArr;
    }

    public boolean au(int i) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        w wVar;
        w wVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] kv = kv();
        trackDirection = this.yX.yM;
        switch (kv[trackDirection.ordinal()]) {
            case 1:
                i4 = this.yX.uH;
                if (i4 != 10004) {
                    i5 = this.yX.uH;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.yX.uH;
                if (i2 != 10004) {
                    i3 = this.yX.uH;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                wVar = this.yX.yW;
                if (wVar != null) {
                    wVar2 = this.yX.yW;
                    wVar2.aC(i);
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
        if (this.vg) {
            i2 = this.yX.yJ;
            int i10 = i2 - i;
            int[] kv = kv();
            trackDirection = this.yX.yM;
            switch (kv[trackDirection.ordinal()]) {
                case 1:
                    Log.d("VerticalTranslateLayout", "@move top");
                    f4 = this.yX.yF;
                    i8 = this.yX.uy;
                    if (i10 > f4 - i8 && i10 < 0) {
                        VerticalTranslateLayout verticalTranslateLayout = this.yX;
                        i9 = verticalTranslateLayout.yJ;
                        verticalTranslateLayout.yJ = i9 - i;
                        this.yX.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("VerticalTranslateLayout", "@move bottom");
                    i6 = this.yX.uy;
                    f3 = this.yX.yH;
                    if (i10 < i6 - f3 && i10 > 0) {
                        VerticalTranslateLayout verticalTranslateLayout2 = this.yX;
                        i7 = verticalTranslateLayout2.yJ;
                        verticalTranslateLayout2.yJ = i7 - i;
                        this.yX.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("VerticalTranslateLayout", "@move vertical");
                    f = this.yX.yF;
                    i3 = this.yX.uy;
                    if (i10 >= f - i3) {
                        i4 = this.yX.uy;
                        f2 = this.yX.yH;
                        if (i10 <= i4 - f2) {
                            VerticalTranslateLayout verticalTranslateLayout3 = this.yX;
                            i5 = verticalTranslateLayout3.yJ;
                            verticalTranslateLayout3.yJ = i5 - i;
                            this.yX.invalidate();
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
        VerticalTranslateLayout.TrackDirection trackDirection;
        this.vf.computeCurrentVelocity(this.vh);
        float yVelocity = this.vf.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        if (yVelocity < 0.0f) {
            max = Math.min(yVelocity, -this.vi);
        } else {
            max = Math.max(yVelocity, this.vi);
        }
        int[] kv = kv();
        trackDirection = this.yX.yM;
        switch (kv[trackDirection.ordinal()]) {
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
        this.vf.recycle();
        this.vf = null;
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
        i = this.yX.yJ;
        if (i <= 0) {
            f3 = this.yX.yF;
            i3 = this.yX.uy;
            if (i >= f3 - i3) {
                if (f < 0.0f) {
                    sVar4 = this.yX.yS;
                    sVar4.o(f);
                    return;
                }
                sVar3 = this.yX.yS;
                sVar3.m(f);
                return;
            }
        }
        if (i >= 0) {
            i2 = this.yX.uy;
            f2 = this.yX.yH;
            if (i <= i2 - f2) {
                if (f < 0.0f) {
                    sVar2 = this.yX.yS;
                    sVar2.n(f);
                    return;
                }
                sVar = this.yX.yS;
                sVar.p(f);
            }
        }
    }

    private void r(float f) {
        s sVar;
        s sVar2;
        Log.d("VerticalTranslateLayout", "@topFling");
        if (f < 0.0f) {
            sVar2 = this.yX.yS;
            sVar2.o(f);
            return;
        }
        sVar = this.yX.yS;
        sVar.m(f);
    }

    private void s(float f) {
        s sVar;
        s sVar2;
        Log.d("VerticalTranslateLayout", "@bottomFling");
        if (f < 0.0f) {
            sVar2 = this.yX.yS;
            sVar2.n(f);
            return;
        }
        sVar = this.yX.yS;
        sVar.p(f);
    }
}
