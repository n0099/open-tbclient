package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class r implements Runnable {
    final /* synthetic */ q afE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public r(q qVar) {
        this.afE = qVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afE.afD.start();
    }
}
