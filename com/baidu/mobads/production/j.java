package com.baidu.mobads.production;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class j implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ a f2465a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(a aVar) {
        this.f2465a = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.f2465a.h != null) {
            this.f2465a.h.resume();
        }
    }
}
