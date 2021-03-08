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
import com.baidu.live.z.a.b;
/* loaded from: classes10.dex */
public class e {
    private AlaLiveRecorder bDg;
    private View bPO;
    private com.baidu.live.videochat.e.d bPP;
    private a bPQ;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int mChatStatus = 1;
    private boolean bPR = false;
    private long mChatId = 0;
    private boolean bPS = false;
    private Runnable bPT = null;
    private com.baidu.live.videochat.e.a bPU = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.e.1
        @Override // com.baidu.live.videochat.e.a
        public int AO() {
            if (e.this.bDg != null) {
                return e.this.bDg.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int Wd() {
            return e.this.bPR ? 1 : 2;
        }
    };
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.e.2
    };
    private com.baidu.live.videochat.e.e bPV = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            e.this.bPS = false;
            if (aVar != null) {
                e.this.a(aVar.chatId, aVar.aGY, aVar.aGZ, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void N(int i, String str) {
            e.this.bPS = false;
            if (e.this.bPQ != null) {
                e.this.bPQ.G(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void We() {
            e.this.bPS = false;
            if (e.this.bPP != null) {
                e.this.bPP.WX();
            }
            if (e.this.bPQ != null) {
                e.this.bPQ.VN();
            }
            e.this.mChatStatus = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void O(int i, String str) {
            e.this.bPS = false;
            if (e.this.bPQ != null) {
                e.this.bPQ.H(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Wf() {
            if (e.this.bPQ != null) {
                e.this.bPQ.du(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void P(int i, String str) {
            if (e.this.bPQ != null) {
                e.this.bPQ.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Wg() {
            if (e.this.bPQ != null) {
                e.this.bPQ.du(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Q(int i, String str) {
            if (e.this.bPQ != null) {
                e.this.bPQ.b(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Wh() {
            if (e.this.bPQ != null) {
                e.this.bPQ.dv(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void R(int i, String str) {
            if (e.this.bPQ != null) {
                e.this.bPQ.c(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Wi() {
            if (e.this.bPQ != null) {
                e.this.bPQ.dv(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void S(int i, String str) {
            if (e.this.bPQ != null) {
                e.this.bPQ.c(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (e.this.mChatStatus == 2 && e.this.bPQ != null) {
                    e.this.bPQ.a(null);
                }
                e.this.mChatStatus = 1;
                e.this.bPP.WX();
                return;
            }
            if (!e.this.bPS && e.this.bPQ != null) {
                e.this.bPQ.a(cVar.aQi);
            }
            e.this.mChatStatus = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (e.this.mChatStatus != 4 && bVar != null && bVar.SY() == 2) {
                e.this.mChatStatus = 4;
                if (e.this.bPQ != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aQi;
                    }
                    e.this.bPQ.a(e.this.bPP.Wv(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.Wc();
        }

        @Override // com.baidu.live.videochat.e.c
        public void Wj() {
            e.this.Wc();
        }

        @Override // com.baidu.live.videochat.e.c
        public void T(int i, String str) {
            if (e.this.bPQ != null) {
                e.this.bPQ.I(i, str);
            }
        }
    };
    private BdUniqueId aEw = BdUniqueId.gen();

    public e(Activity activity) {
        this.mActivity = activity;
        this.bPP = new com.baidu.live.videochat.e.d(activity, this.aEw);
        this.bPP.a(this.bPV);
        this.bPP.a(this.bPU);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bDg != null && this.bDg.getPreview() != null) {
            if (this.bDg.getPreview().getParent() != null) {
                ((ViewGroup) this.bDg.getPreview().getParent()).removeView(this.bDg.getPreview());
            }
            this.bDg.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.bDg, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bPO = this.bDg.createPKPlayer();
        }
    }

    private void Wb() {
        this.bPO = null;
        if (this.bDg != null) {
            this.bDg.removeRecorderCallback(this.mRecorderCallback);
            if (this.bDg.getPreview().getParent() != null) {
                ((ViewGroup) this.bDg.getPreview().getParent()).removeView(this.bDg.getPreview());
            }
            b.a f = com.baidu.live.z.a.b.PI().f(true, false);
            this.bDg.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.mChatStatus != 3) {
            this.bPP.f(j, false);
            this.bPP.WX();
            if (this.bPQ != null && !z) {
                this.bPQ.VM();
            }
            this.mChatStatus = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bPQ != null) {
                this.bPQ.a(j, this.bDg.getPreview(), this.bPO);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wc() {
        this.bPP.WZ();
        if (this.mChatStatus != 1) {
            Wb();
            this.mChatStatus = 1;
            if (this.bPQ != null) {
                this.bPQ.bA(this.bPP.Wv());
            }
        }
    }
}
