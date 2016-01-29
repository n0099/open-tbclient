package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.t;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j Ll;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Lm = null;
    private com.baidu.adp.lib.voice.k Ln = null;
    Runnable Lo = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zx = 1;
    }

    public static g os() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar == null) {
            return false;
        }
        this.Ll = jVar;
        if (!com.baidu.tbadk.core.util.m.fq()) {
            String uU = com.baidu.tbadk.core.util.m.uU();
            if (uU == null) {
                uU = com.baidu.adp.lib.voice.l.getString(t.j.voice_error_sdcard);
            }
            this.Ll.onShowErr(0, uU);
            return false;
        }
        V(true);
        this.Lm = com.baidu.tbadk.core.voice.i.xx();
        String dN = com.baidu.tbadk.core.voice.i.dN(this.Lm);
        if (this.Ln == null) {
            this.Ln = new a(this, null);
        }
        com.baidu.audiorecorder.lib.voice.a.stop();
        releaseWakeLock();
        boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dN, i, this.Ln);
        if (a2) {
            this.Ll.onStartedRecorder(true);
            com.baidu.adp.lib.voice.l.zx = 2;
            return a2;
        }
        com.baidu.adp.lib.voice.l.zx = 1;
        com.baidu.audiorecorder.lib.voice.a.stop();
        com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
        lVar.i("voiceType", Integer.valueOf(i));
        TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
        this.Ll.onStartedRecorder(false);
        return a2;
    }

    public void V(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void ot() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bT(String str) {
        ov();
        V(false);
        if (this.Ll != null) {
            this.Ll.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean ou() {
        return com.baidu.adp.lib.voice.l.zx == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.zx = 3;
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
            com.baidu.adp.lib.voice.l.zx = 1;
            if (g.this.Lm == null || str == null) {
                com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                lVar.i("file", str);
                lVar.i("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (g.this.Ll != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.Lm)) {
                        g.this.o(g.this.Lm, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.Lm = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.l lVar2 = new com.baidu.tbadk.core.util.l();
                    lVar2.i("file", str);
                    lVar2.i("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                g.this.Ll.onShowErr(2, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_short_tip));
                com.baidu.tbadk.core.util.l lVar3 = new com.baidu.tbadk.core.util.l();
                lVar3.i("file", str);
                lVar3.i("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", lVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void m(int i, String str) {
            g.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (g.this.Ll == null) {
                com.baidu.adp.lib.voice.l.zx = 1;
            } else if (i == 7) {
                if (g.this.Lm != null) {
                    g.this.o(g.this.Lm, com.baidu.adp.lib.voice.h.zw / 1000);
                    g.this.Lm = null;
                    g.this.Ll.onShowErr(3, g.this.context.getString(t.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.zx = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.Ll.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void av(int i) {
            if (g.this.Ll != null) {
                g.this.Ll.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void aw(int i) {
            if (g.this.Ll != null) {
                g.this.Ll.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void jC() {
            com.baidu.adp.lib.voice.l.zx = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        ov();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Lo);
        }
        this.context = null;
        this.Ll = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void ov() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Lo, 100L);
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
