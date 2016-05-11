package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int BQ;
    final /* synthetic */ j BR;
    private final /* synthetic */ String BS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.BR = jVar;
        this.BS = str;
        this.BQ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.qc = 1;
        gVar = this.BR.BN;
        gVar.BJ.onSendVoice(this.BS, this.BQ);
    }
}
