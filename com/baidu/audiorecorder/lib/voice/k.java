package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.w;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j KI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.KI = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.KI.KE;
        com.baidu.adp.lib.voice.j jVar = gVar.KA;
        gVar2 = this.KI.KE;
        jVar.onShowErr(4, gVar2.context.getString(w.l.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zE = 1;
    }
}
