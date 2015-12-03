package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.n;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j KG;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String KH = null;
    private com.baidu.adp.lib.voice.k KI = null;
    Runnable KJ = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zn = 1;
    }

    public static g oz() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar == null) {
            return false;
        }
        this.KG = jVar;
        if (!com.baidu.tbadk.core.util.n.fi()) {
            String ug = com.baidu.tbadk.core.util.n.ug();
            if (ug == null) {
                ug = com.baidu.adp.lib.voice.l.getString(n.i.voice_error_sdcard);
            }
            this.KG.onShowErr(0, ug);
            return false;
        }
        Y(true);
        this.KH = com.baidu.tbadk.core.voice.h.wA();
        String dL = com.baidu.tbadk.core.voice.h.dL(this.KH);
        if (this.KI == null) {
            this.KI = new a(this, null);
        }
        com.baidu.audiorecorder.lib.voice.a.stop();
        releaseWakeLock();
        boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dL, i, this.KI);
        if (a2) {
            this.KG.onStartedRecorder(true);
            com.baidu.adp.lib.voice.l.zn = 2;
            return a2;
        }
        com.baidu.adp.lib.voice.l.zn = 1;
        com.baidu.audiorecorder.lib.voice.a.stop();
        com.baidu.tbadk.core.util.m mVar = new com.baidu.tbadk.core.util.m();
        mVar.h("voiceType", Integer.valueOf(i));
        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", mVar.toString());
        this.KG.onStartedRecorder(false);
        return a2;
    }

    public void Y(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void oA() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bR(String str) {
        oC();
        Y(false);
        if (this.KG != null) {
            this.KG.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean oB() {
        return com.baidu.adp.lib.voice.l.zn == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.zn = 3;
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
        public void j(String str, int i) {
            g.this.releaseWakeLock();
            com.baidu.adp.lib.voice.l.zn = 1;
            if (g.this.KH == null || str == null) {
                com.baidu.tbadk.core.util.m mVar = new com.baidu.tbadk.core.util.m();
                mVar.h("file", str);
                mVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", mVar.toString());
            } else if (g.this.KG != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.KH)) {
                        g.this.n(g.this.KH, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.KH = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.m mVar2 = new com.baidu.tbadk.core.util.m();
                    mVar2.h("file", str);
                    mVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", mVar2.toString());
                    return;
                }
                g.this.KG.onShowErr(2, com.baidu.adp.lib.voice.l.getString(n.i.voice_record_short_tip));
                com.baidu.tbadk.core.util.m mVar3 = new com.baidu.tbadk.core.util.m();
                mVar3.h("file", str);
                mVar3.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", mVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void m(int i, String str) {
            g.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (g.this.KG == null) {
                com.baidu.adp.lib.voice.l.zn = 1;
            } else if (i == 7) {
                if (g.this.KH != null) {
                    g.this.n(g.this.KH, com.baidu.adp.lib.voice.h.zm / 1000);
                    g.this.KH = null;
                    g.this.KG.onShowErr(3, g.this.context.getString(n.i.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.zn = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.KG.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ak(int i) {
            if (g.this.KG != null) {
                g.this.KG.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void al(int i) {
            if (g.this.KG != null) {
                g.this.KG.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void js() {
            com.baidu.adp.lib.voice.l.zn = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        oC();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.KJ);
        }
        this.context = null;
        this.KG = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void oC() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.KJ, 100L);
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
