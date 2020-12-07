package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes26.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3186a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.b = bVar;
        this.f3186a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f3185a.f(this.f3186a);
    }
}
