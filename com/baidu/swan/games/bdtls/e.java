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
    private static volatile e dDw = new e();
    private j dDt = new j();
    private volatile boolean dDv = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> dDu = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aOH() {
        return dDw;
    }

    public j aOI() {
        if (this.dDt == null) {
            this.dDt = new j();
        }
        return this.dDt;
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
        if (this.dDt.aPG() != 2) {
            if (!this.dDt.aPI()) {
                if (this.dDu == null) {
                    this.dDu = new ConcurrentLinkedQueue<>();
                }
                this.dDu.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aOJ();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aOJ() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.dDv) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.dDv = true;
        byte[] a2 = d.aOG().a(this.dDt);
        if (a2 == null || a2.length <= 0) {
            this.dDv = false;
            vL("record data error");
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
                                byte aPz = X.aPz();
                                byte[] aPD = X.aPD();
                                if (aPD == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aPz));
                                    }
                                    switch (aPz) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aPD);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.dDt, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.dDv = false;
                                                    e.this.vL(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.dDt, aPD) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.dDt.lG(1);
                                                f.vM("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.dDu.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aPv(), fVar.aPw());
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
                        e.this.vL(str);
                    }
                    str = "";
                    e.this.vL(str);
                } finally {
                    e.this.dDv = false;
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
            a2 = d.aOG().a(this.dDt, (String) null);
        } else {
            a2 = d.aOG().a(this.dDt, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.gW(true);
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
            bVar.gW(false);
            bVar.Y(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.lH(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vL(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.dDt.lG(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.dDu.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aPv(), poll.aPw());
                } else {
                    com.baidu.swan.games.bdtls.b.b aPw = poll.aPw();
                    if (aPw != null) {
                        aPw.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
