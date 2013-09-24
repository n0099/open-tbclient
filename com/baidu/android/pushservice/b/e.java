package com.baidu.android.pushservice.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ d f608a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(d dVar) {
        this.f608a = dVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f608a.f();
        this.f608a.c = false;
    }
}
