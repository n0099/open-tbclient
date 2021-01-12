package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3443a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f3443a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3443a.h.resume();
    }
}
