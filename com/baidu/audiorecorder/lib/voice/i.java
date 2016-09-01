package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g EB;
    private final /* synthetic */ String EC;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.EB = gVar;
        this.EC = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.dX(this.EC));
    }
}
