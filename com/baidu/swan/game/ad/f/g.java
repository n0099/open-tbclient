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
public class g implements a.InterfaceC0418a, a.b, a.c {
    private com.baidu.swan.apps.media.b.a bIb;
    public String cQa;
    private String cRd;
    private AdElementInfo cSc;
    private com.baidu.swan.game.ad.b cSj;
    private com.baidu.swan.games.view.a cSl;
    private j cSm;
    private k cSn;
    public com.baidu.swan.apps.res.widget.dialog.g cSo;
    private i cSp;
    private boolean cSq;
    private a cSr;
    private boolean cSs;
    private int cSk = 256;
    private int mPausePosition = 0;
    private boolean cSt = true;
    private Context mContext = AppRuntime.getAppContext();
    private b cSb = new b(this.mContext);

    public g(String str, String str2) {
        this.cQa = "";
        this.cRd = str;
        this.cQa = str2;
    }

    public void a(i iVar) {
        this.cSp = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.cSk == 257) {
            com.baidu.swan.game.ad.f.a.awz().a(d);
        } else if (this.cSk == 261 || this.cSk == 260 || this.cSk == 265) {
            a(d, "3010006");
        } else {
            if (this.cSk == 258) {
                if (awI()) {
                    this.cSk = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.cSk == 259 || this.cSk == 262 || this.cSk == 263 || this.cSk == 264 || this.cSk == 256 || this.cSk == 272) {
                com.baidu.swan.apps.runtime.e aoF = com.baidu.swan.apps.runtime.e.aoF();
                String str = "";
                if (aoF != null) {
                    str = aoF.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.cRd) || TextUtils.isEmpty(this.cQa)) {
                    a(d, "3010007");
                } else {
                    this.cSm = d;
                    this.cSk = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().qA(this.cRd).qB(this.cQa).qC(str).awu());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.cC("video", null);
                    aVar.a(eVar, this.cSb);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.cSk == 261 || this.cSk == 260 || this.cSk == 265) {
            if (e != null) {
                e.qI("3010004");
            }
            if (this.cSp != null) {
                this.cSp.onError("3010004");
            }
        } else if (this.cSk != 258 || awI()) {
            a(e, "3010004");
        } else if (this.cSc != null && TextUtils.isEmpty(this.cSc.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.cSk == 258) {
            this.cSk = 265;
            aj.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.awK();
                    if (com.baidu.swan.games.view.a.c.ay(g.this.cSj.getConvertView())) {
                        com.baidu.swan.games.view.a.c.av(g.this.cSj.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.cSj.getConvertView(), com.baidu.swan.apps.model.a.a.a.ajX())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.cSn = e;
                    g.this.cSk = 260;
                    g.this.cSj.bk(g.this.cSc.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0418a
    public void b(AdElementInfo adElementInfo) {
        this.cSc = adElementInfo;
        this.cSk = 258;
        c(this.cSm);
        com.baidu.swan.games.view.a.b.cC("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0418a
    public void qu(String str) {
        this.cSk = 259;
        a(this.cSm, str);
        com.baidu.swan.games.view.a.b.Q("video", "fail", str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void awm() {
        SwanAppActivity ahF;
        int i;
        int i2;
        int i3;
        if (this.bIb != null && (ahF = com.baidu.swan.apps.w.f.ahV().ahF()) != null && !this.cSq) {
            int aCG = com.baidu.swan.games.view.a.c.aCG();
            int aCH = com.baidu.swan.games.view.a.c.aCH();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aCG * 0.275f);
                i2 = (int) (aCG * 0.275f);
                i3 = (int) (0.05f * aCH);
            } else {
                i = (int) (aCG * 0.1f);
                i2 = (int) (aCG * 0.1f);
                i3 = 0;
            }
            avT();
            if (this.bIb.isEnd()) {
                awG();
                return;
            }
            boolean z = this.bIb.getDuration() / 1000 > 15;
            this.cSq = true;
            this.cSo = new g.a(ahF).eR(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.awG();
                    g.this.cSq = false;
                    com.baidu.swan.games.view.a.b.cC("video", "close");
                }
            }).eS(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.awJ();
                    g.this.cSq = false;
                }
            }).gx(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.cSq = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).n(i, 0, i2, i3).aon();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void pQ() {
        com.baidu.swan.apps.core.d.e QH = com.baidu.swan.apps.w.f.ahV().QH();
        if (QH == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.cSc != null) {
            String awg = this.cSc.awg();
            QH.jp("adLanding").ae(com.baidu.swan.apps.core.d.e.bVN, com.baidu.swan.apps.core.d.e.bVP).a("adLanding", com.baidu.swan.apps.model.b.bx(awg, awg)).Zb();
        }
        com.baidu.swan.game.ad.d.a.b(this.cSc, this.cSb);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awG() {
        if (this.cSp != null && this.bIb != null) {
            this.cSp.fD(this.bIb.isEnd());
        }
        awH();
        com.baidu.swan.game.ad.d.a.d(this.cSc, this.cSb);
        this.cSk = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awH() {
        if (this.bIb != null) {
            this.bIb.pause();
            this.bIb.onDestroy();
        }
        if (this.cSr != null) {
            this.mContext.unregisterReceiver(this.cSr);
            this.cSr = null;
        }
        if (this.cSj != null) {
            this.cSj.avV();
            this.cSj.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.av(this.cSj.getConvertView());
        }
        if (this.cSl != null) {
            com.baidu.swan.games.view.a.c.b(this.cSl);
            this.cSl = null;
        }
    }

    private boolean awI() {
        if (this.cSc == null) {
            return true;
        }
        long awh = this.cSc.awh() * 1000;
        if (awh == 0) {
            awh = 1740000;
        }
        return System.currentTimeMillis() - this.cSc.getCreateTime() >= awh;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bIb != null) {
            return this.bIb.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.cSp != null) {
            this.cSp.onLoad();
        }
        if (jVar != null) {
            jVar.awN();
        }
        com.baidu.swan.game.ad.f.a.awz().X(16, "");
    }

    private void a(j jVar, String str) {
        if (this.cSp != null) {
            this.cSp.onError(str);
        }
        if (jVar != null) {
            jVar.qH(str);
        }
        com.baidu.swan.game.ad.f.a.awz().X(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void avT() {
        if (this.bIb != null && this.cSj != null && this.bIb.isPlaying()) {
            this.bIb.pause();
            this.cSj.avT();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.cSc, this.cSb);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awJ() {
        if (this.bIb != null && this.cSj != null) {
            if ((this.cSo == null || !this.cSo.isShowing()) && !this.bIb.isPlaying() && !this.bIb.isEnd()) {
                this.bIb.resume();
                this.cSj.avU();
                com.baidu.swan.game.ad.d.a.c(this.cSc, this.cSb);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.qI(str);
        }
        if (this.cSp != null) {
            this.cSp.onError(str);
        }
        this.cSk = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void awK() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.cSj = new com.baidu.swan.game.ad.d(this.mContext, this.cSc);
        } else {
            this.cSj = new com.baidu.swan.game.ad.e(this.mContext, this.cSc);
        }
        this.cSj.a((a.b) this);
        this.cSj.a((a.c) this);
        this.bIb = this.cSj.getPlayer();
        this.bIb.b(new com.baidu.swan.apps.media.b.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.b.b
            public void a(com.baidu.swan.apps.u.b.j jVar) {
                if (g.this.cSj != null) {
                    g.this.cSj.onPrepared();
                }
                g.this.cSk = 261;
                g.this.mPausePosition = 0;
                if (g.this.cSj != null) {
                    g.this.cSj.avS();
                }
                if (g.this.cSn != null) {
                    g.this.cSn.awO();
                }
                if (g.this.cSr == null) {
                    g.this.cSr = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.cSr, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.cSc, g.this.cSb);
                com.baidu.swan.game.ad.d.a.c(g.this.cSc, g.this.cSb);
            }

            @Override // com.baidu.swan.apps.media.b.b
            public boolean a(com.baidu.swan.apps.u.b.j jVar, int i, int i2) {
                g.this.awH();
                g.this.a(g.this.cSn, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.b.b
            public void b(com.baidu.swan.apps.u.b.j jVar) {
                g.this.cSk = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.cSc, g.this.cSb);
                if (g.this.cSj != null) {
                    g.this.cSj.avW();
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
        if (this.cSl == null) {
            this.cSl = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void awL() {
                    g.this.cSs = true;
                    if (g.this.cSt) {
                        g.this.awJ();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void awM() {
                    g.this.cSs = false;
                    g.this.avT();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.cSl);
        }
        this.cSj.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.bIb != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.cSt = true;
                    if (g.this.cSs) {
                        g.this.awJ();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.cSt = false;
                }
            }
        }
    }
}
