package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ai implements Runnable {
    final /* synthetic */ ah aad;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ai(ah ahVar) {
        this.aad = ahVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aad.aac.start();
    }
}
