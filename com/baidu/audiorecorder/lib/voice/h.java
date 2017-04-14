package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g KE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.KE = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.KE.KA != null && com.baidu.adp.lib.voice.l.zE == 2) {
            this.KE.KA.onStopingRecorder();
        }
    }
}
