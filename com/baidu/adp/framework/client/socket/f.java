package com.baidu.adp.framework.client.socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e ht;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.ht = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ht.bo();
    }
}
