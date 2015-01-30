package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
class k implements Runnable {
    private final /* synthetic */ int Oj;
    final /* synthetic */ i Ok;
    private final /* synthetic */ String Ol;

    /* JADX INFO: Access modifiers changed from: package-private */
    public k(i iVar, String str, int i) {
        this.Ok = iVar;
        this.Ol = str;
        this.Oj = i;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        voiceManager = this.Ok.this$0;
        voiceManager.currRecordState = 1;
        voiceManager2 = this.Ok.this$0;
        voiceManager2.recordView.onSendVoice(this.Ol, this.Oj);
    }
}
