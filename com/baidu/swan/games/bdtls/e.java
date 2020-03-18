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
    private static volatile e ckZ = new e();
    private j ckW = new j();
    private volatile boolean ckY = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> ckX = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e alM() {
        return ckZ;
    }

    public j alN() {
        if (this.ckW == null) {
            this.ckW = new j();
        }
        return this.ckW;
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
        if (c.alK().isEnable() && this.ckW != null && this.ckW.amP() && this.ckW.amM() != -1) {
            if (!this.ckW.amO()) {
                if (this.ckX == null) {
                    this.ckX = new ConcurrentLinkedQueue<>();
                }
                this.ckX.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                alO();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void alO() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.ckY) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.ckY = true;
        byte[] a = d.alL().a(this.ckW);
        if (a == null || a.length <= 0) {
            this.ckY = false;
            hH(-1);
            return;
        }
        if (this.ckW != null) {
            this.ckW.amN();
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
                        byte amE = L.amE();
                        byte[] amI = L.amI();
                        if (amI != null) {
                            if (a.DEBUG) {
                                Log.d("BDTLS", "doHandShake response schemeType =" + ((int) amE));
                            }
                            switch (amE) {
                                case 21:
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    e.this.ckW.hN(-1);
                                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(amI);
                                    if (parseFrom != null) {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        f.a(e.this.ckW, parseFrom);
                                        break;
                                    }
                                    break;
                                case 22:
                                    if (com.baidu.swan.games.bdtls.a.a.b(e.this.ckW, amI) == null) {
                                        e.this.ckW.hN(-1);
                                        break;
                                    } else {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        e.this.ckW.hN(1);
                                        f.ou("serverHello");
                                        while (true) {
                                            com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.ckX.poll();
                                            if (fVar == null) {
                                                return;
                                            }
                                            e.this.d(fVar.amA(), fVar.amB());
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
                    e.this.ckY = false;
                }
                e.this.hH(-1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            byte[] a = d.alL().a(this.ckW, str);
            if (a != null) {
                if (a.DEBUG) {
                    Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                }
                bVar.eB(true);
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
            bVar.eB(false);
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
        this.ckW.hN(-1);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.ckX.poll();
            if (poll != null) {
                e(poll.amA(), poll.amB());
            } else {
                return;
            }
        }
    }
}
