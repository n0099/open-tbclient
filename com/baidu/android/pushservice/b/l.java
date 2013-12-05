package com.baidu.android.pushservice.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f704a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f704a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f704a.f();
        this.f704a.c = false;
    }
}
