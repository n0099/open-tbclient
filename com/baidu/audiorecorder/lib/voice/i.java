package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class i implements Runnable {
    final /* synthetic */ g JY;
    private final /* synthetic */ String JZ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.JY = gVar;
        this.JZ = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.dW(this.JZ));
    }
}
