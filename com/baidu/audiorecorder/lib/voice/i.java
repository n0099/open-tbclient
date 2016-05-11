package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g BN;
    private final /* synthetic */ String BO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.BN = gVar;
        this.BO = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.aE(com.baidu.tbadk.core.voice.i.dR(this.BO));
    }
}
