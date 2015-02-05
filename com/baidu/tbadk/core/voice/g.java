package com.baidu.tbadk.core.voice;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class g implements Runnable {
    private final /* synthetic */ String Oe;
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public g(VoiceManager voiceManager, String str) {
        this.this$0 = voiceManager;
        this.Oe = str;
    }

    @Override // java.lang.Runnable
    public void run() {
        r.ax(r.cS(this.Oe));
    }
}
