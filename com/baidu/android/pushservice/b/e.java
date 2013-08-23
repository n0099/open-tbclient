package com.baidu.android.pushservice.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f596a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f596a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f596a.f();
        this.f596a.c = false;
    }
}
