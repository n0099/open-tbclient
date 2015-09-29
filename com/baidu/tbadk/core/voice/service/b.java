package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a aff;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.aff = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.aff.vK();
    }
}
