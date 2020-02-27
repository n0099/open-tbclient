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
/* loaded from: classes11.dex */
public class g implements a.InterfaceC0327a, a.b, a.c {
    private com.baidu.swan.apps.media.c.a bbF;
    public String cgz;
    private String chE;
    private AdElementInfo ciE;
    private com.baidu.swan.game.ad.b ciL;
    private com.baidu.swan.games.view.a ciN;
    private j ciO;
    private k ciP;
    public com.baidu.swan.apps.res.widget.dialog.g ciQ;
    private i ciR;
    private boolean ciS;
    private a ciT;
    private boolean ciU;
    private int ciM = 256;
    private int mPausePosition = 0;
    private boolean ciV = true;
    private Context mContext = AppRuntime.getAppContext();
    private b ciD = new b(this.mContext);

    public g(String str, String str2) {
        this.cgz = "";
        this.chE = str;
        this.cgz = str2;
    }

    public void a(i iVar) {
        this.ciR = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.ciM == 257) {
            com.baidu.swan.game.ad.f.a.akB().a(d);
        } else if (this.ciM == 261 || this.ciM == 260 || this.ciM == 265) {
            a(d, "3010006");
        } else {
            if (this.ciM == 258) {
                if (akK()) {
                    this.ciM = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.ciM == 259 || this.ciM == 262 || this.ciM == 263 || this.ciM == 264 || this.ciM == 256 || this.ciM == 272) {
                com.baidu.swan.apps.runtime.e acD = com.baidu.swan.apps.runtime.e.acD();
                String str = "";
                if (acD != null) {
                    str = acD.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.chE) || TextUtils.isEmpty(this.cgz)) {
                    a(d, "3010007");
                } else {
                    this.ciO = d;
                    this.ciM = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().nO(this.chE).nP(this.cgz).nQ(str).akx());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bX("video", null);
                    aVar.a(eVar, this.ciD);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.ciM == 261 || this.ciM == 260 || this.ciM == 265) {
            if (e != null) {
                e.nW("3010004");
            }
            if (this.ciR != null) {
                this.ciR.onError("3010004");
            }
        } else if (this.ciM != 258 || akK()) {
            a(e, "3010004");
        } else if (this.ciE != null && TextUtils.isEmpty(this.ciE.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.ciM == 258) {
            this.ciM = 265;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.akL();
                    if (com.baidu.swan.games.view.a.c.ay(g.this.ciL.getConvertView())) {
                        com.baidu.swan.games.view.a.c.au(g.this.ciL.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.ciL.getConvertView(), com.baidu.swan.apps.model.a.a.a.Yu())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.ciP = e;
                    g.this.ciM = 260;
                    g.this.ciL.V(g.this.ciE.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void b(AdElementInfo adElementInfo) {
        this.ciE = adElementInfo;
        this.ciM = 258;
        c(this.ciO);
        com.baidu.swan.games.view.a.b.bX("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void nI(String str) {
        this.ciM = 259;
        a(this.ciO, str);
        com.baidu.swan.games.view.a.b.N("video", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void akp() {
        SwanAppActivity WB;
        int i;
        int i2;
        int i3;
        if (this.bbF != null && (WB = com.baidu.swan.apps.y.f.WQ().WB()) != null && !this.ciS) {
            int aqx = com.baidu.swan.games.view.a.c.aqx();
            int aqy = com.baidu.swan.games.view.a.c.aqy();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aqx * 0.275f);
                i2 = (int) (aqx * 0.275f);
                i3 = (int) (0.05f * aqy);
            } else {
                i = (int) (aqx * 0.1f);
                i2 = (int) (aqx * 0.1f);
                i3 = 0;
            }
            pausePlay();
            if (this.bbF.isEnd()) {
                akI();
                return;
            }
            boolean z = this.bbF.getDuration() / 1000 > 15;
            this.ciS = true;
            this.ciQ = new g.a(WB).dB(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.akI();
                    g.this.ciS = false;
                    com.baidu.swan.games.view.a.b.bX("video", "close");
                }
            }).eC(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.continuePlay();
                    g.this.ciS = false;
                }
            }).fW(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.ciS = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).o(i, 0, i2, i3).acn();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void lg() {
        com.baidu.swan.apps.core.d.e GA = com.baidu.swan.apps.y.f.WQ().GA();
        if (GA == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.ciE != null) {
            String akj = this.ciE.akj();
            GA.hb("adLanding").Y(com.baidu.swan.apps.core.d.e.boe, com.baidu.swan.apps.core.d.e.bog).a("adLanding", com.baidu.swan.apps.model.b.aX(akj, akj)).Ox();
        }
        com.baidu.swan.game.ad.d.a.b(this.ciE, this.ciD);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akI() {
        if (this.ciR != null && this.bbF != null) {
            this.ciR.ev(this.bbF.isEnd());
        }
        akJ();
        com.baidu.swan.game.ad.d.a.d(this.ciE, this.ciD);
        this.ciM = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akJ() {
        if (this.bbF != null) {
            this.bbF.pause();
            this.bbF.onDestroy();
        }
        if (this.ciT != null) {
            this.mContext.unregisterReceiver(this.ciT);
            this.ciT = null;
        }
        if (this.ciL != null) {
            this.ciL.ajZ();
            this.ciL.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.au(this.ciL.getConvertView());
        }
        if (this.ciN != null) {
            com.baidu.swan.games.view.a.c.b(this.ciN);
            this.ciN = null;
        }
    }

    private boolean akK() {
        if (this.ciE == null) {
            return true;
        }
        long akk = this.ciE.akk() * 1000;
        if (akk == 0) {
            akk = 1740000;
        }
        return System.currentTimeMillis() - this.ciE.getCreateTime() >= akk;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bbF != null) {
            return this.bbF.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.ciR != null) {
            this.ciR.onLoad();
        }
        if (jVar != null) {
            jVar.akO();
        }
        com.baidu.swan.game.ad.f.a.akB().F(16, "");
    }

    private void a(j jVar, String str) {
        if (this.ciR != null) {
            this.ciR.onError(str);
        }
        if (jVar != null) {
            jVar.nV(str);
        }
        com.baidu.swan.game.ad.f.a.akB().F(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        if (this.bbF != null && this.ciL != null && this.bbF.isPlaying()) {
            this.bbF.pause();
            this.ciL.pausePlay();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.ciE, this.ciD);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continuePlay() {
        if (this.bbF != null && this.ciL != null) {
            if ((this.ciQ == null || !this.ciQ.isShowing()) && !this.bbF.isPlaying() && !this.bbF.isEnd()) {
                this.bbF.resume();
                this.ciL.ajY();
                com.baidu.swan.game.ad.d.a.c(this.ciE, this.ciD);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.nW(str);
        }
        if (this.ciR != null) {
            this.ciR.onError(str);
        }
        this.ciM = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.ciL = new com.baidu.swan.game.ad.d(this.mContext, this.ciE);
        } else {
            this.ciL = new com.baidu.swan.game.ad.e(this.mContext, this.ciE);
        }
        this.ciL.a((a.b) this);
        this.ciL.a((a.c) this);
        this.bbF = this.ciL.getPlayer();
        this.bbF.b(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.c.b
            public void a(com.baidu.swan.apps.w.b.l lVar) {
                if (g.this.bbF != null) {
                    g.this.bbF.cJ(true);
                }
                if (g.this.ciL != null) {
                    g.this.ciL.onPrepared();
                }
                g.this.ciM = 261;
                g.this.mPausePosition = 0;
                if (g.this.ciL != null) {
                    g.this.ciL.ajX();
                }
                if (g.this.ciP != null) {
                    g.this.ciP.akP();
                }
                if (g.this.ciT == null) {
                    g.this.ciT = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.ciT, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.ciE, g.this.ciD);
                com.baidu.swan.game.ad.d.a.c(g.this.ciE, g.this.ciD);
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(com.baidu.swan.apps.w.b.l lVar, int i, int i2) {
                g.this.akJ();
                g.this.a(g.this.ciP, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(com.baidu.swan.apps.w.b.l lVar) {
                g.this.ciM = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.ciE, g.this.ciD);
                if (g.this.ciL != null) {
                    g.this.ciL.aka();
                }
            }
        });
        if (this.ciN == null) {
            this.ciN = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void akM() {
                    g.this.ciU = true;
                    if (g.this.ciV) {
                        g.this.continuePlay();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void akN() {
                    g.this.ciU = false;
                    g.this.pausePlay();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.ciN);
        }
        this.ciL.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.bbF != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.ciV = true;
                    if (g.this.ciU) {
                        g.this.continuePlay();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.ciV = false;
                }
            }
        }
    }
}
