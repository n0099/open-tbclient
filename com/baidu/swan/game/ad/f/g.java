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
    private com.baidu.swan.apps.media.c.a bbU;
    public String cgM;
    private String chR;
    private AdElementInfo ciR;
    private com.baidu.swan.game.ad.b ciY;
    private com.baidu.swan.games.view.a cja;
    private j cjb;
    private k cjc;
    public com.baidu.swan.apps.res.widget.dialog.g cjd;
    private i cje;
    private boolean cjf;
    private a cjg;
    private boolean cjh;
    private int ciZ = 256;
    private int mPausePosition = 0;
    private boolean cji = true;
    private Context mContext = AppRuntime.getAppContext();
    private b ciQ = new b(this.mContext);

    public g(String str, String str2) {
        this.cgM = "";
        this.chR = str;
        this.cgM = str2;
    }

    public void a(i iVar) {
        this.cje = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.ciZ == 257) {
            com.baidu.swan.game.ad.f.a.akG().a(d);
        } else if (this.ciZ == 261 || this.ciZ == 260 || this.ciZ == 265) {
            a(d, "3010006");
        } else {
            if (this.ciZ == 258) {
                if (akP()) {
                    this.ciZ = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.ciZ == 259 || this.ciZ == 262 || this.ciZ == 263 || this.ciZ == 264 || this.ciZ == 256 || this.ciZ == 272) {
                com.baidu.swan.apps.runtime.e acI = com.baidu.swan.apps.runtime.e.acI();
                String str = "";
                if (acI != null) {
                    str = acI.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.chR) || TextUtils.isEmpty(this.cgM)) {
                    a(d, "3010007");
                } else {
                    this.cjb = d;
                    this.ciZ = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().nN(this.chR).nO(this.cgM).nP(str).akC());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bW("video", null);
                    aVar.a(eVar, this.ciQ);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.ciZ == 261 || this.ciZ == 260 || this.ciZ == 265) {
            if (e != null) {
                e.nV("3010004");
            }
            if (this.cje != null) {
                this.cje.onError("3010004");
            }
        } else if (this.ciZ != 258 || akP()) {
            a(e, "3010004");
        } else if (this.ciR != null && TextUtils.isEmpty(this.ciR.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.ciZ == 258) {
            this.ciZ = 265;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.akQ();
                    if (com.baidu.swan.games.view.a.c.ay(g.this.ciY.getConvertView())) {
                        com.baidu.swan.games.view.a.c.au(g.this.ciY.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.ciY.getConvertView(), com.baidu.swan.apps.model.a.a.a.Yz())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.cjc = e;
                    g.this.ciZ = 260;
                    g.this.ciY.V(g.this.ciR.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void b(AdElementInfo adElementInfo) {
        this.ciR = adElementInfo;
        this.ciZ = 258;
        c(this.cjb);
        com.baidu.swan.games.view.a.b.bW("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0327a
    public void nH(String str) {
        this.ciZ = 259;
        a(this.cjb, str);
        com.baidu.swan.games.view.a.b.N("video", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void aku() {
        SwanAppActivity WG;
        int i;
        int i2;
        int i3;
        if (this.bbU != null && (WG = com.baidu.swan.apps.y.f.WV().WG()) != null && !this.cjf) {
            int aqC = com.baidu.swan.games.view.a.c.aqC();
            int aqD = com.baidu.swan.games.view.a.c.aqD();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aqC * 0.275f);
                i2 = (int) (aqC * 0.275f);
                i3 = (int) (0.05f * aqD);
            } else {
                i = (int) (aqC * 0.1f);
                i2 = (int) (aqC * 0.1f);
                i3 = 0;
            }
            pausePlay();
            if (this.bbU.isEnd()) {
                akN();
                return;
            }
            boolean z = this.bbU.getDuration() / 1000 > 15;
            this.cjf = true;
            this.cjd = new g.a(WG).dC(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.akN();
                    g.this.cjf = false;
                    com.baidu.swan.games.view.a.b.bW("video", "close");
                }
            }).eC(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.continuePlay();
                    g.this.cjf = false;
                }
            }).fW(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.cjf = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).o(i, 0, i2, i3).acs();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void lg() {
        com.baidu.swan.apps.core.d.e GH = com.baidu.swan.apps.y.f.WV().GH();
        if (GH == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.ciR != null) {
            String ako = this.ciR.ako();
            GH.ha("adLanding").Y(com.baidu.swan.apps.core.d.e.bos, com.baidu.swan.apps.core.d.e.bou).a("adLanding", com.baidu.swan.apps.model.b.aW(ako, ako)).OC();
        }
        com.baidu.swan.game.ad.d.a.b(this.ciR, this.ciQ);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akN() {
        if (this.cje != null && this.bbU != null) {
            this.cje.ew(this.bbU.isEnd());
        }
        akO();
        com.baidu.swan.game.ad.d.a.d(this.ciR, this.ciQ);
        this.ciZ = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akO() {
        if (this.bbU != null) {
            this.bbU.pause();
            this.bbU.onDestroy();
        }
        if (this.cjg != null) {
            this.mContext.unregisterReceiver(this.cjg);
            this.cjg = null;
        }
        if (this.ciY != null) {
            this.ciY.ake();
            this.ciY.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.au(this.ciY.getConvertView());
        }
        if (this.cja != null) {
            com.baidu.swan.games.view.a.c.b(this.cja);
            this.cja = null;
        }
    }

    private boolean akP() {
        if (this.ciR == null) {
            return true;
        }
        long akp = this.ciR.akp() * 1000;
        if (akp == 0) {
            akp = 1740000;
        }
        return System.currentTimeMillis() - this.ciR.getCreateTime() >= akp;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.bbU != null) {
            return this.bbU.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.cje != null) {
            this.cje.onLoad();
        }
        if (jVar != null) {
            jVar.akT();
        }
        com.baidu.swan.game.ad.f.a.akG().F(16, "");
    }

    private void a(j jVar, String str) {
        if (this.cje != null) {
            this.cje.onError(str);
        }
        if (jVar != null) {
            jVar.nU(str);
        }
        com.baidu.swan.game.ad.f.a.akG().F(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        if (this.bbU != null && this.ciY != null && this.bbU.isPlaying()) {
            this.bbU.pause();
            this.ciY.pausePlay();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.ciR, this.ciQ);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continuePlay() {
        if (this.bbU != null && this.ciY != null) {
            if ((this.cjd == null || !this.cjd.isShowing()) && !this.bbU.isPlaying() && !this.bbU.isEnd()) {
                this.bbU.resume();
                this.ciY.akd();
                com.baidu.swan.game.ad.d.a.c(this.ciR, this.ciQ);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.nV(str);
        }
        if (this.cje != null) {
            this.cje.onError(str);
        }
        this.ciZ = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void akQ() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.ciY = new com.baidu.swan.game.ad.d(this.mContext, this.ciR);
        } else {
            this.ciY = new com.baidu.swan.game.ad.e(this.mContext, this.ciR);
        }
        this.ciY.a((a.b) this);
        this.ciY.a((a.c) this);
        this.bbU = this.ciY.getPlayer();
        this.bbU.b(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.c.b
            public void a(com.baidu.swan.apps.w.b.l lVar) {
                if (g.this.bbU != null) {
                    g.this.bbU.cK(true);
                }
                if (g.this.ciY != null) {
                    g.this.ciY.onPrepared();
                }
                g.this.ciZ = 261;
                g.this.mPausePosition = 0;
                if (g.this.ciY != null) {
                    g.this.ciY.akc();
                }
                if (g.this.cjc != null) {
                    g.this.cjc.akU();
                }
                if (g.this.cjg == null) {
                    g.this.cjg = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.cjg, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.ciR, g.this.ciQ);
                com.baidu.swan.game.ad.d.a.c(g.this.ciR, g.this.ciQ);
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(com.baidu.swan.apps.w.b.l lVar, int i, int i2) {
                g.this.akO();
                g.this.a(g.this.cjc, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(com.baidu.swan.apps.w.b.l lVar) {
                g.this.ciZ = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.ciR, g.this.ciQ);
                if (g.this.ciY != null) {
                    g.this.ciY.akf();
                }
            }
        });
        if (this.cja == null) {
            this.cja = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void akR() {
                    g.this.cjh = true;
                    if (g.this.cji) {
                        g.this.continuePlay();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void akS() {
                    g.this.cjh = false;
                    g.this.pausePlay();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.cja);
        }
        this.ciY.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes11.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.bbU != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.cji = true;
                    if (g.this.cjh) {
                        g.this.continuePlay();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.cji = false;
                }
            }
        }
    }
}
