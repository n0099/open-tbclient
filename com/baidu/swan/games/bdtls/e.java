package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.games.bdtls.b.c;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.j;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes10.dex */
public class e {
    private static volatile e cgI = new e();
    private j cgF = new j();
    private volatile boolean cgH = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> cgG = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e ajt() {
        return cgI;
    }

    public j aju() {
        if (this.cgF == null) {
            this.cgF = new j();
        }
        return this.cgF;
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
        if (c.ajr().isEnable() && this.cgF != null && this.cgF.akw() && this.cgF.akt() != -1) {
            if (!this.cgF.akv()) {
                if (this.cgG == null) {
                    this.cgG = new ConcurrentLinkedQueue<>();
                }
                this.cgG.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                ajv();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void ajv() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.cgH) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.cgH = true;
        byte[] a = d.ajs().a(this.cgF);
        if (a == null || a.length <= 0) {
            this.cgH = false;
            hq(-1);
            return;
        }
        if (this.cgF != null) {
            this.cgF.aku();
        }
        new com.baidu.swan.games.bdtls.b.c().a(a, new c.a() { // from class: com.baidu.swan.games.bdtls.e.2
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=4] */
            @Override // com.baidu.swan.games.bdtls.b.c.a
            public void b(boolean z, byte[] bArr) {
                h G;
                try {
                    if (a.DEBUG) {
                        Log.d("BDTLS", "doHandShake response");
                    }
                    if (z && bArr != null && (G = com.baidu.swan.games.bdtls.a.b.G(bArr)) != null) {
                        byte akl = G.akl();
                        byte[] akp = G.akp();
                        if (akp != null) {
                            if (a.DEBUG) {
                                Log.d("BDTLS", "doHandShake response schemeType =" + ((int) akl));
                            }
                            switch (akl) {
                                case 21:
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    e.this.cgF.hw(-1);
                                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(akp);
                                    if (parseFrom != null) {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        f.a(e.this.cgF, parseFrom);
                                        break;
                                    }
                                    break;
                                case 22:
                                    if (com.baidu.swan.games.bdtls.a.a.b(e.this.cgF, akp) == null) {
                                        e.this.cgF.hw(-1);
                                        break;
                                    } else {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        e.this.cgF.hw(1);
                                        f.oe("serverHello");
                                        while (true) {
                                            com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.cgG.poll();
                                            if (fVar == null) {
                                                return;
                                            }
                                            e.this.d(fVar.akh(), fVar.aki());
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
                    e.this.cgH = false;
                }
                e.this.hq(-1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            byte[] a = d.ajs().a(this.cgF, str);
            if (a != null) {
                if (a.DEBUG) {
                    Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                }
                bVar.et(true);
                bVar.H(a);
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
            bVar.et(false);
            bVar.H(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.hx(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hq(int i) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        this.cgF.hw(-1);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.cgG.poll();
            if (poll != null) {
                e(poll.akh(), poll.aki());
            } else {
                return;
            }
        }
    }
}
