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
/* loaded from: classes25.dex */
public class e {
    private static volatile e dXb = new e();
    private j dWY = new j();
    private volatile boolean dXa = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> dWZ = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aVy() {
        return dXb;
    }

    public j aVz() {
        if (this.dWY == null) {
            this.dWY = new j();
        }
        return this.dWY;
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
        if (this.dWY.aWx() != 2) {
            if (!this.dWY.aWz()) {
                if (this.dWZ == null) {
                    this.dWZ = new ConcurrentLinkedQueue<>();
                }
                this.dWZ.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aVA();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aVA() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.dXa) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.dXa = true;
        byte[] a2 = d.aVx().a(this.dWY);
        if (a2 == null || a2.length <= 0) {
            this.dXa = false;
            wU("record data error");
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
                            h Z = com.baidu.swan.games.bdtls.a.b.Z(bArr);
                            if (Z == null) {
                                str = "";
                            } else {
                                byte aWq = Z.aWq();
                                byte[] aWu = Z.aWu();
                                if (aWu == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aWq));
                                    }
                                    switch (aWq) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aWu);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.dWY, parseFrom);
                                                    break;
                                                } catch (Exception e3) {
                                                    e = e3;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.dXa = false;
                                                    e.this.wU(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.dWY, aWu) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.dWY.mv(1);
                                                f.wV("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.dWZ.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aWm(), fVar.aWn());
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
                        e.this.wU(str);
                    }
                    str = "";
                    e.this.wU(str);
                } finally {
                    e.this.dXa = false;
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
            a2 = d.aVx().a(this.dWY, (String) null);
        } else {
            a2 = d.aVx().a(this.dWY, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.hK(true);
            bVar.aa(a2);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.hK(false);
            bVar.aa(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.mw(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wU(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.dWY.mv(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.dWZ.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aWm(), poll.aWn());
                } else {
                    com.baidu.swan.games.bdtls.b.b aWn = poll.aWn();
                    if (aWn != null) {
                        aWn.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
