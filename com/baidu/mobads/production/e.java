package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes14.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f3438a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f3438a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f3438a.h.pause();
    }
}
