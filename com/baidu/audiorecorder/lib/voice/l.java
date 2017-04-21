package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int KJ;
    final /* synthetic */ j KK;
    private final /* synthetic */ String KL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.KK = jVar;
        this.KL = str;
        this.KJ = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zH = 1;
        gVar = this.KK.KG;
        gVar.KC.onSendVoice(this.KL, this.KJ);
    }
}
