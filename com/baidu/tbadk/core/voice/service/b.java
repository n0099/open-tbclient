package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a aiM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aiM = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aiM.wW();
    }
}
