package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int KN;
    final /* synthetic */ j KO;
    private final /* synthetic */ String KP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.KO = jVar;
        this.KP = str;
        this.KN = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zn = 1;
        gVar = this.KO.KK;
        gVar.KG.onSendVoice(this.KP, this.KN);
    }
}
