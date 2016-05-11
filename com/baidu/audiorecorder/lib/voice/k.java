package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.t;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j BR;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.BR = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.BR.BN;
        com.baidu.adp.lib.voice.j jVar = gVar.BJ;
        gVar2 = this.BR.BN;
        jVar.onShowErr(4, gVar2.context.getString(t.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.qc = 1;
    }
}
