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
import com.baidu.tbadk.core.util.ac;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.d;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f Ql;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Qm = null;
    private g Qn = null;
    Runnable Qo = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Ql != null && h.DU == 2) {
                e.this.Ql.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.DU = 1;
    }

    public static e oG() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ac.aR(this.context.getPageActivity())) {
            this.Ql = fVar;
            if (!l.gd()) {
                String yi = l.yi();
                if (yi == null) {
                    yi = h.getString(d.j.voice_error_sdcard);
                }
                this.Ql.onShowErr(0, yi);
                return false;
            }
            stopPlay(true);
            this.Qm = com.baidu.tbadk.core.voice.a.Bk();
            String fr = com.baidu.tbadk.core.voice.a.fr(this.Qm);
            if (this.Qn == null) {
                this.Qn = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(fr, i, this.Qn);
            if (a2) {
                this.Ql.onStartedRecorder(true);
                h.DU = 2;
                return a2;
            }
            h.DU = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            k kVar = new k();
            kVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.Ql.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void oH() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void cd(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.Ql != null) {
            this.Ql.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.aY(com.baidu.tbadk.core.voice.a.getVoiceFilePath(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean oI() {
        return h.DU == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final String str, final int i) {
        if (str != null && i >= 1) {
            h.DU = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.ft(com.baidu.tbadk.core.voice.a.fs(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Qo);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Ql.onShowErr(4, e.this.context.getString(d.j.voice_error_file_md5));
                                    h.DU = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.DU = 1;
                                    e.this.Ql.onSendVoice(str2, i);
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
        public void k(String str, int i) {
            e.this.releaseWakeLock();
            h.DU = 1;
            if (e.this.Qm == null || str == null) {
                k kVar = new k();
                kVar.h("file", str);
                kVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (e.this.Ql != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Qm)) {
                        e.this.p(e.this.Qm, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Qm = null;
                        return;
                    }
                    k kVar2 = new k();
                    kVar2.h("file", str);
                    kVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                e.this.Ql.onShowErr(2, h.getString(d.j.voice_record_short_tip));
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
            if (e.this.Ql == null) {
                h.DU = 1;
            } else if (i == 7) {
                if (e.this.Qm != null) {
                    e.this.p(e.this.Qm, com.baidu.adp.lib.voice.d.DT / 1000);
                    e.this.Qm = null;
                    e.this.Ql.onShowErr(3, e.this.context.getString(d.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.DU = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Ql.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aw(int i) {
            if (e.this.Ql != null) {
                e.this.Ql.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void ax(int i) {
            if (e.this.Ql != null) {
                e.this.Ql.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void ki() {
            h.DU = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Qo);
        }
        this.context = null;
        this.Ql = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.Ql = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Qo, 100L);
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
