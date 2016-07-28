package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class h implements Runnable {
    final /* synthetic */ g Co;

    /* JADX INFO: Access modifiers changed from: package-private */
    public h(g gVar) {
        this.Co = gVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        if (this.Co.Ck != null && com.baidu.adp.lib.voice.l.qE == 2) {
            this.Co.Ck.onStopingRecorder();
        }
    }
}
