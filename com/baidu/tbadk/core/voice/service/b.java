package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a afI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.afI = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afI.vM();
    }
}
