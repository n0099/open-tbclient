package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class i implements Runnable {
    final /* synthetic */ g JM;
    private final /* synthetic */ String JN;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.JM = gVar;
        this.JN = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.dU(this.JN));
    }
}
