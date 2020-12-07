package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class n implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ com.baidu.mobads.vo.d f2423a;
    final /* synthetic */ b b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(b bVar, com.baidu.mobads.vo.d dVar) {
        this.b = bVar;
        this.f2423a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.b.b(this.f2423a);
    }
}
