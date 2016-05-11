package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h ne;
    private HashMap<String, a> nc = new HashMap<>();
    private HashMap<String, b> nd = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h ef() {
        if (ne == null) {
            synchronized (h.class) {
                if (ne == null) {
                    ne = new h();
                }
            }
        }
        return ne;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.X(3000);
        bVar.Y(120000);
        bVar.Z(500);
        this.nd.put("net", bVar);
        this.nd.put("op", bVar);
        this.nd.put("stat", bVar);
        this.nd.put("crash", bVar);
        this.nd.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.X(3000);
        bVar2.Y(120000);
        bVar2.Z(1500);
        this.nd.put("file", bVar2);
        this.nd.put("db", bVar2);
        this.nd.put("img", bVar2);
        this.nd.put("voice", bVar2);
        this.nd.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.X(3000);
        bVar3.Y(120000);
        bVar3.Z(1500);
        this.nd.put("dbg", bVar3);
    }

    public boolean ao(String str) {
        a aVar;
        b bVar = this.nd.get(str);
        if (bVar == null) {
            return false;
        }
        a aVar2 = this.nc.get(str);
        long currentTimeMillis = System.currentTimeMillis();
        if (aVar2 == null) {
            a aVar3 = new a(this, null);
            aVar3.B(false);
            aVar3.A(false);
            aVar3.e(currentTimeMillis);
            this.nc.put(str, aVar3);
            aVar = aVar3;
        } else {
            aVar = aVar2;
        }
        if (aVar.eg()) {
            return true;
        }
        if (aVar.ek()) {
            aVar.W(aVar.ei() + 1);
            if (currentTimeMillis - aVar.eh() < bVar.em()) {
                if (aVar.ei() >= bVar.en()) {
                    aVar.A(true);
                    com.baidu.adp.lib.stats.a.dN().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                    a(aVar);
                    return true;
                }
                return false;
            }
            aVar.B(false);
            aVar.W(0);
            aVar.e(currentTimeMillis);
            return false;
        } else if (currentTimeMillis - aVar.ej() < bVar.el()) {
            aVar.B(true);
            aVar.d(currentTimeMillis);
            return false;
        } else {
            aVar.e(currentTimeMillis);
            return false;
        }
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
        private long ng;
        private boolean nh;
        private int ni;
        private long nj;
        private boolean nk;

        private a() {
            this.nh = false;
            this.ni = 0;
            this.nk = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean eg() {
            return this.nk;
        }

        public void A(boolean z) {
            this.nk = z;
        }

        public long eh() {
            return this.nj;
        }

        public void d(long j) {
            this.nj = j;
        }

        public int ei() {
            return this.ni;
        }

        public void W(int i) {
            this.ni = i;
        }

        public long ej() {
            return this.ng;
        }

        public void e(long j) {
            this.ng = j;
        }

        public boolean ek() {
            return this.nh;
        }

        public void B(boolean z) {
            this.nh = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int nl;
        private int nm;
        private int nn;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int el() {
            return this.nl;
        }

        public void X(int i) {
            this.nl = i;
        }

        public int em() {
            return this.nm;
        }

        public void Y(int i) {
            this.nm = i;
        }

        public int en() {
            return this.nn;
        }

        public void Z(int i) {
            this.nn = i;
        }
    }
}
