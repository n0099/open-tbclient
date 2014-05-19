package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.sapi2.shell.SapiErrorCode;
import com.baidu.tbadk.TbConfig;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g {
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
        f fVar;
        i iVar;
        e();
        if (this.a <= this.c) {
            iVar = this.h.u;
            if (iVar != null) {
                iVar.b();
            }
            this.g = false;
            this.h.j = TbConfig.BIG_IMAGE_MIN_CAPACITY;
            this.h.a();
            return;
        }
        this.h.e = (int) (aa.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.r;
        fVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        f fVar;
        k kVar;
        e();
        if (this.a >= this.c) {
            kVar = this.h.v;
            if (kVar != null) {
                kVar.b();
            }
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
    public void c() {
        f fVar;
        List<j> list;
        e();
        if (this.a >= this.c) {
            list = this.h.w;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.b();
                }
            }
            this.g = false;
            this.h.j = 10004;
            this.h.a();
            return;
        }
        this.h.e = (int) (aa.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.r;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        f fVar;
        List<j> list;
        e();
        if (this.a <= this.c) {
            list = this.h.w;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.b();
                }
            }
            this.g = false;
            this.h.j = 10004;
            this.h.a();
            return;
        }
        this.h.e = (int) (aa.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.r;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.h.w;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.a();
            }
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
        fVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        fVar2 = this.h.r;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<j> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.h.w;
        for (j jVar : list) {
            if (jVar != null) {
                jVar.a();
            }
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
        fVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        fVar2 = this.h.r;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        i iVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        iVar = this.h.u;
        if (iVar != null) {
            iVar.a();
        }
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
    public void d(float f) {
        k kVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        kVar = this.h.v;
        if (kVar != null) {
            kVar.a();
        }
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
