package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g BO;
    private final /* synthetic */ String BP;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.BO = gVar;
        this.BP = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.aE(com.baidu.tbadk.core.voice.i.dV(this.BP));
    }
}
