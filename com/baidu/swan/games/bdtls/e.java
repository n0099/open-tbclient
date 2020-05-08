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
    private static volatile e cKc = new e();
    private j cJZ = new j();
    private volatile boolean cKb = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> cKa = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aua() {
        return cKc;
    }

    public j aub() {
        if (this.cJZ == null) {
            this.cJZ = new j();
        }
        return this.cJZ;
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
        if (c.atY().isEnable() && this.cJZ != null && this.cJZ.avc() && this.cJZ.auZ() != -1) {
            if (!this.cJZ.avb()) {
                if (this.cKa == null) {
                    this.cKa = new ConcurrentLinkedQueue<>();
                }
                this.cKa.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                auc();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void auc() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.cKb) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.cKb = true;
        byte[] a = d.atZ().a(this.cJZ);
        if (a == null || a.length <= 0) {
            this.cKb = false;
            hO(-1);
            return;
        }
        if (this.cJZ != null) {
            this.cJZ.ava();
        }
        new com.baidu.swan.games.bdtls.b.c().a(a, new c.a() { // from class: com.baidu.swan.games.bdtls.e.2
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=4] */
            @Override // com.baidu.swan.games.bdtls.b.c.a
            public void b(boolean z, byte[] bArr) {
                h N;
                try {
                    if (a.DEBUG) {
                        Log.d("BDTLS", "doHandShake response");
                    }
                    if (z && bArr != null && (N = com.baidu.swan.games.bdtls.a.b.N(bArr)) != null) {
                        byte auS = N.auS();
                        byte[] auW = N.auW();
                        if (auW != null) {
                            if (a.DEBUG) {
                                Log.d("BDTLS", "doHandShake response schemeType =" + ((int) auS));
                            }
                            switch (auS) {
                                case 21:
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    e.this.cJZ.hU(-1);
                                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(auW);
                                    if (parseFrom != null) {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        f.a(e.this.cJZ, parseFrom);
                                        break;
                                    }
                                    break;
                                case 22:
                                    if (com.baidu.swan.games.bdtls.a.a.b(e.this.cJZ, auW) == null) {
                                        e.this.cJZ.hU(-1);
                                        break;
                                    } else {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        e.this.cJZ.hU(1);
                                        f.pH("serverHello");
                                        while (true) {
                                            com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.cKa.poll();
                                            if (fVar == null) {
                                                return;
                                            }
                                            e.this.d(fVar.auO(), fVar.auP());
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
                    e.this.cKb = false;
                }
                e.this.hO(-1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            byte[] a = d.atZ().a(this.cJZ, str);
            if (a != null) {
                if (a.DEBUG) {
                    Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                }
                bVar.fy(true);
                bVar.O(a);
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
            bVar.fy(false);
            bVar.O(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.hV(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hO(int i) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        this.cJZ.hU(-1);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.cKa.poll();
            if (poll != null) {
                e(poll.auO(), poll.auP());
            } else {
                return;
            }
        }
    }
}
