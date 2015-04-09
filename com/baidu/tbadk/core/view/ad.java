package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ ac Zc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.Zc = acVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Zc.Zb.start();
    }
}
