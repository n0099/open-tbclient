package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.adp.lib.voice.g;
import com.baidu.adp.lib.voice.h;
import com.baidu.live.adp.lib.stats.BdStatsConstant;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.util.m;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.R;
/* loaded from: classes6.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f Dq;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Dr = null;
    private g Ds = null;
    Runnable Dt = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Dq != null && h.sa == 2) {
                e.this.Dq.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.sa = 1;
    }

    public static e lf() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.checkWriteExternalStorage(this.context.getPageActivity())) {
            this.Dq = fVar;
            if (!m.checkSD()) {
                String sdErrorString = m.getSdErrorString();
                if (sdErrorString == null) {
                    sdErrorString = h.getString(R.string.voice_error_sdcard);
                }
                this.Dq.onShowErr(0, sdErrorString);
                return false;
            }
            stopPlay(true);
            this.Dr = com.baidu.tbadk.core.voice.a.aox();
            String oC = com.baidu.tbadk.core.voice.a.oC(this.Dr);
            if (this.Ds == null) {
                this.Ds = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(oC, i, this.Ds);
            if (a2) {
                this.Dq.onStartedRecorder(true);
                h.sa = 2;
                return a2;
            }
            h.sa = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            l lVar = new l();
            lVar.append("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(-1101, "onTouch-getBtnMsgsendVoice: user click too often", lVar.toString());
            this.Dq.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lg() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bm(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.Dq != null) {
            this.Dq.onDeletedVoice(str);
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
    public boolean lh() {
        return h.sa == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void j(final String str, final int i) {
        if (str != null && i >= 1) {
            h.sa = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.oE(com.baidu.tbadk.core.voice.a.oD(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Dt);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Dq.onShowErr(4, e.this.context.getString(R.string.voice_error_file_md5));
                                    h.sa = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.sa = 1;
                                    e.this.Dq.onSendVoice(str2, i);
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
        public void e(String str, int i) {
            e.this.releaseWakeLock();
            h.sa = 1;
            if (e.this.Dr == null || str == null) {
                l lVar = new l();
                lVar.append(BdStatsConstant.OpSubType.FILE, str);
                lVar.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1103, "RecoreCallback.succ: file is null", lVar.toString());
            } else if (e.this.Dq != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Dr)) {
                        e.this.j(e.this.Dr, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Dr = null;
                        return;
                    }
                    l lVar2 = new l();
                    lVar2.append(BdStatsConstant.OpSubType.FILE, str);
                    lVar2.append("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(-1106, "RecoreCallback.succ: filename error", lVar2.toString());
                    return;
                }
                e.this.Dq.onShowErr(2, h.getString(R.string.voice_record_short_tip));
                l lVar3 = new l();
                lVar3.append(BdStatsConstant.OpSubType.FILE, str);
                lVar3.append("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(-1105, "voice too short", lVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.Dq == null) {
                h.sa = 1;
            } else if (i == 7) {
                if (e.this.Dr != null) {
                    e.this.j(e.this.Dr, com.baidu.adp.lib.voice.d.rZ / 1000);
                    e.this.Dr = null;
                    e.this.Dq.onShowErr(3, e.this.context.getString(R.string.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.sa = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Dq.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void U(int i) {
            if (e.this.Dq != null) {
                e.this.Dq.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void V(int i) {
            if (e.this.Dq != null) {
                e.this.Dq.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void hg() {
            h.sa = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Dt);
        }
        this.context = null;
        this.Dq = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.Dq = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Dt, 100L);
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
