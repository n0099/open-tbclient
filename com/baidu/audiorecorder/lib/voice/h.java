package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g Kw;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Kw = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Kw.Ks != null && com.baidu.adp.lib.voice.l.zI == 2) {
            this.Kw.Ks.onStopingRecorder();
        }
    }
}
