package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aeC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aeC = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeC.aeB.start();
    }
}
