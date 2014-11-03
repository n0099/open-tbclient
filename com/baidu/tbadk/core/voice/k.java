package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
class k implements Runnable {
    private final /* synthetic */ int IH;
    final /* synthetic */ i II;
    private final /* synthetic */ String IJ;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, int i) {
        this.II = iVar;
        this.IJ = str;
        this.IH = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        voiceManager = this.II.this$0;
        voiceManager.currRecordState = 1;
        voiceManager2 = this.II.this$0;
        voiceManager2.recordView.onSendVoice(this.IJ, this.IH);
    }
}
