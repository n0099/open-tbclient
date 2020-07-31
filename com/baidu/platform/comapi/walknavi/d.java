package com.baidu.platform.comapi.walknavi;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes10.dex */
public class d implements Runnable {
    final /* synthetic */ b a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(b bVar) {
        this.a = bVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.a.F().runEntryState();
    }
}
