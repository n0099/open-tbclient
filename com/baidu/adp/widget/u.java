package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {
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
    public void a() {
        t tVar;
        x xVar;
        e();
        if (this.a <= this.c) {
            xVar = this.h.x;
            if (xVar != null) {
                xVar.b();
            }
            this.g = false;
            this.h.m = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        tVar = this.h.u;
        tVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        t tVar;
        v vVar;
        e();
        if (this.a >= this.c) {
            vVar = this.h.y;
            if (vVar != null) {
                vVar.b();
            }
            this.g = false;
            this.h.m = 10001;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        tVar = this.h.u;
        tVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        t tVar;
        List<w> list;
        e();
        if (this.a >= this.c) {
            list = this.h.z;
            for (w wVar : list) {
                if (wVar != null) {
                    wVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        tVar = this.h.u;
        tVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        t tVar;
        List<w> list;
        e();
        if (this.a <= this.c) {
            list = this.h.z;
            for (w wVar : list) {
                if (wVar != null) {
                    wVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        tVar = this.h.u;
        tVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<w> list;
        int i;
        int i2;
        t tVar;
        t tVar2;
        list = this.h.z;
        for (w wVar : list) {
            if (wVar != null) {
                wVar.a();
            }
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
        tVar = this.h.u;
        tVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        tVar2 = this.h.u;
        tVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<w> list;
        int i;
        int i2;
        t tVar;
        t tVar2;
        list = this.h.z;
        for (w wVar : list) {
            if (wVar != null) {
                wVar.a();
            }
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
        tVar = this.h.u;
        tVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        tVar2 = this.h.u;
        tVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        x xVar;
        int i;
        float f2;
        int i2;
        int i3;
        t tVar;
        t tVar2;
        xVar = this.h.x;
        if (xVar != null) {
            xVar.a();
        }
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
        tVar = this.h.u;
        tVar.removeMessages(-100);
        tVar2 = this.h.u;
        tVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        v vVar;
        int i;
        float f2;
        int i2;
        int i3;
        t tVar;
        t tVar2;
        vVar = this.h.y;
        if (vVar != null) {
            vVar.a();
        }
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
        tVar = this.h.u;
        tVar.removeMessages(-101);
        tVar2 = this.h.u;
        tVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
