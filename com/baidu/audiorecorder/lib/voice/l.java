package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int KH;
    final /* synthetic */ j KI;
    private final /* synthetic */ String KJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.KI = jVar;
        this.KJ = str;
        this.KH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zE = 1;
        gVar = this.KI.KE;
        gVar.KA.onSendVoice(this.KJ, this.KH);
    }
}
