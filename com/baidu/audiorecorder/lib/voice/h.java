package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g Lw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Lw = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Lw.Ls != null && com.baidu.adp.lib.voice.l.zP == 2) {
            this.Lw.Ls.onStopingRecorder();
        }
    }
}
