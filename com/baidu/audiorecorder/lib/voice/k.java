package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.u;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j BS;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.BS = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.BS.BO;
        com.baidu.adp.lib.voice.j jVar = gVar.BK;
        gVar2 = this.BS.BO;
        jVar.onShowErr(4, gVar2.context.getString(u.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.qc = 1;
    }
}
