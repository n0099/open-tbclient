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
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j BJ;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String BK = null;
    private com.baidu.adp.lib.voice.k BL = null;
    Runnable BM = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.qc = 1;
    }

    public static g ky() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ag.W(null)) {
            this.BJ = jVar;
            if (!com.baidu.tbadk.core.util.m.bF()) {
                String sX = com.baidu.tbadk.core.util.m.sX();
                if (sX == null) {
                    sX = com.baidu.adp.lib.voice.l.getString(t.j.voice_error_sdcard);
                }
                this.BJ.onShowErr(0, sX);
                return false;
            }
            U(true);
            this.BK = com.baidu.tbadk.core.voice.i.vS();
            String dQ = com.baidu.tbadk.core.voice.i.dQ(this.BK);
            if (this.BL == null) {
                this.BL = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dQ, i, this.BL);
            if (a2) {
                this.BJ.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.qc = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.qc = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
            lVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.BJ.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void U(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void kz() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bK(String str) {
        kB();
        U(false);
        if (this.BJ != null) {
            this.BJ.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean kA() {
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
            if (g.this.BK == null || str == null) {
                com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                lVar.h("file", str);
                lVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (g.this.BJ != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.BK)) {
                        g.this.p(g.this.BK, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.BK = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.l lVar2 = new com.baidu.tbadk.core.util.l();
                    lVar2.h("file", str);
                    lVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                g.this.BJ.onShowErr(2, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_short_tip));
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
            if (g.this.BJ == null) {
                com.baidu.adp.lib.voice.l.qc = 1;
            } else if (i == 7) {
                if (g.this.BK != null) {
                    g.this.p(g.this.BK, com.baidu.adp.lib.voice.h.qb / 1000);
                    g.this.BK = null;
                    g.this.BJ.onShowErr(3, g.this.context.getString(t.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.qc = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.BJ.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ai(int i) {
            if (g.this.BJ != null) {
                g.this.BJ.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void aj(int i) {
            if (g.this.BJ != null) {
                g.this.BJ.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void fV() {
            com.baidu.adp.lib.voice.l.qc = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        kB();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.BM);
        }
        this.context = null;
        this.BJ = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void kB() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.BM, 100L);
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
