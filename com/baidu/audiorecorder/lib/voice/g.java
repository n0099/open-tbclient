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
    com.baidu.adp.lib.voice.j Ls;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Lt = null;
    private com.baidu.adp.lib.voice.k Lu = null;
    Runnable Lv = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zP = 1;
    }

    public static g ol() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar != null && !ag.X(null)) {
            this.Ls = jVar;
            if (!com.baidu.tbadk.core.util.m.fr()) {
                String vq = com.baidu.tbadk.core.util.m.vq();
                if (vq == null) {
                    vq = com.baidu.adp.lib.voice.l.getString(t.j.voice_error_sdcard);
                }
                this.Ls.onShowErr(0, vq);
                return false;
            }
            U(true);
            this.Lt = com.baidu.tbadk.core.voice.i.xY();
            String dU = com.baidu.tbadk.core.voice.i.dU(this.Lt);
            if (this.Lu == null) {
                this.Lu = new a(this, null);
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(dU, i, this.Lu);
            if (a2) {
                this.Ls.onStartedRecorder(true);
                com.baidu.adp.lib.voice.l.zP = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.l.zP = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
            lVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.Ls.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void U(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void om() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bR(String str) {
        oo();
        U(false);
        if (this.Ls != null) {
            this.Ls.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean on() {
        return com.baidu.adp.lib.voice.l.zP == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.zP = 3;
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
            com.baidu.adp.lib.voice.l.zP = 1;
            if (g.this.Lt == null || str == null) {
                com.baidu.tbadk.core.util.l lVar = new com.baidu.tbadk.core.util.l();
                lVar.h("file", str);
                lVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (g.this.Ls != null) {
                if (i > 1000) {
                    if (str.endsWith(g.this.Lt)) {
                        g.this.o(g.this.Lt, (int) Math.round((i * 1.0d) / 1000.0d));
                        g.this.Lt = null;
                        return;
                    }
                    com.baidu.tbadk.core.util.l lVar2 = new com.baidu.tbadk.core.util.l();
                    lVar2.h("file", str);
                    lVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                g.this.Ls.onShowErr(2, com.baidu.adp.lib.voice.l.getString(t.j.voice_record_short_tip));
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
            if (g.this.Ls == null) {
                com.baidu.adp.lib.voice.l.zP = 1;
            } else if (i == 7) {
                if (g.this.Lt != null) {
                    g.this.o(g.this.Lt, com.baidu.adp.lib.voice.h.zO / 1000);
                    g.this.Lt = null;
                    g.this.Ls.onShowErr(3, g.this.context.getString(t.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.l.zP = 1;
                if (i == 8) {
                    i = 2;
                }
                g.this.Ls.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.i
        public void au(int i) {
            if (g.this.Ls != null) {
                g.this.Ls.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void av(int i) {
            if (g.this.Ls != null) {
                g.this.Ls.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.k
        public void jI() {
            com.baidu.adp.lib.voice.l.zP = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        oo();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Lv);
        }
        this.context = null;
        this.Ls = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void oo() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Lv, 100L);
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
