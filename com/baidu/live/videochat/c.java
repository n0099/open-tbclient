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
    private a bfA;
    private AlaLiveRecorder bfx;
    private View bfy;
    private com.baidu.live.videochat.c.d bfz;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int bfB = 1;
    private boolean bfC = false;
    private long mChatId = 0;
    private boolean bfD = false;
    private Runnable bfE = null;
    private com.baidu.live.videochat.c.a bfF = new com.baidu.live.videochat.c.a() { // from class: com.baidu.live.videochat.c.1
        @Override // com.baidu.live.videochat.c.a
        public int vG() {
            if (c.this.bfx != null) {
                return c.this.bfx.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.c.a
        public int Im() {
            return c.this.bfC ? 1 : 2;
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
            c.this.bfC = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.c.e bfG = new com.baidu.live.videochat.c.e() { // from class: com.baidu.live.videochat.c.3
        @Override // com.baidu.live.videochat.c.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            c.this.bfD = false;
            if (aVar != null) {
                c.this.a(aVar.chatId, aVar.aui, aVar.auj, false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void w(int i, String str) {
            c.this.bfD = false;
            if (c.this.bfA != null) {
                c.this.bfA.p(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void In() {
            c.this.bfD = false;
            if (c.this.bfz != null) {
                c.this.bfz.Jd();
            }
            if (c.this.bfA != null) {
                c.this.bfA.Ig();
            }
            c.this.bfB = 1;
        }

        @Override // com.baidu.live.videochat.c.e
        public void x(int i, String str) {
            c.this.bfD = false;
            if (c.this.bfA != null) {
                c.this.bfA.q(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Io() {
            if (c.this.bfA != null) {
                c.this.bfA.cp(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void y(int i, String str) {
            if (c.this.bfA != null) {
                c.this.bfA.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Ip() {
            if (c.this.bfA != null) {
                c.this.bfA.cp(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void z(int i, String str) {
            if (c.this.bfA != null) {
                c.this.bfA.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Iq() {
            if (c.this.bfA != null) {
                c.this.bfA.cq(false);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void A(int i, String str) {
            if (c.this.bfA != null) {
                c.this.bfA.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void Ir() {
            if (c.this.bfA != null) {
                c.this.bfA.cq(true);
            }
        }

        @Override // com.baidu.live.videochat.c.e
        public void B(int i, String str) {
            if (c.this.bfA != null) {
                c.this.bfA.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (c.this.bfB == 2 && c.this.bfA != null) {
                    c.this.bfA.a(null);
                }
                c.this.bfB = 1;
                c.this.bfz.Jd();
                return;
            }
            if (!c.this.bfD && c.this.bfA != null) {
                c.this.bfA.a(cVar.azo);
            }
            c.this.bfB = 2;
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (c.this.bfB != 4 && bVar != null && bVar.IJ() == 2) {
                c.this.bfB = 4;
                if (c.this.bfA != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.azo;
                    }
                    c.this.bfA.a(c.this.bfz.II(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            c.this.Il();
        }

        @Override // com.baidu.live.videochat.c.c
        public void Is() {
            c.this.Il();
        }

        @Override // com.baidu.live.videochat.c.c
        public void C(int i, String str) {
            if (c.this.bfA != null) {
                c.this.bfA.r(i, str);
            }
        }
    };
    private BdUniqueId aWV = BdUniqueId.gen();

    public c(Activity activity) {
        this.mActivity = activity;
        this.bfz = new com.baidu.live.videochat.c.d(activity, this.aWV);
        this.bfz.a(this.bfG);
        this.bfz.a(this.bfF);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bfx != null && this.bfx.getPreview() != null) {
            if (this.bfx.getPreview().getParent() != null) {
                ((ViewGroup) this.bfx.getPreview().getParent()).removeView(this.bfx.getPreview());
            }
            this.bfx.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.d.a.a(this.bfx, com.baidu.live.videochat.d.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bfy = this.bfx.createPKPlayer();
        }
    }

    private void Ik() {
        this.bfy = null;
        if (this.bfx != null) {
            this.bfx.removeRecorderCallback(this.mRecorderCallback);
            if (this.bfx.getPreview().getParent() != null) {
                ((ViewGroup) this.bfx.getPreview().getParent()).removeView(this.bfx.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.FX().f(true, false);
            this.bfx.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.bfB != 3) {
            this.bfz.d(j, false);
            this.bfz.Jd();
            if (this.bfA != null && !z) {
                this.bfA.If();
            }
            this.bfB = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bfA != null) {
                this.bfA.a(j, this.bfx.getPreview(), this.bfy);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Il() {
        this.bfz.Jf();
        if (this.bfB != 1) {
            Ik();
            this.bfB = 1;
            if (this.bfA != null) {
                this.bfA.ay(this.bfz.II());
            }
        }
    }
}
