package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g Lw;
    private final /* synthetic */ String Lx;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.Lw = gVar;
        this.Lx = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.aL(com.baidu.tbadk.core.voice.i.dV(this.Lx));
    }
}
