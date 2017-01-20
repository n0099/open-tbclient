package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j DL;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String DM = null;
    private com.baidu.adp.lib.voice.k DN = null;
    Runnable DO = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.sM = 1;
    }

    public static g ln() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ad.af(null)) {
            this.DL = jVar;
            if (!com.baidu.tbadk.core.util.l.cy()) {
                String tX = com.baidu.tbadk.core.util.l.tX();
                if (tX == null) {
                    tX = com.baidu.adp.lib.voice.l.getString(r.l.voice_error_sdcard);
                }
                this.DL.onShowErr(0, tX);
                return false;
            }
            Y(true);
            this.DM = com.baidu.tbadk.core.voice.i.wO();
            String dW = com.baidu.tbadk.core.voice.i.dW(this.DM);
            if (this.DN == null) {
                this.DN = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dW, i, this.DN);
            if (a2) {
                this.DL.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.sM = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.sM = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
            kVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.DL.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void Y(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lo() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bK(String str) {
        lq();
        Y(false);
        if (this.DL != null) {
            this.DL.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lp() {
        return com.baidu.adp.lib.voice.l.sM == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.sM = 3;
            new Thread(new j(this, str, i)).start();
        }
    }

    /* loaded from: classes.dex */
    private class a implements com.baidu.adp.lib.voice.k {
        private a() {
        }

        /* synthetic */ a(g gVar, a aVar) {
            this();
        }

        @Override // com.baidu.adp.lib.voice.i
        public void k(String str, int i) {
            g.this.releaseWakeLock();
            com.baidu.adp.lib.voice.l.sM = 1;
            if (g.this.DM == null || str == null) {
                com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                kVar.n("file", str);
                kVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (g.this.DL != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.DM)) {
                        g.this.p(g.this.DM, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.DM = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.k kVar2 = new com.baidu.tbadk.core.util.k();
                    kVar2.n("file", str);
                    kVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                g.this.DL.onShowErr(2, com.baidu.adp.lib.voice.l.getString(r.l.voice_record_short_tip));
                com.baidu.tbadk.core.util.k kVar3 = new com.baidu.tbadk.core.util.k();
                kVar3.n("file", str);
                kVar3.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", kVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void e(int i, String str) {
            g.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (g.this.DL == null) {
                com.baidu.adp.lib.voice.l.sM = 1;
            } else if (i == 7) {
                if (g.this.DM != null) {
                    g.this.p(g.this.DM, com.baidu.adp.lib.voice.h.sL / 1000);
                    g.this.DM = null;
                    g.this.DL.onShowErr(3, g.this.context.getString(r.l.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.sM = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.DL.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void az(int i) {
            if (g.this.DL != null) {
                g.this.DL.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void aA(int i) {
            if (g.this.DL != null) {
                g.this.DL.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void gP() {
            com.baidu.adp.lib.voice.l.sM = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        lq();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.DO);
        }
        this.context = null;
        this.DL = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lq() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.DO, 100L);
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
