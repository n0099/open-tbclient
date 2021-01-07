package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.mobads.vo.d f3500a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3501b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(b bVar, com.baidu.mobads.vo.d dVar) {
        this.f3501b = bVar;
        this.f3500a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3501b.b(this.f3500a);
    }
}
