package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes4.dex */
public class c implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public c(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.A().runEntryState();
    }
}
