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
    com.baidu.adp.lib.voice.f Lh;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Li = null;
    private com.baidu.adp.lib.voice.g Lj = null;
    Runnable Lk = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Lh != null && h.Bl == 2) {
                e.this.Lh.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.Bl = 1;
    }

    public static e lP() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar != null && !aa.aJ(null)) {
            this.Lh = fVar;
            if (!k.dR()) {
                String uJ = k.uJ();
                if (uJ == null) {
                    uJ = h.getString(d.l.voice_error_sdcard);
                }
                this.Lh.onShowErr(0, uJ);
                return false;
            }
            X(true);
            this.Li = com.baidu.tbadk.core.voice.a.xz();
            String eA = com.baidu.tbadk.core.voice.a.eA(this.Li);
            if (this.Lj == null) {
                this.Lj = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(eA, i, this.Lj);
            if (a2) {
                this.Lh.onStartedRecorder(true);
                h.Bl = 2;
                return a2;
            }
            h.Bl = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            j jVar = new j();
            jVar.n("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", jVar.toString());
            this.Lh.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void X(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lQ() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bN(final String str) {
        stopRecord();
        X(false);
        if (this.Lh != null) {
            this.Lh.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.eB(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lR() {
        return h.Bl == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final String str, final int i) {
        if (str != null && i >= 1) {
            h.Bl = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.eD(com.baidu.tbadk.core.voice.a.eC(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Lk);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Lh.onShowErr(4, e.this.context.getString(d.l.voice_error_file_md5));
                                    h.Bl = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.Bl = 1;
                                    e.this.Lh.onSendVoice(str2, i);
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
            h.Bl = 1;
            if (e.this.Li == null || str == null) {
                j jVar = new j();
                jVar.n("file", str);
                jVar.n("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", jVar.toString());
            } else if (e.this.Lh != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Li)) {
                        e.this.p(e.this.Li, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Li = null;
                        return;
                    }
                    j jVar2 = new j();
                    jVar2.n("file", str);
                    jVar2.n("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", jVar2.toString());
                    return;
                }
                e.this.Lh.onShowErr(2, h.getString(d.l.voice_record_short_tip));
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
            if (e.this.Lh == null) {
                h.Bl = 1;
            } else if (i == 7) {
                if (e.this.Li != null) {
                    e.this.p(e.this.Li, com.baidu.adp.lib.voice.d.Bk / 1000);
                    e.this.Li = null;
                    e.this.Lh.onShowErr(3, e.this.context.getString(d.l.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.Bl = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Lh.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aB(int i) {
            if (e.this.Lh != null) {
                e.this.Lh.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aC(int i) {
            if (e.this.Lh != null) {
                e.this.Lh.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void hV() {
            h.Bl = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Lk);
        }
        this.context = null;
        this.Lh = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Lk, 100L);
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
