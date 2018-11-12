package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class h implements Runnable {
    final /* synthetic */ g a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.a = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.a.a.x;
        com.baidu.platform.comapi.wnplatform.o.g.a(context, com.baidu.platform.comapi.walknavi.b.a.a);
    }
}
