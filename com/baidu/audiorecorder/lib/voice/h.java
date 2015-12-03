package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g KK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.KK = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.KK.KG != null && com.baidu.adp.lib.voice.l.zn == 2) {
            this.KK.KG.onStopingRecorder();
        }
    }
}
