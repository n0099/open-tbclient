package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aeH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aeH = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeH.aeG.start();
    }
}
