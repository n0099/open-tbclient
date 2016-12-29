package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g EE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.EE = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.EE.EA != null && com.baidu.adp.lib.voice.l.sV == 2) {
            this.EE.EA.onStopingRecorder();
        }
    }
}
