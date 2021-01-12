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
/* loaded from: classes10.dex */
public class e {
    private View bKE;
    private com.baidu.live.videochat.e.d bKF;
    private a bKG;
    private AlaLiveRecorder bya;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int mChatStatus = 1;
    private boolean bKH = false;
    private long mChatId = 0;
    private boolean bKI = false;
    private Runnable bKJ = null;
    private com.baidu.live.videochat.e.a bKK = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.e.1
        @Override // com.baidu.live.videochat.e.a
        public int Ab() {
            if (e.this.bya != null) {
                return e.this.bya.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int Ur() {
            return e.this.bKH ? 1 : 2;
        }
    };
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.e.2
    };
    private com.baidu.live.videochat.e.e bKL = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            e.this.bKI = false;
            if (aVar != null) {
                e.this.a(aVar.chatId, aVar.aDL, aVar.aDM, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void J(int i, String str) {
            e.this.bKI = false;
            if (e.this.bKG != null) {
                e.this.bKG.C(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Us() {
            e.this.bKI = false;
            if (e.this.bKF != null) {
                e.this.bKF.Vl();
            }
            if (e.this.bKG != null) {
                e.this.bKG.Ub();
            }
            e.this.mChatStatus = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void K(int i, String str) {
            e.this.bKI = false;
            if (e.this.bKG != null) {
                e.this.bKG.D(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Ut() {
            if (e.this.bKG != null) {
                e.this.bKG.dm(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void L(int i, String str) {
            if (e.this.bKG != null) {
                e.this.bKG.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Uu() {
            if (e.this.bKG != null) {
                e.this.bKG.dm(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void M(int i, String str) {
            if (e.this.bKG != null) {
                e.this.bKG.b(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Uv() {
            if (e.this.bKG != null) {
                e.this.bKG.dn(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void N(int i, String str) {
            if (e.this.bKG != null) {
                e.this.bKG.c(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Uw() {
            if (e.this.bKG != null) {
                e.this.bKG.dn(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void O(int i, String str) {
            if (e.this.bKG != null) {
                e.this.bKG.c(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (e.this.mChatStatus == 2 && e.this.bKG != null) {
                    e.this.bKG.a(null);
                }
                e.this.mChatStatus = 1;
                e.this.bKF.Vl();
                return;
            }
            if (!e.this.bKI && e.this.bKG != null) {
                e.this.bKG.a(cVar.aLL);
            }
            e.this.mChatStatus = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (e.this.mChatStatus != 4 && bVar != null && bVar.Ro() == 2) {
                e.this.mChatStatus = 4;
                if (e.this.bKG != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aLL;
                    }
                    e.this.bKG.a(e.this.bKF.UJ(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.Uq();
        }

        @Override // com.baidu.live.videochat.e.c
        public void Ux() {
            e.this.Uq();
        }

        @Override // com.baidu.live.videochat.e.c
        public void P(int i, String str) {
            if (e.this.bKG != null) {
                e.this.bKG.E(i, str);
            }
        }
    };
    private BdUniqueId brL = BdUniqueId.gen();

    public e(Activity activity) {
        this.mActivity = activity;
        this.bKF = new com.baidu.live.videochat.e.d(activity, this.brL);
        this.bKF.a(this.bKL);
        this.bKF.a(this.bKK);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bya != null && this.bya.getPreview() != null) {
            if (this.bya.getPreview().getParent() != null) {
                ((ViewGroup) this.bya.getPreview().getParent()).removeView(this.bya.getPreview());
            }
            this.bya.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.bya, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bKE = this.bya.createPKPlayer();
        }
    }

    private void Up() {
        this.bKE = null;
        if (this.bya != null) {
            this.bya.removeRecorderCallback(this.mRecorderCallback);
            if (this.bya.getPreview().getParent() != null) {
                ((ViewGroup) this.bya.getPreview().getParent()).removeView(this.bya.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Og().f(true, false);
            this.bya.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.mChatStatus != 3) {
            this.bKF.e(j, false);
            this.bKF.Vl();
            if (this.bKG != null && !z) {
                this.bKG.Ua();
            }
            this.mChatStatus = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bKG != null) {
                this.bKG.a(j, this.bya.getPreview(), this.bKE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uq() {
        this.bKF.Vn();
        if (this.mChatStatus != 1) {
            Up();
            this.mChatStatus = 1;
            if (this.bKG != null) {
                this.bKG.bw(this.bKF.UJ());
            }
        }
    }
}
