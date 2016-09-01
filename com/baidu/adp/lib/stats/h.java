package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h qc;
    private HashMap<String, a> qa = new HashMap<>();
    private HashMap<String, b> qb = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h fa() {
        if (qc == null) {
            synchronized (h.class) {
                if (qc == null) {
                    qc = new h();
                }
            }
        }
        return qc;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.an(3000);
        bVar.ao(120000);
        bVar.ap(500);
        this.qb.put("net", bVar);
        this.qb.put("op", bVar);
        this.qb.put("stat", bVar);
        this.qb.put("crash", bVar);
        this.qb.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.an(3000);
        bVar2.ao(120000);
        bVar2.ap(1500);
        this.qb.put("file", bVar2);
        this.qb.put("db", bVar2);
        this.qb.put("img", bVar2);
        this.qb.put("voice", bVar2);
        this.qb.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.an(3000);
        bVar3.ao(120000);
        bVar3.ap(1500);
        this.qb.put("dbg", bVar3);
    }

    public synchronized boolean ar(String str) {
        a aVar;
        boolean z;
        b bVar = this.qb.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.qa.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a(this, null);
                aVar3.F(false);
                aVar3.E(false);
                aVar3.f(currentTimeMillis);
                this.qa.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.fb()) {
                z = true;
            } else {
                if (aVar.ff()) {
                    aVar.am(aVar.fd() + 1);
                    if (currentTimeMillis - aVar.fc() < bVar.fh()) {
                        if (aVar.fd() >= bVar.fi()) {
                            aVar.E(true);
                            com.baidu.adp.lib.stats.a.eI().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.F(false);
                        aVar.am(0);
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
        private long qe;
        private boolean qf;
        private int qg;
        private long qh;
        private boolean qi;

        private a() {
            this.qf = false;
            this.qg = 0;
            this.qi = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean fb() {
            return this.qi;
        }

        public void E(boolean z) {
            this.qi = z;
        }

        public long fc() {
            return this.qh;
        }

        public void e(long j) {
            this.qh = j;
        }

        public int fd() {
            return this.qg;
        }

        public void am(int i) {
            this.qg = i;
        }

        public long fe() {
            return this.qe;
        }

        public void f(long j) {
            this.qe = j;
        }

        public boolean ff() {
            return this.qf;
        }

        public void F(boolean z) {
            this.qf = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int qj;
        private int qk;
        private int ql;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int fg() {
            return this.qj;
        }

        public void an(int i) {
            this.qj = i;
        }

        public int fh() {
            return this.qk;
        }

        public void ao(int i) {
            this.qk = i;
        }

        public int fi() {
            return this.ql;
        }

        public void ap(int i) {
            this.ql = i;
        }
    }
}
