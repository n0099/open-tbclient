package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.games.bdtls.b.c;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.j;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes9.dex */
public class e {
    private static volatile e cgv = new e();
    private j cgs = new j();
    private volatile boolean cgu = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> cgt = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aja() {
        return cgv;
    }

    public j ajb() {
        if (this.cgs == null) {
            this.cgs = new j();
        }
        return this.cgs;
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
        if (c.aiY().isEnable() && this.cgs != null && this.cgs.akd() && this.cgs.aka() != -1) {
            if (!this.cgs.akc()) {
                if (this.cgt == null) {
                    this.cgt = new ConcurrentLinkedQueue<>();
                }
                this.cgt.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                ajc();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void ajc() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.cgu) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.cgu = true;
        byte[] a = d.aiZ().a(this.cgs);
        if (a == null || a.length <= 0) {
            this.cgu = false;
            hq(-1);
            return;
        }
        if (this.cgs != null) {
            this.cgs.akb();
        }
        new com.baidu.swan.games.bdtls.b.c().a(a, new c.a() { // from class: com.baidu.swan.games.bdtls.e.2
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=4] */
            @Override // com.baidu.swan.games.bdtls.b.c.a
            public void b(boolean z, byte[] bArr) {
                h H;
                try {
                    if (a.DEBUG) {
                        Log.d("BDTLS", "doHandShake response");
                    }
                    if (z && bArr != null && (H = com.baidu.swan.games.bdtls.a.b.H(bArr)) != null) {
                        byte ajS = H.ajS();
                        byte[] ajW = H.ajW();
                        if (ajW != null) {
                            if (a.DEBUG) {
                                Log.d("BDTLS", "doHandShake response schemeType =" + ((int) ajS));
                            }
                            switch (ajS) {
                                case 21:
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    e.this.cgs.hw(-1);
                                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(ajW);
                                    if (parseFrom != null) {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        f.a(e.this.cgs, parseFrom);
                                        break;
                                    }
                                    break;
                                case 22:
                                    if (com.baidu.swan.games.bdtls.a.a.b(e.this.cgs, ajW) == null) {
                                        e.this.cgs.hw(-1);
                                        break;
                                    } else {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        e.this.cgs.hw(1);
                                        f.ob("serverHello");
                                        while (true) {
                                            com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.cgt.poll();
                                            if (fVar == null) {
                                                return;
                                            }
                                            e.this.d(fVar.ajO(), fVar.ajP());
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
                    e.this.cgu = false;
                }
                e.this.hq(-1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            byte[] a = d.aiZ().a(this.cgs, str);
            if (a != null) {
                if (a.DEBUG) {
                    Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                }
                bVar.eo(true);
                bVar.I(a);
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
            bVar.eo(false);
            bVar.I(str.getBytes());
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
        this.cgs.hw(-1);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.cgt.poll();
            if (poll != null) {
                e(poll.ajO(), poll.ajP());
            } else {
                return;
            }
        }
    }
}
