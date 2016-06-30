package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int BR;
    final /* synthetic */ j BS;
    private final /* synthetic */ String BT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.BS = jVar;
        this.BT = str;
        this.BR = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.qc = 1;
        gVar = this.BS.BO;
        gVar.BK.onSendVoice(this.BT, this.BR);
    }
}
