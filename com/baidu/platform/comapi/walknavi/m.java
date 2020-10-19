package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class m implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ l f3080a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.f3080a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.f3080a.f3079a.z;
        com.baidu.platform.comapi.wnplatform.p.i.a(context, com.baidu.platform.comapi.walknavi.b.a.f2954a);
    }
}
