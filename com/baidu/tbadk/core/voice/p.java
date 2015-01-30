package com.baidu.tbadk.core.voice;

import android.os.Handler;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class p implements com.baidu.adp.lib.voice.j {
    final /* synthetic */ VoiceManager this$0;

    private p(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ p(VoiceManager voiceManager, p pVar) {
        this(voiceManager);
    }

    @Override // com.baidu.adp.lib.voice.n
    public void j(String str, int i) {
        m mVar;
        VoiceData.VoiceModel voiceModel;
        boolean z;
        m playView;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceData.VoiceModel voiceModel2;
        mVar = this.this$0.sPlayView;
        if (mVar != null) {
            voiceModel = this.this$0.mCurPlayModel;
            if (voiceModel == null) {
                return;
            }
            z = this.this$0.bStopAndReplay;
            if (!z) {
                VoiceManager voiceManager = this.this$0;
                voiceModel2 = this.this$0.mCurPlayModel;
                voiceManager.setStatusWaiting(voiceModel2);
                this.this$0.sPlayView = null;
            }
            this.this$0.mCurPlayModel = null;
            playView = this.this$0.getPlayView();
            z2 = this.this$0.bStopAndReplay;
            if (z2 && playView != null) {
                VoiceData.VoiceModel voiceModel3 = playView.getVoiceModel();
                if (voiceModel3 != null && i >= 0) {
                    voiceModel3.curr_time = i;
                }
                handler = this.this$0.mHandle;
                if (handler != null) {
                    handler2 = this.this$0.mHandle;
                    handler2.removeCallbacks(this.this$0.stopVoiceAndRePlayRunnable);
                    handler3 = this.this$0.mHandle;
                    handler3.postDelayed(this.this$0.stopVoiceAndRePlayRunnable, 10L);
                    return;
                }
                return;
            }
            this.this$0.releaseWakeLock();
        }
    }

    @Override // com.baidu.adp.lib.voice.n
    public void error(int i, String str) {
        m mVar;
        m mVar2;
        VoiceData.VoiceModel voiceModel;
        VoiceData.VoiceModel voiceModel2;
        TiebaStatic.voiceError("", i, str, "");
        mVar = this.this$0.sPlayView;
        if (mVar != null) {
            mVar2 = this.this$0.sPlayView;
            mVar2.onShowErr(i, str);
            voiceModel = this.this$0.mCurPlayModel;
            if (voiceModel != null) {
                VoiceManager voiceManager = this.this$0;
                voiceModel2 = this.this$0.mCurPlayModel;
                voiceManager.setStatusWaiting(voiceModel2);
                this.this$0.mCurPlayModel = null;
            }
            this.this$0.releaseWakeLock();
        }
    }

    @Override // com.baidu.adp.lib.voice.n
    public void ah(int i) {
    }

    @Override // com.baidu.adp.lib.voice.j
    public void ag(int i) {
        m playView;
        VoiceData.VoiceModel voiceModel;
        VoiceData.VoiceModel voiceModel2;
        playView = this.this$0.getPlayView();
        if (playView != null) {
            playView.cu(i);
        }
        voiceModel = this.this$0.mCurPlayModel;
        if (voiceModel != null) {
            voiceModel2 = this.this$0.mCurPlayModel;
            voiceModel2.elapse = i;
        }
    }
}
