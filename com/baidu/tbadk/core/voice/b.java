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
        i playView;
        playView = this.this$0.getPlayView();
        if (playView != null) {
            this.this$0.startPlay(playView);
        }
    }
}
