package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3476a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f3476a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3476a.h.pause();
    }
}
