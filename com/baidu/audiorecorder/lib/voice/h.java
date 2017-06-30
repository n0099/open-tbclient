package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class h implements Runnable {
    final /* synthetic */ g JL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.JL = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.JL.JH != null && com.baidu.adp.lib.voice.l.zI == 2) {
            this.JL.JH.onStopingRecorder();
        }
    }
}
