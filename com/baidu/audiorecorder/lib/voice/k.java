package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.r;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j EI;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.EI = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.EI.EE;
        com.baidu.adp.lib.voice.j jVar = gVar.EA;
        gVar2 = this.EI.EE;
        jVar.onShowErr(4, gVar2.context.getString(r.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.sV = 1;
    }
}
