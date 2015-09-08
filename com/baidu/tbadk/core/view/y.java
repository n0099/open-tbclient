package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x afo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.afo = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afo.afn.start();
    }
}
