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
    com.baidu.adp.lib.voice.j KZ;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String La = null;
    private com.baidu.adp.lib.voice.k Lb = null;
    Runnable Lc = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.Ae = 1;
    }

    public static g mh() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ae.aD(null)) {
            this.KZ = jVar;
            if (!com.baidu.tbadk.core.util.l.dH()) {
                String uv = com.baidu.tbadk.core.util.l.uv();
                if (uv == null) {
                    uv = com.baidu.adp.lib.voice.l.getString(w.l.voice_error_sdcard);
                }
                this.KZ.onShowErr(0, uv);
                return false;
            }
            Z(true);
            this.La = com.baidu.tbadk.core.voice.i.xl();
            String dQ = com.baidu.tbadk.core.voice.i.dQ(this.La);
            if (this.Lb == null) {
                this.Lb = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dQ, i, this.Lb);
            if (a2) {
                this.KZ.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.Ae = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.Ae = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
            kVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.KZ.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void Z(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void mi() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bE(String str) {
        mk();
        Z(false);
        if (this.KZ != null) {
            this.KZ.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean mj() {
        return com.baidu.adp.lib.voice.l.Ae == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.Ae = 3;
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
            com.baidu.adp.lib.voice.l.Ae = 1;
            if (g.this.La == null || str == null) {
                com.baidu.tbadk.core.util.k kVar = new com.baidu.tbadk.core.util.k();
                kVar.n("file", str);
                kVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (g.this.KZ != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.La)) {
                        g.this.p(g.this.La, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.La = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.k kVar2 = new com.baidu.tbadk.core.util.k();
                    kVar2.n("file", str);
                    kVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                g.this.KZ.onShowErr(2, com.baidu.adp.lib.voice.l.getString(w.l.voice_record_short_tip));
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
            if (g.this.KZ == null) {
                com.baidu.adp.lib.voice.l.Ae = 1;
            } else if (i == 7) {
                if (g.this.La != null) {
                    g.this.p(g.this.La, com.baidu.adp.lib.voice.h.Ac / 1000);
                    g.this.La = null;
                    g.this.KZ.onShowErr(3, g.this.context.getString(w.l.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.Ae = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.KZ.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void az(int i) {
            if (g.this.KZ != null) {
                g.this.KZ.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void aA(int i) {
            if (g.this.KZ != null) {
                g.this.KZ.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void hJ() {
            com.baidu.adp.lib.voice.l.Ae = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        mk();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Lc);
        }
        this.context = null;
        this.KZ = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void mk() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Lc, 100L);
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
