package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class m implements com.baidu.adp.lib.voice.k {
    final /* synthetic */ g Ko;

    private m(g gVar) {
        this.Ko = gVar;
    }

    /* JADX INFO: Access modifiers changed from: package-private */
    public /* synthetic */ m(g gVar, m mVar) {
        this(gVar);
    }

    @Override // com.baidu.adp.lib.voice.i
    public void i(String str, int i) {
        String str2;
        String str3;
        String str4;
        this.Ko.releaseWakeLock();
        com.baidu.adp.lib.voice.l.zx = 1;
        str2 = this.Ko.Kl;
        if (str2 == null || str == null) {
            com.baidu.tbadk.core.util.n nVar = new com.baidu.tbadk.core.util.n();
            nVar.h("file", str);
            nVar.h("dur", Integer.valueOf(i));
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", nVar.toString());
        } else if (this.Ko.Kk != null) {
            if (i > 1000) {
                str3 = this.Ko.Kl;
                if (!str.endsWith(str3)) {
                    com.baidu.tbadk.core.util.n nVar2 = new com.baidu.tbadk.core.util.n();
                    nVar2.h("file", str);
                    nVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", nVar2.toString());
                    return;
                }
                g gVar = this.Ko;
                str4 = this.Ko.Kl;
                gVar.l(str4, (int) Math.round((i * 1.0d) / 1000.0d));
                this.Ko.Kl = null;
                return;
            }
            this.Ko.Kk.onShowErr(2, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_record_short_tip));
            com.baidu.tbadk.core.util.n nVar3 = new com.baidu.tbadk.core.util.n();
            nVar3.h("file", str);
            nVar3.h("dur", Integer.valueOf(i));
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_LEN, "voice too short", nVar3.toString());
        }
    }

    @Override // com.baidu.adp.lib.voice.i
    public void error(int i, String str) {
        String str2;
        String str3;
        TbPageContext tbPageContext;
        this.Ko.releaseWakeLock();
        TiebaStatic.voiceError("", i, "RecoreCallback.error: " + str, "");
        if (this.Ko.Kk == null) {
            com.baidu.adp.lib.voice.l.zx = 1;
        } else if (i == 7) {
            str2 = this.Ko.Kl;
            if (str2 == null) {
                TiebaStatic.voiceError("", i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                return;
            }
            g gVar = this.Ko;
            str3 = this.Ko.Kl;
            gVar.l(str3, com.baidu.adp.lib.voice.h.zw / 1000);
            this.Ko.Kl = null;
            com.baidu.adp.lib.voice.j jVar = this.Ko.Kk;
            tbPageContext = this.Ko.context;
            jVar.onShowErr(3, tbPageContext.getString(com.baidu.tieba.t.voice_record_timeout_tip));
        } else {
            com.baidu.adp.lib.voice.l.zx = 1;
            if (i == 8) {
                i = 2;
            }
            this.Ko.Kk.onShowErr(i, str);
            TiebaStatic.voiceError("", i, "RecoreCallback.err: " + str, "");
        }
    }

    @Override // com.baidu.adp.lib.voice.i
    public void ah(int i) {
        if (this.Ko.Kk != null) {
            this.Ko.Kk.onShowRecording(i);
        }
    }

    @Override // com.baidu.adp.lib.voice.k
    public void ai(int i) {
        if (this.Ko.Kk != null) {
            this.Ko.Kk.onShowRecordTime(i / 1000);
        }
    }

    @Override // com.baidu.adp.lib.voice.k
    public void jz() {
        com.baidu.adp.lib.voice.l.zx = 1;
    }
}
