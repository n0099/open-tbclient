package com.baidu.tbadk.core.voice;

import android.os.Handler;
import com.baidu.tbadk.core.data.VoiceData;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements j {
    final /* synthetic */ VoiceManager a;

    private ab(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(VoiceManager voiceManager, ab abVar) {
        this(voiceManager);
    }

    @Override // com.baidu.adp.lib.voice.c
    public void a(String str, int i) {
        y yVar;
        VoiceData.VoiceModel voiceModel;
        boolean z;
        y playView;
        boolean z2;
        Handler handler;
        Handler handler2;
        Handler handler3;
        VoiceData.VoiceModel voiceModel2;
        yVar = this.a.sPlayView;
        if (yVar != null) {
            voiceModel = this.a.mCurPlayModel;
            if (voiceModel == null) {
                return;
            }
            z = this.a.bStopAndReplay;
            if (!z) {
                VoiceManager voiceManager = this.a;
                voiceModel2 = this.a.mCurPlayModel;
                voiceManager.setStatusWaiting(voiceModel2);
                this.a.sPlayView = null;
            }
            this.a.mCurPlayModel = null;
            playView = this.a.getPlayView();
            z2 = this.a.bStopAndReplay;
            if (z2 && playView != null) {
                VoiceData.VoiceModel voiceModel3 = playView.getVoiceModel();
                if (voiceModel3 != null && i >= 0) {
                    voiceModel3.curr_time = i;
                }
                handler = this.a.mHandle;
                if (handler != null) {
                    handler2 = this.a.mHandle;
                    handler2.removeCallbacks(this.a.stopVoiceAndRePlayRunnable);
                    handler3 = this.a.mHandle;
                    handler3.postDelayed(this.a.stopVoiceAndRePlayRunnable, 10L);
                    return;
                }
                return;
            }
            this.a.releaseWakeLock();
        }
    }

    @Override // com.baidu.adp.lib.voice.c
    public void a(int i, String str) {
        y yVar;
        y yVar2;
        VoiceData.VoiceModel voiceModel;
        VoiceData.VoiceModel voiceModel2;
        TiebaStatic.voiceError("", i, str, "");
        yVar = this.a.sPlayView;
        if (yVar != null) {
            yVar2 = this.a.sPlayView;
            yVar2.a(i, str);
            voiceModel = this.a.mCurPlayModel;
            if (voiceModel != null) {
                VoiceManager voiceManager = this.a;
                voiceModel2 = this.a.mCurPlayModel;
                voiceManager.setStatusWaiting(voiceModel2);
                this.a.mCurPlayModel = null;
            }
            this.a.releaseWakeLock();
        }
    }

    @Override // com.baidu.tbadk.core.voice.j
    public void a(int i) {
        y playView;
        VoiceData.VoiceModel voiceModel;
        VoiceData.VoiceModel voiceModel2;
        playView = this.a.getPlayView();
        if (playView != null) {
            playView.a(i);
        }
        voiceModel = this.a.mCurPlayModel;
        if (voiceModel != null) {
            voiceModel2 = this.a.mCurPlayModel;
            voiceModel2.elapse = i;
        }
    }
}
