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
/* loaded from: classes4.dex */
public class d {
    private AlaLiveRecorder bAW;
    private View bAX;
    private com.baidu.live.videochat.e.d bAY;
    private a bAZ;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bBa = 1;
    private boolean bBb = false;
    private long mChatId = 0;
    private boolean bBc = false;
    private Runnable bBd = null;
    private com.baidu.live.videochat.e.a bBe = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.d.1
        @Override // com.baidu.live.videochat.e.a
        public int Dn() {
            if (d.this.bAW != null) {
                return d.this.bAW.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int SD() {
            return d.this.bBb ? 1 : 2;
        }
    };
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.d.2
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
            d.this.bBb = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.e.e bBf = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            d.this.bBc = false;
            if (aVar != null) {
                d.this.a(aVar.chatId, aVar.aGp, aVar.aGq, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void C(int i, String str) {
            d.this.bBc = false;
            if (d.this.bAZ != null) {
                d.this.bAZ.v(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void SE() {
            d.this.bBc = false;
            if (d.this.bAY != null) {
                d.this.bAY.TF();
            }
            if (d.this.bAZ != null) {
                d.this.bAZ.Sl();
            }
            d.this.bBa = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void D(int i, String str) {
            d.this.bBc = false;
            if (d.this.bAZ != null) {
                d.this.bAZ.w(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void SF() {
            if (d.this.bAZ != null) {
                d.this.bAZ.cQ(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void E(int i, String str) {
            if (d.this.bAZ != null) {
                d.this.bAZ.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void SG() {
            if (d.this.bAZ != null) {
                d.this.bAZ.cQ(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void F(int i, String str) {
            if (d.this.bAZ != null) {
                d.this.bAZ.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void SH() {
            if (d.this.bAZ != null) {
                d.this.bAZ.cR(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void G(int i, String str) {
            if (d.this.bAZ != null) {
                d.this.bAZ.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void SI() {
            if (d.this.bAZ != null) {
                d.this.bAZ.cR(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void H(int i, String str) {
            if (d.this.bAZ != null) {
                d.this.bAZ.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (d.this.bBa == 2 && d.this.bAZ != null) {
                    d.this.bAZ.a(null);
                }
                d.this.bBa = 1;
                d.this.bAY.TF();
                return;
            }
            if (!d.this.bBc && d.this.bAZ != null) {
                d.this.bAZ.a(cVar.aNs);
            }
            d.this.bBa = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (d.this.bBa != 4 && bVar != null && bVar.Ta() == 2) {
                d.this.bBa = 4;
                if (d.this.bAZ != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aNs;
                    }
                    d.this.bAZ.a(d.this.bAY.SZ(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.SC();
        }

        @Override // com.baidu.live.videochat.e.c
        public void SJ() {
            d.this.SC();
        }

        @Override // com.baidu.live.videochat.e.c
        public void I(int i, String str) {
            if (d.this.bAZ != null) {
                d.this.bAZ.x(i, str);
            }
        }
    };
    private BdUniqueId bnb = BdUniqueId.gen();

    public d(Activity activity) {
        this.mActivity = activity;
        this.bAY = new com.baidu.live.videochat.e.d(activity, this.bnb);
        this.bAY.a(this.bBf);
        this.bAY.a(this.bBe);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bAW != null && this.bAW.getPreview() != null) {
            if (this.bAW.getPreview().getParent() != null) {
                ((ViewGroup) this.bAW.getPreview().getParent()).removeView(this.bAW.getPreview());
            }
            this.bAW.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.bAW, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bAX = this.bAW.createPKPlayer();
        }
    }

    private void SB() {
        this.bAX = null;
        if (this.bAW != null) {
            this.bAW.removeRecorderCallback(this.mRecorderCallback);
            if (this.bAW.getPreview().getParent() != null) {
                ((ViewGroup) this.bAW.getPreview().getParent()).removeView(this.bAW.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.ON().f(true, false);
            this.bAW.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bBa != 3) {
            this.bAY.c(j, false);
            this.bAY.TF();
            if (this.bAZ != null && !z) {
                this.bAZ.Sk();
            }
            this.bBa = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bAZ != null) {
                this.bAZ.a(j, this.bAW.getPreview(), this.bAX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SC() {
        this.bAY.TH();
        if (this.bBa != 1) {
            SB();
            this.bBa = 1;
            if (this.bAZ != null) {
                this.bAZ.aC(this.bAY.SZ());
            }
        }
    }
}
