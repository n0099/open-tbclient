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
/* loaded from: classes24.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f acs;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String act = null;
    private g acu = null;
    Runnable acv = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.acs != null && h.QM == 2) {
                e.this.acs.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.QM = 1;
    }

    public static e sv() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ae.checkWriteExternalStorage(this.context.getPageActivity())) {
            this.acs = fVar;
            if (!n.checkSD()) {
                String sdErrorString = n.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.getString(R.string.voice_error_sdcard);
                }
                this.acs.onShowErr(0, sdErrorString);
                return false;
            }
            stopPlay(true);
            this.act = com.baidu.tbadk.core.voice.a.bwK();
            String CH = com.baidu.tbadk.core.voice.a.CH(this.act);
            if (this.acu == null) {
                this.acu = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(CH, i, this.acu);
            if (a2) {
                this.acs.onStartedRecorder(true);
                h.QM = 2;
                return a2;
            }
            h.QM = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            m mVar = new m();
            mVar.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(-1101, "onTouch-getBtnMsgsendVoice: user click too often", mVar.toString());
            this.acs.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void sw() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void db(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.acs != null) {
            this.acs.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.CI(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean sx() {
        return h.QM == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final String str, final int i) {
        if (str != null && i >= 1) {
            h.QM = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.CK(com.baidu.tbadk.core.voice.a.CJ(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.acv);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.acs.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.QM = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.QM = 1;
                                    e.this.acs.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes24.dex */
    private class a implements g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void m(String str, int i) {
            e.this.releaseWakeLock();
            h.QM = 1;
            if (e.this.act == null || str == null) {
                m mVar = new m();
                mVar.append("file", str);
                mVar.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1103, "RecoreCallback.succ: file is null", mVar.toString());
            } else if (e.this.acs != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.act)) {
                        e.this.r(e.this.act, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.act = null;
                        return;
                    }
                    m mVar2 = new m();
                    mVar2.append("file", str);
                    mVar2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(-1106, "RecoreCallback.succ: filename error", mVar2.toString());
                    return;
                }
                e.this.acs.onShowErr(2, h.getString(R.string.voice_record_short_tip));
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
            if (e.this.acs == null) {
                h.QM = 1;
            } else if (i == 7) {
                if (e.this.act != null) {
                    e.this.r(e.this.act, com.baidu.adp.lib.voice.d.QL / 1000);
                    e.this.act = null;
                    e.this.acs.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.QM = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.acs.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aE(int i) {
            if (e.this.acs != null) {
                e.this.acs.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aF(int i) {
            if (e.this.acs != null) {
                e.this.acs.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void os() {
            h.QM = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.acv);
        }
        this.context = null;
        this.acs = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.acs = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.acv, 100L);
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
