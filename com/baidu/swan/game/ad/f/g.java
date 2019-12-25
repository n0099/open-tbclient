package com.baidu.swan.game.ad.f;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.IntentFilter;
import android.text.TextUtils;
import android.view.animation.AnimationUtils;
import com.baidu.idl.authority.AuthorityState;
import com.baidu.pass.biometrics.face.liveness.stat.LivenessStat;
import com.baidu.searchbox.common.runtime.AppRuntime;
import com.baidu.swan.apps.SwanAppActivity;
import com.baidu.swan.apps.as.ai;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.c.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes9.dex */
public class g implements a.InterfaceC0315a, a.b, a.c {
    private com.baidu.swan.apps.media.c.a aWC;
    public String cci;
    private String cdo;
    private i ceA;
    private boolean ceB;
    private a ceC;
    private boolean ceD;
    private AdElementInfo cen;
    private com.baidu.swan.game.ad.b ceu;
    private com.baidu.swan.games.view.a cew;
    private j cex;
    private k cey;
    public com.baidu.swan.apps.res.widget.dialog.g cez;
    private int cev = 256;
    private int mPausePosition = 0;
    private boolean ceE = true;
    private Context mContext = AppRuntime.getAppContext();
    private b cem = new b(this.mContext);

    public g(String str, String str2) {
        this.cci = "";
        this.cdo = str;
        this.cci = str2;
    }

    public void a(i iVar) {
        this.ceA = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.cev == 257) {
            com.baidu.swan.game.ad.f.a.ahU().a(d);
        } else if (this.cev == 261 || this.cev == 260 || this.cev == 265) {
            a(d, "3010006");
        } else {
            if (this.cev == 258) {
                if (aid()) {
                    this.cev = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.cev == 259 || this.cev == 262 || this.cev == 263 || this.cev == 264 || this.cev == 256 || this.cev == 272) {
                com.baidu.swan.apps.runtime.e ZS = com.baidu.swan.apps.runtime.e.ZS();
                String str = "";
                if (ZS != null) {
                    str = ZS.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.cdo) || TextUtils.isEmpty(this.cci)) {
                    a(d, "3010007");
                } else {
                    this.cex = d;
                    this.cev = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().nw(this.cdo).nx(this.cci).ny(str).ahQ());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bN("video", null);
                    aVar.a(eVar, this.cem);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.cev == 261 || this.cev == 260 || this.cev == 265) {
            if (e != null) {
                e.nE("3010004");
            }
            if (this.ceA != null) {
                this.ceA.onError("3010004");
            }
        } else if (this.cev != 258 || aid()) {
            a(e, "3010004");
        } else if (this.cen != null && TextUtils.isEmpty(this.cen.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.cev == 258) {
            this.cev = 265;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.aie();
                    if (com.baidu.swan.games.view.a.c.au(g.this.ceu.getConvertView())) {
                        com.baidu.swan.games.view.a.c.aq(g.this.ceu.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.ceu.getConvertView(), com.baidu.swan.apps.model.a.a.a.VJ())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.cey = e;
                    g.this.cev = 260;
                    g.this.ceu.U(g.this.cen.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0315a
    public void b(AdElementInfo adElementInfo) {
        this.cen = adElementInfo;
        this.cev = 258;
        c(this.cex);
        com.baidu.swan.games.view.a.b.bN("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0315a
    public void nq(String str) {
        this.cev = 259;
        a(this.cex, str);
        com.baidu.swan.games.view.a.b.M("video", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void ahI() {
        SwanAppActivity TQ;
        int i;
        int i2;
        int i3;
        if (this.aWC != null && (TQ = com.baidu.swan.apps.y.f.Uf().TQ()) != null && !this.ceB) {
            int anQ = com.baidu.swan.games.view.a.c.anQ();
            int anR = com.baidu.swan.games.view.a.c.anR();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (anQ * 0.275f);
                i2 = (int) (anQ * 0.275f);
                i3 = (int) (0.05f * anR);
            } else {
                i = (int) (anQ * 0.1f);
                i2 = (int) (anQ * 0.1f);
                i3 = 0;
            }
            pausePlay();
            if (this.aWC.isEnd()) {
                aib();
                return;
            }
            boolean z = this.aWC.getDuration() / 1000 > 15;
            this.ceB = true;
            this.cez = new g.a(TQ).dp(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.aib();
                    g.this.ceB = false;
                    com.baidu.swan.games.view.a.b.bN("video", "close");
                }
            }).el(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.continuePlay();
                    g.this.ceB = false;
                }
            }).fF(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.ceB = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).o(i, 0, i2, i3).ZC();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void kQ() {
        com.baidu.swan.apps.core.d.e DP = com.baidu.swan.apps.y.f.Uf().DP();
        if (DP == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.cen != null) {
            String ahC = this.cen.ahC();
            DP.gJ("adLanding").U(com.baidu.swan.apps.core.d.e.bjf, com.baidu.swan.apps.core.d.e.bjh).a("adLanding", com.baidu.swan.apps.model.b.aN(ahC, ahC)).LN();
        }
        com.baidu.swan.game.ad.d.a.b(this.cen, this.cem);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aib() {
        if (this.ceA != null && this.aWC != null) {
            this.ceA.ej(this.aWC.isEnd());
        }
        aic();
        com.baidu.swan.game.ad.d.a.d(this.cen, this.cem);
        this.cev = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aic() {
        if (this.aWC != null) {
            this.aWC.pause();
            this.aWC.onDestroy();
        }
        if (this.ceC != null) {
            this.mContext.unregisterReceiver(this.ceC);
            this.ceC = null;
        }
        if (this.ceu != null) {
            this.ceu.ahs();
            this.ceu.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.aq(this.ceu.getConvertView());
        }
        if (this.cew != null) {
            com.baidu.swan.games.view.a.c.b(this.cew);
            this.cew = null;
        }
    }

    private boolean aid() {
        if (this.cen == null) {
            return true;
        }
        long ahD = this.cen.ahD() * 1000;
        if (ahD == 0) {
            ahD = 1740000;
        }
        return System.currentTimeMillis() - this.cen.getCreateTime() >= ahD;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.aWC != null) {
            return this.aWC.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.ceA != null) {
            this.ceA.onLoad();
        }
        if (jVar != null) {
            jVar.aih();
        }
        com.baidu.swan.game.ad.f.a.ahU().B(16, "");
    }

    private void a(j jVar, String str) {
        if (this.ceA != null) {
            this.ceA.onError(str);
        }
        if (jVar != null) {
            jVar.nD(str);
        }
        com.baidu.swan.game.ad.f.a.ahU().B(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        if (this.aWC != null && this.ceu != null && this.aWC.isPlaying()) {
            this.aWC.pause();
            this.ceu.pausePlay();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.cen, this.cem);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continuePlay() {
        if (this.aWC != null && this.ceu != null) {
            if ((this.cez == null || !this.cez.isShowing()) && !this.aWC.isPlaying() && !this.aWC.isEnd()) {
                this.aWC.resume();
                this.ceu.ahr();
                com.baidu.swan.game.ad.d.a.c(this.cen, this.cem);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.nE(str);
        }
        if (this.ceA != null) {
            this.ceA.onError(str);
        }
        this.cev = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aie() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.ceu = new com.baidu.swan.game.ad.d(this.mContext, this.cen);
        } else {
            this.ceu = new com.baidu.swan.game.ad.e(this.mContext, this.cen);
        }
        this.ceu.a((a.b) this);
        this.ceu.a((a.c) this);
        this.aWC = this.ceu.getPlayer();
        this.aWC.b(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.c.b
            public void a(com.baidu.swan.apps.w.b.l lVar) {
                if (g.this.aWC != null) {
                    g.this.aWC.cx(true);
                }
                if (g.this.ceu != null) {
                    g.this.ceu.onPrepared();
                }
                g.this.cev = 261;
                g.this.mPausePosition = 0;
                if (g.this.ceu != null) {
                    g.this.ceu.ahq();
                }
                if (g.this.cey != null) {
                    g.this.cey.aii();
                }
                if (g.this.ceC == null) {
                    g.this.ceC = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.ceC, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.cen, g.this.cem);
                com.baidu.swan.game.ad.d.a.c(g.this.cen, g.this.cem);
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(com.baidu.swan.apps.w.b.l lVar, int i, int i2) {
                g.this.aic();
                g.this.a(g.this.cey, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(com.baidu.swan.apps.w.b.l lVar) {
                g.this.cev = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.cen, g.this.cem);
                if (g.this.ceu != null) {
                    g.this.ceu.aht();
                }
            }
        });
        if (this.cew == null) {
            this.cew = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void aif() {
                    g.this.ceD = true;
                    if (g.this.ceE) {
                        g.this.continuePlay();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aig() {
                    g.this.ceD = false;
                    g.this.pausePlay();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.cew);
        }
        this.ceu.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes9.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.aWC != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.ceE = true;
                    if (g.this.ceD) {
                        g.this.continuePlay();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.ceE = false;
                }
            }
        }
    }
}
