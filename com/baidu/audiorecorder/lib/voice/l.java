package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int DS;
    final /* synthetic */ j DT;
    private final /* synthetic */ String DU;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.DT = jVar;
        this.DU = str;
        this.DS = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.sM = 1;
        gVar = this.DT.DP;
        gVar.DL.onSendVoice(this.DU, this.DS);
    }
}
