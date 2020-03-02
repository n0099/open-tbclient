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
    private static volatile e ckN = new e();
    private j ckK = new j();
    private volatile boolean ckM = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> ckL = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e alJ() {
        return ckN;
    }

    public j alK() {
        if (this.ckK == null) {
            this.ckK = new j();
        }
        return this.ckK;
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
        if (c.alH().isEnable() && this.ckK != null && this.ckK.amM() && this.ckK.amJ() != -1) {
            if (!this.ckK.amL()) {
                if (this.ckL == null) {
                    this.ckL = new ConcurrentLinkedQueue<>();
                }
                this.ckL.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
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
        if (this.ckM) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.ckM = true;
        byte[] a = d.alI().a(this.ckK);
        if (a == null || a.length <= 0) {
            this.ckM = false;
            hH(-1);
            return;
        }
        if (this.ckK != null) {
            this.ckK.amK();
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
                                    e.this.ckK.hN(-1);
                                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(amF);
                                    if (parseFrom != null) {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        f.a(e.this.ckK, parseFrom);
                                        break;
                                    }
                                    break;
                                case 22:
                                    if (com.baidu.swan.games.bdtls.a.a.b(e.this.ckK, amF) == null) {
                                        e.this.ckK.hN(-1);
                                        break;
                                    } else {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        e.this.ckK.hN(1);
                                        f.ov("serverHello");
                                        while (true) {
                                            com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.ckL.poll();
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
                    e.this.ckM = false;
                }
                e.this.hH(-1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            byte[] a = d.alI().a(this.ckK, str);
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
        this.ckK.hN(-1);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.ckL.poll();
            if (poll != null) {
                e(poll.amx(), poll.amy());
            } else {
                return;
            }
        }
    }
}
