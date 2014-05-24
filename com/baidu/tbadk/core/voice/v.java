package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ t a;
    private final /* synthetic */ String b;
    private final /* synthetic */ int c;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(t tVar, String str, int i) {
        this.a = tVar;
        this.b = str;
        this.c = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        voiceManager = this.a.a;
        voiceManager.currRecordState = 1;
        voiceManager2 = this.a.a;
        voiceManager2.recordView.a(this.b, this.c);
    }
}
