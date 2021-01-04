package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ad;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
/* loaded from: classes8.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f adf;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String adg = null;
    private g adh = null;
    Runnable adi = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.adf != null && h.QP == 2) {
                e.this.adf.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.QP = 1;
    }

    public static e rW() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ad.checkWriteExternalStorage(this.context.getPageActivity())) {
            this.adf = fVar;
            if (!n.checkSD()) {
                String sdErrorString = n.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.getString(R.string.voice_error_sdcard);
                }
                this.adf.onShowErr(0, sdErrorString);
                return false;
            }
            stopPlay(true);
            this.adg = com.baidu.tbadk.core.voice.a.bzd();
            String CF = com.baidu.tbadk.core.voice.a.CF(this.adg);
            if (this.adh == null) {
                this.adh = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(CF, i, this.adh);
            if (a2) {
                this.adf.onStartedRecorder(true);
                h.QP = 2;
                return a2;
            }
            h.QP = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            m mVar = new m();
            mVar.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(-1101, "onTouch-getBtnMsgsendVoice: user click too often", mVar.toString());
            this.adf.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void rX() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void cU(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.adf != null) {
            this.adf.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CG(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean rY() {
        return h.QP == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final String str, final int i) {
        if (str != null && i >= 1) {
            h.QP = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.CI(com.baidu.tbadk.core.voice.a.CH(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.adi);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.adf.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.QP = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.QP = 1;
                                    e.this.adf.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes8.dex */
    private class a implements g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void m(String str, int i) {
            e.this.releaseWakeLock();
            h.QP = 1;
            if (e.this.adg == null || str == null) {
                m mVar = new m();
                mVar.append("file", str);
                mVar.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1103, "RecoreCallback.succ: file is null", mVar.toString());
            } else if (e.this.adf != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.adg)) {
                        e.this.r(e.this.adg, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.adg = null;
                        return;
                    }
                    m mVar2 = new m();
                    mVar2.append("file", str);
                    mVar2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(-1106, "RecoreCallback.succ: filename error", mVar2.toString());
                    return;
                }
                e.this.adf.onShowErr(2, h.getString(R.string.voice_record_short_tip));
                m mVar3 = new m();
                mVar3.append("file", str);
                mVar3.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1105, "voice too short", mVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.adf == null) {
                h.QP = 1;
            } else if (i == 7) {
                if (e.this.adg != null) {
                    e.this.r(e.this.adg, com.baidu.adp.lib.voice.d.QO / 1000);
                    e.this.adg = null;
                    e.this.adf.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.QP = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.adf.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aF(int i) {
            if (e.this.adf != null) {
                e.this.adf.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aG(int i) {
            if (e.this.adf != null) {
                e.this.adf.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void nT() {
            h.QP = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.adi);
        }
        this.context = null;
        this.adf = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.adf = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.adi, 100L);
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
