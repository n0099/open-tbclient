package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g La;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.La = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.La.KW != null && com.baidu.adp.lib.voice.l.zp == 2) {
            this.La.KW.onStopingRecorder();
        }
    }
}
