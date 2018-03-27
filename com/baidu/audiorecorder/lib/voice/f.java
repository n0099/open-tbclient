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
    com.baidu.adp.lib.voice.f axM;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String axN = null;
    private com.baidu.adp.lib.voice.g axO = null;
    Runnable axP = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.axM != null && com.baidu.adp.lib.voice.h.anl == 2) {
                f.this.axM.onStopingRecorder();
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
            this.axM = fVar;
            if (!k.lk()) {
                String BT = k.BT();
                if (BT == null) {
                    BT = com.baidu.adp.lib.voice.h.getString(d.j.voice_error_sdcard);
                }
                this.axM.onShowErr(0, BT);
                return false;
            }
            aI(true);
            this.axN = com.baidu.tbadk.core.voice.a.EN();
            String eY = com.baidu.tbadk.core.voice.a.eY(this.axN);
            if (this.axO == null) {
                this.axO = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(eY, i, this.axO);
            if (a2) {
                this.axM.onStartedRecorder(true);
                com.baidu.adp.lib.voice.h.anl = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.h.anl = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            j jVar = new j();
            jVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", jVar.toString());
            this.axM.onStartedRecorder(false);
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
        if (this.axM != null) {
            this.axM.onDeletedVoice(str);
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
                        f.this.mHandle.removeCallbacks(f.this.axP);
                        if (StringUtils.isNull(str2)) {
                            f.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.axM.onShowErr(4, f.this.context.getString(d.j.voice_error_file_md5));
                                    com.baidu.adp.lib.voice.h.anl = 1;
                                }
                            });
                        } else {
                            f.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.adp.lib.voice.h.anl = 1;
                                    f.this.axM.onSendVoice(str2, i);
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
            if (f.this.axN == null || str == null) {
                j jVar = new j();
                jVar.h("file", str);
                jVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", jVar.toString());
            } else if (f.this.axM != null) {
                if (i > 1000) {
                    if (str.endsWith(f.this.axN)) {
                        f.this.q(f.this.axN, (int) Math.round((i * 1.0d) / 1000.0d));
                        f.this.axN = null;
                        return;
                    }
                    j jVar2 = new j();
                    jVar2.h("file", str);
                    jVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", jVar2.toString());
                    return;
                }
                f.this.axM.onShowErr(2, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
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
            if (f.this.axM == null) {
                com.baidu.adp.lib.voice.h.anl = 1;
            } else if (i == 7) {
                if (f.this.axN != null) {
                    f.this.q(f.this.axN, com.baidu.adp.lib.voice.d.ank / 1000);
                    f.this.axN = null;
                    f.this.axM.onShowErr(3, f.this.context.getString(d.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.h.anl = 1;
                if (i == 8) {
                    i = 2;
                }
                f.this.axM.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void du(int i) {
            if (f.this.axM != null) {
                f.this.axM.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void dv(int i) {
            if (f.this.axM != null) {
                f.this.axM.onShowRecordTime(i / 1000);
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
            this.mHandle.removeCallbacks(this.axP);
        }
        this.context = null;
        this.axM = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.axM = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.axP, 100L);
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
