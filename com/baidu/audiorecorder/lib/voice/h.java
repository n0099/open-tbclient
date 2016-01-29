package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g Lp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Lp = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Lp.Ll != null && com.baidu.adp.lib.voice.l.zx == 2) {
            this.Lp.Ll.onStopingRecorder();
        }
    }
}
