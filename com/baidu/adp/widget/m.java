package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class m {
    private static /* synthetic */ int[] Gj;
    final /* synthetic */ HorizontalTranslateLayout FW;
    VelocityTracker Gf;
    boolean Gg;
    final int Gh;
    final int Gi;

    static /* synthetic */ int[] mw() {
        int[] iArr = Gj;
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
            Gj = iArr;
        }
        return iArr;
    }

    public boolean aw(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        i iVar;
        i iVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] mw = mw();
        trackDirection = this.FW.FG;
        switch (mw[trackDirection.ordinal()]) {
            case 1:
                i4 = this.FW.FH;
                if (i4 != 10004) {
                    i5 = this.FW.FH;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.FW.FH;
                if (i2 != 10004) {
                    i3 = this.FW.FH;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                iVar = this.FW.FV;
                if (iVar != null) {
                    iVar2 = this.FW.FV;
                    iVar2.av(i);
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
        HorizontalTranslateLayout.TrackDirection trackDirection;
        float f;
        float f2;
        int i3;
        float f3;
        int i4;
        float f4;
        int i5;
        if (this.Gg) {
            i2 = this.FW.FC;
            int i6 = i2 - i;
            int[] mw = mw();
            trackDirection = this.FW.FG;
            switch (mw[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f4 = this.FW.FA;
                    if (i6 > f4 - this.FW.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.FW;
                        i5 = horizontalTranslateLayout.FC;
                        horizontalTranslateLayout.FC = i5 - i;
                        this.FW.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f3 = this.FW.FB;
                    if (i6 < this.FW.getMeasuredWidth() - f3 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.FW;
                        i4 = horizontalTranslateLayout2.FC;
                        horizontalTranslateLayout2.FC = i4 - i;
                        this.FW.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f = this.FW.FA;
                    if (i6 >= f - this.FW.getMeasuredWidth()) {
                        f2 = this.FW.FB;
                        if (i6 <= this.FW.getMeasuredWidth() - f2) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.FW;
                            i3 = horizontalTranslateLayout3.FC;
                            horizontalTranslateLayout3.FC = i3 - i;
                            this.FW.invalidate();
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
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.Gf.computeCurrentVelocity(this.Gh);
        float xVelocity = this.Gf.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.Gi);
        } else {
            max = Math.max(xVelocity, this.Gi);
        }
        int[] mw = mw();
        trackDirection = this.FW.FG;
        switch (mw[trackDirection.ordinal()]) {
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
        this.Gf.recycle();
        this.Gf = null;
    }

    private void g(float f) {
        int i;
        float f2;
        h hVar;
        h hVar2;
        float f3;
        h hVar3;
        h hVar4;
        Log.d("HorizontalTranslateLayout", "@horizontalFling");
        i = this.FW.FC;
        if (i <= 0) {
            f3 = this.FW.FA;
            if (i >= f3 - this.FW.getMeasuredWidth()) {
                if (f < 0.0f) {
                    hVar4 = this.FW.FQ;
                    hVar4.e(f);
                    return;
                }
                hVar3 = this.FW.FQ;
                hVar3.c(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.FW.FB;
            if (i <= this.FW.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    hVar2 = this.FW.FQ;
                    hVar2.d(f);
                    return;
                }
                hVar = this.FW.FQ;
                hVar.f(f);
            }
        }
    }

    private void h(float f) {
        h hVar;
        h hVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            hVar2 = this.FW.FQ;
            hVar2.e(f);
            return;
        }
        hVar = this.FW.FQ;
        hVar.c(f);
    }

    private void i(float f) {
        h hVar;
        h hVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            hVar2 = this.FW.FQ;
            hVar2.d(f);
            return;
        }
        hVar = this.FW.FQ;
        hVar.f(f);
    }
}
