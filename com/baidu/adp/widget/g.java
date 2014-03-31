package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class g {
    float a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ HorizontalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        f fVar;
        i unused;
        e();
        if (this.a <= this.c) {
            unused = this.h.u;
            this.g = false;
            this.h.j = 10000;
            this.h.a();
            return;
        }
        this.h.e = (int) (aa.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.r;
        fVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        f fVar;
        j unused;
        e();
        if (this.a >= this.c) {
            unused = this.h.v;
            this.g = false;
            this.h.j = 10001;
            this.h.a();
            return;
        }
        this.h.e = (int) (aa.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.r;
        fVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        f fVar;
        List list;
        e();
        if (this.a >= this.c) {
            list = this.h.w;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.g = false;
            this.h.j = 10004;
            this.h.a();
            return;
        }
        this.h.e = (int) (aa.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.r;
        fVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        f fVar;
        List list;
        e();
        if (this.a <= this.c) {
            list = this.h.w;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.g = false;
            this.h.j = 10004;
            this.h.a();
            return;
        }
        this.h.e = (int) (aa.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.r;
        fVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f) {
        List list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.h.w;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        i = this.h.e;
        this.c = 0 - i;
        i2 = this.h.e;
        this.d = i2;
        fVar = this.h.r;
        fVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        fVar2 = this.h.r;
        fVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(float f) {
        List list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.h.w;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            it.next();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        i = this.h.e;
        this.c = 0 - i;
        i2 = this.h.e;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        fVar = this.h.r;
        fVar.removeMessages(-105);
        fVar2 = this.h.r;
        fVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(float f) {
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        i unused;
        unused = this.h.u;
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        f2 = this.h.c;
        float f3 = (-this.h.getMeasuredWidth()) + f2;
        i = this.h.e;
        this.c = f3 - i;
        i2 = this.h.e;
        this.d = i2;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        fVar = this.h.r;
        fVar.removeMessages(-100);
        fVar2 = this.h.r;
        fVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(float f) {
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        j unused;
        unused = this.h.v;
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        f2 = this.h.d;
        float measuredWidth = this.h.getMeasuredWidth() - f2;
        i = this.h.e;
        this.c = measuredWidth - i;
        i2 = this.h.e;
        this.d = i2;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        fVar = this.h.r;
        fVar.removeMessages(-101);
        fVar2 = this.h.r;
        fVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
