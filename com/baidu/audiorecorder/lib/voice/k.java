package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.w;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j Lh;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Lh = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.Lh.Ld;
        com.baidu.adp.lib.voice.j jVar = gVar.KZ;
        gVar2 = this.Lh.Ld;
        jVar.onShowErr(4, gVar2.context.getString(w.l.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.Ae = 1;
    }
}
