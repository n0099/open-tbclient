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
    private AlaLiveInfoData bdu;
    private BdUniqueId beX;
    private com.baidu.live.videochat.a.a bqT;
    private com.baidu.live.videochat.a.b bqU;
    private f bqV;
    private com.baidu.live.p.f bqW;
    private b bqX;
    private long brd;
    private long bre;
    private Activity mActivity;
    private volatile int bqM = 1;
    private boolean bqY = true;
    private boolean bqZ = true;
    private boolean bra = true;
    private boolean brb = false;
    private boolean brc = false;
    private volatile boolean brf = false;
    private g brg = new g() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.c.g
        public void PI() {
            if (d.this.bqV != null) {
                d.this.bqV.Qn();
            }
            if (d.this.bqX != null) {
                d.this.bqX.Pt();
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void E(int i, String str) {
            if (d.this.bqM != 1) {
                d.this.bqM = 1;
                d.this.brf = false;
                if (d.this.bqX != null) {
                    d.this.bqX.t(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void PJ() {
            if (d.this.bqV != null) {
                d.this.bqV.Qp();
            }
            if (d.this.bqM != 1) {
                d.this.bqM = 1;
                d.this.brf = false;
                if (d.this.bqX != null) {
                    d.this.bqX.Pu();
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (d.this.bqX != null) {
                    d.this.bqX.u(-100, "");
                }
            } else if (d.this.bqM != 3) {
                d.this.bqM = 3;
                if (d.this.bqV != null) {
                    d.this.bqV.Qp();
                }
                if (d.this.bqV != null) {
                    d.this.bqV.b(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aIG, aVar.aCt, aVar.aCu);
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void F(int i, String str) {
            if (d.this.bqX != null) {
                d.this.bqX.u(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (d.this.bqM != 2) {
                if (d.this.bqV != null) {
                    d.this.bqV.Qp();
                }
            } else if (i == 1) {
                d.this.PF();
            } else if (i != 2) {
                if (d.this.bqV != null) {
                    d.this.bqV.Qp();
                }
                if (d.this.bqM != 1) {
                    d.this.bqM = 1;
                    d.this.brf = false;
                    if (d.this.bqX != null) {
                        d.this.bqX.v(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (d.this.bqV != null) {
                    d.this.bqV.Qp();
                }
                if (d.this.bqM != 1) {
                    d.this.bqM = 1;
                    d.this.brf = false;
                    if (d.this.bqX != null) {
                        d.this.bqX.v(-100, str);
                    }
                }
            } else {
                d.this.bqM = 3;
                if (d.this.bqV != null) {
                    d.this.bqV.Qp();
                }
                if (d.this.bqV != null) {
                    d.this.bqV.b(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aIG, aVar.aCt, aVar.aCu);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.brf = (bVar == null || bVar.PW() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            d.this.a(d.this.brf, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.cJ(true);
        }

        @Override // com.baidu.live.videochat.c.c
        public void PE() {
            d.this.cJ(false);
        }

        @Override // com.baidu.live.videochat.c.c
        public void D(int i, String str) {
            if (d.this.bqM != 1 && d.this.bqX != null) {
                d.this.bqX.w(i, str);
            }
        }
    };
    private CustomMessageListener brh = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                d.this.cK(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public d(Activity activity) {
        this.brd = 0L;
        this.bre = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.beX = BdUniqueId.gen();
        this.bqT = new com.baidu.live.videochat.a.a(activity);
        this.bqT.a(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.d.1
            @Override // com.baidu.live.p.b
            public void dD(int i) {
            }
        });
        this.bqU = new com.baidu.live.videochat.a.b(activity);
        this.bqU.a(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.d.2
            @Override // com.baidu.live.p.b
            public void dD(int i) {
            }
        });
        this.bqV = new f(activity, this.beX);
        this.bqV.a(this.brg);
        this.bqV.a(this.bqT);
        MessageManager.getInstance().registerListener(this.brh);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bre = com.baidu.live.c.AD().getLong(sharedPrefKeyWithAccount, 0L);
        this.brd = com.baidu.live.c.AD().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void PF() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.brf = true;
        if (this.bqW != null) {
            this.bqW.ch(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.AD().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.AD().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a = this.bqT.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bqX != null) {
            if (a) {
                this.bqX.a(true, j, this.bqT.PM(), this.bqT.PN());
            } else {
                cJ(true);
            }
        }
        return a;
    }

    private void PG() {
        if (this.bqT != null) {
            this.bqT.PK();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bqU != null && !this.bqU.isStarted() && bVar != null && dVar2 != null) {
            this.bqU.e(dVar2.aIG);
            if (this.bqX != null) {
                this.bqX.a(false, bVar.PU(), this.bqU.PM(), this.bqW.getLivePlayer());
            }
        }
    }

    private void PH() {
        if (!this.brf && this.bqU != null) {
            this.bqU.PR();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bqM != 4 && bVar != null && bVar.PV() == 2) {
            this.bqM = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bqX != null) {
                    this.bqX.a(z, bVar.PU(), dVar2.aIn, z2);
                }
            } else if (this.bqT != null && !this.bqT.PL()) {
                a(z, bVar.PU(), bVar, dVar, dVar2);
            } else if (this.bqX != null) {
                this.bqX.a(z, bVar.PU(), dVar2.aIn, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cJ(boolean z) {
        if (this.bqV != null) {
            this.bqV.Qr();
        }
        if (this.bqM != 1) {
            this.bqM = 1;
            if (z) {
                if (this.brf) {
                    PG();
                    if (this.bqX != null) {
                        this.bqX.cI(true);
                    }
                    this.bqW.c(this.bdu);
                } else {
                    PH();
                    if (this.bqX != null) {
                        this.bqX.cI(false);
                    }
                }
            } else {
                PG();
                if (this.bqX != null) {
                    this.bqX.cI(true);
                }
                this.bqW.c(this.bdu);
            }
            this.brf = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(boolean z) {
        if (this.bqT != null) {
            if (z) {
                this.bqT.PO();
            } else {
                this.bqT.PP();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.brb && j == this.bre && dVar2 != null && dVar2.aIG != null && dVar != null && dVar.aIG != null && dVar.aIG.live_id == this.brd && dVar2.brD != null && dVar2.brD.aCu != null && dVar2.brD.aCt != null) {
            if (!this.brc) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            aA(bVar.PU());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bqX != null) {
            this.brc = this.bqX.a(dVar == null ? null : dVar.aIn, new e() { // from class: com.baidu.live.videochat.d.5
            });
            if (!this.brc && bVar != null) {
                aA(bVar.PU());
            }
        }
    }

    private void aA(long j) {
        if (this.bqV != null) {
            this.bqV.aB(j);
        }
        if (this.bqV != null) {
            this.bqV.Qr();
        }
        this.bqM = 1;
    }
}
