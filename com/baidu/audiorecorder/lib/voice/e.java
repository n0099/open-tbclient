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
    com.baidu.adp.lib.voice.f Zi;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Zj = null;
    private g Zk = null;
    Runnable Zl = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Zi != null && h.NK == 2) {
                e.this.Zi.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.NK = 1;
    }

    public static e qo() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.checkWriteExternalStorage(this.context.getPageActivity())) {
            this.Zi = fVar;
            if (!m.checkSD()) {
                String sdErrorString = m.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.getString(R.string.voice_error_sdcard);
                }
                this.Zi.onShowErr(0, sdErrorString);
                return false;
            }
            stopPlay(true);
            this.Zj = com.baidu.tbadk.core.voice.a.aRg();
            String vr = com.baidu.tbadk.core.voice.a.vr(this.Zj);
            if (this.Zk == null) {
                this.Zk = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(vr, i, this.Zk);
            if (a2) {
                this.Zi.onStartedRecorder(true);
                h.NK = 2;
                return a2;
            }
            h.NK = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            l lVar = new l();
            lVar.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(-1101, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.Zi.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void qp() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void cN(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.Zi != null) {
            this.Zi.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.delFile(com.baidu.tbadk.core.voice.a.vs(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean qq() {
        return h.NK == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void q(final String str, final int i) {
        if (str != null && i >= 1) {
            h.NK = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.vu(com.baidu.tbadk.core.voice.a.vt(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Zl);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Zi.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.NK = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.NK = 1;
                                    e.this.Zi.onSendVoice(str2, i);
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
        public void l(String str, int i) {
            e.this.releaseWakeLock();
            h.NK = 1;
            if (e.this.Zj == null || str == null) {
                l lVar = new l();
                lVar.append("file", str);
                lVar.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1103, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (e.this.Zi != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Zj)) {
                        e.this.q(e.this.Zj, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Zj = null;
                        return;
                    }
                    l lVar2 = new l();
                    lVar2.append("file", str);
                    lVar2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(-1106, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                e.this.Zi.onShowErr(2, h.getString(R.string.voice_record_short_tip));
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
            if (e.this.Zi == null) {
                h.NK = 1;
            } else if (i == 7) {
                if (e.this.Zj != null) {
                    e.this.q(e.this.Zj, com.baidu.adp.lib.voice.d.NJ / 1000);
                    e.this.Zj = null;
                    e.this.Zi.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.NK = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Zi.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void an(int i) {
            if (e.this.Zi != null) {
                e.this.Zi.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void ao(int i) {
            if (e.this.Zi != null) {
                e.this.Zi.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void mu() {
            h.NK = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Zl);
        }
        this.context = null;
        this.Zi = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.Zi = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Zl, 100L);
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
