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
import com.baidu.swan.apps.an.ac;
import com.baidu.swan.apps.res.widget.dialog.g;
import com.baidu.swan.apps.u.b.v;
import com.baidu.swan.game.ad.a;
import com.baidu.swan.game.ad.b.a;
import com.baidu.swan.game.ad.c.b;
/* loaded from: classes2.dex */
public class h implements a.InterfaceC0235a, a.b, a.c {
    public String b;
    private com.baidu.swan.game.ad.c bwS;
    private com.baidu.swan.apps.media.d.a bwT;
    private com.baidu.swan.game.ad.a.a bwU;
    private com.baidu.swan.games.view.a.a bwV;
    private k bwW;
    private l bwX;
    public com.baidu.swan.apps.res.widget.dialog.g bwY;
    private j bwZ;
    private a bxb;
    private String l;
    private boolean n;
    private boolean q;
    private int g = 256;
    private int i = 0;
    private boolean r = true;
    private Context c = AppRuntime.getAppContext();
    private d bxa = new d(this.c);

    public h(String str, String str2) {
        this.b = "";
        this.l = str;
        this.b = str2;
    }

    public void a(j jVar) {
        this.bwZ = jVar;
    }

    public synchronized void a(com.baidu.swan.games.binding.model.c cVar) {
        k c = k.c(cVar);
        if (this.g == 257) {
            c.VD().a(c);
        } else if (this.g == 261 || this.g == 260 || this.g == 265) {
            a(c, "3010006");
        } else {
            if (this.g == 258) {
                if (e()) {
                    this.g = AuthorityState.STATE_INIT_ING;
                } else {
                    a(c);
                }
            }
            if (this.g == 259 || this.g == 262 || this.g == 263 || this.g == 264 || this.g == 256 || this.g == 272) {
                com.baidu.swan.apps.ae.b Ra = com.baidu.swan.apps.ae.b.Ra();
                String str = "";
                if (Ra != null) {
                    str = Ra.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.b)) {
                    a(c, "3010007");
                } else {
                    this.bwW = c;
                    this.g = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.c, new b.a().jm(this.l).jn(this.b).jo(str).VC());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.br("video", null);
                    aVar.a(eVar, this.bxa);
                }
            }
        }
    }

    public synchronized void b(com.baidu.swan.games.binding.model.c cVar) {
        final l d = l.d(cVar);
        if (this.g == 261 || this.g == 260 || this.g == 265) {
            if (d != null) {
                d.a("3010004");
            }
            if (this.bwZ != null) {
                this.bwZ.a("3010004");
            }
        } else if (this.g != 258 || e()) {
            a(d, "3010004");
        } else if (this.bwU != null && TextUtils.isEmpty(this.bwU.e())) {
            a(d, "3010008");
        } else if (this.g == 258) {
            this.g = 265;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.i();
                    if (com.baidu.swan.games.view.a.c.az(h.this.bwS.a())) {
                        com.baidu.swan.games.view.a.c.at(h.this.bwS.a());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.bwS.a(), com.baidu.swan.apps.model.a.a.b.Mt())) {
                        h.this.a(d, "3010000");
                        return;
                    }
                    h.this.bwX = d;
                    h.this.g = 260;
                    h.this.bwS.a(h.this.bwU.e());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0235a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.bwU = aVar;
        this.g = 258;
        a(this.bwW);
        com.baidu.swan.games.view.a.b.br("video", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0235a
    public void a(String str) {
        this.g = 259;
        a(this.bwW, str);
        com.baidu.swan.games.view.a.b.br("video", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    @Override // com.baidu.swan.game.ad.b.a.b
    public void a() {
        SwanAppActivity Lq;
        int i;
        int i2;
        int i3;
        if (this.bwT != null && (Lq = com.baidu.swan.apps.w.e.LE().Lq()) != null && !this.n) {
            int Yu = com.baidu.swan.games.view.a.c.Yu();
            int Yv = com.baidu.swan.games.view.a.c.Yv();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (Yu * 0.275f);
                i2 = (int) (Yu * 0.275f);
                i3 = (int) (0.05f * Yv);
            } else {
                i = (int) (Yu * 0.1f);
                i2 = (int) (Yu * 0.1f);
                i3 = 0;
            }
            g();
            if (this.bwT.isEnd()) {
                c();
                return;
            }
            this.n = true;
            this.bwY = new g.a(Lq).ct(true).c(a.f.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.c();
                    h.this.n = false;
                }
            }).di(a.f.ad_dialog_msg_tip).b(a.f.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.h();
                    h.this.n = false;
                }
            }).er(a.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.n = false;
                }
            }).a(new com.baidu.swan.apps.view.b.a()).k(i, 0, i2, i3).Qv();
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.c
    public void b() {
        com.baidu.swan.apps.core.d.e AI = com.baidu.swan.apps.w.e.LE().AI();
        if (AI == null) {
            if (this.c != null) {
                com.baidu.swan.apps.res.widget.b.d.i(this.c, a.f.aiapps_open_fragment_failed_toast).QO();
                return;
            }
            return;
        }
        if (this.bwU != null) {
            String f = this.bwU.f();
            AI.eC("adLanding").F(com.baidu.swan.apps.core.d.e.aKT, com.baidu.swan.apps.core.d.e.aKV).a("adLanding", com.baidu.swan.apps.model.b.ay(f, f)).FD();
        }
        com.baidu.swan.game.ad.d.a.b(this.bwU, this.bxa);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.bwZ != null && this.bwT != null) {
            this.bwZ.a(this.bwT.isEnd());
        }
        d();
        com.baidu.swan.game.ad.d.a.d(this.bwU, this.bxa);
        this.g = 263;
        a((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.bwT != null) {
            this.bwT.pause();
            this.bwT.onDestroy();
        }
        if (this.bxb != null) {
            this.c.unregisterReceiver(this.bxb);
            this.bxb = null;
        }
        if (this.bwS != null) {
            this.bwS.g();
            this.bwS.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0234a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.at(this.bwS.a());
        }
        if (this.bwV != null) {
            com.baidu.swan.games.view.a.c.b(this.bwV);
            this.bwV = null;
        }
    }

    private boolean e() {
        if (this.bwU == null) {
            return true;
        }
        long j = this.bwU.j() * 1000;
        if (j == 0) {
            j = 1740000;
        }
        return System.currentTimeMillis() - this.bwU.i() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (this.bwT != null) {
            return this.bwT.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void a(k kVar) {
        if (this.bwZ != null) {
            this.bwZ.a();
        }
        if (kVar != null) {
            kVar.a();
        }
        c.VD().a(16, "");
    }

    private void a(k kVar, String str) {
        if (this.bwZ != null) {
            this.bwZ.a(str);
        }
        if (kVar != null) {
            kVar.a(str);
        }
        c.VD().a(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.bwT != null && this.bwS != null && this.bwT.isPlaying()) {
            this.bwT.pause();
            this.bwS.e();
            com.baidu.swan.game.ad.d.a.a(f(), this.i, this.bwU, this.bxa);
            this.i = f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.bwT != null && this.bwS != null) {
            if ((this.bwY == null || !this.bwY.isShowing()) && !this.bwT.isPlaying() && !this.bwT.isEnd()) {
                this.bwT.resume();
                this.bwS.f();
                com.baidu.swan.game.ad.d.a.c(this.bwU, this.bxa);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.a(str);
        }
        if (this.bwZ != null) {
            this.bwZ.a(str);
        }
        this.g = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.bwS = new com.baidu.swan.game.ad.d(this.c, this.bwU);
        } else {
            this.bwS = new com.baidu.swan.game.ad.e(this.c, this.bwU);
        }
        this.bwS.a((a.b) this);
        this.bwS.a((a.c) this);
        this.bwT = this.bwS.VA();
        this.bwT.a(new com.baidu.swan.apps.media.d.b() { // from class: com.baidu.swan.game.ad.f.h.5
            @Override // com.baidu.swan.apps.media.d.b
            public void b(v vVar) {
                if (h.this.bwT != null) {
                    h.this.bwT.bJ(true);
                }
                if (h.this.bwS != null) {
                    h.this.bwS.d();
                }
                h.this.g = 261;
                h.this.i = 0;
                if (h.this.bwS != null) {
                    h.this.bwS.c();
                }
                if (h.this.bwX != null) {
                    h.this.bwX.a();
                }
                if (h.this.bxb == null) {
                    h.this.bxb = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.c.registerReceiver(h.this.bxb, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(h.this.bwU, h.this.bxa);
                com.baidu.swan.game.ad.d.a.c(h.this.bwU, h.this.bxa);
            }

            @Override // com.baidu.swan.apps.media.d.b
            public boolean a(v vVar, int i, int i2) {
                h.this.d();
                h.this.a(h.this.bwX, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.d.b
            public void a(v vVar) {
                h.this.g = 262;
                com.baidu.swan.game.ad.d.a.a(h.this.f(), h.this.i, h.this.bwU, h.this.bxa);
                if (h.this.bwS != null) {
                    h.this.bwS.h();
                }
            }
        });
        if (this.bwV == null) {
            this.bwV = new com.baidu.swan.games.view.a.a() { // from class: com.baidu.swan.game.ad.f.h.6
                @Override // com.baidu.swan.games.view.a.a
                public void VE() {
                    h.this.q = true;
                    if (h.this.r) {
                        h.this.h();
                    }
                }

                @Override // com.baidu.swan.games.view.a.a
                public void VF() {
                    h.this.q = false;
                    h.this.g();
                }
            };
            com.baidu.swan.games.view.a.c.a(this.bwV);
        }
        this.bwS.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0234a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.bwT != null) {
                if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_ON")) {
                    h.this.r = true;
                    if (h.this.q) {
                        h.this.h();
                    }
                } else if (TextUtils.equals(intent.getAction(), "android.intent.action.SCREEN_OFF")) {
                    h.this.r = false;
                }
            }
        }
    }
}
