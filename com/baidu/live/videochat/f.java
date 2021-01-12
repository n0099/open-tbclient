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
/* loaded from: classes10.dex */
public class f {
    private com.baidu.live.videochat.a.a bKN;
    private com.baidu.live.videochat.a.b bKO;
    private com.baidu.live.videochat.e.f bKP;
    private b bKQ;
    private long bKW;
    private long bKX;
    private AlaLiveInfoData bnl;
    private BdUniqueId brL;
    private com.baidu.live.v.f byH;
    private Activity mActivity;
    private volatile int mChatStatus = 1;
    private boolean bKR = true;
    private boolean bKS = true;
    private boolean bKT = true;
    private boolean bKU = false;
    private boolean bKV = false;
    private volatile boolean bKY = false;
    private com.baidu.live.videochat.e.g bKZ = new com.baidu.live.videochat.e.g() { // from class: com.baidu.live.videochat.f.3
        @Override // com.baidu.live.videochat.e.g
        public void UB() {
            if (f.this.bKP != null) {
                f.this.bKP.Vj();
            }
            if (f.this.bKQ != null) {
                f.this.bKQ.Uc();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void Q(int i, String str) {
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bKY = false;
                if (f.this.bKQ != null) {
                    f.this.bKQ.F(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void UC() {
            if (f.this.bKP != null) {
                f.this.bKP.Vl();
            }
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bKY = false;
                if (f.this.bKQ != null) {
                    f.this.bKQ.Qf();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (f.this.bKQ != null) {
                    f.this.bKQ.G(-100, "");
                }
            } else if (f.this.mChatStatus != 3) {
                f.this.mChatStatus = 3;
                if (f.this.bKP != null) {
                    f.this.bKP.Vl();
                }
                if (f.this.bKP != null) {
                    f.this.bKP.e(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aLZ, aVar.aDL, aVar.aDM);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void R(int i, String str) {
            if (f.this.bKQ != null) {
                f.this.bKQ.G(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (f.this.mChatStatus != 2) {
                if (f.this.bKP != null) {
                    f.this.bKP.Vl();
                }
            } else if (i == 1) {
                f.this.Uy();
            } else if (i != 2) {
                if (f.this.bKP != null) {
                    f.this.bKP.Vl();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bKY = false;
                    if (f.this.bKQ != null) {
                        f.this.bKQ.H(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (f.this.bKP != null) {
                    f.this.bKP.Vl();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bKY = false;
                    if (f.this.bKQ != null) {
                        f.this.bKQ.H(-100, str);
                    }
                }
            } else {
                f.this.mChatStatus = 3;
                if (f.this.bKP != null) {
                    f.this.bKP.Vl();
                }
                if (f.this.bKP != null) {
                    f.this.bKP.e(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aLZ, aVar.aDL, aVar.aDM);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.bKY = (bVar == null || bVar.UK() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            f.this.a(f.this.bKY, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.dp(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void Ux() {
            f.this.dp(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void P(int i, String str) {
            if (f.this.mChatStatus != 1 && f.this.bKQ != null) {
                f.this.bKQ.I(i, str);
            }
        }
    };
    private CustomMessageListener byv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                f.this.dq(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public f(Activity activity) {
        this.bKW = 0L;
        this.bKX = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.brL = BdUniqueId.gen();
        this.bKN = new com.baidu.live.videochat.a.a(activity);
        this.bKN.a(new com.baidu.live.v.b() { // from class: com.baidu.live.videochat.f.1
            @Override // com.baidu.live.v.b
            public void cs(int i) {
            }
        });
        this.bKO = new com.baidu.live.videochat.a.b(activity);
        this.bKO.a(new com.baidu.live.v.b() { // from class: com.baidu.live.videochat.f.2
            @Override // com.baidu.live.v.b
            public void cs(int i) {
            }
        });
        this.bKP = new com.baidu.live.videochat.e.f(activity, this.brL);
        this.bKP.a(this.bKZ);
        this.bKP.a(this.bKN);
        MessageManager.getInstance().registerListener(this.byv);
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bKX = com.baidu.live.d.xf().getLong(sharedPrefKeyWithAccount, 0L);
        this.bKW = com.baidu.live.d.xf().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Uy() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bKY = true;
        if (this.byH != null) {
            this.byH.cD(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.d.xf().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.d.xf().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.bKN.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bKQ != null) {
            if (a2) {
                this.bKQ.a(true, j, this.bKN.UF(), this.bKN.UG());
            } else {
                dp(true);
            }
        }
        return a2;
    }

    private void Uz() {
        if (this.bKN != null) {
            this.bKN.UD();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bKO != null && !this.bKO.isStarted() && bVar != null && dVar2 != null) {
            this.bKO.e(dVar2.aLZ);
            if (this.bKQ != null) {
                this.bKQ.a(false, bVar.UJ(), this.bKO.UF(), this.byH.getLivePlayer());
            }
        }
    }

    private void UA() {
        if (!this.bKY && this.bKO != null) {
            this.bKO.UH();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.mChatStatus != 4 && bVar != null && bVar.Ro() == 2) {
            this.mChatStatus = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bKQ != null) {
                    this.bKQ.a(z, bVar.UJ(), dVar2.aLL, z2);
                }
            } else if (this.bKN != null && !this.bKN.UE()) {
                a(z, bVar.UJ(), bVar, dVar, dVar2);
            } else if (this.bKQ != null) {
                this.bKQ.a(z, bVar.UJ(), dVar2.aLL, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dp(boolean z) {
        if (this.bKP != null) {
            this.bKP.Vn();
        }
        if (this.mChatStatus != 1) {
            this.mChatStatus = 1;
            if (z) {
                if (this.bKY) {
                    Uz();
                    if (this.bKQ != null) {
                        this.bKQ.m22do(true);
                    }
                    this.byH.c(this.bnl);
                } else {
                    UA();
                    if (this.bKQ != null) {
                        this.bKQ.m22do(false);
                    }
                }
            } else {
                Uz();
                if (this.bKQ != null) {
                    this.bKQ.m22do(true);
                }
                this.byH.c(this.bnl);
            }
            this.bKY = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dq(boolean z) {
        if (this.bKN != null) {
            if (z) {
                this.bKN.TS();
            } else {
                this.bKN.TT();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bKU && j == this.bKX && dVar2 != null && dVar2.aLZ != null && dVar != null && dVar.aLZ != null && dVar.aLZ.live_id == this.bKW && dVar2.bLu != null && dVar2.bLu.aDM != null && dVar2.bLu.aDL != null) {
            if (!this.bKV) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            bx(bVar.UJ());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bKQ != null) {
            this.bKV = this.bKQ.a(dVar == null ? null : dVar.aLL, new g() { // from class: com.baidu.live.videochat.f.5
            });
            if (!this.bKV && bVar != null) {
                bx(bVar.UJ());
            }
        }
    }

    private void bx(long j) {
        if (this.bKP != null) {
            this.bKP.bz(j);
        }
        if (this.bKP != null) {
            this.bKP.Vn();
        }
        this.mChatStatus = 1;
    }
}
