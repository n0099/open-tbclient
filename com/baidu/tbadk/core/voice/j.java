package com.baidu.tbadk.core.voice;

import com.baidu.tieba.y;
/* loaded from: classes.dex */
class j implements Runnable {
    final /* synthetic */ i II;

    /* JADX INFO: Access modifiers changed from: package-private */
    public j(i iVar) {
        this.II = iVar;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceManager voiceManager;
        VoiceManager voiceManager2;
        VoiceManager voiceManager3;
        voiceManager = this.II.this$0;
        n nVar = voiceManager.recordView;
        voiceManager2 = this.II.this$0;
        nVar.onShowErr(4, voiceManager2.context.getString(y.voice_error_file_md5));
        voiceManager3 = this.II.this$0;
        voiceManager3.currRecordState = 1;
    }
}
