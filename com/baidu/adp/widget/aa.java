package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class aa {

    /* renamed from: a  reason: collision with root package name */
    float f604a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ VerticalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f604a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.f604a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        z zVar;
        ae aeVar;
        e();
        if (this.f604a <= this.c) {
            aeVar = this.h.x;
            if (aeVar != null) {
                aeVar.b();
            }
            this.g = false;
            this.h.m = VersionUtils.CUR_DEVELOPMENT;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f604a, false) + this.d);
        this.h.invalidate();
        zVar = this.h.u;
        zVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        z zVar;
        ab abVar;
        e();
        if (this.f604a >= this.c) {
            abVar = this.h.y;
            if (abVar != null) {
                abVar.b();
            }
            this.g = false;
            this.h.m = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f604a, false) + this.d);
        this.h.invalidate();
        zVar = this.h.u;
        zVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        z zVar;
        List<ad> list;
        e();
        if (this.f604a >= this.c) {
            list = this.h.z;
            for (ad adVar : list) {
                if (adVar != null) {
                    adVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f604a, false) + this.d);
        this.h.invalidate();
        zVar = this.h.u;
        zVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        z zVar;
        List<ad> list;
        e();
        if (this.f604a <= this.c) {
            list = this.h.z;
            for (ad adVar : list) {
                if (adVar != null) {
                    adVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f604a, false) + this.d);
        this.h.invalidate();
        zVar = this.h.u;
        zVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<ad> list;
        int i;
        int i2;
        z zVar;
        z zVar2;
        list = this.h.z;
        for (ad adVar : list) {
            if (adVar != null) {
                adVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f604a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        zVar = this.h.u;
        zVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        zVar2 = this.h.u;
        zVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<ad> list;
        int i;
        int i2;
        z zVar;
        z zVar2;
        list = this.h.z;
        for (ad adVar : list) {
            if (adVar != null) {
                adVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f604a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        zVar = this.h.u;
        zVar.removeMessages(-105);
        zVar2 = this.h.u;
        zVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        ae aeVar;
        int i;
        float f2;
        int i2;
        int i3;
        z zVar;
        z zVar2;
        aeVar = this.h.x;
        if (aeVar != null) {
            aeVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f604a = 0.0f;
        i = this.h.c;
        f2 = this.h.d;
        float f3 = (-i) + f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        zVar = this.h.u;
        zVar.removeMessages(-100);
        zVar2 = this.h.u;
        zVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        ab abVar;
        int i;
        float f2;
        int i2;
        int i3;
        z zVar;
        z zVar2;
        abVar = this.h.y;
        if (abVar != null) {
            abVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f604a = 0.0f;
        i = this.h.c;
        f2 = this.h.f;
        float f3 = i - f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        zVar = this.h.u;
        zVar.removeMessages(-101);
        zVar2 = this.h.u;
        zVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
