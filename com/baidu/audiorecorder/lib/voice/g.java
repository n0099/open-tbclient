package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ag;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.u;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j BK;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String BL = null;
    private com.baidu.adp.lib.voice.k BM = null;
    Runnable BN = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.qc = 1;
    }

    public static g kB() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ag.V(null)) {
            this.BK = jVar;
            if (!com.baidu.tbadk.core.util.m.bG()) {
                String sV = com.baidu.tbadk.core.util.m.sV();
                if (sV == null) {
                    sV = com.baidu.adp.lib.voice.l.getString(u.j.voice_error_sdcard);
                }
                this.BK.onShowErr(0, sV);
                return false;
            }
            U(true);
            this.BL = com.baidu.tbadk.core.voice.i.vW();
            String dU = com.baidu.tbadk.core.voice.i.dU(this.BL);
            if (this.BM == null) {
                this.BM = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dU, i, this.BM);
            if (a2) {
                this.BK.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.qc = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.qc = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
            lVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.BK.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void U(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void kC() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bK(String str) {
        kE();
        U(false);
        if (this.BK != null) {
            this.BK.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean kD() {
        return com.baidu.adp.lib.voice.l.qc == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.qc = 3;
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
            com.baidu.adp.lib.voice.l.qc = 1;
            if (g.this.BL == null || str == null) {
                com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                lVar.h("file", str);
                lVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (g.this.BK != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.BL)) {
                        g.this.p(g.this.BL, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.BL = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.l lVar2 = new com.baidu.tbadk.core.util.l();
                    lVar2.h("file", str);
                    lVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                g.this.BK.onShowErr(2, com.baidu.adp.lib.voice.l.getString(u.j.voice_record_short_tip));
                com.baidu.tbadk.core.util.l lVar3 = new com.baidu.tbadk.core.util.l();
                lVar3.h("file", str);
                lVar3.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", lVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void f(int i, String str) {
            g.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (g.this.BK == null) {
                com.baidu.adp.lib.voice.l.qc = 1;
            } else if (i == 7) {
                if (g.this.BL != null) {
                    g.this.p(g.this.BL, com.baidu.adp.lib.voice.h.qb / 1000);
                    g.this.BL = null;
                    g.this.BK.onShowErr(3, g.this.context.getString(u.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.qc = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.BK.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ai(int i) {
            if (g.this.BK != null) {
                g.this.BK.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void aj(int i) {
            if (g.this.BK != null) {
                g.this.BK.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void fW() {
            com.baidu.adp.lib.voice.l.qc = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        kE();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.BN);
        }
        this.context = null;
        this.BK = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void kE() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.BN, 100L);
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
