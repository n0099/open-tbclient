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
public class h implements a.InterfaceC0199a, a.b, a.c {
    public String b;
    private a beA;
    private com.baidu.swan.game.ad.c beq;
    private com.baidu.swan.apps.media.d.a ber;
    private com.baidu.swan.game.ad.a.a bes;
    private com.baidu.swan.games.view.a.a beu;
    private k bev;
    private l bew;
    public com.baidu.swan.apps.res.widget.dialog.g bex;
    private j bey;
    private String l;
    private boolean n;
    private boolean q;
    private int g = 256;
    private int i = 0;
    private boolean r = true;
    private Context c = AppRuntime.getAppContext();
    private d bez = new d(this.c);

    public h(String str, String str2) {
        this.b = "";
        this.l = str;
        this.b = str2;
    }

    public void a(j jVar) {
        this.bey = jVar;
    }

    public synchronized void a(com.baidu.swan.games.binding.model.c cVar) {
        k c = k.c(cVar);
        if (this.g == 257) {
            c.QL().a(c);
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
                com.baidu.swan.apps.ae.b Md = com.baidu.swan.apps.ae.b.Md();
                String str = "";
                if (Md != null) {
                    str = Md.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.b)) {
                    a(c, "3010007");
                } else {
                    this.bev = c;
                    this.g = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.c, new b.a().iH(this.l).iI(this.b).iJ(str).QK());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bk("video", null);
                    aVar.a(eVar, this.bez);
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
            if (this.bey != null) {
                this.bey.a("3010004");
            }
        } else if (this.g != 258 || e()) {
            a(d, "3010004");
        } else if (this.bes != null && TextUtils.isEmpty(this.bes.e())) {
            a(d, "3010008");
        } else if (this.g == 258) {
            this.g = 265;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.i();
                    if (com.baidu.swan.games.view.a.c.at(h.this.beq.a())) {
                        com.baidu.swan.games.view.a.c.an(h.this.beq.a());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.beq.a(), com.baidu.swan.apps.model.a.a.b.Hu())) {
                        h.this.a(d, "3010000");
                        return;
                    }
                    h.this.bew = d;
                    h.this.g = 260;
                    h.this.beq.a(h.this.bes.e());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0199a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.bes = aVar;
        this.g = 258;
        a(this.bev);
        com.baidu.swan.games.view.a.b.bk("video", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0199a
    public void a(String str) {
        this.g = 259;
        a(this.bev, str);
        com.baidu.swan.games.view.a.b.bk("video", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    @Override // com.baidu.swan.game.ad.b.a.b
    public void a() {
        SwanAppActivity Gr;
        int i;
        int i2;
        int i3;
        if (this.ber != null && (Gr = com.baidu.swan.apps.w.e.GF().Gr()) != null && !this.n) {
            int TB = com.baidu.swan.games.view.a.c.TB();
            int TC = com.baidu.swan.games.view.a.c.TC();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (TB * 0.275f);
                i2 = (int) (TB * 0.275f);
                i3 = (int) (0.05f * TC);
            } else {
                i = (int) (TB * 0.1f);
                i2 = (int) (TB * 0.1f);
                i3 = 0;
            }
            g();
            if (this.ber.isEnd()) {
                c();
                return;
            }
            this.n = true;
            this.bex = new g.a(Gr).cc(true).c(a.f.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.c();
                    h.this.n = false;
                }
            }).cl(a.f.ad_dialog_msg_tip).b(a.f.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.h();
                    h.this.n = false;
                }
            }).dv(a.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.n = false;
                }
            }).a(new com.baidu.swan.apps.view.b.a()).g(i, 0, i2, i3).Lx();
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.c
    public void b() {
        com.baidu.swan.apps.core.d.e vJ = com.baidu.swan.apps.w.e.GF().vJ();
        if (vJ == null) {
            if (this.c != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.c, a.f.aiapps_open_fragment_failed_toast).LQ();
                return;
            }
            return;
        }
        if (this.bes != null) {
            String f = this.bes.f();
            vJ.dS("adLanding").B(com.baidu.swan.apps.core.d.e.arw, com.baidu.swan.apps.core.d.e.ary).a("adLanding", com.baidu.swan.apps.model.b.aq(f, f)).AD();
        }
        com.baidu.swan.game.ad.d.a.b(this.bes, this.bez);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.bey != null && this.ber != null) {
            this.bey.a(this.ber.isEnd());
        }
        d();
        com.baidu.swan.game.ad.d.a.d(this.bes, this.bez);
        this.g = 263;
        a((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.ber != null) {
            this.ber.pause();
            this.ber.onDestroy();
        }
        if (this.beA != null) {
            this.c.unregisterReceiver(this.beA);
            this.beA = null;
        }
        if (this.beq != null) {
            this.beq.g();
            this.beq.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0198a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.an(this.beq.a());
        }
        if (this.beu != null) {
            com.baidu.swan.games.view.a.c.b(this.beu);
            this.beu = null;
        }
    }

    private boolean e() {
        if (this.bes == null) {
            return true;
        }
        long j = this.bes.j() * 1000;
        if (j == 0) {
            j = 1740000;
        }
        return System.currentTimeMillis() - this.bes.i() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (this.ber != null) {
            return this.ber.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void a(k kVar) {
        if (this.bey != null) {
            this.bey.a();
        }
        if (kVar != null) {
            kVar.a();
        }
        c.QL().a(16, "");
    }

    private void a(k kVar, String str) {
        if (this.bey != null) {
            this.bey.a(str);
        }
        if (kVar != null) {
            kVar.a(str);
        }
        c.QL().a(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.ber != null && this.beq != null && this.ber.isPlaying()) {
            this.ber.pause();
            this.beq.e();
            com.baidu.swan.game.ad.d.a.a(f(), this.i, this.bes, this.bez);
            this.i = f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.ber != null && this.beq != null) {
            if ((this.bex == null || !this.bex.isShowing()) && !this.ber.isPlaying() && !this.ber.isEnd()) {
                this.ber.resume();
                this.beq.f();
                com.baidu.swan.game.ad.d.a.c(this.bes, this.bez);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.a(str);
        }
        if (this.bey != null) {
            this.bey.a(str);
        }
        this.g = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.beq = new com.baidu.swan.game.ad.d(this.c, this.bes);
        } else {
            this.beq = new com.baidu.swan.game.ad.e(this.c, this.bes);
        }
        this.beq.a((a.b) this);
        this.beq.a((a.c) this);
        this.ber = this.beq.QI();
        this.ber.a(new com.baidu.swan.apps.media.d.b() { // from class: com.baidu.swan.game.ad.f.h.5
            @Override // com.baidu.swan.apps.media.d.b
            public void b(v vVar) {
                if (h.this.ber != null) {
                    h.this.ber.br(true);
                }
                if (h.this.beq != null) {
                    h.this.beq.d();
                }
                h.this.g = 261;
                h.this.i = 0;
                if (h.this.beq != null) {
                    h.this.beq.c();
                }
                if (h.this.bew != null) {
                    h.this.bew.a();
                }
                if (h.this.beA == null) {
                    h.this.beA = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.c.registerReceiver(h.this.beA, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(h.this.bes, h.this.bez);
                com.baidu.swan.game.ad.d.a.c(h.this.bes, h.this.bez);
            }

            @Override // com.baidu.swan.apps.media.d.b
            public boolean a(v vVar, int i, int i2) {
                h.this.d();
                h.this.a(h.this.bew, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.d.b
            public void a(v vVar) {
                h.this.g = 262;
                com.baidu.swan.game.ad.d.a.a(h.this.f(), h.this.i, h.this.bes, h.this.bez);
                if (h.this.beq != null) {
                    h.this.beq.h();
                }
            }
        });
        if (this.beu == null) {
            this.beu = new com.baidu.swan.games.view.a.a() { // from class: com.baidu.swan.game.ad.f.h.6
                @Override // com.baidu.swan.games.view.a.a
                public void QM() {
                    h.this.q = true;
                    if (h.this.r) {
                        h.this.h();
                    }
                }

                @Override // com.baidu.swan.games.view.a.a
                public void QN() {
                    h.this.q = false;
                    h.this.g();
                }
            };
            com.baidu.swan.games.view.a.c.a(this.beu);
        }
        this.beq.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0198a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.ber != null) {
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
