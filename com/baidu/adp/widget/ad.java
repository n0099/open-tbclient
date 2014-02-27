package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
final class ad {
    private static /* synthetic */ int[] f;
    VelocityTracker a;
    boolean b;
    final int c;
    final int d;
    final /* synthetic */ VerticalTranslateLayout e;

    private static /* synthetic */ int[] a() {
        int[] iArr = f;
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
            f = iArr;
        }
        return iArr;
    }

    public final boolean a(int i) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        ac acVar;
        int i2;
        int i3;
        int i4;
        int i5;
        ac unused;
        int[] a = a();
        trackDirection = this.e.l;
        switch (a[trackDirection.ordinal()]) {
            case 1:
                i4 = this.e.m;
                if (i4 != 10004) {
                    i5 = this.e.m;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.e.m;
                if (i2 != 10004) {
                    i3 = this.e.m;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                acVar = this.e.C;
                if (acVar != null) {
                    unused = this.e.C;
                    break;
                }
                break;
        }
        this.a = VelocityTracker.obtain();
        this.b = true;
        return true;
    }

    public final void b(int i) {
        int i2;
        VerticalTranslateLayout.TrackDirection trackDirection;
        float f2;
        int i3;
        int i4;
        float f3;
        int i5;
        int i6;
        float f4;
        int i7;
        float f5;
        int i8;
        int i9;
        if (this.b) {
            i2 = this.e.h;
            int i10 = i2 - i;
            int[] a = a();
            trackDirection = this.e.l;
            switch (a[trackDirection.ordinal()]) {
                case 1:
                    Log.d("VerticalTranslateLayout", "@move top");
                    f5 = this.e.d;
                    i8 = this.e.c;
                    if (i10 > f5 - i8 && i10 < 0) {
                        VerticalTranslateLayout verticalTranslateLayout = this.e;
                        i9 = verticalTranslateLayout.h;
                        verticalTranslateLayout.h = i9 - i;
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("VerticalTranslateLayout", "@move bottom");
                    i6 = this.e.c;
                    f4 = this.e.f;
                    if (i10 < i6 - f4 && i10 > 0) {
                        VerticalTranslateLayout verticalTranslateLayout2 = this.e;
                        i7 = verticalTranslateLayout2.h;
                        verticalTranslateLayout2.h = i7 - i;
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("VerticalTranslateLayout", "@move vertical");
                    f2 = this.e.d;
                    i3 = this.e.c;
                    if (i10 >= f2 - i3) {
                        i4 = this.e.c;
                        f3 = this.e.f;
                        if (i10 <= i4 - f3) {
                            VerticalTranslateLayout verticalTranslateLayout3 = this.e;
                            i5 = verticalTranslateLayout3.h;
                            verticalTranslateLayout3.h = i5 - i;
                            this.e.invalidate();
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

    public static /* synthetic */ void a(ad adVar) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        x xVar;
        x xVar2;
        x xVar3;
        x xVar4;
        int i;
        int i2;
        float f2;
        x xVar5;
        x xVar6;
        float f3;
        int i3;
        x xVar7;
        x xVar8;
        adVar.a.computeCurrentVelocity(adVar.c);
        float yVelocity = adVar.a.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        float min = yVelocity < 0.0f ? Math.min(yVelocity, -adVar.d) : Math.max(yVelocity, adVar.d);
        int[] a = a();
        trackDirection = adVar.e.l;
        switch (a[trackDirection.ordinal()]) {
            case 1:
                Log.d("VerticalTranslateLayout", "@topFling");
                if (min < 0.0f) {
                    xVar4 = adVar.e.v;
                    xVar4.c(min);
                    break;
                } else {
                    xVar3 = adVar.e.v;
                    xVar3.a(min);
                    break;
                }
            case 2:
                Log.d("VerticalTranslateLayout", "@bottomFling");
                if (min < 0.0f) {
                    xVar2 = adVar.e.v;
                    xVar2.b(min);
                    break;
                } else {
                    xVar = adVar.e.v;
                    xVar.d(min);
                    break;
                }
            case 3:
                Log.d("VerticalTranslateLayout", "@verticalFling");
                i = adVar.e.h;
                if (i <= 0) {
                    f3 = adVar.e.d;
                    i3 = adVar.e.c;
                    if (i >= f3 - i3) {
                        if (min < 0.0f) {
                            xVar8 = adVar.e.v;
                            xVar8.c(min);
                            break;
                        } else {
                            xVar7 = adVar.e.v;
                            xVar7.a(min);
                            break;
                        }
                    }
                }
                if (i >= 0) {
                    i2 = adVar.e.c;
                    f2 = adVar.e.f;
                    if (i <= i2 - f2) {
                        if (min < 0.0f) {
                            xVar6 = adVar.e.v;
                            xVar6.b(min);
                            break;
                        } else {
                            xVar5 = adVar.e.v;
                            xVar5.d(min);
                            break;
                        }
                    }
                }
                break;
        }
        adVar.a.recycle();
        adVar.a = null;
    }
}
