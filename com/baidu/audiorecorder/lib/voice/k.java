package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.r;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j EH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.EH = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.EH.ED;
        com.baidu.adp.lib.voice.j jVar = gVar.Ez;
        gVar2 = this.EH.ED;
        jVar.onShowErr(4, gVar2.context.getString(r.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.sV = 1;
    }
}
