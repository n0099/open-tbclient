package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.t;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j LA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.LA = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.LA.Lw;
        com.baidu.adp.lib.voice.j jVar = gVar.Ls;
        gVar2 = this.LA.Lw;
        jVar.onShowErr(4, gVar2.context.getString(t.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zP = 1;
    }
}
