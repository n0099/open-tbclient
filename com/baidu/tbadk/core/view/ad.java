package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ad implements Runnable {
    final /* synthetic */ ab alo;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ad(ab abVar) {
        this.alo = abVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.alo.ald != null) {
            this.alo.ald.start();
        }
    }
}
