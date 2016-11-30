package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g ED;
    private final /* synthetic */ String EE;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.ED = gVar;
        this.EE = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.i.delFile(com.baidu.tbadk.core.voice.i.ec(this.EE));
    }
}
