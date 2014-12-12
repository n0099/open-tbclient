package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
class k implements Runnable {
    private final /* synthetic */ int NI;
    final /* synthetic */ i NJ;
    private final /* synthetic */ String NK;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, int i) {
        this.NJ = iVar;
        this.NK = str;
        this.NI = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        voiceManager = this.NJ.this$0;
        voiceManager.currRecordState = 1;
        voiceManager2 = this.NJ.this$0;
        voiceManager2.recordView.onSendVoice(this.NK, this.NI);
    }
}
