package com.baidu.tbadk.core.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        Boolean bool;
        Boolean bool2;
        bool = this.a.bSpeakerphoneOn;
        if (bool != null) {
            bool2 = this.a.bSpeakerphoneOn;
            if (bool2.booleanValue()) {
                this.a.openSpeaker();
            } else {
                this.a.closeSpeaker();
            }
        }
    }
}
