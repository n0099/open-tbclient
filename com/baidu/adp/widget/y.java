package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class y {
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
        x xVar;
        ac acVar;
        e();
        if (this.a <= this.c) {
            acVar = this.h.x;
            if (acVar != null) {
                acVar.b();
            }
            this.g = false;
            this.h.m = 10000;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        xVar = this.h.u;
        xVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        x xVar;
        z zVar;
        e();
        if (this.a >= this.c) {
            zVar = this.h.y;
            if (zVar != null) {
                zVar.b();
            }
            this.g = false;
            this.h.m = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        xVar = this.h.u;
        xVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        x xVar;
        List<ab> list;
        e();
        if (this.a >= this.c) {
            list = this.h.z;
            for (ab abVar : list) {
                if (abVar != null) {
                    abVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        xVar = this.h.u;
        xVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        x xVar;
        List<ab> list;
        e();
        if (this.a <= this.c) {
            list = this.h.z;
            for (ab abVar : list) {
                if (abVar != null) {
                    abVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        xVar = this.h.u;
        xVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<ab> list;
        int i;
        int i2;
        x xVar;
        x xVar2;
        list = this.h.z;
        for (ab abVar : list) {
            if (abVar != null) {
                abVar.a();
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
        xVar = this.h.u;
        xVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        xVar2 = this.h.u;
        xVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<ab> list;
        int i;
        int i2;
        x xVar;
        x xVar2;
        list = this.h.z;
        for (ab abVar : list) {
            if (abVar != null) {
                abVar.a();
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
        xVar = this.h.u;
        xVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        xVar2 = this.h.u;
        xVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        ac acVar;
        int i;
        float f2;
        int i2;
        int i3;
        x xVar;
        x xVar2;
        acVar = this.h.x;
        if (acVar != null) {
            acVar.a();
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
        xVar = this.h.u;
        xVar.removeMessages(-100);
        xVar2 = this.h.u;
        xVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        z zVar;
        int i;
        float f2;
        int i2;
        int i3;
        x xVar;
        x xVar2;
        zVar = this.h.y;
        if (zVar != null) {
            zVar.a();
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
        xVar = this.h.u;
        xVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        xVar2 = this.h.u;
        xVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.f);
    }
}
