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
/* loaded from: classes7.dex */
public class e {
    private static volatile e dQd = new e();
    private j dQa = new j();
    private volatile boolean dQc = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> dQb = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aSt() {
        return dQd;
    }

    public j aSu() {
        if (this.dQa == null) {
            this.dQa = new j();
        }
        return this.dQa;
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
        if (this.dQa.aTs() != 2) {
            if (!this.dQa.aTu()) {
                if (this.dQb == null) {
                    this.dQb = new ConcurrentLinkedQueue<>();
                }
                this.dQb.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aSv();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aSv() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.dQc) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.dQc = true;
        byte[] a2 = d.aSs().a(this.dQa);
        if (a2 == null || a2.length <= 0) {
            this.dQc = false;
            wn("record data error");
            return;
        }
        new com.baidu.swan.games.bdtls.b.d().a(a2, new d.a() { // from class: com.baidu.swan.games.bdtls.e.2
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
                                byte aTl = X.aTl();
                                byte[] aTp = X.aTp();
                                if (aTp == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aTl));
                                    }
                                    switch (aTl) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aTp);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.dQa, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.dQc = false;
                                                    e.this.wn(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.dQa, aTp) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.dQa.lX(1);
                                                f.wo("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.dQb.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aTh(), fVar.aTi());
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
                        e.this.wn(str);
                    }
                    str = "";
                    e.this.wn(str);
                } finally {
                    e.this.dQc = false;
                }
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        byte[] a2;
        if (str == null || bVar == null) {
            a(-1, (com.baidu.swan.games.bdtls.b.b) null);
            return;
        }
        if (TextUtils.equals(bVar.getMethod(), "GET")) {
            a2 = d.aSs().a(this.dQa, (String) null);
        } else {
            a2 = d.aSs().a(this.dQa, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.hv(true);
            bVar.Y(a2);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.hv(false);
            bVar.Y(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.lY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wn(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.dQa.lX(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.dQb.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aTh(), poll.aTi());
                } else {
                    com.baidu.swan.games.bdtls.b.b aTi = poll.aTi();
                    if (aTi != null) {
                        aTi.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
