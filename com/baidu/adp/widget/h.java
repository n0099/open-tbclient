package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {
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
    public void a() {
        g gVar;
        j jVar;
        e();
        if (this.a <= this.c) {
            jVar = this.h.v;
            if (jVar != null) {
                jVar.b();
            }
            this.g = false;
            this.h.k = 10000;
            this.h.a();
            return;
        }
        this.h.f = (int) (ai.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        gVar = this.h.s;
        gVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        g gVar;
        m mVar;
        e();
        if (this.a >= this.c) {
            mVar = this.h.w;
            if (mVar != null) {
                mVar.b();
            }
            this.g = false;
            this.h.k = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.f = (int) (ai.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        gVar = this.h.s;
        gVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        g gVar;
        List<l> list;
        e();
        if (this.a >= this.c) {
            list = this.h.x;
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.b();
                }
            }
            this.g = false;
            this.h.k = 10004;
            this.h.a();
            return;
        }
        this.h.f = (int) (ai.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        gVar = this.h.s;
        gVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        g gVar;
        List<l> list;
        e();
        if (this.a <= this.c) {
            list = this.h.x;
            for (l lVar : list) {
                if (lVar != null) {
                    lVar.b();
                }
            }
            this.g = false;
            this.h.k = 10004;
            this.h.a();
            return;
        }
        this.h.f = (int) (ai.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        gVar = this.h.s;
        gVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<l> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.h.x;
        for (l lVar : list) {
            if (lVar != null) {
                lVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        i = this.h.f;
        this.c = 0 - i;
        i2 = this.h.f;
        this.d = i2;
        gVar = this.h.s;
        gVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        gVar2 = this.h.s;
        gVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<l> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.h.x;
        for (l lVar : list) {
            if (lVar != null) {
                lVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        i = this.h.f;
        this.c = 0 - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        gVar = this.h.s;
        gVar.removeMessages(-105);
        gVar2 = this.h.s;
        gVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        j jVar;
        float f2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        jVar = this.h.v;
        if (jVar != null) {
            jVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        f2 = this.h.d;
        float f3 = (-this.h.getMeasuredWidth()) + f2;
        i = this.h.f;
        this.c = f3 - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        gVar = this.h.s;
        gVar.removeMessages(-100);
        gVar2 = this.h.s;
        gVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        m mVar;
        float f2;
        int i;
        int i2;
        g gVar;
        g gVar2;
        mVar = this.h.w;
        if (mVar != null) {
            mVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.a = 0.0f;
        f2 = this.h.e;
        float measuredWidth = this.h.getMeasuredWidth() - f2;
        i = this.h.f;
        this.c = measuredWidth - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        gVar = this.h.s;
        gVar.removeMessages(-101);
        gVar2 = this.h.s;
        gVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
