package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f9712a;

    public k(j jVar) {
        this.f9712a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f9712a.f9711a.y;
        com.baidu.platform.comapi.wnplatform.o.h.a(context, com.baidu.platform.comapi.walknavi.b.a.f9461a);
    }
}
