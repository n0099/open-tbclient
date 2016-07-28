package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ t adC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.adC = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.adC.ads != null) {
            this.adC.ads.start();
        }
    }
}
