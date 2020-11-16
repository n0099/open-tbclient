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
public class e {
    private View bFu;
    private com.baidu.live.videochat.e.d bFv;
    private a bFw;
    private AlaLiveRecorder bsP;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bwz = 1;
    private boolean bFx = false;
    private long mChatId = 0;
    private boolean bFy = false;
    private Runnable bFz = null;
    private com.baidu.live.videochat.e.a bFA = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.e.1
        @Override // com.baidu.live.videochat.e.a
        public int CX() {
            if (e.this.bsP != null) {
                return e.this.bsP.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int UB() {
            return e.this.bFx ? 1 : 2;
        }
    };
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.e.2
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
            e.this.bFx = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.e.e bFB = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            e.this.bFy = false;
            if (aVar != null) {
                e.this.a(aVar.chatId, aVar.aFu, aVar.aFv, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void G(int i, String str) {
            e.this.bFy = false;
            if (e.this.bFw != null) {
                e.this.bFw.z(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void UC() {
            e.this.bFy = false;
            if (e.this.bFv != null) {
                e.this.bFv.Vw();
            }
            if (e.this.bFw != null) {
                e.this.bFw.Ul();
            }
            e.this.bwz = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void H(int i, String str) {
            e.this.bFy = false;
            if (e.this.bFw != null) {
                e.this.bFw.A(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void UD() {
            if (e.this.bFw != null) {
                e.this.bFw.cZ(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void I(int i, String str) {
            if (e.this.bFw != null) {
                e.this.bFw.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void UE() {
            if (e.this.bFw != null) {
                e.this.bFw.cZ(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void J(int i, String str) {
            if (e.this.bFw != null) {
                e.this.bFw.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void UF() {
            if (e.this.bFw != null) {
                e.this.bFw.da(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void K(int i, String str) {
            if (e.this.bFw != null) {
                e.this.bFw.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void UG() {
            if (e.this.bFw != null) {
                e.this.bFw.da(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void L(int i, String str) {
            if (e.this.bFw != null) {
                e.this.bFw.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (e.this.bwz == 2 && e.this.bFw != null) {
                    e.this.bFw.a(null);
                }
                e.this.bwz = 1;
                e.this.bFv.Vw();
                return;
            }
            if (!e.this.bFy && e.this.bFw != null) {
                e.this.bFw.a(cVar.aMK);
            }
            e.this.bwz = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (e.this.bwz != 4 && bVar != null && bVar.RE() == 2) {
                e.this.bwz = 4;
                if (e.this.bFw != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aMK;
                    }
                    e.this.bFw.a(e.this.bFv.UV(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.UA();
        }

        @Override // com.baidu.live.videochat.e.c
        public void UH() {
            e.this.UA();
        }

        @Override // com.baidu.live.videochat.e.c
        public void M(int i, String str) {
            if (e.this.bFw != null) {
                e.this.bFw.B(i, str);
            }
        }
    };
    private BdUniqueId bmJ = BdUniqueId.gen();

    public e(Activity activity) {
        this.mActivity = activity;
        this.bFv = new com.baidu.live.videochat.e.d(activity, this.bmJ);
        this.bFv.a(this.bFB);
        this.bFv.a(this.bFA);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bsP != null && this.bsP.getPreview() != null) {
            if (this.bsP.getPreview().getParent() != null) {
                ((ViewGroup) this.bsP.getPreview().getParent()).removeView(this.bsP.getPreview());
            }
            this.bsP.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.bsP, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bFu = this.bsP.createPKPlayer();
        }
    }

    private void Uz() {
        this.bFu = null;
        if (this.bsP != null) {
            this.bsP.removeRecorderCallback(this.mRecorderCallback);
            if (this.bsP.getPreview().getParent() != null) {
                ((ViewGroup) this.bsP.getPreview().getParent()).removeView(this.bsP.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.OE().f(true, false);
            this.bsP.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bwz != 3) {
            this.bFv.c(j, false);
            this.bFv.Vw();
            if (this.bFw != null && !z) {
                this.bFw.Uk();
            }
            this.bwz = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bFw != null) {
                this.bFw.a(j, this.bsP.getPreview(), this.bFu);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UA() {
        this.bFv.Vy();
        if (this.bwz != 1) {
            Uz();
            this.bwz = 1;
            if (this.bFw != null) {
                this.bFw.aY(this.bFv.UV());
            }
        }
    }
}
