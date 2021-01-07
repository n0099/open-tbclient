package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes3.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3481a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f3481a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3481a.h.resume();
    }
}
