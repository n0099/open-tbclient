package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes5.dex */
public class k implements Runnable {
    final /* synthetic */ j a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.a = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.a.a.y;
        com.baidu.platform.comapi.wnplatform.o.h.a(context, com.baidu.platform.comapi.walknavi.b.a.a);
    }
}
