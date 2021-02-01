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
/* loaded from: classes11.dex */
public class e {
    private AlaLiveRecorder bBG;
    private View bOo;
    private com.baidu.live.videochat.e.d bOp;
    private a bOq;
    private Activity mActivity;
    private Handler mHandler = new Handler(Looper.getMainLooper());
    private int mChatStatus = 1;
    private boolean bOr = false;
    private long mChatId = 0;
    private boolean bOs = false;
    private Runnable bOt = null;
    private com.baidu.live.videochat.e.a bOu = new com.baidu.live.videochat.e.a() { // from class: com.baidu.live.videochat.e.1
        @Override // com.baidu.live.videochat.e.a
        public int AL() {
            if (e.this.bBG != null) {
                return e.this.bBG.getRtcStreamStatus();
            }
            return 0;
        }

        @Override // com.baidu.live.videochat.e.a
        public int Wa() {
            return e.this.bOr ? 1 : 2;
        }
    };
    private RecorderCallback mRecorderCallback = new RecorderCallback() { // from class: com.baidu.live.videochat.e.2
    };
    private com.baidu.live.videochat.e.e bOv = new com.baidu.live.videochat.e.e() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.e
        public void a(com.baidu.live.videochat.b.a aVar) {
            e.this.bOs = false;
            if (aVar != null) {
                e.this.a(aVar.chatId, aVar.aFy, aVar.aFz, false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void N(int i, String str) {
            e.this.bOs = false;
            if (e.this.bOq != null) {
                e.this.bOq.G(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Wb() {
            e.this.bOs = false;
            if (e.this.bOp != null) {
                e.this.bOp.WU();
            }
            if (e.this.bOq != null) {
                e.this.bOq.VK();
            }
            e.this.mChatStatus = 1;
        }

        @Override // com.baidu.live.videochat.e.e
        public void O(int i, String str) {
            e.this.bOs = false;
            if (e.this.bOq != null) {
                e.this.bOq.H(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Wc() {
            if (e.this.bOq != null) {
                e.this.bOq.du(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void P(int i, String str) {
            if (e.this.bOq != null) {
                e.this.bOq.b(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Wd() {
            if (e.this.bOq != null) {
                e.this.bOq.du(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Q(int i, String str) {
            if (e.this.bOq != null) {
                e.this.bOq.b(true, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void We() {
            if (e.this.bOq != null) {
                e.this.bOq.dv(false);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void R(int i, String str) {
            if (e.this.bOq != null) {
                e.this.bOq.c(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void Wf() {
            if (e.this.bOq != null) {
                e.this.bOq.dv(true);
            }
        }

        @Override // com.baidu.live.videochat.e.e
        public void S(int i, String str) {
            if (e.this.bOq != null) {
                e.this.bOq.c(false, i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (cVar == null || i != 1) {
                if (e.this.mChatStatus == 2 && e.this.bOq != null) {
                    e.this.bOq.a(null);
                }
                e.this.mChatStatus = 1;
                e.this.bOp.WU();
                return;
            }
            if (!e.this.bOs && e.this.bOq != null) {
                e.this.bOq.a(cVar.aOI);
            }
            e.this.mChatStatus = 2;
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            if (e.this.mChatStatus != 4 && bVar != null && bVar.SV() == 2) {
                e.this.mChatStatus = 4;
                if (e.this.bOq != null) {
                    AlaLiveUserInfoData alaLiveUserInfoData = null;
                    if (dVar2 != null) {
                        alaLiveUserInfoData = dVar2.aOI;
                    }
                    e.this.bOq.a(e.this.bOp.Ws(), alaLiveUserInfoData);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.VZ();
        }

        @Override // com.baidu.live.videochat.e.c
        public void Wg() {
            e.this.VZ();
        }

        @Override // com.baidu.live.videochat.e.c
        public void T(int i, String str) {
            if (e.this.bOq != null) {
                e.this.bOq.I(i, str);
            }
        }
    };
    private BdUniqueId aCW = BdUniqueId.gen();

    public e(Activity activity) {
        this.mActivity = activity;
        this.bOp = new com.baidu.live.videochat.e.d(activity, this.aCW);
        this.bOp.a(this.bOv);
        this.bOp.a(this.bOu);
    }

    private void a(AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        if (this.bBG != null && this.bBG.getPreview() != null) {
            if (this.bBG.getPreview().getParent() != null) {
                ((ViewGroup) this.bBG.getPreview().getParent()).removeView(this.bBG.getPreview());
            }
            this.bBG.addRecorderCallback(this.mRecorderCallback);
            com.baidu.live.videochat.g.a.a(this.bBG, com.baidu.live.videochat.g.a.b(alaAvtsData, alaAvtsConfigInfo));
            this.bOo = this.bBG.createPKPlayer();
        }
    }

    private void VY() {
        this.bOo = null;
        if (this.bBG != null) {
            this.bBG.removeRecorderCallback(this.mRecorderCallback);
            if (this.bBG.getPreview().getParent() != null) {
                ((ViewGroup) this.bBG.getPreview().getParent()).removeView(this.bBG.getPreview());
            }
            b.a f = com.baidu.live.z.a.b.PF().f(true, false);
            this.bBG.switchToCommonMode(f.getWidth(), f.getHeight());
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(long j, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo, boolean z) {
        if (this.mChatStatus != 3) {
            this.bOp.f(j, false);
            this.bOp.WU();
            if (this.bOq != null && !z) {
                this.bOq.VJ();
            }
            this.mChatStatus = 3;
            a(alaAvtsData, alaAvtsConfigInfo);
            if (this.bOq != null) {
                this.bOq.a(j, this.bBG.getPreview(), this.bOo);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void VZ() {
        this.bOp.WW();
        if (this.mChatStatus != 1) {
            VY();
            this.mChatStatus = 1;
            if (this.bOq != null) {
                this.bOq.bA(this.bOp.Ws());
            }
        }
    }
}
