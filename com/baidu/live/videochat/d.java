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
    private BdUniqueId aQK;
    private com.baidu.live.videochat.a.a aYm;
    private com.baidu.live.videochat.a.b aYn;
    private f aYo;
    private com.baidu.live.o.f aYp;
    private AlaLiveInfoData aYq;
    private b aYr;
    private long aYx;
    private long aYy;
    private Activity mActivity;
    private volatile int aYf = 1;
    private boolean aYs = true;
    private boolean aYt = true;
    private boolean aYu = true;
    private boolean aYv = false;
    private boolean aYw = false;
    private volatile boolean aYz = false;
    private g aYA = new g() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.c.g
        public void GD() {
            if (d.this.aYo != null) {
                d.this.aYo.Hi();
            }
            if (d.this.aYr != null) {
                d.this.aYr.Go();
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void D(int i, String str) {
            if (d.this.aYf != 1) {
                d.this.aYf = 1;
                d.this.aYz = false;
                if (d.this.aYr != null) {
                    d.this.aYr.s(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void GE() {
            if (d.this.aYo != null) {
                d.this.aYo.Hk();
            }
            if (d.this.aYf != 1) {
                d.this.aYf = 1;
                d.this.aYz = false;
                if (d.this.aYr != null) {
                    d.this.aYr.Gp();
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (d.this.aYr != null) {
                    d.this.aYr.t(-100, "");
                }
            } else if (d.this.aYf != 3) {
                d.this.aYf = 3;
                if (d.this.aYo != null) {
                    d.this.aYo.Hk();
                }
                if (d.this.aYo != null) {
                    d.this.aYo.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.auw, aVar.apo, aVar.apq);
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void E(int i, String str) {
            if (d.this.aYr != null) {
                d.this.aYr.t(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (d.this.aYf != 2) {
                if (d.this.aYo != null) {
                    d.this.aYo.Hk();
                }
            } else if (i == 1) {
                d.this.GA();
            } else if (i != 2) {
                if (d.this.aYo != null) {
                    d.this.aYo.Hk();
                }
                if (d.this.aYf != 1) {
                    d.this.aYf = 1;
                    d.this.aYz = false;
                    if (d.this.aYr != null) {
                        d.this.aYr.u(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (d.this.aYo != null) {
                    d.this.aYo.Hk();
                }
                if (d.this.aYf != 1) {
                    d.this.aYf = 1;
                    d.this.aYz = false;
                    if (d.this.aYr != null) {
                        d.this.aYr.u(-100, str);
                    }
                }
            } else {
                d.this.aYf = 3;
                if (d.this.aYo != null) {
                    d.this.aYo.Hk();
                }
                if (d.this.aYo != null) {
                    d.this.aYo.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.auw, aVar.apo, aVar.apq);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.aYz = (bVar == null || bVar.GR() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            d.this.a(d.this.aYz, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.cg(true);
        }

        @Override // com.baidu.live.videochat.c.c
        public void Gz() {
            d.this.cg(false);
        }

        @Override // com.baidu.live.videochat.c.c
        public void C(int i, String str) {
            if (d.this.aYf != 1 && d.this.aYr != null) {
                d.this.aYr.v(i, str);
            }
        }
    };
    private CustomMessageListener aYB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                d.this.ch(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public d(Activity activity) {
        this.aYx = 0L;
        this.aYy = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.aQK = BdUniqueId.gen();
        this.aYm = new com.baidu.live.videochat.a.a(activity);
        this.aYm.a(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.d.1
            @Override // com.baidu.live.o.b
            public void bx(int i) {
            }
        });
        this.aYn = new com.baidu.live.videochat.a.b(activity);
        this.aYn.a(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.d.2
            @Override // com.baidu.live.o.b
            public void bx(int i) {
            }
        });
        this.aYo = new f(activity, this.aQK);
        this.aYo.a(this.aYA);
        this.aYo.a(this.aYm);
        MessageManager.getInstance().registerListener(this.aYB);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.aYy = com.baidu.live.c.tG().getLong(sharedPrefKeyWithAccount, 0L);
        this.aYx = com.baidu.live.c.tG().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void GA() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.aYz = true;
        if (this.aYp != null) {
            this.aYp.bM(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.tG().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.tG().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a = this.aYm.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.aYr != null) {
            if (a) {
                this.aYr.a(true, j, this.aYm.GH(), this.aYm.GI());
            } else {
                cg(true);
            }
        }
        return a;
    }

    private void GB() {
        if (this.aYm != null) {
            this.aYm.GF();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.aYn != null && !this.aYn.isStarted() && bVar != null && dVar2 != null) {
            this.aYn.d(dVar2.auw);
            if (this.aYr != null) {
                this.aYr.a(false, bVar.GP(), this.aYn.GH(), this.aYp.getLivePlayer());
            }
        }
    }

    private void GC() {
        if (!this.aYz && this.aYn != null) {
            this.aYn.GM();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.aYf != 4 && bVar != null && bVar.GQ() == 2) {
            this.aYf = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.aYr != null) {
                    this.aYr.a(z, bVar.GP(), dVar2.auk, z2);
                }
            } else if (this.aYm != null && !this.aYm.GG()) {
                a(z, bVar.GP(), bVar, dVar, dVar2);
            } else if (this.aYr != null) {
                this.aYr.a(z, bVar.GP(), dVar2.auk, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cg(boolean z) {
        if (this.aYo != null) {
            this.aYo.Hm();
        }
        if (this.aYf != 1) {
            this.aYf = 1;
            if (z) {
                if (this.aYz) {
                    GB();
                    if (this.aYr != null) {
                        this.aYr.cf(true);
                    }
                    this.aYp.b(this.aYq);
                } else {
                    GC();
                    if (this.aYr != null) {
                        this.aYr.cf(false);
                    }
                }
            } else {
                GB();
                if (this.aYr != null) {
                    this.aYr.cf(true);
                }
                this.aYp.b(this.aYq);
            }
            this.aYz = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ch(boolean z) {
        if (this.aYm != null) {
            if (z) {
                this.aYm.GJ();
            } else {
                this.aYm.GK();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.aYv && j == this.aYy && dVar2 != null && dVar2.auw != null && dVar != null && dVar.auw != null && dVar.auw.live_id == this.aYx && dVar2.aYX != null && dVar2.aYX.apq != null && dVar2.aYX.apo != null) {
            if (!this.aYw) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            au(bVar.GP());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.aYr != null) {
            this.aYw = this.aYr.a(dVar == null ? null : dVar.auk, new e() { // from class: com.baidu.live.videochat.d.5
            });
            if (!this.aYw && bVar != null) {
                au(bVar.GP());
            }
        }
    }

    private void au(long j) {
        if (this.aYo != null) {
            this.aYo.av(j);
        }
        if (this.aYo != null) {
            this.aYo.Hm();
        }
        this.aYf = 1;
    }
}
