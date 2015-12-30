package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.n;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j Le;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Le = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.Le.La;
        com.baidu.adp.lib.voice.j jVar = gVar.KW;
        gVar2 = this.Le.La;
        jVar.onShowErr(4, gVar2.context.getString(n.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zp = 1;
    }
}
