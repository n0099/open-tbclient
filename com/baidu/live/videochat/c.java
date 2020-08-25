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
/* loaded from: classes7.dex */
public class c {
    private AlaLiveRecorder bqF;
    private View bqG;
    private com.baidu.live.videochat.c.d bqH;
    private a bqI;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bqJ = 1;
    private boolean bqK = false;
    private long mChatId = 0;
    private boolean bqL = false;
    private Runnable bqM = null;
    private com.baidu.live.videochat.c.a bqN = new com.baidu.live.videochat.c.a() { // from class: com.baidu.live.videochat.c.1
        @Override // com.baidu.live.videochat.c.a
        public int BU() {
            if (c.this.bqF != null) {
                return c.this.bqF.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.c.a
        public int Py() {
            return c.this.bqK ? 1 : 2;
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
            c.this.bqK = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.c.e bqO = new com.baidu.live.videochat.c.e() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.c.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            c.this.bqL = false;
            if (aVar != null) {
                c.this.a(aVar.chatId, aVar.aCr, aVar.aCs, false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void x(int i, String str) {
            c.this.bqL = false;
            if (c.this.bqI != null) {
                c.this.bqI.q(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Pz() {
            c.this.bqL = false;
            if (c.this.bqH != null) {
                c.this.bqH.Qp();
            }
            if (c.this.bqI != null) {
                c.this.bqI.Ps();
            }
            c.this.bqJ = 1;
        }

        @Override // com.baidu.live.videochat.c.e
        public void y(int i, String str) {
            c.this.bqL = false;
            if (c.this.bqI != null) {
                c.this.bqI.r(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void PA() {
            if (c.this.bqI != null) {
                c.this.bqI.cF(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void z(int i, String str) {
            if (c.this.bqI != null) {
                c.this.bqI.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void PB() {
            if (c.this.bqI != null) {
                c.this.bqI.cF(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void A(int i, String str) {
            if (c.this.bqI != null) {
                c.this.bqI.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void PC() {
            if (c.this.bqI != null) {
                c.this.bqI.cG(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void B(int i, String str) {
            if (c.this.bqI != null) {
                c.this.bqI.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void PD() {
            if (c.this.bqI != null) {
                c.this.bqI.cG(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void C(int i, String str) {
            if (c.this.bqI != null) {
                c.this.bqI.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (c.this.bqJ == 2 && c.this.bqI != null) {
                    c.this.bqI.a(null);
                }
                c.this.bqJ = 1;
                c.this.bqH.Qp();
                return;
            }
            if (!c.this.bqL && c.this.bqI != null) {
                c.this.bqI.a(cVar.aIl);
            }
            c.this.bqJ = 2;
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (c.this.bqJ != 4 && bVar != null && bVar.PV() == 2) {
                c.this.bqJ = 4;
                if (c.this.bqI != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aIl;
                    }
                    c.this.bqI.a(c.this.bqH.PU(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            c.this.Px();
        }

        @Override // com.baidu.live.videochat.c.c
        public void PE() {
            c.this.Px();
        }

        @Override // com.baidu.live.videochat.c.c
        public void D(int i, String str) {
            if (c.this.bqI != null) {
                c.this.bqI.s(i, str);
            }
        }
    };
    private BdUniqueId beV = BdUniqueId.gen();

    public c(Activity activity) {
        this.mActivity = activity;
        this.bqH = new com.baidu.live.videochat.c.d(activity, this.beV);
        this.bqH.a(this.bqO);
        this.bqH.a(this.bqN);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bqF != null && this.bqF.getPreview() != null) {
            if (this.bqF.getPreview().getParent() != null) {
                ((ViewGroup) this.bqF.getPreview().getParent()).removeView(this.bqF.getPreview());
            }
            this.bqF.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.d.a.a(this.bqF, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bqG = this.bqF.createPKPlayer();
        }
    }

    private void Pw() {
        this.bqG = null;
        if (this.bqF != null) {
            this.bqF.removeRecorderCallback(this.mRecorderCallback);
            if (this.bqF.getPreview().getParent() != null) {
                ((ViewGroup) this.bqF.getPreview().getParent()).removeView(this.bqF.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.MC().f(true, false);
            this.bqF.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bqJ != 3) {
            this.bqH.b(j, false);
            this.bqH.Qp();
            if (this.bqI != null && !z) {
                this.bqI.Pr();
            }
            this.bqJ = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bqI != null) {
                this.bqI.a(j, this.bqF.getPreview(), this.bqG);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px() {
        this.bqH.Qr();
        if (this.bqJ != 1) {
            Pw();
            this.bqJ = 1;
            if (this.bqI != null) {
                this.bqI.az(this.bqH.PU());
            }
        }
    }
}
