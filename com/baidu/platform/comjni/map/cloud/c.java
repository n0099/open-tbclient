package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes6.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4479a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4480b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.f4480b = bVar;
        this.f4479a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4480b.f4478a.f(this.f4479a);
    }
}
