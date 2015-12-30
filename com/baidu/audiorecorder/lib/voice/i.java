package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g La;
    private final /* synthetic */ String Lb;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.La = gVar;
        this.Lb = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.h.aK(com.baidu.tbadk.core.voice.h.dP(this.Lb));
    }
}
