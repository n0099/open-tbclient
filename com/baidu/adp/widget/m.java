package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
final class m {
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
        trackDirection = this.e.j;
        switch (a[trackDirection.ordinal()]) {
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
                    unused = this.e.A;
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
            i2 = this.e.f;
            int i6 = i2 - i;
            int[] a = a();
            trackDirection = this.e.j;
            switch (a[trackDirection.ordinal()]) {
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

    public static /* synthetic */ void a(m mVar) {
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
        mVar.a.computeCurrentVelocity(mVar.c);
        float xVelocity = mVar.a.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        float min = xVelocity < 0.0f ? Math.min(xVelocity, -mVar.d) : Math.max(xVelocity, mVar.d);
        int[] a = a();
        trackDirection = mVar.e.j;
        switch (a[trackDirection.ordinal()]) {
            case 1:
                Log.d("HorizontalTranslateLayout", "@leftFling");
                if (min < 0.0f) {
                    gVar4 = mVar.e.t;
                    gVar4.c(min);
                    break;
                } else {
                    gVar3 = mVar.e.t;
                    gVar3.a(min);
                    break;
                }
            case 2:
                Log.d("HorizontalTranslateLayout", "@rightFling");
                if (min < 0.0f) {
                    gVar2 = mVar.e.t;
                    gVar2.b(min);
                    break;
                } else {
                    gVar = mVar.e.t;
                    gVar.d(min);
                    break;
                }
            case 3:
                Log.d("HorizontalTranslateLayout", "@horizontalFling");
                i = mVar.e.f;
                if (i <= 0) {
                    f3 = mVar.e.d;
                    if (i >= f3 - mVar.e.getMeasuredWidth()) {
                        if (min < 0.0f) {
                            gVar8 = mVar.e.t;
                            gVar8.c(min);
                            break;
                        } else {
                            gVar7 = mVar.e.t;
                            gVar7.a(min);
                            break;
                        }
                    }
                }
                if (i >= 0) {
                    f2 = mVar.e.e;
                    if (i <= mVar.e.getMeasuredWidth() - f2) {
                        if (min < 0.0f) {
                            gVar6 = mVar.e.t;
                            gVar6.b(min);
                            break;
                        } else {
                            gVar5 = mVar.e.t;
                            gVar5.d(min);
                            break;
                        }
                    }
                }
                break;
        }
        mVar.a.recycle();
        mVar.a = null;
    }
}
