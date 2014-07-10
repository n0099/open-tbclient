package com.baidu.tbadk.core.voice;
/* loaded from: classes.dex */
class v implements Runnable {
    final /* synthetic */ u a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public v(u uVar) {
        this.a = uVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        VoiceManager voiceManager3;
        voiceManager = this.a.a;
        z zVar = voiceManager.recordView;
        voiceManager2 = this.a.a;
        zVar.a(4, voiceManager2.context.getString(com.baidu.tieba.y.voice_error_file_md5));
        voiceManager3 = this.a.a;
        voiceManager3.currRecordState = 1;
    }
}
