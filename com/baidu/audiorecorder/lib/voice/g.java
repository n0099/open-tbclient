package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j JU;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String JV = null;
    private com.baidu.adp.lib.voice.k JW = null;
    Runnable JX = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zI = 1;
    }

    public static g lT() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ae.aI(null)) {
            this.JU = jVar;
            if (!com.baidu.tbadk.core.util.l.dH()) {
                String ue = com.baidu.tbadk.core.util.l.ue();
                if (ue == null) {
                    ue = com.baidu.adp.lib.voice.l.getString(w.l.voice_error_sdcard);
                }
                this.JU.onShowErr(0, ue);
                return false;
            }
            Y(true);
            this.JV = com.baidu.tbadk.core.voice.i.wV();
            String dV = com.baidu.tbadk.core.voice.i.dV(this.JV);
            if (this.JW == null) {
                this.JW = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dV, i, this.JW);
            if (a2) {
                this.JU.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.zI = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.zI = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
            kVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.JU.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void Y(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lU() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bz(String str) {
        stopRecord();
        Y(false);
        if (this.JU != null) {
            this.JU.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lV() {
        return com.baidu.adp.lib.voice.l.zI == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.zI = 3;
            new Thread(new j(this, str, i)).start();
        }
    }

    /* loaded from: classes2.dex */
    private class a implements com.baidu.adp.lib.voice.k {
        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.voice.i
        public void k(String str, int i) {
            g.this.releaseWakeLock();
            com.baidu.adp.lib.voice.l.zI = 1;
            if (g.this.JV == null || str == null) {
                com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                kVar.n("file", str);
                kVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (g.this.JU != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.JV)) {
                        g.this.p(g.this.JV, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.JV = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.k kVar2 = new com.baidu.tbadk.core.util.k();
                    kVar2.n("file", str);
                    kVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                g.this.JU.onShowErr(2, com.baidu.adp.lib.voice.l.getString(w.l.voice_record_short_tip));
                com.baidu.tbadk.core.util.k kVar3 = new com.baidu.tbadk.core.util.k();
                kVar3.n("file", str);
                kVar3.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", kVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void f(int i, String str) {
            g.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (g.this.JU == null) {
                com.baidu.adp.lib.voice.l.zI = 1;
            } else if (i == 7) {
                if (g.this.JV != null) {
                    g.this.p(g.this.JV, com.baidu.adp.lib.voice.h.zH / 1000);
                    g.this.JV = null;
                    g.this.JU.onShowErr(3, g.this.context.getString(w.l.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.zI = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.JU.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ax(int i) {
            if (g.this.JU != null) {
                g.this.JU.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void ay(int i) {
            if (g.this.JU != null) {
                g.this.JU.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void hO() {
            com.baidu.adp.lib.voice.l.zI = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.JX);
        }
        this.context = null;
        this.JU = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.JX, 100L);
        }
        releaseWakeLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWakeLock() {
        removeBlackScreen();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(TbPageContext<?> tbPageContext) {
        this.context = tbPageContext;
    }

    private void removeBlackScreen() {
        this.isAddScreenView = false;
    }
}
