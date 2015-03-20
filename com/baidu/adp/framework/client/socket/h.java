package com.baidu.adp.framework.client.socket;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class h implements Runnable {
    final /* synthetic */ g oC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.oC = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.oC.dW();
    }
}
