package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ h a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        b a = b.a();
        Context context = this.a.a;
        z = this.a.b.b;
        a.a(context, z);
    }
}
