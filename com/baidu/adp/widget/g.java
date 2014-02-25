package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.shell.SapiErrorCode;
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
            iVar = this.h.v;
            if (iVar != null) {
                iVar.b();
            }
            this.g = false;
            this.h.k = 10000;
            this.h.a();
            return;
        }
        this.h.f = (int) (ag.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.s;
        fVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        f fVar;
        l lVar;
        e();
        if (this.a >= this.c) {
            lVar = this.h.w;
            if (lVar != null) {
                lVar.b();
            }
            this.g = false;
            this.h.k = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.f = (int) (ag.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.s;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        f fVar;
        List<k> list;
        e();
        if (this.a >= this.c) {
            list = this.h.x;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.b();
                }
            }
            this.g = false;
            this.h.k = 10004;
            this.h.a();
            return;
        }
        this.h.f = (int) (ag.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.s;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        f fVar;
        List<k> list;
        e();
        if (this.a <= this.c) {
            list = this.h.x;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.b();
                }
            }
            this.g = false;
            this.h.k = 10004;
            this.h.a();
            return;
        }
        this.h.f = (int) (ag.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        fVar = this.h.s;
        fVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<k> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.h.x;
        for (k kVar : list) {
            if (kVar != null) {
                kVar.a();
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
        fVar = this.h.s;
        fVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        fVar2 = this.h.s;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<k> list;
        int i;
        int i2;
        f fVar;
        f fVar2;
        list = this.h.x;
        for (k kVar : list) {
            if (kVar != null) {
                kVar.a();
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
        fVar = this.h.s;
        fVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        fVar2 = this.h.s;
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
        iVar = this.h.v;
        if (iVar != null) {
            iVar.a();
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
        fVar = this.h.s;
        fVar.removeMessages(-100);
        fVar2 = this.h.s;
        fVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        l lVar;
        float f2;
        int i;
        int i2;
        f fVar;
        f fVar2;
        lVar = this.h.w;
        if (lVar != null) {
            lVar.a();
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
        fVar = this.h.s;
        fVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        fVar2 = this.h.s;
        fVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.f);
    }
}
