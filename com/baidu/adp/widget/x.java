package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class x {

    /* renamed from: a  reason: collision with root package name */
    float f616a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ VerticalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f616a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.f616a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        w wVar;
        ab abVar;
        e();
        if (this.f616a <= this.c) {
            abVar = this.h.x;
            if (abVar != null) {
                abVar.b();
            }
            this.g = false;
            this.h.m = VersionUtils.CUR_DEVELOPMENT;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f616a, false) + this.d);
        this.h.invalidate();
        wVar = this.h.u;
        wVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        w wVar;
        y yVar;
        e();
        if (this.f616a >= this.c) {
            yVar = this.h.y;
            if (yVar != null) {
                yVar.b();
            }
            this.g = false;
            this.h.m = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f616a, false) + this.d);
        this.h.invalidate();
        wVar = this.h.u;
        wVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        w wVar;
        List<aa> list;
        e();
        if (this.f616a >= this.c) {
            list = this.h.z;
            for (aa aaVar : list) {
                if (aaVar != null) {
                    aaVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f616a, false) + this.d);
        this.h.invalidate();
        wVar = this.h.u;
        wVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        w wVar;
        List<aa> list;
        e();
        if (this.f616a <= this.c) {
            list = this.h.z;
            for (aa aaVar : list) {
                if (aaVar != null) {
                    aaVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f616a, false) + this.d);
        this.h.invalidate();
        wVar = this.h.u;
        wVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<aa> list;
        int i;
        int i2;
        w wVar;
        w wVar2;
        list = this.h.z;
        for (aa aaVar : list) {
            if (aaVar != null) {
                aaVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f616a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        wVar = this.h.u;
        wVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        wVar2 = this.h.u;
        wVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<aa> list;
        int i;
        int i2;
        w wVar;
        w wVar2;
        list = this.h.z;
        for (aa aaVar : list) {
            if (aaVar != null) {
                aaVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f616a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        wVar = this.h.u;
        wVar.removeMessages(-105);
        wVar2 = this.h.u;
        wVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        ab abVar;
        int i;
        float f2;
        int i2;
        int i3;
        w wVar;
        w wVar2;
        abVar = this.h.x;
        if (abVar != null) {
            abVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f616a = 0.0f;
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
    public void d(float f) {
        y yVar;
        int i;
        float f2;
        int i2;
        int i3;
        w wVar;
        w wVar2;
        yVar = this.h.y;
        if (yVar != null) {
            yVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f616a = 0.0f;
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
        wVar.removeMessages(-101);
        wVar2 = this.h.u;
        wVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
