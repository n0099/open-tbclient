package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class e implements Runnable {

    /* renamed from: a  reason: collision with root package name */
    final /* synthetic */ String f4266a;

    /* renamed from: b  reason: collision with root package name */
    final /* synthetic */ b f4267b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public e(b bVar, String str) {
        this.f4267b = bVar;
        this.f4266a = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.f4267b.F().setInitialState(this.f4266a);
        this.f4267b.F().runCurrentState();
    }
}
