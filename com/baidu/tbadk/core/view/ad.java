package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ ab alC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.alC = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.alC.als != null) {
            this.alC.als.start();
        }
    }
}
