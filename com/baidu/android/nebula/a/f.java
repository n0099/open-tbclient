package com.baidu.android.nebula.a;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ e f643a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.f643a = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        new Thread(new g(this)).start();
    }
}
