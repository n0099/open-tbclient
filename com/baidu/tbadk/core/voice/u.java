package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
class u implements Runnable {
    final /* synthetic */ t a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public u(t tVar) {
        this.a = tVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        VoiceManager voiceManager3;
        voiceManager = this.a.a;
        y yVar = voiceManager.a;
        voiceManager2 = this.a.a;
        yVar.a(4, voiceManager2.d.getString(com.baidu.tieba.u.voice_error_file_md5));
        voiceManager3 = this.a.a;
        voiceManager3.H = 1;
    }
}
