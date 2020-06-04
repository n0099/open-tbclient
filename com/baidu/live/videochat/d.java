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
    private BdUniqueId aWV;
    private com.baidu.live.videochat.a.a bfI;
    private com.baidu.live.videochat.a.b bfJ;
    private f bfK;
    private com.baidu.live.o.f bfL;
    private AlaLiveInfoData bfM;
    private b bfN;
    private long bfT;
    private long bfU;
    private Activity mActivity;
    private volatile int bfB = 1;
    private boolean bfO = true;
    private boolean bfP = true;
    private boolean bfQ = true;
    private boolean bfR = false;
    private boolean bfS = false;
    private volatile boolean bfV = false;
    private g bfW = new g() { // from class: com.baidu.live.videochat.d.3
        @Override // com.baidu.live.videochat.c.g
        public void Iw() {
            if (d.this.bfK != null) {
                d.this.bfK.Jb();
            }
            if (d.this.bfN != null) {
                d.this.bfN.Ih();
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void D(int i, String str) {
            if (d.this.bfB != 1) {
                d.this.bfB = 1;
                d.this.bfV = false;
                if (d.this.bfN != null) {
                    d.this.bfN.s(i, str);
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void Ix() {
            if (d.this.bfK != null) {
                d.this.bfK.Jd();
            }
            if (d.this.bfB != 1) {
                d.this.bfB = 1;
                d.this.bfV = false;
                if (d.this.bfN != null) {
                    d.this.bfN.Ii();
                }
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void a(AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (aVar == null || aVar.chatId == 0) {
                if (d.this.bfN != null) {
                    d.this.bfN.t(-100, "");
                }
            } else if (d.this.bfB != 3) {
                d.this.bfB = 3;
                if (d.this.bfK != null) {
                    d.this.bfK.Jd();
                }
                if (d.this.bfK != null) {
                    d.this.bfK.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.azA, aVar.aui, aVar.auj);
            }
        }

        @Override // com.baidu.live.videochat.c.g
        public void E(int i, String str) {
            if (d.this.bfN != null) {
                d.this.bfN.t(i, str);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(int i, String str, AlaLiveInfoData alaLiveInfoData, com.baidu.live.videochat.b.a aVar, com.baidu.live.videochat.b.c cVar) {
            if (d.this.bfB != 2) {
                if (d.this.bfK != null) {
                    d.this.bfK.Jd();
                }
            } else if (i == 1) {
                d.this.It();
            } else if (i != 2) {
                if (d.this.bfK != null) {
                    d.this.bfK.Jd();
                }
                if (d.this.bfB != 1) {
                    d.this.bfB = 1;
                    d.this.bfV = false;
                    if (d.this.bfN != null) {
                        d.this.bfN.u(i, str);
                    }
                }
            } else if (aVar == null || alaLiveInfoData == null || aVar.chatId == 0) {
                if (d.this.bfK != null) {
                    d.this.bfK.Jd();
                }
                if (d.this.bfB != 1) {
                    d.this.bfB = 1;
                    d.this.bfV = false;
                    if (d.this.bfN != null) {
                        d.this.bfN.u(-100, str);
                    }
                }
            } else {
                d.this.bfB = 3;
                if (d.this.bfK != null) {
                    d.this.bfK.Jd();
                }
                if (d.this.bfK != null) {
                    d.this.bfK.d(aVar.chatId, false);
                }
                d.this.a(alaLiveInfoData, aVar.chatId, aVar.azA, aVar.aui, aVar.auj);
            }
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.bfV = (bVar == null || bVar.IK() != TbadkCoreApplication.getCurrentAccountId() || TbadkCoreApplication.getCurrentAccountId() == 0) ? false : true;
            d.this.a(d.this.bfV, bVar, dVar, dVar2, z);
        }

        @Override // com.baidu.live.videochat.c.c
        public void a(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
            d.this.cs(true);
        }

        @Override // com.baidu.live.videochat.c.c
        public void Is() {
            d.this.cs(false);
        }

        @Override // com.baidu.live.videochat.c.c
        public void C(int i, String str) {
            if (d.this.bfB != 1 && d.this.bfN != null) {
                d.this.bfN.v(i, str);
            }
        }
    };
    private CustomMessageListener bfX = new CustomMessageListener(CmdConfigCustom.CMD_BACKGROUND_SWTICH) { // from class: com.baidu.live.videochat.d.4
        /* JADX DEBUG: Method merged with bridge method */
        @Override // com.baidu.live.adp.framework.listener.MessageListener
        public void onMessage(CustomResponsedMessage<?> customResponsedMessage) {
            if (customResponsedMessage instanceof BackgroundSwitchMessage) {
                d.this.ct(((BackgroundSwitchMessage) customResponsedMessage).getData().booleanValue());
            }
        }
    };

    public d(Activity activity) {
        this.bfT = 0L;
        this.bfU = 0L;
        if (activity == null) {
            throw new RuntimeException("sender live video chat param invalid context is null");
        }
        this.mActivity = activity;
        this.aWV = BdUniqueId.gen();
        this.bfI = new com.baidu.live.videochat.a.a(activity);
        this.bfI.a(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.d.1
            @Override // com.baidu.live.o.b
            public void bG(int i) {
            }
        });
        this.bfJ = new com.baidu.live.videochat.a.b(activity);
        this.bfJ.a(new com.baidu.live.o.b() { // from class: com.baidu.live.videochat.d.2
            @Override // com.baidu.live.o.b
            public void bG(int i) {
            }
        });
        this.bfK = new f(activity, this.aWV);
        this.bfK.a(this.bfW);
        this.bfK.a(this.bfI);
        MessageManager.getInstance().registerListener(this.bfX);
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        this.bfU = com.baidu.live.c.uN().getLong(sharedPrefKeyWithAccount, 0L);
        this.bfT = com.baidu.live.c.uN().getLong(sharedPrefKeyWithAccount2, 0L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void It() {
    }

    /* JADX INFO: Access modifiers changed from: private */
    public boolean a(AlaLiveInfoData alaLiveInfoData, long j, AlaLiveInfoData alaLiveInfoData2, AlaAvtsData alaAvtsData, AlaAvtsConfigInfo alaAvtsConfigInfo) {
        this.bfV = true;
        if (this.bfL != null) {
            this.bfL.bW(false);
        }
        String sharedPrefKeyWithAccount = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_CHAT_ID);
        String sharedPrefKeyWithAccount2 = com.baidu.live.c.getSharedPrefKeyWithAccount(SharedPrefConfig.KEY_LIVE_VIDEO_CHAT_SENDER_LIVE_ID);
        com.baidu.live.c.uN().putLong(sharedPrefKeyWithAccount, j);
        com.baidu.live.c.uN().putLong(sharedPrefKeyWithAccount2, alaLiveInfoData2 != null ? alaLiveInfoData2.live_id : 0L);
        boolean a = this.bfI.a(alaLiveInfoData, alaAvtsData, alaAvtsConfigInfo);
        if (this.bfN != null) {
            if (a) {
                this.bfN.a(true, j, this.bfI.IA(), this.bfI.IB());
            } else {
                cs(true);
            }
        }
        return a;
    }

    private void Iu() {
        if (this.bfI != null) {
            this.bfI.Iy();
        }
    }

    private void b(com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bfJ != null && !this.bfJ.isStarted() && bVar != null && dVar2 != null) {
            this.bfJ.d(dVar2.azA);
            if (this.bfN != null) {
                this.bfN.a(false, bVar.II(), this.bfJ.IA(), this.bfL.getLivePlayer());
            }
        }
    }

    private void Iv() {
        if (!this.bfV && this.bfJ != null) {
            this.bfJ.IF();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(boolean z, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2, boolean z2) {
        if (this.bfB != 4 && bVar != null && bVar.IJ() == 2) {
            this.bfB = 4;
            if (!z) {
                b(bVar, dVar, dVar2);
                if (this.bfN != null) {
                    this.bfN.a(z, bVar.II(), dVar2.azo, z2);
                }
            } else if (this.bfI != null && !this.bfI.Iz()) {
                a(z, bVar.II(), bVar, dVar, dVar2);
            } else if (this.bfN != null) {
                this.bfN.a(z, bVar.II(), dVar2.azo, z2);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void cs(boolean z) {
        if (this.bfK != null) {
            this.bfK.Jf();
        }
        if (this.bfB != 1) {
            this.bfB = 1;
            if (z) {
                if (this.bfV) {
                    Iu();
                    if (this.bfN != null) {
                        this.bfN.cr(true);
                    }
                    this.bfL.b(this.bfM);
                } else {
                    Iv();
                    if (this.bfN != null) {
                        this.bfN.cr(false);
                    }
                }
            } else {
                Iu();
                if (this.bfN != null) {
                    this.bfN.cr(true);
                }
                this.bfL.b(this.bfM);
            }
            this.bfV = false;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ct(boolean z) {
        if (this.bfI != null) {
            if (z) {
                this.bfI.IC();
            } else {
                this.bfI.ID();
            }
        }
    }

    private void a(boolean z, long j, com.baidu.live.videochat.b.b bVar, com.baidu.live.videochat.b.d dVar, com.baidu.live.videochat.b.d dVar2) {
        if (this.bfR && j == this.bfU && dVar2 != null && dVar2.azA != null && dVar != null && dVar.azA != null && dVar.azA.live_id == this.bfT && dVar2.bgu != null && dVar2.bgu.auj != null && dVar2.bgu.aui != null) {
            if (!this.bfS) {
                b(z, bVar, dVar, dVar2);
            }
        } else if (bVar != null) {
            az(bVar.II());
        }
    }

    private void b(final boolean z, final com.baidu.live.videochat.b.b bVar, final com.baidu.live.videochat.b.d dVar, final com.baidu.live.videochat.b.d dVar2) {
        if (this.bfN != null) {
            this.bfS = this.bfN.a(dVar == null ? null : dVar.azo, new e() { // from class: com.baidu.live.videochat.d.5
            });
            if (!this.bfS && bVar != null) {
                az(bVar.II());
            }
        }
    }

    private void az(long j) {
        if (this.bfK != null) {
            this.bfK.aA(j);
        }
        if (this.bfK != null) {
            this.bfK.Jf();
        }
        this.bfB = 1;
    }
}
