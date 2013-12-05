package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.HorizontalTranslateLayout;
/* loaded from: classes.dex */
public class o {

    /* renamed from: a */
    VelocityTracker f612a;
    boolean b;
    final int c;
    final int d;
    final /* synthetic */ HorizontalTranslateLayout e;

    public boolean a(int i) {
        HorizontalTranslateLayout.TrackDirection trackDirection;
        i iVar;
        i iVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = f.f609a;
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
                iVar = this.e.A;
                if (iVar != null) {
                    iVar2 = this.e.A;
                    iVar2.a(i);
                    break;
                }
                break;
        }
        this.f612a = VelocityTracker.obtain();
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
            int[] iArr = f.f609a;
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
        this.f612a.computeCurrentVelocity(this.c);
        float xVelocity = this.f612a.getXVelocity();
        Log.d("HorizontalTranslateLayout", "@fling x " + xVelocity);
        if (xVelocity < 0.0f) {
            max = Math.min(xVelocity, -this.d);
        } else {
            max = Math.max(xVelocity, this.d);
        }
        int[] iArr = f.f609a;
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
        this.f612a.recycle();
        this.f612a = null;
    }

    private void a(float f) {
        int i;
        float f2;
        h hVar;
        h hVar2;
        float f3;
        h hVar3;
        h hVar4;
        Log.d("HorizontalTranslateLayout", "@horizontalFling");
        i = this.e.f;
        if (i <= 0) {
            f3 = this.e.d;
            if (i >= f3 - this.e.getMeasuredWidth()) {
                if (f < 0.0f) {
                    hVar4 = this.e.t;
                    hVar4.c(f);
                    return;
                }
                hVar3 = this.e.t;
                hVar3.a(f);
                return;
            }
        }
        if (i >= 0) {
            f2 = this.e.e;
            if (i <= this.e.getMeasuredWidth() - f2) {
                if (f < 0.0f) {
                    hVar2 = this.e.t;
                    hVar2.b(f);
                    return;
                }
                hVar = this.e.t;
                hVar.d(f);
            }
        }
    }

    private void b(float f) {
        h hVar;
        h hVar2;
        Log.d("HorizontalTranslateLayout", "@leftFling");
        if (f < 0.0f) {
            hVar2 = this.e.t;
            hVar2.c(f);
            return;
        }
        hVar = this.e.t;
        hVar.a(f);
    }

    private void c(float f) {
        h hVar;
        h hVar2;
        Log.d("HorizontalTranslateLayout", "@rightFling");
        if (f < 0.0f) {
            hVar2 = this.e.t;
            hVar2.b(f);
            return;
        }
        hVar = this.e.t;
        hVar.d(f);
    }
}
