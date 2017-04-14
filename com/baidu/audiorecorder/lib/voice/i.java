package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g KE;
    private final /* synthetic */ String KF;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.KE = gVar;
        this.KF = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.dX(this.KF));
    }
}
