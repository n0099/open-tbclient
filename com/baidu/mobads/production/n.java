package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.mobads.vo.d f3462a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f3463b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(b bVar, com.baidu.mobads.vo.d dVar) {
        this.f3463b = bVar;
        this.f3462a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3463b.b(this.f3462a);
    }
}
