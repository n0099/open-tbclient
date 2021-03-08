package com.baidu.mobads.nativecpu;

import com.baidu.mobads.nativecpu.NativeCPUManager;
import java.util.List;
/* loaded from: classes4.dex */
class b implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ List f2431a;
    final /* synthetic */ NativeCPUManager.a b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(NativeCPUManager.a aVar, List list) {
        this.b = aVar;
        this.f2431a = list;
    }

    @Override // java.lang.Runnable
    public void run() {
        NativeCPUManager.this.b.onAdLoaded(this.f2431a);
    }
}
