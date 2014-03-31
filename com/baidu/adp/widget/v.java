package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class v {
    float a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ VerticalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a() {
        u uVar;
        x unused;
        e();
        if (this.a <= this.c) {
            unused = this.h.x;
            this.g = false;
            this.h.m = 10000;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        uVar = this.h.u;
        uVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        u uVar;
        w unused;
        e();
        if (this.a >= this.c) {
            unused = this.h.y;
            this.g = false;
            this.h.m = 10001;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        uVar = this.h.u;
        uVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        u uVar;
        List list;
        e();
        if (this.a >= this.c) {
            list = this.h.z;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        uVar = this.h.u;
        uVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        u uVar;
        List list;
        e();
        if (this.a <= this.c) {
            list = this.h.z;
            Iterator it = list.iterator();
            while (it.hasNext()) {
                it.next();
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        uVar = this.h.u;
        uVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f) {
        List list;
        int i;
        int i2;
        u uVar;
        u uVar2;
        list = this.h.z;
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
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        uVar = this.h.u;
        uVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        uVar2 = this.h.u;
        uVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(float f) {
        List list;
        int i;
        int i2;
        u uVar;
        u uVar2;
        list = this.h.z;
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
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        uVar = this.h.u;
        uVar.removeMessages(-105);
        uVar2 = this.h.u;
        uVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(float f) {
        int i;
        float f2;
        int i2;
        int i3;
        u uVar;
        u uVar2;
        x unused;
        unused = this.h.x;
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        i = this.h.c;
        f2 = this.h.d;
        float f3 = (-i) + f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        uVar = this.h.u;
        uVar.removeMessages(-100);
        uVar2 = this.h.u;
        uVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(float f) {
        int i;
        float f2;
        int i2;
        int i3;
        u uVar;
        u uVar2;
        w unused;
        unused = this.h.y;
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        i = this.h.c;
        f2 = this.h.f;
        float f3 = i - f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        uVar = this.h.u;
        uVar.removeMessages(-101);
        uVar2 = this.h.u;
        uVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
