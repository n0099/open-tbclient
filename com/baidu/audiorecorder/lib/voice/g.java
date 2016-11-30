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
import com.baidu.tieba.r;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j Ez;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String EA = null;
    private com.baidu.adp.lib.voice.k EB = null;
    Runnable EC = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.sV = 1;
    }

    public static g lv() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ae.af(null)) {
            this.Ez = jVar;
            if (!com.baidu.tbadk.core.util.m.cA()) {
                String ut = com.baidu.tbadk.core.util.m.ut();
                if (ut == null) {
                    ut = com.baidu.adp.lib.voice.l.getString(r.j.voice_error_sdcard);
                }
                this.Ez.onShowErr(0, ut);
                return false;
            }
            Y(true);
            this.EA = com.baidu.tbadk.core.voice.i.xh();
            String eb = com.baidu.tbadk.core.voice.i.eb(this.EA);
            if (this.EB == null) {
                this.EB = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(eb, i, this.EB);
            if (a2) {
                this.Ez.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.sV = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.sV = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
            lVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.Ez.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void Y(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lw() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bM(String str) {
        ly();
        Y(false);
        if (this.Ez != null) {
            this.Ez.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lx() {
        return com.baidu.adp.lib.voice.l.sV == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.sV = 3;
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
            com.baidu.adp.lib.voice.l.sV = 1;
            if (g.this.EA == null || str == null) {
                com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                lVar.n("file", str);
                lVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (g.this.Ez != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.EA)) {
                        g.this.p(g.this.EA, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.EA = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.l lVar2 = new com.baidu.tbadk.core.util.l();
                    lVar2.n("file", str);
                    lVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                g.this.Ez.onShowErr(2, com.baidu.adp.lib.voice.l.getString(r.j.voice_record_short_tip));
                com.baidu.tbadk.core.util.l lVar3 = new com.baidu.tbadk.core.util.l();
                lVar3.n("file", str);
                lVar3.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", lVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void e(int i, String str) {
            g.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (g.this.Ez == null) {
                com.baidu.adp.lib.voice.l.sV = 1;
            } else if (i == 7) {
                if (g.this.EA != null) {
                    g.this.p(g.this.EA, com.baidu.adp.lib.voice.h.sU / 1000);
                    g.this.EA = null;
                    g.this.Ez.onShowErr(3, g.this.context.getString(r.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.sV = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.Ez.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ay(int i) {
            if (g.this.Ez != null) {
                g.this.Ez.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void az(int i) {
            if (g.this.Ez != null) {
                g.this.Ez.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void gR() {
            com.baidu.adp.lib.voice.l.sV = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        ly();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.EC);
        }
        this.context = null;
        this.Ez = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void ly() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.EC, 100L);
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
