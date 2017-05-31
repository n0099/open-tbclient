package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class h implements Runnable {
    final /* synthetic */ g JM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.JM = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.JM.JI != null && com.baidu.adp.lib.voice.l.zI == 2) {
            this.JM.JI.onStopingRecorder();
        }
    }
}
