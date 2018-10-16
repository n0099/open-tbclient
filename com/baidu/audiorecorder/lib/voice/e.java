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
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.util.l;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.e;
/* loaded from: classes3.dex */
public class e implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f Td;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String Te = null;
    private g Tf = null;
    Runnable Tg = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.3
        @Override // java.lang.Runnable
        public void run() {
            if (e.this.Td != null && h.GX == 2) {
                e.this.Td.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        h.GX = 1;
    }

    public static e pR() {
        return new e();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar == null || this.context == null) {
            return false;
        }
        if (ab.bE(this.context.getPageActivity())) {
            this.Td = fVar;
            if (!l.hB()) {
                String Bw = l.Bw();
                if (Bw == null) {
                    Bw = h.getString(e.j.voice_error_sdcard);
                }
                this.Td.onShowErr(0, Bw);
                return false;
            }
            stopPlay(true);
            this.Te = com.baidu.tbadk.core.voice.a.Ey();
            String ga = com.baidu.tbadk.core.voice.a.ga(this.Te);
            if (this.Tf == null) {
                this.Tf = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(ga, i, this.Tf);
            if (a2) {
                this.Td.onStartedRecorder(true);
                h.GX = 2;
                return a2;
            }
            h.GX = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            k kVar = new k();
            kVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", kVar.toString());
            this.Td.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void stopPlay(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(2001273, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void pS() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void ct(final String str) {
        stopRecord();
        stopPlay(false);
        if (this.Td != null) {
            this.Td.onDeletedVoice(str);
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
    public boolean pT() {
        return h.GX == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void u(final String str, final int i) {
        if (str != null && i >= 1) {
            h.GX = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.gc(com.baidu.tbadk.core.voice.a.gb(str)).md5;
                    if (e.this.mHandle != null) {
                        e.this.mHandle.removeCallbacks(e.this.Tg);
                        if (StringUtils.isNull(str2)) {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    e.this.Td.onShowErr(4, e.this.context.getString(e.j.voice_error_file_md5));
                                    h.GX = 1;
                                }
                            });
                        } else {
                            e.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.e.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    h.GX = 1;
                                    e.this.Td.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes3.dex */
    private class a implements g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void p(String str, int i) {
            e.this.releaseWakeLock();
            h.GX = 1;
            if (e.this.Te == null || str == null) {
                k kVar = new k();
                kVar.h("file", str);
                kVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", kVar.toString());
            } else if (e.this.Td != null) {
                if (i > 1000) {
                    if (str.endsWith(e.this.Te)) {
                        e.this.u(e.this.Te, (int) Math.round((i * 1.0d) / 1000.0d));
                        e.this.Te = null;
                        return;
                    }
                    k kVar2 = new k();
                    kVar2.h("file", str);
                    kVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", kVar2.toString());
                    return;
                }
                e.this.Td.onShowErr(2, h.getString(e.j.voice_record_short_tip));
                k kVar3 = new k();
                kVar3.h("file", str);
                kVar3.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", kVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void error(int i, String str) {
            e.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (e.this.Td == null) {
                h.GX = 1;
            } else if (i == 7) {
                if (e.this.Te != null) {
                    e.this.u(e.this.Te, com.baidu.adp.lib.voice.d.GW / 1000);
                    e.this.Te = null;
                    e.this.Td.onShowErr(3, e.this.context.getString(e.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                h.GX = 1;
                if (i == 8) {
                    i = 2;
                }
                e.this.Td.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aE(int i) {
            if (e.this.Td != null) {
                e.this.Td.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aF(int i) {
            if (e.this.Td != null) {
                e.this.Td.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void lz() {
            h.GX = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Tg);
        }
        this.context = null;
        this.Td = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.Td = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Tg, 100L);
        }
        releaseWakeLock();
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void releaseWakeLock() {
        removeBlackScreen();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void setContext(TbPageContext<?> tbPageContext) {
        this.context = tbPageContext;
    }

    private void removeBlackScreen() {
        this.isAddScreenView = false;
    }
}
