package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ ab alD;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.alD = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.alD.alt != null) {
            this.alD.alt.start();
        }
    }
}
