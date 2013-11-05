package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f {

    /* renamed from: a  reason: collision with root package name */
    float f598a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ HorizontalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f598a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.f598a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        e eVar;
        h hVar;
        e();
        if (this.f598a <= this.c) {
            hVar = this.h.v;
            if (hVar != null) {
                hVar.b();
            }
            this.g = false;
            this.h.k = VersionUtils.CUR_DEVELOPMENT;
            this.h.a();
            return;
        }
        this.h.f = (int) (ac.a(this.c, this.f598a, false) + this.d);
        this.h.invalidate();
        eVar = this.h.s;
        eVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        e eVar;
        k kVar;
        e();
        if (this.f598a >= this.c) {
            kVar = this.h.w;
            if (kVar != null) {
                kVar.b();
            }
            this.g = false;
            this.h.k = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.f = (int) (ac.a(this.c, this.f598a, false) + this.d);
        this.h.invalidate();
        eVar = this.h.s;
        eVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        e eVar;
        List<j> list;
        e();
        if (this.f598a >= this.c) {
            list = this.h.x;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.b();
                }
            }
            this.g = false;
            this.h.k = 10004;
            this.h.a();
            return;
        }
        this.h.f = (int) (ac.a(this.c, this.f598a, false) + this.d);
        this.h.invalidate();
        eVar = this.h.s;
        eVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        e eVar;
        List<j> list;
        e();
        if (this.f598a <= this.c) {
            list = this.h.x;
            for (j jVar : list) {
                if (jVar != null) {
                    jVar.b();
                }
            }
            this.g = false;
            this.h.k = 10004;
            this.h.a();
            return;
        }
        this.h.f = (int) (ac.a(this.c, this.f598a, false) + this.d);
        this.h.invalidate();
        eVar = this.h.s;
        eVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<j> list;
        int i;
        int i2;
        e eVar;
        e eVar2;
        list = this.h.x;
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
        this.f598a = 0.0f;
        i = this.h.f;
        this.c = 0 - i;
        i2 = this.h.f;
        this.d = i2;
        eVar = this.h.s;
        eVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        eVar2 = this.h.s;
        eVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<j> list;
        int i;
        int i2;
        e eVar;
        e eVar2;
        list = this.h.x;
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
        this.f598a = 0.0f;
        i = this.h.f;
        this.c = 0 - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        eVar = this.h.s;
        eVar.removeMessages(-105);
        eVar2 = this.h.s;
        eVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        h hVar;
        float f2;
        int i;
        int i2;
        e eVar;
        e eVar2;
        hVar = this.h.v;
        if (hVar != null) {
            hVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f598a = 0.0f;
        f2 = this.h.d;
        float f3 = (-this.h.getMeasuredWidth()) + f2;
        i = this.h.f;
        this.c = f3 - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        eVar = this.h.s;
        eVar.removeMessages(-100);
        eVar2 = this.h.s;
        eVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        k kVar;
        float f2;
        int i;
        int i2;
        e eVar;
        e eVar2;
        kVar = this.h.w;
        if (kVar != null) {
            kVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f598a = 0.0f;
        f2 = this.h.e;
        float measuredWidth = this.h.getMeasuredWidth() - f2;
        i = this.h.f;
        this.c = measuredWidth - i;
        i2 = this.h.f;
        this.d = i2;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        eVar = this.h.s;
        eVar.removeMessages(-101);
        eVar2 = this.h.s;
        eVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
