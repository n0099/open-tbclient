package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
final class k {
    private static /* synthetic */ int[] f;
    VelocityTracker a;
    boolean b;
    final int c;
    final int d;
    final /* synthetic */ HorizontalTranslateLayout e;

    private static /* synthetic */ int[] a() {
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

    public final boolean a(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        h hVar;
        int i2;
        int i3;
        int i4;
        int i5;
        h unused;
        int[] a = a();
        trackDirection = this.e.i;
        switch (a[trackDirection.ordinal()]) {
            case 1:
                i4 = this.e.j;
                if (i4 != 10004) {
                    i5 = this.e.j;
                    if (i5 != 10000) {
                        return false;
                    }
                }
                break;
            case 2:
                i2 = this.e.j;
                if (i2 != 10004) {
                    i3 = this.e.j;
                    if (i3 != 10001) {
                        return false;
                    }
                }
                break;
            case 3:
                hVar = this.e.x;
                if (hVar != null) {
                    unused = this.e.x;
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
        HorizontalTranslateLayout.TrackDirection trackDirection;
        float f2;
        float f3;
        int i3;
        float f4;
        int i4;
        float f5;
        int i5;
        if (this.b) {
            i2 = this.e.e;
            int i6 = i2 - i;
            int[] a = a();
            trackDirection = this.e.i;
            switch (a[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f5 = this.e.c;
                    if (i6 > f5 - this.e.getMeasuredWidth() && i6 < 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout = this.e;
                        i5 = horizontalTranslateLayout.e;
                        horizontalTranslateLayout.e = i5 - i;
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f4 = this.e.d;
                    if (i6 < this.e.getMeasuredWidth() - f4 && i6 > 0) {
                        HorizontalTranslateLayout horizontalTranslateLayout2 = this.e;
                        i4 = horizontalTranslateLayout2.e;
                        horizontalTranslateLayout2.e = i4 - i;
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f2 = this.e.c;
                    if (i6 >= f2 - this.e.getMeasuredWidth()) {
                        f3 = this.e.d;
                        if (i6 <= this.e.getMeasuredWidth() - f3) {
                            HorizontalTranslateLayout horizontalTranslateLayout3 = this.e;
                            i3 = horizontalTranslateLayout3.e;
                            horizontalTranslateLayout3.e = i3 - i;
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

    public static /* synthetic */ void a(k kVar) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        g gVar;
        g gVar2;
        g gVar3;
        g gVar4;
        int i;
        float f2;
        g gVar5;
        g gVar6;
        float f3;
        g gVar7;
        g gVar8;
        kVar.a.computeCurrentVelocity(kVar.c);
        float xVelocity = kVar.a.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        float min = xVelocity < 0.0f ? Math.min(xVelocity, -kVar.d) : Math.max(xVelocity, kVar.d);
        int[] a = a();
        trackDirection = kVar.e.i;
        switch (a[trackDirection.ordinal()]) {
            case 1:
                Log.d("HorizontalTranslateLayout", "@leftFling");
                if (min < 0.0f) {
                    gVar4 = kVar.e.s;
                    gVar4.c(min);
                    break;
                } else {
                    gVar3 = kVar.e.s;
                    gVar3.a(min);
                    break;
                }
            case 2:
                Log.d("HorizontalTranslateLayout", "@rightFling");
                if (min < 0.0f) {
                    gVar2 = kVar.e.s;
                    gVar2.b(min);
                    break;
                } else {
                    gVar = kVar.e.s;
                    gVar.d(min);
                    break;
                }
            case 3:
                Log.d("HorizontalTranslateLayout", "@horizontalFling");
                i = kVar.e.e;
                if (i <= 0) {
                    f3 = kVar.e.c;
                    if (i >= f3 - kVar.e.getMeasuredWidth()) {
                        if (min < 0.0f) {
                            gVar8 = kVar.e.s;
                            gVar8.c(min);
                            break;
                        } else {
                            gVar7 = kVar.e.s;
                            gVar7.a(min);
                            break;
                        }
                    }
                }
                if (i >= 0) {
                    f2 = kVar.e.d;
                    if (i <= kVar.e.getMeasuredWidth() - f2) {
                        if (min < 0.0f) {
                            gVar6 = kVar.e.s;
                            gVar6.b(min);
                            break;
                        } else {
                            gVar5 = kVar.e.s;
                            gVar5.d(min);
                            break;
                        }
                    }
                }
                break;
        }
        kVar.a.recycle();
        kVar.a = null;
    }
}
