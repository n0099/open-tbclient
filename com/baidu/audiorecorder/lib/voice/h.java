package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g BN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.BN = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.BN.BJ != null && com.baidu.adp.lib.voice.l.qc == 2) {
            this.BN.BJ.onStopingRecorder();
        }
    }
}
