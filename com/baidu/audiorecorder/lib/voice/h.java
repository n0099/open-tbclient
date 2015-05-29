package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g Ko;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Ko = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ko.Kk != null && com.baidu.adp.lib.voice.l.zx == 2) {
            this.Ko.Kk.onStopingRecorder();
        }
    }
}
