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
    private static volatile e dLT = new e();
    private j dLQ = new j();
    private volatile boolean dLS = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> dLR = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aQB() {
        return dLT;
    }

    public j aQC() {
        if (this.dLQ == null) {
            this.dLQ = new j();
        }
        return this.dLQ;
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
        if (this.dLQ.aRA() != 2) {
            if (!this.dLQ.aRC()) {
                if (this.dLR == null) {
                    this.dLR = new ConcurrentLinkedQueue<>();
                }
                this.dLR.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aQD();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aQD() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.dLS) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.dLS = true;
        byte[] a2 = d.aQA().a(this.dLQ);
        if (a2 == null || a2.length <= 0) {
            this.dLS = false;
            we("record data error");
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
                                byte aRt = X.aRt();
                                byte[] aRx = X.aRx();
                                if (aRx == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aRt));
                                    }
                                    switch (aRt) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aRx);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.dLQ, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.dLS = false;
                                                    e.this.we(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.dLQ, aRx) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.dLQ.lR(1);
                                                f.wf("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.dLR.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aRp(), fVar.aRq());
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
                        e.this.we(str);
                    }
                    str = "";
                    e.this.we(str);
                } finally {
                    e.this.dLS = false;
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
            a2 = d.aQA().a(this.dLQ, (String) null);
        } else {
            a2 = d.aQA().a(this.dLQ, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.hj(true);
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
            bVar.hj(false);
            bVar.Y(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.lS(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void we(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.dLQ.lR(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.dLR.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aRp(), poll.aRq());
                } else {
                    com.baidu.swan.games.bdtls.b.b aRq = poll.aRq();
                    if (aRq != null) {
                        aRq.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
