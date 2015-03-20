package com.baidu.audiorecorder.lib.voice;

import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
/* loaded from: classes.dex */
class m implements com.baidu.adp.lib.voice.k {
    final /* synthetic */ g Ku;

    private m(g gVar) {
        this.Ku = gVar;
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
        this.Ku.releaseWakeLock();
        com.baidu.adp.lib.voice.l.zI = 1;
        str2 = this.Ku.Kr;
        if (str2 == null || str == null) {
            com.baidu.tbadk.core.util.n nVar = new com.baidu.tbadk.core.util.n();
            nVar.h("file", str);
            nVar.h("dur", Integer.valueOf(i));
            TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", nVar.toString());
        } else if (this.Ku.Kq != null) {
            if (i > 1000) {
                str3 = this.Ku.Kr;
                if (!str.endsWith(str3)) {
                    com.baidu.tbadk.core.util.n nVar2 = new com.baidu.tbadk.core.util.n();
                    nVar2.h("file", str);
                    nVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", nVar2.toString());
                    return;
                }
                g gVar = this.Ku;
                str4 = this.Ku.Kr;
                gVar.l(str4, (int) Math.round((i * 1.0d) / 1000.0d));
                this.Ku.Kr = null;
                return;
            }
            this.Ku.Kq.onShowErr(2, com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_record_short_tip));
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
        this.Ku.releaseWakeLock();
        TiebaStatic.voiceError("", i, "RecoreCallback.error: " + str, "");
        if (this.Ku.Kq == null) {
            com.baidu.adp.lib.voice.l.zI = 1;
        } else if (i == 7) {
            str2 = this.Ku.Kr;
            if (str2 == null) {
                TiebaStatic.voiceError("", i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
                return;
            }
            g gVar = this.Ku;
            str3 = this.Ku.Kr;
            gVar.l(str3, com.baidu.adp.lib.voice.h.zH / 1000);
            this.Ku.Kr = null;
            com.baidu.adp.lib.voice.j jVar = this.Ku.Kq;
            tbPageContext = this.Ku.context;
            jVar.onShowErr(3, tbPageContext.getString(com.baidu.tieba.y.voice_record_timeout_tip));
        } else {
            com.baidu.adp.lib.voice.l.zI = 1;
            if (i == 8) {
                i = 2;
            }
            this.Ku.Kq.onShowErr(i, str);
            TiebaStatic.voiceError("", i, "RecoreCallback.err: " + str, "");
        }
    }

    @Override // com.baidu.adp.lib.voice.i
    public void aj(int i) {
        if (this.Ku.Kq != null) {
            this.Ku.Kq.onShowRecording(i);
        }
    }

    @Override // com.baidu.adp.lib.voice.k
    public void ak(int i) {
        if (this.Ku.Kq != null) {
            this.Ku.Kq.onShowRecordTime(i / 1000);
        }
    }

    @Override // com.baidu.adp.lib.voice.k
    public void ji() {
        com.baidu.adp.lib.voice.l.zI = 1;
    }
}
