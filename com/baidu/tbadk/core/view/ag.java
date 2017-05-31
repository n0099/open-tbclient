package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ag implements Runnable {
    final /* synthetic */ ae alp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ag(ae aeVar) {
        this.alp = aeVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.alp.ale != null) {
            this.alp.ale.start();
        }
    }
}
