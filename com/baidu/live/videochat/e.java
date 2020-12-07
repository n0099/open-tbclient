package com.baidu.live.videochat;

import android.app.Activity;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.ViewGroup;
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
    private View bKD;
    private com.baidu.live.videochat.e.d bKE;
    private a bKF;
    private AlaLiveRecorder bya;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int mChatStatus = 1;
    private boolean bKG = false;
    private long mChatId = 0;
    private boolean bKH = false;
    private Runnable bKI = null;
    private com.baidu.live.videochat.e.a bKJ = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.e.1
        @Override // com.baidu.live.videochat.e.a
        public int EH() {
            if (e.this.bya != null) {
                return e.this.bya.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int Xd() {
            return e.this.bKG ? 1 : 2;
        }
    };
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.e.2
    };
    private com.baidu.live.videochat.e.e bKK = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            e.this.bKH = false;
            if (aVar != null) {
                e.this.a(aVar.chatId, aVar.aIc, aVar.aId, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void G(int i, String str) {
            e.this.bKH = false;
            if (e.this.bKF != null) {
                e.this.bKF.z(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Xe() {
            e.this.bKH = false;
            if (e.this.bKE != null) {
                e.this.bKE.XW();
            }
            if (e.this.bKF != null) {
                e.this.bKF.WN();
            }
            e.this.mChatStatus = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void H(int i, String str) {
            e.this.bKH = false;
            if (e.this.bKF != null) {
                e.this.bKF.A(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Xf() {
            if (e.this.bKF != null) {
                e.this.bKF.dn(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void I(int i, String str) {
            if (e.this.bKF != null) {
                e.this.bKF.a(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Xg() {
            if (e.this.bKF != null) {
                e.this.bKF.dn(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void J(int i, String str) {
            if (e.this.bKF != null) {
                e.this.bKF.a(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Xh() {
            if (e.this.bKF != null) {
                e.this.bKF.m22do(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void K(int i, String str) {
            if (e.this.bKF != null) {
                e.this.bKF.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Xi() {
            if (e.this.bKF != null) {
                e.this.bKF.m22do(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void L(int i, String str) {
            if (e.this.bKF != null) {
                e.this.bKF.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (e.this.mChatStatus == 2 && e.this.bKF != null) {
                    e.this.bKF.a(null);
                }
                e.this.mChatStatus = 1;
                e.this.bKE.XW();
                return;
            }
            if (!e.this.bKH && e.this.bKF != null) {
                e.this.bKF.a(cVar.aPJ);
            }
            e.this.mChatStatus = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (e.this.mChatStatus != 4 && bVar != null && bVar.Uc() == 2) {
                e.this.mChatStatus = 4;
                if (e.this.bKF != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aPJ;
                    }
                    e.this.bKF.a(e.this.bKE.Xv(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.Xc();
        }

        @Override // com.baidu.live.videochat.e.c
        public void Xj() {
            e.this.Xc();
        }

        @Override // com.baidu.live.videochat.e.c
        public void M(int i, String str) {
            if (e.this.bKF != null) {
                e.this.bKF.B(i, str);
            }
        }
    };
    private BdUniqueId brR = BdUniqueId.gen();

    public e(Activity activity) {
        this.mActivity = activity;
        this.bKE = new com.baidu.live.videochat.e.d(activity, this.brR);
        this.bKE.a(this.bKK);
        this.bKE.a(this.bKJ);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bya != null && this.bya.getPreview() != null) {
            if (this.bya.getPreview().getParent() != null) {
                ((ViewGroup) this.bya.getPreview().getParent()).removeView(this.bya.getPreview());
            }
            this.bya.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.bya, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bKD = this.bya.createPKPlayer();
        }
    }

    private void Xb() {
        this.bKD = null;
        if (this.bya != null) {
            this.bya.removeRecorderCallback(this.mRecorderCallback);
            if (this.bya.getPreview().getParent() != null) {
                ((ViewGroup) this.bya.getPreview().getParent()).removeView(this.bya.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.QY().f(true, false);
            this.bya.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.mChatStatus != 3) {
            this.bKE.c(j, false);
            this.bKE.XW();
            if (this.bKF != null && !z) {
                this.bKF.WM();
            }
            this.mChatStatus = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bKF != null) {
                this.bKF.a(j, this.bya.getPreview(), this.bKD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xc() {
        this.bKE.XY();
        if (this.mChatStatus != 1) {
            Xb();
            this.mChatStatus = 1;
            if (this.bKF != null) {
                this.bKF.bw(this.bKE.Xv());
            }
        }
    }
}
