package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    final /* synthetic */ j LA;
    private final /* synthetic */ String LB;
    private final /* synthetic */ int Lz;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.LA = jVar;
        this.LB = str;
        this.Lz = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zP = 1;
        gVar = this.LA.Lw;
        gVar.Ls.onSendVoice(this.LB, this.Lz);
    }
}
