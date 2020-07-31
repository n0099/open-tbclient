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
    private AlaLiveRecorder bkZ;
    private View bla;
    private com.baidu.live.videochat.c.d blb;
    private a blc;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bld = 1;
    private boolean ble = false;
    private long mChatId = 0;
    private boolean blf = false;
    private Runnable blg = null;
    private com.baidu.live.videochat.c.a blh = new com.baidu.live.videochat.c.a() { // from class: com.baidu.live.videochat.c.1
        @Override // com.baidu.live.videochat.c.a
        public int ww() {
            if (c.this.bkZ != null) {
                return c.this.bkZ.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.c.a
        public int JG() {
            return c.this.ble ? 1 : 2;
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
            c.this.ble = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.c.e bli = new com.baidu.live.videochat.c.e() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.c.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            c.this.blf = false;
            if (aVar != null) {
                c.this.a(aVar.chatId, aVar.axp, aVar.axq, false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void y(int i, String str) {
            c.this.blf = false;
            if (c.this.blc != null) {
                c.this.blc.r(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JH() {
            c.this.blf = false;
            if (c.this.blb != null) {
                c.this.blb.Kx();
            }
            if (c.this.blc != null) {
                c.this.blc.JA();
            }
            c.this.bld = 1;
        }

        @Override // com.baidu.live.videochat.c.e
        public void z(int i, String str) {
            c.this.blf = false;
            if (c.this.blc != null) {
                c.this.blc.s(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JI() {
            if (c.this.blc != null) {
                c.this.blc.cx(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void A(int i, String str) {
            if (c.this.blc != null) {
                c.this.blc.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JJ() {
            if (c.this.blc != null) {
                c.this.blc.cx(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void B(int i, String str) {
            if (c.this.blc != null) {
                c.this.blc.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JK() {
            if (c.this.blc != null) {
                c.this.blc.cy(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void C(int i, String str) {
            if (c.this.blc != null) {
                c.this.blc.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void JL() {
            if (c.this.blc != null) {
                c.this.blc.cy(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void D(int i, String str) {
            if (c.this.blc != null) {
                c.this.blc.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (c.this.bld == 2 && c.this.blc != null) {
                    c.this.blc.a(null);
                }
                c.this.bld = 1;
                c.this.blb.Kx();
                return;
            }
            if (!c.this.blf && c.this.blc != null) {
                c.this.blc.a(cVar.aDb);
            }
            c.this.bld = 2;
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (c.this.bld != 4 && bVar != null && bVar.Kd() == 2) {
                c.this.bld = 4;
                if (c.this.blc != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aDb;
                    }
                    c.this.blc.a(c.this.blb.Kc(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            c.this.JF();
        }

        @Override // com.baidu.live.videochat.c.c
        public void JM() {
            c.this.JF();
        }

        @Override // com.baidu.live.videochat.c.c
        public void E(int i, String str) {
            if (c.this.blc != null) {
                c.this.blc.t(i, str);
            }
        }
    };
    private BdUniqueId aZB = BdUniqueId.gen();

    public c(Activity activity) {
        this.mActivity = activity;
        this.blb = new com.baidu.live.videochat.c.d(activity, this.aZB);
        this.blb.a(this.bli);
        this.blb.a(this.blh);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bkZ != null && this.bkZ.getPreview() != null) {
            if (this.bkZ.getPreview().getParent() != null) {
                ((ViewGroup) this.bkZ.getPreview().getParent()).removeView(this.bkZ.getPreview());
            }
            this.bkZ.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.d.a.a(this.bkZ, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bla = this.bkZ.createPKPlayer();
        }
    }

    private void JE() {
        this.bla = null;
        if (this.bkZ != null) {
            this.bkZ.removeRecorderCallback(this.mRecorderCallback);
            if (this.bkZ.getPreview().getParent() != null) {
                ((ViewGroup) this.bkZ.getPreview().getParent()).removeView(this.bkZ.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.GN().f(true, false);
            this.bkZ.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bld != 3) {
            this.blb.d(j, false);
            this.blb.Kx();
            if (this.blc != null && !z) {
                this.blc.Jz();
            }
            this.bld = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.blc != null) {
                this.blc.a(j, this.bkZ.getPreview(), this.bla);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JF() {
        this.blb.Kz();
        if (this.bld != 1) {
            JE();
            this.bld = 1;
            if (this.blc != null) {
                this.blc.ay(this.blb.Kc());
            }
        }
    }
}
