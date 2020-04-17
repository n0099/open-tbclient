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
    private AlaLiveRecorder aXW;
    private View aXX;
    private com.baidu.live.videochat.c.d aXY;
    private a aXZ;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int aYa = 1;
    private boolean aYb = false;
    private long mChatId = 0;
    private boolean aYc = false;
    private Runnable aYd = null;
    private com.baidu.live.videochat.c.a aYe = new com.baidu.live.videochat.c.a() { // from class: com.baidu.live.videochat.c.1
        @Override // com.baidu.live.videochat.c.a
        public int uA() {
            if (c.this.aXW != null) {
                return c.this.aXW.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.c.a
        public int Gu() {
            return c.this.aYb ? 1 : 2;
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
            c.this.aYb = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.c.e aYf = new com.baidu.live.videochat.c.e() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.c.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            c.this.aYc = false;
            if (aVar != null) {
                c.this.a(aVar.chatId, aVar.api, aVar.apj, false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void w(int i, String str) {
            c.this.aYc = false;
            if (c.this.aXZ != null) {
                c.this.aXZ.p(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gv() {
            c.this.aYc = false;
            if (c.this.aXY != null) {
                c.this.aXY.Hl();
            }
            if (c.this.aXZ != null) {
                c.this.aXZ.Go();
            }
            c.this.aYa = 1;
        }

        @Override // com.baidu.live.videochat.c.e
        public void x(int i, String str) {
            c.this.aYc = false;
            if (c.this.aXZ != null) {
                c.this.aXZ.q(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gw() {
            if (c.this.aXZ != null) {
                c.this.aXZ.cd(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void y(int i, String str) {
            if (c.this.aXZ != null) {
                c.this.aXZ.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gx() {
            if (c.this.aXZ != null) {
                c.this.aXZ.cd(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void z(int i, String str) {
            if (c.this.aXZ != null) {
                c.this.aXZ.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gy() {
            if (c.this.aXZ != null) {
                c.this.aXZ.ce(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void A(int i, String str) {
            if (c.this.aXZ != null) {
                c.this.aXZ.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gz() {
            if (c.this.aXZ != null) {
                c.this.aXZ.ce(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void B(int i, String str) {
            if (c.this.aXZ != null) {
                c.this.aXZ.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (c.this.aYa == 2 && c.this.aXZ != null) {
                    c.this.aXZ.a(null);
                }
                c.this.aYa = 1;
                c.this.aXY.Hl();
                return;
            }
            if (!c.this.aYc && c.this.aXZ != null) {
                c.this.aXZ.a(cVar.aue);
            }
            c.this.aYa = 2;
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (c.this.aYa != 4 && bVar != null && bVar.GR() == 2) {
                c.this.aYa = 4;
                if (c.this.aXZ != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aue;
                    }
                    c.this.aXZ.a(c.this.aXY.GQ(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            c.this.Gt();
        }

        @Override // com.baidu.live.videochat.c.c
        public void GA() {
            c.this.Gt();
        }

        @Override // com.baidu.live.videochat.c.c
        public void C(int i, String str) {
            if (c.this.aXZ != null) {
                c.this.aXZ.r(i, str);
            }
        }
    };
    private BdUniqueId aQF = BdUniqueId.gen();

    public c(Activity activity) {
        this.mActivity = activity;
        this.aXY = new com.baidu.live.videochat.c.d(activity, this.aQF);
        this.aXY.a(this.aYf);
        this.aXY.a(this.aYe);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.aXW != null && this.aXW.getPreview() != null) {
            if (this.aXW.getPreview().getParent() != null) {
                ((ViewGroup) this.aXW.getPreview().getParent()).removeView(this.aXW.getPreview());
            }
            this.aXW.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.d.a.a(this.aXW, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.aXX = this.aXW.createPKPlayer();
        }
    }

    private void Gs() {
        this.aXX = null;
        if (this.aXW != null) {
            this.aXW.removeRecorderCallback(this.mRecorderCallback);
            if (this.aXW.getPreview().getParent() != null) {
                ((ViewGroup) this.aXW.getPreview().getParent()).removeView(this.aXW.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Ei().f(true, false);
            this.aXW.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.aYa != 3) {
            this.aXY.d(j, false);
            this.aXY.Hl();
            if (this.aXZ != null && !z) {
                this.aXZ.Gn();
            }
            this.aYa = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.aXZ != null) {
                this.aXZ.a(j, this.aXW.getPreview(), this.aXX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gt() {
        this.aXY.Hn();
        if (this.aYa != 1) {
            Gs();
            this.aYa = 1;
            if (this.aXZ != null) {
                this.aXZ.at(this.aXY.GQ());
            }
        }
    }
}
