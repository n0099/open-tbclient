package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f10154a;

    public k(j jVar) {
        this.f10154a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f10154a.f10153a.y;
        com.baidu.platform.comapi.wnplatform.o.h.a(context, com.baidu.platform.comapi.walknavi.b.a.f9903a);
    }
}
