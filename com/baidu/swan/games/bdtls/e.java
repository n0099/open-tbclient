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
    private static volatile e efY = new e();
    private j efV = new j();
    private volatile boolean efX = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> efW = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aXT() {
        return efY;
    }

    public j aXU() {
        if (this.efV == null) {
            this.efV = new j();
        }
        return this.efV;
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
        if (this.efV.aYS() != 2) {
            if (!this.efV.aYU()) {
                if (this.efW == null) {
                    this.efW = new ConcurrentLinkedQueue<>();
                }
                this.efW.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aXV();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aXV() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.efX) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.efX = true;
        byte[] a2 = d.aXS().a(this.efV);
        if (a2 == null || a2.length <= 0) {
            this.efX = false;
            wT("record data error");
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
                            h W = com.baidu.swan.games.bdtls.a.b.W(bArr);
                            if (W == null) {
                                str = "";
                            } else {
                                byte aYL = W.aYL();
                                byte[] aYP = W.aYP();
                                if (aYP == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aYL));
                                    }
                                    switch (aYL) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aYP);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.efV, parseFrom);
                                                    break;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.efX = false;
                                                    e.this.wT(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.efV, aYP) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.efV.mD(1);
                                                f.wU("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.efW.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aYH(), fVar.aYI());
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
                        e.this.wT(str);
                    }
                    str = "";
                    e.this.wT(str);
                } finally {
                    e.this.efX = false;
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
            a2 = d.aXS().a(this.efV, (String) null);
        } else {
            a2 = d.aXS().a(this.efV, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.ic(true);
            bVar.X(a2);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.ic(false);
            bVar.X(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.mE(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wT(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.efV.mD(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.efW.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aYH(), poll.aYI());
                } else {
                    com.baidu.swan.games.bdtls.b.b aYI = poll.aYI();
                    if (aYI != null) {
                        aYI.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
