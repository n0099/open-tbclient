package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class k implements Runnable {
    final /* synthetic */ j JP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.JP = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.JP.JL;
        com.baidu.adp.lib.voice.j jVar = gVar.JH;
        gVar2 = this.JP.JL;
        jVar.onShowErr(4, gVar2.context.getString(w.l.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zI = 1;
    }
}
