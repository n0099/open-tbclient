package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g KG;
    private final /* synthetic */ String KH;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.KG = gVar;
        this.KH = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.dX(this.KH));
    }
}
