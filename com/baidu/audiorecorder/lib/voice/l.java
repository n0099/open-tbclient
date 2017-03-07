package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int Lg;
    final /* synthetic */ j Lh;
    private final /* synthetic */ String Li;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.Lh = jVar;
        this.Li = str;
        this.Lg = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.Ae = 1;
        gVar = this.Lh.Ld;
        gVar.KZ.onSendVoice(this.Li, this.Lg);
    }
}
