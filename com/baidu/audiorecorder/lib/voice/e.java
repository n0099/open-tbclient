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
    com.baidu.adp.lib.voice.f Tf;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Tg = null;
    private g Th = null;
    Runnable Ti = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Tf != null && h.Hb == 2) {
                e.this.Tf.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.Hb = 1;
    }

    public static e pP() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.bC(this.context.getPageActivity())) {
            this.Tf = fVar;
            if (!l.hA()) {
                String BD = l.BD();
                if (BD == null) {
                    BD = h.getString(e.j.voice_error_sdcard);
                }
                this.Tf.onShowErr(0, BD);
                return false;
            }
            stopPlay(true);
            this.Tg = com.baidu.tbadk.core.voice.a.EI();
            String gb = com.baidu.tbadk.core.voice.a.gb(this.Tg);
            if (this.Th == null) {
                this.Th = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(gb, i, this.Th);
            if (a2) {
                this.Tf.onStartedRecorder(true);
                h.Hb = 2;
                return a2;
            }
            h.Hb = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            k kVar = new k();
            kVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.Tf.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void pQ() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void ct(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.Tf != null) {
            this.Tf.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.bo(com.baidu.tbadk.core.voice.a.getVoiceFilePath(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean pR() {
        return h.Hb == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final int i) {
        if (str != null && i >= 1) {
            h.Hb = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.gd(com.baidu.tbadk.core.voice.a.gc(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Ti);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Tf.onShowErr(4, e.this.context.getString(e.j.voice_error_file_md5));
                                    h.Hb = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.Hb = 1;
                                    e.this.Tf.onSendVoice(str2, i);
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
            h.Hb = 1;
            if (e.this.Tg == null || str == null) {
                k kVar = new k();
                kVar.h("file", str);
                kVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (e.this.Tf != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Tg)) {
                        e.this.u(e.this.Tg, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Tg = null;
                        return;
                    }
                    k kVar2 = new k();
                    kVar2.h("file", str);
                    kVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                e.this.Tf.onShowErr(2, h.getString(e.j.voice_record_short_tip));
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
            if (e.this.Tf == null) {
                h.Hb = 1;
            } else if (i == 7) {
                if (e.this.Tg != null) {
                    e.this.u(e.this.Tg, com.baidu.adp.lib.voice.d.Ha / 1000);
                    e.this.Tg = null;
                    e.this.Tf.onShowErr(3, e.this.context.getString(e.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.Hb = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Tf.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aV(int i) {
            if (e.this.Tf != null) {
                e.this.Tf.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aW(int i) {
            if (e.this.Tf != null) {
                e.this.Tf.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void lx() {
            h.Hb = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Ti);
        }
        this.context = null;
        this.Tf = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.Tf = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Ti, 100L);
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
