package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
class k implements Runnable {
    private final /* synthetic */ int Og;
    final /* synthetic */ i Oh;
    private final /* synthetic */ String Oi;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, int i) {
        this.Oh = iVar;
        this.Oi = str;
        this.Og = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        voiceManager = this.Oh.this$0;
        voiceManager.currRecordState = 1;
        voiceManager2 = this.Oh.this$0;
        voiceManager2.recordView.onSendVoice(this.Oi, this.Og);
    }
}
