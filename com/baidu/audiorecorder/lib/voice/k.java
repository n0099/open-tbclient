package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j Ks;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Ks = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        TbPageContext tbPageContext;
        gVar = this.Ks.Ko;
        com.baidu.adp.lib.voice.j jVar = gVar.Kk;
        gVar2 = this.Ks.Ko;
        tbPageContext = gVar2.context;
        jVar.onShowErr(4, tbPageContext.getString(com.baidu.tieba.t.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zx = 1;
    }
}
