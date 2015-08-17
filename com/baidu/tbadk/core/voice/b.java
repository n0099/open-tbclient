package com.baidu.tbadk.core.voice;

import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.voice.VoiceManager;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class b implements Runnable {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public b(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceData.VoiceModel voiceModel;
        VoiceManager.b bVar;
        VoiceManager voiceManager = this.this$0;
        voiceModel = this.this$0.mNewClickModel;
        voiceManager.mCurPlayModel = voiceModel;
        VoiceManager voiceManager2 = this.this$0;
        bVar = this.this$0.sNewPlayView;
        voiceManager2.sPlayView = bVar;
        this.this$0.sNewPlayView = null;
        this.this$0.setDownloading(this.this$0.mCurPlayModel);
    }
}
