package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class h implements Runnable {
    final /* synthetic */ g JY;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.JY = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.JY.JU != null && com.baidu.adp.lib.voice.l.zI == 2) {
            this.JY.JU.onStopingRecorder();
        }
    }
}
