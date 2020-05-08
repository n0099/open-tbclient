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
    private AlaLiveRecorder aYb;
    private View aYc;
    private com.baidu.live.videochat.c.d aYd;
    private a aYe;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int aYf = 1;
    private boolean aYg = false;
    private long mChatId = 0;
    private boolean aYh = false;
    private Runnable aYi = null;
    private com.baidu.live.videochat.c.a aYj = new com.baidu.live.videochat.c.a() { // from class: com.baidu.live.videochat.c.1
        @Override // com.baidu.live.videochat.c.a
        public int uz() {
            if (c.this.aYb != null) {
                return c.this.aYb.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.c.a
        public int Gt() {
            return c.this.aYg ? 1 : 2;
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
            c.this.aYg = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.c.e aYk = new com.baidu.live.videochat.c.e() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.c.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            c.this.aYh = false;
            if (aVar != null) {
                c.this.a(aVar.chatId, aVar.apo, aVar.apq, false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void w(int i, String str) {
            c.this.aYh = false;
            if (c.this.aYe != null) {
                c.this.aYe.p(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gu() {
            c.this.aYh = false;
            if (c.this.aYd != null) {
                c.this.aYd.Hk();
            }
            if (c.this.aYe != null) {
                c.this.aYe.Gn();
            }
            c.this.aYf = 1;
        }

        @Override // com.baidu.live.videochat.c.e
        public void x(int i, String str) {
            c.this.aYh = false;
            if (c.this.aYe != null) {
                c.this.aYe.q(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gv() {
            if (c.this.aYe != null) {
                c.this.aYe.cd(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void y(int i, String str) {
            if (c.this.aYe != null) {
                c.this.aYe.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gw() {
            if (c.this.aYe != null) {
                c.this.aYe.cd(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void z(int i, String str) {
            if (c.this.aYe != null) {
                c.this.aYe.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gx() {
            if (c.this.aYe != null) {
                c.this.aYe.ce(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void A(int i, String str) {
            if (c.this.aYe != null) {
                c.this.aYe.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Gy() {
            if (c.this.aYe != null) {
                c.this.aYe.ce(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void B(int i, String str) {
            if (c.this.aYe != null) {
                c.this.aYe.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (c.this.aYf == 2 && c.this.aYe != null) {
                    c.this.aYe.a(null);
                }
                c.this.aYf = 1;
                c.this.aYd.Hk();
                return;
            }
            if (!c.this.aYh && c.this.aYe != null) {
                c.this.aYe.a(cVar.auk);
            }
            c.this.aYf = 2;
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (c.this.aYf != 4 && bVar != null && bVar.GQ() == 2) {
                c.this.aYf = 4;
                if (c.this.aYe != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.auk;
                    }
                    c.this.aYe.a(c.this.aYd.GP(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            c.this.Gs();
        }

        @Override // com.baidu.live.videochat.c.c
        public void Gz() {
            c.this.Gs();
        }

        @Override // com.baidu.live.videochat.c.c
        public void C(int i, String str) {
            if (c.this.aYe != null) {
                c.this.aYe.r(i, str);
            }
        }
    };
    private BdUniqueId aQK = BdUniqueId.gen();

    public c(Activity activity) {
        this.mActivity = activity;
        this.aYd = new com.baidu.live.videochat.c.d(activity, this.aQK);
        this.aYd.a(this.aYk);
        this.aYd.a(this.aYj);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.aYb != null && this.aYb.getPreview() != null) {
            if (this.aYb.getPreview().getParent() != null) {
                ((ViewGroup) this.aYb.getPreview().getParent()).removeView(this.aYb.getPreview());
            }
            this.aYb.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.d.a.a(this.aYb, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.aYc = this.aYb.createPKPlayer();
        }
    }

    private void Gr() {
        this.aYc = null;
        if (this.aYb != null) {
            this.aYb.removeRecorderCallback(this.mRecorderCallback);
            if (this.aYb.getPreview().getParent() != null) {
                ((ViewGroup) this.aYb.getPreview().getParent()).removeView(this.aYb.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Eh().f(true, false);
            this.aYb.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.aYf != 3) {
            this.aYd.d(j, false);
            this.aYd.Hk();
            if (this.aYe != null && !z) {
                this.aYe.Gm();
            }
            this.aYf = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.aYe != null) {
                this.aYe.a(j, this.aYb.getPreview(), this.aYc);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Gs() {
        this.aYd.Hm();
        if (this.aYf != 1) {
            Gr();
            this.aYf = 1;
            if (this.aYe != null) {
                this.aYe.at(this.aYd.GP());
            }
        }
    }
}
