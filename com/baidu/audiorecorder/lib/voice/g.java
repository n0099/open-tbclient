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
    com.baidu.adp.lib.voice.j KW;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String KX = null;
    private com.baidu.adp.lib.voice.k KY = null;
    Runnable KZ = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zp = 1;
    }

    public static g nX() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar == null) {
            return false;
        }
        this.KW = jVar;
        if (!com.baidu.tbadk.core.util.n.fi()) {
            String tQ = com.baidu.tbadk.core.util.n.tQ();
            if (tQ == null) {
                tQ = com.baidu.adp.lib.voice.l.getString(n.j.voice_error_sdcard);
            }
            this.KW.onShowErr(0, tQ);
            return false;
        }
        V(true);
        this.KX = com.baidu.tbadk.core.voice.h.wj();
        String dO = com.baidu.tbadk.core.voice.h.dO(this.KX);
        if (this.KY == null) {
            this.KY = new a(this, null);
        }
        com.baidu.audiorecorder.lib.voice.a.stop();
        releaseWakeLock();
        boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dO, i, this.KY);
        if (a2) {
            this.KW.onStartedRecorder(true);
            com.baidu.adp.lib.voice.l.zp = 2;
            return a2;
        }
        com.baidu.adp.lib.voice.l.zp = 1;
        com.baidu.audiorecorder.lib.voice.a.stop();
        com.baidu.tbadk.core.util.m mVar = new com.baidu.tbadk.core.util.m();
        mVar.h("voiceType", Integer.valueOf(i));
        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", mVar.toString());
        this.KW.onStartedRecorder(false);
        return a2;
    }

    public void V(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void nY() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bT(String str) {
        oa();
        V(false);
        if (this.KW != null) {
            this.KW.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean nZ() {
        return com.baidu.adp.lib.voice.l.zp == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void n(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.zp = 3;
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
            com.baidu.adp.lib.voice.l.zp = 1;
            if (g.this.KX == null || str == null) {
                com.baidu.tbadk.core.util.m mVar = new com.baidu.tbadk.core.util.m();
                mVar.h("file", str);
                mVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", mVar.toString());
            } else if (g.this.KW != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.KX)) {
                        g.this.n(g.this.KX, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.KX = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.m mVar2 = new com.baidu.tbadk.core.util.m();
                    mVar2.h("file", str);
                    mVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", mVar2.toString());
                    return;
                }
                g.this.KW.onShowErr(2, com.baidu.adp.lib.voice.l.getString(n.j.voice_record_short_tip));
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
            if (g.this.KW == null) {
                com.baidu.adp.lib.voice.l.zp = 1;
            } else if (i == 7) {
                if (g.this.KX != null) {
                    g.this.n(g.this.KX, com.baidu.adp.lib.voice.h.zo / 1000);
                    g.this.KX = null;
                    g.this.KW.onShowErr(3, g.this.context.getString(n.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.zp = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.KW.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void ak(int i) {
            if (g.this.KW != null) {
                g.this.KW.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void al(int i) {
            if (g.this.KW != null) {
                g.this.KW.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void jt() {
            com.baidu.adp.lib.voice.l.zp = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        oa();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.KZ);
        }
        this.context = null;
        this.KW = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void oa() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.KZ, 100L);
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
