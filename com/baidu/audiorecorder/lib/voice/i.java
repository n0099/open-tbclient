package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g Lp;
    private final /* synthetic */ String Lq;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.Lp = gVar;
        this.Lq = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.aJ(com.baidu.tbadk.core.voice.i.dO(this.Lq));
    }
}
