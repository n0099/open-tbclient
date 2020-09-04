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
    private AlaLiveRecorder bqI;
    private View bqJ;
    private com.baidu.live.videochat.c.d bqK;
    private a bqL;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bqM = 1;
    private boolean bqN = false;
    private long mChatId = 0;
    private boolean bqO = false;
    private Runnable bqP = null;
    private com.baidu.live.videochat.c.a bqQ = new com.baidu.live.videochat.c.a() { // from class: com.baidu.live.videochat.c.1
        @Override // com.baidu.live.videochat.c.a
        public int BU() {
            if (c.this.bqI != null) {
                return c.this.bqI.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.c.a
        public int Py() {
            return c.this.bqN ? 1 : 2;
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
            c.this.bqN = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.c.e bqR = new com.baidu.live.videochat.c.e() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.c.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            c.this.bqO = false;
            if (aVar != null) {
                c.this.a(aVar.chatId, aVar.aCt, aVar.aCu, false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void x(int i, String str) {
            c.this.bqO = false;
            if (c.this.bqL != null) {
                c.this.bqL.q(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Pz() {
            c.this.bqO = false;
            if (c.this.bqK != null) {
                c.this.bqK.Qp();
            }
            if (c.this.bqL != null) {
                c.this.bqL.Ps();
            }
            c.this.bqM = 1;
        }

        @Override // com.baidu.live.videochat.c.e
        public void y(int i, String str) {
            c.this.bqO = false;
            if (c.this.bqL != null) {
                c.this.bqL.r(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void PA() {
            if (c.this.bqL != null) {
                c.this.bqL.cG(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void z(int i, String str) {
            if (c.this.bqL != null) {
                c.this.bqL.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void PB() {
            if (c.this.bqL != null) {
                c.this.bqL.cG(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void A(int i, String str) {
            if (c.this.bqL != null) {
                c.this.bqL.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void PC() {
            if (c.this.bqL != null) {
                c.this.bqL.cH(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void B(int i, String str) {
            if (c.this.bqL != null) {
                c.this.bqL.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void PD() {
            if (c.this.bqL != null) {
                c.this.bqL.cH(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void C(int i, String str) {
            if (c.this.bqL != null) {
                c.this.bqL.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (c.this.bqM == 2 && c.this.bqL != null) {
                    c.this.bqL.a(null);
                }
                c.this.bqM = 1;
                c.this.bqK.Qp();
                return;
            }
            if (!c.this.bqO && c.this.bqL != null) {
                c.this.bqL.a(cVar.aIn);
            }
            c.this.bqM = 2;
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (c.this.bqM != 4 && bVar != null && bVar.PV() == 2) {
                c.this.bqM = 4;
                if (c.this.bqL != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aIn;
                    }
                    c.this.bqL.a(c.this.bqK.PU(), alaLiveUserInfoData);
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
            if (c.this.bqL != null) {
                c.this.bqL.s(i, str);
            }
        }
    };
    private BdUniqueId beX = BdUniqueId.gen();

    public c(Activity activity) {
        this.mActivity = activity;
        this.bqK = new com.baidu.live.videochat.c.d(activity, this.beX);
        this.bqK.a(this.bqR);
        this.bqK.a(this.bqQ);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bqI != null && this.bqI.getPreview() != null) {
            if (this.bqI.getPreview().getParent() != null) {
                ((ViewGroup) this.bqI.getPreview().getParent()).removeView(this.bqI.getPreview());
            }
            this.bqI.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.d.a.a(this.bqI, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bqJ = this.bqI.createPKPlayer();
        }
    }

    private void Pw() {
        this.bqJ = null;
        if (this.bqI != null) {
            this.bqI.removeRecorderCallback(this.mRecorderCallback);
            if (this.bqI.getPreview().getParent() != null) {
                ((ViewGroup) this.bqI.getPreview().getParent()).removeView(this.bqI.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.MC().f(true, false);
            this.bqI.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bqM != 3) {
            this.bqK.b(j, false);
            this.bqK.Qp();
            if (this.bqL != null && !z) {
                this.bqL.Pr();
            }
            this.bqM = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bqL != null) {
                this.bqL.a(j, this.bqI.getPreview(), this.bqJ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Px() {
        this.bqK.Qr();
        if (this.bqM != 1) {
            Pw();
            this.bqM = 1;
            if (this.bqL != null) {
                this.bqL.az(this.bqK.PU());
            }
        }
    }
}
