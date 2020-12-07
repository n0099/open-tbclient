package com.baidu.live.videochat;

import android.app.Activity;
import com.baidu.live.adp.BdUniqueId;
import com.baidu.live.adp.framework.MessageManager;
import com.baidu.live.adp.framework.listener.CustomMessageListener;
import com.baidu.live.adp.framework.message.CustomResponsedMessage;
import com.baidu.live.data.AlaAvtsConfigInfo;
import com.baidu.live.data.AlaAvtsData;
import com.baidu.live.data.AlaLiveInfoData;
import com.baidu.live.tbadk.core.TbadkCoreApplication;
import com.baidu.live.tbadk.core.frameworkdata.CmdConfigCustom;
import com.baidu.live.tbadk.core.message.BackgroundSwitchMessage;
import com.baidu.live.tbadk.core.sharedpref.SharedPrefConfig;
/* loaded from: classes4.dex */
public class f {
    private com.baidu.live.videochat.a.a bKM;
    private com.baidu.live.videochat.a.b bKN;
    private com.baidu.live.videochat.e.f bKO;
    private b bKP;
    private long bKV;
    private long bKW;
    private AlaLiveInfoData bqm;
    private BdUniqueId brR;
    private com.baidu.live.u.f byH;
    private Activity mActivity;
    private volatile int mChatStatus = 1;
    private boolean bKQ = true;
    private boolean bKR = true;
    private boolean bKS = true;
    private boolean bKT = false;
    private boolean bKU = false;
    private volatile boolean bKX = false;
    private com.baidu.live.videochat.e.g bKY = new com.baidu.live.videochat.e.g() { // from class: com.baidu.live.videochat.f.3
        @Override // com.baidu.live.videochat.e.g
        public void Xn() {
            if (f.this.bKO != null) {
                f.this.bKO.XU();
            }
            if (f.this.bKP != null) {
                f.this.bKP.WO();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void N(int i, String str) {
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bKX = false;
                if (f.this.bKP != null) {
                    f.this.bKP.C(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void Xo() {
            if (f.this.bKO != null) {
                f.this.bKO.XW();
            }
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bKX = false;
                if (f.this.bKP != null) {
                    f.this.bKP.ST();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (f.this.bKP != null) {
                    f.this.bKP.D(-100, "");
                }
            } else if (f.this.mChatStatus != 3) {
                f.this.mChatStatus = 3;
                if (f.this.bKO != null) {
                    f.this.bKO.XW();
                }
                if (f.this.bKO != null) {
                    f.this.bKO.c(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aPX, aVar.aIc, aVar.aId);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void O(int i, String str) {
            if (f.this.bKP != null) {
                f.this.bKP.D(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (f.this.mChatStatus != 2) {
                if (f.this.bKO != null) {
                    f.this.bKO.XW();
                }
            } else if (i == 1) {
                f.this.Xk();
            } else if (i != 2) {
                if (f.this.bKO != null) {
                    f.this.bKO.XW();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bKX = false;
                    if (f.this.bKP != null) {
                        f.this.bKP.E(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (f.this.bKO != null) {
                    f.this.bKO.XW();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bKX = false;
                    if (f.this.bKP != null) {
                        f.this.bKP.E(-100, str);
                    }
                }
            } else {
                f.this.mChatStatus = 3;
                if (f.this.bKO != null) {
                    f.this.bKO.XW();
                }
                if (f.this.bKO != null) {
                    f.this.bKO.c(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aPX, aVar.aIc, aVar.aId);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.bKX = (bVar == null || bVar.Xw() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            f.this.a(f.this.bKX, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.dq(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void Xj() {
            f.this.dq(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void M(int i, String str) {
            if (f.this.mChatStatus != 1 && f.this.bKP != null) {
                f.this.bKP.F(i, str);
            }
        }
    };
    private CustomMessageListener byv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                f.this.dr(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public f(Activity activity) {
        this.bKV = 0L;
        this.bKW = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.brR = BdUniqueId.gen();
        this.bKM = new com.baidu.live.videochat.a.a(activity);
        this.bKM.a(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.f.1
            @Override // com.baidu.live.u.b
            public void eb(int i) {
            }
        });
        this.bKN = new com.baidu.live.videochat.a.b(activity);
        this.bKN.a(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.f.2
            @Override // com.baidu.live.u.b
            public void eb(int i) {
            }
        });
        this.bKO = new com.baidu.live.videochat.e.f(activity, this.brR);
        this.bKO.a(this.bKY);
        this.bKO.a(this.bKM);
        MessageManager.getInstance().registerListener(this.byv);
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bKW = com.baidu.live.d.BM().getLong(sharedPrefKeyWithAccount, 0L);
        this.bKV = com.baidu.live.d.BM().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Xk() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bKX = true;
        if (this.byH != null) {
            this.byH.cE(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.d.BM().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.d.BM().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.bKM.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bKP != null) {
            if (a2) {
                this.bKP.a(true, j, this.bKM.Xr(), this.bKM.Xs());
            } else {
                dq(true);
            }
        }
        return a2;
    }

    private void Xl() {
        if (this.bKM != null) {
            this.bKM.Xp();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bKN != null && !this.bKN.isStarted() && bVar != null && dVar2 != null) {
            this.bKN.e(dVar2.aPX);
            if (this.bKP != null) {
                this.bKP.a(false, bVar.Xv(), this.bKN.Xr(), this.byH.getLivePlayer());
            }
        }
    }

    private void Xm() {
        if (!this.bKX && this.bKN != null) {
            this.bKN.Xt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.mChatStatus != 4 && bVar != null && bVar.Uc() == 2) {
            this.mChatStatus = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bKP != null) {
                    this.bKP.a(z, bVar.Xv(), dVar2.aPJ, z2);
                }
            } else if (this.bKM != null && !this.bKM.Xq()) {
                a(z, bVar.Xv(), bVar, dVar, dVar2);
            } else if (this.bKP != null) {
                this.bKP.a(z, bVar.Xv(), dVar2.aPJ, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(boolean z) {
        if (this.bKO != null) {
            this.bKO.XY();
        }
        if (this.mChatStatus != 1) {
            this.mChatStatus = 1;
            if (z) {
                if (this.bKX) {
                    Xl();
                    if (this.bKP != null) {
                        this.bKP.dp(true);
                    }
                    this.byH.c(this.bqm);
                } else {
                    Xm();
                    if (this.bKP != null) {
                        this.bKP.dp(false);
                    }
                }
            } else {
                Xl();
                if (this.bKP != null) {
                    this.bKP.dp(true);
                }
                this.byH.c(this.bqm);
            }
            this.bKX = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dr(boolean z) {
        if (this.bKM != null) {
            if (z) {
                this.bKM.WG();
            } else {
                this.bKM.WH();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bKT && j == this.bKW && dVar2 != null && dVar2.aPX != null && dVar != null && dVar.aPX != null && dVar.aPX.live_id == this.bKV && dVar2.bLt != null && dVar2.bLt.aId != null && dVar2.bLt.aIc != null) {
            if (!this.bKU) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            bx(bVar.Xv());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bKP != null) {
            this.bKU = this.bKP.a(dVar == null ? null : dVar.aPJ, new g() { // from class: com.baidu.live.videochat.f.5
            });
            if (!this.bKU && bVar != null) {
                bx(bVar.Xv());
            }
        }
    }

    private void bx(long j) {
        if (this.bKO != null) {
            this.bKO.bz(j);
        }
        if (this.bKO != null) {
            this.bKO.XY();
        }
        this.mChatStatus = 1;
    }
}
