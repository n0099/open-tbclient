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
    private View bHf;
    private com.baidu.live.videochat.e.d bHg;
    private a bHh;
    private AlaLiveRecorder buC;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int byk = 1;
    private boolean bHi = false;
    private long mChatId = 0;
    private boolean bHj = false;
    private Runnable bHk = null;
    private com.baidu.live.videochat.e.a bHl = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.e.1
        @Override // com.baidu.live.videochat.e.a
        public int DG() {
            if (e.this.buC != null) {
                return e.this.buC.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int Vk() {
            return e.this.bHi ? 1 : 2;
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
            e.this.bHi = i == 0;
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onPKPlayerFirstFrame() {
        }

        @Override // com.baidu.ala.recorder.RecorderCallback
        public void onFaceUnityEvent(int i, int i2, Object obj) {
        }
    };
    private com.baidu.live.videochat.e.e bHm = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            e.this.bHj = false;
            if (aVar != null) {
                e.this.a(aVar.chatId, aVar.aHf, aVar.aHg, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void G(int i, String str) {
            e.this.bHj = false;
            if (e.this.bHh != null) {
                e.this.bHh.z(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Vl() {
            e.this.bHj = false;
            if (e.this.bHg != null) {
                e.this.bHg.Wf();
            }
            if (e.this.bHh != null) {
                e.this.bHh.UU();
            }
            e.this.byk = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void H(int i, String str) {
            e.this.bHj = false;
            if (e.this.bHh != null) {
                e.this.bHh.A(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Vm() {
            if (e.this.bHh != null) {
                e.this.bHh.cX(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void I(int i, String str) {
            if (e.this.bHh != null) {
                e.this.bHh.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Vn() {
            if (e.this.bHh != null) {
                e.this.bHh.cX(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void J(int i, String str) {
            if (e.this.bHh != null) {
                e.this.bHh.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Vo() {
            if (e.this.bHh != null) {
                e.this.bHh.cY(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void K(int i, String str) {
            if (e.this.bHh != null) {
                e.this.bHh.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Vp() {
            if (e.this.bHh != null) {
                e.this.bHh.cY(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void L(int i, String str) {
            if (e.this.bHh != null) {
                e.this.bHh.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (e.this.byk == 2 && e.this.bHh != null) {
                    e.this.bHh.a(null);
                }
                e.this.byk = 1;
                e.this.bHg.Wf();
                return;
            }
            if (!e.this.bHj && e.this.bHh != null) {
                e.this.bHh.a(cVar.aOv);
            }
            e.this.byk = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (e.this.byk != 4 && bVar != null && bVar.Sn() == 2) {
                e.this.byk = 4;
                if (e.this.bHh != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aOv;
                    }
                    e.this.bHh.a(e.this.bHg.VE(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.Vj();
        }

        @Override // com.baidu.live.videochat.e.c
        public void Vq() {
            e.this.Vj();
        }

        @Override // com.baidu.live.videochat.e.c
        public void M(int i, String str) {
            if (e.this.bHh != null) {
                e.this.bHh.B(i, str);
            }
        }
    };
    private BdUniqueId bou = BdUniqueId.gen();

    public e(Activity activity) {
        this.mActivity = activity;
        this.bHg = new com.baidu.live.videochat.e.d(activity, this.bou);
        this.bHg.a(this.bHm);
        this.bHg.a(this.bHl);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.buC != null && this.buC.getPreview() != null) {
            if (this.buC.getPreview().getParent() != null) {
                ((ViewGroup) this.buC.getPreview().getParent()).removeView(this.buC.getPreview());
            }
            this.buC.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.buC, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bHf = this.buC.createPKPlayer();
        }
    }

    private void Vi() {
        this.bHf = null;
        if (this.buC != null) {
            this.buC.removeRecorderCallback(this.mRecorderCallback);
            if (this.buC.getPreview().getParent() != null) {
                ((ViewGroup) this.buC.getPreview().getParent()).removeView(this.buC.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Pn().f(true, false);
            this.buC.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.byk != 3) {
            this.bHg.c(j, false);
            this.bHg.Wf();
            if (this.bHh != null && !z) {
                this.bHh.UT();
            }
            this.byk = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bHh != null) {
                this.bHh.a(j, this.buC.getPreview(), this.bHf);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vj() {
        this.bHg.Wh();
        if (this.byk != 1) {
            Vi();
            this.byk = 1;
            if (this.bHh != null) {
                this.bHh.aY(this.bHg.VE());
            }
        }
    }
}
