package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* loaded from: classes2.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    public final /* synthetic */ j f10072a;

    public k(j jVar) {
        this.f10072a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f10072a.f10071a.y;
        com.baidu.platform.comapi.wnplatform.o.h.a(context, com.baidu.platform.comapi.walknavi.b.a.f9816a);
    }
}
