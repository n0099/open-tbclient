package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class r {

    /* renamed from: a  reason: collision with root package name */
    float f525a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ VerticalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f525a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.f525a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        q qVar;
        v vVar;
        e();
        if (this.f525a <= this.c) {
            vVar = this.h.x;
            if (vVar != null) {
                vVar.b();
            }
            this.g = false;
            this.h.m = VersionUtils.CUR_DEVELOPMENT;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f525a, false) + this.d);
        this.h.invalidate();
        qVar = this.h.u;
        qVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        q qVar;
        s sVar;
        e();
        if (this.f525a >= this.c) {
            sVar = this.h.y;
            if (sVar != null) {
                sVar.b();
            }
            this.g = false;
            this.h.m = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f525a, false) + this.d);
        this.h.invalidate();
        qVar = this.h.u;
        qVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        q qVar;
        List<u> list;
        e();
        if (this.f525a >= this.c) {
            list = this.h.z;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f525a, false) + this.d);
        this.h.invalidate();
        qVar = this.h.u;
        qVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        q qVar;
        List<u> list;
        e();
        if (this.f525a <= this.c) {
            list = this.h.z;
            for (u uVar : list) {
                if (uVar != null) {
                    uVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f525a, false) + this.d);
        this.h.invalidate();
        qVar = this.h.u;
        qVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<u> list;
        int i;
        int i2;
        q qVar;
        q qVar2;
        list = this.h.z;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f525a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        qVar = this.h.u;
        qVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        qVar2 = this.h.u;
        qVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<u> list;
        int i;
        int i2;
        q qVar;
        q qVar2;
        list = this.h.z;
        for (u uVar : list) {
            if (uVar != null) {
                uVar.a();
            }
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f525a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        qVar = this.h.u;
        qVar.removeMessages(-105);
        qVar2 = this.h.u;
        qVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        v vVar;
        int i;
        float f2;
        int i2;
        int i3;
        q qVar;
        q qVar2;
        vVar = this.h.x;
        if (vVar != null) {
            vVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f525a = 0.0f;
        i = this.h.c;
        f2 = this.h.d;
        float f3 = (-i) + f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        qVar = this.h.u;
        qVar.removeMessages(-100);
        qVar2 = this.h.u;
        qVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        s sVar;
        int i;
        float f2;
        int i2;
        int i3;
        q qVar;
        q qVar2;
        sVar = this.h.y;
        if (sVar != null) {
            sVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f525a = 0.0f;
        i = this.h.c;
        f2 = this.h.f;
        float f3 = i - f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        qVar = this.h.u;
        qVar.removeMessages(-101);
        qVar2 = this.h.u;
        qVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
