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
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j KC;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String KD = null;
    private com.baidu.adp.lib.voice.k KE = null;
    Runnable KF = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zH = 1;
    }

    public static g mm() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ae.aF(null)) {
            this.KC = jVar;
            if (!com.baidu.tbadk.core.util.l.dH()) {
                String uS = com.baidu.tbadk.core.util.l.uS();
                if (uS == null) {
                    uS = com.baidu.adp.lib.voice.l.getString(w.l.voice_error_sdcard);
                }
                this.KC.onShowErr(0, uS);
                return false;
            }
            Z(true);
            this.KD = com.baidu.tbadk.core.voice.i.xH();
            String dW = com.baidu.tbadk.core.voice.i.dW(this.KD);
            if (this.KE == null) {
                this.KE = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dW, i, this.KE);
            if (a2) {
                this.KC.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.zH = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.zH = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
            kVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.KC.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void Z(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void mn() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bz(String str) {
        stopRecord();
        Z(false);
        if (this.KC != null) {
            this.KC.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean mo() {
        return com.baidu.adp.lib.voice.l.zH == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.zH = 3;
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
            com.baidu.adp.lib.voice.l.zH = 1;
            if (g.this.KD == null || str == null) {
                com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                kVar.n("file", str);
                kVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (g.this.KC != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.KD)) {
                        g.this.p(g.this.KD, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.KD = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.k kVar2 = new com.baidu.tbadk.core.util.k();
                    kVar2.n("file", str);
                    kVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                g.this.KC.onShowErr(2, com.baidu.adp.lib.voice.l.getString(w.l.voice_record_short_tip));
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
            if (g.this.KC == null) {
                com.baidu.adp.lib.voice.l.zH = 1;
            } else if (i == 7) {
                if (g.this.KD != null) {
                    g.this.p(g.this.KD, com.baidu.adp.lib.voice.h.zG / 1000);
                    g.this.KD = null;
                    g.this.KC.onShowErr(3, g.this.context.getString(w.l.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.zH = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.KC.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ay(int i) {
            if (g.this.KC != null) {
                g.this.KC.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void az(int i) {
            if (g.this.KC != null) {
                g.this.KC.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void hP() {
            com.baidu.adp.lib.voice.l.zH = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.KF);
        }
        this.context = null;
        this.KC = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.KF, 100L);
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
