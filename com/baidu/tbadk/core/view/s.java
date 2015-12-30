package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ r agr;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.agr = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.agr.agq.start();
    }
}
