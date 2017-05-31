package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class l implements Runnable {
    private final /* synthetic */ int JP;
    final /* synthetic */ j JQ;
    private final /* synthetic */ String JR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.JQ = jVar;
        this.JR = str;
        this.JP = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zI = 1;
        gVar = this.JQ.JM;
        gVar.JI.onSendVoice(this.JR, this.JP);
    }
}
