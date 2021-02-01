package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class k implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ j f4359a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.f4359a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f4359a.f4358a.y;
        com.baidu.platform.comapi.wnplatform.o.h.a(context, com.baidu.platform.comapi.walknavi.b.a.f4190a);
    }
}
