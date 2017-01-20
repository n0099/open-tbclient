package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ac implements Runnable {
    final /* synthetic */ aa afV;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ac(aa aaVar) {
        this.afV = aaVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.afV.afL != null) {
            this.afV.afL.start();
        }
    }
}
