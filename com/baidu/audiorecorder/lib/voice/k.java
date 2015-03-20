package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.TbPageContext;
/* loaded from: classes.dex */
class k implements Runnable {
    final /* synthetic */ j Ky;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(j jVar) {
        this.Ky = jVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        g gVar;
        g gVar2;
        TbPageContext tbPageContext;
        gVar = this.Ky.Ku;
        com.baidu.adp.lib.voice.j jVar = gVar.Kq;
        gVar2 = this.Ky.Ku;
        tbPageContext = gVar2.context;
        jVar.onShowErr(4, tbPageContext.getString(com.baidu.tieba.y.voice_error_file_md5));
        com.baidu.adp.lib.voice.l.zI = 1;
    }
}
