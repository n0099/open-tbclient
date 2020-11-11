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
    private com.baidu.live.videochat.a.a bHo;
    private com.baidu.live.videochat.a.b bHp;
    private com.baidu.live.videochat.e.f bHq;
    private b bHr;
    private long bHx;
    private long bHy;
    private AlaLiveInfoData bmO;
    private BdUniqueId bou;
    private com.baidu.live.s.f bvi;
    private Activity mActivity;
    private volatile int byk = 1;
    private boolean bHs = true;
    private boolean bHt = true;
    private boolean bHu = true;
    private boolean bHv = false;
    private boolean bHw = false;
    private volatile boolean bHz = false;
    private com.baidu.live.videochat.e.g bHA = new com.baidu.live.videochat.e.g() { // from class: com.baidu.live.videochat.f.3
        @Override // com.baidu.live.videochat.e.g
        public void Vu() {
            if (f.this.bHq != null) {
                f.this.bHq.Wd();
            }
            if (f.this.bHr != null) {
                f.this.bHr.UV();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void N(int i, String str) {
            if (f.this.byk != 1) {
                f.this.byk = 1;
                f.this.bHz = false;
                if (f.this.bHr != null) {
                    f.this.bHr.C(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void Vv() {
            if (f.this.bHq != null) {
                f.this.bHq.Wf();
            }
            if (f.this.byk != 1) {
                f.this.byk = 1;
                f.this.bHz = false;
                if (f.this.bHr != null) {
                    f.this.bHr.Re();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (f.this.bHr != null) {
                    f.this.bHr.D(-100, "");
                }
            } else if (f.this.byk != 3) {
                f.this.byk = 3;
                if (f.this.bHq != null) {
                    f.this.bHq.Wf();
                }
                if (f.this.bHq != null) {
                    f.this.bHq.c(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aOJ, aVar.aHf, aVar.aHg);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void O(int i, String str) {
            if (f.this.bHr != null) {
                f.this.bHr.D(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (f.this.byk != 2) {
                if (f.this.bHq != null) {
                    f.this.bHq.Wf();
                }
            } else if (i == 1) {
                f.this.Vr();
            } else if (i != 2) {
                if (f.this.bHq != null) {
                    f.this.bHq.Wf();
                }
                if (f.this.byk != 1) {
                    f.this.byk = 1;
                    f.this.bHz = false;
                    if (f.this.bHr != null) {
                        f.this.bHr.E(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (f.this.bHq != null) {
                    f.this.bHq.Wf();
                }
                if (f.this.byk != 1) {
                    f.this.byk = 1;
                    f.this.bHz = false;
                    if (f.this.bHr != null) {
                        f.this.bHr.E(-100, str);
                    }
                }
            } else {
                f.this.byk = 3;
                if (f.this.bHq != null) {
                    f.this.bHq.Wf();
                }
                if (f.this.bHq != null) {
                    f.this.bHq.c(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aOJ, aVar.aHf, aVar.aHg);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.bHz = (bVar == null || bVar.VF() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            f.this.a(f.this.bHz, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.da(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void Vq() {
            f.this.da(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void M(int i, String str) {
            if (f.this.byk != 1 && f.this.bHr != null) {
                f.this.bHr.F(i, str);
            }
        }
    };
    private CustomMessageListener bHB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                f.this.db(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public f(Activity activity) {
        this.bHx = 0L;
        this.bHy = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.bou = BdUniqueId.gen();
        this.bHo = new com.baidu.live.videochat.a.a(activity);
        this.bHo.a(new com.baidu.live.s.b() { // from class: com.baidu.live.videochat.f.1
            @Override // com.baidu.live.s.b
            public void dM(int i) {
            }
        });
        this.bHp = new com.baidu.live.videochat.a.b(activity);
        this.bHp.a(new com.baidu.live.s.b() { // from class: com.baidu.live.videochat.f.2
            @Override // com.baidu.live.s.b
            public void dM(int i) {
            }
        });
        this.bHq = new com.baidu.live.videochat.e.f(activity, this.bou);
        this.bHq.a(this.bHA);
        this.bHq.a(this.bHo);
        MessageManager.getInstance().registerListener(this.bHB);
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bHy = com.baidu.live.d.AZ().getLong(sharedPrefKeyWithAccount, 0L);
        this.bHx = com.baidu.live.d.AZ().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Vr() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bHz = true;
        if (this.bvi != null) {
            this.bvi.co(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.d.AZ().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.d.AZ().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.bHo.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bHr != null) {
            if (a2) {
                this.bHr.a(true, j, this.bHo.Vy(), this.bHo.Vz());
            } else {
                da(true);
            }
        }
        return a2;
    }

    private void Vs() {
        if (this.bHo != null) {
            this.bHo.Vw();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bHp != null && !this.bHp.isStarted() && bVar != null && dVar2 != null) {
            this.bHp.e(dVar2.aOJ);
            if (this.bHr != null) {
                this.bHr.a(false, bVar.VE(), this.bHp.Vy(), this.bvi.getLivePlayer());
            }
        }
    }

    private void Vt() {
        if (!this.bHz && this.bHp != null) {
            this.bHp.VC();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.byk != 4 && bVar != null && bVar.Sn() == 2) {
            this.byk = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bHr != null) {
                    this.bHr.a(z, bVar.VE(), dVar2.aOv, z2);
                }
            } else if (this.bHo != null && !this.bHo.Vx()) {
                a(z, bVar.VE(), bVar, dVar, dVar2);
            } else if (this.bHr != null) {
                this.bHr.a(z, bVar.VE(), dVar2.aOv, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void da(boolean z) {
        if (this.bHq != null) {
            this.bHq.Wh();
        }
        if (this.byk != 1) {
            this.byk = 1;
            if (z) {
                if (this.bHz) {
                    Vs();
                    if (this.bHr != null) {
                        this.bHr.cZ(true);
                    }
                    this.bvi.c(this.bmO);
                } else {
                    Vt();
                    if (this.bHr != null) {
                        this.bHr.cZ(false);
                    }
                }
            } else {
                Vs();
                if (this.bHr != null) {
                    this.bHr.cZ(true);
                }
                this.bvi.c(this.bmO);
            }
            this.bHz = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void db(boolean z) {
        if (this.bHo != null) {
            if (z) {
                this.bHo.VA();
            } else {
                this.bHo.VB();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bHv && j == this.bHy && dVar2 != null && dVar2.aOJ != null && dVar != null && dVar.aOJ != null && dVar.aOJ.live_id == this.bHx && dVar2.bHW != null && dVar2.bHW.aHg != null && dVar2.bHW.aHf != null) {
            if (!this.bHw) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            aZ(bVar.VE());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bHr != null) {
            this.bHw = this.bHr.a(dVar == null ? null : dVar.aOv, new g() { // from class: com.baidu.live.videochat.f.5
            });
            if (!this.bHw && bVar != null) {
                aZ(bVar.VE());
            }
        }
    }

    private void aZ(long j) {
        if (this.bHq != null) {
            this.bHq.bb(j);
        }
        if (this.bHq != null) {
            this.bHq.Wh();
        }
        this.byk = 1;
    }
}
