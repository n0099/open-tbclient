package com.baidu.swan.game.ad.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.animation.AnimationUtils;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.c.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes11.dex */
public class g implements a.InterfaceC0357a, a.b, a.c {
    private com.baidu.swan.apps.media.c.a bAi;
    public String cFK;
    private String cGN;
    private AdElementInfo cHM;
    private com.baidu.swan.game.ad.b cHT;
    private com.baidu.swan.games.view.a cHV;
    private j cHW;
    private k cHX;
    public com.baidu.swan.apps.res.widget.dialog.g cHY;
    private i cHZ;
    private boolean cIa;
    private a cIb;
    private boolean cIc;
    private int cHU = 256;
    private int mPausePosition = 0;
    private boolean cId = true;
    private Context mContext = AppRuntime.getAppContext();
    private b cHL = new b(this.mContext);

    public g(String str, String str2) {
        this.cFK = "";
        this.cGN = str;
        this.cFK = str2;
    }

    public void a(i iVar) {
        this.cHZ = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.cHU == 257) {
            com.baidu.swan.game.ad.f.a.asS().a(d);
        } else if (this.cHU == 261 || this.cHU == 260 || this.cHU == 265) {
            a(d, "3010006");
        } else {
            if (this.cHU == 258) {
                if (atb()) {
                    this.cHU = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.cHU == 259 || this.cHU == 262 || this.cHU == 263 || this.cHU == 264 || this.cHU == 256 || this.cHU == 272) {
                com.baidu.swan.apps.runtime.e akN = com.baidu.swan.apps.runtime.e.akN();
                String str = "";
                if (akN != null) {
                    str = akN.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.cGN) || TextUtils.isEmpty(this.cFK)) {
                    a(d, "3010007");
                } else {
                    this.cHW = d;
                    this.cHU = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().pc(this.cGN).pd(this.cFK).pe(str).asO());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.ch("video", null);
                    aVar.a(eVar, this.cHL);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.cHU == 261 || this.cHU == 260 || this.cHU == 265) {
            if (e != null) {
                e.pk("3010004");
            }
            if (this.cHZ != null) {
                this.cHZ.onError("3010004");
            }
        } else if (this.cHU != 258 || atb()) {
            a(e, "3010004");
        } else if (this.cHM != null && TextUtils.isEmpty(this.cHM.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.cHU == 258) {
            this.cHU = 265;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.atd();
                    if (com.baidu.swan.games.view.a.c.az(g.this.cHT.getConvertView())) {
                        com.baidu.swan.games.view.a.c.av(g.this.cHT.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.cHT.getConvertView(), com.baidu.swan.apps.model.a.a.a.agF())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.cHX = e;
                    g.this.cHU = 260;
                    g.this.cHT.bk(g.this.cHM.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0357a
    public void b(AdElementInfo adElementInfo) {
        this.cHM = adElementInfo;
        this.cHU = 258;
        c(this.cHW);
        com.baidu.swan.games.view.a.b.ch("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0357a
    public void oW(String str) {
        this.cHU = 259;
        a(this.cHW, str);
        com.baidu.swan.games.view.a.b.N("video", "fail", str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void asG() {
        SwanAppActivity aev;
        int i;
        int i2;
        int i3;
        if (this.bAi != null && (aev = com.baidu.swan.apps.y.f.aeK().aev()) != null && !this.cIa) {
            int ayO = com.baidu.swan.games.view.a.c.ayO();
            int ayP = com.baidu.swan.games.view.a.c.ayP();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (ayO * 0.275f);
                i2 = (int) (ayO * 0.275f);
                i3 = (int) (0.05f * ayP);
            } else {
                i = (int) (ayO * 0.1f);
                i2 = (int) (ayO * 0.1f);
                i3 = 0;
            }
            asn();
            if (this.bAi.isEnd()) {
                asZ();
                return;
            }
            boolean z = this.bAi.getDuration() / 1000 > 15;
            this.cIa = true;
            this.cHY = new g.a(aev).ey(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.asZ();
                    g.this.cIa = false;
                    com.baidu.swan.games.view.a.b.ch("video", "close");
                }
            }).eH(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.atc();
                    g.this.cIa = false;
                }
            }).gd(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.cIa = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).akx();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void pK() {
        com.baidu.swan.apps.core.d.e Ou = com.baidu.swan.apps.y.f.aeK().Ou();
        if (Ou == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.cHM != null) {
            String asA = this.cHM.asA();
            Ou.io("adLanding").ab(com.baidu.swan.apps.core.d.e.bMz, com.baidu.swan.apps.core.d.e.bMB).a("adLanding", com.baidu.swan.apps.model.b.bg(asA, asA)).Wq();
        }
        com.baidu.swan.game.ad.d.a.b(this.cHM, this.cHL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asZ() {
        if (this.cHZ != null && this.bAi != null) {
            this.cHZ.ft(this.bAi.isEnd());
        }
        ata();
        com.baidu.swan.game.ad.d.a.d(this.cHM, this.cHL);
        this.cHU = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ata() {
        if (this.bAi != null) {
            this.bAi.pause();
            this.bAi.onDestroy();
        }
        if (this.cIb != null) {
            this.mContext.unregisterReceiver(this.cIb);
            this.cIb = null;
        }
        if (this.cHT != null) {
            this.cHT.asp();
            this.cHT.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.av(this.cHT.getConvertView());
        }
        if (this.cHV != null) {
            com.baidu.swan.games.view.a.c.b(this.cHV);
            this.cHV = null;
        }
    }

    private boolean atb() {
        if (this.cHM == null) {
            return true;
        }
        long asB = this.cHM.asB() * 1000;
        if (asB == 0) {
            asB = 1740000;
        }
        return System.currentTimeMillis() - this.cHM.getCreateTime() >= asB;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bAi != null) {
            return this.bAi.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.cHZ != null) {
            this.cHZ.onLoad();
        }
        if (jVar != null) {
            jVar.atg();
        }
        com.baidu.swan.game.ad.f.a.asS().W(16, "");
    }

    private void a(j jVar, String str) {
        if (this.cHZ != null) {
            this.cHZ.onError(str);
        }
        if (jVar != null) {
            jVar.pj(str);
        }
        com.baidu.swan.game.ad.f.a.asS().W(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asn() {
        if (this.bAi != null && this.cHT != null && this.bAi.isPlaying()) {
            this.bAi.pause();
            this.cHT.asn();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.cHM, this.cHL);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atc() {
        if (this.bAi != null && this.cHT != null) {
            if ((this.cHY == null || !this.cHY.isShowing()) && !this.bAi.isPlaying() && !this.bAi.isEnd()) {
                this.bAi.resume();
                this.cHT.aso();
                com.baidu.swan.game.ad.d.a.c(this.cHM, this.cHL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.pk(str);
        }
        if (this.cHZ != null) {
            this.cHZ.onError(str);
        }
        this.cHU = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atd() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.cHT = new com.baidu.swan.game.ad.d(this.mContext, this.cHM);
        } else {
            this.cHT = new com.baidu.swan.game.ad.e(this.mContext, this.cHM);
        }
        this.cHT.a((a.b) this);
        this.cHT.a((a.c) this);
        this.bAi = this.cHT.getPlayer();
        this.bAi.b(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.c.b
            public void a(com.baidu.swan.apps.w.b.l lVar) {
                if (g.this.bAi != null) {
                    g.this.bAi.dG(true);
                }
                if (g.this.cHT != null) {
                    g.this.cHT.onPrepared();
                }
                g.this.cHU = 261;
                g.this.mPausePosition = 0;
                if (g.this.cHT != null) {
                    g.this.cHT.asl();
                }
                if (g.this.cHX != null) {
                    g.this.cHX.ath();
                }
                if (g.this.cIb == null) {
                    g.this.cIb = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.cIb, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.cHM, g.this.cHL);
                com.baidu.swan.game.ad.d.a.c(g.this.cHM, g.this.cHL);
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(com.baidu.swan.apps.w.b.l lVar, int i, int i2) {
                g.this.ata();
                g.this.a(g.this.cHX, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(com.baidu.swan.apps.w.b.l lVar) {
                g.this.cHU = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.cHM, g.this.cHL);
                if (g.this.cHT != null) {
                    g.this.cHT.asq();
                }
            }
        });
        if (this.cHV == null) {
            this.cHV = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void ate() {
                    g.this.cIc = true;
                    if (g.this.cId) {
                        g.this.atc();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void atf() {
                    g.this.cIc = false;
                    g.this.asn();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.cHV);
        }
        this.cHT.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.bAi != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.cId = true;
                    if (g.this.cIc) {
                        g.this.atc();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.cId = false;
                }
            }
        }
    }
}
