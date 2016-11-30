package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g ED;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.ED = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.ED.Ez != null && com.baidu.adp.lib.voice.l.sV == 2) {
            this.ED.Ez.onStopingRecorder();
        }
    }
}
