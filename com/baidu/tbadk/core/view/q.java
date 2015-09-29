package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class q implements Runnable {
    final /* synthetic */ p aeB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public q(p pVar) {
        this.aeB = pVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aeB.aeA.start();
    }
}
