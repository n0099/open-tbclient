package com.baidu.adp.widget;

import android.os.SystemClock;
import android.util.Log;
import com.baidu.android.pushservice.PushConstants;
import com.baidu.cyberplayer.sdk.internal.VersionUtils;
import java.util.List;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h {

    /* renamed from: a  reason: collision with root package name */
    float f491a;
    float b;
    float c;
    float d;
    long e;
    long f;
    boolean g;
    final /* synthetic */ VerticalTranslateLayout h;

    private void e() {
        long uptimeMillis = SystemClock.uptimeMillis();
        this.f491a = ((((float) (uptimeMillis - this.e)) / 1000.0f) * this.b) + this.f491a;
        this.e = uptimeMillis;
        this.f += 16;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a() {
        g gVar;
        l lVar;
        e();
        if (this.f491a <= this.c) {
            lVar = this.h.x;
            if (lVar != null) {
                lVar.b();
            }
            this.g = false;
            this.h.m = VersionUtils.CUR_DEVELOPMENT;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f491a, false) + this.d);
        this.h.invalidate();
        gVar = this.h.u;
        gVar.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b() {
        g gVar;
        i iVar;
        e();
        if (this.f491a >= this.c) {
            iVar = this.h.y;
            if (iVar != null) {
                iVar.b();
            }
            this.g = false;
            this.h.m = PushConstants.ERROR_NETWORK_ERROR;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f491a, false) + this.d);
        this.h.invalidate();
        gVar = this.h.u;
        gVar.sendEmptyMessageAtTime(-101, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c() {
        g gVar;
        List<k> list;
        e();
        if (this.f491a >= this.c) {
            list = this.h.z;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f491a, false) + this.d);
        this.h.invalidate();
        gVar = this.h.u;
        gVar.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d() {
        g gVar;
        List<k> list;
        e();
        if (this.f491a <= this.c) {
            list = this.h.z;
            for (k kVar : list) {
                if (kVar != null) {
                    kVar.b();
                }
            }
            this.g = false;
            this.h.m = 10004;
            this.h.a();
            return;
        }
        this.h.h = (int) (a.a(this.c, this.f491a, false) + this.d);
        this.h.invalidate();
        gVar = this.h.u;
        gVar.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void a(float f) {
        List<k> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.h.z;
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
        this.f491a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        gVar = this.h.u;
        gVar.removeMessages(-104);
        Log.d("Animator", "@animateTopOpen " + this.c);
        Log.d("Animator", "@animateTopOpen " + f);
        gVar2 = this.h.u;
        gVar2.sendEmptyMessageAtTime(-104, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void b(float f) {
        List<k> list;
        int i;
        int i2;
        g gVar;
        g gVar2;
        list = this.h.z;
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
        this.f491a = 0.0f;
        i = this.h.h;
        this.c = 0 - i;
        i2 = this.h.h;
        this.d = i2;
        Log.d("Animator", "@animateBottomOpen " + this.c);
        Log.d("Animator", "@animateBottomOpen " + f);
        gVar = this.h.u;
        gVar.removeMessages(-105);
        gVar2 = this.h.u;
        gVar2.sendEmptyMessageAtTime(-105, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void c(float f) {
        l lVar;
        int i;
        float f2;
        int i2;
        int i3;
        g gVar;
        g gVar2;
        lVar = this.h.x;
        if (lVar != null) {
            lVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f491a = 0.0f;
        i = this.h.c;
        f2 = this.h.d;
        float f3 = (-i) + f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateTop " + this.c);
        Log.d("Animator", "@animateTop " + f);
        gVar = this.h.u;
        gVar.removeMessages(-100);
        gVar2 = this.h.u;
        gVar2.sendEmptyMessageAtTime(-100, this.f);
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public void d(float f) {
        i iVar;
        int i;
        float f2;
        int i2;
        int i3;
        g gVar;
        g gVar2;
        iVar = this.h.y;
        if (iVar != null) {
            iVar.a();
        }
        this.g = true;
        long uptimeMillis = SystemClock.uptimeMillis();
        this.e = uptimeMillis;
        this.f = uptimeMillis + 16;
        this.b = f;
        this.f491a = 0.0f;
        i = this.h.c;
        f2 = this.h.f;
        float f3 = i - f2;
        i2 = this.h.h;
        this.c = f3 - i2;
        i3 = this.h.h;
        this.d = i3;
        Log.d("Animator", "@animateBottom " + this.c);
        Log.d("Animator", "@animateBottom " + f);
        gVar = this.h.u;
        gVar.removeMessages(-101);
        gVar2 = this.h.u;
        gVar2.sendEmptyMessageAtTime(-101, this.f);
    }
}
