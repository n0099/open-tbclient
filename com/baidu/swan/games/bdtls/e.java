package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.games.bdtls.b.c;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.j;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes11.dex */
public class e {
    private static volatile e ckO = new e();
    private j ckL = new j();
    private volatile boolean ckN = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> ckM = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e alJ() {
        return ckO;
    }

    public j alK() {
        if (this.ckL == null) {
            this.ckL = new j();
        }
        return this.ckL;
    }

    public void b(final String str, final com.baidu.swan.games.bdtls.b.b bVar) {
        m.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.bdtls.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.c(str, bVar);
            }
        }, "SessionController");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (c.alH().isEnable() && this.ckL != null && this.ckL.amM() && this.ckL.amJ() != -1) {
            if (!this.ckL.amL()) {
                if (this.ckM == null) {
                    this.ckM = new ConcurrentLinkedQueue<>();
                }
                this.ckM.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                alL();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void alL() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.ckN) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.ckN = true;
        byte[] a = d.alI().a(this.ckL);
        if (a == null || a.length <= 0) {
            this.ckN = false;
            hH(-1);
            return;
        }
        if (this.ckL != null) {
            this.ckL.amK();
        }
        new com.baidu.swan.games.bdtls.b.c().a(a, new c.a() { // from class: com.baidu.swan.games.bdtls.e.2
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=4] */
            @Override // com.baidu.swan.games.bdtls.b.c.a
            public void b(boolean z, byte[] bArr) {
                h L;
                try {
                    if (a.DEBUG) {
                        Log.d("BDTLS", "doHandShake response");
                    }
                    if (z && bArr != null && (L = com.baidu.swan.games.bdtls.a.b.L(bArr)) != null) {
                        byte amB = L.amB();
                        byte[] amF = L.amF();
                        if (amF != null) {
                            if (a.DEBUG) {
                                Log.d("BDTLS", "doHandShake response schemeType =" + ((int) amB));
                            }
                            switch (amB) {
                                case 21:
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    e.this.ckL.hN(-1);
                                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(amF);
                                    if (parseFrom != null) {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        f.a(e.this.ckL, parseFrom);
                                        break;
                                    }
                                    break;
                                case 22:
                                    if (com.baidu.swan.games.bdtls.a.a.b(e.this.ckL, amF) == null) {
                                        e.this.ckL.hN(-1);
                                        break;
                                    } else {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        e.this.ckL.hN(1);
                                        f.ov("serverHello");
                                        while (true) {
                                            com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.ckM.poll();
                                            if (fVar == null) {
                                                return;
                                            }
                                            e.this.d(fVar.amx(), fVar.amy());
                                        }
                                    }
                            }
                        }
                    }
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        Log.d("BDTLS", "exception=" + e.getMessage());
                    }
                } finally {
                    e.this.ckN = false;
                }
                e.this.hH(-1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            byte[] a = d.alI().a(this.ckL, str);
            if (a != null) {
                if (a.DEBUG) {
                    Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                }
                bVar.eA(true);
                bVar.M(a);
                return;
            }
            e(str, bVar);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.eA(false);
            bVar.M(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.hO(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(int i) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        this.ckL.hN(-1);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.ckM.poll();
            if (poll != null) {
                e(poll.amx(), poll.amy());
            } else {
                return;
            }
        }
    }
}
