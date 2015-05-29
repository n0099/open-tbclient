package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int Kr;
    final /* synthetic */ j Ks;
    private final /* synthetic */ String Kt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.Ks = jVar;
        this.Kt = str;
        this.Kr = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zx = 1;
        gVar = this.Ks.Ko;
        gVar.Kk.onSendVoice(this.Kt, this.Kr);
    }
}
