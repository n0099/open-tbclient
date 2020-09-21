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
/* loaded from: classes4.dex */
public class d {
    private AlaLiveInfoData bgj;
    private BdUniqueId bhK;
    private com.baidu.live.videochat.a.a bui;
    private com.baidu.live.videochat.a.b buj;
    private f buk;
    private com.baidu.live.q.f bul;
    private b bum;
    private long bus;
    private long but;
    private Activity mActivity;
    private volatile int bua = 1;
    private boolean bun = true;
    private boolean buo = true;
    private boolean bup = true;
    private boolean buq = false;
    private boolean bur = false;
    private volatile boolean buu = false;
    private g buv = new g() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.c.g
        public void Qq() {
            if (d.this.buk != null) {
                d.this.buk.QV();
            }
            if (d.this.bum != null) {
                d.this.bum.Qb();
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void F(int i, String str) {
            if (d.this.bua != 1) {
                d.this.bua = 1;
                d.this.buu = false;
                if (d.this.bum != null) {
                    d.this.bum.u(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void Qr() {
            if (d.this.buk != null) {
                d.this.buk.QX();
            }
            if (d.this.bua != 1) {
                d.this.bua = 1;
                d.this.buu = false;
                if (d.this.bum != null) {
                    d.this.bum.Qc();
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (d.this.bum != null) {
                    d.this.bum.v(-100, "");
                }
            } else if (d.this.bua != 3) {
                d.this.bua = 3;
                if (d.this.buk != null) {
                    d.this.buk.QX();
                }
                if (d.this.buk != null) {
                    d.this.buk.c(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aJW, aVar.aDc, aVar.aDd);
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void G(int i, String str) {
            if (d.this.bum != null) {
                d.this.bum.v(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (d.this.bua != 2) {
                if (d.this.buk != null) {
                    d.this.buk.QX();
                }
            } else if (i == 1) {
                d.this.Qn();
            } else if (i != 2) {
                if (d.this.buk != null) {
                    d.this.buk.QX();
                }
                if (d.this.bua != 1) {
                    d.this.bua = 1;
                    d.this.buu = false;
                    if (d.this.bum != null) {
                        d.this.bum.w(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (d.this.buk != null) {
                    d.this.buk.QX();
                }
                if (d.this.bua != 1) {
                    d.this.bua = 1;
                    d.this.buu = false;
                    if (d.this.bum != null) {
                        d.this.bum.w(-100, str);
                    }
                }
            } else {
                d.this.bua = 3;
                if (d.this.buk != null) {
                    d.this.buk.QX();
                }
                if (d.this.buk != null) {
                    d.this.buk.c(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aJW, aVar.aDc, aVar.aDd);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.buu = (bVar == null || bVar.QE() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            d.this.a(d.this.buu, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.cK(true);
        }

        @Override // com.baidu.live.videochat.c.c
        public void Qm() {
            d.this.cK(false);
        }

        @Override // com.baidu.live.videochat.c.c
        public void E(int i, String str) {
            if (d.this.bua != 1 && d.this.bum != null) {
                d.this.bum.x(i, str);
            }
        }
    };
    private CustomMessageListener buw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                d.this.cL(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public d(Activity activity) {
        this.bus = 0L;
        this.but = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.bhK = BdUniqueId.gen();
        this.bui = new com.baidu.live.videochat.a.a(activity);
        this.bui.a(new com.baidu.live.q.b() { // from class: com.baidu.live.videochat.d.1
            @Override // com.baidu.live.q.b
            public void dH(int i) {
            }
        });
        this.buj = new com.baidu.live.videochat.a.b(activity);
        this.buj.a(new com.baidu.live.q.b() { // from class: com.baidu.live.videochat.d.2
            @Override // com.baidu.live.q.b
            public void dH(int i) {
            }
        });
        this.buk = new f(activity, this.bhK);
        this.buk.a(this.buv);
        this.buk.a(this.bui);
        MessageManager.getInstance().registerListener(this.buw);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.but = com.baidu.live.c.AR().getLong(sharedPrefKeyWithAccount, 0L);
        this.bus = com.baidu.live.c.AR().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Qn() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.buu = true;
        if (this.bul != null) {
            this.bul.ci(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.AR().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.AR().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a = this.bui.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bum != null) {
            if (a) {
                this.bum.a(true, j, this.bui.Qu(), this.bui.Qv());
            } else {
                cK(true);
            }
        }
        return a;
    }

    private void Qo() {
        if (this.bui != null) {
            this.bui.Qs();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.buj != null && !this.buj.isStarted() && bVar != null && dVar2 != null) {
            this.buj.e(dVar2.aJW);
            if (this.bum != null) {
                this.bum.a(false, bVar.QC(), this.buj.Qu(), this.bul.getLivePlayer());
            }
        }
    }

    private void Qp() {
        if (!this.buu && this.buj != null) {
            this.buj.Qz();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bua != 4 && bVar != null && bVar.QD() == 2) {
            this.bua = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bum != null) {
                    this.bum.a(z, bVar.QC(), dVar2.aJI, z2);
                }
            } else if (this.bui != null && !this.bui.Qt()) {
                a(z, bVar.QC(), bVar, dVar, dVar2);
            } else if (this.bum != null) {
                this.bum.a(z, bVar.QC(), dVar2.aJI, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cK(boolean z) {
        if (this.buk != null) {
            this.buk.QZ();
        }
        if (this.bua != 1) {
            this.bua = 1;
            if (z) {
                if (this.buu) {
                    Qo();
                    if (this.bum != null) {
                        this.bum.cJ(true);
                    }
                    this.bul.c(this.bgj);
                } else {
                    Qp();
                    if (this.bum != null) {
                        this.bum.cJ(false);
                    }
                }
            } else {
                Qo();
                if (this.bum != null) {
                    this.bum.cJ(true);
                }
                this.bul.c(this.bgj);
            }
            this.buu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cL(boolean z) {
        if (this.bui != null) {
            if (z) {
                this.bui.Qw();
            } else {
                this.bui.Qx();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.buq && j == this.but && dVar2 != null && dVar2.aJW != null && dVar != null && dVar.aJW != null && dVar.aJW.live_id == this.bus && dVar2.buS != null && dVar2.buS.aDd != null && dVar2.buS.aDc != null) {
            if (!this.bur) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            aA(bVar.QC());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bum != null) {
            this.bur = this.bum.a(dVar == null ? null : dVar.aJI, new e() { // from class: com.baidu.live.videochat.d.5
            });
            if (!this.bur && bVar != null) {
                aA(bVar.QC());
            }
        }
    }

    private void aA(long j) {
        if (this.buk != null) {
            this.buk.aB(j);
        }
        if (this.buk != null) {
            this.buk.QZ();
        }
        this.bua = 1;
    }
}
