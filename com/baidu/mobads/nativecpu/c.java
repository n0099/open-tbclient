package com.baidu.mobads.nativecpu;

import com.baidu.mobads.nativecpu.NativeCPUManager;
/* loaded from: classes4.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f2432a;
    final /* synthetic */ int b;
    final /* synthetic */ NativeCPUManager.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NativeCPUManager.a aVar, String str, int i) {
        this.c = aVar;
        this.f2432a = str;
        this.b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NativeCPUManager.this.b.onAdError(this.f2432a, this.b);
    }
}
