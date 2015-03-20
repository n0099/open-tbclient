package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ ac Za;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ac acVar) {
        this.Za = acVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.Za.YZ.start();
    }
}
