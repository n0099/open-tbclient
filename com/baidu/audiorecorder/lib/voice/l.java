package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int EG;
    final /* synthetic */ j EH;
    private final /* synthetic */ String EI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.EH = jVar;
        this.EI = str;
        this.EG = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.sV = 1;
        gVar = this.EH.ED;
        gVar.Ez.onSendVoice(this.EI, this.EG);
    }
}
