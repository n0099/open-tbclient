package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class n {
    private static /* synthetic */ int[] f;
    VelocityTracker a;
    boolean b;
    final int c;
    final int d;
    final /* synthetic */ HorizontalTranslateLayout e;

    static /* synthetic */ int[] b() {
        int[] iArr = f;
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
            f = iArr;
        }
        return iArr;
    }

    public boolean a(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        h hVar;
        h hVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] b = b();
        trackDirection = this.e.j;
        switch (b[trackDirection.ordinal()]) {
            case 1:
                i4 = this.e.k;
                if (i4 != 10004) {
                    i5 = this.e.k;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.e.k;
                if (i2 != 10004) {
                    i3 = this.e.k;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                hVar = this.e.A;
                if (hVar != null) {
                    hVar2 = this.e.A;
                    hVar2.a(i);
                    break;
                }
                break;
        }
        this.a = VelocityTracker.obtain();
        this.b = true;
        return true;
    }

    public void a() {
        this.b = false;
    }

    public void b(int i) {
        int i2;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        float f2;
        float f3;
        int i3;
        float f4;
        int i4;
        float f5;
        int i5;
        if (this.b) {
            i2 = this.e.f;
            int i6 = i2 - i;
            int[] b = b();
            trackDirection = this.e.j;
            switch (b[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f5 = this.e.d;
                    if (i6 > f5 - this.e.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.e;
                        i5 = horizontalTranslateLayout.f;
                        horizontalTranslateLayout.f = i5 - i;
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f4 = this.e.e;
                    if (i6 < this.e.getMeasuredWidth() - f4 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.e;
                        i4 = horizontalTranslateLayout2.f;
                        horizontalTranslateLayout2.f = i4 - i;
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f2 = this.e.d;
                    if (i6 >= f2 - this.e.getMeasuredWidth()) {
                        f3 = this.e.e;
                        if (i6 <= this.e.getMeasuredWidth() - f3) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.e;
                            i3 = horizontalTranslateLayout3.f;
                            horizontalTranslateLayout3.f = i3 - i;
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
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.a.computeCurrentVelocity(this.c);
        float xVelocity = this.a.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.d);
        } else {
            max = Math.max(xVelocity, this.d);
        }
        int[] b = b();
        trackDirection = this.e.j;
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
        this.a.recycle();
        this.a = null;
    }

    private void a(float f2) {
        int i;
        float f3;
        g gVar;
        g gVar2;
        float f4;
        g gVar3;
        g gVar4;
        Log.d("HorizontalTranslateLayout", "@horizontalFling");
        i = this.e.f;
        if (i <= 0) {
            f4 = this.e.d;
            if (i >= f4 - this.e.getMeasuredWidth()) {
                if (f2 < 0.0f) {
                    gVar4 = this.e.t;
                    gVar4.c(f2);
                    return;
                }
                gVar3 = this.e.t;
                gVar3.a(f2);
                return;
            }
        }
        if (i >= 0) {
            f3 = this.e.e;
            if (i <= this.e.getMeasuredWidth() - f3) {
                if (f2 < 0.0f) {
                    gVar2 = this.e.t;
                    gVar2.b(f2);
                    return;
                }
                gVar = this.e.t;
                gVar.d(f2);
            }
        }
    }

    private void b(float f2) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f2 < 0.0f) {
            gVar2 = this.e.t;
            gVar2.c(f2);
            return;
        }
        gVar = this.e.t;
        gVar.a(f2);
    }

    private void c(float f2) {
        g gVar;
        g gVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f2 < 0.0f) {
            gVar2 = this.e.t;
            gVar2.b(f2);
            return;
        }
        gVar = this.e.t;
        gVar.d(f2);
    }
}
