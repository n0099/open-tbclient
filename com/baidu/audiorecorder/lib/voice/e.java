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
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
/* loaded from: classes11.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f FU;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String FV = null;
    private g FW = null;
    Runnable FX = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.FU != null && h.uQ == 2) {
                e.this.FU.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.uQ = 1;
    }

    public static e lM() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.checkWriteExternalStorage(this.context.getPageActivity())) {
            this.FU = fVar;
            if (!m.checkSD()) {
                String sdErrorString = m.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.getString(R.string.voice_error_sdcard);
                }
                this.FU.onShowErr(0, sdErrorString);
                return false;
            }
            stopPlay(true);
            this.FV = com.baidu.tbadk.core.voice.a.aIG();
            String ua = com.baidu.tbadk.core.voice.a.ua(this.FV);
            if (this.FW == null) {
                this.FW = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(ua, i, this.FW);
            if (a2) {
                this.FU.onStartedRecorder(true);
                h.uQ = 2;
                return a2;
            }
            h.uQ = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            l lVar = new l();
            lVar.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(-1101, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.FU.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lN() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bz(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.FU != null) {
            this.FU.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.getVoiceFilePath(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lO() {
        return h.uQ == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void m(final String str, final int i) {
        if (str != null && i >= 1) {
            h.uQ = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.uc(com.baidu.tbadk.core.voice.a.ub(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.FX);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.FU.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.uQ = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.uQ = 1;
                                    e.this.FU.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes11.dex */
    private class a implements g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void h(String str, int i) {
            e.this.releaseWakeLock();
            h.uQ = 1;
            if (e.this.FV == null || str == null) {
                l lVar = new l();
                lVar.append("file", str);
                lVar.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1103, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (e.this.FU != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.FV)) {
                        e.this.m(e.this.FV, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.FV = null;
                        return;
                    }
                    l lVar2 = new l();
                    lVar2.append("file", str);
                    lVar2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(-1106, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                e.this.FU.onShowErr(2, h.getString(R.string.voice_record_short_tip));
                l lVar3 = new l();
                lVar3.append("file", str);
                lVar3.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1105, "voice too short", lVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.FU == null) {
                h.uQ = 1;
            } else if (i == 7) {
                if (e.this.FV != null) {
                    e.this.m(e.this.FV, com.baidu.adp.lib.voice.d.uP / 1000);
                    e.this.FV = null;
                    e.this.FU.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.uQ = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.FU.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void ab(int i) {
            if (e.this.FU != null) {
                e.this.FU.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void ac(int i) {
            if (e.this.FU != null) {
                e.this.FU.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void hQ() {
            h.uQ = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.FX);
        }
        this.context = null;
        this.FU = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.FU = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.FX, 100L);
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
