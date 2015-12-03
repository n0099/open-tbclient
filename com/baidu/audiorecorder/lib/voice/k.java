package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.n;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j KO;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.KO = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.KO.KK;
        com.baidu.adp.lib.voice.j jVar = gVar.KG;
        gVar2 = this.KO.KK;
        jVar.onShowErr(4, gVar2.context.getString(n.i.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zn = 1;
    }
}
