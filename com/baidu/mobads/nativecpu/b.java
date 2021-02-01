package com.baidu.mobads.nativecpu;

import com.baidu.mobads.nativecpu.NativeCPUManager;
import java.util.List;
/* loaded from: classes5.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f3411a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ NativeCPUManager.a f3412b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NativeCPUManager.a aVar, List list) {
        this.f3412b = aVar;
        this.f3411a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        NativeCPUManager.this.f3404b.onAdLoaded(this.f3411a);
    }
}
