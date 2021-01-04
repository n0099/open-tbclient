package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes15.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f4581a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f4581a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f4581a.f4580a.z;
        com.baidu.platform.comapi.wnplatform.p.i.a(context, com.baidu.platform.comapi.walknavi.b.a.f4403a);
    }
}
