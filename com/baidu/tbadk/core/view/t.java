package com.baidu.tbadk.core.view;
/* loaded from: classes.dex */
class t implements Runnable {
    final /* synthetic */ s agG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public t(s sVar) {
        this.agG = sVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.agG.agF.start();
    }
}
