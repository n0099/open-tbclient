package com.baidu.tbadk.core.voice;

import com.baidu.tbadk.core.data.VoiceData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class a implements Runnable {
    final /* synthetic */ VoiceManager this$0;

    /* JADX INFO: Access modifiers changed from: package-private */
    public a(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceData.VoiceModel voiceModel;
        m mVar;
        VoiceData.VoiceModel voiceModel2;
        VoiceManager voiceManager = this.this$0;
        voiceModel = this.this$0.mNewClickModel;
        voiceManager.mCurPlayModel = voiceModel;
        VoiceManager voiceManager2 = this.this$0;
        mVar = this.this$0.sNewPlayView;
        voiceManager2.sPlayView = mVar;
        this.this$0.sNewPlayView = null;
        VoiceManager voiceManager3 = this.this$0;
        voiceModel2 = this.this$0.mCurPlayModel;
        voiceManager3.setDownloading(voiceModel2);
    }
}
