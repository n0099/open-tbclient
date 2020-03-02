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
    private com.baidu.swan.apps.media.c.a bbG;
    public String cgA;
    private String chF;
    private AdElementInfo ciF;
    private com.baidu.swan.game.ad.b ciM;
    private com.baidu.swan.games.view.a ciO;
    private j ciP;
    private k ciQ;
    public com.baidu.swan.apps.res.widget.dialog.g ciR;
    private i ciS;
    private boolean ciT;
    private a ciU;
    private boolean ciV;
    private int ciN = 256;
    private int mPausePosition = 0;
    private boolean ciW = true;
    private Context mContext = AppRuntime.getAppContext();
    private b ciE = new b(this.mContext);

    public g(String str, String str2) {
        this.cgA = "";
        this.chF = str;
        this.cgA = str2;
    }

    public void a(i iVar) {
        this.ciS = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.ciN == 257) {
            com.baidu.swan.game.ad.f.a.akD().a(d);
        } else if (this.ciN == 261 || this.ciN == 260 || this.ciN == 265) {
            a(d, "3010006");
        } else {
            if (this.ciN == 258) {
                if (akM()) {
                    this.ciN = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.ciN == 259 || this.ciN == 262 || this.ciN == 263 || this.ciN == 264 || this.ciN == 256 || this.ciN == 272) {
                com.baidu.swan.apps.runtime.e acF = com.baidu.swan.apps.runtime.e.acF();
                String str = "";
                if (acF != null) {
                    str = acF.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.chF) || TextUtils.isEmpty(this.cgA)) {
                    a(d, "3010007");
                } else {
                    this.ciP = d;
                    this.ciN = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().nO(this.chF).nP(this.cgA).nQ(str).akz());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bX("video", null);
                    aVar.a(eVar, this.ciE);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.ciN == 261 || this.ciN == 260 || this.ciN == 265) {
            if (e != null) {
                e.nW("3010004");
            }
            if (this.ciS != null) {
                this.ciS.onError("3010004");
            }
        } else if (this.ciN != 258 || akM()) {
            a(e, "3010004");
        } else if (this.ciF != null && TextUtils.isEmpty(this.ciF.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.ciN == 258) {
            this.ciN = 265;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.akN();
                    if (com.baidu.swan.games.view.a.c.ay(g.this.ciM.getConvertView())) {
                        com.baidu.swan.games.view.a.c.au(g.this.ciM.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.ciM.getConvertView(), com.baidu.swan.apps.model.a.a.a.Yw())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.ciQ = e;
                    g.this.ciN = 260;
                    g.this.ciM.V(g.this.ciF.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void b(AdElementInfo adElementInfo) {
        this.ciF = adElementInfo;
        this.ciN = 258;
        c(this.ciP);
        com.baidu.swan.games.view.a.b.bX("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void nI(String str) {
        this.ciN = 259;
        a(this.ciP, str);
        com.baidu.swan.games.view.a.b.N("video", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void akr() {
        SwanAppActivity WD;
        int i;
        int i2;
        int i3;
        if (this.bbG != null && (WD = com.baidu.swan.apps.y.f.WS().WD()) != null && !this.ciT) {
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
            if (this.bbG.isEnd()) {
                akK();
                return;
            }
            boolean z = this.bbG.getDuration() / 1000 > 15;
            this.ciT = true;
            this.ciR = new g.a(WD).dB(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.akK();
                    g.this.ciT = false;
                    com.baidu.swan.games.view.a.b.bX("video", "close");
                }
            }).eC(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.continuePlay();
                    g.this.ciT = false;
                }
            }).fW(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.ciT = false;
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
        if (this.ciF != null) {
            String akl = this.ciF.akl();
            GC.hb("adLanding").Y(com.baidu.swan.apps.core.d.e.bof, com.baidu.swan.apps.core.d.e.boh).a("adLanding", com.baidu.swan.apps.model.b.aX(akl, akl)).Oz();
        }
        com.baidu.swan.game.ad.d.a.b(this.ciF, this.ciE);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akK() {
        if (this.ciS != null && this.bbG != null) {
            this.ciS.ev(this.bbG.isEnd());
        }
        akL();
        com.baidu.swan.game.ad.d.a.d(this.ciF, this.ciE);
        this.ciN = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akL() {
        if (this.bbG != null) {
            this.bbG.pause();
            this.bbG.onDestroy();
        }
        if (this.ciU != null) {
            this.mContext.unregisterReceiver(this.ciU);
            this.ciU = null;
        }
        if (this.ciM != null) {
            this.ciM.akb();
            this.ciM.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.au(this.ciM.getConvertView());
        }
        if (this.ciO != null) {
            com.baidu.swan.games.view.a.c.b(this.ciO);
            this.ciO = null;
        }
    }

    private boolean akM() {
        if (this.ciF == null) {
            return true;
        }
        long akm = this.ciF.akm() * 1000;
        if (akm == 0) {
            akm = 1740000;
        }
        return System.currentTimeMillis() - this.ciF.getCreateTime() >= akm;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bbG != null) {
            return this.bbG.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.ciS != null) {
            this.ciS.onLoad();
        }
        if (jVar != null) {
            jVar.akQ();
        }
        com.baidu.swan.game.ad.f.a.akD().F(16, "");
    }

    private void a(j jVar, String str) {
        if (this.ciS != null) {
            this.ciS.onError(str);
        }
        if (jVar != null) {
            jVar.nV(str);
        }
        com.baidu.swan.game.ad.f.a.akD().F(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        if (this.bbG != null && this.ciM != null && this.bbG.isPlaying()) {
            this.bbG.pause();
            this.ciM.pausePlay();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.ciF, this.ciE);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continuePlay() {
        if (this.bbG != null && this.ciM != null) {
            if ((this.ciR == null || !this.ciR.isShowing()) && !this.bbG.isPlaying() && !this.bbG.isEnd()) {
                this.bbG.resume();
                this.ciM.aka();
                com.baidu.swan.game.ad.d.a.c(this.ciF, this.ciE);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.nW(str);
        }
        if (this.ciS != null) {
            this.ciS.onError(str);
        }
        this.ciN = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akN() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.ciM = new com.baidu.swan.game.ad.d(this.mContext, this.ciF);
        } else {
            this.ciM = new com.baidu.swan.game.ad.e(this.mContext, this.ciF);
        }
        this.ciM.a((a.b) this);
        this.ciM.a((a.c) this);
        this.bbG = this.ciM.getPlayer();
        this.bbG.b(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.c.b
            public void a(com.baidu.swan.apps.w.b.l lVar) {
                if (g.this.bbG != null) {
                    g.this.bbG.cJ(true);
                }
                if (g.this.ciM != null) {
                    g.this.ciM.onPrepared();
                }
                g.this.ciN = 261;
                g.this.mPausePosition = 0;
                if (g.this.ciM != null) {
                    g.this.ciM.ajZ();
                }
                if (g.this.ciQ != null) {
                    g.this.ciQ.akR();
                }
                if (g.this.ciU == null) {
                    g.this.ciU = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.ciU, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.ciF, g.this.ciE);
                com.baidu.swan.game.ad.d.a.c(g.this.ciF, g.this.ciE);
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(com.baidu.swan.apps.w.b.l lVar, int i, int i2) {
                g.this.akL();
                g.this.a(g.this.ciQ, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(com.baidu.swan.apps.w.b.l lVar) {
                g.this.ciN = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.ciF, g.this.ciE);
                if (g.this.ciM != null) {
                    g.this.ciM.akc();
                }
            }
        });
        if (this.ciO == null) {
            this.ciO = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void akO() {
                    g.this.ciV = true;
                    if (g.this.ciW) {
                        g.this.continuePlay();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void akP() {
                    g.this.ciV = false;
                    g.this.pausePlay();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.ciO);
        }
        this.ciM.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.bbG != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.ciW = true;
                    if (g.this.ciV) {
                        g.this.continuePlay();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.ciW = false;
                }
            }
        }
    }
}
