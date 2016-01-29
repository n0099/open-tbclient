package com.baidu.tbadk.core.voice;

import com.baidu.tbadk.core.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class d implements Runnable {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public d(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager.b playView = this.this$0.getPlayView();
        if (playView != null) {
            this.this$0.startPlay(playView);
        }
    }
}
