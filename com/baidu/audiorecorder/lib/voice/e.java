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
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f TH;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String TI = null;
    private g TJ = null;
    Runnable TK = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.TH != null && h.EK == 2) {
                e.this.TH.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.EK = 1;
    }

    public static e pP() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.cA(this.context.getPageActivity())) {
            this.TH = fVar;
            if (!m.gs()) {
                String agZ = m.agZ();
                if (agZ == null) {
                    agZ = h.getString(R.string.voice_error_sdcard);
                }
                this.TH.onShowErr(0, agZ);
                return false;
            }
            stopPlay(true);
            this.TI = com.baidu.tbadk.core.voice.a.akq();
            String oF = com.baidu.tbadk.core.voice.a.oF(this.TI);
            if (this.TJ == null) {
                this.TJ = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(oF, i, this.TJ);
            if (a2) {
                this.TH.onStartedRecorder(true);
                h.EK = 2;
                return a2;
            }
            h.EK = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            l lVar = new l();
            lVar.o("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.TH.onStartedRecorder(false);
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
    public void cd(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.TH != null) {
            this.TH.onDeletedVoice(str);
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
    public boolean pR() {
        return h.EK == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void o(final String str, final int i) {
        if (str != null && i >= 1) {
            h.EK = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.oH(com.baidu.tbadk.core.voice.a.oG(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.TK);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.TH.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.EK = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.EK = 1;
                                    e.this.TH.onSendVoice(str2, i);
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
        public void j(String str, int i) {
            e.this.releaseWakeLock();
            h.EK = 1;
            if (e.this.TI == null || str == null) {
                l lVar = new l();
                lVar.o("file", str);
                lVar.o("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (e.this.TH != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.TI)) {
                        e.this.o(e.this.TI, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.TI = null;
                        return;
                    }
                    l lVar2 = new l();
                    lVar2.o("file", str);
                    lVar2.o("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                e.this.TH.onShowErr(2, h.getString(R.string.voice_record_short_tip));
                l lVar3 = new l();
                lVar3.o("file", str);
                lVar3.o("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", lVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.TH == null) {
                h.EK = 1;
            } else if (i == 7) {
                if (e.this.TI != null) {
                    e.this.o(e.this.TI, com.baidu.adp.lib.voice.d.EJ / 1000);
                    e.this.TI = null;
                    e.this.TH.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.EK = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.TH.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void ax(int i) {
            if (e.this.TH != null) {
                e.this.TH.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void ay(int i) {
            if (e.this.TH != null) {
                e.this.TH.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void kv() {
            h.EK = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.TK);
        }
        this.context = null;
        this.TH = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.TH = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.TK, 100L);
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
