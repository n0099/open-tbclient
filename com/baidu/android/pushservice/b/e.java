package com.baidu.android.pushservice.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f687a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f687a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f687a.f();
        this.f687a.c = false;
    }
}
