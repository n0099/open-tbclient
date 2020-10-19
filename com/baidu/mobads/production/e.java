package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2399a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar) {
        this.f2399a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2399a.h.pause();
    }
}
