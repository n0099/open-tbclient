package com.baidu.platform.comapi.walknavi.g.b;

import android.os.Handler;
/* loaded from: classes2.dex */
public class t implements com.baidu.platform.comapi.walknavi.d.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f9673a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f9674b;

    public t(c cVar, String str) {
        this.f9674b = cVar;
        this.f9673a = str;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(boolean z, float f2) {
        Handler handler;
        if (z) {
            this.f9674b.R = z;
            handler = this.f9674b.n;
            handler.postDelayed(new u(this), 500L);
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().a(this.f9673a, true);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa progress: " + i);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa responseCode = " + i + ", responseMessage = " + str);
    }
}
