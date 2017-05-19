package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.w;
/* loaded from: classes2.dex */
class k implements Runnable {
    final /* synthetic */ j Kc;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Kc = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.Kc.JY;
        com.baidu.adp.lib.voice.j jVar = gVar.JU;
        gVar2 = this.Kc.JY;
        jVar.onShowErr(4, gVar2.context.getString(w.l.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zI = 1;
    }
}
