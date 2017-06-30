package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class l implements Runnable {
    private final /* synthetic */ int JO;
    final /* synthetic */ j JP;
    private final /* synthetic */ String JQ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.JP = jVar;
        this.JQ = str;
        this.JO = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zI = 1;
        gVar = this.JP.JL;
        gVar.JH.onSendVoice(this.JQ, this.JO);
    }
}
