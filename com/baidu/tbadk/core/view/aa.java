package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class aa implements Runnable {
    final /* synthetic */ y agQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public aa(y yVar) {
        this.agQ = yVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.agQ.agG != null) {
            this.agQ.agG.start();
        }
    }
}
