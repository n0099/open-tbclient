package com.baidu.tbadk.core.voice;

import com.baidu.tbadk.core.data.VoiceData;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class m implements Runnable {
    final /* synthetic */ VoiceManager a;

    /* JADX INFO: Access modifiers changed from: package-private */
    public m(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    @Override // java.lang.Runnable
    public void run() {
        VoiceData.VoiceModel voiceModel;
        x xVar;
        VoiceData.VoiceModel voiceModel2;
        VoiceManager voiceManager = this.a;
        voiceModel = this.a.mNewClickModel;
        voiceManager.mCurPlayModel = voiceModel;
        VoiceManager voiceManager2 = this.a;
        xVar = this.a.sNewPlayView;
        voiceManager2.sPlayView = xVar;
        this.a.sNewPlayView = null;
        VoiceManager voiceManager3 = this.a;
        voiceModel2 = this.a.mCurPlayModel;
        voiceManager3.setDownloading(voiceModel2);
    }
}
