package com.baidu.android.pushservice.b;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class l implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ k f698a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(k kVar) {
        this.f698a = kVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f698a.f();
        this.f698a.c = false;
    }
}
