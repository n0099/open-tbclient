package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes7.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ b f2404a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(b bVar) {
        this.f2404a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f2404a.h.resume();
    }
}
