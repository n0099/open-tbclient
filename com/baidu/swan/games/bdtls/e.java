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
    private static volatile e eeU = new e();
    private j eeR = new j();
    private volatile boolean eeT = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> eeS = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e aUo() {
        return eeU;
    }

    public j aUp() {
        if (this.eeR == null) {
            this.eeR = new j();
        }
        return this.eeR;
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
        if (this.eeR.aVn() != 2) {
            if (!this.eeR.aVp()) {
                if (this.eeS == null) {
                    this.eeS = new ConcurrentLinkedQueue<>();
                }
                this.eeS.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                aUq();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void aUq() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.eeT) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.eeT = true;
        byte[] a2 = d.aUn().a(this.eeR);
        if (a2 == null || a2.length <= 0) {
            this.eeT = false;
            wi("record data error");
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
                                byte aVg = W.aVg();
                                byte[] aVk = W.aVk();
                                if (aVk == null) {
                                    str = "";
                                } else {
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake response schemeType =" + ((int) aVg));
                                    }
                                    switch (aVg) {
                                        case 21:
                                            if (a.DEBUG) {
                                                Log.d("BDTLS", "doHandShake alert");
                                            }
                                            Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(aVk);
                                            if (parseFrom != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "bdtls ubc handshake alert");
                                                }
                                                str = parseFrom.getDescription() != null ? new String(parseFrom.getDescription().toByteArray()) : "";
                                                try {
                                                    f.a(e.this.eeR, parseFrom);
                                                    break;
                                                } catch (Exception e2) {
                                                    e = e2;
                                                    if (a.DEBUG) {
                                                        e.printStackTrace();
                                                        Log.d("BDTLS", "exception=" + e.getMessage());
                                                    }
                                                    e.this.eeT = false;
                                                    e.this.wi(str);
                                                }
                                            }
                                            break;
                                        case 22:
                                            if (com.baidu.swan.games.bdtls.a.a.b(e.this.eeR, aVk) != null) {
                                                if (a.DEBUG) {
                                                    Log.d("BDTLS", "doHandShake serverHello");
                                                }
                                                e.this.eeR.lb(1);
                                                f.wj("serverHello");
                                                while (true) {
                                                    com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.eeS.poll();
                                                    if (fVar != null) {
                                                        e.this.d(fVar.aVc(), fVar.aVd());
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
                        e.this.wi(str);
                    }
                    str = "";
                    e.this.wi(str);
                } finally {
                    e.this.eeT = false;
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
            a2 = d.aUn().a(this.eeR, (String) null);
        } else {
            a2 = d.aUn().a(this.eeR, str);
        }
        if (a2 != null) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doBdtlsApplicationDataRequest");
            }
            bVar.ia(true);
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
            bVar.ia(false);
            bVar.X(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.lc(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void wi(String str) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        int i = TextUtils.equals(str, "down grade") ? 2 : -1;
        this.eeR.lb(i);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.eeS.poll();
            if (poll != null) {
                if (i == 2) {
                    e(poll.aVc(), poll.aVd());
                } else {
                    com.baidu.swan.games.bdtls.b.b aVd = poll.aVd();
                    if (aVd != null) {
                        aVd.b(new IOException(TextUtils.isEmpty(str) ? "connect fail" : str));
                    }
                }
            } else {
                return;
            }
        }
    }
}
