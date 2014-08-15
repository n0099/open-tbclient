package com.baidu.tbadk.core.voice;

import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ac implements l {
    final /* synthetic */ VoiceManager a;

    private ac(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ac(VoiceManager voiceManager, ac acVar) {
        this(voiceManager);
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void a(String str, int i) {
        this.a.releaseWakeLock();
        this.a.currRecordState = 1;
        if (this.a.mCurRecordVid == null || str == null) {
            com.baidu.tbadk.core.util.r rVar = new com.baidu.tbadk.core.util.r();
            rVar.a("file", str);
            rVar.a("dur", Integer.valueOf(i));
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", rVar.toString());
        } else if (this.a.recordView != null) {
            if (i <= 1000) {
                this.a.recordView.a(2, ae.a(com.baidu.tieba.x.voice_record_short_tip));
                com.baidu.tbadk.core.util.r rVar2 = new com.baidu.tbadk.core.util.r();
                rVar2.a("file", str);
                rVar2.a("dur", Integer.valueOf(i));
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_LEN, "voice too short", rVar2.toString());
            } else if (str.endsWith(this.a.mCurRecordVid)) {
                this.a.doVoiceFileMd5(this.a.mCurRecordVid, (int) Math.round((i * 1.0d) / 1000.0d));
                this.a.mCurRecordVid = null;
            } else {
                com.baidu.tbadk.core.util.r rVar3 = new com.baidu.tbadk.core.util.r();
                rVar3.a("file", str);
                rVar3.a("dur", Integer.valueOf(i));
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", rVar3.toString());
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void a(int i, String str) {
        this.a.releaseWakeLock();
        TiebaStatic.voiceError("", i, "RecoreCallback.error: " + str, "");
        if (this.a.recordView == null) {
            this.a.currRecordState = 1;
        } else if (i != 7) {
            this.a.currRecordState = 1;
            if (i == 8) {
                i = 2;
            }
            this.a.recordView.a(i, str);
            TiebaStatic.voiceError("", i, "RecoreCallback.err: " + str, "");
        } else if (this.a.mCurRecordVid != null) {
            this.a.doVoiceFileMd5(this.a.mCurRecordVid, com.baidu.adp.lib.voice.b.a / 1000);
            this.a.mCurRecordVid = null;
            this.a.recordView.a(3, this.a.context.getString(com.baidu.tieba.x.voice_record_timeout_tip));
        } else {
            TiebaStatic.voiceError("", i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void a(int i) {
        if (this.a.recordView != null) {
            this.a.recordView.c(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void b(int i) {
        if (this.a.recordView != null) {
            this.a.recordView.b(i / 1000);
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void a() {
        this.a.currRecordState = 1;
    }
}
