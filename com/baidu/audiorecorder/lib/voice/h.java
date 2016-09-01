package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g EB;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.EB = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.EB.Ex != null && com.baidu.adp.lib.voice.l.sU == 2) {
            this.EB.Ex.onStopingRecorder();
        }
    }
}
