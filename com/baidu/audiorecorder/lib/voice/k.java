package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.t;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j EF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.EF = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.EF.EB;
        com.baidu.adp.lib.voice.j jVar = gVar.Ex;
        gVar2 = this.EF.EB;
        jVar.onShowErr(4, gVar2.context.getString(t.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.sU = 1;
    }
}
