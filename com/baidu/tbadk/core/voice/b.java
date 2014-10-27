package com.baidu.tbadk.core.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        int i;
        if (this.this$0.recordView == null) {
            return;
        }
        i = this.this$0.currRecordState;
        if (i == 2) {
            this.this$0.recordView.onStopingRecorder();
        }
    }
}
