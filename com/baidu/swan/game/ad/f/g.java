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
import com.baidu.swan.apps.aq.aj;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.game.ad.a.a;
import com.baidu.swan.game.ad.c;
import com.baidu.swan.game.ad.c.b;
import com.baidu.swan.game.ad.entity.AdElementInfo;
/* loaded from: classes11.dex */
public class g implements a.InterfaceC0424a, a.b, a.c {
    private com.baidu.swan.apps.media.b.a bMP;
    public String cUK;
    private String cVN;
    private AdElementInfo cWM;
    private com.baidu.swan.game.ad.b cWT;
    private com.baidu.swan.games.view.a cWV;
    private j cWW;
    private k cWX;
    public com.baidu.swan.apps.res.widget.dialog.g cWY;
    private i cWZ;
    private boolean cXa;
    private a cXb;
    private boolean cXc;
    private int cWU = 256;
    private int mPausePosition = 0;
    private boolean cXd = true;
    private Context mContext = AppRuntime.getAppContext();
    private b cWL = new b(this.mContext);

    public g(String str, String str2) {
        this.cUK = "";
        this.cVN = str;
        this.cUK = str2;
    }

    public void a(i iVar) {
        this.cWZ = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.cWU == 257) {
            com.baidu.swan.game.ad.f.a.axF().a(d);
        } else if (this.cWU == 261 || this.cWU == 260 || this.cWU == 265) {
            a(d, "3010006");
        } else {
            if (this.cWU == 258) {
                if (axO()) {
                    this.cWU = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.cWU == 259 || this.cWU == 262 || this.cWU == 263 || this.cWU == 264 || this.cWU == 256 || this.cWU == 272) {
                com.baidu.swan.apps.runtime.e apM = com.baidu.swan.apps.runtime.e.apM();
                String str = "";
                if (apM != null) {
                    str = apM.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.cVN) || TextUtils.isEmpty(this.cUK)) {
                    a(d, "3010007");
                } else {
                    this.cWW = d;
                    this.cWU = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().qI(this.cVN).qJ(this.cUK).qK(str).axA());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.cE("video", null);
                    aVar.a(eVar, this.cWL);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.cWU == 261 || this.cWU == 260 || this.cWU == 265) {
            if (e != null) {
                e.qQ("3010004");
            }
            if (this.cWZ != null) {
                this.cWZ.onError("3010004");
            }
        } else if (this.cWU != 258 || axO()) {
            a(e, "3010004");
        } else if (this.cWM != null && TextUtils.isEmpty(this.cWM.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.cWU == 258) {
            this.cWU = 265;
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.axQ();
                    if (com.baidu.swan.games.view.a.c.ay(g.this.cWT.getConvertView())) {
                        com.baidu.swan.games.view.a.c.av(g.this.cWT.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.cWT.getConvertView(), com.baidu.swan.apps.model.a.a.a.ald())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.cWX = e;
                    g.this.cWU = 260;
                    g.this.cWT.bl(g.this.cWM.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0424a
    public void b(AdElementInfo adElementInfo) {
        this.cWM = adElementInfo;
        this.cWU = 258;
        c(this.cWW);
        com.baidu.swan.games.view.a.b.cE("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0424a
    public void qC(String str) {
        this.cWU = 259;
        a(this.cWW, str);
        com.baidu.swan.games.view.a.b.R("video", "fail", str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void axs() {
        SwanAppActivity aiL;
        int i;
        int i2;
        int i3;
        if (this.bMP != null && (aiL = com.baidu.swan.apps.w.f.ajb().aiL()) != null && !this.cXa) {
            int aDM = com.baidu.swan.games.view.a.c.aDM();
            int aDN = com.baidu.swan.games.view.a.c.aDN();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aDM * 0.275f);
                i2 = (int) (aDM * 0.275f);
                i3 = (int) (0.05f * aDN);
            } else {
                i = (int) (aDM * 0.1f);
                i2 = (int) (aDM * 0.1f);
                i3 = 0;
            }
            awZ();
            if (this.bMP.isEnd()) {
                axM();
                return;
            }
            boolean z = this.bMP.getDuration() / 1000 > 15;
            this.cXa = true;
            this.cWY = new g.a(aiL).eW(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.axM();
                    g.this.cXa = false;
                    com.baidu.swan.games.view.a.b.cE("video", "close");
                }
            }).fd(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.axP();
                    g.this.cXa = false;
                }
            }).gI(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.cXa = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).apu();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void qh() {
        com.baidu.swan.apps.core.d.e RN = com.baidu.swan.apps.w.f.ajb().RN();
        if (RN == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.cWM != null) {
            String axm = this.cWM.axm();
            RN.jx("adLanding").ag(com.baidu.swan.apps.core.d.e.caB, com.baidu.swan.apps.core.d.e.caD).a("adLanding", com.baidu.swan.apps.model.b.bz(axm, axm)).aah();
        }
        com.baidu.swan.game.ad.d.a.b(this.cWM, this.cWL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axM() {
        if (this.cWZ != null && this.bMP != null) {
            this.cWZ.fI(this.bMP.isEnd());
        }
        axN();
        com.baidu.swan.game.ad.d.a.d(this.cWM, this.cWL);
        this.cWU = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axN() {
        if (this.bMP != null) {
            this.bMP.pause();
            this.bMP.onDestroy();
        }
        if (this.cXb != null) {
            this.mContext.unregisterReceiver(this.cXb);
            this.cXb = null;
        }
        if (this.cWT != null) {
            this.cWT.axb();
            this.cWT.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.av(this.cWT.getConvertView());
        }
        if (this.cWV != null) {
            com.baidu.swan.games.view.a.c.b(this.cWV);
            this.cWV = null;
        }
    }

    private boolean axO() {
        if (this.cWM == null) {
            return true;
        }
        long axn = this.cWM.axn() * 1000;
        if (axn == 0) {
            axn = 1740000;
        }
        return System.currentTimeMillis() - this.cWM.getCreateTime() >= axn;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bMP != null) {
            return this.bMP.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.cWZ != null) {
            this.cWZ.onLoad();
        }
        if (jVar != null) {
            jVar.axT();
        }
        com.baidu.swan.game.ad.f.a.axF().Z(16, "");
    }

    private void a(j jVar, String str) {
        if (this.cWZ != null) {
            this.cWZ.onError(str);
        }
        if (jVar != null) {
            jVar.qP(str);
        }
        com.baidu.swan.game.ad.f.a.axF().Z(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awZ() {
        if (this.bMP != null && this.cWT != null && this.bMP.isPlaying()) {
            this.bMP.pause();
            this.cWT.awZ();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.cWM, this.cWL);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axP() {
        if (this.bMP != null && this.cWT != null) {
            if ((this.cWY == null || !this.cWY.isShowing()) && !this.bMP.isPlaying() && !this.bMP.isEnd()) {
                this.bMP.resume();
                this.cWT.axa();
                com.baidu.swan.game.ad.d.a.c(this.cWM, this.cWL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.qQ(str);
        }
        if (this.cWZ != null) {
            this.cWZ.onError(str);
        }
        this.cWU = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void axQ() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.cWT = new com.baidu.swan.game.ad.d(this.mContext, this.cWM);
        } else {
            this.cWT = new com.baidu.swan.game.ad.e(this.mContext, this.cWM);
        }
        this.cWT.a((a.b) this);
        this.cWT.a((a.c) this);
        this.bMP = this.cWT.getPlayer();
        this.bMP.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.u.b.j jVar) {
                if (g.this.cWT != null) {
                    g.this.cWT.onPrepared();
                }
                g.this.cWU = 261;
                g.this.mPausePosition = 0;
                if (g.this.cWT != null) {
                    g.this.cWT.awY();
                }
                if (g.this.cWX != null) {
                    g.this.cWX.axU();
                }
                if (g.this.cXb == null) {
                    g.this.cXb = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.cXb, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.cWM, g.this.cWL);
                com.baidu.swan.game.ad.d.a.c(g.this.cWM, g.this.cWL);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.u.b.j jVar, int i, int i2) {
                g.this.axN();
                g.this.a(g.this.cWX, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.u.b.j jVar) {
                g.this.cWU = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.cWM, g.this.cWL);
                if (g.this.cWT != null) {
                    g.this.cWT.axc();
                }
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void c(com.baidu.swan.apps.u.b.j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void d(com.baidu.swan.apps.u.b.j jVar) {
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void e(com.baidu.swan.apps.u.b.j jVar) {
            }
        });
        if (this.cWV == null) {
            this.cWV = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void axR() {
                    g.this.cXc = true;
                    if (g.this.cXd) {
                        g.this.axP();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void axS() {
                    g.this.cXc = false;
                    g.this.awZ();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.cWV);
        }
        this.cWT.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.bMP != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.cXd = true;
                    if (g.this.cXc) {
                        g.this.axP();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.cXd = false;
                }
            }
        }
    }
}
