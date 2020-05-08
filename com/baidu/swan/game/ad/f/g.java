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
public class g implements a.InterfaceC0378a, a.b, a.c {
    private com.baidu.swan.apps.media.c.a bAn;
    public String cFQ;
    private String cGT;
    private AdElementInfo cHS;
    private com.baidu.swan.game.ad.b cHZ;
    private com.baidu.swan.games.view.a cIb;
    private j cIc;
    private k cId;
    public com.baidu.swan.apps.res.widget.dialog.g cIe;
    private i cIf;
    private boolean cIg;
    private a cIh;
    private boolean cIi;
    private int cIa = 256;
    private int mPausePosition = 0;
    private boolean cIj = true;
    private Context mContext = AppRuntime.getAppContext();
    private b cHR = new b(this.mContext);

    public g(String str, String str2) {
        this.cFQ = "";
        this.cGT = str;
        this.cFQ = str2;
    }

    public void a(i iVar) {
        this.cIf = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.cIa == 257) {
            com.baidu.swan.game.ad.f.a.asS().a(d);
        } else if (this.cIa == 261 || this.cIa == 260 || this.cIa == 265) {
            a(d, "3010006");
        } else {
            if (this.cIa == 258) {
                if (atb()) {
                    this.cIa = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.cIa == 259 || this.cIa == 262 || this.cIa == 263 || this.cIa == 264 || this.cIa == 256 || this.cIa == 272) {
                com.baidu.swan.apps.runtime.e akM = com.baidu.swan.apps.runtime.e.akM();
                String str = "";
                if (akM != null) {
                    str = akM.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.cGT) || TextUtils.isEmpty(this.cFQ)) {
                    a(d, "3010007");
                } else {
                    this.cIc = d;
                    this.cIa = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().pc(this.cGT).pd(this.cFQ).pe(str).asN());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.ch("video", null);
                    aVar.a(eVar, this.cHR);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.cIa == 261 || this.cIa == 260 || this.cIa == 265) {
            if (e != null) {
                e.pk("3010004");
            }
            if (this.cIf != null) {
                this.cIf.onError("3010004");
            }
        } else if (this.cIa != 258 || atb()) {
            a(e, "3010004");
        } else if (this.cHS != null && TextUtils.isEmpty(this.cHS.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.cIa == 258) {
            this.cIa = 265;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.atd();
                    if (com.baidu.swan.games.view.a.c.az(g.this.cHZ.getConvertView())) {
                        com.baidu.swan.games.view.a.c.av(g.this.cHZ.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.cHZ.getConvertView(), com.baidu.swan.apps.model.a.a.a.agE())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.cId = e;
                    g.this.cIa = 260;
                    g.this.cHZ.bk(g.this.cHS.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0378a
    public void b(AdElementInfo adElementInfo) {
        this.cHS = adElementInfo;
        this.cIa = 258;
        c(this.cIc);
        com.baidu.swan.games.view.a.b.ch("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0378a
    public void oW(String str) {
        this.cIa = 259;
        a(this.cIc, str);
        com.baidu.swan.games.view.a.b.N("video", "fail", str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void asF() {
        SwanAppActivity aeu;
        int i;
        int i2;
        int i3;
        if (this.bAn != null && (aeu = com.baidu.swan.apps.y.f.aeJ().aeu()) != null && !this.cIg) {
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
            asl();
            if (this.bAn.isEnd()) {
                asZ();
                return;
            }
            boolean z = this.bAn.getDuration() / 1000 > 15;
            this.cIg = true;
            this.cIe = new g.a(aeu).ey(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.asZ();
                    g.this.cIg = false;
                    com.baidu.swan.games.view.a.b.ch("video", "close");
                }
            }).eH(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.atc();
                    g.this.cIg = false;
                }
            }).gd(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.cIg = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).akw();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void pK() {
        com.baidu.swan.apps.core.d.e Ot = com.baidu.swan.apps.y.f.aeJ().Ot();
        if (Ot == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.cHS != null) {
            String asz = this.cHS.asz();
            Ot.io("adLanding").ab(com.baidu.swan.apps.core.d.e.bME, com.baidu.swan.apps.core.d.e.bMG).a("adLanding", com.baidu.swan.apps.model.b.bg(asz, asz)).Wp();
        }
        com.baidu.swan.game.ad.d.a.b(this.cHS, this.cHR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asZ() {
        if (this.cIf != null && this.bAn != null) {
            this.cIf.ft(this.bAn.isEnd());
        }
        ata();
        com.baidu.swan.game.ad.d.a.d(this.cHS, this.cHR);
        this.cIa = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ata() {
        if (this.bAn != null) {
            this.bAn.pause();
            this.bAn.onDestroy();
        }
        if (this.cIh != null) {
            this.mContext.unregisterReceiver(this.cIh);
            this.cIh = null;
        }
        if (this.cHZ != null) {
            this.cHZ.aso();
            this.cHZ.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.av(this.cHZ.getConvertView());
        }
        if (this.cIb != null) {
            com.baidu.swan.games.view.a.c.b(this.cIb);
            this.cIb = null;
        }
    }

    private boolean atb() {
        if (this.cHS == null) {
            return true;
        }
        long asA = this.cHS.asA() * 1000;
        if (asA == 0) {
            asA = 1740000;
        }
        return System.currentTimeMillis() - this.cHS.getCreateTime() >= asA;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bAn != null) {
            return this.bAn.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.cIf != null) {
            this.cIf.onLoad();
        }
        if (jVar != null) {
            jVar.atg();
        }
        com.baidu.swan.game.ad.f.a.asS().W(16, "");
    }

    private void a(j jVar, String str) {
        if (this.cIf != null) {
            this.cIf.onError(str);
        }
        if (jVar != null) {
            jVar.pj(str);
        }
        com.baidu.swan.game.ad.f.a.asS().W(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void asl() {
        if (this.bAn != null && this.cHZ != null && this.bAn.isPlaying()) {
            this.bAn.pause();
            this.cHZ.asl();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.cHS, this.cHR);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atc() {
        if (this.bAn != null && this.cHZ != null) {
            if ((this.cIe == null || !this.cIe.isShowing()) && !this.bAn.isPlaying() && !this.bAn.isEnd()) {
                this.bAn.resume();
                this.cHZ.asn();
                com.baidu.swan.game.ad.d.a.c(this.cHS, this.cHR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.pk(str);
        }
        if (this.cIf != null) {
            this.cIf.onError(str);
        }
        this.cIa = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void atd() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.cHZ = new com.baidu.swan.game.ad.d(this.mContext, this.cHS);
        } else {
            this.cHZ = new com.baidu.swan.game.ad.e(this.mContext, this.cHS);
        }
        this.cHZ.a((a.b) this);
        this.cHZ.a((a.c) this);
        this.bAn = this.cHZ.getPlayer();
        this.bAn.b(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.c.b
            public void a(com.baidu.swan.apps.w.b.l lVar) {
                if (g.this.bAn != null) {
                    g.this.bAn.dG(true);
                }
                if (g.this.cHZ != null) {
                    g.this.cHZ.onPrepared();
                }
                g.this.cIa = 261;
                g.this.mPausePosition = 0;
                if (g.this.cHZ != null) {
                    g.this.cHZ.ask();
                }
                if (g.this.cId != null) {
                    g.this.cId.ath();
                }
                if (g.this.cIh == null) {
                    g.this.cIh = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.cIh, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.cHS, g.this.cHR);
                com.baidu.swan.game.ad.d.a.c(g.this.cHS, g.this.cHR);
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(com.baidu.swan.apps.w.b.l lVar, int i, int i2) {
                g.this.ata();
                g.this.a(g.this.cId, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(com.baidu.swan.apps.w.b.l lVar) {
                g.this.cIa = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.cHS, g.this.cHR);
                if (g.this.cHZ != null) {
                    g.this.cHZ.asp();
                }
            }
        });
        if (this.cIb == null) {
            this.cIb = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void ate() {
                    g.this.cIi = true;
                    if (g.this.cIj) {
                        g.this.atc();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void atf() {
                    g.this.cIi = false;
                    g.this.asl();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.cIb);
        }
        this.cHZ.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.bAn != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.cIj = true;
                    if (g.this.cIi) {
                        g.this.atc();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.cIj = false;
                }
            }
        }
    }
}
