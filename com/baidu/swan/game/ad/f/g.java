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
    private com.baidu.swan.apps.media.c.a bbH;
    public String cgB;
    private String chG;
    private AdElementInfo ciG;
    private com.baidu.swan.game.ad.b ciN;
    private com.baidu.swan.games.view.a ciP;
    private j ciQ;
    private k ciR;
    public com.baidu.swan.apps.res.widget.dialog.g ciS;
    private i ciT;
    private boolean ciU;
    private a ciV;
    private boolean ciW;
    private int ciO = 256;
    private int mPausePosition = 0;
    private boolean ciX = true;
    private Context mContext = AppRuntime.getAppContext();
    private b ciF = new b(this.mContext);

    public g(String str, String str2) {
        this.cgB = "";
        this.chG = str;
        this.cgB = str2;
    }

    public void a(i iVar) {
        this.ciT = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.ciO == 257) {
            com.baidu.swan.game.ad.f.a.akD().a(d);
        } else if (this.ciO == 261 || this.ciO == 260 || this.ciO == 265) {
            a(d, "3010006");
        } else {
            if (this.ciO == 258) {
                if (akM()) {
                    this.ciO = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.ciO == 259 || this.ciO == 262 || this.ciO == 263 || this.ciO == 264 || this.ciO == 256 || this.ciO == 272) {
                com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                String str = "";
                if (acF != null) {
                    str = acF.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.chG) || TextUtils.isEmpty(this.cgB)) {
                    a(d, "3010007");
                } else {
                    this.ciQ = d;
                    this.ciO = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().nO(this.chG).nP(this.cgB).nQ(str).akz());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bX("video", null);
                    aVar.a(eVar, this.ciF);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.ciO == 261 || this.ciO == 260 || this.ciO == 265) {
            if (e != null) {
                e.nW("3010004");
            }
            if (this.ciT != null) {
                this.ciT.onError("3010004");
            }
        } else if (this.ciO != 258 || akM()) {
            a(e, "3010004");
        } else if (this.ciG != null && TextUtils.isEmpty(this.ciG.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.ciO == 258) {
            this.ciO = 265;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.akN();
                    if (com.baidu.swan.games.view.a.c.ay(g.this.ciN.getConvertView())) {
                        com.baidu.swan.games.view.a.c.au(g.this.ciN.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.ciN.getConvertView(), com.baidu.swan.apps.model.a.a.a.Yw())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.ciR = e;
                    g.this.ciO = 260;
                    g.this.ciN.V(g.this.ciG.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void b(AdElementInfo adElementInfo) {
        this.ciG = adElementInfo;
        this.ciO = 258;
        c(this.ciQ);
        com.baidu.swan.games.view.a.b.bX("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void nI(String str) {
        this.ciO = 259;
        a(this.ciQ, str);
        com.baidu.swan.games.view.a.b.N("video", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void akr() {
        SwanAppActivity WD;
        int i;
        int i2;
        int i3;
        if (this.bbH != null && (WD = com.baidu.swan.apps.y.f.WS().WD()) != null && !this.ciU) {
            int aqz = com.baidu.swan.games.view.a.c.aqz();
            int aqA = com.baidu.swan.games.view.a.c.aqA();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aqz * 0.275f);
                i2 = (int) (aqz * 0.275f);
                i3 = (int) (0.05f * aqA);
            } else {
                i = (int) (aqz * 0.1f);
                i2 = (int) (aqz * 0.1f);
                i3 = 0;
            }
            pausePlay();
            if (this.bbH.isEnd()) {
                akK();
                return;
            }
            boolean z = this.bbH.getDuration() / 1000 > 15;
            this.ciU = true;
            this.ciS = new g.a(WD).dB(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.akK();
                    g.this.ciU = false;
                    com.baidu.swan.games.view.a.b.bX("video", "close");
                }
            }).eC(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.continuePlay();
                    g.this.ciU = false;
                }
            }).fW(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.ciU = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).o(i, 0, i2, i3).acp();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void lg() {
        com.baidu.swan.apps.core.d.e GC = com.baidu.swan.apps.y.f.WS().GC();
        if (GC == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.ciG != null) {
            String akl = this.ciG.akl();
            GC.hb("adLanding").Y(com.baidu.swan.apps.core.d.e.bog, com.baidu.swan.apps.core.d.e.boi).a("adLanding", com.baidu.swan.apps.model.b.aX(akl, akl)).Oz();
        }
        com.baidu.swan.game.ad.d.a.b(this.ciG, this.ciF);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akK() {
        if (this.ciT != null && this.bbH != null) {
            this.ciT.ev(this.bbH.isEnd());
        }
        akL();
        com.baidu.swan.game.ad.d.a.d(this.ciG, this.ciF);
        this.ciO = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        if (this.bbH != null) {
            this.bbH.pause();
            this.bbH.onDestroy();
        }
        if (this.ciV != null) {
            this.mContext.unregisterReceiver(this.ciV);
            this.ciV = null;
        }
        if (this.ciN != null) {
            this.ciN.akb();
            this.ciN.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.au(this.ciN.getConvertView());
        }
        if (this.ciP != null) {
            com.baidu.swan.games.view.a.c.b(this.ciP);
            this.ciP = null;
        }
    }

    private boolean akM() {
        if (this.ciG == null) {
            return true;
        }
        long akm = this.ciG.akm() * 1000;
        if (akm == 0) {
            akm = 1740000;
        }
        return System.currentTimeMillis() - this.ciG.getCreateTime() >= akm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bbH != null) {
            return this.bbH.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.ciT != null) {
            this.ciT.onLoad();
        }
        if (jVar != null) {
            jVar.akQ();
        }
        com.baidu.swan.game.ad.f.a.akD().F(16, "");
    }

    private void a(j jVar, String str) {
        if (this.ciT != null) {
            this.ciT.onError(str);
        }
        if (jVar != null) {
            jVar.nV(str);
        }
        com.baidu.swan.game.ad.f.a.akD().F(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        if (this.bbH != null && this.ciN != null && this.bbH.isPlaying()) {
            this.bbH.pause();
            this.ciN.pausePlay();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.ciG, this.ciF);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continuePlay() {
        if (this.bbH != null && this.ciN != null) {
            if ((this.ciS == null || !this.ciS.isShowing()) && !this.bbH.isPlaying() && !this.bbH.isEnd()) {
                this.bbH.resume();
                this.ciN.aka();
                com.baidu.swan.game.ad.d.a.c(this.ciG, this.ciF);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.nW(str);
        }
        if (this.ciT != null) {
            this.ciT.onError(str);
        }
        this.ciO = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akN() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.ciN = new com.baidu.swan.game.ad.d(this.mContext, this.ciG);
        } else {
            this.ciN = new com.baidu.swan.game.ad.e(this.mContext, this.ciG);
        }
        this.ciN.a((a.b) this);
        this.ciN.a((a.c) this);
        this.bbH = this.ciN.getPlayer();
        this.bbH.b(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.c.b
            public void a(com.baidu.swan.apps.w.b.l lVar) {
                if (g.this.bbH != null) {
                    g.this.bbH.cJ(true);
                }
                if (g.this.ciN != null) {
                    g.this.ciN.onPrepared();
                }
                g.this.ciO = 261;
                g.this.mPausePosition = 0;
                if (g.this.ciN != null) {
                    g.this.ciN.ajZ();
                }
                if (g.this.ciR != null) {
                    g.this.ciR.akR();
                }
                if (g.this.ciV == null) {
                    g.this.ciV = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.ciV, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.ciG, g.this.ciF);
                com.baidu.swan.game.ad.d.a.c(g.this.ciG, g.this.ciF);
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(com.baidu.swan.apps.w.b.l lVar, int i, int i2) {
                g.this.akL();
                g.this.a(g.this.ciR, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(com.baidu.swan.apps.w.b.l lVar) {
                g.this.ciO = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.ciG, g.this.ciF);
                if (g.this.ciN != null) {
                    g.this.ciN.akc();
                }
            }
        });
        if (this.ciP == null) {
            this.ciP = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void akO() {
                    g.this.ciW = true;
                    if (g.this.ciX) {
                        g.this.continuePlay();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void akP() {
                    g.this.ciW = false;
                    g.this.pausePlay();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.ciP);
        }
        this.ciN.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.bbH != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.ciX = true;
                    if (g.this.ciW) {
                        g.this.continuePlay();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.ciX = false;
                }
            }
        }
    }
}
