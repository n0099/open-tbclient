package com.baidu.adp.lib.stats;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.HashMap;
/* loaded from: classes.dex */
public class h {
    private static h nH;
    private HashMap<String, a> nF = new HashMap<>();
    private HashMap<String, b> nG = new HashMap<>();
    private Handler mHandler = new i(this, Looper.getMainLooper());

    public static h ef() {
        if (nH == null) {
            synchronized (h.class) {
                if (nH == null) {
                    nH = new h();
                }
            }
        }
        return nH;
    }

    public h() {
        b bVar = new b(this, null);
        bVar.aa(3000);
        bVar.ab(120000);
        bVar.ac(500);
        this.nG.put("net", bVar);
        this.nG.put("op", bVar);
        this.nG.put("stat", bVar);
        this.nG.put("crash", bVar);
        this.nG.put("pfmonitor", bVar);
        b bVar2 = new b(this, null);
        bVar2.aa(3000);
        bVar2.ab(120000);
        bVar2.ac(1500);
        this.nG.put("file", bVar2);
        this.nG.put("db", bVar2);
        this.nG.put("img", bVar2);
        this.nG.put("voice", bVar2);
        this.nG.put("error", bVar2);
        b bVar3 = new b(this, null);
        bVar3.aa(3000);
        bVar3.ab(120000);
        bVar3.ac(1500);
        this.nG.put("dbg", bVar3);
    }

    public synchronized boolean aq(String str) {
        a aVar;
        boolean z;
        b bVar = this.nG.get(str);
        if (bVar == null) {
            z = false;
        } else {
            a aVar2 = this.nF.get(str);
            long currentTimeMillis = System.currentTimeMillis();
            if (aVar2 == null) {
                a aVar3 = new a(this, null);
                aVar3.D(false);
                aVar3.C(false);
                aVar3.f(currentTimeMillis);
                this.nF.put(str, aVar3);
                aVar = aVar3;
            } else {
                aVar = aVar2;
            }
            if (aVar.eg()) {
                z = true;
            } else {
                if (aVar.ek()) {
                    aVar.Z(aVar.ei() + 1);
                    if (currentTimeMillis - aVar.eh() < bVar.em()) {
                        if (aVar.ei() >= bVar.en()) {
                            aVar.C(true);
                            com.baidu.adp.lib.stats.a.dN().a(false, "d", "logfast", (String) null, 0L, 99999, str, new Object[0]);
                            a(aVar);
                            z = true;
                        }
                    } else {
                        aVar.D(false);
                        aVar.Z(0);
                        aVar.f(currentTimeMillis);
                    }
                } else if (currentTimeMillis - aVar.ej() < bVar.el()) {
                    aVar.D(true);
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
        private long nJ;
        private boolean nK;
        private int nL;
        private long nM;
        private boolean nN;

        private a() {
            this.nK = false;
            this.nL = 0;
            this.nN = false;
        }

        /* synthetic */ a(h hVar, a aVar) {
            this();
        }

        public boolean eg() {
            return this.nN;
        }

        public void C(boolean z) {
            this.nN = z;
        }

        public long eh() {
            return this.nM;
        }

        public void e(long j) {
            this.nM = j;
        }

        public int ei() {
            return this.nL;
        }

        public void Z(int i) {
            this.nL = i;
        }

        public long ej() {
            return this.nJ;
        }

        public void f(long j) {
            this.nJ = j;
        }

        public boolean ek() {
            return this.nK;
        }

        public void D(boolean z) {
            this.nK = z;
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* loaded from: classes.dex */
    public class b {
        private int nO;
        private int nP;
        private int nQ;

        private b() {
        }

        /* synthetic */ b(h hVar, b bVar) {
            this();
        }

        public int el() {
            return this.nO;
        }

        public void aa(int i) {
            this.nO = i;
        }

        public int em() {
            return this.nP;
        }

        public void ab(int i) {
            this.nP = i;
        }

        public int en() {
            return this.nQ;
        }

        public void ac(int i) {
            this.nQ = i;
        }
    }
}
