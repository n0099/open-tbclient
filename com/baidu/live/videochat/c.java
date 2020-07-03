package com.baidu.live.videochat;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
import com.baidu.ala.helper.AlaLiveDebugInfo;
import com.baidu.ala.recorder.AlaLiveRecorder;
import com.baidu.ala.recorder.RecorderCallback;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.data.AlaLiveUserInfoData;
import com.baidu.live.recorder.helper.LiveRecorderConfigHelper;
/* loaded from: classes3.dex */
public class c {
    private AlaLiveRecorder bkF;
    private View bkG;
    private com.baidu.live.videochat.c.d bkH;
    private a bkI;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bkJ = 1;
    private boolean bkK = false;
    private long mChatId = 0;
    private boolean bkL = false;
    private Runnable bkM = null;
    private com.baidu.live.videochat.c.a bkN = new com.baidu.live.videochat.c.a() { // from class: com.baidu.live.videochat.c.1
        @Override // com.baidu.live.videochat.c.a
        public int wa() {
            if (c.this.bkF != null) {
                return c.this.bkF.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.c.a
        public int Jz() {
            return c.this.bkK ? 1 : 2;
        }
    };
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.c.2
        @Override // com.baidu.ala.recorder.RecorderCallback
        public void flashLightSwitched(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void cameraSwitched(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamLostPackageRateReceived(double d) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void streamStateReceived(int i, boolean z, int i2, boolean z2) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStart(boolean z, int i, int i2) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onVideoCollectionStop() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onAudioOpened(boolean z) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onDebugInfo(AlaLiveDebugInfo alaLiveDebugInfo) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onError(int i, String str) {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onRtcConnected(int i) {
            c.this.bkK = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.c.e bkO = new com.baidu.live.videochat.c.e() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.c.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            c.this.bkL = false;
            if (aVar != null) {
                c.this.a(aVar.chatId, aVar.awk, aVar.awl, false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void y(int i, String str) {
            c.this.bkL = false;
            if (c.this.bkI != null) {
                c.this.bkI.r(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JA() {
            c.this.bkL = false;
            if (c.this.bkH != null) {
                c.this.bkH.Kq();
            }
            if (c.this.bkI != null) {
                c.this.bkI.Jt();
            }
            c.this.bkJ = 1;
        }

        @Override // com.baidu.live.videochat.c.e
        public void z(int i, String str) {
            c.this.bkL = false;
            if (c.this.bkI != null) {
                c.this.bkI.s(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JB() {
            if (c.this.bkI != null) {
                c.this.bkI.cv(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void A(int i, String str) {
            if (c.this.bkI != null) {
                c.this.bkI.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JC() {
            if (c.this.bkI != null) {
                c.this.bkI.cv(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void B(int i, String str) {
            if (c.this.bkI != null) {
                c.this.bkI.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JD() {
            if (c.this.bkI != null) {
                c.this.bkI.cw(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void C(int i, String str) {
            if (c.this.bkI != null) {
                c.this.bkI.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JE() {
            if (c.this.bkI != null) {
                c.this.bkI.cw(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void D(int i, String str) {
            if (c.this.bkI != null) {
                c.this.bkI.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (c.this.bkJ == 2 && c.this.bkI != null) {
                    c.this.bkI.a(null);
                }
                c.this.bkJ = 1;
                c.this.bkH.Kq();
                return;
            }
            if (!c.this.bkL && c.this.bkI != null) {
                c.this.bkI.a(cVar.aBG);
            }
            c.this.bkJ = 2;
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (c.this.bkJ != 4 && bVar != null && bVar.JW() == 2) {
                c.this.bkJ = 4;
                if (c.this.bkI != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aBG;
                    }
                    c.this.bkI.a(c.this.bkH.JV(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            c.this.Jy();
        }

        @Override // com.baidu.live.videochat.c.c
        public void JF() {
            c.this.Jy();
        }

        @Override // com.baidu.live.videochat.c.c
        public void E(int i, String str) {
            if (c.this.bkI != null) {
                c.this.bkI.t(i, str);
            }
        }
    };
    private BdUniqueId aZD = BdUniqueId.gen();

    public c(Activity activity) {
        this.mActivity = activity;
        this.bkH = new com.baidu.live.videochat.c.d(activity, this.aZD);
        this.bkH.a(this.bkO);
        this.bkH.a(this.bkN);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bkF != null && this.bkF.getPreview() != null) {
            if (this.bkF.getPreview().getParent() != null) {
                ((ViewGroup) this.bkF.getPreview().getParent()).removeView(this.bkF.getPreview());
            }
            this.bkF.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.d.a.a(this.bkF, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bkG = this.bkF.createPKPlayer();
        }
    }

    private void Jx() {
        this.bkG = null;
        if (this.bkF != null) {
            this.bkF.removeRecorderCallback(this.mRecorderCallback);
            if (this.bkF.getPreview().getParent() != null) {
                ((ViewGroup) this.bkF.getPreview().getParent()).removeView(this.bkF.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.GG().f(true, false);
            this.bkF.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bkJ != 3) {
            this.bkH.d(j, false);
            this.bkH.Kq();
            if (this.bkI != null && !z) {
                this.bkI.Js();
            }
            this.bkJ = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bkI != null) {
                this.bkI.a(j, this.bkF.getPreview(), this.bkG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Jy() {
        this.bkH.Ks();
        if (this.bkJ != 1) {
            Jx();
            this.bkJ = 1;
            if (this.bkI != null) {
                this.bkI.ay(this.bkH.JV());
            }
        }
    }
}
