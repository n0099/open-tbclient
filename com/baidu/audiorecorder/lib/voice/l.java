package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int Kx;
    final /* synthetic */ j Ky;
    private final /* synthetic */ String Kz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.Ky = jVar;
        this.Kz = str;
        this.Kx = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zI = 1;
        gVar = this.Ky.Ku;
        gVar.Kq.onSendVoice(this.Kz, this.Kx);
    }
}
