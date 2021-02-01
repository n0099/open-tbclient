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
/* loaded from: classes11.dex */
public class f {
    private BdUniqueId aCW;
    private com.baidu.live.u.f bCn;
    private b bOA;
    private long bOG;
    private long bOH;
    private com.baidu.live.videochat.a.a bOx;
    private com.baidu.live.videochat.a.b bOy;
    private com.baidu.live.videochat.e.f bOz;
    private AlaLiveInfoData bqM;
    private Activity mActivity;
    private volatile int mChatStatus = 1;
    private boolean bOB = true;
    private boolean bOC = true;
    private boolean bOD = true;
    private boolean bOE = false;
    private boolean bOF = false;
    private volatile boolean bOI = false;
    private com.baidu.live.videochat.e.g bOJ = new com.baidu.live.videochat.e.g() { // from class: com.baidu.live.videochat.f.3
        @Override // com.baidu.live.videochat.e.g
        public void Wk() {
            if (f.this.bOz != null) {
                f.this.bOz.WS();
            }
            if (f.this.bOA != null) {
                f.this.bOA.VL();
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void U(int i, String str) {
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bOI = false;
                if (f.this.bOA != null) {
                    f.this.bOA.J(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void Wl() {
            if (f.this.bOz != null) {
                f.this.bOz.WU();
            }
            if (f.this.mChatStatus != 1) {
                f.this.mChatStatus = 1;
                f.this.bOI = false;
                if (f.this.bOA != null) {
                    f.this.bOA.RP();
                }
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (f.this.bOA != null) {
                    f.this.bOA.K(-100, "");
                }
            } else if (f.this.mChatStatus != 3) {
                f.this.mChatStatus = 3;
                if (f.this.bOz != null) {
                    f.this.bOz.WU();
                }
                if (f.this.bOz != null) {
                    f.this.bOz.f(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aOW, aVar.aFy, aVar.aFz);
            }
        }

        @Override // com.baidu.live.videochat.e.g
        public void V(int i, String str) {
            if (f.this.bOA != null) {
                f.this.bOA.K(i, str);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (f.this.mChatStatus != 2) {
                if (f.this.bOz != null) {
                    f.this.bOz.WU();
                }
            } else if (i == 1) {
                f.this.Wh();
            } else if (i != 2) {
                if (f.this.bOz != null) {
                    f.this.bOz.WU();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bOI = false;
                    if (f.this.bOA != null) {
                        f.this.bOA.L(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (f.this.bOz != null) {
                    f.this.bOz.WU();
                }
                if (f.this.mChatStatus != 1) {
                    f.this.mChatStatus = 1;
                    f.this.bOI = false;
                    if (f.this.bOA != null) {
                        f.this.bOA.L(-100, str);
                    }
                }
            } else {
                f.this.mChatStatus = 3;
                if (f.this.bOz != null) {
                    f.this.bOz.WU();
                }
                if (f.this.bOz != null) {
                    f.this.bOz.f(aVar.chatId, false);
                }
                f.this.a(alaLiveInfoData, aVar.chatId, aVar.aOW, aVar.aFy, aVar.aFz);
            }
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.bOI = (bVar == null || bVar.Wt() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            f.this.a(f.this.bOI, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.e.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            f.this.dx(true);
        }

        @Override // com.baidu.live.videochat.e.c
        public void Wg() {
            f.this.dx(false);
        }

        @Override // com.baidu.live.videochat.e.c
        public void T(int i, String str) {
            if (f.this.mChatStatus != 1 && f.this.bOA != null) {
                f.this.bOA.M(i, str);
            }
        }
    };
    private CustomMessageListener bCb = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.f.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                f.this.dy(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public f(Activity activity) {
        this.bOG = 0L;
        this.bOH = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.aCW = BdUniqueId.gen();
        this.bOx = new com.baidu.live.videochat.a.a(activity);
        this.bOx.a(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.f.1
            @Override // com.baidu.live.u.b
            public void cv(int i) {
            }
        });
        this.bOy = new com.baidu.live.videochat.a.b(activity);
        this.bOy.a(new com.baidu.live.u.b() { // from class: com.baidu.live.videochat.f.2
            @Override // com.baidu.live.u.b
            public void cv(int i) {
            }
        });
        this.bOz = new com.baidu.live.videochat.e.f(activity, this.aCW);
        this.bOz.a(this.bOJ);
        this.bOz.a(this.bOx);
        MessageManager.getInstance().registerListener(this.bCb);
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bOH = com.baidu.live.d.xc().getLong(sharedPrefKeyWithAccount, 0L);
        this.bOG = com.baidu.live.d.xc().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void Wh() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bOI = true;
        if (this.bCn != null) {
            this.bCn.cM(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.d.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.d.xc().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.d.xc().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a2 = this.bOx.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bOA != null) {
            if (a2) {
                this.bOA.a(true, j, this.bOx.Wo(), this.bOx.Wp());
            } else {
                dx(true);
            }
        }
        return a2;
    }

    private void Wi() {
        if (this.bOx != null) {
            this.bOx.Wm();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bOy != null && !this.bOy.isStarted() && bVar != null && dVar2 != null) {
            this.bOy.e(dVar2.aOW);
            if (this.bOA != null) {
                this.bOA.a(false, bVar.Ws(), this.bOy.Wo(), this.bCn.getLivePlayer());
            }
        }
    }

    private void Wj() {
        if (!this.bOI && this.bOy != null) {
            this.bOy.Wq();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.mChatStatus != 4 && bVar != null && bVar.SV() == 2) {
            this.mChatStatus = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bOA != null) {
                    this.bOA.a(z, bVar.Ws(), dVar2.aOI, z2);
                }
            } else if (this.bOx != null && !this.bOx.Wn()) {
                a(z, bVar.Ws(), bVar, dVar, dVar2);
            } else if (this.bOA != null) {
                this.bOA.a(z, bVar.Ws(), dVar2.aOI, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dx(boolean z) {
        if (this.bOz != null) {
            this.bOz.WW();
        }
        if (this.mChatStatus != 1) {
            this.mChatStatus = 1;
            if (z) {
                if (this.bOI) {
                    Wi();
                    if (this.bOA != null) {
                        this.bOA.dw(true);
                    }
                    this.bCn.c(this.bqM);
                } else {
                    Wj();
                    if (this.bOA != null) {
                        this.bOA.dw(false);
                    }
                }
            } else {
                Wi();
                if (this.bOA != null) {
                    this.bOA.dw(true);
                }
                this.bCn.c(this.bqM);
            }
            this.bOI = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void dy(boolean z) {
        if (this.bOx != null) {
            if (z) {
                this.bOx.VA();
            } else {
                this.bOx.VB();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bOE && j == this.bOH && dVar2 != null && dVar2.aOW != null && dVar != null && dVar.aOW != null && dVar.aOW.live_id == this.bOG && dVar2.bPe != null && dVar2.bPe.aFz != null && dVar2.bPe.aFy != null) {
            if (!this.bOF) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            bB(bVar.Ws());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bOA != null) {
            this.bOF = this.bOA.a(dVar == null ? null : dVar.aOI, new g() { // from class: com.baidu.live.videochat.f.5
            });
            if (!this.bOF && bVar != null) {
                bB(bVar.Ws());
            }
        }
    }

    private void bB(long j) {
        if (this.bOz != null) {
            this.bOz.bD(j);
        }
        if (this.bOz != null) {
            this.bOz.WW();
        }
        this.mChatStatus = 1;
    }
}
