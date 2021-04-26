package com.baidu.platform.comapi.walknavi.g.b;

import android.os.Handler;
/* loaded from: classes2.dex */
public class t implements com.baidu.platform.comapi.walknavi.d.c {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ String f10033a;

    /* renamed from: b  reason: collision with root package name */
    public final /* synthetic */ c f10034b;

    public t(c cVar, String str) {
        this.f10034b = cVar;
        this.f10033a = str;
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(boolean z, float f2) {
        Handler handler;
        if (z) {
            this.f10034b.R = z;
            handler = this.f10034b.n;
            handler.postDelayed(new u(this), 500L);
            return;
        }
        com.baidu.platform.comapi.walknavi.d.e.c().a(this.f10033a, true);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i2) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa progress: " + i2);
    }

    @Override // com.baidu.platform.comapi.walknavi.d.c
    public void a(int i2, String str) {
        com.baidu.platform.comapi.wnplatform.d.a.b("aaaaa responseCode = " + i2 + ", responseMessage = " + str);
    }
}
