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
    com.baidu.adp.lib.voice.f Qo;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Qp = null;
    private g Qq = null;
    Runnable Qr = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Qo != null && h.DX == 2) {
                e.this.Qo.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.DX = 1;
    }

    public static e oE() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ac.aQ(this.context.getPageActivity())) {
            this.Qo = fVar;
            if (!l.ge()) {
                String yq = l.yq();
                if (yq == null) {
                    yq = h.getString(d.k.voice_error_sdcard);
                }
                this.Qo.onShowErr(0, yq);
                return false;
            }
            ae(true);
            this.Qp = com.baidu.tbadk.core.voice.a.Bt();
            String ft = com.baidu.tbadk.core.voice.a.ft(this.Qp);
            if (this.Qq == null) {
                this.Qq = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(ft, i, this.Qq);
            if (a2) {
                this.Qo.onStartedRecorder(true);
                h.DX = 2;
                return a2;
            }
            h.DX = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            k kVar = new k();
            kVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.Qo.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void ae(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void oF() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void cc(final String str) {
        stopRecord();
        ae(false);
        if (this.Qo != null) {
            this.Qo.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.aX(com.baidu.tbadk.core.voice.a.getVoiceFilePath(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean oG() {
        return h.DX == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final String str, final int i) {
        if (str != null && i >= 1) {
            h.DX = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.fv(com.baidu.tbadk.core.voice.a.fu(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Qr);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Qo.onShowErr(4, e.this.context.getString(d.k.voice_error_file_md5));
                                    h.DX = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.DX = 1;
                                    e.this.Qo.onSendVoice(str2, i);
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
            h.DX = 1;
            if (e.this.Qp == null || str == null) {
                k kVar = new k();
                kVar.h("file", str);
                kVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (e.this.Qo != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Qp)) {
                        e.this.p(e.this.Qp, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Qp = null;
                        return;
                    }
                    k kVar2 = new k();
                    kVar2.h("file", str);
                    kVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                e.this.Qo.onShowErr(2, h.getString(d.k.voice_record_short_tip));
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
            if (e.this.Qo == null) {
                h.DX = 1;
            } else if (i == 7) {
                if (e.this.Qp != null) {
                    e.this.p(e.this.Qp, com.baidu.adp.lib.voice.d.DW / 1000);
                    e.this.Qp = null;
                    e.this.Qo.onShowErr(3, e.this.context.getString(d.k.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.DX = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Qo.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void av(int i) {
            if (e.this.Qo != null) {
                e.this.Qo.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aw(int i) {
            if (e.this.Qo != null) {
                e.this.Qo.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void kh() {
            h.DX = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Qr);
        }
        this.context = null;
        this.Qo = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.Qo = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Qr, 100L);
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
