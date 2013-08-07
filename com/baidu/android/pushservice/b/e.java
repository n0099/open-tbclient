package com.baidu.android.pushservice.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f573a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f573a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f573a.f();
        this.f573a.c = false;
    }
}
