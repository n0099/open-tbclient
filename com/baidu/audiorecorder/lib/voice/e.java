package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.voice.h;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.aa;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f Lf;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Lg = null;
    private com.baidu.adp.lib.voice.g Lh = null;
    Runnable Li = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Lf != null && h.Bj == 2) {
                e.this.Lf.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.Bj = 1;
    }

    public static e lQ() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar != null && !aa.aJ(null)) {
            this.Lf = fVar;
            if (!k.dR()) {
                String uI = k.uI();
                if (uI == null) {
                    uI = h.getString(d.l.voice_error_sdcard);
                }
                this.Lf.onShowErr(0, uI);
                return false;
            }
            X(true);
            this.Lg = com.baidu.tbadk.core.voice.a.xz();
            String ew = com.baidu.tbadk.core.voice.a.ew(this.Lg);
            if (this.Lh == null) {
                this.Lh = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(ew, i, this.Lh);
            if (a2) {
                this.Lf.onStartedRecorder(true);
                h.Bj = 2;
                return a2;
            }
            h.Bj = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            j jVar = new j();
            jVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", jVar.toString());
            this.Lf.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void X(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lR() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bM(final String str) {
        stopRecord();
        X(false);
        if (this.Lf != null) {
            this.Lf.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.ex(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lS() {
        return h.Bj == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final String str, final int i) {
        if (str != null && i >= 1) {
            h.Bj = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.ez(com.baidu.tbadk.core.voice.a.ey(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Li);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Lf.onShowErr(4, e.this.context.getString(d.l.voice_error_file_md5));
                                    h.Bj = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.Bj = 1;
                                    e.this.Lf.onSendVoice(str2, i);
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
        public void k(String str, int i) {
            e.this.releaseWakeLock();
            h.Bj = 1;
            if (e.this.Lg == null || str == null) {
                j jVar = new j();
                jVar.n("file", str);
                jVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", jVar.toString());
            } else if (e.this.Lf != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Lg)) {
                        e.this.p(e.this.Lg, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Lg = null;
                        return;
                    }
                    j jVar2 = new j();
                    jVar2.n("file", str);
                    jVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", jVar2.toString());
                    return;
                }
                e.this.Lf.onShowErr(2, h.getString(d.l.voice_record_short_tip));
                j jVar3 = new j();
                jVar3.n("file", str);
                jVar3.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", jVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void f(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.Lf == null) {
                h.Bj = 1;
            } else if (i == 7) {
                if (e.this.Lg != null) {
                    e.this.p(e.this.Lg, com.baidu.adp.lib.voice.d.Bi / 1000);
                    e.this.Lg = null;
                    e.this.Lf.onShowErr(3, e.this.context.getString(d.l.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.Bj = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Lf.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aB(int i) {
            if (e.this.Lf != null) {
                e.this.Lf.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aC(int i) {
            if (e.this.Lf != null) {
                e.this.Lf.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void hV() {
            h.Bj = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Li);
        }
        this.context = null;
        this.Lf = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Li, 100L);
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
