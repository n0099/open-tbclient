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
/* loaded from: classes11.dex */
public class f {
    private com.baidu.live.v.f bDt;
    private com.baidu.live.videochat.a.b bPA;
    private com.baidu.live.videochat.e.f bPB;
    private b bPC;
    private long bPI;
    private long bPJ;
    private com.baidu.live.videochat.a.a bPz;
    private AlaLiveInfoData brX;
    private BdUniqueId bwz;
    private Activity mActivity;
    private volatile int mChatStatus = 1;
    private boolean bPD = true;
    private boolean bPE = true;
    private boolean bPF = true;
    private boolean bPG = false;
    private boolean bPH = false;
    private volatile boolean bPK = false;
    private com.baidu.live.videochat.e.g bPL = new com.baidu.live.videochat.e.g() { // from class: com.baidu.live.videochat.f.3
        @Override // com.baidu.live.videochat.e.g
        public void Yu() {
            if (f.this.bPB != null) {
                f.this.bPB.Zc();
            }
            if (f.this.bPC != null) {
                f.this.bPC.XV();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void P(int i, String str) {
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bPK = false;
                if (f.this.bPC != null) {
                    f.this.bPC.E(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void Yv() {
            if (f.this.bPB != null) {
                f.this.bPB.Ze();
            }
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bPK = false;
                if (f.this.bPC != null) {
                    f.this.bPC.Ua();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (f.this.bPC != null) {
                    f.this.bPC.F(-100, "");
                }
            } else if (f.this.mChatStatus != 3) {
                f.this.mChatStatus = 3;
                if (f.this.bPB != null) {
                    f.this.bPB.Ze();
                }
                if (f.this.bPB != null) {
                    f.this.bPB.d(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aQM, aVar.aIy, aVar.aIz);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void Q(int i, String str) {
            if (f.this.bPC != null) {
                f.this.bPC.F(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (f.this.mChatStatus != 2) {
                if (f.this.bPB != null) {
                    f.this.bPB.Ze();
                }
            } else if (i == 1) {
                f.this.Yr();
            } else if (i != 2) {
                if (f.this.bPB != null) {
                    f.this.bPB.Ze();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bPK = false;
                    if (f.this.bPC != null) {
                        f.this.bPC.G(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (f.this.bPB != null) {
                    f.this.bPB.Ze();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bPK = false;
                    if (f.this.bPC != null) {
                        f.this.bPC.G(-100, str);
                    }
                }
            } else {
                f.this.mChatStatus = 3;
                if (f.this.bPB != null) {
                    f.this.bPB.Ze();
                }
                if (f.this.bPB != null) {
                    f.this.bPB.d(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aQM, aVar.aIy, aVar.aIz);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.bPK = (bVar == null || bVar.YD() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            f.this.a(f.this.bPK, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.dt(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void Yq() {
            f.this.dt(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void O(int i, String str) {
            if (f.this.mChatStatus != 1 && f.this.bPC != null) {
                f.this.bPC.H(i, str);
            }
        }
    };
    private CustomMessageListener bDh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                f.this.du(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public f(Activity activity) {
        this.bPI = 0L;
        this.bPJ = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.bwz = BdUniqueId.gen();
        this.bPz = new com.baidu.live.videochat.a.a(activity);
        this.bPz.a(new com.baidu.live.v.b() { // from class: com.baidu.live.videochat.f.1
            @Override // com.baidu.live.v.b
            public void dY(int i) {
            }
        });
        this.bPA = new com.baidu.live.videochat.a.b(activity);
        this.bPA.a(new com.baidu.live.v.b() { // from class: com.baidu.live.videochat.f.2
            @Override // com.baidu.live.v.b
            public void dY(int i) {
            }
        });
        this.bPB = new com.baidu.live.videochat.e.f(activity, this.bwz);
        this.bPB.a(this.bPL);
        this.bPB.a(this.bPz);
        MessageManager.getInstance().registerListener(this.bDh);
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bPJ = com.baidu.live.d.Ba().getLong(sharedPrefKeyWithAccount, 0L);
        this.bPI = com.baidu.live.d.Ba().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Yr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bPK = true;
        if (this.bDt != null) {
            this.bDt.cH(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.d.Ba().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.d.Ba().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.bPz.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bPC != null) {
            if (a2) {
                this.bPC.a(true, j, this.bPz.Yy(), this.bPz.Yz());
            } else {
                dt(true);
            }
        }
        return a2;
    }

    private void Ys() {
        if (this.bPz != null) {
            this.bPz.Yw();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bPA != null && !this.bPA.isStarted() && bVar != null && dVar2 != null) {
            this.bPA.e(dVar2.aQM);
            if (this.bPC != null) {
                this.bPC.a(false, bVar.YC(), this.bPA.Yy(), this.bDt.getLivePlayer());
            }
        }
    }

    private void Yt() {
        if (!this.bPK && this.bPA != null) {
            this.bPA.YA();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.mChatStatus != 4 && bVar != null && bVar.Vh() == 2) {
            this.mChatStatus = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bPC != null) {
                    this.bPC.a(z, bVar.YC(), dVar2.aQy, z2);
                }
            } else if (this.bPz != null && !this.bPz.Yx()) {
                a(z, bVar.YC(), bVar, dVar, dVar2);
            } else if (this.bPC != null) {
                this.bPC.a(z, bVar.YC(), dVar2.aQy, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dt(boolean z) {
        if (this.bPB != null) {
            this.bPB.Zg();
        }
        if (this.mChatStatus != 1) {
            this.mChatStatus = 1;
            if (z) {
                if (this.bPK) {
                    Ys();
                    if (this.bPC != null) {
                        this.bPC.ds(true);
                    }
                    this.bDt.c(this.brX);
                } else {
                    Yt();
                    if (this.bPC != null) {
                        this.bPC.ds(false);
                    }
                }
            } else {
                Ys();
                if (this.bPC != null) {
                    this.bPC.ds(true);
                }
                this.bDt.c(this.brX);
            }
            this.bPK = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void du(boolean z) {
        if (this.bPz != null) {
            if (z) {
                this.bPz.XL();
            } else {
                this.bPz.XM();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bPG && j == this.bPJ && dVar2 != null && dVar2.aQM != null && dVar != null && dVar.aQM != null && dVar.aQM.live_id == this.bPI && dVar2.bQg != null && dVar2.bQg.aIz != null && dVar2.bQg.aIy != null) {
            if (!this.bPH) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            bx(bVar.YC());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bPC != null) {
            this.bPH = this.bPC.a(dVar == null ? null : dVar.aQy, new g() { // from class: com.baidu.live.videochat.f.5
            });
            if (!this.bPH && bVar != null) {
                bx(bVar.YC());
            }
        }
    }

    private void bx(long j) {
        if (this.bPB != null) {
            this.bPB.bz(j);
        }
        if (this.bPB != null) {
            this.bPB.Zg();
        }
        this.mChatStatus = 1;
    }
}
