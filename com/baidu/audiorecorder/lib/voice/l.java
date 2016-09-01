package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int EE;
    final /* synthetic */ j EF;
    private final /* synthetic */ String EG;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.EF = jVar;
        this.EG = str;
        this.EE = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.sU = 1;
        gVar = this.EF.EB;
        gVar.Ex.onSendVoice(this.EG, this.EE);
    }
}
