package com.baidu.tbadk.core.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class n implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public n(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public final void run() {
        int i;
        if (this.a.a == null) {
            return;
        }
        i = this.a.E;
        if (i == 2) {
            y yVar = this.a.a;
        }
    }
}
