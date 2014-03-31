package com.baidu.tbadk.core.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public final class s implements Runnable {
    final /* synthetic */ VoiceManager a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(VoiceManager voiceManager, String str) {
        this.a = voiceManager;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ad.b(com.baidu.tbadk.core.util.w.a(this.b, 1));
    }
}
