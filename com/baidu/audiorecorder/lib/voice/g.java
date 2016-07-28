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
    com.baidu.adp.lib.voice.j Ck;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Cl = null;
    private com.baidu.adp.lib.voice.k Cm = null;
    Runnable Cn = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.qE = 1;
    }

    public static g kx() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ag.V(null)) {
            this.Ck = jVar;
            if (!com.baidu.tbadk.core.util.m.bF()) {
                String sU = com.baidu.tbadk.core.util.m.sU();
                if (sU == null) {
                    sU = com.baidu.adp.lib.voice.l.getString(u.j.voice_error_sdcard);
                }
                this.Ck.onShowErr(0, sU);
                return false;
            }
            W(true);
            this.Cl = com.baidu.tbadk.core.voice.i.vW();
            String dT = com.baidu.tbadk.core.voice.i.dT(this.Cl);
            if (this.Cm == null) {
                this.Cm = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dT, i, this.Cm);
            if (a2) {
                this.Ck.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.qE = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.qE = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
            lVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.Ck.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void W(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void ky() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bL(String str) {
        kA();
        W(false);
        if (this.Ck != null) {
            this.Ck.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean kz() {
        return com.baidu.adp.lib.voice.l.qE == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.qE = 3;
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
            com.baidu.adp.lib.voice.l.qE = 1;
            if (g.this.Cl == null || str == null) {
                com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                lVar.n("file", str);
                lVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (g.this.Ck != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.Cl)) {
                        g.this.p(g.this.Cl, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.Cl = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.l lVar2 = new com.baidu.tbadk.core.util.l();
                    lVar2.n("file", str);
                    lVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                g.this.Ck.onShowErr(2, com.baidu.adp.lib.voice.l.getString(u.j.voice_record_short_tip));
                com.baidu.tbadk.core.util.l lVar3 = new com.baidu.tbadk.core.util.l();
                lVar3.n("file", str);
                lVar3.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", lVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void f(int i, String str) {
            g.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (g.this.Ck == null) {
                com.baidu.adp.lib.voice.l.qE = 1;
            } else if (i == 7) {
                if (g.this.Cl != null) {
                    g.this.p(g.this.Cl, com.baidu.adp.lib.voice.h.qD / 1000);
                    g.this.Cl = null;
                    g.this.Ck.onShowErr(3, g.this.context.getString(u.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.qE = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.Ck.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void al(int i) {
            if (g.this.Ck != null) {
                g.this.Ck.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void am(int i) {
            if (g.this.Ck != null) {
                g.this.Ck.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void fV() {
            com.baidu.adp.lib.voice.l.qE = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        kA();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Cn);
        }
        this.context = null;
        this.Ck = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void kA() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Cn, 100L);
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
