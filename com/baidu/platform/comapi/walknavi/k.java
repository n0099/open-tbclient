package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes6.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f4356a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f4356a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f4356a.f4355a.y;
        com.baidu.platform.comapi.wnplatform.o.h.a(context, com.baidu.platform.comapi.walknavi.b.a.f4187a);
    }
}
