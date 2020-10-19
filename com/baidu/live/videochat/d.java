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
    private AlaLiveRecorder bya;
    private View byb;
    private com.baidu.live.videochat.e.d byc;
    private a byd;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bye = 1;
    private boolean byf = false;
    private long mChatId = 0;
    private boolean byg = false;
    private Runnable byh = null;
    private com.baidu.live.videochat.e.a byi = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.d.1
        @Override // com.baidu.live.videochat.e.a
        public int Dg() {
            if (d.this.bya != null) {
                return d.this.bya.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int RD() {
            return d.this.byf ? 1 : 2;
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
            d.this.byf = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.e.e byj = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            d.this.byg = false;
            if (aVar != null) {
                d.this.a(aVar.chatId, aVar.aGh, aVar.aGi, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void A(int i, String str) {
            d.this.byg = false;
            if (d.this.byd != null) {
                d.this.byd.t(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void RE() {
            d.this.byg = false;
            if (d.this.byc != null) {
                d.this.byc.SF();
            }
            if (d.this.byd != null) {
                d.this.byd.Rl();
            }
            d.this.bye = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void B(int i, String str) {
            d.this.byg = false;
            if (d.this.byd != null) {
                d.this.byd.u(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void RF() {
            if (d.this.byd != null) {
                d.this.byd.cK(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void C(int i, String str) {
            if (d.this.byd != null) {
                d.this.byd.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void RG() {
            if (d.this.byd != null) {
                d.this.byd.cK(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void D(int i, String str) {
            if (d.this.byd != null) {
                d.this.byd.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void RH() {
            if (d.this.byd != null) {
                d.this.byd.cL(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void E(int i, String str) {
            if (d.this.byd != null) {
                d.this.byd.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void RI() {
            if (d.this.byd != null) {
                d.this.byd.cL(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void F(int i, String str) {
            if (d.this.byd != null) {
                d.this.byd.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (d.this.bye == 2 && d.this.byd != null) {
                    d.this.byd.a(null);
                }
                d.this.bye = 1;
                d.this.byc.SF();
                return;
            }
            if (!d.this.byg && d.this.byd != null) {
                d.this.byd.a(cVar.aMN);
            }
            d.this.bye = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (d.this.bye != 4 && bVar != null && bVar.Sa() == 2) {
                d.this.bye = 4;
                if (d.this.byd != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aMN;
                    }
                    d.this.byd.a(d.this.byc.RZ(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.RC();
        }

        @Override // com.baidu.live.videochat.e.c
        public void RJ() {
            d.this.RC();
        }

        @Override // com.baidu.live.videochat.e.c
        public void G(int i, String str) {
            if (d.this.byd != null) {
                d.this.byd.v(i, str);
            }
        }
    };
    private BdUniqueId blA = BdUniqueId.gen();

    public d(Activity activity) {
        this.mActivity = activity;
        this.byc = new com.baidu.live.videochat.e.d(activity, this.blA);
        this.byc.a(this.byj);
        this.byc.a(this.byi);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bya != null && this.bya.getPreview() != null) {
            if (this.bya.getPreview().getParent() != null) {
                ((ViewGroup) this.bya.getPreview().getParent()).removeView(this.bya.getPreview());
            }
            this.bya.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.bya, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.byb = this.bya.createPKPlayer();
        }
    }

    private void RB() {
        this.byb = null;
        if (this.bya != null) {
            this.bya.removeRecorderCallback(this.mRecorderCallback);
            if (this.bya.getPreview().getParent() != null) {
                ((ViewGroup) this.bya.getPreview().getParent()).removeView(this.bya.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Op().f(true, false);
            this.bya.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bye != 3) {
            this.byc.c(j, false);
            this.byc.SF();
            if (this.byd != null && !z) {
                this.byd.Rk();
            }
            this.bye = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.byd != null) {
                this.byd.a(j, this.bya.getPreview(), this.byb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RC() {
        this.byc.SH();
        if (this.bye != 1) {
            RB();
            this.bye = 1;
            if (this.byd != null) {
                this.byd.aA(this.byc.RZ());
            }
        }
    }
}
