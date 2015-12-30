package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int Ld;
    final /* synthetic */ j Le;
    private final /* synthetic */ String Lf;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.Le = jVar;
        this.Lf = str;
        this.Ld = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zp = 1;
        gVar = this.Le.La;
        gVar.KW.onSendVoice(this.Lf, this.Ld);
    }
}
