package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g KG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.KG = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.KG.KC != null && com.baidu.adp.lib.voice.l.zH == 2) {
            this.KG.KC.onStopingRecorder();
        }
    }
}
