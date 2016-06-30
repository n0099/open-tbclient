package com.baidu.tbadk.core.voice.service;
/* loaded from: classes.dex */
class b implements Runnable {
    final /* synthetic */ a afi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(a aVar) {
        this.afi = aVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        this.afi.vY();
    }
}
