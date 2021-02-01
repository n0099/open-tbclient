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
/* loaded from: classes9.dex */
public class e {
    private static volatile e edt = new e();
    private j edq = new j();
    private volatile boolean eds = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> edr = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aUl() {
        return edt;
    }

    public j aUm() {
        if (this.edq == null) {
            this.edq = new j();
        }
        return this.edq;
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
        if (this.edq.aVk() != 2) {
            if (!this.edq.aVm()) {
                if (this.edr == null) {
                    this.edr = new ConcurrentLinkedQueue<>();
                }
                this.edr.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aUn();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aUn() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.eds) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.eds = true;
        byte[] a2 = d.aUk().a(this.edq);
        if (a2 == null || a2.length <= 0) {
            this.eds = false;
            wb("record data error");
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
                            h U = com.baidu.swan.games.bdtls.a.b.U(bArr);
                            if (U == null) {
                                str = "";
                            } else {
                                byte aVd = U.aVd();
                                byte[] aVh = U.aVh();
                                if (aVh == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aVd));
                                    }
                                    switch (aVd) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aVh);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.edq, parseFrom);
                                                    break;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.eds = false;
                                                    e.this.wb(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.edq, aVh) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.edq.la(1);
                                                f.wc("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.edr.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aUZ(), fVar.aVa());
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
                        e.this.wb(str);
                    }
                    str = "";
                    e.this.wb(str);
                } finally {
                    e.this.eds = false;
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
            a2 = d.aUk().a(this.edq, (String) null);
        } else {
            a2 = d.aUk().a(this.edq, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.ia(true);
            bVar.V(a2);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.ia(false);
            bVar.V(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.lb(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wb(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.edq.la(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.edr.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aUZ(), poll.aVa());
                } else {
                    com.baidu.swan.games.bdtls.b.b aVa = poll.aVa();
                    if (aVa != null) {
                        aVa.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
