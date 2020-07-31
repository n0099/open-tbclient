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
    private AlaLiveInfoData aYc;
    private BdUniqueId aZB;
    private com.baidu.live.videochat.a.a blk;
    private com.baidu.live.videochat.a.b bll;
    private f blm;
    private com.baidu.live.p.f bln;
    private b blo;
    private long blu;
    private long blv;
    private Activity mActivity;
    private volatile int bld = 1;
    private boolean blp = true;
    private boolean blq = true;
    private boolean blr = true;
    private boolean bls = false;
    private boolean blt = false;
    private volatile boolean blw = false;
    private g blx = new g() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.c.g
        public void JQ() {
            if (d.this.blm != null) {
                d.this.blm.Kv();
            }
            if (d.this.blo != null) {
                d.this.blo.JB();
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void F(int i, String str) {
            if (d.this.bld != 1) {
                d.this.bld = 1;
                d.this.blw = false;
                if (d.this.blo != null) {
                    d.this.blo.u(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void JR() {
            if (d.this.blm != null) {
                d.this.blm.Kx();
            }
            if (d.this.bld != 1) {
                d.this.bld = 1;
                d.this.blw = false;
                if (d.this.blo != null) {
                    d.this.blo.JC();
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (d.this.blo != null) {
                    d.this.blo.v(-100, "");
                }
            } else if (d.this.bld != 3) {
                d.this.bld = 3;
                if (d.this.blm != null) {
                    d.this.blm.Kx();
                }
                if (d.this.blm != null) {
                    d.this.blm.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aDu, aVar.axp, aVar.axq);
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void G(int i, String str) {
            if (d.this.blo != null) {
                d.this.blo.v(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (d.this.bld != 2) {
                if (d.this.blm != null) {
                    d.this.blm.Kx();
                }
            } else if (i == 1) {
                d.this.JN();
            } else if (i != 2) {
                if (d.this.blm != null) {
                    d.this.blm.Kx();
                }
                if (d.this.bld != 1) {
                    d.this.bld = 1;
                    d.this.blw = false;
                    if (d.this.blo != null) {
                        d.this.blo.w(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (d.this.blm != null) {
                    d.this.blm.Kx();
                }
                if (d.this.bld != 1) {
                    d.this.bld = 1;
                    d.this.blw = false;
                    if (d.this.blo != null) {
                        d.this.blo.w(-100, str);
                    }
                }
            } else {
                d.this.bld = 3;
                if (d.this.blm != null) {
                    d.this.blm.Kx();
                }
                if (d.this.blm != null) {
                    d.this.blm.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aDu, aVar.axp, aVar.axq);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.blw = (bVar == null || bVar.Ke() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            d.this.a(d.this.blw, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.cA(true);
        }

        @Override // com.baidu.live.videochat.c.c
        public void JM() {
            d.this.cA(false);
        }

        @Override // com.baidu.live.videochat.c.c
        public void E(int i, String str) {
            if (d.this.bld != 1 && d.this.blo != null) {
                d.this.blo.x(i, str);
            }
        }
    };
    private CustomMessageListener bly = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                d.this.cB(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public d(Activity activity) {
        this.blu = 0L;
        this.blv = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.aZB = BdUniqueId.gen();
        this.blk = new com.baidu.live.videochat.a.a(activity);
        this.blk.a(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.d.1
            @Override // com.baidu.live.p.b
            public void bR(int i) {
            }
        });
        this.bll = new com.baidu.live.videochat.a.b(activity);
        this.bll.a(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.d.2
            @Override // com.baidu.live.p.b
            public void bR(int i) {
            }
        });
        this.blm = new f(activity, this.aZB);
        this.blm.a(this.blx);
        this.blm.a(this.blk);
        MessageManager.getInstance().registerListener(this.bly);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.blv = com.baidu.live.c.vf().getLong(sharedPrefKeyWithAccount, 0L);
        this.blu = com.baidu.live.c.vf().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JN() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.blw = true;
        if (this.bln != null) {
            this.bln.bZ(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.vf().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.vf().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a = this.blk.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.blo != null) {
            if (a) {
                this.blo.a(true, j, this.blk.JU(), this.blk.JV());
            } else {
                cA(true);
            }
        }
        return a;
    }

    private void JO() {
        if (this.blk != null) {
            this.blk.JS();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bll != null && !this.bll.isStarted() && bVar != null && dVar2 != null) {
            this.bll.e(dVar2.aDu);
            if (this.blo != null) {
                this.blo.a(false, bVar.Kc(), this.bll.JU(), this.bln.getLivePlayer());
            }
        }
    }

    private void JP() {
        if (!this.blw && this.bll != null) {
            this.bll.JZ();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bld != 4 && bVar != null && bVar.Kd() == 2) {
            this.bld = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.blo != null) {
                    this.blo.a(z, bVar.Kc(), dVar2.aDb, z2);
                }
            } else if (this.blk != null && !this.blk.JT()) {
                a(z, bVar.Kc(), bVar, dVar, dVar2);
            } else if (this.blo != null) {
                this.blo.a(z, bVar.Kc(), dVar2.aDb, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cA(boolean z) {
        if (this.blm != null) {
            this.blm.Kz();
        }
        if (this.bld != 1) {
            this.bld = 1;
            if (z) {
                if (this.blw) {
                    JO();
                    if (this.blo != null) {
                        this.blo.cz(true);
                    }
                    this.bln.c(this.aYc);
                } else {
                    JP();
                    if (this.blo != null) {
                        this.blo.cz(false);
                    }
                }
            } else {
                JO();
                if (this.blo != null) {
                    this.blo.cz(true);
                }
                this.bln.c(this.aYc);
            }
            this.blw = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cB(boolean z) {
        if (this.blk != null) {
            if (z) {
                this.blk.JW();
            } else {
                this.blk.JX();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bls && j == this.blv && dVar2 != null && dVar2.aDu != null && dVar != null && dVar.aDu != null && dVar.aDu.live_id == this.blu && dVar2.blU != null && dVar2.blU.axq != null && dVar2.blU.axp != null) {
            if (!this.blt) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            az(bVar.Kc());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.blo != null) {
            this.blt = this.blo.a(dVar == null ? null : dVar.aDb, new e() { // from class: com.baidu.live.videochat.d.5
            });
            if (!this.blt && bVar != null) {
                az(bVar.Kc());
            }
        }
    }

    private void az(long j) {
        if (this.blm != null) {
            this.blm.aA(j);
        }
        if (this.blm != null) {
            this.blm.Kz();
        }
        this.bld = 1;
    }
}
