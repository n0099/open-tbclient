package com.baidu.tbadk.core.voice;

import com.baidu.adp.lib.util.BdLog;
import com.baidu.location.LocationClientOption;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* JADX INFO: Access modifiers changed from: package-private */
/* loaded from: classes.dex */
public class ab implements l {
    final /* synthetic */ VoiceManager a;

    private ab(VoiceManager voiceManager) {
        this.a = voiceManager;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ ab(VoiceManager voiceManager, ab abVar) {
        this(voiceManager);
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void a(String str, int i) {
        this.a.q();
        this.a.H = 1;
        if (this.a.b == null || str == null) {
            BdLog.e("VoiceManager", "RecoreCallback.succ", "data err:" + str + " d:" + i);
            com.baidu.tbadk.core.util.w wVar = new com.baidu.tbadk.core.util.w();
            wVar.a("file", str);
            wVar.a("dur", Integer.valueOf(i));
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", wVar.toString());
        } else if (this.a.a != null) {
            if (i <= 1000) {
                this.a.a.a(2, ae.a(com.baidu.tieba.u.voice_record_short_tip));
                BdLog.e("VoiceManager", "RecoreCallback.succ", "voice too short f:" + str + " d:" + i);
                com.baidu.tbadk.core.util.w wVar2 = new com.baidu.tbadk.core.util.w();
                wVar2.a("file", str);
                wVar2.a("dur", Integer.valueOf(i));
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_LEN, "voice too short", wVar2.toString());
            } else if (!str.endsWith(this.a.b)) {
                BdLog.e("VoiceManager", "RecoreCallback.succ", "filename error f:" + str + " v:" + this.a.b);
                com.baidu.tbadk.core.util.w wVar3 = new com.baidu.tbadk.core.util.w();
                wVar3.a("file", str);
                wVar3.a("dur", Integer.valueOf(i));
                TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", wVar3.toString());
            } else {
                BdLog.i("========start submit voice f:" + str + " d:" + i);
                this.a.a(this.a.b, (int) Math.round((i * 1.0d) / 1000.0d));
                this.a.b = null;
            }
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void a(int i, String str) {
        this.a.q();
        BdLog.e(getClass().getName(), "RecoreCallback.error", "error: " + str);
        TiebaStatic.voiceError("", i, "RecoreCallback.error: " + str, "");
        if (this.a.a == null) {
            this.a.H = 1;
        } else if (i != 7) {
            this.a.H = 1;
            if (i == 8) {
                i = 2;
            }
            this.a.a.a(i, str);
            BdLog.e("VoiceManager", "RecoreCallback.error", "err:" + i + " " + str);
            TiebaStatic.voiceError("", i, "RecoreCallback.err: " + str, "");
        } else if (this.a.b != null) {
            this.a.a(this.a.b, com.baidu.adp.lib.voice.a.a / LocationClientOption.MIN_SCAN_SPAN);
            this.a.b = null;
            this.a.a.a(3, this.a.d.getString(com.baidu.tieba.u.voice_record_timeout_tip));
        } else {
            BdLog.e("VoiceManager", "RecoreCallback.error", "data err");
            TiebaStatic.voiceError("", i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void a(int i) {
        if (this.a.a != null) {
            this.a.a.c(i);
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void b(int i) {
        if (this.a.a != null) {
            this.a.a.b(i / LocationClientOption.MIN_SCAN_SPAN);
        }
    }

    @Override // com.baidu.tbadk.core.voice.l
    public void a() {
        this.a.H = 1;
    }
}
