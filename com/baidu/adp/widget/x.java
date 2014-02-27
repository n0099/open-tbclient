package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.sapi2.shell.SapiErrorCode;
import java.util.Iterator;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class x {
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
        w wVar;
        aa unused;
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
        wVar = this.h.u;
        wVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b() {
        w wVar;
        y unused;
        e();
        if (this.a >= this.c) {
            unused = this.h.y;
            this.g = false;
            this.h.m = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.a, false) + this.d);
        this.h.invalidate();
        wVar = this.h.u;
        wVar.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c() {
        w wVar;
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
        wVar = this.h.u;
        wVar.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d() {
        w wVar;
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
        wVar = this.h.u;
        wVar.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void a(float f) {
        List list;
        int i;
        int i2;
        w wVar;
        w wVar2;
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
        wVar = this.h.u;
        wVar.removeMessages(SapiErrorCode.GETTING_CERT);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        wVar2 = this.h.u;
        wVar2.sendEmptyMessageAtTime(SapiErrorCode.GETTING_CERT, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void b(float f) {
        List list;
        int i;
        int i2;
        w wVar;
        w wVar2;
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
        wVar = this.h.u;
        wVar.removeMessages(SapiErrorCode.GET_CERT_FAIL);
        wVar2 = this.h.u;
        wVar2.sendEmptyMessageAtTime(SapiErrorCode.GET_CERT_FAIL, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void c(float f) {
        int i;
        float f2;
        int i2;
        int i3;
        w wVar;
        w wVar2;
        aa unused;
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
        wVar = this.h.u;
        wVar.removeMessages(-100);
        wVar2 = this.h.u;
        wVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public final void d(float f) {
        int i;
        float f2;
        int i2;
        int i3;
        w wVar;
        w wVar2;
        y unused;
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
        wVar = this.h.u;
        wVar.removeMessages(SapiErrorCode.SENT_SUCCEED);
        wVar2 = this.h.u;
        wVar2.sendEmptyMessageAtTime(SapiErrorCode.SENT_SUCCEED, this.f);
    }
}
