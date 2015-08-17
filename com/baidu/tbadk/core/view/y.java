package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class y implements Runnable {
    final /* synthetic */ x afe;

    /* JADX INFO: Access modifiers changed from: package-private */
    public y(x xVar) {
        this.afe = xVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afe.afd.start();
    }
}
