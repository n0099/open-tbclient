package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g DP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.DP = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.DP.DL != null && com.baidu.adp.lib.voice.l.sM == 2) {
            this.DP.DL.onStopingRecorder();
        }
    }
}
