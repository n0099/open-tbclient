package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g Ld;
    private final /* synthetic */ String Le;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.Ld = gVar;
        this.Le = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.dR(this.Le));
    }
}
