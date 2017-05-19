package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class l implements Runnable {
    private final /* synthetic */ int Kb;
    final /* synthetic */ j Kc;
    private final /* synthetic */ String Kd;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.Kc = jVar;
        this.Kd = str;
        this.Kb = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zI = 1;
        gVar = this.Kc.JY;
        gVar.JU.onSendVoice(this.Kd, this.Kb);
    }
}
