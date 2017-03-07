package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g Ld;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Ld = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ld.KZ != null && com.baidu.adp.lib.voice.l.Ae == 2) {
            this.Ld.KZ.onStopingRecorder();
        }
    }
}
