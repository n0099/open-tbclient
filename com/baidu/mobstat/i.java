package com.baidu.mobstat;

import android.content.Context;
/* loaded from: classes.dex */
class i implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ h f784a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(h hVar) {
        this.f784a = hVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        boolean z;
        b a2 = b.a();
        Context context = this.f784a.f783a;
        z = this.f784a.b.b;
        a2.a(context, z);
    }
}
