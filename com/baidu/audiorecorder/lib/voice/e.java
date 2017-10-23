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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f Jv;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Jw = null;
    private com.baidu.adp.lib.voice.g Jx = null;
    Runnable Jy = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Jv != null && h.zh == 2) {
                e.this.Jv.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.zh = 1;
    }

    public static e lJ() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar != null && !ab.aO(null)) {
            this.Jv = fVar;
            if (!k.dG()) {
                String ua = k.ua();
                if (ua == null) {
                    ua = h.getString(d.l.voice_error_sdcard);
                }
                this.Jv.onShowErr(0, ua);
                return false;
            }
            Z(true);
            this.Jw = com.baidu.tbadk.core.voice.a.wT();
            String em = com.baidu.tbadk.core.voice.a.em(this.Jw);
            if (this.Jx == null) {
                this.Jx = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(em, i, this.Jx);
            if (a2) {
                this.Jv.onStartedRecorder(true);
                h.zh = 2;
                return a2;
            }
            h.zh = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            j jVar = new j();
            jVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", jVar.toString());
            this.Jv.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void Z(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lK() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bJ(final String str) {
        stopRecord();
        Z(false);
        if (this.Jv != null) {
            this.Jv.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.aE(com.baidu.tbadk.core.voice.a.en(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lL() {
        return h.zh == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final String str, final int i) {
        if (str != null && i >= 1) {
            h.zh = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.ep(com.baidu.tbadk.core.voice.a.eo(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Jy);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Jv.onShowErr(4, e.this.context.getString(d.l.voice_error_file_md5));
                                    h.zh = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.zh = 1;
                                    e.this.Jv.onSendVoice(str2, i);
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
            h.zh = 1;
            if (e.this.Jw == null || str == null) {
                j jVar = new j();
                jVar.h("file", str);
                jVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", jVar.toString());
            } else if (e.this.Jv != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Jw)) {
                        e.this.p(e.this.Jw, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Jw = null;
                        return;
                    }
                    j jVar2 = new j();
                    jVar2.h("file", str);
                    jVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", jVar2.toString());
                    return;
                }
                e.this.Jv.onShowErr(2, h.getString(d.l.voice_record_short_tip));
                j jVar3 = new j();
                jVar3.h("file", str);
                jVar3.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", jVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void f(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.Jv == null) {
                h.zh = 1;
            } else if (i == 7) {
                if (e.this.Jw != null) {
                    e.this.p(e.this.Jw, com.baidu.adp.lib.voice.d.zg / 1000);
                    e.this.Jw = null;
                    e.this.Jv.onShowErr(3, e.this.context.getString(d.l.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.zh = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Jv.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aB(int i) {
            if (e.this.Jv != null) {
                e.this.Jv.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aC(int i) {
            if (e.this.Jv != null) {
                e.this.Jv.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void hL() {
            h.zh = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Jy);
        }
        this.context = null;
        this.Jv = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Jy, 100L);
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
