package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes3.dex */
class c implements Runnable {
    final /* synthetic */ String a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.b = bVar;
        this.a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.a.f(this.a);
    }
}
