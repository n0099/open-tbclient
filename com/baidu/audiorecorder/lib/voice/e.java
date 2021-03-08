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
import com.baidu.tbadk.core.util.n;
import com.baidu.tbadk.core.util.o;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
/* loaded from: classes7.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f aeq;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String aer = null;
    private g aes = null;
    Runnable aet = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.aeq != null && h.Sh == 2) {
                e.this.aeq.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.Sh = 1;
    }

    public static e rT() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ae.checkWriteExternalStorage(this.context.getPageActivity())) {
            this.aeq = fVar;
            if (!o.checkSD()) {
                String sdErrorString = o.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.getString(R.string.voice_error_sdcard);
                }
                this.aeq.onShowErr(0, sdErrorString);
                return false;
            }
            stopPlay(true);
            this.aer = com.baidu.tbadk.core.voice.a.bvH();
            String BR = com.baidu.tbadk.core.voice.a.BR(this.aer);
            if (this.aes == null) {
                this.aes = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(BR, i, this.aes);
            if (a2) {
                this.aeq.onStartedRecorder(true);
                h.Sh = 2;
                return a2;
            }
            h.Sh = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            n nVar = new n();
            nVar.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(-1101, "onTouch-getBtnMsgsendVoice: user click too often", nVar.toString());
            this.aeq.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void rU() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void cY(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.aeq != null) {
            this.aeq.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.BS(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean rV() {
        return h.Sh == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final String str, final int i) {
        if (str != null && i >= 1) {
            h.Sh = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.BU(com.baidu.tbadk.core.voice.a.BT(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.aet);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.aeq.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.Sh = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.Sh = 1;
                                    e.this.aeq.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes7.dex */
    private class a implements g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void m(String str, int i) {
            e.this.releaseWakeLock();
            h.Sh = 1;
            if (e.this.aer == null || str == null) {
                n nVar = new n();
                nVar.append("file", str);
                nVar.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1103, "RecoreCallback.succ: file is null", nVar.toString());
            } else if (e.this.aeq != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.aer)) {
                        e.this.r(e.this.aer, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.aer = null;
                        return;
                    }
                    n nVar2 = new n();
                    nVar2.append("file", str);
                    nVar2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(-1106, "RecoreCallback.succ: filename error", nVar2.toString());
                    return;
                }
                e.this.aeq.onShowErr(2, h.getString(R.string.voice_record_short_tip));
                n nVar3 = new n();
                nVar3.append("file", str);
                nVar3.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1105, "voice too short", nVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.aeq == null) {
                h.Sh = 1;
            } else if (i == 7) {
                if (e.this.aer != null) {
                    e.this.r(e.this.aer, com.baidu.adp.lib.voice.d.Sg / 1000);
                    e.this.aer = null;
                    e.this.aeq.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.Sh = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.aeq.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aF(int i) {
            if (e.this.aeq != null) {
                e.this.aeq.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aG(int i) {
            if (e.this.aeq != null) {
                e.this.aeq.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void nS() {
            h.Sh = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.aet);
        }
        this.context = null;
        this.aeq = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.aeq = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.aet, 100L);
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
