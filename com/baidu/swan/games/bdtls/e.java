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
/* loaded from: classes10.dex */
public class e {
    private static volatile e dRL = new e();
    private j dRI = new j();
    private volatile boolean dRK = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> dRJ = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aTb() {
        return dRL;
    }

    public j aTc() {
        if (this.dRI == null) {
            this.dRI = new j();
        }
        return this.dRI;
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
        if (this.dRI.aUa() != 2) {
            if (!this.dRI.aUc()) {
                if (this.dRJ == null) {
                    this.dRJ = new ConcurrentLinkedQueue<>();
                }
                this.dRJ.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aTd();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aTd() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.dRK) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.dRK = true;
        byte[] a2 = d.aTa().a(this.dRI);
        if (a2 == null || a2.length <= 0) {
            this.dRK = false;
            ws("record data error");
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
                                byte aTT = X.aTT();
                                byte[] aTX = X.aTX();
                                if (aTX == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aTT));
                                    }
                                    switch (aTT) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aTX);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.dRI, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.dRK = false;
                                                    e.this.ws(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.dRI, aTX) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.dRI.mb(1);
                                                f.wt("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.dRJ.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aTP(), fVar.aTQ());
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
                        e.this.ws(str);
                    }
                    str = "";
                    e.this.ws(str);
                } finally {
                    e.this.dRK = false;
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
            a2 = d.aTa().a(this.dRI, (String) null);
        } else {
            a2 = d.aTa().a(this.dRI, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.hs(true);
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
            bVar.hs(false);
            bVar.Y(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.mc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void ws(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.dRI.mb(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.dRJ.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aTP(), poll.aTQ());
                } else {
                    com.baidu.swan.games.bdtls.b.b aTQ = poll.aTQ();
                    if (aTQ != null) {
                        aTQ.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
