package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f axL;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String axM = null;
    private com.baidu.adp.lib.voice.g axN = null;
    Runnable axO = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.axL != null && com.baidu.adp.lib.voice.h.anl == 2) {
                f.this.axL.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.h.anl = 1;
    }

    public static f ti() {
        return new f();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.aW(this.context.getPageActivity())) {
            this.axL = fVar;
            if (!k.lk()) {
                String BS = k.BS();
                if (BS == null) {
                    BS = com.baidu.adp.lib.voice.h.getString(d.j.voice_error_sdcard);
                }
                this.axL.onShowErr(0, BS);
                return false;
            }
            aI(true);
            this.axM = com.baidu.tbadk.core.voice.a.EM();
            String eY = com.baidu.tbadk.core.voice.a.eY(this.axM);
            if (this.axN == null) {
                this.axN = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(eY, i, this.axN);
            if (a2) {
                this.axL.onStartedRecorder(true);
                com.baidu.adp.lib.voice.h.anl = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.h.anl = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            j jVar = new j();
            jVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", jVar.toString());
            this.axL.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void aI(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void tj() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bR(final String str) {
        stopRecord();
        aI(false);
        if (this.axL != null) {
            this.axL.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.aM(com.baidu.tbadk.core.voice.a.eZ(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean tk() {
        return com.baidu.adp.lib.voice.h.anl == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final String str, final int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.h.anl = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.fb(com.baidu.tbadk.core.voice.a.fa(str)).md5;
                    if (f.this.mHandle != null) {
                        f.this.mHandle.removeCallbacks(f.this.axO);
                        if (StringUtils.isNull(str2)) {
                            f.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.axL.onShowErr(4, f.this.context.getString(d.j.voice_error_file_md5));
                                    com.baidu.adp.lib.voice.h.anl = 1;
                                }
                            });
                        } else {
                            f.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.adp.lib.voice.h.anl = 1;
                                    f.this.axL.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes2.dex */
    private class a implements com.baidu.adp.lib.voice.g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void l(String str, int i) {
            f.this.releaseWakeLock();
            com.baidu.adp.lib.voice.h.anl = 1;
            if (f.this.axM == null || str == null) {
                j jVar = new j();
                jVar.h("file", str);
                jVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", jVar.toString());
            } else if (f.this.axL != null) {
                if (i > 1000) {
                    if (str.endsWith(f.this.axM)) {
                        f.this.q(f.this.axM, (int) Math.round((i * 1.0d) / 1000.0d));
                        f.this.axM = null;
                        return;
                    }
                    j jVar2 = new j();
                    jVar2.h("file", str);
                    jVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", jVar2.toString());
                    return;
                }
                f.this.axL.onShowErr(2, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                j jVar3 = new j();
                jVar3.h("file", str);
                jVar3.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", jVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            f.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (f.this.axL == null) {
                com.baidu.adp.lib.voice.h.anl = 1;
            } else if (i == 7) {
                if (f.this.axM != null) {
                    f.this.q(f.this.axM, com.baidu.adp.lib.voice.d.ank / 1000);
                    f.this.axM = null;
                    f.this.axL.onShowErr(3, f.this.context.getString(d.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.h.anl = 1;
                if (i == 8) {
                    i = 2;
                }
                f.this.axL.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void du(int i) {
            if (f.this.axL != null) {
                f.this.axL.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void dv(int i) {
            if (f.this.axL != null) {
                f.this.axL.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void pn() {
            com.baidu.adp.lib.voice.h.anl = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.axO);
        }
        this.context = null;
        this.axL = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.axL = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.axO, 100L);
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
