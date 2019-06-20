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
public class h implements a.InterfaceC0197a, a.b, a.c {
    public String b;
    private com.baidu.swan.game.ad.c bdD;
    private com.baidu.swan.apps.media.d.a bdE;
    private com.baidu.swan.game.ad.a.a bdF;
    private com.baidu.swan.games.view.a.a bdG;
    private k bdH;
    private l bdI;
    public com.baidu.swan.apps.res.widget.dialog.g bdJ;
    private j bdK;
    private a bdM;
    private String l;
    private boolean n;
    private boolean q;
    private int g = 256;
    private int i = 0;
    private boolean r = true;
    private Context c = AppRuntime.getAppContext();
    private d bdL = new d(this.c);

    public h(String str, String str2) {
        this.b = "";
        this.l = str;
        this.b = str2;
    }

    public void a(j jVar) {
        this.bdK = jVar;
    }

    public synchronized void a(com.baidu.swan.games.binding.model.c cVar) {
        k c = k.c(cVar);
        if (this.g == 257) {
            c.PT().a(c);
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
                com.baidu.swan.apps.ae.b Lq = com.baidu.swan.apps.ae.b.Lq();
                String str = "";
                if (Lq != null) {
                    str = Lq.getAppKey();
                }
                if (TextUtils.isEmpty(str) || TextUtils.isEmpty(this.l) || TextUtils.isEmpty(this.b)) {
                    a(c, "3010007");
                } else {
                    this.bdH = c;
                    this.g = 257;
                    com.baidu.swan.game.ad.c.e eVar = new com.baidu.swan.game.ad.c.e(this.c, new b.a().iA(this.l).iB(this.b).iC(str).PS());
                    com.baidu.swan.game.ad.c.a aVar = new com.baidu.swan.game.ad.c.a(this.c);
                    aVar.a(this);
                    com.baidu.swan.games.view.a.b.bk("video", null);
                    aVar.a(eVar, this.bdL);
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
            if (this.bdK != null) {
                this.bdK.a("3010004");
            }
        } else if (this.g != 258 || e()) {
            a(d, "3010004");
        } else if (this.bdF != null && TextUtils.isEmpty(this.bdF.e())) {
            a(d, "3010008");
        } else if (this.g == 258) {
            this.g = 265;
            ac.runOnUiThread(new Runnable() { // from class: com.baidu.swan.game.ad.f.h.1
                @Override // java.lang.Runnable
                public void run() {
                    h.this.i();
                    if (com.baidu.swan.games.view.a.c.ar(h.this.bdD.a())) {
                        com.baidu.swan.games.view.a.c.al(h.this.bdD.a());
                    }
                    if (!com.baidu.swan.games.view.a.c.c(h.this.bdD.a(), com.baidu.swan.apps.model.a.a.b.GK())) {
                        h.this.a(d, "3010000");
                        return;
                    }
                    h.this.bdI = d;
                    h.this.g = 260;
                    h.this.bdD.a(h.this.bdF.e());
                }
            });
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0197a
    public void a(com.baidu.swan.game.ad.a.a aVar) {
        this.bdF = aVar;
        this.g = 258;
        a(this.bdH);
        com.baidu.swan.games.view.a.b.bk("video", "success");
    }

    @Override // com.baidu.swan.game.ad.b.a.InterfaceC0197a
    public void a(String str) {
        this.g = 259;
        a(this.bdH, str);
        com.baidu.swan.games.view.a.b.bk("video", LivenessStat.TYPE_FACE_MATCH_FAIL);
    }

    @Override // com.baidu.swan.game.ad.b.a.b
    public void a() {
        SwanAppActivity FH;
        int i;
        int i2;
        int i3;
        if (this.bdE != null && (FH = com.baidu.swan.apps.w.e.FV().FH()) != null && !this.n) {
            int SI = com.baidu.swan.games.view.a.c.SI();
            int SJ = com.baidu.swan.games.view.a.c.SJ();
            if (com.baidu.swan.games.view.a.c.isLandScape()) {
                i = (int) (SI * 0.275f);
                i2 = (int) (SI * 0.275f);
                i3 = (int) (0.05f * SJ);
            } else {
                i = (int) (SI * 0.1f);
                i2 = (int) (SI * 0.1f);
                i3 = 0;
            }
            g();
            if (this.bdE.isEnd()) {
                c();
                return;
            }
            this.n = true;
            this.bdJ = new g.a(FH).bZ(true).c(a.f.ad_close, new DialogInterface.OnClickListener() { // from class: com.baidu.swan.game.ad.f.h.4
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
            }).ds(a.b.aiapps_game_continue_watch).b(new DialogInterface.OnDismissListener() { // from class: com.baidu.swan.game.ad.f.h.2
                @Override // android.content.DialogInterface.OnDismissListener
                public void onDismiss(DialogInterface dialogInterface) {
                    h.this.n = false;
                }
            }).a(new com.baidu.swan.apps.view.b.a()).f(i, 0, i2, i3).KK();
        }
    }

    @Override // com.baidu.swan.game.ad.b.a.c
    public void b() {
        com.baidu.swan.apps.core.d.e vi = com.baidu.swan.apps.w.e.FV().vi();
        if (vi == null) {
            if (this.c != null) {
                com.baidu.swan.apps.res.widget.b.d.k(this.c, a.f.aiapps_open_fragment_failed_toast).Ld();
                return;
            }
            return;
        }
        if (this.bdF != null) {
            String f = this.bdF.f();
            vi.dN("adLanding").y(com.baidu.swan.apps.core.d.e.aqT, com.baidu.swan.apps.core.d.e.aqV).a("adLanding", com.baidu.swan.apps.model.b.aq(f, f)).zW();
        }
        com.baidu.swan.game.ad.d.a.b(this.bdF, this.bdL);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c() {
        if (this.bdK != null && this.bdE != null) {
            this.bdK.a(this.bdE.isEnd());
        }
        d();
        com.baidu.swan.game.ad.d.a.d(this.bdF, this.bdL);
        this.g = 263;
        a((com.baidu.swan.games.binding.model.c) null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d() {
        if (this.bdE != null) {
            this.bdE.pause();
            this.bdE.onDestroy();
        }
        if (this.bdM != null) {
            this.c.unregisterReceiver(this.bdM);
            this.bdM = null;
        }
        if (this.bdD != null) {
            this.bdD.g();
            this.bdD.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0196a.ng_game_ad_close));
            com.baidu.swan.games.view.a.c.al(this.bdD.a());
        }
        if (this.bdG != null) {
            com.baidu.swan.games.view.a.c.b(this.bdG);
            this.bdG = null;
        }
    }

    private boolean e() {
        if (this.bdF == null) {
            return true;
        }
        long j = this.bdF.j() * 1000;
        if (j == 0) {
            j = 1740000;
        }
        return System.currentTimeMillis() - this.bdF.i() >= j;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int f() {
        if (this.bdE != null) {
            return this.bdE.getCurrentPosition() / 1000;
        }
        return 0;
    }

    private void a(k kVar) {
        if (this.bdK != null) {
            this.bdK.a();
        }
        if (kVar != null) {
            kVar.a();
        }
        c.PT().a(16, "");
    }

    private void a(k kVar, String str) {
        if (this.bdK != null) {
            this.bdK.a(str);
        }
        if (kVar != null) {
            kVar.a(str);
        }
        c.PT().a(17, str);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void g() {
        if (this.bdE != null && this.bdD != null && this.bdE.isPlaying()) {
            this.bdE.pause();
            this.bdD.e();
            com.baidu.swan.game.ad.d.a.a(f(), this.i, this.bdF, this.bdL);
            this.i = f();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void h() {
        if (this.bdE != null && this.bdD != null) {
            if ((this.bdJ == null || !this.bdJ.isShowing()) && !this.bdE.isPlaying() && !this.bdE.isEnd()) {
                this.bdE.resume();
                this.bdD.f();
                com.baidu.swan.game.ad.d.a.c(this.bdF, this.bdL);
            }
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void a(l lVar, String str) {
        if (lVar != null) {
            lVar.a(str);
        }
        if (this.bdK != null) {
            this.bdK.a(str);
        }
        this.g = 264;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void i() {
        if (com.baidu.swan.games.view.a.c.isLandScape()) {
            this.bdD = new com.baidu.swan.game.ad.d(this.c, this.bdF);
        } else {
            this.bdD = new com.baidu.swan.game.ad.e(this.c, this.bdF);
        }
        this.bdD.a((a.b) this);
        this.bdD.a((a.c) this);
        this.bdE = this.bdD.PQ();
        this.bdE.a(new com.baidu.swan.apps.media.d.b() { // from class: com.baidu.swan.game.ad.f.h.5
            @Override // com.baidu.swan.apps.media.d.b
            public void b(v vVar) {
                if (h.this.bdE != null) {
                    h.this.bdE.bo(true);
                }
                if (h.this.bdD != null) {
                    h.this.bdD.d();
                }
                h.this.g = 261;
                h.this.i = 0;
                if (h.this.bdD != null) {
                    h.this.bdD.c();
                }
                if (h.this.bdI != null) {
                    h.this.bdI.a();
                }
                if (h.this.bdM == null) {
                    h.this.bdM = new a();
                    IntentFilter intentFilter = new IntentFilter();
                    intentFilter.addAction("android.intent.action.SCREEN_ON");
                    intentFilter.addAction("android.intent.action.SCREEN_OFF");
                    h.this.c.registerReceiver(h.this.bdM, intentFilter);
                }
                com.baidu.swan.game.ad.d.a.a(h.this.bdF, h.this.bdL);
                com.baidu.swan.game.ad.d.a.c(h.this.bdF, h.this.bdL);
            }

            @Override // com.baidu.swan.apps.media.d.b
            public boolean a(v vVar, int i, int i2) {
                h.this.d();
                h.this.a(h.this.bdI, "3010001");
                return true;
            }

            @Override // com.baidu.swan.apps.media.d.b
            public void a(v vVar) {
                h.this.g = 262;
                com.baidu.swan.game.ad.d.a.a(h.this.f(), h.this.i, h.this.bdF, h.this.bdL);
                if (h.this.bdD != null) {
                    h.this.bdD.h();
                }
            }
        });
        if (this.bdG == null) {
            this.bdG = new com.baidu.swan.games.view.a.a() { // from class: com.baidu.swan.game.ad.f.h.6
                @Override // com.baidu.swan.games.view.a.a
                public void PU() {
                    h.this.q = true;
                    if (h.this.r) {
                        h.this.h();
                    }
                }

                @Override // com.baidu.swan.games.view.a.a
                public void PV() {
                    h.this.q = false;
                    h.this.g();
                }
            };
            com.baidu.swan.games.view.a.c.a(this.bdG);
        }
        this.bdD.a().setAnimation(AnimationUtils.loadAnimation(this.c, a.C0196a.ng_game_ad_open));
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes2.dex */
    public class a extends BroadcastReceiver {
        private a() {
        }

        @Override // android.content.BroadcastReceiver
        public void onReceive(Context context, Intent intent) {
            if (h.this.bdE != null) {
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
