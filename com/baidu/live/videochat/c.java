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
public class c {
    private AlaLiveRecorder btW;
    private View btX;
    private com.baidu.live.videochat.c.d btY;
    private a btZ;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bua = 1;
    private boolean bub = false;
    private long mChatId = 0;
    private boolean buc = false;
    private Runnable bud = null;
    private com.baidu.live.videochat.c.a bue = new com.baidu.live.videochat.c.a() { // from class: com.baidu.live.videochat.c.1
        @Override // com.baidu.live.videochat.c.a
        public int Cj() {
            if (c.this.btW != null) {
                return c.this.btW.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.c.a
        public int Qg() {
            return c.this.bub ? 1 : 2;
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
            c.this.bub = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.c.e bug = new com.baidu.live.videochat.c.e() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.c.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            c.this.buc = false;
            if (aVar != null) {
                c.this.a(aVar.chatId, aVar.aDc, aVar.aDd, false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void y(int i, String str) {
            c.this.buc = false;
            if (c.this.btZ != null) {
                c.this.btZ.r(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Qh() {
            c.this.buc = false;
            if (c.this.btY != null) {
                c.this.btY.QX();
            }
            if (c.this.btZ != null) {
                c.this.btZ.Qa();
            }
            c.this.bua = 1;
        }

        @Override // com.baidu.live.videochat.c.e
        public void z(int i, String str) {
            c.this.buc = false;
            if (c.this.btZ != null) {
                c.this.btZ.s(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Qi() {
            if (c.this.btZ != null) {
                c.this.btZ.cH(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void A(int i, String str) {
            if (c.this.btZ != null) {
                c.this.btZ.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Qj() {
            if (c.this.btZ != null) {
                c.this.btZ.cH(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void B(int i, String str) {
            if (c.this.btZ != null) {
                c.this.btZ.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Qk() {
            if (c.this.btZ != null) {
                c.this.btZ.cI(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void C(int i, String str) {
            if (c.this.btZ != null) {
                c.this.btZ.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Ql() {
            if (c.this.btZ != null) {
                c.this.btZ.cI(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void D(int i, String str) {
            if (c.this.btZ != null) {
                c.this.btZ.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (c.this.bua == 2 && c.this.btZ != null) {
                    c.this.btZ.a(null);
                }
                c.this.bua = 1;
                c.this.btY.QX();
                return;
            }
            if (!c.this.buc && c.this.btZ != null) {
                c.this.btZ.a(cVar.aJI);
            }
            c.this.bua = 2;
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (c.this.bua != 4 && bVar != null && bVar.QD() == 2) {
                c.this.bua = 4;
                if (c.this.btZ != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aJI;
                    }
                    c.this.btZ.a(c.this.btY.QC(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            c.this.Qf();
        }

        @Override // com.baidu.live.videochat.c.c
        public void Qm() {
            c.this.Qf();
        }

        @Override // com.baidu.live.videochat.c.c
        public void E(int i, String str) {
            if (c.this.btZ != null) {
                c.this.btZ.t(i, str);
            }
        }
    };
    private BdUniqueId bhK = BdUniqueId.gen();

    public c(Activity activity) {
        this.mActivity = activity;
        this.btY = new com.baidu.live.videochat.c.d(activity, this.bhK);
        this.btY.a(this.bug);
        this.btY.a(this.bue);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.btW != null && this.btW.getPreview() != null) {
            if (this.btW.getPreview().getParent() != null) {
                ((ViewGroup) this.btW.getPreview().getParent()).removeView(this.btW.getPreview());
            }
            this.btW.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.d.a.a(this.btW, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.btX = this.btW.createPKPlayer();
        }
    }

    private void Qe() {
        this.btX = null;
        if (this.btW != null) {
            this.btW.removeRecorderCallback(this.mRecorderCallback);
            if (this.btW.getPreview().getParent() != null) {
                ((ViewGroup) this.btW.getPreview().getParent()).removeView(this.btW.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Nk().f(true, false);
            this.btW.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bua != 3) {
            this.btY.c(j, false);
            this.btY.QX();
            if (this.btZ != null && !z) {
                this.btZ.PZ();
            }
            this.bua = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.btZ != null) {
                this.btZ.a(j, this.btW.getPreview(), this.btX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qf() {
        this.btY.QZ();
        if (this.bua != 1) {
            Qe();
            this.bua = 1;
            if (this.btZ != null) {
                this.btZ.az(this.btY.QC());
            }
        }
    }
}
