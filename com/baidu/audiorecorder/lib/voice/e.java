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
    com.baidu.adp.lib.voice.f abp;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String abq = null;
    private g abr = null;
    Runnable abt = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.abp != null && h.PQ == 2) {
                e.this.abp.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.PQ = 1;
    }

    public static e ss() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ae.checkWriteExternalStorage(this.context.getPageActivity())) {
            this.abp = fVar;
            if (!n.checkSD()) {
                String sdErrorString = n.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.getString(R.string.voice_error_sdcard);
                }
                this.abp.onShowErr(0, sdErrorString);
                return false;
            }
            stopPlay(true);
            this.abq = com.baidu.tbadk.core.voice.a.bru();
            String Cm = com.baidu.tbadk.core.voice.a.Cm(this.abq);
            if (this.abr == null) {
                this.abr = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(Cm, i, this.abr);
            if (a2) {
                this.abp.onStartedRecorder(true);
                h.PQ = 2;
                return a2;
            }
            h.PQ = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            m mVar = new m();
            mVar.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(-1101, "onTouch-getBtnMsgsendVoice: user click too often", mVar.toString());
            this.abp.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void st() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void cW(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.abp != null) {
            this.abp.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.Cn(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean su() {
        return h.PQ == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void r(final String str, final int i) {
        if (str != null && i >= 1) {
            h.PQ = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.Cp(com.baidu.tbadk.core.voice.a.Co(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.abt);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.abp.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.PQ = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.PQ = 1;
                                    e.this.abp.onSendVoice(str2, i);
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
            h.PQ = 1;
            if (e.this.abq == null || str == null) {
                m mVar = new m();
                mVar.append("file", str);
                mVar.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1103, "RecoreCallback.succ: file is null", mVar.toString());
            } else if (e.this.abp != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.abq)) {
                        e.this.r(e.this.abq, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.abq = null;
                        return;
                    }
                    m mVar2 = new m();
                    mVar2.append("file", str);
                    mVar2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(-1106, "RecoreCallback.succ: filename error", mVar2.toString());
                    return;
                }
                e.this.abp.onShowErr(2, h.getString(R.string.voice_record_short_tip));
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
            if (e.this.abp == null) {
                h.PQ = 1;
            } else if (i == 7) {
                if (e.this.abq != null) {
                    e.this.r(e.this.abq, com.baidu.adp.lib.voice.d.PP / 1000);
                    e.this.abq = null;
                    e.this.abp.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.PQ = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.abp.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aB(int i) {
            if (e.this.abp != null) {
                e.this.abp.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aC(int i) {
            if (e.this.abp != null) {
                e.this.abp.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void ot() {
            h.PQ = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.abt);
        }
        this.context = null;
        this.abp = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.abp = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.abt, 100L);
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
