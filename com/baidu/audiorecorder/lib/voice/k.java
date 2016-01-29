package com.baidu.audiorecorder.lib.voice;

import com.baidu.tieba.t;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j Lt;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Lt = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        gVar = this.Lt.Lp;
        com.baidu.adp.lib.voice.j jVar = gVar.Ll;
        gVar2 = this.Lt.Lp;
        jVar.onShowErr(4, gVar2.context.getString(t.j.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zx = 1;
    }
}
