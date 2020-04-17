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
/* loaded from: classes3.dex */
public class d {
    private BdUniqueId aQF;
    private com.baidu.live.videochat.a.a aYh;
    private com.baidu.live.videochat.a.b aYi;
    private f aYj;
    private com.baidu.live.o.f aYk;
    private AlaLiveInfoData aYl;
    private b aYm;
    private long aYs;
    private long aYt;
    private Activity mActivity;
    private volatile int aYa = 1;
    private boolean aYn = true;
    private boolean aYo = true;
    private boolean aYp = true;
    private boolean aYq = false;
    private boolean aYr = false;
    private volatile boolean aYu = false;
    private g aYv = new g() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.c.g
        public void GE() {
            if (d.this.aYj != null) {
                d.this.aYj.Hj();
            }
            if (d.this.aYm != null) {
                d.this.aYm.Gp();
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void D(int i, String str) {
            if (d.this.aYa != 1) {
                d.this.aYa = 1;
                d.this.aYu = false;
                if (d.this.aYm != null) {
                    d.this.aYm.s(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void GF() {
            if (d.this.aYj != null) {
                d.this.aYj.Hl();
            }
            if (d.this.aYa != 1) {
                d.this.aYa = 1;
                d.this.aYu = false;
                if (d.this.aYm != null) {
                    d.this.aYm.Gq();
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (d.this.aYm != null) {
                    d.this.aYm.t(-100, "");
                }
            } else if (d.this.aYa != 3) {
                d.this.aYa = 3;
                if (d.this.aYj != null) {
                    d.this.aYj.Hl();
                }
                if (d.this.aYj != null) {
                    d.this.aYj.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.auq, aVar.api, aVar.apj);
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void E(int i, String str) {
            if (d.this.aYm != null) {
                d.this.aYm.t(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (d.this.aYa != 2) {
                if (d.this.aYj != null) {
                    d.this.aYj.Hl();
                }
            } else if (i == 1) {
                d.this.GB();
            } else if (i != 2) {
                if (d.this.aYj != null) {
                    d.this.aYj.Hl();
                }
                if (d.this.aYa != 1) {
                    d.this.aYa = 1;
                    d.this.aYu = false;
                    if (d.this.aYm != null) {
                        d.this.aYm.u(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (d.this.aYj != null) {
                    d.this.aYj.Hl();
                }
                if (d.this.aYa != 1) {
                    d.this.aYa = 1;
                    d.this.aYu = false;
                    if (d.this.aYm != null) {
                        d.this.aYm.u(-100, str);
                    }
                }
            } else {
                d.this.aYa = 3;
                if (d.this.aYj != null) {
                    d.this.aYj.Hl();
                }
                if (d.this.aYj != null) {
                    d.this.aYj.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.auq, aVar.api, aVar.apj);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.aYu = (bVar == null || bVar.GS() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            d.this.a(d.this.aYu, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.cg(true);
        }

        @Override // com.baidu.live.videochat.c.c
        public void GA() {
            d.this.cg(false);
        }

        @Override // com.baidu.live.videochat.c.c
        public void C(int i, String str) {
            if (d.this.aYa != 1 && d.this.aYm != null) {
                d.this.aYm.v(i, str);
            }
        }
    };
    private CustomMessageListener aYw = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                d.this.ch(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public d(Activity activity) {
        this.aYs = 0L;
        this.aYt = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.aQF = BdUniqueId.gen();
        this.aYh = new com.baidu.live.videochat.a.a(activity);
        this.aYh.a(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.d.1
            @Override // com.baidu.live.o.b
            public void bx(int i) {
            }
        });
        this.aYi = new com.baidu.live.videochat.a.b(activity);
        this.aYi.a(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.d.2
            @Override // com.baidu.live.o.b
            public void bx(int i) {
            }
        });
        this.aYj = new f(activity, this.aQF);
        this.aYj.a(this.aYv);
        this.aYj.a(this.aYh);
        MessageManager.getInstance().registerListener(this.aYw);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.aYt = com.baidu.live.c.tH().getLong(sharedPrefKeyWithAccount, 0L);
        this.aYs = com.baidu.live.c.tH().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GB() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.aYu = true;
        if (this.aYk != null) {
            this.aYk.bM(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.tH().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.tH().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a = this.aYh.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.aYm != null) {
            if (a) {
                this.aYm.a(true, j, this.aYh.GI(), this.aYh.GJ());
            } else {
                cg(true);
            }
        }
        return a;
    }

    private void GC() {
        if (this.aYh != null) {
            this.aYh.GG();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.aYi != null && !this.aYi.isStarted() && bVar != null && dVar2 != null) {
            this.aYi.d(dVar2.auq);
            if (this.aYm != null) {
                this.aYm.a(false, bVar.GQ(), this.aYi.GI(), this.aYk.getLivePlayer());
            }
        }
    }

    private void GD() {
        if (!this.aYu && this.aYi != null) {
            this.aYi.GN();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.aYa != 4 && bVar != null && bVar.GR() == 2) {
            this.aYa = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.aYm != null) {
                    this.aYm.a(z, bVar.GQ(), dVar2.aue, z2);
                }
            } else if (this.aYh != null && !this.aYh.GH()) {
                a(z, bVar.GQ(), bVar, dVar, dVar2);
            } else if (this.aYm != null) {
                this.aYm.a(z, bVar.GQ(), dVar2.aue, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        if (this.aYj != null) {
            this.aYj.Hn();
        }
        if (this.aYa != 1) {
            this.aYa = 1;
            if (z) {
                if (this.aYu) {
                    GC();
                    if (this.aYm != null) {
                        this.aYm.cf(true);
                    }
                    this.aYk.b(this.aYl);
                } else {
                    GD();
                    if (this.aYm != null) {
                        this.aYm.cf(false);
                    }
                }
            } else {
                GC();
                if (this.aYm != null) {
                    this.aYm.cf(true);
                }
                this.aYk.b(this.aYl);
            }
            this.aYu = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        if (this.aYh != null) {
            if (z) {
                this.aYh.GK();
            } else {
                this.aYh.GL();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.aYq && j == this.aYt && dVar2 != null && dVar2.auq != null && dVar != null && dVar.auq != null && dVar.auq.live_id == this.aYs && dVar2.aYS != null && dVar2.aYS.apj != null && dVar2.aYS.api != null) {
            if (!this.aYr) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            au(bVar.GQ());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.aYm != null) {
            this.aYr = this.aYm.a(dVar == null ? null : dVar.aue, new e() { // from class: com.baidu.live.videochat.d.5
            });
            if (!this.aYr && bVar != null) {
                au(bVar.GQ());
            }
        }
    }

    private void au(long j) {
        if (this.aYj != null) {
            this.aYj.av(j);
        }
        if (this.aYj != null) {
            this.aYj.Hn();
        }
        this.aYa = 1;
    }
}
