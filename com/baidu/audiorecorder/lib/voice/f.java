package com.baidu.audiorecorder.lib.voice;

import android.os.Handler;
import com.baidu.adp.framework.MessageManager;
import com.baidu.adp.framework.message.CustomResponsedMessage;
import com.baidu.adp.lib.util.StringUtils;
import com.baidu.tbadk.TbPageContext;
import com.baidu.tbadk.core.frameworkData.CmdConfigCustom;
import com.baidu.tbadk.core.util.TbErrInfo;
import com.baidu.tbadk.core.util.TiebaStatic;
import com.baidu.tbadk.core.util.ab;
import com.baidu.tbadk.core.util.j;
import com.baidu.tbadk.core.util.k;
import com.baidu.tbadk.core.voice.service.MediaService;
import com.baidu.tieba.d;
/* loaded from: classes2.dex */
public class f implements com.baidu.tieba.tbadkCore.voice.a {
    com.baidu.adp.lib.voice.f IY;
    private TbPageContext<?> context;
    private boolean isAddScreenView;
    private String IZ = null;
    private com.baidu.adp.lib.voice.g Ja = null;
    Runnable Jb = new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.3
        @Override // java.lang.Runnable
        public void run() {
            if (f.this.IY != null && com.baidu.adp.lib.voice.h.zf == 2) {
                f.this.IY.onStopingRecorder();
            }
        }
    };
    private Handler mHandle = new Handler();

    static {
        com.baidu.adp.lib.voice.h.zf = 1;
    }

    public static f lF() {
        return new f();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean a(com.baidu.adp.lib.voice.f fVar, int i) {
        if (fVar != null && !ab.aN(null)) {
            this.IY = fVar;
            if (!k.dG()) {
                String uh = k.uh();
                if (uh == null) {
                    uh = com.baidu.adp.lib.voice.h.getString(d.j.voice_error_sdcard);
                }
                this.IY.onShowErr(0, uh);
                return false;
            }
            Y(true);
            this.IZ = com.baidu.tbadk.core.voice.a.xa();
            String ey = com.baidu.tbadk.core.voice.a.ey(this.IZ);
            if (this.Ja == null) {
                this.Ja = new a();
            }
            com.baidu.audiorecorder.lib.voice.a.stop();
            releaseWakeLock();
            boolean a2 = com.baidu.audiorecorder.lib.voice.a.a(ey, i, this.Ja);
            if (a2) {
                this.IY.onStartedRecorder(true);
                com.baidu.adp.lib.voice.h.zf = 2;
                return a2;
            }
            com.baidu.adp.lib.voice.h.zf = 1;
            com.baidu.audiorecorder.lib.voice.a.stop();
            j jVar = new j();
            jVar.h("voiceType", Integer.valueOf(i));
            TiebaStatic.voiceError(TbErrInfo.ERR_VOI_START, "onTouch-getBtnMsgsendVoice: user click too often", jVar.toString());
            this.IY.onStartedRecorder(false);
            return a2;
        }
        return false;
    }

    public void Y(boolean z) {
        MessageManager.getInstance().dispatchResponsedMessage(new CustomResponsedMessage(CmdConfigCustom.CMD_VOICE_STOP_PLAY, Boolean.valueOf(z)));
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void lG() {
        com.baidu.audiorecorder.lib.voice.a.cancel();
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void bJ(final String str) {
        stopRecord();
        Y(false);
        if (this.IY != null) {
            this.IY.onDeletedVoice(str);
        }
        if (this.mHandle != null) {
            this.mHandle.postDelayed(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.1
                @Override // java.lang.Runnable
                public void run() {
                    if (com.baidu.tbadk.core.voice.a.aE(com.baidu.tbadk.core.voice.a.ez(str))) {
                    }
                }
            }, 200L);
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public boolean lH() {
        return com.baidu.adp.lib.voice.h.zf == 1;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void p(final String str, final int i) {
        if (str != null && i >= 1) {
            com.baidu.adp.lib.voice.h.zf = 3;
            new Thread(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.2
                @Override // java.lang.Runnable
                public void run() {
                    final String str2 = com.baidu.tbadk.core.voice.a.b.eB(com.baidu.tbadk.core.voice.a.eA(str)).md5;
                    if (f.this.mHandle != null) {
                        f.this.mHandle.removeCallbacks(f.this.Jb);
                        if (StringUtils.isNull(str2)) {
                            f.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.2.1
                                @Override // java.lang.Runnable
                                public void run() {
                                    f.this.IY.onShowErr(4, f.this.context.getString(d.j.voice_error_file_md5));
                                    com.baidu.adp.lib.voice.h.zf = 1;
                                }
                            });
                        } else {
                            f.this.mHandle.post(new Runnable() { // from class: com.baidu.audiorecorder.lib.voice.f.2.2
                                @Override // java.lang.Runnable
                                public void run() {
                                    com.baidu.adp.lib.voice.h.zf = 1;
                                    f.this.IY.onSendVoice(str2, i);
                                }
                            });
                        }
                    }
                }
            }).start();
        }
    }

    /* loaded from: classes2.dex */
    private class a implements com.baidu.adp.lib.voice.g {
        private a() {
        }

        @Override // com.baidu.adp.lib.voice.e
        public void k(String str, int i) {
            f.this.releaseWakeLock();
            com.baidu.adp.lib.voice.h.zf = 1;
            if (f.this.IZ == null || str == null) {
                j jVar = new j();
                jVar.h("file", str);
                jVar.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILE, "RecoreCallback.succ: file is null", jVar.toString());
            } else if (f.this.IY != null) {
                if (i > 1000) {
                    if (str.endsWith(f.this.IZ)) {
                        f.this.p(f.this.IZ, (int) Math.round((i * 1.0d) / 1000.0d));
                        f.this.IZ = null;
                        return;
                    }
                    j jVar2 = new j();
                    jVar2.h("file", str);
                    jVar2.h("dur", Integer.valueOf(i));
                    TiebaStatic.voiceError(TbErrInfo.ERR_VOI_FILENAME, "RecoreCallback.succ: filename error", jVar2.toString());
                    return;
                }
                f.this.IY.onShowErr(2, com.baidu.adp.lib.voice.h.getString(d.j.voice_record_short_tip));
                j jVar3 = new j();
                jVar3.h("file", str);
                jVar3.h("dur", Integer.valueOf(i));
                TiebaStatic.voiceError(TbErrInfo.ERR_VOI_LEN, "voice too short", jVar3.toString());
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void f(int i, String str) {
            f.this.releaseWakeLock();
            TiebaStatic.voiceError(i, "RecoreCallback.error: " + str, "");
            if (f.this.IY == null) {
                com.baidu.adp.lib.voice.h.zf = 1;
            } else if (i == 7) {
                if (f.this.IZ != null) {
                    f.this.p(f.this.IZ, com.baidu.adp.lib.voice.d.ze / 1000);
                    f.this.IZ = null;
                    f.this.IY.onShowErr(3, f.this.context.getString(d.j.voice_record_timeout_tip));
                    return;
                }
                TiebaStatic.voiceError(i, "RecoreCallback.error data err: " + str, "errCode == BdRecordingResult.TIME_OUT");
            } else {
                com.baidu.adp.lib.voice.h.zf = 1;
                if (i == 8) {
                    i = 2;
                }
                f.this.IY.onShowErr(i, str);
                TiebaStatic.voiceError(i, "RecoreCallback.err: " + str, "");
            }
        }

        @Override // com.baidu.adp.lib.voice.e
        public void aA(int i) {
            if (f.this.IY != null) {
                f.this.IY.onShowRecording(i);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void aB(int i) {
            if (f.this.IY != null) {
                f.this.IY.onShowRecordTime(i / 1000);
            }
        }

        @Override // com.baidu.adp.lib.voice.g
        public void hL() {
            com.baidu.adp.lib.voice.h.zf = 1;
        }
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void release() {
        stopRecord();
        if (this.context != null && this.context.getPageActivity() != null) {
            MediaService.stopMy(this.context.getPageActivity());
        }
        if (this.mHandle != null) {
            this.mHandle.removeCallbacks(this.Jb);
        }
        this.context = null;
        this.IY = null;
        this.mHandle = null;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void a(com.baidu.adp.lib.voice.f fVar) {
        this.IY = fVar;
    }

    @Override // com.baidu.tieba.tbadkCore.voice.a
    public void stopRecord() {
        com.baidu.audiorecorder.lib.voice.a.stop();
        if (this.mHandle != null) {
            this.mHandle.postDelayed(this.Jb, 100L);
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
