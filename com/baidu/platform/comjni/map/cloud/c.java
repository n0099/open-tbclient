package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes7.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3184a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.b = bVar;
        this.f3184a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f3183a.f(this.f3184a);
    }
}
