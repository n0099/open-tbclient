package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
class m implements Runnable {
    final /* synthetic */ l a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(l lVar) {
        this.a = lVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        k kVar = this.a.b;
        Context context = this.a.a;
        z = this.a.b.b;
        kVar.a(context, z);
    }
}
