package com.baidu.audiorecorder.lib.voice;
/* loaded from: classes.dex */
class i implements Runnable {
    final /* synthetic */ g Ku;
    private final /* synthetic */ String Kv;

    /* JADX INFO: Access modifiers changed from: package-private */
    public i(g gVar, String str) {
        this.Ku = gVar;
        this.Kv = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        com.baidu.tbadk.core.voice.l.aF(com.baidu.tbadk.core.voice.l.db(this.Kv));
    }
}
