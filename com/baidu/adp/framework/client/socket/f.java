package com.baidu.adp.framework.client.socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e oI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.oI = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.oI.ea();
    }
}
