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
/* loaded from: classes11.dex */
public class e {
    private AlaLiveRecorder bCM;
    private View bPq;
    private com.baidu.live.videochat.e.d bPr;
    private a bPs;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int mChatStatus = 1;
    private boolean bPt = false;
    private long mChatId = 0;
    private boolean bPu = false;
    private Runnable bPv = null;
    private com.baidu.live.videochat.e.a bPw = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.e.1
        @Override // com.baidu.live.videochat.e.a
        public int DW() {
            if (e.this.bCM != null) {
                return e.this.bCM.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int Yk() {
            return e.this.bPt ? 1 : 2;
        }
    };
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.e.2
    };
    private com.baidu.live.videochat.e.e bPx = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            e.this.bPu = false;
            if (aVar != null) {
                e.this.a(aVar.chatId, aVar.aIy, aVar.aIz, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void I(int i, String str) {
            e.this.bPu = false;
            if (e.this.bPs != null) {
                e.this.bPs.B(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Yl() {
            e.this.bPu = false;
            if (e.this.bPr != null) {
                e.this.bPr.Ze();
            }
            if (e.this.bPs != null) {
                e.this.bPs.XU();
            }
            e.this.mChatStatus = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void J(int i, String str) {
            e.this.bPu = false;
            if (e.this.bPs != null) {
                e.this.bPs.C(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Ym() {
            if (e.this.bPs != null) {
                e.this.bPs.dq(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void K(int i, String str) {
            if (e.this.bPs != null) {
                e.this.bPs.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Yn() {
            if (e.this.bPs != null) {
                e.this.bPs.dq(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void L(int i, String str) {
            if (e.this.bPs != null) {
                e.this.bPs.b(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Yo() {
            if (e.this.bPs != null) {
                e.this.bPs.dr(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void M(int i, String str) {
            if (e.this.bPs != null) {
                e.this.bPs.c(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Yp() {
            if (e.this.bPs != null) {
                e.this.bPs.dr(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void N(int i, String str) {
            if (e.this.bPs != null) {
                e.this.bPs.c(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (e.this.mChatStatus == 2 && e.this.bPs != null) {
                    e.this.bPs.a(null);
                }
                e.this.mChatStatus = 1;
                e.this.bPr.Ze();
                return;
            }
            if (!e.this.bPu && e.this.bPs != null) {
                e.this.bPs.a(cVar.aQy);
            }
            e.this.mChatStatus = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (e.this.mChatStatus != 4 && bVar != null && bVar.Vh() == 2) {
                e.this.mChatStatus = 4;
                if (e.this.bPs != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aQy;
                    }
                    e.this.bPs.a(e.this.bPr.YC(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.Yj();
        }

        @Override // com.baidu.live.videochat.e.c
        public void Yq() {
            e.this.Yj();
        }

        @Override // com.baidu.live.videochat.e.c
        public void O(int i, String str) {
            if (e.this.bPs != null) {
                e.this.bPs.D(i, str);
            }
        }
    };
    private BdUniqueId bwz = BdUniqueId.gen();

    public e(Activity activity) {
        this.mActivity = activity;
        this.bPr = new com.baidu.live.videochat.e.d(activity, this.bwz);
        this.bPr.a(this.bPx);
        this.bPr.a(this.bPw);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bCM != null && this.bCM.getPreview() != null) {
            if (this.bCM.getPreview().getParent() != null) {
                ((ViewGroup) this.bCM.getPreview().getParent()).removeView(this.bCM.getPreview());
            }
            this.bCM.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.bCM, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bPq = this.bCM.createPKPlayer();
        }
    }

    private void Yi() {
        this.bPq = null;
        if (this.bCM != null) {
            this.bCM.removeRecorderCallback(this.mRecorderCallback);
            if (this.bCM.getPreview().getParent() != null) {
                ((ViewGroup) this.bCM.getPreview().getParent()).removeView(this.bCM.getPreview());
            }
            LiveRecorderConfigHelper.VideoResolution f = LiveRecorderConfigHelper.Sb().f(true, false);
            this.bCM.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.mChatStatus != 3) {
            this.bPr.d(j, false);
            this.bPr.Ze();
            if (this.bPs != null && !z) {
                this.bPs.XT();
            }
            this.mChatStatus = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bPs != null) {
                this.bPs.a(j, this.bCM.getPreview(), this.bPq);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yj() {
        this.bPr.Zg();
        if (this.mChatStatus != 1) {
            Yi();
            this.mChatStatus = 1;
            if (this.bPs != null) {
                this.bPs.bw(this.bPr.YC());
            }
        }
    }
}
