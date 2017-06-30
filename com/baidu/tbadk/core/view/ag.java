package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ ae amc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.amc = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.amc.alS != null) {
            this.amc.alS.start();
        }
    }
}
