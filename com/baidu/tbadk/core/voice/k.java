package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
class k implements Runnable {
    private final /* synthetic */ int IG;
    final /* synthetic */ i IH;
    private final /* synthetic */ String II;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, int i) {
        this.IH = iVar;
        this.II = str;
        this.IG = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        voiceManager = this.IH.this$0;
        voiceManager.currRecordState = 1;
        voiceManager2 = this.IH.this$0;
        voiceManager2.recordView.onSendVoice(this.II, this.IG);
    }
}
