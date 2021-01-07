package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes3.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4756a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4757b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.f4757b = bVar;
        this.f4756a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4757b.f4755a.f(this.f4756a);
    }
}
