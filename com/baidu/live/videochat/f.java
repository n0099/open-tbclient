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
/* loaded from: classes10.dex */
public class f {
    private BdUniqueId aEw;
    private com.baidu.live.u.f bDN;
    private com.baidu.live.videochat.a.a bPX;
    private com.baidu.live.videochat.a.b bPY;
    private com.baidu.live.videochat.e.f bPZ;
    private b bQa;
    private long bQg;
    private long bQh;
    private AlaLiveInfoData bsm;
    private Activity mActivity;
    private volatile int mChatStatus = 1;
    private boolean bQb = true;
    private boolean bQc = true;
    private boolean bQd = true;
    private boolean bQe = false;
    private boolean bQf = false;
    private volatile boolean bQi = false;
    private com.baidu.live.videochat.e.g bQj = new com.baidu.live.videochat.e.g() { // from class: com.baidu.live.videochat.f.3
        @Override // com.baidu.live.videochat.e.g
        public void Wn() {
            if (f.this.bPZ != null) {
                f.this.bPZ.WV();
            }
            if (f.this.bQa != null) {
                f.this.bQa.VO();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void U(int i, String str) {
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bQi = false;
                if (f.this.bQa != null) {
                    f.this.bQa.J(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void Wo() {
            if (f.this.bPZ != null) {
                f.this.bPZ.WX();
            }
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bQi = false;
                if (f.this.bQa != null) {
                    f.this.bQa.RS();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (f.this.bQa != null) {
                    f.this.bQa.K(-100, "");
                }
            } else if (f.this.mChatStatus != 3) {
                f.this.mChatStatus = 3;
                if (f.this.bPZ != null) {
                    f.this.bPZ.WX();
                }
                if (f.this.bPZ != null) {
                    f.this.bPZ.f(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aQw, aVar.aGY, aVar.aGZ);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void V(int i, String str) {
            if (f.this.bQa != null) {
                f.this.bQa.K(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (f.this.mChatStatus != 2) {
                if (f.this.bPZ != null) {
                    f.this.bPZ.WX();
                }
            } else if (i == 1) {
                f.this.Wk();
            } else if (i != 2) {
                if (f.this.bPZ != null) {
                    f.this.bPZ.WX();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bQi = false;
                    if (f.this.bQa != null) {
                        f.this.bQa.L(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (f.this.bPZ != null) {
                    f.this.bPZ.WX();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bQi = false;
                    if (f.this.bQa != null) {
                        f.this.bQa.L(-100, str);
                    }
                }
            } else {
                f.this.mChatStatus = 3;
                if (f.this.bPZ != null) {
                    f.this.bPZ.WX();
                }
                if (f.this.bPZ != null) {
                    f.this.bPZ.f(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aQw, aVar.aGY, aVar.aGZ);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.bQi = (bVar == null || bVar.Ww() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            f.this.a(f.this.bQi, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.dx(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void Wj() {
            f.this.dx(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void T(int i, String str) {
            if (f.this.mChatStatus != 1 && f.this.bQa != null) {
                f.this.bQa.M(i, str);
            }
        }
    };
    private CustomMessageListener bDB = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                f.this.dy(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public f(Activity activity) {
        this.bQg = 0L;
        this.bQh = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.aEw = BdUniqueId.gen();
        this.bPX = new com.baidu.live.videochat.a.a(activity);
        this.bPX.a(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.f.1
            @Override // com.baidu.live.u.b
            public void cw(int i) {
            }
        });
        this.bPY = new com.baidu.live.videochat.a.b(activity);
        this.bPY.a(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.f.2
            @Override // com.baidu.live.u.b
            public void cw(int i) {
            }
        });
        this.bPZ = new com.baidu.live.videochat.e.f(activity, this.aEw);
        this.bPZ.a(this.bQj);
        this.bPZ.a(this.bPX);
        MessageManager.getInstance().registerListener(this.bDB);
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bQh = com.baidu.live.d.xf().getLong(sharedPrefKeyWithAccount, 0L);
        this.bQg = com.baidu.live.d.xf().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wk() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bQi = true;
        if (this.bDN != null) {
            this.bDN.cM(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.d.xf().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.d.xf().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.bPX.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bQa != null) {
            if (a2) {
                this.bQa.a(true, j, this.bPX.Wr(), this.bPX.Ws());
            } else {
                dx(true);
            }
        }
        return a2;
    }

    private void Wl() {
        if (this.bPX != null) {
            this.bPX.Wp();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bPY != null && !this.bPY.isStarted() && bVar != null && dVar2 != null) {
            this.bPY.e(dVar2.aQw);
            if (this.bQa != null) {
                this.bQa.a(false, bVar.Wv(), this.bPY.Wr(), this.bDN.getLivePlayer());
            }
        }
    }

    private void Wm() {
        if (!this.bQi && this.bPY != null) {
            this.bPY.Wt();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.mChatStatus != 4 && bVar != null && bVar.SY() == 2) {
            this.mChatStatus = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bQa != null) {
                    this.bQa.a(z, bVar.Wv(), dVar2.aQi, z2);
                }
            } else if (this.bPX != null && !this.bPX.Wq()) {
                a(z, bVar.Wv(), bVar, dVar, dVar2);
            } else if (this.bQa != null) {
                this.bQa.a(z, bVar.Wv(), dVar2.aQi, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(boolean z) {
        if (this.bPZ != null) {
            this.bPZ.WZ();
        }
        if (this.mChatStatus != 1) {
            this.mChatStatus = 1;
            if (z) {
                if (this.bQi) {
                    Wl();
                    if (this.bQa != null) {
                        this.bQa.dw(true);
                    }
                    this.bDN.c(this.bsm);
                } else {
                    Wm();
                    if (this.bQa != null) {
                        this.bQa.dw(false);
                    }
                }
            } else {
                Wl();
                if (this.bQa != null) {
                    this.bQa.dw(true);
                }
                this.bDN.c(this.bsm);
            }
            this.bQi = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(boolean z) {
        if (this.bPX != null) {
            if (z) {
                this.bPX.VD();
            } else {
                this.bPX.VE();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bQe && j == this.bQh && dVar2 != null && dVar2.aQw != null && dVar != null && dVar.aQw != null && dVar.aQw.live_id == this.bQg && dVar2.bQE != null && dVar2.bQE.aGZ != null && dVar2.bQE.aGY != null) {
            if (!this.bQf) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            bB(bVar.Wv());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bQa != null) {
            this.bQf = this.bQa.a(dVar == null ? null : dVar.aQi, new g() { // from class: com.baidu.live.videochat.f.5
            });
            if (!this.bQf && bVar != null) {
                bB(bVar.Wv());
            }
        }
    }

    private void bB(long j) {
        if (this.bPZ != null) {
            this.bPZ.bD(j);
        }
        if (this.bPZ != null) {
            this.bPZ.WZ();
        }
        this.mChatStatus = 1;
    }
}
