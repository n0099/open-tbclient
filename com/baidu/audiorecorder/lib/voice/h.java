package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g Ku;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Ku = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Ku.Kq != null && com.baidu.adp.lib.voice.l.zI == 2) {
            this.Ku.Kq.onStopingRecorder();
        }
    }
}
