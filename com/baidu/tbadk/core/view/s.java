package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class s implements Runnable {
    final /* synthetic */ r ahf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(r rVar) {
        this.ahf = rVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.ahf.ahe.start();
    }
}
