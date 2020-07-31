package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.aq.p;
import com.baidu.swan.games.bdtls.b.d;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.j;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes7.dex */
public class e {
    private static volatile e dfe = new e();
    private j dfb = new j();
    private volatile boolean dfd = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> dfc = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aCy() {
        return dfe;
    }

    public j aCz() {
        if (this.dfb == null) {
            this.dfb = new j();
        }
        return this.dfb;
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
        if (this.dfb.aDx() != 2) {
            if (!this.dfb.aDz()) {
                if (this.dfc == null) {
                    this.dfc = new ConcurrentLinkedQueue<>();
                }
                this.dfc.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aCA();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aCA() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.dfd) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.dfd = true;
        byte[] a = d.aCx().a(this.dfb);
        if (a == null || a.length <= 0) {
            this.dfd = false;
            sn("record data error");
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
                                byte aDq = W.aDq();
                                byte[] aDu = W.aDu();
                                if (aDu == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aDq));
                                    }
                                    switch (aDq) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aDu);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.dfb, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.dfd = false;
                                                    e.this.sn(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.dfb, aDu) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.dfb.iP(1);
                                                f.so("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.dfc.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aDm(), fVar.aDn());
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
                        e.this.sn(str);
                    }
                    str = "";
                    e.this.sn(str);
                } finally {
                    e.this.dfd = false;
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
            a = d.aCx().a(this.dfb, (String) null);
        } else {
            a = d.aCx().a(this.dfb, str);
        }
        if (a != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.gf(true);
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
            bVar.gf(false);
            bVar.X(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.iQ(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void sn(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.dfb.iP(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.dfc.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aDm(), poll.aDn());
                } else {
                    com.baidu.swan.games.bdtls.b.b aDn = poll.aDn();
                    if (aDn != null) {
                        aDn.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
