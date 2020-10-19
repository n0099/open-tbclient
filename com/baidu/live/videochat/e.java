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
    private AlaLiveInfoData bjZ;
    private BdUniqueId blA;
    private com.baidu.live.videochat.a.a byl;
    private com.baidu.live.videochat.a.b bym;
    private com.baidu.live.videochat.e.f byn;
    private com.baidu.live.q.f byo;
    private b byp;
    private long byv;
    private long byw;
    private Activity mActivity;
    private volatile int bye = 1;
    private boolean byq = true;
    private boolean byr = true;
    private boolean bys = true;
    private boolean byt = false;
    private boolean byu = false;
    private volatile boolean byx = false;
    private g byy = new g() { // from class: com.baidu.live.videochat.e.3
        @Override // com.baidu.live.videochat.e.g
        public void RN() {
            if (e.this.byn != null) {
                e.this.byn.SD();
            }
            if (e.this.byp != null) {
                e.this.byp.Rm();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void H(int i, String str) {
            if (e.this.bye != 1) {
                e.this.bye = 1;
                e.this.byx = false;
                if (e.this.byp != null) {
                    e.this.byp.w(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void RO() {
            if (e.this.byn != null) {
                e.this.byn.SF();
            }
            if (e.this.bye != 1) {
                e.this.bye = 1;
                e.this.byx = false;
                if (e.this.byp != null) {
                    e.this.byp.Rn();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (e.this.byp != null) {
                    e.this.byp.x(-100, "");
                }
            } else if (e.this.bye != 3) {
                e.this.bye = 3;
                if (e.this.byn != null) {
                    e.this.byn.SF();
                }
                if (e.this.byn != null) {
                    e.this.byn.c(aVar.chatId, false);
                }
                e.this.a(alaLiveInfoData, aVar.chatId, aVar.aNb, aVar.aGh, aVar.aGi);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void I(int i, String str) {
            if (e.this.byp != null) {
                e.this.byp.x(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (e.this.bye != 2) {
                if (e.this.byn != null) {
                    e.this.byn.SF();
                }
            } else if (i == 1) {
                e.this.RK();
            } else if (i != 2) {
                if (e.this.byn != null) {
                    e.this.byn.SF();
                }
                if (e.this.bye != 1) {
                    e.this.bye = 1;
                    e.this.byx = false;
                    if (e.this.byp != null) {
                        e.this.byp.y(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (e.this.byn != null) {
                    e.this.byn.SF();
                }
                if (e.this.bye != 1) {
                    e.this.bye = 1;
                    e.this.byx = false;
                    if (e.this.byp != null) {
                        e.this.byp.y(-100, str);
                    }
                }
            } else {
                e.this.bye = 3;
                if (e.this.byn != null) {
                    e.this.byn.SF();
                }
                if (e.this.byn != null) {
                    e.this.byn.c(aVar.chatId, false);
                }
                e.this.a(alaLiveInfoData, aVar.chatId, aVar.aNb, aVar.aGh, aVar.aGi);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.byx = (bVar == null || bVar.Sb() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            e.this.a(e.this.byx, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            e.this.cN(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void RJ() {
            e.this.cN(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void G(int i, String str) {
            if (e.this.bye != 1 && e.this.byp != null) {
                e.this.byp.z(i, str);
            }
        }
    };
    private CustomMessageListener byz = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.e.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                e.this.cO(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public e(Activity activity) {
        this.byv = 0L;
        this.byw = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.blA = BdUniqueId.gen();
        this.byl = new com.baidu.live.videochat.a.a(activity);
        this.byl.a(new com.baidu.live.q.b() { // from class: com.baidu.live.videochat.e.1
            @Override // com.baidu.live.q.b
            public void dM(int i) {
            }
        });
        this.bym = new com.baidu.live.videochat.a.b(activity);
        this.bym.a(new com.baidu.live.q.b() { // from class: com.baidu.live.videochat.e.2
            @Override // com.baidu.live.q.b
            public void dM(int i) {
            }
        });
        this.byn = new com.baidu.live.videochat.e.f(activity, this.blA);
        this.byn.a(this.byy);
        this.byn.a(this.byl);
        MessageManager.getInstance().registerListener(this.byz);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.byw = com.baidu.live.c.AZ().getLong(sharedPrefKeyWithAccount, 0L);
        this.byv = com.baidu.live.c.AZ().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void RK() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.byx = true;
        if (this.byo != null) {
            this.byo.cl(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.AZ().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.AZ().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.byl.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.byp != null) {
            if (a2) {
                this.byp.a(true, j, this.byl.RR(), this.byl.RS());
            } else {
                cN(true);
            }
        }
        return a2;
    }

    private void RL() {
        if (this.byl != null) {
            this.byl.RP();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bym != null && !this.bym.isStarted() && bVar != null && dVar2 != null) {
            this.bym.e(dVar2.aNb);
            if (this.byp != null) {
                this.byp.a(false, bVar.RZ(), this.bym.RR(), this.byo.getLivePlayer());
            }
        }
    }

    private void RM() {
        if (!this.byx && this.bym != null) {
            this.bym.RW();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bye != 4 && bVar != null && bVar.Sa() == 2) {
            this.bye = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.byp != null) {
                    this.byp.a(z, bVar.RZ(), dVar2.aMN, z2);
                }
            } else if (this.byl != null && !this.byl.RQ()) {
                a(z, bVar.RZ(), bVar, dVar, dVar2);
            } else if (this.byp != null) {
                this.byp.a(z, bVar.RZ(), dVar2.aMN, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cN(boolean z) {
        if (this.byn != null) {
            this.byn.SH();
        }
        if (this.bye != 1) {
            this.bye = 1;
            if (z) {
                if (this.byx) {
                    RL();
                    if (this.byp != null) {
                        this.byp.cM(true);
                    }
                    this.byo.c(this.bjZ);
                } else {
                    RM();
                    if (this.byp != null) {
                        this.byp.cM(false);
                    }
                }
            } else {
                RL();
                if (this.byp != null) {
                    this.byp.cM(true);
                }
                this.byo.c(this.bjZ);
            }
            this.byx = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cO(boolean z) {
        if (this.byl != null) {
            if (z) {
                this.byl.RT();
            } else {
                this.byl.RU();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.byt && j == this.byw && dVar2 != null && dVar2.aNb != null && dVar != null && dVar.aNb != null && dVar.aNb.live_id == this.byv && dVar2.byU != null && dVar2.byU.aGi != null && dVar2.byU.aGh != null) {
            if (!this.byu) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            aB(bVar.RZ());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.byp != null) {
            this.byu = this.byp.a(dVar == null ? null : dVar.aMN, new f() { // from class: com.baidu.live.videochat.e.5
            });
            if (!this.byu && bVar != null) {
                aB(bVar.RZ());
            }
        }
    }

    private void aB(long j) {
        if (this.byn != null) {
            this.byn.aD(j);
        }
        if (this.byn != null) {
            this.byn.SH();
        }
        this.bye = 1;
    }
}
