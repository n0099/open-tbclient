package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ap.p;
import com.baidu.swan.games.bdtls.b.d;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.j;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public class e {
    private static volatile e dpr = new e();
    private j dpo = new j();
    private volatile boolean dpq = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> dpp = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aLn() {
        return dpr;
    }

    public j aLo() {
        if (this.dpo == null) {
            this.dpo = new j();
        }
        return this.dpo;
    }

    public void b(final String str, final com.baidu.swan.games.bdtls.b.b bVar) {
        p.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.bdtls.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.c(str, bVar);
            }
        }, "SessionController");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (this.dpo.aMm() != 2) {
            if (!this.dpo.aMo()) {
                if (this.dpp == null) {
                    this.dpp = new ConcurrentLinkedQueue<>();
                }
                this.dpp.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aLp();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aLp() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.dpq) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.dpq = true;
        byte[] a = d.aLm().a(this.dpo);
        if (a == null || a.length <= 0) {
            this.dpq = false;
            uG("record data error");
            return;
        }
        new com.baidu.swan.games.bdtls.b.d().a(a, new d.a() { // from class: com.baidu.swan.games.bdtls.e.2
            @Override // com.baidu.swan.games.bdtls.b.d.a
            public void b(boolean z, byte[] bArr) {
                String str;
                Exception e;
                try {
                    try {
                        if (a.DEBUG) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                    } catch (Exception e2) {
                        str = "";
                        e = e2;
                    }
                    if (z) {
                        if (bArr == null) {
                            str = "";
                        } else {
                            h X = com.baidu.swan.games.bdtls.a.b.X(bArr);
                            if (X == null) {
                                str = "";
                            } else {
                                byte aMf = X.aMf();
                                byte[] aMj = X.aMj();
                                if (aMj == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aMf));
                                    }
                                    switch (aMf) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aMj);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.dpo, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.dpq = false;
                                                    e.this.uG(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.dpo, aMj) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.dpo.kY(1);
                                                f.uH("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.dpp.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aMb(), fVar.aMc());
                                                    } else {
                                                        return;
                                                    }
                                                }
                                            } else {
                                                str = "params decode error";
                                                break;
                                            }
                                    }
                                }
                            }
                        }
                        e.this.uG(str);
                    }
                    str = "";
                    e.this.uG(str);
                } finally {
                    e.this.dpq = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        byte[] a;
        if (str == null || bVar == null) {
            a(-1, (com.baidu.swan.games.bdtls.b.b) null);
            return;
        }
        if (TextUtils.equals(bVar.getMethod(), "GET")) {
            a = d.aLm().a(this.dpo, (String) null);
        } else {
            a = d.aLm().a(this.dpo, str);
        }
        if (a != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.gC(true);
            bVar.Y(a);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.gC(false);
            bVar.Y(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.kZ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uG(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.dpo.kY(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.dpp.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aMb(), poll.aMc());
                } else {
                    com.baidu.swan.games.bdtls.b.b aMc = poll.aMc();
                    if (aMc != null) {
                        aMc.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
