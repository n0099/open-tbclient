package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j KA;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.KA = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        TbPageContext tbPageContext;
        gVar = this.KA.Kw;
        com.baidu.adp.lib.voice.j jVar = gVar.Ks;
        gVar2 = this.KA.Kw;
        tbPageContext = gVar2.context;
        jVar.onShowErr(4, tbPageContext.getString(com.baidu.tieba.y.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zI = 1;
    }
}
