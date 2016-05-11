package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ t acw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar) {
        this.acw = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.acw.acm.start();
    }
}
