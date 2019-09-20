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
public class h implements a.InterfaceC0208a, a.b, a.c {
    public String b;
    private com.baidu.swan.game.ad.c beP;
    private com.baidu.swan.apps.media.d.a beQ;
    private com.baidu.swan.game.ad.a.a beR;
    private com.baidu.swan.games.view.a.a beS;
    private k beT;
    private l beU;
    public com.baidu.swan.apps.res.widget.dialog.g beV;
    private j beW;
    private a beY;
    private String l;
    private boolean n;
    private boolean q;
    private int g = 256;
    private int i = 0;
    private boolean r = true;
    private Context c = AppRuntime.getAppContext();
    private d beX = new d(this.c);

    public h(String str, String str2) {
        this.b = "";
        this.l = str;
        this.b = str2;
    }

    public void a(j jVar) {
        this.beW = jVar;
    }

    public synchronized void a(com.baidu.swan.games.binding.model.c cVar) {
        k c = k.c(cVar);
        if (this.g == 257) {
            c.QP().a(c);
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
                com.baidu.swan.apps.ae.b Mh = com.baidu.swan.apps.ae.b.Mh();
                String str = "";
                if (Mh != null) {
                    str = Mh.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.b)) {
                    a(c, "3010007");
                } else {
                    this.beT = c;
                    this.g = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.c, new b.a().iJ(this.l).iK(this.b).iL(str).QO());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bk("video", null);
                    aVar.a(eVar, this.beX);
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
            if (this.beW != null) {
                this.beW.a("3010004");
            }
        } else if (this.g != 258 || e()) {
            a(d, "3010004");
        } else if (this.beR != null && TextUtils.isEmpty(this.beR.e())) {
            a(d, "3010008");
        } else if (this.g == 258) {
            this.g = 265;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.i();
                    if (com.baidu.swan.games.view.a.c.at(h.this.beP.a())) {
                        com.baidu.swan.games.view.a.c.an(h.this.beP.a());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.beP.a(), com.baidu.swan.apps.model.a.a.b.Hy())) {
                        h.this.a(d, "3010000");
                        return;
                    }
                    h.this.beU = d;
                    h.this.g = 260;
                    h.this.beP.a(h.this.beR.e());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0208a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.beR = aVar;
        this.g = 258;
        a(this.beT);
        com.baidu.swan.games.view.a.b.bk("video", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0208a
    public void a(String str) {
        this.g = 259;
        a(this.beT, str);
        com.baidu.swan.games.view.a.b.bk("video", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    @Override // com.baidu.swan.game.ad.b.a.b
    public void a() {
        SwanAppActivity Gv;
        int i;
        int i2;
        int i3;
        if (this.beQ != null && (Gv = com.baidu.swan.apps.w.e.GJ().Gv()) != null && !this.n) {
            int TF = com.baidu.swan.games.view.a.c.TF();
            int TG = com.baidu.swan.games.view.a.c.TG();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (TF * 0.275f);
                i2 = (int) (TF * 0.275f);
                i3 = (int) (0.05f * TG);
            } else {
                i = (int) (TF * 0.1f);
                i2 = (int) (TF * 0.1f);
                i3 = 0;
            }
            g();
            if (this.beQ.isEnd()) {
                c();
                return;
            }
            this.n = true;
            this.beV = new g.a(Gv).cc(true).c(a.f.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.h.4
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.c();
                    h.this.n = false;
                }
            }).cm(a.f.ad_dialog_msg_tip).b(a.f.ad_continue_watch, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.h.3
                @Override // android.content.DialogInterface.OnClickListener
                public void onClick(DialogInterface dialogInterface, int i4) {
                    h.this.h();
                    h.this.n = false;
                }
            }).dw(a.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.n = false;
                }
            }).a(new com.baidu.swan.apps.view.b.a()).j(i, 0, i2, i3).LB();
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.c
    public void b() {
        com.baidu.swan.apps.core.d.e vN = com.baidu.swan.apps.w.e.GJ().vN();
        if (vN == null) {
            if (this.c != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.c, a.f.aiapps_open_fragment_failed_toast).LU();
                return;
            }
            return;
        }
        if (this.beR != null) {
            String f = this.beR.f();
            vN.dU("adLanding").B(com.baidu.swan.apps.core.d.e.arU, com.baidu.swan.apps.core.d.e.arW).a("adLanding", com.baidu.swan.apps.model.b.aq(f, f)).AH();
        }
        com.baidu.swan.game.ad.d.a.b(this.beR, this.beX);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.beW != null && this.beQ != null) {
            this.beW.a(this.beQ.isEnd());
        }
        d();
        com.baidu.swan.game.ad.d.a.d(this.beR, this.beX);
        this.g = 263;
        a((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.beQ != null) {
            this.beQ.pause();
            this.beQ.onDestroy();
        }
        if (this.beY != null) {
            this.c.unregisterReceiver(this.beY);
            this.beY = null;
        }
        if (this.beP != null) {
            this.beP.g();
            this.beP.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0207a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.an(this.beP.a());
        }
        if (this.beS != null) {
            com.baidu.swan.games.view.a.c.b(this.beS);
            this.beS = null;
        }
    }

    private boolean e() {
        if (this.beR == null) {
            return true;
        }
        long j = this.beR.j() * 1000;
        if (j == 0) {
            j = 1740000;
        }
        return System.currentTimeMillis() - this.beR.i() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (this.beQ != null) {
            return this.beQ.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void a(k kVar) {
        if (this.beW != null) {
            this.beW.a();
        }
        if (kVar != null) {
            kVar.a();
        }
        c.QP().a(16, "");
    }

    private void a(k kVar, String str) {
        if (this.beW != null) {
            this.beW.a(str);
        }
        if (kVar != null) {
            kVar.a(str);
        }
        c.QP().a(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.beQ != null && this.beP != null && this.beQ.isPlaying()) {
            this.beQ.pause();
            this.beP.e();
            com.baidu.swan.game.ad.d.a.a(f(), this.i, this.beR, this.beX);
            this.i = f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.beQ != null && this.beP != null) {
            if ((this.beV == null || !this.beV.isShowing()) && !this.beQ.isPlaying() && !this.beQ.isEnd()) {
                this.beQ.resume();
                this.beP.f();
                com.baidu.swan.game.ad.d.a.c(this.beR, this.beX);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.a(str);
        }
        if (this.beW != null) {
            this.beW.a(str);
        }
        this.g = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.beP = new com.baidu.swan.game.ad.d(this.c, this.beR);
        } else {
            this.beP = new com.baidu.swan.game.ad.e(this.c, this.beR);
        }
        this.beP.a((a.b) this);
        this.beP.a((a.c) this);
        this.beQ = this.beP.QM();
        this.beQ.a(new com.baidu.swan.apps.media.d.b() { // from class: com.baidu.swan.game.ad.f.h.5
            @Override // com.baidu.swan.apps.media.d.b
            public void b(v vVar) {
                if (h.this.beQ != null) {
                    h.this.beQ.br(true);
                }
                if (h.this.beP != null) {
                    h.this.beP.d();
                }
                h.this.g = 261;
                h.this.i = 0;
                if (h.this.beP != null) {
                    h.this.beP.c();
                }
                if (h.this.beU != null) {
                    h.this.beU.a();
                }
                if (h.this.beY == null) {
                    h.this.beY = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.c.registerReceiver(h.this.beY, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(h.this.beR, h.this.beX);
                com.baidu.swan.game.ad.d.a.c(h.this.beR, h.this.beX);
            }

            @Override // com.baidu.swan.apps.media.d.b
            public boolean a(v vVar, int i, int i2) {
                h.this.d();
                h.this.a(h.this.beU, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.d.b
            public void a(v vVar) {
                h.this.g = 262;
                com.baidu.swan.game.ad.d.a.a(h.this.f(), h.this.i, h.this.beR, h.this.beX);
                if (h.this.beP != null) {
                    h.this.beP.h();
                }
            }
        });
        if (this.beS == null) {
            this.beS = new com.baidu.swan.games.view.a.a() { // from class: com.baidu.swan.game.ad.f.h.6
                @Override // com.baidu.swan.games.view.a.a
                public void QQ() {
                    h.this.q = true;
                    if (h.this.r) {
                        h.this.h();
                    }
                }

                @Override // com.baidu.swan.games.view.a.a
                public void QR() {
                    h.this.q = false;
                    h.this.g();
                }
            };
            com.baidu.swan.games.view.a.c.a(this.beS);
        }
        this.beP.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0207a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.beQ != null) {
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
