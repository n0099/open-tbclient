package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.n;
import com.baidu.swan.games.bdtls.b.d;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.j;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes11.dex */
public class e {
    private static volatile e cZt = new e();
    private j cZq = new j();
    private volatile boolean cZs = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> cZr = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e ayT() {
        return cZt;
    }

    public j ayU() {
        if (this.cZq == null) {
            this.cZq = new j();
        }
        return this.cZq;
    }

    public void b(final String str, final com.baidu.swan.games.bdtls.b.b bVar) {
        n.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.bdtls.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.c(str, bVar);
            }
        }, "SessionController");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (this.cZq.azS() != 2) {
            if (!this.cZq.azU()) {
                if (this.cZr == null) {
                    this.cZr = new ConcurrentLinkedQueue<>();
                }
                this.cZr.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                ayV();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void ayV() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.cZs) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.cZs = true;
        byte[] a = d.ayS().a(this.cZq);
        if (a == null || a.length <= 0) {
            this.cZs = false;
            rp("record data error");
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
                            h W = com.baidu.swan.games.bdtls.a.b.W(bArr);
                            if (W == null) {
                                str = "";
                            } else {
                                byte azL = W.azL();
                                byte[] azP = W.azP();
                                if (azP == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) azL));
                                    }
                                    switch (azL) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(azP);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.cZq, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.cZs = false;
                                                    e.this.rp(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.cZq, azP) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.cZq.iy(1);
                                                f.rq("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.cZr.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.azH(), fVar.azI());
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
                        e.this.rp(str);
                    }
                    str = "";
                    e.this.rp(str);
                } finally {
                    e.this.cZs = false;
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
            a = d.ayS().a(this.cZq, (String) null);
        } else {
            a = d.ayS().a(this.cZq, str);
        }
        if (a != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.fO(true);
            bVar.X(a);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.fO(false);
            bVar.X(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.iz(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rp(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.cZq.iy(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.cZr.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.azH(), poll.azI());
                } else {
                    com.baidu.swan.games.bdtls.b.b azI = poll.azI();
                    if (azI != null) {
                        azI.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
