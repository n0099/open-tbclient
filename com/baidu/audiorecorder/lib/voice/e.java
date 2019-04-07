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
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.d;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f VS;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String VT = null;
    private g VU = null;
    Runnable VV = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.VS != null && h.Ha == 2) {
                e.this.VS.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.Ha = 1;
    }

    public static e qU() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.cV(this.context.getPageActivity())) {
            this.VS = fVar;
            if (!m.hy()) {
                String acb = m.acb();
                if (acb == null) {
                    acb = h.getString(d.j.voice_error_sdcard);
                }
                this.VS.onShowErr(0, acb);
                return false;
            }
            stopPlay(true);
            this.VT = com.baidu.tbadk.core.voice.a.afr();
            String nv = com.baidu.tbadk.core.voice.a.nv(this.VT);
            if (this.VU == null) {
                this.VU = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(nv, i, this.VU);
            if (a2) {
                this.VS.onStartedRecorder(true);
                h.Ha = 2;
                return a2;
            }
            h.Ha = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            l lVar = new l();
            lVar.l("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.VS.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void qV() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void ct(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.VS != null) {
            this.VS.onDeletedVoice(str);
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
    public boolean qW() {
        return h.Ha == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final int i) {
        if (str != null && i >= 1) {
            h.Ha = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.nx(com.baidu.tbadk.core.voice.a.nw(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.VV);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.VS.onShowErr(4, e.this.context.getString(d.j.voice_error_file_md5));
                                    h.Ha = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.Ha = 1;
                                    e.this.VS.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes6.dex */
    private class a implements g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void p(String str, int i) {
            e.this.releaseWakeLock();
            h.Ha = 1;
            if (e.this.VT == null || str == null) {
                l lVar = new l();
                lVar.l("file", str);
                lVar.l("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (e.this.VS != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.VT)) {
                        e.this.u(e.this.VT, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.VT = null;
                        return;
                    }
                    l lVar2 = new l();
                    lVar2.l("file", str);
                    lVar2.l("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                e.this.VS.onShowErr(2, h.getString(d.j.voice_record_short_tip));
                l lVar3 = new l();
                lVar3.l("file", str);
                lVar3.l("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", lVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.VS == null) {
                h.Ha = 1;
            } else if (i == 7) {
                if (e.this.VT != null) {
                    e.this.u(e.this.VT, com.baidu.adp.lib.voice.d.GZ / 1000);
                    e.this.VT = null;
                    e.this.VS.onShowErr(3, e.this.context.getString(d.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.Ha = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.VS.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aE(int i) {
            if (e.this.VS != null) {
                e.this.VS.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aF(int i) {
            if (e.this.VS != null) {
                e.this.VS.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void lB() {
            h.Ha = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.VV);
        }
        this.context = null;
        this.VS = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.VS = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.VV, 100L);
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
