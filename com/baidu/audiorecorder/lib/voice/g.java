package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.service.MediaService;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j Kk;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private View screenView;
    private WindowManager windowManager;
    private String Kl = null;
    private com.baidu.adp.lib.voice.k Km = null;
    Runnable Kn = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zx = 1;
    }

    public static g oi() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar == null) {
            return false;
        }
        this.Kk = jVar;
        if (!com.baidu.tbadk.core.util.o.fo()) {
            String sr = com.baidu.tbadk.core.util.o.sr();
            if (sr == null) {
                sr = com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.t.voice_error_sdcard);
            }
            this.Kk.onShowErr(0, sr);
            return false;
        }
        W(true);
        this.Kl = com.baidu.tbadk.core.voice.l.uG();
        String dr = com.baidu.tbadk.core.voice.l.dr(this.Kl);
        if (this.Km == null) {
            this.Km = new m(this, null);
        }
        a.stop();
        releaseWakeLock();
        boolean a = a.a(dr, i, this.Km);
        if (a) {
            this.Kk.onStartedRecorder(true);
            com.baidu.adp.lib.voice.l.zx = 2;
            return a;
        }
        com.baidu.adp.lib.voice.l.zx = 1;
        a.stop();
        com.baidu.tbadk.core.util.n nVar = new com.baidu.tbadk.core.util.n();
        nVar.h("voiceType", Integer.valueOf(i));
        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", nVar.toString());
        this.Kk.onStartedRecorder(false);
        return a;
    }

    public void W(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001280, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void oj() {
        a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bO(String str) {
        ol();
        W(false);
        if (this.Kk != null) {
            this.Kk.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean ok() {
        return com.baidu.adp.lib.voice.l.zx == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.zx = 3;
            new Thread(new j(this, str, i)).start();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        ol();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Kn);
        }
        this.context = null;
        this.Kk = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void ol() {
        a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Kn, 100L);
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
        if (this.windowManager != null && this.screenView != null && this.isAddScreenView) {
            this.windowManager.removeView(this.screenView);
        }
        this.isAddScreenView = false;
    }
}
