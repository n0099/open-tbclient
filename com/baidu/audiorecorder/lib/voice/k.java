package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.r;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j DT;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.DT = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.DT.DP;
        com.baidu.adp.lib.voice.j jVar = gVar.DL;
        gVar2 = this.DT.DP;
        jVar.onShowErr(4, gVar2.context.getString(r.l.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.sM = 1;
    }
}
