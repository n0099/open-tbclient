package com.baidu.tbadk.core.voice;

import com.baidu.tieba.z;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i Ok;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.Ok = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        VoiceManager voiceManager3;
        voiceManager = this.Ok.this$0;
        n nVar = voiceManager.recordView;
        voiceManager2 = this.Ok.this$0;
        nVar.onShowErr(4, voiceManager2.context.getString(z.voice_error_file_md5));
        voiceManager3 = this.Ok.this$0;
        voiceManager3.currRecordState = 1;
    }
}
