package com.baidu.adp.widget;

import android.util.Log;
import android.view.VelocityTracker;
import com.baidu.adp.widget.VerticalTranslateLayout;
/* loaded from: classes.dex */
public class ab {

    /* renamed from: a */
    VelocityTracker f594a;
    boolean b;
    final int c;
    final int d;
    final /* synthetic */ VerticalTranslateLayout e;

    public boolean a(int i) {
        VerticalTranslateLayout.TrackDirection trackDirection;
        aa aaVar;
        aa aaVar2;
        int i2;
        int i3;
        int i4;
        int i5;
        int[] iArr = s.f605a;
        trackDirection = this.e.l;
        switch (iArr[trackDirection.ordinal()]) {
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
                aaVar = this.e.C;
                if (aaVar != null) {
                    aaVar2 = this.e.C;
                    aaVar2.a(i);
                    break;
                }
                break;
        }
        this.f594a = VelocityTracker.obtain();
        this.b = true;
        return true;
    }

    public void a() {
        this.b = false;
    }

    public void b(int i) {
        int i2;
        VerticalTranslateLayout.TrackDirection trackDirection;
        float f;
        int i3;
        int i4;
        float f2;
        int i5;
        float f3;
        float f4;
        int i6;
        if (this.b) {
            i2 = this.e.h;
            int i7 = i2 - i;
            int[] iArr = s.f605a;
            trackDirection = this.e.l;
            switch (iArr[trackDirection.ordinal()]) {
                case 1:
                    Log.d("VerticalTranslateLayout", "@move top");
                    f4 = this.e.d;
                    i6 = this.e.c;
                    if (i7 > f4 - i6 && i7 < 0) {
                        VerticalTranslateLayout.a(this.e, i);
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 2:
                    Log.d("VerticalTranslateLayout", "@move bottom");
                    i5 = this.e.c;
                    f3 = this.e.f;
                    if (i7 < i5 - f3 && i7 > 0) {
                        VerticalTranslateLayout.a(this.e, i);
                        this.e.invalidate();
                        return;
                    }
                    return;
                case 3:
                    Log.d("VerticalTranslateLayout", "@move vertical");
                    f = this.e.d;
                    i3 = this.e.c;
                    if (i7 >= f - i3) {
                        i4 = this.e.c;
                        f2 = this.e.f;
                        if (i7 <= i4 - f2) {
                            VerticalTranslateLayout.a(this.e, i);
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
        VerticalTranslateLayout.TrackDirection trackDirection;
        this.f594a.computeCurrentVelocity(this.c);
        float yVelocity = this.f594a.getYVelocity();
        Log.d("VerticalTranslateLayout", "@fling y " + yVelocity);
        if (yVelocity < 0.0f) {
            max = Math.min(yVelocity, -this.d);
        } else {
            max = Math.max(yVelocity, this.d);
        }
        int[] iArr = s.f605a;
        trackDirection = this.e.l;
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
        this.f594a.recycle();
        this.f594a = null;
    }

    private void a(float f) {
        int i;
        int i2;
        float f2;
        u uVar;
        u uVar2;
        float f3;
        int i3;
        u uVar3;
        u uVar4;
        Log.d("VerticalTranslateLayout", "@verticalFling");
        i = this.e.h;
        if (i <= 0) {
            f3 = this.e.d;
            i3 = this.e.c;
            if (i >= f3 - i3) {
                if (f < 0.0f) {
                    uVar4 = this.e.v;
                    uVar4.c(f);
                    return;
                }
                uVar3 = this.e.v;
                uVar3.a(f);
                return;
            }
        }
        if (i >= 0) {
            i2 = this.e.c;
            f2 = this.e.f;
            if (i <= i2 - f2) {
                if (f < 0.0f) {
                    uVar2 = this.e.v;
                    uVar2.b(f);
                    return;
                }
                uVar = this.e.v;
                uVar.d(f);
            }
        }
    }

    private void b(float f) {
        u uVar;
        u uVar2;
        Log.d("VerticalTranslateLayout", "@topFling");
        if (f < 0.0f) {
            uVar2 = this.e.v;
            uVar2.c(f);
            return;
        }
        uVar = this.e.v;
        uVar.a(f);
    }

    private void c(float f) {
        u uVar;
        u uVar2;
        Log.d("VerticalTranslateLayout", "@bottomFling");
        if (f < 0.0f) {
            uVar2 = this.e.v;
            uVar2.b(f);
            return;
        }
        uVar = this.e.v;
        uVar.d(f);
    }
}
