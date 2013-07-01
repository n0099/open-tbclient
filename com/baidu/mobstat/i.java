package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f582a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f582a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        b a2 = b.a();
        Context context = this.f582a.f581a;
        z = this.f582a.b.b;
        a2.a(context, z);
    }
}
