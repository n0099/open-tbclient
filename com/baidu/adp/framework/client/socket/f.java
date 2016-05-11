package com.baidu.adp.framework.client.socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class f implements Runnable {
    final /* synthetic */ e eF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public f(e eVar) {
        this.eF = eVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.eF.at();
    }
}
