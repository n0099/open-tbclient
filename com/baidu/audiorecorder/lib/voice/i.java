package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g Kw;
    private final /* synthetic */ String Kx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.Kw = gVar;
        this.Kx = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.l.aF(com.baidu.tbadk.core.voice.l.db(this.Kx));
    }
}
