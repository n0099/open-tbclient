package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import android.view.View;
import android.view.WindowManager;
import com.baidu.adp.framework.MessageManager;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.voice.VoiceManager;
import com.baidu.tbadk.core.voice.service.MediaService;
/* loaded from: classes.dex */
public class g implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.j Ks;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private View screenView;
    private WindowManager windowManager;
    private String Kt = null;
    private com.baidu.adp.lib.voice.k Ku = null;
    Runnable Kv = new h(this);
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.l.zI = 1;
    }

    public static g nR() {
        return new g();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.j jVar, int i) {
        if (jVar == null) {
            return false;
        }
        this.Ks = jVar;
        if (!com.baidu.tbadk.core.util.o.fj()) {
            String rI = com.baidu.tbadk.core.util.o.rI();
            if (rI == null) {
                rI = com.baidu.adp.lib.voice.l.getString(com.baidu.tieba.y.voice_error_sdcard);
            }
            this.Ks.onShowErr(0, rI);
            return false;
        }
        stopPlay();
        this.Kt = com.baidu.tbadk.core.voice.l.tX();
        String da = com.baidu.tbadk.core.voice.l.da(this.Kt);
        if (this.Ku == null) {
            this.Ku = new m(this, null);
        }
        a.stop();
        releaseWakeLock();
        boolean a = a.a(da, i, this.Ku);
        if (a) {
            this.Ks.onStartedRecorder(true);
            com.baidu.adp.lib.voice.l.zI = 2;
            return a;
        }
        com.baidu.adp.lib.voice.l.zI = 1;
        a.stop();
        com.baidu.tbadk.core.util.n nVar = new com.baidu.tbadk.core.util.n();
        nVar.h("voiceType", Integer.valueOf(i));
        TiebaStatic.voiceError("", TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", nVar.toString());
        this.Ks.onStartedRecorder(false);
        return a;
    }

    public void stopPlay() {
        MessageManager.getInstance().runTask(2001280, VoiceManager.class);
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void nS() {
        a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bE(String str) {
        nU();
        stopPlay();
        if (this.Ks != null) {
            this.Ks.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new i(this, str), 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean nT() {
        return com.baidu.adp.lib.voice.l.zI == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void l(String str, int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.l.zI = 3;
            new Thread(new j(this, str, i)).start();
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        nU();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Kv);
        }
        this.context = null;
        this.Ks = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void nU() {
        a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Kv, 100L);
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
