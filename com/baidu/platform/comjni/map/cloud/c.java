package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes4.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4482a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4483b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.f4483b = bVar;
        this.f4482a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4483b.f4481a.f(this.f4482a);
    }
}
