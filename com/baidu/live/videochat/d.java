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
import com.baidu.live.videochat.c.f;
import com.baidu.live.videochat.c.g;
/* loaded from: classes7.dex */
public class d {
    private AlaLiveInfoData bds;
    private BdUniqueId beV;
    private com.baidu.live.videochat.a.a bqQ;
    private com.baidu.live.videochat.a.b bqR;
    private f bqS;
    private com.baidu.live.p.f bqT;
    private b bqU;
    private long bra;
    private long brb;
    private Activity mActivity;
    private volatile int bqJ = 1;
    private boolean bqV = true;
    private boolean bqW = true;
    private boolean bqX = true;
    private boolean bqY = false;
    private boolean bqZ = false;
    private volatile boolean brc = false;
    private g brd = new g() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.c.g
        public void PI() {
            if (d.this.bqS != null) {
                d.this.bqS.Qn();
            }
            if (d.this.bqU != null) {
                d.this.bqU.Pt();
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void E(int i, String str) {
            if (d.this.bqJ != 1) {
                d.this.bqJ = 1;
                d.this.brc = false;
                if (d.this.bqU != null) {
                    d.this.bqU.t(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void PJ() {
            if (d.this.bqS != null) {
                d.this.bqS.Qp();
            }
            if (d.this.bqJ != 1) {
                d.this.bqJ = 1;
                d.this.brc = false;
                if (d.this.bqU != null) {
                    d.this.bqU.Pu();
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (d.this.bqU != null) {
                    d.this.bqU.u(-100, "");
                }
            } else if (d.this.bqJ != 3) {
                d.this.bqJ = 3;
                if (d.this.bqS != null) {
                    d.this.bqS.Qp();
                }
                if (d.this.bqS != null) {
                    d.this.bqS.b(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aIE, aVar.aCr, aVar.aCs);
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void F(int i, String str) {
            if (d.this.bqU != null) {
                d.this.bqU.u(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (d.this.bqJ != 2) {
                if (d.this.bqS != null) {
                    d.this.bqS.Qp();
                }
            } else if (i == 1) {
                d.this.PF();
            } else if (i != 2) {
                if (d.this.bqS != null) {
                    d.this.bqS.Qp();
                }
                if (d.this.bqJ != 1) {
                    d.this.bqJ = 1;
                    d.this.brc = false;
                    if (d.this.bqU != null) {
                        d.this.bqU.v(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (d.this.bqS != null) {
                    d.this.bqS.Qp();
                }
                if (d.this.bqJ != 1) {
                    d.this.bqJ = 1;
                    d.this.brc = false;
                    if (d.this.bqU != null) {
                        d.this.bqU.v(-100, str);
                    }
                }
            } else {
                d.this.bqJ = 3;
                if (d.this.bqS != null) {
                    d.this.bqS.Qp();
                }
                if (d.this.bqS != null) {
                    d.this.bqS.b(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aIE, aVar.aCr, aVar.aCs);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.brc = (bVar == null || bVar.PW() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            d.this.a(d.this.brc, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.cI(true);
        }

        @Override // com.baidu.live.videochat.c.c
        public void PE() {
            d.this.cI(false);
        }

        @Override // com.baidu.live.videochat.c.c
        public void D(int i, String str) {
            if (d.this.bqJ != 1 && d.this.bqU != null) {
                d.this.bqU.w(i, str);
            }
        }
    };
    private CustomMessageListener bre = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                d.this.cJ(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public d(Activity activity) {
        this.bra = 0L;
        this.brb = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.beV = BdUniqueId.gen();
        this.bqQ = new com.baidu.live.videochat.a.a(activity);
        this.bqQ.a(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.d.1
            @Override // com.baidu.live.p.b
            public void dD(int i) {
            }
        });
        this.bqR = new com.baidu.live.videochat.a.b(activity);
        this.bqR.a(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.d.2
            @Override // com.baidu.live.p.b
            public void dD(int i) {
            }
        });
        this.bqS = new f(activity, this.beV);
        this.bqS.a(this.brd);
        this.bqS.a(this.bqQ);
        MessageManager.getInstance().registerListener(this.bre);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.brb = com.baidu.live.c.AD().getLong(sharedPrefKeyWithAccount, 0L);
        this.bra = com.baidu.live.c.AD().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.brc = true;
        if (this.bqT != null) {
            this.bqT.ch(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.AD().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.AD().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a = this.bqQ.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bqU != null) {
            if (a) {
                this.bqU.a(true, j, this.bqQ.PM(), this.bqQ.PN());
            } else {
                cI(true);
            }
        }
        return a;
    }

    private void PG() {
        if (this.bqQ != null) {
            this.bqQ.PK();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bqR != null && !this.bqR.isStarted() && bVar != null && dVar2 != null) {
            this.bqR.e(dVar2.aIE);
            if (this.bqU != null) {
                this.bqU.a(false, bVar.PU(), this.bqR.PM(), this.bqT.getLivePlayer());
            }
        }
    }

    private void PH() {
        if (!this.brc && this.bqR != null) {
            this.bqR.PR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bqJ != 4 && bVar != null && bVar.PV() == 2) {
            this.bqJ = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bqU != null) {
                    this.bqU.a(z, bVar.PU(), dVar2.aIl, z2);
                }
            } else if (this.bqQ != null && !this.bqQ.PL()) {
                a(z, bVar.PU(), bVar, dVar, dVar2);
            } else if (this.bqU != null) {
                this.bqU.a(z, bVar.PU(), dVar2.aIl, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cI(boolean z) {
        if (this.bqS != null) {
            this.bqS.Qr();
        }
        if (this.bqJ != 1) {
            this.bqJ = 1;
            if (z) {
                if (this.brc) {
                    PG();
                    if (this.bqU != null) {
                        this.bqU.cH(true);
                    }
                    this.bqT.c(this.bds);
                } else {
                    PH();
                    if (this.bqU != null) {
                        this.bqU.cH(false);
                    }
                }
            } else {
                PG();
                if (this.bqU != null) {
                    this.bqU.cH(true);
                }
                this.bqT.c(this.bds);
            }
            this.brc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(boolean z) {
        if (this.bqQ != null) {
            if (z) {
                this.bqQ.PO();
            } else {
                this.bqQ.PP();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bqY && j == this.brb && dVar2 != null && dVar2.aIE != null && dVar != null && dVar.aIE != null && dVar.aIE.live_id == this.bra && dVar2.brA != null && dVar2.brA.aCs != null && dVar2.brA.aCr != null) {
            if (!this.bqZ) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            aA(bVar.PU());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bqU != null) {
            this.bqZ = this.bqU.a(dVar == null ? null : dVar.aIl, new e() { // from class: com.baidu.live.videochat.d.5
            });
            if (!this.bqZ && bVar != null) {
                aA(bVar.PU());
            }
        }
    }

    private void aA(long j) {
        if (this.bqS != null) {
            this.bqS.aB(j);
        }
        if (this.bqS != null) {
            this.bqS.Qr();
        }
        this.bqJ = 1;
    }
}
