package com.baidu.tbadk.core.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class s implements Runnable {
    final /* synthetic */ VoiceManager a;
    private final /* synthetic */ String b;

    /* JADX INFO: Access modifiers changed from: package-private */
    public s(VoiceManager voiceManager, String str) {
        this.a = voiceManager;
        this.b = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        ad.d(ad.b(this.b));
    }
}
