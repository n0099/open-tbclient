package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class m {

    /* renamed from: a */
    VelocityTracker f599a;
    boolean b;
    final int c;
    final int d;
    final /* synthetic */ HorizontalTranslateLayout e;

    public boolean a(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        g gVar;
        g gVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = d.f596a;
        trackDirection = this.e.j;
        switch (iArr[trackDirection.ordinal()]) {
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
                gVar = this.e.A;
                if (gVar != null) {
                    gVar2 = this.e.A;
                    gVar2.a(i);
                    break;
                }
                break;
        }
        this.f599a = VelocityTracker.obtain();
        this.b = true;
        return true;
    }

    public void a() {
        this.b = false;
    }

    public void b(int i) {
        int i2;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        float f;
        float f2;
        float f3;
        float f4;
        if (this.b) {
            i2 = this.e.f;
            int i3 = i2 - i;
            int[] iArr = d.f596a;
            trackDirection = this.e.j;
            switch (iArr[trackDirection.ordinal()]) {
                case 1:
                    Log.d("HorizontalTranslateLayout", "@move left");
                    f4 = this.e.d;
                    if (i3 > f4 - this.e.getMeasuredWidth() && i3 < 0) {
                        HorizontalTranslateLayout.a(this.e, i);
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("HorizontalTranslateLayout", "@move right");
                    f3 = this.e.e;
                    if (i3 < this.e.getMeasuredWidth() - f3 && i3 > 0) {
                        HorizontalTranslateLayout.a(this.e, i);
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("HorizontalTranslateLayout", "@move horizontal");
                    f = this.e.d;
                    if (i3 >= f - this.e.getMeasuredWidth()) {
                        f2 = this.e.e;
                        if (i3 <= this.e.getMeasuredWidth() - f2) {
                            HorizontalTranslateLayout.a(this.e, i);
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

    public void b() {
        float max;
        HorizontalTranslateLayout.TrackDirection trackDirection;
        this.f599a.computeCurrentVelocity(this.c);
        float xVelocity = this.f599a.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.d);
        } else {
            max = Math.max(xVelocity, this.d);
        }
        int[] iArr = d.f596a;
        trackDirection = this.e.j;
        switch (iArr[trackDirection.ordinal()]) {
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
        this.f599a.recycle();
        this.f599a = null;
    }

    private void a(float f) {
        int i;
        float f2;
        f fVar;
        f fVar2;
        float f3;
        f fVar3;
        f fVar4;
        Log.d("HorizontalTranslateLayout", "@horizontalFling");
        i = this.e.f;
        if (i <= 0) {
            f3 = this.e.d;
            if (i >= f3 - this.e.getMeasuredWidth()) {
                if (f < 0.0f) {
                    fVar4 = this.e.t;
                    fVar4.c(f);
                    return;
                }
                fVar3 = this.e.t;
                fVar3.a(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.e.e;
            if (i <= this.e.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    fVar2 = this.e.t;
                    fVar2.b(f);
                    return;
                }
                fVar = this.e.t;
                fVar.d(f);
            }
        }
    }

    private void b(float f) {
        f fVar;
        f fVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            fVar2 = this.e.t;
            fVar2.c(f);
            return;
        }
        fVar = this.e.t;
        fVar.a(f);
    }

    private void c(float f) {
        f fVar;
        f fVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            fVar2 = this.e.t;
            fVar2.b(f);
            return;
        }
        fVar = this.e.t;
        fVar.d(f);
    }
}
