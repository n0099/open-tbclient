package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class l implements Runnable {
    private final /* synthetic */ int Ls;
    final /* synthetic */ j Lt;
    private final /* synthetic */ String Lu;

    /* JADX INFO: Access modifiers changed from: package-private */
    public l(j jVar, String str, int i) {
        this.Lt = jVar;
        this.Lu = str;
        this.Ls = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        com.baidu.adp.lib.voice.l.zx = 1;
        gVar = this.Lt.Lp;
        gVar.Ll.onSendVoice(this.Lu, this.Ls);
    }
}
