package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g KK;
    private final /* synthetic */ String KL;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.KK = gVar;
        this.KL = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.h.aK(com.baidu.tbadk.core.voice.h.dM(this.KL));
    }
}
