package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.u;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j Cs;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Cs = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.Cs.Co;
        com.baidu.adp.lib.voice.j jVar = gVar.Ck;
        gVar2 = this.Cs.Co;
        jVar.onShowErr(4, gVar2.context.getString(u.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.qE = 1;
    }
}
