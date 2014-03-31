package com.baidu.tbadk.core.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class p implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public p(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Boolean bool;
        Boolean bool2;
        bool = this.a.A;
        if (bool != null) {
            bool2 = this.a.A;
            if (bool2.booleanValue()) {
                this.a.l();
            } else {
                this.a.m();
            }
        }
    }
}
