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
/* loaded from: classes10.dex */
public class g implements a.InterfaceC0317a, a.b, a.c {
    private com.baidu.swan.apps.media.c.a aXu;
    public String ccv;
    private String cdB;
    private AdElementInfo ceA;
    private com.baidu.swan.game.ad.b ceH;
    private com.baidu.swan.games.view.a ceJ;
    private j ceK;
    private k ceL;
    public com.baidu.swan.apps.res.widget.dialog.g ceM;
    private i ceN;
    private boolean ceO;
    private a ceP;
    private boolean ceQ;
    private int ceI = 256;
    private int mPausePosition = 0;
    private boolean ceR = true;
    private Context mContext = AppRuntime.getAppContext();
    private b cez = new b(this.mContext);

    public g(String str, String str2) {
        this.ccv = "";
        this.cdB = str;
        this.ccv = str2;
    }

    public void a(i iVar) {
        this.ceN = iVar;
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        j d = j.d(cVar);
        if (this.ceI == 257) {
            com.baidu.swan.game.ad.f.a.ain().a(d);
        } else if (this.ceI == 261 || this.ceI == 260 || this.ceI == 265) {
            a(d, "3010006");
        } else {
            if (this.ceI == 258) {
                if (aiw()) {
                    this.ceI = AuthorityState.STATE_INIT_ING;
                } else {
                    c(d);
                }
            }
            if (this.ceI == 259 || this.ceI == 262 || this.ceI == 263 || this.ceI == 264 || this.ceI == 256 || this.ceI == 272) {
                com.baidu.swan.apps.runtime.e aap = com.baidu.swan.apps.runtime.e.aap();
                String str = "";
                if (aap != null) {
                    str = aap.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.cdB) || TextUtils.isEmpty(this.ccv)) {
                    a(d, "3010007");
                } else {
                    this.ceK = d;
                    this.ceI = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.mContext, new b.a().nz(this.cdB).nA(this.ccv).nB(str).aij());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.mContext);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bO("video", null);
                    aVar.a(eVar, this.cez);
                }
            }
        }
    }

    public synchronized void c(com.baidu.swan.games.binding.model.c cVar) {
        final k e = k.e(cVar);
        if (this.ceI == 261 || this.ceI == 260 || this.ceI == 265) {
            if (e != null) {
                e.nH("3010004");
            }
            if (this.ceN != null) {
                this.ceN.onError("3010004");
            }
        } else if (this.ceI != 258 || aiw()) {
            a(e, "3010004");
        } else if (this.ceA != null && TextUtils.isEmpty(this.ceA.getVideoUrl())) {
            a(e, "3010008");
        } else if (this.ceI == 258) {
            this.ceI = 265;
            ai.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.g.1
                @Override // java.lang.Runnable
                public void run() {
                    g.this.aix();
                    if (com.baidu.swan.games.view.a.c.ay(g.this.ceH.getConvertView())) {
                        com.baidu.swan.games.view.a.c.au(g.this.ceH.getConvertView());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(g.this.ceH.getConvertView(), com.baidu.swan.apps.model.a.a.a.Wg())) {
                        g.this.a(e, "3010000");
                        return;
                    }
                    g.this.ceL = e;
                    g.this.ceI = 260;
                    g.this.ceH.U(g.this.ceA.getVideoUrl());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0317a
    public void b(AdElementInfo adElementInfo) {
        this.ceA = adElementInfo;
        this.ceI = 258;
        c(this.ceK);
        com.baidu.swan.games.view.a.b.bO("video", "success");
    }

    @Override // com.baidu.swan.game.ad.a.a.InterfaceC0317a
    public void nt(String str) {
        this.ceI = 259;
        a(this.ceK, str);
        com.baidu.swan.games.view.a.b.M("video", LivenessStat.TYPE_FACE_MATCH_FAIL, str);
    }

    @Override // com.baidu.swan.game.ad.a.a.b
    public void aib() {
        SwanAppActivity Un;
        int i;
        int i2;
        int i3;
        if (this.aXu != null && (Un = com.baidu.swan.apps.y.f.UC().Un()) != null && !this.ceO) {
            int aoj = com.baidu.swan.games.view.a.c.aoj();
            int aok = com.baidu.swan.games.view.a.c.aok();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (aoj * 0.275f);
                i2 = (int) (aoj * 0.275f);
                i3 = (int) (0.05f * aok);
            } else {
                i = (int) (aoj * 0.1f);
                i2 = (int) (aoj * 0.1f);
                i3 = 0;
            }
            pausePlay();
            if (this.aXu.isEnd()) {
                aiu();
                return;
            }
            boolean z = this.aXu.getDuration() / 1000 > 15;
            this.ceO = true;
            this.ceM = new g.a(Un).du(true).d(c.g.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.aiu();
                    g.this.ceO = false;
                    com.baidu.swan.games.view.a.b.bO("video", "close");
                }
            }).em(z ? c.g.swangame_game_ad_dialog_msg_more : c.g.ad_dialog_msg_tip).c(c.g.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.g.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    g.this.continuePlay();
                    g.this.ceO = false;
                }
            }).fG(c.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.g.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    g.this.ceO = false;
                }
            }).a(new com.baidu.swan.apps.view.c.a()).o(i, 0, i2, i3).ZZ();
        }
    }

    @Override // com.baidu.swan.game.ad.a.a.c
    public void kR() {
        com.baidu.swan.apps.core.d.e El = com.baidu.swan.apps.y.f.UC().El();
        if (El == null) {
            if (this.mContext != null) {
                com.baidu.swan.apps.res.widget.b.d.q(this.mContext, c.g.aiapps_open_fragment_failed_toast).showToast();
                return;
            }
            return;
        }
        if (this.ceA != null) {
            String ahV = this.ceA.ahV();
            El.gM("adLanding").Y(com.baidu.swan.apps.core.d.e.bjU, com.baidu.swan.apps.core.d.e.bjW).a("adLanding", com.baidu.swan.apps.model.b.aO(ahV, ahV)).Mj();
        }
        com.baidu.swan.game.ad.d.a.b(this.ceA, this.cez);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiu() {
        if (this.ceN != null && this.aXu != null) {
            this.ceN.eo(this.aXu.isEnd());
        }
        aiv();
        com.baidu.swan.game.ad.d.a.d(this.ceA, this.cez);
        this.ceI = 263;
        b((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aiv() {
        if (this.aXu != null) {
            this.aXu.pause();
            this.aXu.onDestroy();
        }
        if (this.ceP != null) {
            this.mContext.unregisterReceiver(this.ceP);
            this.ceP = null;
        }
        if (this.ceH != null) {
            this.ceH.ahL();
            this.ceH.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.au(this.ceH.getConvertView());
        }
        if (this.ceJ != null) {
            com.baidu.swan.games.view.a.c.b(this.ceJ);
            this.ceJ = null;
        }
    }

    private boolean aiw() {
        if (this.ceA == null) {
            return true;
        }
        long ahW = this.ceA.ahW() * 1000;
        if (ahW == 0) {
            ahW = 1740000;
        }
        return System.currentTimeMillis() - this.ceA.getCreateTime() >= ahW;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int getProgress() {
        if (this.aXu != null) {
            return this.aXu.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void c(j jVar) {
        if (this.ceN != null) {
            this.ceN.onLoad();
        }
        if (jVar != null) {
            jVar.aiA();
        }
        com.baidu.swan.game.ad.f.a.ain().D(16, "");
    }

    private void a(j jVar, String str) {
        if (this.ceN != null) {
            this.ceN.onError(str);
        }
        if (jVar != null) {
            jVar.nG(str);
        }
        com.baidu.swan.game.ad.f.a.ain().D(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void pausePlay() {
        if (this.aXu != null && this.ceH != null && this.aXu.isPlaying()) {
            this.aXu.pause();
            this.ceH.pausePlay();
            com.baidu.swan.game.ad.d.a.a(getProgress(), this.mPausePosition, this.ceA, this.cez);
            this.mPausePosition = getProgress();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void continuePlay() {
        if (this.aXu != null && this.ceH != null) {
            if ((this.ceM == null || !this.ceM.isShowing()) && !this.aXu.isPlaying() && !this.aXu.isEnd()) {
                this.aXu.resume();
                this.ceH.ahK();
                com.baidu.swan.game.ad.d.a.c(this.ceA, this.cez);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(k kVar, String str) {
        if (kVar != null) {
            kVar.nH(str);
        }
        if (this.ceN != null) {
            this.ceN.onError(str);
        }
        this.ceI = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void aix() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.ceH = new com.baidu.swan.game.ad.d(this.mContext, this.ceA);
        } else {
            this.ceH = new com.baidu.swan.game.ad.e(this.mContext, this.ceA);
        }
        this.ceH.a((a.b) this);
        this.ceH.a((a.c) this);
        this.aXu = this.ceH.getPlayer();
        this.aXu.b(new com.baidu.swan.apps.media.c.b() { // from class: com.baidu.swan.game.ad.f.g.5
            @Override // com.baidu.swan.apps.media.c.b
            public void a(com.baidu.swan.apps.w.b.l lVar) {
                if (g.this.aXu != null) {
                    g.this.aXu.cC(true);
                }
                if (g.this.ceH != null) {
                    g.this.ceH.onPrepared();
                }
                g.this.ceI = 261;
                g.this.mPausePosition = 0;
                if (g.this.ceH != null) {
                    g.this.ceH.ahJ();
                }
                if (g.this.ceL != null) {
                    g.this.ceL.aiB();
                }
                if (g.this.ceP == null) {
                    g.this.ceP = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    g.this.mContext.registerReceiver(g.this.ceP, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(g.this.ceA, g.this.cez);
                com.baidu.swan.game.ad.d.a.c(g.this.ceA, g.this.cez);
            }

            @Override // com.baidu.swan.apps.media.c.b
            public boolean a(com.baidu.swan.apps.w.b.l lVar, int i, int i2) {
                g.this.aiv();
                g.this.a(g.this.ceL, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.c.b
            public void b(com.baidu.swan.apps.w.b.l lVar) {
                g.this.ceI = 262;
                com.baidu.swan.game.ad.d.a.a(g.this.getProgress(), g.this.mPausePosition, g.this.ceA, g.this.cez);
                if (g.this.ceH != null) {
                    g.this.ceH.ahM();
                }
            }
        });
        if (this.ceJ == null) {
            this.ceJ = new com.baidu.swan.games.view.a() { // from class: com.baidu.swan.game.ad.f.g.6
                @Override // com.baidu.swan.games.view.a
                public void aiy() {
                    g.this.ceQ = true;
                    if (g.this.ceR) {
                        g.this.continuePlay();
                    }
                }

                @Override // com.baidu.swan.games.view.a
                public void aiz() {
                    g.this.ceQ = false;
                    g.this.pausePlay();
                }

                @Override // com.baidu.swan.games.view.a
                public void onViewDestroy() {
                }
            };
            com.baidu.swan.games.view.a.c.a(this.ceJ);
        }
        this.ceH.getConvertView().setAnimation(AnimationUtils.loadAnimation(this.mContext, c.a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes10.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (g.this.aXu != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    g.this.ceR = true;
                    if (g.this.ceQ) {
                        g.this.continuePlay();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    g.this.ceR = false;
                }
            }
        }
    }
}
