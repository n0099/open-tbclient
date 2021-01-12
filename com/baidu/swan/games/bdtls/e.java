package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.ao.p;
import com.baidu.swan.games.bdtls.b.d;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.j;
import java.io.IOException;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes8.dex */
public class e {
    private static volatile e ebm = new e();
    private j ebj = new j();
    private volatile boolean ebl = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> ebk = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aTZ() {
        return ebm;
    }

    public j aUa() {
        if (this.ebj == null) {
            this.ebj = new j();
        }
        return this.ebj;
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
        if (this.ebj.aUY() != 2) {
            if (!this.ebj.aVa()) {
                if (this.ebk == null) {
                    this.ebk = new ConcurrentLinkedQueue<>();
                }
                this.ebk.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aUb();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aUb() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.ebl) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.ebl = true;
        byte[] a2 = d.aTY().a(this.ebj);
        if (a2 == null || a2.length <= 0) {
            this.ebl = false;
            vI("record data error");
            return;
        }
        new com.baidu.swan.games.bdtls.b.d().a(a2, new d.a() { // from class: com.baidu.swan.games.bdtls.e.2
            @Override // com.baidu.swan.games.bdtls.b.d.a
            public void b(boolean z, byte[] bArr) {
                String str;
                try {
                    try {
                        if (a.DEBUG) {
                            Log.d("BDTLS", "doHandShake response");
                        }
                    } catch (Exception e) {
                        e = e;
                        str = "";
                    }
                    if (z) {
                        if (bArr == null) {
                            str = "";
                        } else {
                            h V = com.baidu.swan.games.bdtls.a.b.V(bArr);
                            if (V == null) {
                                str = "";
                            } else {
                                byte aUR = V.aUR();
                                byte[] aUV = V.aUV();
                                if (aUV == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aUR));
                                    }
                                    switch (aUR) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aUV);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.ebj, parseFrom);
                                                    break;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.ebl = false;
                                                    e.this.vI(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.ebj, aUV) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.ebj.kX(1);
                                                f.vJ("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.ebk.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aUN(), fVar.aUO());
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
                        e.this.vI(str);
                    }
                    str = "";
                    e.this.vI(str);
                } finally {
                    e.this.ebl = false;
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
            a2 = d.aTY().a(this.ebj, (String) null);
        } else {
            a2 = d.aTY().a(this.ebj, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.hY(true);
            bVar.W(a2);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.hY(false);
            bVar.W(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.kY(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void vI(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.ebj.kX(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.ebk.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aUN(), poll.aUO());
                } else {
                    com.baidu.swan.games.bdtls.b.b aUO = poll.aUO();
                    if (aUO != null) {
                        aUO.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
