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
import com.baidu.tieba.w;
/* loaded from: classes2.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j JH;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String JI = null;
    private com.baidu.adp.lib.voice.k JJ = null;
    Runnable JK = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zI = 1;
    }

    public static g lJ() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ag.aI(null)) {
            this.JH = jVar;
            if (!com.baidu.tbadk.core.util.n.dH()) {
                String us = com.baidu.tbadk.core.util.n.us();
                if (us == null) {
                    us = com.baidu.adp.lib.voice.l.getString(w.l.voice_error_sdcard);
                }
                this.JH.onShowErr(0, us);
                return false;
            }
            X(true);
            this.JI = com.baidu.tbadk.core.voice.i.xg();
            String en = com.baidu.tbadk.core.voice.i.en(this.JI);
            if (this.JJ == null) {
                this.JJ = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(en, i, this.JJ);
            if (a2) {
                this.JH.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.zI = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.zI = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.m mVar = new com.baidu.tbadk.core.util.m();
            mVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", mVar.toString());
            this.JH.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void X(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lK() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bE(String str) {
        stopRecord();
        X(false);
        if (this.JH != null) {
            this.JH.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lL() {
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
            if (g.this.JI == null || str == null) {
                com.baidu.tbadk.core.util.m mVar = new com.baidu.tbadk.core.util.m();
                mVar.n("file", str);
                mVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", mVar.toString());
            } else if (g.this.JH != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.JI)) {
                        g.this.p(g.this.JI, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.JI = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.m mVar2 = new com.baidu.tbadk.core.util.m();
                    mVar2.n("file", str);
                    mVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", mVar2.toString());
                    return;
                }
                g.this.JH.onShowErr(2, com.baidu.adp.lib.voice.l.getString(w.l.voice_record_short_tip));
                com.baidu.tbadk.core.util.m mVar3 = new com.baidu.tbadk.core.util.m();
                mVar3.n("file", str);
                mVar3.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", mVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void f(int i, String str) {
            g.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (g.this.JH == null) {
                com.baidu.adp.lib.voice.l.zI = 1;
            } else if (i == 7) {
                if (g.this.JI != null) {
                    g.this.p(g.this.JI, com.baidu.adp.lib.voice.h.zH / 1000);
                    g.this.JI = null;
                    g.this.JH.onShowErr(3, g.this.context.getString(w.l.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.zI = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.JH.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ay(int i) {
            if (g.this.JH != null) {
                g.this.JH.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void az(int i) {
            if (g.this.JH != null) {
                g.this.JH.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void hN() {
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
            this.mHandle.removeCallbacks(this.JK);
        }
        this.context = null;
        this.JH = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.JK, 100L);
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
