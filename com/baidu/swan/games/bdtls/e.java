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
    private static volatile e cUJ = new e();
    private j cUG = new j();
    private volatile boolean cUI = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> cUH = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e axN() {
        return cUJ;
    }

    public j axO() {
        if (this.cUG == null) {
            this.cUG = new j();
        }
        return this.cUG;
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
        if (this.cUG.ayM() != 2) {
            if (!this.cUG.ayO()) {
                if (this.cUH == null) {
                    this.cUH = new ConcurrentLinkedQueue<>();
                }
                this.cUH.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                axP();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void axP() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.cUI) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.cUI = true;
        byte[] a = d.axM().a(this.cUG);
        if (a == null || a.length <= 0) {
            this.cUI = false;
            rh("record data error");
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
                            h U = com.baidu.swan.games.bdtls.a.b.U(bArr);
                            if (U == null) {
                                str = "";
                            } else {
                                byte ayF = U.ayF();
                                byte[] ayJ = U.ayJ();
                                if (ayJ == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) ayF));
                                    }
                                    switch (ayF) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(ayJ);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.cUG, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.cUI = false;
                                                    e.this.rh(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.cUG, ayJ) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.cUG.in(1);
                                                f.ri("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.cUH.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.ayB(), fVar.ayC());
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
                        e.this.rh(str);
                    }
                    str = "";
                    e.this.rh(str);
                } finally {
                    e.this.cUI = false;
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
            a = d.axM().a(this.cUG, (String) null);
        } else {
            a = d.axM().a(this.cUG, str);
        }
        if (a != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.fJ(true);
            bVar.V(a);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.fJ(false);
            bVar.V(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.io(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void rh(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.cUG.in(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.cUH.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.ayB(), poll.ayC());
                } else {
                    com.baidu.swan.games.bdtls.b.b ayC = poll.ayC();
                    if (ayC != null) {
                        ayC.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
