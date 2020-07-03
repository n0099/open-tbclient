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
    private AlaLiveInfoData aWb;
    private BdUniqueId aZD;
    private com.baidu.live.videochat.a.a bkQ;
    private com.baidu.live.videochat.a.b bkR;
    private f bkS;
    private com.baidu.live.p.f bkT;
    private b bkU;
    private long bla;
    private long blb;
    private Activity mActivity;
    private volatile int bkJ = 1;
    private boolean bkV = true;
    private boolean bkW = true;
    private boolean bkX = true;
    private boolean bkY = false;
    private boolean bkZ = false;
    private volatile boolean blc = false;
    private g bld = new g() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.c.g
        public void JJ() {
            if (d.this.bkS != null) {
                d.this.bkS.Ko();
            }
            if (d.this.bkU != null) {
                d.this.bkU.Ju();
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void F(int i, String str) {
            if (d.this.bkJ != 1) {
                d.this.bkJ = 1;
                d.this.blc = false;
                if (d.this.bkU != null) {
                    d.this.bkU.u(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void JK() {
            if (d.this.bkS != null) {
                d.this.bkS.Kq();
            }
            if (d.this.bkJ != 1) {
                d.this.bkJ = 1;
                d.this.blc = false;
                if (d.this.bkU != null) {
                    d.this.bkU.Jv();
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (d.this.bkU != null) {
                    d.this.bkU.v(-100, "");
                }
            } else if (d.this.bkJ != 3) {
                d.this.bkJ = 3;
                if (d.this.bkS != null) {
                    d.this.bkS.Kq();
                }
                if (d.this.bkS != null) {
                    d.this.bkS.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aBZ, aVar.awk, aVar.awl);
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void G(int i, String str) {
            if (d.this.bkU != null) {
                d.this.bkU.v(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (d.this.bkJ != 2) {
                if (d.this.bkS != null) {
                    d.this.bkS.Kq();
                }
            } else if (i == 1) {
                d.this.JG();
            } else if (i != 2) {
                if (d.this.bkS != null) {
                    d.this.bkS.Kq();
                }
                if (d.this.bkJ != 1) {
                    d.this.bkJ = 1;
                    d.this.blc = false;
                    if (d.this.bkU != null) {
                        d.this.bkU.w(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (d.this.bkS != null) {
                    d.this.bkS.Kq();
                }
                if (d.this.bkJ != 1) {
                    d.this.bkJ = 1;
                    d.this.blc = false;
                    if (d.this.bkU != null) {
                        d.this.bkU.w(-100, str);
                    }
                }
            } else {
                d.this.bkJ = 3;
                if (d.this.bkS != null) {
                    d.this.bkS.Kq();
                }
                if (d.this.bkS != null) {
                    d.this.bkS.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.aBZ, aVar.awk, aVar.awl);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.blc = (bVar == null || bVar.JX() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            d.this.a(d.this.blc, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.cy(true);
        }

        @Override // com.baidu.live.videochat.c.c
        public void JF() {
            d.this.cy(false);
        }

        @Override // com.baidu.live.videochat.c.c
        public void E(int i, String str) {
            if (d.this.bkJ != 1 && d.this.bkU != null) {
                d.this.bkU.x(i, str);
            }
        }
    };
    private CustomMessageListener ble = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                d.this.cz(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public d(Activity activity) {
        this.bla = 0L;
        this.blb = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.aZD = BdUniqueId.gen();
        this.bkQ = new com.baidu.live.videochat.a.a(activity);
        this.bkQ.a(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.d.1
            @Override // com.baidu.live.p.b
            public void bL(int i) {
            }
        });
        this.bkR = new com.baidu.live.videochat.a.b(activity);
        this.bkR.a(new com.baidu.live.p.b() { // from class: com.baidu.live.videochat.d.2
            @Override // com.baidu.live.p.b
            public void bL(int i) {
            }
        });
        this.bkS = new f(activity, this.aZD);
        this.bkS.a(this.bld);
        this.bkS.a(this.bkQ);
        MessageManager.getInstance().registerListener(this.ble);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.blb = com.baidu.live.c.vf().getLong(sharedPrefKeyWithAccount, 0L);
        this.bla = com.baidu.live.c.vf().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void JG() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.blc = true;
        if (this.bkT != null) {
            this.bkT.bY(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.vf().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.vf().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a = this.bkQ.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bkU != null) {
            if (a) {
                this.bkU.a(true, j, this.bkQ.JN(), this.bkQ.JO());
            } else {
                cy(true);
            }
        }
        return a;
    }

    private void JH() {
        if (this.bkQ != null) {
            this.bkQ.JL();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bkR != null && !this.bkR.isStarted() && bVar != null && dVar2 != null) {
            this.bkR.e(dVar2.aBZ);
            if (this.bkU != null) {
                this.bkU.a(false, bVar.JV(), this.bkR.JN(), this.bkT.getLivePlayer());
            }
        }
    }

    private void JI() {
        if (!this.blc && this.bkR != null) {
            this.bkR.JS();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bkJ != 4 && bVar != null && bVar.JW() == 2) {
            this.bkJ = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bkU != null) {
                    this.bkU.a(z, bVar.JV(), dVar2.aBG, z2);
                }
            } else if (this.bkQ != null && !this.bkQ.JM()) {
                a(z, bVar.JV(), bVar, dVar, dVar2);
            } else if (this.bkU != null) {
                this.bkU.a(z, bVar.JV(), dVar2.aBG, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cy(boolean z) {
        if (this.bkS != null) {
            this.bkS.Ks();
        }
        if (this.bkJ != 1) {
            this.bkJ = 1;
            if (z) {
                if (this.blc) {
                    JH();
                    if (this.bkU != null) {
                        this.bkU.cx(true);
                    }
                    this.bkT.c(this.aWb);
                } else {
                    JI();
                    if (this.bkU != null) {
                        this.bkU.cx(false);
                    }
                }
            } else {
                JH();
                if (this.bkU != null) {
                    this.bkU.cx(true);
                }
                this.bkT.c(this.aWb);
            }
            this.blc = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cz(boolean z) {
        if (this.bkQ != null) {
            if (z) {
                this.bkQ.JP();
            } else {
                this.bkQ.JQ();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bkY && j == this.blb && dVar2 != null && dVar2.aBZ != null && dVar != null && dVar.aBZ != null && dVar.aBZ.live_id == this.bla && dVar2.blA != null && dVar2.blA.awl != null && dVar2.blA.awk != null) {
            if (!this.bkZ) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            az(bVar.JV());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bkU != null) {
            this.bkZ = this.bkU.a(dVar == null ? null : dVar.aBG, new e() { // from class: com.baidu.live.videochat.d.5
            });
            if (!this.bkZ && bVar != null) {
                az(bVar.JV());
            }
        }
    }

    private void az(long j) {
        if (this.bkS != null) {
            this.bkS.aA(j);
        }
        if (this.bkS != null) {
            this.bkS.Ks();
        }
        this.bkJ = 1;
    }
}
