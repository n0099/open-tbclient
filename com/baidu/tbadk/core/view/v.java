package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ t agr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.agr = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.agr.agh != null) {
            this.agr.agh.start();
        }
    }
}
