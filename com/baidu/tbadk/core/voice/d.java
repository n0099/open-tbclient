package com.baidu.tbadk.core.voice;
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
        Boolean bool;
        Boolean bool2;
        bool = this.this$0.bSpeakerphoneOn;
        if (bool != null) {
            bool2 = this.this$0.bSpeakerphoneOn;
            if (bool2.booleanValue()) {
                this.this$0.openSpeaker();
            } else {
                this.this$0.closeSpeaker();
            }
        }
    }
}
