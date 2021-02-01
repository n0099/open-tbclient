package com.baidu.mobads.nativecpu;

import com.baidu.mobads.nativecpu.NativeCPUManager;
/* loaded from: classes5.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3413a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ int f3414b;
    final /* synthetic */ NativeCPUManager.a c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(NativeCPUManager.a aVar, String str, int i) {
        this.c = aVar;
        this.f3413a = str;
        this.f3414b = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        NativeCPUManager.this.f3404b.onAdError(this.f3413a, this.f3414b);
    }
}
