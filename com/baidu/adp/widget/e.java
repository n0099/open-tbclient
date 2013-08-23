package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e {

    /* renamed from: a  reason: collision with root package name */
    float f506a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ HorizontalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f506a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.f506a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        d dVar;
        g gVar;
        e();
        if (this.f506a <= this.c) {
            gVar = this.h.v;
            if (gVar != null) {
                gVar.b();
            }
            this.g = false;
            this.h.k = VersionUtils.CUR_DEVELOPMENT;
            this.h.a();
            return;
        }
        this.h.f = (int) (z.a(this.c, this.f506a, false) + this.d);
        this.h.invalidate();
        dVar = this.h.s;
        dVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        d dVar;
        j jVar;
        e();
        if (this.f506a >= this.c) {
            jVar = this.h.w;
            if (jVar != null) {
                jVar.b();
            }
            this.g = false;
            this.h.k = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.f = (int) (z.a(this.c, this.f506a, false) + this.d);
        this.h.invalidate();
        dVar = this.h.s;
        dVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        d dVar;
        List<i> list;
        e();
        if (this.f506a >= this.c) {
            list = this.h.x;
            for (i iVar : list) {
                if (iVar != null) {
                    iVar.b();
                }
            }
            this.g = false;
            this.h.k = 10004;
            this.h.a();
            return;
        }
        this.h.f = (int) (z.a(this.c, this.f506a, false) + this.d);
        this.h.invalidate();
        dVar = this.h.s;
        dVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        d dVar;
        List<i> list;
        e();
        if (this.f506a <= this.c) {
            list = this.h.x;
            for (i iVar : list) {
                if (iVar != null) {
                    iVar.b();
                }
            }
            this.g = false;
            this.h.k = 10004;
            this.h.a();
            return;
        }
        this.h.f = (int) (z.a(this.c, this.f506a, false) + this.d);
        this.h.invalidate();
        dVar = this.h.s;
        dVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<i> list;
        int i;
        int i2;
        d dVar;
        d dVar2;
        list = this.h.x;
        for (i iVar : list) {
            if (iVar != null) {
                iVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f506a = 0.0f;
        i = this.h.f;
        this.c = 0 - i;
        i2 = this.h.f;
        this.d = i2;
        dVar = this.h.s;
        dVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        dVar2 = this.h.s;
        dVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<i> list;
        int i;
        int i2;
        d dVar;
        d dVar2;
        list = this.h.x;
        for (i iVar : list) {
            if (iVar != null) {
                iVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f506a = 0.0f;
        i = this.h.f;
        this.c = 0 - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        dVar = this.h.s;
        dVar.removeMessages(-105);
        dVar2 = this.h.s;
        dVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        g gVar;
        float f2;
        int i;
        int i2;
        d dVar;
        d dVar2;
        gVar = this.h.v;
        if (gVar != null) {
            gVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f506a = 0.0f;
        f2 = this.h.d;
        float f3 = (-this.h.getMeasuredWidth()) + f2;
        i = this.h.f;
        this.c = f3 - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        dVar = this.h.s;
        dVar.removeMessages(-100);
        dVar2 = this.h.s;
        dVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        j jVar;
        float f2;
        int i;
        int i2;
        d dVar;
        d dVar2;
        jVar = this.h.w;
        if (jVar != null) {
            jVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f506a = 0.0f;
        f2 = this.h.e;
        float measuredWidth = this.h.getMeasuredWidth() - f2;
        i = this.h.f;
        this.c = measuredWidth - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        dVar = this.h.s;
        dVar.removeMessages(-101);
        dVar2 = this.h.s;
        dVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
