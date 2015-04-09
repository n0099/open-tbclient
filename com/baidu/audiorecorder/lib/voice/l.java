package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ j KA;
    private final /* synthetic */ String KB;
    private final /* synthetic */ int Kz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.KA = jVar;
        this.KB = str;
        this.Kz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zI = 1;
        gVar = this.KA.Kw;
        gVar.Ks.onSendVoice(this.KB, this.Kz);
    }
}
