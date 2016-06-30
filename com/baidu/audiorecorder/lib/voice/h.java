package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g BO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.BO = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.BO.BK != null && com.baidu.adp.lib.voice.l.qc == 2) {
            this.BO.BK.onStopingRecorder();
        }
    }
}
