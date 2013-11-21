package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class z {

    /* renamed from: a  reason: collision with root package name */
    float f617a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ VerticalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f617a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.f617a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        y yVar;
        ad adVar;
        e();
        if (this.f617a <= this.c) {
            adVar = this.h.x;
            if (adVar != null) {
                adVar.b();
            }
            this.g = false;
            this.h.m = VersionUtils.CUR_DEVELOPMENT;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f617a, false) + this.d);
        this.h.invalidate();
        yVar = this.h.u;
        yVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        y yVar;
        aa aaVar;
        e();
        if (this.f617a >= this.c) {
            aaVar = this.h.y;
            if (aaVar != null) {
                aaVar.b();
            }
            this.g = false;
            this.h.m = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f617a, false) + this.d);
        this.h.invalidate();
        yVar = this.h.u;
        yVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        y yVar;
        List<ac> list;
        e();
        if (this.f617a >= this.c) {
            list = this.h.z;
            for (ac acVar : list) {
                if (acVar != null) {
                    acVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f617a, false) + this.d);
        this.h.invalidate();
        yVar = this.h.u;
        yVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        y yVar;
        List<ac> list;
        e();
        if (this.f617a <= this.c) {
            list = this.h.z;
            for (ac acVar : list) {
                if (acVar != null) {
                    acVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f617a, false) + this.d);
        this.h.invalidate();
        yVar = this.h.u;
        yVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<ac> list;
        int i;
        int i2;
        y yVar;
        y yVar2;
        list = this.h.z;
        for (ac acVar : list) {
            if (acVar != null) {
                acVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f617a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        yVar = this.h.u;
        yVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        yVar2 = this.h.u;
        yVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<ac> list;
        int i;
        int i2;
        y yVar;
        y yVar2;
        list = this.h.z;
        for (ac acVar : list) {
            if (acVar != null) {
                acVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f617a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        yVar = this.h.u;
        yVar.removeMessages(-105);
        yVar2 = this.h.u;
        yVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        ad adVar;
        int i;
        float f2;
        int i2;
        int i3;
        y yVar;
        y yVar2;
        adVar = this.h.x;
        if (adVar != null) {
            adVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f617a = 0.0f;
        i = this.h.c;
        f2 = this.h.d;
        float f3 = (-i) + f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        yVar = this.h.u;
        yVar.removeMessages(-100);
        yVar2 = this.h.u;
        yVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        aa aaVar;
        int i;
        float f2;
        int i2;
        int i3;
        y yVar;
        y yVar2;
        aaVar = this.h.y;
        if (aaVar != null) {
            aaVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f617a = 0.0f;
        i = this.h.c;
        f2 = this.h.f;
        float f3 = i - f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        yVar = this.h.u;
        yVar.removeMessages(-101);
        yVar2 = this.h.u;
        yVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
