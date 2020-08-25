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
import com.baidu.tbadk.core.util.ae;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
/* loaded from: classes18.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f aaD;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String aaE = null;
    private g aaF = null;
    Runnable aaG = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.aaD != null && h.Pc == 2) {
                e.this.aaD.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.Pc = 1;
    }

    public static e sn() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ae.checkWriteExternalStorage(this.context.getPageActivity())) {
            this.aaD = fVar;
            if (!n.checkSD()) {
                String sdErrorString = n.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.getString(R.string.voice_error_sdcard);
                }
                this.aaD.onShowErr(0, sdErrorString);
                return false;
            }
            stopPlay(true);
            this.aaE = com.baidu.tbadk.core.voice.a.blX();
            String AK = com.baidu.tbadk.core.voice.a.AK(this.aaE);
            if (this.aaF == null) {
                this.aaF = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(AK, i, this.aaF);
            if (a2) {
                this.aaD.onStartedRecorder(true);
                h.Pc = 2;
                return a2;
            }
            h.Pc = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            m mVar = new m();
            mVar.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(-1101, "onTouch-getBtnMsgsendVoice: user click too often", mVar.toString());
            this.aaD.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void so() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void cT(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.aaD != null) {
            this.aaD.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.AL(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean sp() {
        return h.Pc == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final String str, final int i) {
        if (str != null && i >= 1) {
            h.Pc = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.AN(com.baidu.tbadk.core.voice.a.AM(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.aaG);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.aaD.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.Pc = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.Pc = 1;
                                    e.this.aaD.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes18.dex */
    private class a implements g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void m(String str, int i) {
            e.this.releaseWakeLock();
            h.Pc = 1;
            if (e.this.aaE == null || str == null) {
                m mVar = new m();
                mVar.append("file", str);
                mVar.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1103, "RecoreCallback.succ: file is null", mVar.toString());
            } else if (e.this.aaD != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.aaE)) {
                        e.this.r(e.this.aaE, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.aaE = null;
                        return;
                    }
                    m mVar2 = new m();
                    mVar2.append("file", str);
                    mVar2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(-1106, "RecoreCallback.succ: filename error", mVar2.toString());
                    return;
                }
                e.this.aaD.onShowErr(2, h.getString(R.string.voice_record_short_tip));
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
            if (e.this.aaD == null) {
                h.Pc = 1;
            } else if (i == 7) {
                if (e.this.aaE != null) {
                    e.this.r(e.this.aaE, com.baidu.adp.lib.voice.d.Pb / 1000);
                    e.this.aaE = null;
                    e.this.aaD.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.Pc = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.aaD.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void ay(int i) {
            if (e.this.aaD != null) {
                e.this.aaD.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void az(int i) {
            if (e.this.aaD != null) {
                e.this.aaD.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void on() {
            h.Pc = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.aaG);
        }
        this.context = null;
        this.aaD = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.aaD = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.aaG, 100L);
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
