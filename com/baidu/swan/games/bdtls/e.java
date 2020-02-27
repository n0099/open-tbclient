package com.baidu.swan.games.bdtls;

import android.text.TextUtils;
import android.util.Log;
import com.baidu.swan.apps.as.m;
import com.baidu.swan.games.bdtls.b.c;
import com.baidu.swan.games.bdtls.model.Bdtls;
import com.baidu.swan.games.bdtls.model.h;
import com.baidu.swan.games.bdtls.model.j;
import java.util.concurrent.ConcurrentLinkedQueue;
/* loaded from: classes11.dex */
public class e {
    private static volatile e ckM = new e();
    private j ckJ = new j();
    private volatile boolean ckL = false;
    private ConcurrentLinkedQueue<com.baidu.swan.games.bdtls.model.f> ckK = new ConcurrentLinkedQueue<>();

    private e() {
    }

    public static e alH() {
        return ckM;
    }

    public j alI() {
        if (this.ckJ == null) {
            this.ckJ = new j();
        }
        return this.ckJ;
    }

    public void b(final String str, final com.baidu.swan.games.bdtls.b.b bVar) {
        m.postOnSerial(new Runnable() { // from class: com.baidu.swan.games.bdtls.e.1
            @Override // java.lang.Runnable
            public void run() {
                e.this.c(str, bVar);
            }
        }, "SessionController");
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void c(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (c.alF().isEnable() && this.ckJ != null && this.ckJ.amK() && this.ckJ.amH() != -1) {
            if (!this.ckJ.amJ()) {
                if (this.ckK == null) {
                    this.ckK = new ConcurrentLinkedQueue<>();
                }
                this.ckK.offer(new com.baidu.swan.games.bdtls.model.f(str, bVar));
                alJ();
                return;
            }
            d(str, bVar);
            return;
        }
        e(str, bVar);
    }

    public void alJ() {
        if (a.DEBUG) {
            Log.d("BDTLS", "doHandShake");
        }
        if (this.ckL) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doHandShake isHandshakeRunning");
                return;
            }
            return;
        }
        this.ckL = true;
        byte[] a = d.alG().a(this.ckJ);
        if (a == null || a.length <= 0) {
            this.ckL = false;
            hH(-1);
            return;
        }
        if (this.ckJ != null) {
            this.ckJ.amI();
        }
        new com.baidu.swan.games.bdtls.b.c().a(a, new c.a() { // from class: com.baidu.swan.games.bdtls.e.2
            /* JADX DEBUG: Don't trust debug lines info. Repeating lines: [225=4] */
            @Override // com.baidu.swan.games.bdtls.b.c.a
            public void b(boolean z, byte[] bArr) {
                h L;
                try {
                    if (a.DEBUG) {
                        Log.d("BDTLS", "doHandShake response");
                    }
                    if (z && bArr != null && (L = com.baidu.swan.games.bdtls.a.b.L(bArr)) != null) {
                        byte amz = L.amz();
                        byte[] amD = L.amD();
                        if (amD != null) {
                            if (a.DEBUG) {
                                Log.d("BDTLS", "doHandShake response schemeType =" + ((int) amz));
                            }
                            switch (amz) {
                                case 21:
                                    if (a.DEBUG) {
                                        Log.d("BDTLS", "doHandShake alert");
                                    }
                                    e.this.ckJ.hN(-1);
                                    Bdtls.Alert parseFrom = Bdtls.Alert.parseFrom(amD);
                                    if (parseFrom != null) {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "bdtls ubc handshake alert");
                                        }
                                        f.a(e.this.ckJ, parseFrom);
                                        break;
                                    }
                                    break;
                                case 22:
                                    if (com.baidu.swan.games.bdtls.a.a.b(e.this.ckJ, amD) == null) {
                                        e.this.ckJ.hN(-1);
                                        break;
                                    } else {
                                        if (a.DEBUG) {
                                            Log.d("BDTLS", "doHandShake serverHello");
                                        }
                                        e.this.ckJ.hN(1);
                                        f.ov("serverHello");
                                        while (true) {
                                            com.baidu.swan.games.bdtls.model.f fVar = (com.baidu.swan.games.bdtls.model.f) e.this.ckK.poll();
                                            if (fVar == null) {
                                                return;
                                            }
                                            e.this.d(fVar.amv(), fVar.amw());
                                        }
                                    }
                            }
                        }
                    }
                } catch (Exception e) {
                    if (a.DEBUG) {
                        e.printStackTrace();
                        Log.d("BDTLS", "exception=" + e.getMessage());
                    }
                } finally {
                    e.this.ckL = false;
                }
                e.this.hH(-1);
            }
        });
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void d(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && str != null) {
            byte[] a = d.alG().a(this.ckJ, str);
            if (a != null) {
                if (a.DEBUG) {
                    Log.d("BDTLS", "doBdtlsApplicationDataRequest");
                }
                bVar.eA(true);
                bVar.M(a);
                return;
            }
            e(str, bVar);
            return;
        }
        a(-1, bVar);
    }

    private void e(String str, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null && !TextUtils.isEmpty(str)) {
            if (a.DEBUG) {
                Log.d("BDTLS", "doNormalApplicationDataRequest");
            }
            bVar.eA(false);
            bVar.M(str.getBytes());
            return;
        }
        a(-1, bVar);
    }

    private void a(int i, com.baidu.swan.games.bdtls.b.b bVar) {
        if (bVar != null) {
            bVar.hO(i);
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public void hH(int i) {
        if (a.DEBUG) {
            Log.d("BDTLS", "onHandshakeError");
        }
        this.ckJ.hN(-1);
        while (true) {
            com.baidu.swan.games.bdtls.model.f poll = this.ckK.poll();
            if (poll != null) {
                e(poll.amv(), poll.amw());
            } else {
                return;
            }
        }
    }
}
