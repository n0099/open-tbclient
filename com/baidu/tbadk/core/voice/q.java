package com.baidu.tbadk.core.voice;

import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tieba.z;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class q implements com.baidu.adp.lib.voice.p {
    final /* synthetic */ VoiceManager this$0;

    private q(VoiceManager voiceManager) {
        this.this$0 = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ q(VoiceManager voiceManager, q qVar) {
        this(voiceManager);
    }

    @Override // com.baidu.adp.lib.voice.n
    public void j(String str, int i) {
        this.this$0.releaseWakeLock();
        this.this$0.currRecordState = 1;
        if (this.this$0.mCurRecordVid == null || str == null) {
            com.baidu.tbadk.core.util.r rVar = new com.baidu.tbadk.core.util.r();
            rVar.h("file", str);
            rVar.h("dur", Integer.valueOf(i));
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", rVar.toString());
        } else if (this.this$0.recordView != null) {
            if (i <= 1000) {
                this.this$0.recordView.onShowErr(2, com.baidu.adp.lib.voice.q.getString(z.voice_record_short_tip));
                com.baidu.tbadk.core.util.r rVar2 = new com.baidu.tbadk.core.util.r();
                rVar2.h("file", str);
                rVar2.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_LEN, "voice too short", rVar2.toString());
            } else if (str.endsWith(this.this$0.mCurRecordVid)) {
                this.this$0.doVoiceFileMd5(this.this$0.mCurRecordVid, (int) Math.round((i * 1.0d) / 1000.0d));
                this.this$0.mCurRecordVid = null;
            } else {
                com.baidu.tbadk.core.util.r rVar3 = new com.baidu.tbadk.core.util.r();
                rVar3.h("file", str);
                rVar3.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", rVar3.toString());
            }
        }
    }

    @Override // com.baidu.adp.lib.voice.n
    public void error(int i, String str) {
        this.this$0.releaseWakeLock();
        TiebaStatic.voiceError("", i, "RecoreCallback.error: " + str, "");
        if (this.this$0.recordView == null) {
            this.this$0.currRecordState = 1;
        } else if (i != 7) {
            this.this$0.currRecordState = 1;
            if (i == 8) {
                i = 2;
            }
            this.this$0.recordView.onShowErr(i, str);
            TiebaStatic.voiceError("", i, "RecoreCallback.err: " + str, "");
        } else if (this.this$0.mCurRecordVid != null) {
            this.this$0.doVoiceFileMd5(this.this$0.mCurRecordVid, com.baidu.adp.lib.voice.m.oE / 1000);
            this.this$0.mCurRecordVid = null;
            this.this$0.recordView.onShowErr(3, this.this$0.context.getString(z.voice_record_timeout_tip));
        } else {
            TiebaStatic.voiceError("", i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
        }
    }

    @Override // com.baidu.adp.lib.voice.n
    public void ah(int i) {
        if (this.this$0.recordView != null) {
            this.this$0.recordView.onShowRecording(i);
        }
    }

    @Override // com.baidu.adp.lib.voice.p
    public void aj(int i) {
        if (this.this$0.recordView != null) {
            this.this$0.recordView.onShowRecordTime(i / 1000);
        }
    }

    @Override // com.baidu.adp.lib.voice.p
    public void fK() {
        this.this$0.currRecordState = 1;
    }
}
