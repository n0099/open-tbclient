package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f SM;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String SO = null;
    private g SQ = null;
    Runnable SR = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.SM != null && h.Go == 2) {
                e.this.SM.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.Go = 1;
    }

    public static e pJ() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.bw(this.context.getPageActivity())) {
            this.SM = fVar;
            if (!l.hk()) {
                String zo = l.zo();
                if (zo == null) {
                    zo = h.getString(e.j.voice_error_sdcard);
                }
                this.SM.onShowErr(0, zo);
                return false;
            }
            stopPlay(true);
            this.SO = com.baidu.tbadk.core.voice.a.Ct();
            String fM = com.baidu.tbadk.core.voice.a.fM(this.SO);
            if (this.SQ == null) {
                this.SQ = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(fM, i, this.SQ);
            if (a2) {
                this.SM.onStartedRecorder(true);
                h.Go = 2;
                return a2;
            }
            h.Go = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            k kVar = new k();
            kVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.SM.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void pK() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void cu(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.SM != null) {
            this.SM.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.bp(com.baidu.tbadk.core.voice.a.getVoiceFilePath(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean pL() {
        return h.Go == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final int i) {
        if (str != null && i >= 1) {
            h.Go = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.fO(com.baidu.tbadk.core.voice.a.fN(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.SR);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.SM.onShowErr(4, e.this.context.getString(e.j.voice_error_file_md5));
                                    h.Go = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.Go = 1;
                                    e.this.SM.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes3.dex */
    private class a implements g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void p(String str, int i) {
            e.this.releaseWakeLock();
            h.Go = 1;
            if (e.this.SO == null || str == null) {
                k kVar = new k();
                kVar.h("file", str);
                kVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (e.this.SM != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.SO)) {
                        e.this.u(e.this.SO, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.SO = null;
                        return;
                    }
                    k kVar2 = new k();
                    kVar2.h("file", str);
                    kVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                e.this.SM.onShowErr(2, h.getString(e.j.voice_record_short_tip));
                k kVar3 = new k();
                kVar3.h("file", str);
                kVar3.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", kVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.SM == null) {
                h.Go = 1;
            } else if (i == 7) {
                if (e.this.SO != null) {
                    e.this.u(e.this.SO, com.baidu.adp.lib.voice.d.Gn / 1000);
                    e.this.SO = null;
                    e.this.SM.onShowErr(3, e.this.context.getString(e.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.Go = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.SM.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aE(int i) {
            if (e.this.SM != null) {
                e.this.SM.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aF(int i) {
            if (e.this.SM != null) {
                e.this.SM.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void lo() {
            h.Go = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.SR);
        }
        this.context = null;
        this.SM = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.SM = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.SR, 100L);
        }
        releaseWakeLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWakeLock() {
        removeBlackScreen();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void setContext(TbPageContext<?> tbPageContext) {
        this.context = tbPageContext;
    }

    private void removeBlackScreen() {
        this.isAddScreenView = false;
    }
}
