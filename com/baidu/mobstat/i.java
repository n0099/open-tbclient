package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f948a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f948a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        b a2 = b.a();
        Context context = this.f948a.f947a;
        z = this.f948a.b.b;
        a2.a(context, z);
    }
}
