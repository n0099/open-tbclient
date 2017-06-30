package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes2.dex */
class i implements Runnable {
    final /* synthetic */ g JL;
    private final /* synthetic */ String JM;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.JL = gVar;
        this.JM = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.eo(this.JM));
    }
}
