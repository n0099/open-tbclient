package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class y {
    private static /* synthetic */ int[] f;

    /* renamed from: a */
    VelocityTracker f515a;
    boolean b;
    final int c;
    final int d;
    final /* synthetic */ VerticalTranslateLayout e;

    static /* synthetic */ int[] b() {
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

    public boolean a(int i) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        x xVar;
        x xVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] b = b();
        trackDirection = this.e.l;
        switch (b[trackDirection.ordinal()]) {
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
                xVar = this.e.C;
                if (xVar != null) {
                    xVar2 = this.e.C;
                    xVar2.a(i);
                    break;
                }
                break;
        }
        this.f515a = VelocityTracker.obtain();
        this.b = true;
        return true;
    }

    public void a() {
        this.b = false;
    }

    public void b(int i) {
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
            int[] b = b();
            trackDirection = this.e.l;
            switch (b[trackDirection.ordinal()]) {
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

    public void c() {
        float max;
        VerticalTranslateLayout.TrackDirection trackDirection;
        this.f515a.computeCurrentVelocity(this.c);
        float yVelocity = this.f515a.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        if (yVelocity < 0.0f) {
            max = Math.min(yVelocity, -this.d);
        } else {
            max = Math.max(yVelocity, this.d);
        }
        int[] b = b();
        trackDirection = this.e.l;
        switch (b[trackDirection.ordinal()]) {
            case 1:
                b(max);
                break;
            case 2:
                c(max);
                break;
            case 3:
                a(max);
                break;
        }
        this.f515a.recycle();
        this.f515a = null;
    }

    private void a(float f2) {
        int i;
        int i2;
        float f3;
        r rVar;
        r rVar2;
        float f4;
        int i3;
        r rVar3;
        r rVar4;
        Log.d("VerticalTranslateLayout", "@verticalFling");
        i = this.e.h;
        if (i <= 0) {
            f4 = this.e.d;
            i3 = this.e.c;
            if (i >= f4 - i3) {
                if (f2 < 0.0f) {
                    rVar4 = this.e.v;
                    rVar4.c(f2);
                    return;
                }
                rVar3 = this.e.v;
                rVar3.a(f2);
                return;
            }
        }
        if (i >= 0) {
            i2 = this.e.c;
            f3 = this.e.f;
            if (i <= i2 - f3) {
                if (f2 < 0.0f) {
                    rVar2 = this.e.v;
                    rVar2.b(f2);
                    return;
                }
                rVar = this.e.v;
                rVar.d(f2);
            }
        }
    }

    private void b(float f2) {
        r rVar;
        r rVar2;
        Log.d("VerticalTranslateLayout", "@topFling");
        if (f2 < 0.0f) {
            rVar2 = this.e.v;
            rVar2.c(f2);
            return;
        }
        rVar = this.e.v;
        rVar.a(f2);
    }

    private void c(float f2) {
        r rVar;
        r rVar2;
        Log.d("VerticalTranslateLayout", "@bottomFling");
        if (f2 < 0.0f) {
            rVar2 = this.e.v;
            rVar2.b(f2);
            return;
        }
        rVar = this.e.v;
        rVar.d(f2);
    }
}
