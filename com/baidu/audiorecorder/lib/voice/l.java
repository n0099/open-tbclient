package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int EH;
    final /* synthetic */ j EI;
    private final /* synthetic */ String EJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.EI = jVar;
        this.EJ = str;
        this.EH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.sV = 1;
        gVar = this.EI.EE;
        gVar.EA.onSendVoice(this.EJ, this.EH);
    }
}
