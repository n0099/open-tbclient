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
import com.baidu.live.videochat.e.g;
/* loaded from: classes4.dex */
public class e {
    private com.baidu.live.videochat.a.a bBh;
    private com.baidu.live.videochat.a.b bBi;
    private com.baidu.live.videochat.e.f bBj;
    private com.baidu.live.r.f bBk;
    private b bBl;
    private long bBr;
    private long bBs;
    private AlaLiveInfoData blu;
    private BdUniqueId bnb;
    private Activity mActivity;
    private volatile int bBa = 1;
    private boolean bBm = true;
    private boolean bBn = true;
    private boolean bBo = true;
    private boolean bBp = false;
    private boolean bBq = false;
    private volatile boolean bBt = false;
    private g bBu = new g() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.g
        public void SN() {
            if (e.this.bBj != null) {
                e.this.bBj.TD();
            }
            if (e.this.bBl != null) {
                e.this.bBl.Sm();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void J(int i, String str) {
            if (e.this.bBa != 1) {
                e.this.bBa = 1;
                e.this.bBt = false;
                if (e.this.bBl != null) {
                    e.this.bBl.y(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void SO() {
            if (e.this.bBj != null) {
                e.this.bBj.TF();
            }
            if (e.this.bBa != 1) {
                e.this.bBa = 1;
                e.this.bBt = false;
                if (e.this.bBl != null) {
                    e.this.bBl.Sn();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (e.this.bBl != null) {
                    e.this.bBl.z(-100, "");
                }
            } else if (e.this.bBa != 3) {
                e.this.bBa = 3;
                if (e.this.bBj != null) {
                    e.this.bBj.TF();
                }
                if (e.this.bBj != null) {
                    e.this.bBj.c(aVar.chatId, false);
                }
                e.this.a(alaLiveInfoData, aVar.chatId, aVar.aNG, aVar.aGp, aVar.aGq);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void K(int i, String str) {
            if (e.this.bBl != null) {
                e.this.bBl.z(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (e.this.bBa != 2) {
                if (e.this.bBj != null) {
                    e.this.bBj.TF();
                }
            } else if (i == 1) {
                e.this.SK();
            } else if (i != 2) {
                if (e.this.bBj != null) {
                    e.this.bBj.TF();
                }
                if (e.this.bBa != 1) {
                    e.this.bBa = 1;
                    e.this.bBt = false;
                    if (e.this.bBl != null) {
                        e.this.bBl.A(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (e.this.bBj != null) {
                    e.this.bBj.TF();
                }
                if (e.this.bBa != 1) {
                    e.this.bBa = 1;
                    e.this.bBt = false;
                    if (e.this.bBl != null) {
                        e.this.bBl.A(-100, str);
                    }
                }
            } else {
                e.this.bBa = 3;
                if (e.this.bBj != null) {
                    e.this.bBj.TF();
                }
                if (e.this.bBj != null) {
                    e.this.bBj.c(aVar.chatId, false);
                }
                e.this.a(alaLiveInfoData, aVar.chatId, aVar.aNG, aVar.aGp, aVar.aGq);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.bBt = (bVar == null || bVar.Tb() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            e.this.a(e.this.bBt, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.cT(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void SJ() {
            e.this.cT(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void I(int i, String str) {
            if (e.this.bBa != 1 && e.this.bBl != null) {
                e.this.bBl.B(i, str);
            }
        }
    };
    private CustomMessageListener bBv = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                e.this.cU(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public e(Activity activity) {
        this.bBr = 0L;
        this.bBs = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.bnb = BdUniqueId.gen();
        this.bBh = new com.baidu.live.videochat.a.a(activity);
        this.bBh.a(new com.baidu.live.r.b() { // from class: com.baidu.live.videochat.e.1
            @Override // com.baidu.live.r.b
            public void dM(int i) {
            }
        });
        this.bBi = new com.baidu.live.videochat.a.b(activity);
        this.bBi.a(new com.baidu.live.r.b() { // from class: com.baidu.live.videochat.e.2
            @Override // com.baidu.live.r.b
            public void dM(int i) {
            }
        });
        this.bBj = new com.baidu.live.videochat.e.f(activity, this.bnb);
        this.bBj.a(this.bBu);
        this.bBj.a(this.bBh);
        MessageManager.getInstance().registerListener(this.bBv);
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bBs = com.baidu.live.d.AZ().getLong(sharedPrefKeyWithAccount, 0L);
        this.bBr = com.baidu.live.d.AZ().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void SK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bBt = true;
        if (this.bBk != null) {
            this.bBk.cn(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.d.AZ().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.d.AZ().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.bBh.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bBl != null) {
            if (a2) {
                this.bBl.a(true, j, this.bBh.SR(), this.bBh.SS());
            } else {
                cT(true);
            }
        }
        return a2;
    }

    private void SL() {
        if (this.bBh != null) {
            this.bBh.SP();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bBi != null && !this.bBi.isStarted() && bVar != null && dVar2 != null) {
            this.bBi.e(dVar2.aNG);
            if (this.bBl != null) {
                this.bBl.a(false, bVar.SZ(), this.bBi.SR(), this.bBk.getLivePlayer());
            }
        }
    }

    private void SM() {
        if (!this.bBt && this.bBi != null) {
            this.bBi.SW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bBa != 4 && bVar != null && bVar.Ta() == 2) {
            this.bBa = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bBl != null) {
                    this.bBl.a(z, bVar.SZ(), dVar2.aNs, z2);
                }
            } else if (this.bBh != null && !this.bBh.SQ()) {
                a(z, bVar.SZ(), bVar, dVar, dVar2);
            } else if (this.bBl != null) {
                this.bBl.a(z, bVar.SZ(), dVar2.aNs, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cT(boolean z) {
        if (this.bBj != null) {
            this.bBj.TH();
        }
        if (this.bBa != 1) {
            this.bBa = 1;
            if (z) {
                if (this.bBt) {
                    SL();
                    if (this.bBl != null) {
                        this.bBl.cS(true);
                    }
                    this.bBk.c(this.blu);
                } else {
                    SM();
                    if (this.bBl != null) {
                        this.bBl.cS(false);
                    }
                }
            } else {
                SL();
                if (this.bBl != null) {
                    this.bBl.cS(true);
                }
                this.bBk.c(this.blu);
            }
            this.bBt = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cU(boolean z) {
        if (this.bBh != null) {
            if (z) {
                this.bBh.ST();
            } else {
                this.bBh.SU();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bBp && j == this.bBs && dVar2 != null && dVar2.aNG != null && dVar != null && dVar.aNG != null && dVar.aNG.live_id == this.bBr && dVar2.bBQ != null && dVar2.bBQ.aGq != null && dVar2.bBQ.aGp != null) {
            if (!this.bBq) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            aD(bVar.SZ());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bBl != null) {
            this.bBq = this.bBl.a(dVar == null ? null : dVar.aNs, new f() { // from class: com.baidu.live.videochat.e.5
            });
            if (!this.bBq && bVar != null) {
                aD(bVar.SZ());
            }
        }
    }

    private void aD(long j) {
        if (this.bBj != null) {
            this.bBj.aF(j);
        }
        if (this.bBj != null) {
            this.bBj.TH();
        }
        this.bBa = 1;
    }
}
