package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class ab implements Runnable {
    final /* synthetic */ z ahq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public ab(z zVar) {
        this.ahq = zVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.ahq.ahg != null) {
            this.ahq.ahg.start();
        }
    }
}
