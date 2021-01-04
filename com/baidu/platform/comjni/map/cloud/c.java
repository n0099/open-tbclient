package com.baidu.platform.comjni.map.cloud;
/* loaded from: classes15.dex */
class c implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4755a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4756b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar, String str) {
        this.f4756b = bVar;
        this.f4755a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4756b.f4754a.f(this.f4755a);
    }
}
