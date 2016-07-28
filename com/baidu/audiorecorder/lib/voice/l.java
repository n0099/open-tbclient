package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int Cr;
    final /* synthetic */ j Cs;
    private final /* synthetic */ String Ct;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.Cs = jVar;
        this.Ct = str;
        this.Cr = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.qE = 1;
        gVar = this.Cs.Co;
        gVar.Ck.onSendVoice(this.Ct, this.Cr);
    }
}
