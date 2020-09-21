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
/* loaded from: classes3.dex */
public class e {
    private static volatile e drt = new e();
    private j drp = new j();
    private volatile boolean drr = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> drq = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aLY() {
        return drt;
    }

    public j aLZ() {
        if (this.drp == null) {
            this.drp = new j();
        }
        return this.drp;
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
        if (this.drp.aMX() != 2) {
            if (!this.drp.aMZ()) {
                if (this.drq == null) {
                    this.drq = new ConcurrentLinkedQueue<>();
                }
                this.drq.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aMa();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aMa() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.drr) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.drr = true;
        byte[] a = d.aLX().a(this.drp);
        if (a == null || a.length <= 0) {
            this.drr = false;
            uZ("record data error");
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
                                byte aMQ = X.aMQ();
                                byte[] aMU = X.aMU();
                                if (aMU == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aMQ));
                                    }
                                    switch (aMQ) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aMU);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.drp, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.drr = false;
                                                    e.this.uZ(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.drp, aMU) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.drp.lj(1);
                                                f.va("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.drq.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aMM(), fVar.aMN());
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
                        e.this.uZ(str);
                    }
                    str = "";
                    e.this.uZ(str);
                } finally {
                    e.this.drr = false;
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
            a = d.aLX().a(this.drp, (String) null);
        } else {
            a = d.aLX().a(this.drp, str);
        }
        if (a != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.gA(true);
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
            bVar.gA(false);
            bVar.Y(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.lk(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void uZ(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.drp.lj(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.drq.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aMM(), poll.aMN());
                } else {
                    com.baidu.swan.games.bdtls.b.b aMN = poll.aMN();
                    if (aMN != null) {
                        aMN.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
