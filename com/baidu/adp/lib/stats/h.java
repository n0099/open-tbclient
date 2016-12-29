package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h qd;
    private HashMap<String, a> qb = new HashMap<>();
    private HashMap<String, b> qc = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h fa() {
        if (qd == null) {
            synchronized (h.class) {
                if (qd == null) {
                    qd = new h();
                }
            }
        }
        return qd;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.ao(3000);
        bVar.ap(120000);
        bVar.aq(500);
        this.qc.put("net", bVar);
        this.qc.put("op", bVar);
        this.qc.put("stat", bVar);
        this.qc.put("crash", bVar);
        this.qc.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.ao(3000);
        bVar2.ap(120000);
        bVar2.aq(1500);
        this.qc.put("file", bVar2);
        this.qc.put("db", bVar2);
        this.qc.put("img", bVar2);
        this.qc.put("voice", bVar2);
        this.qc.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.ao(3000);
        bVar3.ap(120000);
        bVar3.aq(1500);
        this.qc.put("dbg", bVar3);
    }

    public synchronized boolean ar(String str) {
        a aVar;
        boolean z;
        b bVar = this.qc.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.qb.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a(this, null);
                aVar3.F(false);
                aVar3.E(false);
                aVar3.f(currentTimeMillis);
                this.qb.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fb()) {
                z = true;
            } else {
                if (aVar.ff()) {
                    aVar.an(aVar.fd() + 1);
                    if (currentTimeMillis - aVar.fc() < bVar.fh()) {
                        if (aVar.fd() >= bVar.fi()) {
                            aVar.E(true);
                            com.baidu.adp.lib.stats.a.eI().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.F(false);
                        aVar.an(0);
                        aVar.f(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.fe() < bVar.fg()) {
                    aVar.F(true);
                    aVar.e(currentTimeMillis);
                } else {
                    aVar.f(currentTimeMillis);
                }
                z = false;
            }
        }
        return z;
    }

    private void a(a aVar) {
        Message obtainMessage = this.mHandler.obtainMessage();
        obtainMessage.what = 5;
        obtainMessage.obj = aVar;
        this.mHandler.removeMessages(5);
        this.mHandler.sendMessageDelayed(obtainMessage, 300000L);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class a {
        private long qf;
        private boolean qg;
        private int qh;
        private long qi;
        private boolean qj;

        private a() {
            this.qg = false;
            this.qh = 0;
            this.qj = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean fb() {
            return this.qj;
        }

        public void E(boolean z) {
            this.qj = z;
        }

        public long fc() {
            return this.qi;
        }

        public void e(long j) {
            this.qi = j;
        }

        public int fd() {
            return this.qh;
        }

        public void an(int i) {
            this.qh = i;
        }

        public long fe() {
            return this.qf;
        }

        public void f(long j) {
            this.qf = j;
        }

        public boolean ff() {
            return this.qg;
        }

        public void F(boolean z) {
            this.qg = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int qk;
        private int ql;
        private int qm;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int fg() {
            return this.qk;
        }

        public void ao(int i) {
            this.qk = i;
        }

        public int fh() {
            return this.ql;
        }

        public void ap(int i) {
            this.ql = i;
        }

        public int fi() {
            return this.qm;
        }

        public void aq(int i) {
            this.qm = i;
        }
    }
}
