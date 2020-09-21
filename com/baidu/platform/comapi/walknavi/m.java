package com.baidu.platform.comapi.walknavi;

import android.content.Context;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class m implements Runnable {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        Context context;
        context = this.a.a.z;
        com.baidu.platform.comapi.wnplatform.p.i.a(context, com.baidu.platform.comapi.walknavi.b.a.a);
    }
}
