package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g Ko;
    private final /* synthetic */ String Kp;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.Ko = gVar;
        this.Kp = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.l.aO(com.baidu.tbadk.core.voice.l.ds(this.Kp));
    }
}
