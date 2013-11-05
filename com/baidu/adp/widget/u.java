package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class u {

    /* renamed from: a  reason: collision with root package name */
    float f607a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ VerticalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f607a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.f607a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        t tVar;
        y yVar;
        e();
        if (this.f607a <= this.c) {
            yVar = this.h.x;
            if (yVar != null) {
                yVar.b();
            }
            this.g = false;
            this.h.m = VersionUtils.CUR_DEVELOPMENT;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f607a, false) + this.d);
        this.h.invalidate();
        tVar = this.h.u;
        tVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        t tVar;
        v vVar;
        e();
        if (this.f607a >= this.c) {
            vVar = this.h.y;
            if (vVar != null) {
                vVar.b();
            }
            this.g = false;
            this.h.m = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f607a, false) + this.d);
        this.h.invalidate();
        tVar = this.h.u;
        tVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        t tVar;
        List<x> list;
        e();
        if (this.f607a >= this.c) {
            list = this.h.z;
            for (x xVar : list) {
                if (xVar != null) {
                    xVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f607a, false) + this.d);
        this.h.invalidate();
        tVar = this.h.u;
        tVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        t tVar;
        List<x> list;
        e();
        if (this.f607a <= this.c) {
            list = this.h.z;
            for (x xVar : list) {
                if (xVar != null) {
                    xVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f607a, false) + this.d);
        this.h.invalidate();
        tVar = this.h.u;
        tVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<x> list;
        int i;
        int i2;
        t tVar;
        t tVar2;
        list = this.h.z;
        for (x xVar : list) {
            if (xVar != null) {
                xVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f607a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        tVar = this.h.u;
        tVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        tVar2 = this.h.u;
        tVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<x> list;
        int i;
        int i2;
        t tVar;
        t tVar2;
        list = this.h.z;
        for (x xVar : list) {
            if (xVar != null) {
                xVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f607a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        tVar = this.h.u;
        tVar.removeMessages(-105);
        tVar2 = this.h.u;
        tVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        y yVar;
        int i;
        float f2;
        int i2;
        int i3;
        t tVar;
        t tVar2;
        yVar = this.h.x;
        if (yVar != null) {
            yVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f607a = 0.0f;
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
        this.f607a = 0.0f;
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
