package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g EE;
    private final /* synthetic */ String EF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.EE = gVar;
        this.EF = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.dZ(this.EF));
    }
}
