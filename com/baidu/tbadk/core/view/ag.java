package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ ae alz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.alz = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.alz.alp != null) {
            this.alz.alp.start();
        }
    }
}
