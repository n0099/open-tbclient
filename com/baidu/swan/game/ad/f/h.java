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
public class h implements a.InterfaceC0240a, a.b, a.c {
    public String b;
    private com.baidu.swan.game.ad.c bxJ;
    private com.baidu.swan.apps.media.d.a bxK;
    private com.baidu.swan.game.ad.a.a bxL;
    private com.baidu.swan.games.view.a.a bxM;
    private k bxN;
    private l bxO;
    public com.baidu.swan.apps.res.widget.dialog.g bxP;
    private j bxQ;
    private a bxS;
    private String l;
    private boolean n;
    private boolean q;
    private int g = 256;
    private int i = 0;
    private boolean r = true;
    private Context c = AppRuntime.getAppContext();
    private d bxR = new d(this.c);

    public h(String str, String str2) {
        this.b = "";
        this.l = str;
        this.b = str2;
    }

    public void a(j jVar) {
        this.bxQ = jVar;
    }

    public synchronized void a(com.baidu.swan.games.binding.model.c cVar) {
        k c = k.c(cVar);
        if (this.g == 257) {
            c.VF().a(c);
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
                com.baidu.swan.apps.ae.b QZ = com.baidu.swan.apps.ae.b.QZ();
                String str = "";
                if (QZ != null) {
                    str = QZ.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.b)) {
                    a(c, "3010007");
                } else {
                    this.bxN = c;
                    this.g = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.c, new b.a().jm(this.l).jn(this.b).jo(str).VE());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.br("video", null);
                    aVar.a(eVar, this.bxR);
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
            if (this.bxQ != null) {
                this.bxQ.a("3010004");
            }
        } else if (this.g != 258 || e()) {
            a(d, "3010004");
        } else if (this.bxL != null && TextUtils.isEmpty(this.bxL.e())) {
            a(d, "3010008");
        } else if (this.g == 258) {
            this.g = 265;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.i();
                    if (com.baidu.swan.games.view.a.c.az(h.this.bxJ.a())) {
                        com.baidu.swan.games.view.a.c.at(h.this.bxJ.a());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.bxJ.a(), com.baidu.swan.apps.model.a.a.b.Ms())) {
                        h.this.a(d, "3010000");
                        return;
                    }
                    h.this.bxO = d;
                    h.this.g = 260;
                    h.this.bxJ.a(h.this.bxL.e());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0240a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.bxL = aVar;
        this.g = 258;
        a(this.bxN);
        com.baidu.swan.games.view.a.b.br("video", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0240a
    public void a(String str) {
        this.g = 259;
        a(this.bxN, str);
        com.baidu.swan.games.view.a.b.br("video", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    @Override // com.baidu.swan.game.ad.b.a.b
    public void a() {
        SwanAppActivity Lp;
        int i;
        int i2;
        int i3;
        if (this.bxK != null && (Lp = com.baidu.swan.apps.w.e.LD().Lp()) != null && !this.n) {
            int Yw = com.baidu.swan.games.view.a.c.Yw();
            int Yx = com.baidu.swan.games.view.a.c.Yx();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (Yw * 0.275f);
                i2 = (int) (Yw * 0.275f);
                i3 = (int) (0.05f * Yx);
            } else {
                i = (int) (Yw * 0.1f);
                i2 = (int) (Yw * 0.1f);
                i3 = 0;
            }
            g();
            if (this.bxK.isEnd()) {
                c();
                return;
            }
            this.n = true;
            this.bxP = new g.a(Lp).ct(true).c(a.f.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.h.4
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
            }).a(new com.baidu.swan.apps.view.b.a()).k(i, 0, i2, i3).Qu();
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.c
    public void b() {
        com.baidu.swan.apps.core.d.e AH = com.baidu.swan.apps.w.e.LD().AH();
        if (AH == null) {
            if (this.c != null) {
                com.baidu.swan.apps.res.widget.b.d.i(this.c, a.f.aiapps_open_fragment_failed_toast).QN();
                return;
            }
            return;
        }
        if (this.bxL != null) {
            String f = this.bxL.f();
            AH.eC("adLanding").H(com.baidu.swan.apps.core.d.e.aLl, com.baidu.swan.apps.core.d.e.aLn).a("adLanding", com.baidu.swan.apps.model.b.ay(f, f)).FC();
        }
        com.baidu.swan.game.ad.d.a.b(this.bxL, this.bxR);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.bxQ != null && this.bxK != null) {
            this.bxQ.a(this.bxK.isEnd());
        }
        d();
        com.baidu.swan.game.ad.d.a.d(this.bxL, this.bxR);
        this.g = 263;
        a((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.bxK != null) {
            this.bxK.pause();
            this.bxK.onDestroy();
        }
        if (this.bxS != null) {
            this.c.unregisterReceiver(this.bxS);
            this.bxS = null;
        }
        if (this.bxJ != null) {
            this.bxJ.g();
            this.bxJ.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0239a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.at(this.bxJ.a());
        }
        if (this.bxM != null) {
            com.baidu.swan.games.view.a.c.b(this.bxM);
            this.bxM = null;
        }
    }

    private boolean e() {
        if (this.bxL == null) {
            return true;
        }
        long j = this.bxL.j() * 1000;
        if (j == 0) {
            j = 1740000;
        }
        return System.currentTimeMillis() - this.bxL.i() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (this.bxK != null) {
            return this.bxK.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void a(k kVar) {
        if (this.bxQ != null) {
            this.bxQ.a();
        }
        if (kVar != null) {
            kVar.a();
        }
        c.VF().a(16, "");
    }

    private void a(k kVar, String str) {
        if (this.bxQ != null) {
            this.bxQ.a(str);
        }
        if (kVar != null) {
            kVar.a(str);
        }
        c.VF().a(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.bxK != null && this.bxJ != null && this.bxK.isPlaying()) {
            this.bxK.pause();
            this.bxJ.e();
            com.baidu.swan.game.ad.d.a.a(f(), this.i, this.bxL, this.bxR);
            this.i = f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.bxK != null && this.bxJ != null) {
            if ((this.bxP == null || !this.bxP.isShowing()) && !this.bxK.isPlaying() && !this.bxK.isEnd()) {
                this.bxK.resume();
                this.bxJ.f();
                com.baidu.swan.game.ad.d.a.c(this.bxL, this.bxR);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.a(str);
        }
        if (this.bxQ != null) {
            this.bxQ.a(str);
        }
        this.g = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.bxJ = new com.baidu.swan.game.ad.d(this.c, this.bxL);
        } else {
            this.bxJ = new com.baidu.swan.game.ad.e(this.c, this.bxL);
        }
        this.bxJ.a((a.b) this);
        this.bxJ.a((a.c) this);
        this.bxK = this.bxJ.VC();
        this.bxK.a(new com.baidu.swan.apps.media.d.b() { // from class: com.baidu.swan.game.ad.f.h.5
            @Override // com.baidu.swan.apps.media.d.b
            public void b(v vVar) {
                if (h.this.bxK != null) {
                    h.this.bxK.bJ(true);
                }
                if (h.this.bxJ != null) {
                    h.this.bxJ.d();
                }
                h.this.g = 261;
                h.this.i = 0;
                if (h.this.bxJ != null) {
                    h.this.bxJ.c();
                }
                if (h.this.bxO != null) {
                    h.this.bxO.a();
                }
                if (h.this.bxS == null) {
                    h.this.bxS = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.c.registerReceiver(h.this.bxS, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(h.this.bxL, h.this.bxR);
                com.baidu.swan.game.ad.d.a.c(h.this.bxL, h.this.bxR);
            }

            @Override // com.baidu.swan.apps.media.d.b
            public boolean a(v vVar, int i, int i2) {
                h.this.d();
                h.this.a(h.this.bxO, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.d.b
            public void a(v vVar) {
                h.this.g = 262;
                com.baidu.swan.game.ad.d.a.a(h.this.f(), h.this.i, h.this.bxL, h.this.bxR);
                if (h.this.bxJ != null) {
                    h.this.bxJ.h();
                }
            }
        });
        if (this.bxM == null) {
            this.bxM = new com.baidu.swan.games.view.a.a() { // from class: com.baidu.swan.game.ad.f.h.6
                @Override // com.baidu.swan.games.view.a.a
                public void VG() {
                    h.this.q = true;
                    if (h.this.r) {
                        h.this.h();
                    }
                }

                @Override // com.baidu.swan.games.view.a.a
                public void VH() {
                    h.this.q = false;
                    h.this.g();
                }
            };
            com.baidu.swan.games.view.a.c.a(this.bxM);
        }
        this.bxJ.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0239a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.bxK != null) {
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
