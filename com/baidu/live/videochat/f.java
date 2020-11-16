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
    private com.baidu.live.videochat.a.a bFD;
    private com.baidu.live.videochat.a.b bFE;
    private com.baidu.live.videochat.e.f bFF;
    private b bFG;
    private long bFM;
    private long bFN;
    private AlaLiveInfoData bld;
    private BdUniqueId bmJ;
    private com.baidu.live.s.f btw;
    private Activity mActivity;
    private volatile int bwz = 1;
    private boolean bFH = true;
    private boolean bFI = true;
    private boolean bFJ = true;
    private boolean bFK = false;
    private boolean bFL = false;
    private volatile boolean bFO = false;
    private com.baidu.live.videochat.e.g bFP = new com.baidu.live.videochat.e.g() { // from class: com.baidu.live.videochat.f.3
        @Override // com.baidu.live.videochat.e.g
        public void UL() {
            if (f.this.bFF != null) {
                f.this.bFF.Vu();
            }
            if (f.this.bFG != null) {
                f.this.bFG.Um();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void N(int i, String str) {
            if (f.this.bwz != 1) {
                f.this.bwz = 1;
                f.this.bFO = false;
                if (f.this.bFG != null) {
                    f.this.bFG.C(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void UM() {
            if (f.this.bFF != null) {
                f.this.bFF.Vw();
            }
            if (f.this.bwz != 1) {
                f.this.bwz = 1;
                f.this.bFO = false;
                if (f.this.bFG != null) {
                    f.this.bFG.Qv();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (f.this.bFG != null) {
                    f.this.bFG.D(-100, "");
                }
            } else if (f.this.bwz != 3) {
                f.this.bwz = 3;
                if (f.this.bFF != null) {
                    f.this.bFF.Vw();
                }
                if (f.this.bFF != null) {
                    f.this.bFF.c(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aMY, aVar.aFu, aVar.aFv);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void O(int i, String str) {
            if (f.this.bFG != null) {
                f.this.bFG.D(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (f.this.bwz != 2) {
                if (f.this.bFF != null) {
                    f.this.bFF.Vw();
                }
            } else if (i == 1) {
                f.this.UI();
            } else if (i != 2) {
                if (f.this.bFF != null) {
                    f.this.bFF.Vw();
                }
                if (f.this.bwz != 1) {
                    f.this.bwz = 1;
                    f.this.bFO = false;
                    if (f.this.bFG != null) {
                        f.this.bFG.E(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (f.this.bFF != null) {
                    f.this.bFF.Vw();
                }
                if (f.this.bwz != 1) {
                    f.this.bwz = 1;
                    f.this.bFO = false;
                    if (f.this.bFG != null) {
                        f.this.bFG.E(-100, str);
                    }
                }
            } else {
                f.this.bwz = 3;
                if (f.this.bFF != null) {
                    f.this.bFF.Vw();
                }
                if (f.this.bFF != null) {
                    f.this.bFF.c(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aMY, aVar.aFu, aVar.aFv);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.bFO = (bVar == null || bVar.UW() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            f.this.a(f.this.bFO, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.dc(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void UH() {
            f.this.dc(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void M(int i, String str) {
            if (f.this.bwz != 1 && f.this.bFG != null) {
                f.this.bFG.F(i, str);
            }
        }
    };
    private CustomMessageListener bFQ = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                f.this.dd(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public f(Activity activity) {
        this.bFM = 0L;
        this.bFN = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.bmJ = BdUniqueId.gen();
        this.bFD = new com.baidu.live.videochat.a.a(activity);
        this.bFD.a(new com.baidu.live.s.b() { // from class: com.baidu.live.videochat.f.1
            @Override // com.baidu.live.s.b
            public void dI(int i) {
            }
        });
        this.bFE = new com.baidu.live.videochat.a.b(activity);
        this.bFE.a(new com.baidu.live.s.b() { // from class: com.baidu.live.videochat.f.2
            @Override // com.baidu.live.s.b
            public void dI(int i) {
            }
        });
        this.bFF = new com.baidu.live.videochat.e.f(activity, this.bmJ);
        this.bFF.a(this.bFP);
        this.bFF.a(this.bFD);
        MessageManager.getInstance().registerListener(this.bFQ);
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bFN = com.baidu.live.d.Aq().getLong(sharedPrefKeyWithAccount, 0L);
        this.bFM = com.baidu.live.d.Aq().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void UI() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bFO = true;
        if (this.btw != null) {
            this.btw.cq(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.d.Aq().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.d.Aq().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.bFD.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bFG != null) {
            if (a2) {
                this.bFG.a(true, j, this.bFD.UP(), this.bFD.UQ());
            } else {
                dc(true);
            }
        }
        return a2;
    }

    private void UJ() {
        if (this.bFD != null) {
            this.bFD.UN();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bFE != null && !this.bFE.isStarted() && bVar != null && dVar2 != null) {
            this.bFE.e(dVar2.aMY);
            if (this.bFG != null) {
                this.bFG.a(false, bVar.UV(), this.bFE.UP(), this.btw.getLivePlayer());
            }
        }
    }

    private void UK() {
        if (!this.bFO && this.bFE != null) {
            this.bFE.UT();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bwz != 4 && bVar != null && bVar.RE() == 2) {
            this.bwz = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bFG != null) {
                    this.bFG.a(z, bVar.UV(), dVar2.aMK, z2);
                }
            } else if (this.bFD != null && !this.bFD.UO()) {
                a(z, bVar.UV(), bVar, dVar, dVar2);
            } else if (this.bFG != null) {
                this.bFG.a(z, bVar.UV(), dVar2.aMK, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dc(boolean z) {
        if (this.bFF != null) {
            this.bFF.Vy();
        }
        if (this.bwz != 1) {
            this.bwz = 1;
            if (z) {
                if (this.bFO) {
                    UJ();
                    if (this.bFG != null) {
                        this.bFG.db(true);
                    }
                    this.btw.c(this.bld);
                } else {
                    UK();
                    if (this.bFG != null) {
                        this.bFG.db(false);
                    }
                }
            } else {
                UJ();
                if (this.bFG != null) {
                    this.bFG.db(true);
                }
                this.btw.c(this.bld);
            }
            this.bFO = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dd(boolean z) {
        if (this.bFD != null) {
            if (z) {
                this.bFD.UR();
            } else {
                this.bFD.US();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bFK && j == this.bFN && dVar2 != null && dVar2.aMY != null && dVar != null && dVar.aMY != null && dVar.aMY.live_id == this.bFM && dVar2.bGl != null && dVar2.bGl.aFv != null && dVar2.bGl.aFu != null) {
            if (!this.bFL) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            aZ(bVar.UV());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bFG != null) {
            this.bFL = this.bFG.a(dVar == null ? null : dVar.aMK, new g() { // from class: com.baidu.live.videochat.f.5
            });
            if (!this.bFL && bVar != null) {
                aZ(bVar.UV());
            }
        }
    }

    private void aZ(long j) {
        if (this.bFF != null) {
            this.bFF.bb(j);
        }
        if (this.bFF != null) {
            this.bFF.Vy();
        }
        this.bwz = 1;
    }
}
