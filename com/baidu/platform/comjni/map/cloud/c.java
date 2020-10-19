package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes7.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f3182a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.b = bVar;
        this.f3182a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.f3181a.f(this.f3182a);
    }
}
