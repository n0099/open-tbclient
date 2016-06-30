package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ t acR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.acR = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.acR.acH != null) {
            this.acR.acH.start();
        }
    }
}
